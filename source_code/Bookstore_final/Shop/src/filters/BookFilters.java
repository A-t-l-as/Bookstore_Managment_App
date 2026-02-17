package filters;

import java.util.ArrayList;
import java.util.List;

import cargos.CLiterature;
import cargos.CBook;

import myUtils.NSListUtils;



public class BookFilters
{
	public static List<CLiterature> filterByDepth(List<CLiterature> argList, int val)
	{
		List<CBook> onlyBooks = NSListUtils.filterByType( argList, CBook.class );
		
		List<CBook> filteredBookList = NSListUtils.search(
								                          onlyBooks, 
				  					                      item 
				  					                      -> 
								                          val 
								                          == 
								                          item.getDepth() 
								                         );
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredBookList);
		
		return result;
	}
	
	
	public static List<CLiterature> filterByTypeOfCover(
														List<CLiterature> argList, 
														CBook.ENTypeOfCover cover
													   )
	{
		List<CBook> onlyBooks = NSListUtils.filterByType( argList, CBook.class );
		
		List<CBook> filteredBookList = NSListUtils.search(
								                          onlyBooks, 
				  					                      item 
				  					                      -> 
								                          cover
								                          .
								                          equals
								                           (
								                              item.getTypeOfCover()
								                           )
								                         );
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredBookList);
		
		return result;
	}
	
	public static List<CLiterature> filterByWeight(List<CLiterature> argList, float val)
	{
		List<CBook> onlyBooks = NSListUtils.filterByType( argList, CBook.class );
		
		List<CBook> filteredBookList = NSListUtils.search(
								                          onlyBooks, 
				  					                      item 
				  					                      -> 
								                          val 
								                          == 
								                          item.getWeight() 
								                         );
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredBookList);
		
		return result;
	}
	
	
}
