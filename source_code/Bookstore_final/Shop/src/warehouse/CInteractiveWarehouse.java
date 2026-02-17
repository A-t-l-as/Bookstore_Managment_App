package warehouse;

import java.time.LocalTime;
import java.util.List;

import cargos.CBook;
import cargos.CLiterature;
import exceptions.DateException;
import filters.AudioBookFilters;
import filters.BookFilters;
import filters.CargoFilters;
import filters.EBookFilters;
import filters.ELiteratureFilters;
import filters.LiteratureFilters;
import filters.ObjectFilters;
import filters.ProductFilters;
import myUtils.NSStringUtils;
import myUtils.NSConsoleUtils;

public class CInteractiveWarehouse extends CWarehouse
{
//public:

	//--------------
	// Constructors:
	public CInteractiveWarehouse()
	{
		super();
	}
	
	public CInteractiveWarehouse(List<CLiterature> list)
	{
		super(list);
	}
	
	public CInteractiveWarehouse(CInteractiveWarehouse other)
	{
		super(other);
	}
	//--------------
	
	
	//------
	// Show:
	public void showWarehouseDetailedStatus()
	{
		this.printTableHeader(" DETAILED ", this.warehouse);
		
        System.out.println();
		System.out.print(this);
		System.out.println();
	}
	
	public void showWarehouseStatus()
	{			
		this.showListStatus(this.warehouse);
	}
	
	// Metoda ktora pokazuje uproszczony status w ktorym obiekty o tym samym identifierze
	// sa zgrupowane w jeden obiekt ktory ma amount rowny sumie amount wszystkich obiektow
	// o tym samym identifierze. 	
	public void showWarehouseSimpleStatus()
	{		
		this.showListSimpleStatus( this.getWarehouseListWithUniqueItems() );
	}
	
	
    //------------------------
    // SEARCH/FILTER SHOWABLE:
    //------------------------
    
	//-------------
	// Object Show:
    public <T> void showByObjectType(Class<T> argType)
    {
    	this.showListStatus( ObjectFilters.filterByObjType(this.warehouse, argType) );
    }
    
    public void showByObjectType(String argType)
    {
    	this.showListStatus( ObjectFilters.filterByObjType(this.warehouse, argType) );
    }
	
    //------------
    // Cargo Show:
    public void showByIdentifier(String str)
    {
    	this.showListStatus( CargoFilters.filterByIdentifier(this.warehouse, str) );
    }

    
    public void showByDateOfAcceptanceThatEq(String str)
    	throws DateException
    {
    	this.showListStatus( CargoFilters.filterByDateOfAcceptanceThatEq(this.warehouse, str) );
    }
    
    public void showByAmountThatEq(int val)
    {
    	this.showListStatus( CargoFilters.filterByAmountThatEq(this.warehouse, val) );
    }
    
    public void showByAmountInClosedRange(int val1, int val2)
    {
    	this.showListStatus(CargoFilters.filterByAmountInClosedRange(this.warehouse, val1, val2));
    }
    
    public void showByPriceThatEq(int val)
    {
    	this.showListStatus( CargoFilters.filterByPriceThatEq(this.warehouse, val) );
    }
    
    public void showByPriceThatGreaterThan(int val)
    {
    	this.showListStatus( CargoFilters.filterByPriceThatGreaterThan(this.warehouse, val) );
    }
    
    public void showByPriceThatGreaterOrEqThan(int val)
    {
    	this.showListStatus( CargoFilters.filterByPriceThatGreaterOrEqThan(this.warehouse, val) );
    }
    
    public void showByPriceThatLessThan(int val)
    {
    	this.showListStatus( CargoFilters.filterByPriceThatLessThan(this.warehouse, val) );
    }
    
    public void showByPriceThatLessOrEqThan(int val)
    {
    	this.showListStatus( CargoFilters.filterByPriceThatLessOrEqThan(this.warehouse, val) );
    }
    
    public void showByPriceInClosedRange(int val1, int val2)
    {
    	this.showListStatus( CargoFilters.filterByPriceInClosedRange(this.warehouse, val1, val2) );
    }
    
    //--------------
    // Product Show:
	public void showByCategory(String argCategory)
	{
		this.showListStatus( ProductFilters.filterByCategory(this.warehouse, argCategory) );
	}
	
	public void showByProducer(String argProducer)
	{
		this.showListStatus( ProductFilters.filterByProducer(this.warehouse, argProducer) );
	}
	
	public void showByModel(String str)
	{
		this.showListStatus( ProductFilters.filterByModel(this.warehouse, str) );
	}
	
	public void showByProductionDateThatEq(String str)
		throws DateException
	{
		this.showListStatus( ProductFilters.filterByProductionDateThatEq(this.warehouse, str) );
	}
	
    //-----------------
    // Literature Show:
	public void showByTitle(String str)
	{
		this.showListStatus( LiteratureFilters.filterByTitle(this.warehouse, str) );
	}
	
	public void showByAuthor(String str)
	{
		this.showListStatus( LiteratureFilters.filterByAuthor(this.warehouse, str) );
	}
	
	public void showByNumberOfPages(long val)
	{
		this.showListStatus( LiteratureFilters.filterByNumberOfPages(this.warehouse, val) );
	}
	
	public void showByHeight(int val)
	{
		this.showListStatus( LiteratureFilters.filterByHeight(this.warehouse, val) );
	}
	
	public void showByWidth(int val)
	{
		this.showListStatus( LiteratureFilters.filterByWidth(this.warehouse, val) );
	}
	
	public void showByIsbn(String str)
	{
		this.showListStatus( LiteratureFilters.filterByIsbn(this.warehouse, str) );
	}
	
	//----------------
	
	//------------
	// CBook Show:
	public void showByDepth(int val)
	{
		this.showListStatus( BookFilters.filterByDepth(this.warehouse, val) );
	}
	
	public void showByTypeOfCover(CBook.ENTypeOfCover cover)
	{
		this.showListStatus( BookFilters.filterByTypeOfCover(this.warehouse, cover) );
	}
	
	public void showByWeight(float val)
	{
		this.showListStatus( BookFilters.filterByWeight(this.warehouse, val) );
	}
	
	//-------------------
	// CELiterature Show:
	public void showBySizeOfFile(float val)
	{
		this.showListStatus( ELiteratureFilters.filterBySizeOfFile(this.warehouse, val) );
	}
	
	public void showByFileExtension(String str)
	{
		this.showListStatus( ELiteratureFilters.filterByFileExtension(this.warehouse, str) );
	}
	
	//-------------
	// CEBook Show:
	public void showByIsScanned(boolean val)
	{
		this.showListStatus( EBookFilters.filterByIsScanned(this.warehouse, val) );
	}
	
	public void showByTotalNumberOfPages(long val)
	{
		this.showListStatus( EBookFilters.filterByTotalNumberOfPages(this.warehouse, val) );
	}
	
	//-----------------
	// CAudioBook Show:
	public void showByDuration(LocalTime val)
	{
		this.showListStatus( AudioBookFilters.filterByDuration(this.warehouse, val) );
	}
	
	public void showByLector(String str)
	{
		this.showListStatus( AudioBookFilters.filterByLector(this.warehouse, str) );
	}
	//-----------------
	
//private:
	
	//----------------
	// Print and show:
	private void printTableHeader(String header, List<?> l)
	{
		System.out.println(NSConsoleUtils.hLine);
		System.out.println(NSConsoleUtils.hLine);
		System.out.println("\n*** WAREHOUSE" + header + "STATUS ***");
        System.out.println("Number of items: " + l.size() );
        System.out.println("\nList:");
	}
	
	private void showListSimpleStatus(List<CLiterature> argList)
	{		
        this.printTableHeader(" SIMPLE ", argList);
        
        System.out.println(NSConsoleUtils.hLine );
        System.out.printf("%-15s %-20s %-30s %-30s %-30s %-10s %-10s%n", 
            this.labels.get(14), 
            this.labels.get(10), 
            this.labels.get(0), 
            this.labels.get(1), 
            this.labels.get(6),
            this.labels.get(12), 
            this.labels.get(13)
            );
        System.out.println(NSConsoleUtils.hLine);
        
        for (var item : argList)
        {	
            System.out.printf("%-15s %-20s %-30s %-30s %-30s %-10s %-10s%n", 
            	NSStringUtils.truncate(item.getClass().getSimpleName(), 13),
            	NSStringUtils.truncate(item.getIdentifier(), 18), 
            	NSStringUtils.truncate(item.getTitle(), 28), 
            	NSStringUtils.truncate(item.getAuthor(), 28),
            	NSStringUtils.truncate(item.getCategory(), 28),
            	item.getAmount(),
            	item.getPrice()
            );
        }
        System.out.println(NSConsoleUtils.hLine + "\n");
	}
	
	private void showListStatus(List<CLiterature> argList)
	{			
        this.printTableHeader(" ", argList);
        
        System.out.println(NSConsoleUtils.hLine);
        System.out.printf("%-15s %-20s %-30s %-30s %-30s %-10s %-10s%n", 
            this.labels.get(14), 
            this.labels.get(10), 
            this.labels.get(0), 
            this.labels.get(1), 
            this.labels.get(6), 
            this.labels.get(12), 
            this.labels.get(13)
            );
        System.out.println(NSConsoleUtils.hLine);
        
        for (var item : argList)
        {
            System.out.printf("%-15s %-20s %-30s %-30s %-30s %-10s %-10s%n", 
            	NSStringUtils.truncate(item.getClass().getSimpleName(), 13),
            	NSStringUtils.truncate(item.getIdentifier(), 18), 
            	NSStringUtils.truncate(item.getTitle(), 28), 
            	NSStringUtils.truncate(item.getAuthor(), 28),
            	NSStringUtils.truncate(item.getCategory(), 28),
                item.getAmount(),
                item.getPrice()
            );
        }
        System.out.println(NSConsoleUtils.hLine + "\n");
	}


}
