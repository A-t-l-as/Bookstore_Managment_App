package filters;

import java.util.List;

import cargos.CLiterature;
import myUtils.NSListUtils;
import myUtils.NSStringUtils;
import date.CDate;
import exceptions.DateException;

public class ProductFilters
{
	public static List<CLiterature> filterByCategory(List<CLiterature> argList, String str)
	{	
		return NSListUtils.search(argList, 
				item -> NSStringUtils.startsWithIgnoreCase(item.getCategory(), str) );
	}
	
	public static List<CLiterature> filterByProducer(List<CLiterature> argList, String str)
	{	
		return NSListUtils.search(argList, 
				item -> NSStringUtils.startsWithIgnoreCase(item.getProducer(), str) );
	}
	
	public static List<CLiterature> filterByModel(List<CLiterature> argList, String str)
	{	
		// W tym przypadku wyszukiwanie po modelu nie potrzebuje startsWith
		// bo raczej w zdecydowany sposob wiemy jakie wydanie ksiazki chcemy.
		// W dodatku wydanie jest zapisane cyframi rzymskimi i nie sa to jakies wielkie liczby
		// wiec wpisanie tego nie bedzie wielkim problemem.
		
		return NSListUtils.search(argList, 
				  item -> str.equalsIgnoreCase( item.getModel() ));
	}
	
	public static List<CLiterature> filterByProductionDateThatEq(
																 List<CLiterature> argList, 
																 CDate date
																)
	{	
		return NSListUtils.search(argList, 
				  item -> date.equals( item.getProductionDate() ));
	}
	
	public static List<CLiterature> filterByProductionDateThatEq(
																 List<CLiterature> argList, 
																 String dateStr
																)
		throws DateException
	{	
		CDate tempDate = new CDate(dateStr);
		
		return NSListUtils.search(argList, 
				  item -> tempDate.equals( item.getProductionDate() ));
	}
	
	
	public static List<CLiterature> filterByProductionDateInClosedRange(
																		List<CLiterature> argList, 
																		String dateRangeStr1,
																		String dateRangeStr2
																	   )												
																	   throws DateException
	{	
		CDate tempDateRange1 = new CDate(dateRangeStr1);
		CDate tempDateRange2 = new CDate(dateRangeStr2);

		return NSListUtils.search(argList, 
				item -> CDate.isInClosedRange(
						item.getProductionDate(), tempDateRange1, tempDateRange2) );
	}	
	
	
}
