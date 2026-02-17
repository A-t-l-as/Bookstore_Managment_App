package warehouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import audioBookComparators.DurationComparator;
import audioBookComparators.LectorComparator;

import bookComparators.DepthComparator;
import bookComparators.TypeOfCoverComparator;
import bookComparators.WeightComparator;

import cargoComparators.AmountComparator;
import cargoComparators.DateOfAcceptanceComparator;
import cargoComparators.IdentifierComparator;
import cargoComparators.PriceComparator;

import cargos.CAudioBook;
import cargos.CBook;
import cargos.CEBook;
import cargos.CELiterature;
import cargos.CLiterature;

import eBookComparators.IsScannedComparator;
import eBookComparators.TotalNumberOfPagesComparator;

import eLiteratureComparators.FileExtensionComparator;
import eLiteratureComparators.SizeOfFileComparator;

import filters.*;


import literatureComparators.AuthorComparator;
import literatureComparators.HeightComparator;
import literatureComparators.IsbnComparator;
import literatureComparators.NumberOfPagesComparator;
import literatureComparators.TitleComparator;
import literatureComparators.WidthComparator;

import myUtils.NSClassUtils;
import myUtils.NSListUtils;

import objectComparators.ObjectTypeComparator;

import productComparators.CategoryComparator;
import productComparators.ModelComparator;
import productComparators.ProducerComparator;
import productComparators.ProductionDateComparator;
import exceptions.CargoException;
import exceptions.DateException;
import exceptions.LiteratureException;
import exceptions.LiteratureFactoryException;
import exceptions.WarehouseException;
import factories.CLiteratureFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.time.LocalTime;

public class CWarehouse
{
//public:
	
	//--------------
	// Constructors:
	public CWarehouse()
	{
		this.warehouse = new ArrayList<CLiterature>();
		this.initializeLabels();
	}
	
	public CWarehouse(List<CLiterature> list)
	{
		this.warehouse = new ArrayList<CLiterature>(list);
		this.initializeLabels();
	}
	
	public CWarehouse(CWarehouse other)
	{
		this.warehouse = new ArrayList<CLiterature>( other.warehouse ); 
		this.initializeLabels();
	}
	
    //--------------------
    // Remove zero states:
    public void removeItemsWithZeroAmount()
    {
    	this.warehouse.removeIf( literature -> literature.getAmount() <= 0 );
    }

    //---------
    // Reverse:
    //---------
    
    public void reverse()
    {
    	Collections.reverse(this.warehouse);
    }
    
    
    //---------
    // SORTING:
    //---------
    
    //-------
    // Sort:
    public void sort() 
    { 
    	Collections.sort(this.warehouse); 
    }
    
    //-------------
    // Object sort:
    public void sortByObjType()
    {
    	Collections.sort(this.warehouse, new ObjectTypeComparator() );
    }
    
    //-------------
    // CCargo sort:
    public void sortByIdentifier() 
    { 
    	Collections.sort(this.warehouse, new IdentifierComparator() ); 
    }
    
    public void sortByDateOfAcceptance() 
    { 
    	Collections.sort(this.warehouse, new DateOfAcceptanceComparator() );
    }
    
    public void sortByAmount() 
    { 
    	Collections.sort(this.warehouse, new AmountComparator() ); 
    }
    
    public void sortByPrice() 
    { 
    	Collections.sort(this.warehouse, new PriceComparator() ); 
    }
    
    //---------------
    // CProduct sort:
    public void sortByCategory() 
    { 
    	Collections.sort(this.warehouse, new CategoryComparator() ); 
    }
    
    public void sortByProducer() 
    { 
    	Collections.sort(this.warehouse, new ProducerComparator() ); 
    }
    
    public void sortByModel() 
    { 
    	Collections.sort(this.warehouse, new ModelComparator() ); 
    }
    
    public void sortByProductionDate() 
    { 
    	Collections.sort(this.warehouse, new ProductionDateComparator() ); 
    }
    
    //------------------
    // CLiterature sort:
    public void sortByTitle() 
    { 
    	Collections.sort(this.warehouse, new TitleComparator() ); 
    }
    
    public void sortByAuthor() 
    { 
    	Collections.sort(this.warehouse, new AuthorComparator() ); 
    }
    
    public void sortByNumberOfPages() 
    { 
    	Collections.sort(this.warehouse, new NumberOfPagesComparator() ); 
    }
    
    public void sortByHeight() 
    { 
    	Collections.sort(this.warehouse, new HeightComparator() ); 
    }
    
    public void sortByWidth() 
    { 
    	Collections.sort(this.warehouse, new WidthComparator() ); 
    }
    
    public void sortByIsbn() 
    { 
    	Collections.sort(this.warehouse, new IsbnComparator() ); 
    }
    
    //------------
    // CBook sort:
    public void sortByDepth() 
    { 
    	this.sortByT(CBook.class, new DepthComparator());
    }
    
    public void sortByTypeOfCover() 
    { 
    	this.sortByT(CBook.class, new TypeOfCoverComparator());
    }
    
    public void sortByWeight() 
    { 
    	this.sortByT(CBook.class, new WeightComparator());
    }
    
    //-------------------
    // CELiterature sort:
    public void sortBySizeOfFile() 
    { 
    	this.sortByT(CELiterature.class, new SizeOfFileComparator());
    }
    
    public void sortByFileExtension() 
    { 
    	this.sortByT(CELiterature.class, new FileExtensionComparator());
    }
    
    
    //-------------
    // CEBook sort:
    public void sortByIsScanned() 
    { 
    	this.sortByT(CEBook.class, new IsScannedComparator());
    }
    
    public void sortByTotalNumberOfPages() 
    { 
    	this.sortByT(CEBook.class, new TotalNumberOfPagesComparator());
    }
    
    //-----------------
    // CAudioBook sort:
    public void sortByDuration() 
    { 
    	this.sortByT(CAudioBook.class, new DurationComparator());
    }
    
    public void sortByLector() 
    { 
    	this.sortByT(CAudioBook.class, new LectorComparator());
    }
    //-----------------
    
    
    
    //---------------
    // SEARCH/FILTER:
    //---------------
    
    //----------------
    // Object Filters:
    public <T> CInteractiveWarehouse filterByObjectType(Class<T> argType)
    {
    	return new CInteractiveWarehouse( 
    			                         ObjectFilters.filterByObjType
    			                         (
    			                        	this.warehouse, 
    			                        	argType
    			                         ) 
    			                        );
    }
    
    public CInteractiveWarehouse filterByObjectType(String argType)
    {
    	return new CInteractiveWarehouse( 
    			                         ObjectFilters.filterByObjType
    			                         (
    			                        	this.warehouse, 
    			                        	argType
    			                         ) 
    			                        );
    }
    
    //---------------
    // Cargo Filters:
    public CInteractiveWarehouse filterByIdentifier(String str)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByIdentifier
    			                         (
    			                        	this.warehouse, 
    			                        	str
    			                         ) 
    			                        );
    }
    
    public CInteractiveWarehouse filterByDateOfAcceptanceThatEq(String str)
    	throws DateException
    {
    	return new CInteractiveWarehouse( 
    			CargoFilters.filterByDateOfAcceptanceThatEq(this.warehouse, str) );
    }
    
    public CInteractiveWarehouse filterByDateOfAcceptanceInClosedRange(String str1, String str2)
        	throws DateException
    {
        return new CInteractiveWarehouse( 
        		CargoFilters.filterByDateOfAcceptanceInClosedRange(this.warehouse, str1, str2) );
    }
    
    public CInteractiveWarehouse filterByAmountThatEq(int val)
    {
    	return new CInteractiveWarehouse(CargoFilters.filterByAmountThatEq(this.warehouse, val));
    }
    
    public CInteractiveWarehouse filterByAmountInClosedRange(int val1, int val2)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByAmountInClosedRange
    			                         (
    			                           this.warehouse, 
    			                           val1, 
    			                           val2
    			                         ) 
    								    );
    }
    
    public CInteractiveWarehouse filterByPriceThatEq(int val)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByPriceThatEq
    			                         (
    			                        	this.warehouse, 
    			                        	val
    			                         ) 
    			                        );
    }
    
    public CInteractiveWarehouse filterByPriceThatGreaterThan(int val)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByPriceThatGreaterThan
    			                         (
    			                        	this.warehouse, 
    			                        	val
    			                         ) 
    			                        );
    }
    
    public CInteractiveWarehouse filterByPriceThatGreaterOrEqThan(int val)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByPriceThatGreaterOrEqThan
    			                         (
    			                        	this.warehouse, 
    			                        	val
    			                         ) 
    			                        );
    }
    
    public CInteractiveWarehouse filterByPriceThatLessThan(int val)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByPriceThatLessThan
    			                         (
    			                        	this.warehouse, 
    			                        	val
    			                         ) 
    			                        );
    }
    
    public CInteractiveWarehouse filterByPriceThatLessOrEqThan(int val)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByPriceThatLessOrEqThan
    			                         (
    			                        	this.warehouse, 
    			                        	val
    			                         ) 
    			                        );
    }
    
    public CInteractiveWarehouse filterByPriceInClosedRange(int val1, int val2)
    {
    	return new CInteractiveWarehouse( 
    			                         CargoFilters.filterByPriceInClosedRange
    			                         (
    			                            this.warehouse, 
    			                            val1, 
    			                            val2
    			                         ) 
    			                        );
    }
    
    //-----------------
    // Product Filters:
	public CInteractiveWarehouse filterByCategory(String argCategory)
	{
		return new CInteractiveWarehouse( 
				                         ProductFilters.filterByCategory
				                         (
				                        	this.warehouse, 
				                        	argCategory
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByProducer(String argProducer)
	{
		return new CInteractiveWarehouse( 
				                         ProductFilters.filterByProducer
				                         (
				                            this.warehouse, 
				                            argProducer
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByModel(String str)
	{
		return new CInteractiveWarehouse( ProductFilters.filterByModel(this.warehouse, str) );
	}
	
	public CInteractiveWarehouse filterByProductionDateThatEq(String str)
		throws DateException
	{
		return new CInteractiveWarehouse( 
				ProductFilters.filterByProductionDateThatEq(this.warehouse, str) );
	}
	
	public CInteractiveWarehouse filterByProductionDateInClosedRange(String str1, String str2)
			throws DateException
	{
		return new CInteractiveWarehouse( 
				ProductFilters.filterByProductionDateInClosedRange(this.warehouse, str1, str2) );
	}
	
    //--------------------
    // Literature Filters:
	public CInteractiveWarehouse filterByTitle(String str)
	{
		return new CInteractiveWarehouse( LiteratureFilters.filterByTitle(this.warehouse, str) );
	}
	
	public CInteractiveWarehouse filterByAuthor(String str)
	{
		return new CInteractiveWarehouse( 
				                         LiteratureFilters.filterByAuthor
				                         (
				                        	this.warehouse, 
				                        	str
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByNumberOfPages(long val)
	{
		return new CInteractiveWarehouse( 
				                         LiteratureFilters.filterByNumberOfPages
				                         (
				                        	this.warehouse, 
				                        	val
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByHeight(int val)
	{
		return new CInteractiveWarehouse( LiteratureFilters.filterByHeight(this.warehouse, val) );
	}
	
	public CInteractiveWarehouse filterByWidth(int val)
	{
		return new CInteractiveWarehouse( LiteratureFilters.filterByWidth(this.warehouse, val) );
	}
	
	public CInteractiveWarehouse filterByIsbn(String str)
	{
		return new CInteractiveWarehouse( LiteratureFilters.filterByIsbn(this.warehouse, str) );
	}
	
	//----------------
	
	//---------------
	// CBook Filters:
	public CInteractiveWarehouse filterByDepth(int val)
	{
		return new CInteractiveWarehouse( BookFilters.filterByDepth(this.warehouse, val) );
	}
	
	public CInteractiveWarehouse filterByTypeOfCover(CBook.ENTypeOfCover cover)
	{
		return new CInteractiveWarehouse( 
				                         BookFilters.filterByTypeOfCover
				                         (
				                        	this.warehouse, 
				                        	cover
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByWeight(float val)
	{
		return new CInteractiveWarehouse( BookFilters.filterByWeight(this.warehouse, val) );
	}
	
	//----------------------
	// CELiterature Filters:
	public CInteractiveWarehouse filterBySizeOfFile(float val)
	{
		return new CInteractiveWarehouse( 
				                         ELiteratureFilters.filterBySizeOfFile
				                         (
				                        	this.warehouse, 
				                        	val
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByFileExtension(String str)
	{
		return new CInteractiveWarehouse( 
				                         ELiteratureFilters.filterByFileExtension
				                         (
				                        	this.warehouse, 
				                        	str
				                         ) 
				                        );
	}
	
	//----------------
	// CEBook Filters:
	public CInteractiveWarehouse filterByIsScanned(boolean val)
	{
		return new CInteractiveWarehouse( 
				                         EBookFilters.filterByIsScanned
				                         (
				                        	this.warehouse, 
				                        	val
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByTotalNumberOfPages(long val)
	{
		return new CInteractiveWarehouse( 
				                         EBookFilters.filterByTotalNumberOfPages
				                         (
				                        	this.warehouse, 
				                        	val
				                         ) 
				                        );
	}
	
	//--------------------
	// CAudioBook Filters:
	public CInteractiveWarehouse filterByDuration(LocalTime val)
	{
		return new CInteractiveWarehouse(
				                         AudioBookFilters.filterByDuration
				                         (
				                        	this.warehouse, 
				                        	val
				                         ) 
				                        );
	}
	
	public CInteractiveWarehouse filterByLector(String str)
	{
		return new CInteractiveWarehouse(AudioBookFilters.filterByLector(this.warehouse, str));
	}
	
	//-------
	// Views:
	public CInteractiveWarehouse getSimpleView()
	{
		return new CInteractiveWarehouse( this.getWarehouseListWithUniqueItems() );
	}
	
	
	//-------
    // Utils:
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("[").append( System.getProperty("line.separator") );
		
		final int sizeOfWarehouse = this.warehouse.size();
		
		int i = 0 ;
		for(var item : this.warehouse)
		{
			sb.append("{\"class\": ")
			  .append("\"")
			  .append(  item.getClass().getSimpleName()  )
			  .append("\"").append(", ")
			  .append(item).append("}");
			
			if(i < sizeOfWarehouse - 1)
				sb.append(",");
				
			sb.append( System.getProperty("line.separator") );
			
			++i;
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	//---------
	// Getters:
	public int getSumOfItemAmount(String argIdentifier)
	{
		int sum = 0;
		
		for(var item : this.warehouse)
		{
			if( item.getIdentifier().equals(argIdentifier) ) 
				sum += item.getAmount();
			
		}
		
		return sum;
	}
	
	public int getIndexByIdentifier(String argIdentifier)
	{
		int i = 0;
		for(var item : this.warehouse)
		{
			if( item.getIdentifier().equals(argIdentifier) ) 
				return i;

			++i;
		}
		
		return NSListUtils.NOT_FOUND;
	}
	
	public CLiterature getItemByIdentifier(String argIdentifier)
	{
		for(var item : this.warehouse)
		{
			if( item.getIdentifier().equals(argIdentifier) ) 
				return item;
		}
		
		return null;
	}
	
	public CLiterature getAvailableItemByIdentifier(String argIdentifier)
	{
		for(var item : this.warehouse)
		{
			if( item.getIdentifier().equals(argIdentifier) && item.getAmount() > 0) 
				return item;
		}
		
		return null;
	}
	
	public CLiterature getItemByIndex(int index)
	{
		return this.warehouse.get(index);
	}
	
	public boolean isEmpty()
	{
		return this.warehouse.isEmpty();
	}
	
	public int getSize()
	{
		return this.warehouse.size();
	}
	
	public List<CLiterature> getWarehouseList()
	{
		return new ArrayList<>(warehouse);
	}
	
	public List<String> getLabelsList()
	{
		return this.labels;
	}
	
	public String[] getLabelsArray()
	{
		return this.labels.toArray(  new String[ labels.size() ]  );
	}
	
	
	// Metoda zwracająca dane dla GUI (tabela)
    public Object[][] getDataForTable()
    {
    	CLiterature item = new CLiterature();
    	
    	final int numberOfColumns = 
    			NSClassUtils.getAllFields(item.getClass()).size() + 1;
    	
    	final int lastColumnIndex = numberOfColumns - 1;
    	final int wareHouseSize = warehouse.size();
    	
        Object[][] data = new Object[wareHouseSize][numberOfColumns];
        
        for (int i = 0; i < wareHouseSize; ++i)
        {	
        	try
        	{
        		item = new CLiterature(warehouse.get(i));
        	}
        	catch(DateException | LiteratureException | CargoException e){}
        	
            List<Field> allFields = NSClassUtils.getAllFields(item.getClass());
           
            data[i][lastColumnIndex] = warehouse.get(i).getClass().getSimpleName();
            
            for(int j = 0; j < lastColumnIndex; ++j)
            {
            	try
            	{
            		Field singleField = allFields.get(j);
            		singleField.setAccessible(true);
            		data[i][j] = singleField.get(item);
            	}
            	catch (IllegalAccessException e)
            	{
            		e.printStackTrace();
            	}
            }
        }
        
        return data;
    }
	
	
	//---------------
	// IO operations:
	public void loadFromFile(Path argCsvFilePath) 
			throws IOException, WarehouseException
	{
		BufferedReader fin = new BufferedReader(
								new FileReader(argCsvFilePath.toString()));
		
		String line = new String();
		
		while((line = fin.readLine()) != null)
		{	
			try
			{
				this.warehouse.add(  new CLiteratureFactory(line).createObj()  );
			}
			catch(LiteratureFactoryException e)
			{
				fin.close();
				throw new WarehouseException(e, argCsvFilePath);
			}
		}
		
		fin.close();
	}
	
	public void saveToFile(Path argCsvFilePath) throws IOException
	{
		BufferedWriter fout = new BufferedWriter(
								new FileWriter(argCsvFilePath.toString()));
		
		for(var item : warehouse)
		{
			fout.write
			(
				item.getClass().getSimpleName().toUpperCase() 
				+
				";"
				+
				item.toCsv()
			);
			
			fout.newLine();
		}
		
		fout.close();
	}
	//-------------
	
	//-----------------------
	// Adder and substractor:
	public void addItem(CLiterature lit)
	{
		this.warehouse.add(lit);
	}
	
	public void subItem(String identifier, int howMuch) throws WarehouseException
	{
		int totalAmount = this.getSumOfItemAmount(identifier);
		
		CLiterature singleItem = this.getAvailableItemByIdentifier(identifier);
		
		if(singleItem == null)
			throw new WarehouseException("The specified goods are not available!");
		
		if(totalAmount < howMuch)
			throw new WarehouseException("You are trying to take more items than are in stock!");
		
		while(howMuch > 0)
		{
			singleItem = this.getAvailableItemByIdentifier(identifier);
			
			if(singleItem == null)
				throw new WarehouseException("The specified goods are not available!");
			
			howMuch = singleItem.safeSubFromAmount(howMuch);
		}
	}
	
	
	public void removeSingleRowWithIdentifier(String identifier) throws WarehouseException
	{
		int index = this.getIndexByIdentifier(identifier);
		
		if(index == NSListUtils.NOT_FOUND)
			throw new WarehouseException("The specified goods are not available!");
		
		this.warehouse.remove(index);
	}
	//--------------------
	

	
//protected:
	protected List<CLiterature> warehouse;
	protected List<String> labels;

	protected <T extends CLiterature> void sortByT(Class<T> typeToSort, Comparator<T> comparator)
	{
    	List<T> onlyT = NSListUtils.filterByType( this.warehouse, typeToSort );
    	
        Collections.sort(onlyT, comparator); 
        
        List<CLiterature> result = new ArrayList<CLiterature>();
        result.addAll(onlyT);
        
        for (CLiterature item : this.warehouse)
        {
            if ( !typeToSort.isInstance(item) )
            {
                result.add(item);
            }
        }
        
        this.warehouse = result;
	}
	
	protected void initializeLabels()
	{
		// labels:
		this.labels = NSClassUtils.getAllFieldNames(new CLiterature().getClass());
		
		// height + [mm]
		this.labels.set(3, this.labels.get(3) + " [mm]");
				
		// width + [mm]
		this.labels.set(4, this.labels.get(4) + " [mm]");
		
		// producer + (publisher)
		this.labels.set(7, this.labels.get(7) + " (publisher)");
		
		// model + (edition number)
		this.labels.set(8, this.labels.get(8) + " (edition number)");
		
		// productionDate + (release date)
		this.labels.set(9, this.labels.get(9) + " (release date)");
		
		// identifier + (EAN)
		this.labels.set(10, this.labels.get(10) + " (EAN)");
		
		// ostatnia etykieta = item/class type
		this.labels.add("type");
		
	}
	
	protected Set<String> getUniqueIdentifiers()
	{
		// LinkedHashSet zachowuje kolejnosc obiektow...
		Set<String> onlyUniqueIdentifiers = new LinkedHashSet<>();

		for(var item : this.warehouse)
		{
			onlyUniqueIdentifiers.add( item.getIdentifier() );
		}		
		
		return onlyUniqueIdentifiers;
	}
	
	protected List<CLiterature> getWarehouseListWithUniqueItems()
	{
		List<CLiterature> result = new ArrayList<CLiterature>();
		
		Set<String> uniqueIdentifiers = this.getUniqueIdentifiers();
		
		CLiterature tempItem = new CLiterature();
		
        for (var id : uniqueIdentifiers)
        {
        	try
        	{
        		tempItem = CLiteratureFactory
        				   .
        				   createSaveCopyWithType( this.getItemByIdentifier(id) );
        		tempItem.setAmount( this.getSumOfItemAmount(id) );
        	}
        	catch( CargoException | LiteratureFactoryException e)
        	{}
        	
        	result.add(tempItem);
        }	
        
        return result;
	}
}
