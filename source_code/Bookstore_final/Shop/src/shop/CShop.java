package shop;

import java.nio.file.Path;
import java.nio.file.Paths;

import warehouse.CInteractiveWarehouse;
import exceptions.WarehouseException;
import exceptions.MoneySafeException;
import factories.CLiteratureFactory;

import java.io.*;
import myUtils.NSConsoleUtils;
import exceptions.LiteratureFactoryException;
import cargos.CLiterature;
import java.util.*;

import myUtils.NSFileUtils;
import shopUtils.CFileWithList;
import shopUtils.CMoneySafe;
import shopUtils.CPosition;
import shopUtils.NSShopGlobals;
import exceptions.FileWithListException;

public class CShop
{
//public:
	
	public CShop()
	{
		this.initialize();
		this.loadDatabase();
		this.loadMoneySafe();
        this.registerShutdownHook();
        
        this.showWarehouseWindow();
	}

	public boolean pressTheButton(int number, String str, int val1, int val2, Path argPath)
	{
		// exit:
		if(number == 0)
		{
			return false;
		}
		
		switch(number)
		{
			// Show:
			case 1  -> this.showWarehouseWindow(); 
			case 2  -> this.showWarehouseSimpleWindow();
			case 3  -> this.showWarehouseDetailedWindow();
			
			// Acceptance of goods:
			case 4  -> this.acceptanceOfGoods(argPath);
			case 5  -> this.addSingleProduct(str);
			
			// Sell goods:
			case 6  -> this.sellProductsFromList(argPath);
			case 7  -> this.sellSingleProduct(str, val1);
			
			// Remove row:
			case 8  -> this.removeSingleRow(str);
			
			// Removing products with zero stock:
			case 9  -> this.removeProductsWithZeroStock();
			
			// Reversing:
			case 10 -> this.reverseAndShow();
			
			// Sorting:
			case 11 -> this.sortAndShow(); 
			case 12 -> this.sortByObjTypeAndShow(); 
			case 13 -> this.sortByIdentifierAndShow(); 
			case 14 -> this.sortByTitleAndShow(); 
			case 15 -> this.sortByAuthorAndShow(); 
			case 16 -> this.sortByCategoryAndShow();
			case 17 -> this.sortByAmountAndShow();
			case 18 -> this.sortByPriceAndShow();
			// case 19 -> ...
			
			// Filtering:
			case 20 -> this.resetFilters();
			case 21 -> this.showFilterByType(str);
			case 22 -> this.showFilterByIdentifier(str);
			case 23 -> this.showFilterByTitle(str);
			case 24 -> this.showFilterByAuthor(str);
			case 25 -> this.showFilterByCategory(str); 
			case 26 -> this.showFilterByAmountEq(val1); 
			case 27 -> this.showFilterByAmountInRange(val1, val2); 
			case 28 -> this.showFilterByPriceEq(val1); 
			case 29 -> this.showFilterByPriceInRange(val1, val2); 
			// case 30 -> ...
			
			default -> System.out.println("Unknown number of button...");
		}
		
		return true;
	}
	
//private:
	private void showWarehouseWindow()
	{
		this.stockView.showWarehouseStatus();
		this.showMoneyStatus();
		this.printLabels();
	}
	
	private void showWarehouseSimpleWindow()
	{
		this.stockView.showWarehouseSimpleStatus();
		this.showMoneyStatus();
		this.printLabels();
	}
	
	private void showWarehouseDetailedWindow()
	{
		this.stockView.showWarehouseDetailedStatus();
		this.showMoneyStatus();
		this.printLabels();
	}
	
	
	private void reverseAndShow()
	{
		this.stockView.reverse();
		this.showWarehouseWindow();
	}
	
	private void sortAndShow()
	{
		this.stockView.sort();
		this.showWarehouseWindow();
	}
	
	private void sortByObjTypeAndShow()
	{
		this.stockView.sortByObjType();
		this.showWarehouseWindow();
	}
	
	private void sortByIdentifierAndShow()
	{
		this.stockView.sortByIdentifier();
		this.showWarehouseWindow();
	}
	
	private void sortByTitleAndShow()
	{
		this.stockView.sortByTitle();
		this.showWarehouseWindow();
	}
	
	private void sortByAuthorAndShow()
	{
		this.stockView.sortByAuthor();
		this.showWarehouseWindow();
	}
	
	private void sortByCategoryAndShow()
	{
		this.stockView.sortByCategory();
		this.showWarehouseWindow();
	}
	
	private void sortByAmountAndShow()
	{
		this.stockView.sortByAmount();
		this.showWarehouseWindow();
	}
	
	private void sortByPriceAndShow()
	{
		this.stockView.sortByPrice();
		this.showWarehouseWindow();
	}
	
	
	
	private void resetFilters()
	{
		this.refreshStockView();
		this.showWarehouseWindow();
	}
	
	private void showFilterByType(String str)
	{
		this.stockView = this.stockView.filterByObjectType(str);
		this.showWarehouseWindow();
	}
	
	private void showFilterByIdentifier(String str)
	{
		this.stockView = this.stockView.filterByIdentifier(str);
		this.showWarehouseWindow();
	}
	
	private void showFilterByTitle(String str)
	{		
		this.stockView = this.stockView.filterByTitle(str);
		this.showWarehouseWindow();
	}
	
	private void showFilterByAuthor(String str)
	{		
		this.stockView = this.stockView.filterByAuthor(str);
		this.showWarehouseWindow();
	}
	
	
	private void showFilterByCategory(String str)
	{		
		this.stockView = this.stockView.filterByCategory(str);
		this.showWarehouseWindow();
	}
	
	private void showFilterByAmountEq(int val)
	{		
		this.stockView = this.stockView.filterByAmountThatEq(val);
		this.showWarehouseWindow();
	}
	
	private void showFilterByAmountInRange(int val1, int val2)
	{	
		this.stockView = this.stockView.filterByAmountInClosedRange(val1, val2);
		this.showWarehouseWindow();
	}
	
	private void showFilterByPriceEq(int val)
	{		
		this.stockView = this.stockView.filterByPriceThatEq(val);
		this.showWarehouseWindow();
	}
	
	private void showFilterByPriceInRange(int val1, int val2)
	{	
		this.stockView = this.stockView.filterByPriceInClosedRange(val1, val2);
		this.showWarehouseWindow();
	}
	
	private void acceptanceOfGoods(Path argPath)
	{
		if(NSFileUtils.checkThatFileExist(argPath) == false)
			return;
		
		try
		{
			this.stock.loadFromFile(argPath);
			this.refreshStockView();
			
			System.out.println("The delivery has been successfully accepted!");
			this.showWarehouseWindow();
		}
		catch(IOException ioe)
		{
			System.out.println("An error occurred while loading the file!");
			System.out.println(ioe);
		}
		catch(WarehouseException we)
		{
			System.out.println("The specified file contains incorrect data!");
			System.out.println(we);
		}
		
	}
    
	private void addSingleProduct(String str)
	{
		try
		{
			CLiterature item = new CLiteratureFactory(str).createObj();
			
			this.stock.addItem(item);
			this.refreshStockView();
			
			System.out.println("The product has been added successfully!");
			this.showWarehouseWindow();
		}
		catch(LiteratureFactoryException e)
		{
			System.out.println("The product has been entered incorrectly.");
			System.out.println
			(
				"The product should be entered as a string of information" +
			    " separated by semicolons..."
			);
		}
	}
	
	private void sellSingleProduct(String str, int howMuch)
	{
		this.sellSingleProduct(str, howMuch, true);
	}
	
	private void sellSingleProduct(String str, int howMuch, boolean refreshWindow)
	{
		try
		{
			this.sellSingleProductUnsafe(str, howMuch, refreshWindow);
		}
		catch(WarehouseException | MoneySafeException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private void sellSingleProductUnsafe(String str, int howMuch, boolean refreshWindow)
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
			System.out.println("Transaction completed successfully.");
			this.showWarehouseWindow();
		}
	}
	
	
	private void sellProductsFromList(Path argPath)
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
					System.out.println
					(
						WarehouseException.getMessageForSellProductsFromList( position.getStr() )
					);
				}
				catch(MoneySafeException mse)
				{
					System.out.println(mse.getMessage());
				}
			}
			
			System.out.println("Transaction completed successfully.");
			this.showWarehouseWindow();
		}
		catch(IOException ioe)
		{
			System.out.println("An error occurred while loading the file!");
			System.out.println(ioe.getMessage());
		}
		catch(FileWithListException iae)
		{
			System.out.println(iae.getMessage());
		}
		
	}
	
	
	private void removeSingleRow(String str)
	{
		try
		{
			this.stock.removeSingleRowWithIdentifier(str);
			this.refreshStockView();
			
			System.out.println("Row deleted successfully.");
			this.showWarehouseWindow();
		}
		catch(WarehouseException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	private void removeProductsWithZeroStock()
	{
		this.stock.removeItemsWithZeroAmount();
		this.refreshStockView();
		this.showWarehouseWindow();
	}
	
//private:
	
	private CMoneySafe shopMoneySafe;
	private CInteractiveWarehouse stockView;
	private CInteractiveWarehouse stock;
	
	private Path databaseFilePath;
	private Path moneySafeFilePath;
	
	private void refreshStockView()
	{
		this.stockView = new CInteractiveWarehouse(this.stock);
	}
	
	
	private void initialize()
	{
		this.shopMoneySafe = new CMoneySafe();
		
		this.databaseFilePath = Paths.get("")
				  .toAbsolutePath()
				  .resolve(NSShopGlobals.databaseDirectoryName)
				  .resolve(NSShopGlobals.databaseFileName);
		
		
		this.moneySafeFilePath = Paths.get("")
				  .toAbsolutePath()
				  .resolve(NSShopGlobals.databaseDirectoryName)
				  .resolve(NSShopGlobals.moneySafeFileName);
		

		this.stock = new CInteractiveWarehouse();
		this.stockView = new CInteractiveWarehouse();
		
	}
	
	
	private void loadMoneySafe()
	{
		try
		{
			this.shopMoneySafe.loadStatusFromFile(this.moneySafeFilePath);
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
	
	private void loadDatabase()
	{
		try
		{
			this.stock.loadFromFile(databaseFilePath);
			this.refreshStockView();
		}
		catch(IOException | WarehouseException e)
		{
			System.err.println(e);
		}
	}
	
	
	private void saveMoneySafe()
	{
		try
		{
			this.shopMoneySafe.saveStatusToFile(this.moneySafeFilePath);
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
	
	private void saveDatabase()
	{
		if( this.stock.isEmpty() )
		{
			System.err.println("The database in memory is empty, so I am not saving it...");
			return;
		}
		
		try
		{
			this.stock.saveToFile(databaseFilePath);
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
	
	
    private void registerShutdownHook()
    {
        Runtime.getRuntime().addShutdownHook
        (
        	new Thread
        	(
        		() -> 
        		{
        			System.out.println("Shutdown hook triggered. Saving database...");
        			saveMoneySafe();
        			saveDatabase();
        		}
        	)
       );
    }
    
    private void printLabels()
    {
		System.out.println(NSConsoleUtils.hLine);
		System.out.println("0. Exit | 1. Show normal status | 2. Show simple status | 3. Show detailed status | 4. Accept the goods from the file | 5. Add single product |");
		System.out.println(NSConsoleUtils.hLine);
		System.out.println("6. Sell multiple products based on a list from a file | 7. Sell single product | 8. Remove single row | 9. Remove products with zero stock |");
		System.out.println(NSConsoleUtils.hLine);
		System.out.println("10. Reverse | 11. Sort | 12. Sort by type | 13. Sort by identifier (EAN) | 14. Sort by title | 15. Sort by author | 16. Sort by category |");
		System.out.println(NSConsoleUtils.hLine);
		System.out.println("17. Sort by amount | 18. Sort by price |");
		System.out.println(NSConsoleUtils.hLine);
		System.out.println("20. Reset filters | 21. Filter by type | 22. Filter by identifier | 23. Filter by title | 24. Filter by author | 25. Filter by category |");
		System.out.println(NSConsoleUtils.hLine);
		System.out.println("26. Filter by amount that equal | 27. Filter by amount in range | 28. Filter by price that equal | 29. Filter by price in range |");
		System.out.println(NSConsoleUtils.hLine);
    }
    
    
    private void showMoneyStatus()
    {
    	System.out.println(this.shopMoneySafe);
    }
}
