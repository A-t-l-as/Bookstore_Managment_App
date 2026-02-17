package filters;

import java.util.ArrayList;
import java.util.List;

import cargos.CEBook;
import cargos.CLiterature;

import myUtils.NSListUtils;

public class EBookFilters
{
	public static List<CLiterature> filterByIsScanned(List<CLiterature> argList, boolean val)
	{
		List<CEBook> onlyEBooks = NSListUtils.filterByType( argList, CEBook.class );
		
		List<CEBook> filteredEBookList = NSListUtils.search(
															onlyEBooks, 
														    item 
														    -> 
														    val 
														    == 
														    item.getIsScanned() 
								                           );
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredEBookList);
		
		return result;
	}
	
	
	public static List<CLiterature> filterByTotalNumberOfPages(
															   List<CLiterature> argList, 
															   long val
															  )
	{
		List<CEBook> onlyEBooks = NSListUtils.filterByType( argList, CEBook.class );
		
		List<CEBook> filteredEBookList = NSListUtils.search(
															onlyEBooks, 
														    item 
														    -> 
														    val 
														    == 
														    item.getTotalNumberOfPages() 
								                           );
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredEBookList);
		
		return result;
	}
	
}
