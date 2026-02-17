package shopGui;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFrame;

import cargos.CLiterature;
import exceptions.DateException;
import exceptions.FileWithListException;
import exceptions.LiteratureFactoryException;
import exceptions.MoneySafeException;
import exceptions.WarehouseException;
import factories.CInsertStringPopupFactory;
import factories.CLiteratureFactory;

import guiPopups.CErrorPopup;
import guiPopups.CInfoPopup;
import guiPopups.CWarningPopup;

import myUtils.NSFileUtils;
import shopUtils.CFileWithList;
import shopUtils.CPosition;
import shopUtils.NSShopGlobals;
import warehouse.CWarehouse;
import shopUtils.CMoneySafe;


public class CDatabase
{
	public CDatabase(JFrame argPParent)
	{
		this.databaseFilePath = Paths.get("")
				  .toAbsolutePath()
				  .resolve(NSShopGlobals.databaseDirectoryName)
				  .resolve(NSShopGlobals.databaseFileName);
		
		this.moneySafeFilePath = Paths.get("")
				  .toAbsolutePath()
				  .resolve(NSShopGlobals.databaseDirectoryName)
				  .resolve(NSShopGlobals.moneySafeFileName);
		
		this.pParent = argPParent;
		this.insStrPopupFac = new CInsertStringPopupFactory(this.pParent);
		
		this.stock = new CWarehouse();
		this.stockView = new CWarehouse();
		
		this.shopMoneySafe = new CMoneySafe();
	}
	
	//---------
	// Getters:
	public int getStockSize()
	{
		return this.stock.getSize();
	}
	
	public int getStockViewSize()
	{
		return this.stockView.getSize();
	}
	
	public String[] getLabelsArrayFromStock()
	{
		return this.stock.getLabelsArray();
	}
	
	public Object[][] getDataForTableFromStockView()
	{
		return this.stockView.getDataForTable();
	}
	
	public JFrame getPParent()
	{
		return this.pParent;
	}
	
	
	public String getDetailedViewStr()
	{
		return this.stockView.toString();
	}
	
	public CInsertStringPopupFactory getInsStrPopupFac()
	{
		return this.insStrPopupFac;
	}
	
	public String getMoneyStatus()
	{
		return this.shopMoneySafe.toString();
	}
	
	//-----------------
	// Boolean getters:
	public boolean isStockEmpty()
	{
		return this.stock.isEmpty();
	}
	
	public boolean isStockViewEmpty()
	{
		return this.stockView.isEmpty();
	}
	
	//---------
	// Setters:
	public void setStockViewToSimpleView()
	{
		this.stockView = this.stockView.getSimpleView();
	}
	
	//-------
	// Utils:
	public void refreshStockView()
	{
		this.stockView = new CWarehouse(this.stock);
	}
	
	public void reverseStockView()
	{
		this.stockView.reverse();
	}
	
	// Load and save:
	public void load()
	{
		this.loadStockDatabase();
		this.loadMoneySafe();
	}
	
	public void save()
	{
		this.saveMoneySafe();
		this.saveStockDatabase();
	}
	
	// acceptance of goods
	public void acceptanceOfGoods(Path argPath)
	{
		if(NSFileUtils.checkThatFileExist(argPath) == false)
			return;
		
		try
		{
			this.stock.loadFromFile(argPath);
			this.refreshStockView();
				
			new CInfoPopup(pParent, "The delivery has been successfully accepted!");
		}
		catch(IOException ioe)
		{		
			new CErrorPopup
			(
				pParent,
				"An error occurred while loading the file: " + ioe.getMessage()
			);
		}
		catch(WarehouseException we)
		{		
			new CErrorPopup
			(
				pParent,
				"The specified file contains incorrect data: " + we.getMessage()
			);
		}
		
	}
	
	// sell multiple products form list
	public void sellProductsFromList(Path argPath)
	{
		if(NSFileUtils.checkThatFileExist(argPath) == false)
			return;
		
		try
		{
			CFileWithList lFile = new CFileWithList(argPath, CFileWithList.ENItemType.IDENTIFIER);
			List<CPosition> positionsList = lFile.getListOfPositions();
			
			for(CPosition position : positionsList)
			{	
				try
				{
					this.sellSingleProductUnsafe(position.getStr(), position.getHowMuch(), false);
				}
				catch(WarehouseException we)
				{	
					new CInfoPopup
					(
						pParent, 
						WarehouseException.getMessageForSellProductsFromList( position.getStr() )
					);
					
				}
				catch(MoneySafeException mse)
				{		
					new CErrorPopup
					(
						pParent,
						mse.getMessage()
					);
				}
			}
			
			new CInfoPopup(this.pParent, "Transaction completed successfully.");
		}
		catch(IOException ioe)
		{
			new CErrorPopup
			(
				pParent,
				"An error occurred while loading the file: " + ioe.getMessage()
			);
		}
		catch(FileWithListException iae)
		{
			new CErrorPopup
			(
				pParent,
				iae.getMessage()
			);
		}
		
	}
	
	// sell single product
	public void sellSingleProduct(String str, int howMuch)
	{
		this.sellSingleProduct(str, howMuch, true);
	}
	
	public void sellSingleProduct(String str, int howMuch, boolean refreshWindow)
	{
		try
		{
			this.sellSingleProductUnsafe(str, howMuch, refreshWindow);
		}
		catch(WarehouseException | MoneySafeException e)
		{
			new CInfoPopup(pParent, e.getMessage());
		}
	}
	
	public void sellSingleProductUnsafe(
			                            String str, 
			                            int howMuch, 
			                            boolean refreshWindow
			                           )
			throws WarehouseException, MoneySafeException
	{
		this.stock.subItem(str, howMuch);
		
		// GetItemByIdentifier szuka pierwszego przedmiotu o takim identyfikatorze 
		// i nie zwraca uwagi na ilosc.
		//
		// natomiast
		//
		// GetAvailableItemByIdentifier szuka pierwszego przedmiotu o takim identyfikatorze 
		// i sprawdza ilosc tego przedmiotu o tym identyfikatorze i na podstawie tego podejmuje
		// decyzje czy zwrocic obiekt.
		
		long bill = howMuch * (long) this.stock.getItemByIdentifier(str).getPrice();
	
		this.refreshStockView();
		
		this.shopMoneySafe.depositMoney(bill);
		
		if(refreshWindow)
		{
			new CInfoPopup(pParent, "Transaction completed successfully.");
		}
	}
	

	// remove single row
	public void removeSingleRow(String str)
	{
		try
		{
			this.stock.removeSingleRowWithIdentifier(str);
			this.refreshStockView();
			
			new CInfoPopup(pParent, "Row deleted successfully.");
		}
		catch(WarehouseException e)
		{		
			new CInfoPopup(pParent, e.getMessage());
		}
	}
	
	// remove products with zero stock
	public void removeProductsWithZeroStock()
	{
		this.stock.removeItemsWithZeroAmount();
		this.refreshStockView();
	}
	
	// add single product
	public void addSingleProduct(String str)
	{
		try
		{
			CLiterature item = new CLiteratureFactory(str).createObj();
			
			this.stock.addItem(item);
			this.refreshStockView();
			new CInfoPopup(pParent, "The product has been added successfully!");
		}
		catch(LiteratureFactoryException e)
		{
			new CInfoPopup
			(
				pParent, 
				"The product should be entered as a string of information" +
				"separated by semicolons..."
			);
		
		}
	}
	
	// sorting
    public void sortBySth(ENAllSortingTypes field)
    {
    	
		switch(field)
		{
			case ENAllSortingTypes.DEFAULT       	-> this.stockView.sort();
			case ENAllSortingTypes.TITLE         	-> this.stockView.sortByTitle();
			case ENAllSortingTypes.AUTHOR        	-> this.stockView.sortByAuthor();
			case ENAllSortingTypes.NUMBEROFPAGES 	-> this.stockView.sortByNumberOfPages();
			case ENAllSortingTypes.HEIGHT 			-> this.stockView.sortByHeight();
			case ENAllSortingTypes.WIDTH 			-> this.stockView.sortByWidth();
			case ENAllSortingTypes.ISBN 			-> this.stockView.sortByIsbn();
			case ENAllSortingTypes.CATEGORY 		-> this.stockView.sortByCategory();
			case ENAllSortingTypes.PRODUCER 		-> this.stockView.sortByProducer();
			case ENAllSortingTypes.MODEL 			-> this.stockView.sortByModel();
			case ENAllSortingTypes.PRODUCTIONDATE 	-> this.stockView.sortByProductionDate();
			case ENAllSortingTypes.IDENTIFIER 		-> this.stockView.sortByIdentifier();
			case ENAllSortingTypes.DATEOFACCEPTANCE -> this.stockView.sortByDateOfAcceptance();
			case ENAllSortingTypes.AMOUNT 			-> this.stockView.sortByAmount();
			case ENAllSortingTypes.PRICE 			-> this.stockView.sortByPrice();
			case ENAllSortingTypes.TYPE 			-> this.stockView.sortByObjType();
		}
    }
   
  	public enum ENAllSortingTypes
  	{
  		DEFAULT,
    	TITLE,
    	AUTHOR,
    	NUMBEROFPAGES,
    	HEIGHT,
    	WIDTH,
    	ISBN,
    	CATEGORY,
    	PRODUCER,
    	MODEL,
    	PRODUCTIONDATE,
    	IDENTIFIER,
    	DATEOFACCEPTANCE,
    	AMOUNT,
    	PRICE,
    	TYPE
  	}
  	
  	// filters:
  	
    public enum ENTextField
    {
    	TITLE,
    	AUTHOR,
    	ISBN,
    	CATEGORY,
    	PRODUCER,
    	MODEL,
    	IDENTIFIER,
    	TYPE
    }
    
    public enum ENIntField
    {
    	NUMBEROFPAGES,
    	HEIGHT,
    	WIDTH,
    	AMOUNT,
    	PRICE
    }
    
    public enum ENIntRangeField
    {
    	AMOUNT,
    	PRICE
    }
    
    public enum ENDateField
    {
    	PRODUCTIONDATE,
    	DATEOFACCEPTANCE
    }
    
	public void filterBySthButString(ENTextField field, String str)
	{
		
		
		switch(field)
		{
			case ENTextField.TITLE          -> 
			this.stockView = this.stockView.filterByTitle(str);
			
			case ENTextField.AUTHOR         -> 
			this.stockView = this.stockView.filterByAuthor(str);
			
			case ENTextField.ISBN           -> 
			this.stockView = this.stockView.filterByIsbn(str);
			
			case ENTextField.CATEGORY       -> 
			this.stockView = this.stockView.filterByCategory(str);
			
			case ENTextField.PRODUCER       -> 
			this.stockView = this.stockView.filterByProducer(str);
			
			case ENTextField.MODEL          -> 
			this.stockView = this.stockView.filterByModel(str);
			
			case ENTextField.IDENTIFIER     -> 
			this.stockView = this.stockView.filterByIdentifier(str);
			
			case ENTextField.TYPE           -> 
			this.stockView = this.stockView.filterByObjectType(str);
		}
	}
	
	public void filterBySthButInt(ENIntField field, int val)
	{
		switch(field)
		{
			case ENIntField.NUMBEROFPAGES -> 
			this.stockView = this.stockView.filterByNumberOfPages(val);
			
			case ENIntField.HEIGHT        -> 
			this.stockView = this.stockView.filterByHeight(val);
			
			case ENIntField.WIDTH         -> 
			this.stockView = this.stockView.filterByWidth(val);
			
			case ENIntField.AMOUNT        -> 
			this.stockView = this.stockView.filterByAmountThatEq(val);
			
			case ENIntField.PRICE         -> 
			this.stockView = this.stockView.filterByPriceThatEq(val);
		}
	}
	
	public void filterBySthButInRange(ENIntRangeField field, int val1, int val2)
	{
		switch(field)
		{
			case ENIntRangeField.AMOUNT -> 
			this.stockView = this.stockView.filterByAmountInClosedRange(val1, val2);
			
			case ENIntRangeField.PRICE  -> 
			this.stockView = this.stockView.filterByPriceInClosedRange(val1, val2);
		}
	}
    
	public void filterBySthButDate(ENDateField field, String str)
			throws DateException
	{
		switch(field)
		{
			case ENDateField.PRODUCTIONDATE   -> 
			this.stockView = this.stockView.filterByProductionDateThatEq(str);
			
			case ENDateField.DATEOFACCEPTANCE -> 
			this.stockView = this.stockView.filterByDateOfAcceptanceThatEq(str);
		}
	}
	
	public void filterBySthButDateInRange(ENDateField field, String date1, String date2)
			throws DateException
	{
		switch(field)
		{
			case ENDateField.PRODUCTIONDATE   -> 
			this.stockView = 
			this.stockView.filterByProductionDateInClosedRange(date1, date2);
			
			case ENDateField.DATEOFACCEPTANCE -> 
			this.stockView = 
			this.stockView.filterByDateOfAcceptanceInClosedRange(date1, date2);
		}
	}
	
//private:
	private CMoneySafe shopMoneySafe;
	
	private CWarehouse stockView;
	private CWarehouse stock;
	
	private CInsertStringPopupFactory insStrPopupFac;
	private JFrame pParent;
	
	private Path databaseFilePath;
	private Path moneySafeFilePath;
	
	// wczytanie bazy danych:
	private void loadStockDatabase()
	{
		try
		{
			this.stock.loadFromFile(databaseFilePath);
			this.refreshStockView();
		}
		catch(IOException | WarehouseException e)
		{
			new CErrorPopup
			(
				pParent,
				"Error while loading database: " + e.getMessage()
			);
		}
	}
	

	// zapis bazy danych:
	private void saveStockDatabase()
	{
		if( this.isStockEmpty() )
		{
			new CWarningPopup
			(
		       pParent,
		       "The database in memory is empty, so I am not saving it...",
		       "Warning - Empty Database"
		    );
			
			return;
		}
		
		try
		{
			this.stock.saveToFile(databaseFilePath);
		}
		catch(IOException e)
		{
			new CErrorPopup
			(
				pParent,
				"Error saving database: " + e.getMessage()
			);
		}
	}
	
	// wczytanie sejfu z pieniedzmi:
	private void loadMoneySafe()
	{
		try
		{
			this.shopMoneySafe.loadStatusFromFile(this.moneySafeFilePath);
		}
		catch(IOException e)
		{
			new CErrorPopup
			(
				pParent,
				"Error while loading money safe: " + e.getMessage()
			);
		}
	}
	
	// zapis sejfu z pieniedzmi:
	private void saveMoneySafe()
	{
		try
		{
			this.shopMoneySafe.saveStatusToFile(this.moneySafeFilePath);
		}
		catch(IOException e)
		{   
			new CErrorPopup
			(
				pParent,
				"Error saving money safe: " + e.getMessage()
			);
		}
	}
	
}
