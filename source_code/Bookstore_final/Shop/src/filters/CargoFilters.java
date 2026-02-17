package filters;

import java.util.List;

import cargos.CLiterature;
import date.CDate;
import exceptions.DateException;
import myUtils.NSListUtils;
import myUtils.NSIntRangeUtils;
import myUtils.NSStringUtils;

public class CargoFilters
{
	public static List<CLiterature> filterByIdentifier(List<CLiterature> argList, String str)
	{	
		return NSListUtils.search(argList, 
				item -> NSStringUtils.startsWithIgnoreCase(item.getIdentifier(), str) );
	}
	
	public static List<CLiterature> filterByDateOfAcceptanceThatEq(
																   List<CLiterature> argList, 
																   CDate date
																  )
	{	
		return NSListUtils.search(argList, 
				  item -> date.equals( item.getDateOfAcceptance() ));
		
	}
	
	public static List<CLiterature> filterByDateOfAcceptanceThatEq(
															       List<CLiterature> argList, 
															       String dateStr
															      )
		throws DateException
	{	
		CDate tempDate = new CDate(dateStr);
		
		return NSListUtils.search(argList, 
				  item -> tempDate.equals( item.getDateOfAcceptance() ));
	}
	
	public static List<CLiterature> filterByDateOfAcceptanceInClosedRange
																   (
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
						item.getDateOfAcceptance(), tempDateRange1, tempDateRange2) );
	}	
	
	
	public static List<CLiterature> filterByAmountThatEq(List<CLiterature> argList, int val)
	{	
		return NSListUtils.search(argList, 
				  item -> val == item.getAmount() );
	}
	
	
	public static List<CLiterature> filterByAmountInClosedRange(
			   													List<CLiterature> argList, 
			   													int val1, 
			   													int val2
			  												   )
	{	
		return NSListUtils.search(argList, 
				item ->  NSIntRangeUtils.isInClosedRange(item.getAmount(), val1, val2) );
	}
	
	
	public static List<CLiterature> filterByPriceThatEq(List<CLiterature> argList, int val)
	{	
		return NSListUtils.search(argList, 
				  item -> val == item.getPrice() );
	}
	
	
	
	public static List<CLiterature> filterByPriceThatGreaterThan(
																 List<CLiterature> argList, 
																 int val
																)
	{	
		return NSListUtils.search(argList, 
				  item -> item.getPrice() > val );
	}
	
	public static List<CLiterature> filterByPriceThatGreaterOrEqThan(
																	 List<CLiterature> argList,
																	 int val
																	)
	{	
		return NSListUtils.search(argList, 
				  item -> item.getPrice() >= val );
	}
	
	
	public static List<CLiterature> filterByPriceThatLessThan(List<CLiterature> argList, int val)
	{	
		return NSListUtils.search(argList, 
				  item -> item.getPrice() < val );
	}
	
	public static List<CLiterature> filterByPriceThatLessOrEqThan(
																  List<CLiterature> argList, 
																  int val
																 )
	{	
		return NSListUtils.search(argList, 
				  item -> item.getPrice() <= val );
	}
	
	public static List<CLiterature> filterByPriceInClosedRange(
															   List<CLiterature> argList, 
															   int val1, 
															   int val2
															  )
	{	
		return NSListUtils.search(argList, 
				  item ->  NSIntRangeUtils.isInClosedRange(item.getPrice(), val1, val2) );
	}
	
	
	
}
