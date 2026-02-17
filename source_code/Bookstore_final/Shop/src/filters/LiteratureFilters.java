package filters;

import java.util.List;

import cargos.CLiterature;
import myUtils.NSListUtils;
import myUtils.NSStringUtils;

public class LiteratureFilters
{
	public static List<CLiterature> filterByTitle(List<CLiterature> argList, String str)
	{	
		return NSListUtils.search(argList, 
				item -> NSStringUtils.startsWithIgnoreCase(item.getTitle(), str) );
	}
	
	public static List<CLiterature> filterByAuthor(List<CLiterature> argList, String str)
	{	
		return NSListUtils.search(argList, 
				item -> NSStringUtils.startsWithIgnoreCase(item.getAuthor(), str) );
	}
	
	public static List<CLiterature> filterByNumberOfPages(List<CLiterature> argList, long val)
	{	
		return NSListUtils.search(argList, 
				  item -> val == item.getNumberOfPages() );
	}
	
	public static List<CLiterature> filterByHeight(List<CLiterature> argList, int val)
	{	
		return NSListUtils.search(argList, 
				  item -> val == item.getHeight() );
	}
	
	public static List<CLiterature> filterByWidth(List<CLiterature> argList, int val)
	{	
		return NSListUtils.search(argList, 
				  item -> val == item.getWidth() );
	}
	
	public static List<CLiterature> filterByIsbn(List<CLiterature> argList, String str)
	{	
		return NSListUtils.search(argList, 
				item -> NSStringUtils.startsWithIgnoreCase(item.getIsbn(), str) );
	}
	
}
