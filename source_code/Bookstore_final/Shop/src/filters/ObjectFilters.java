package filters;

import java.util.List;

import cargos.CLiterature;
import myUtils.NSListUtils;
import myUtils.NSStringUtils;

public class ObjectFilters
{
	public static List<CLiterature> filterByObjType(List<CLiterature> argList, String type)
	{	
		return NSListUtils.search(argList, 
				item -> NSStringUtils.startsWithIgnoreCase(item.getClass().getSimpleName(), type));
	}
	
	public static <T> List<CLiterature> filterByObjType(
														List<CLiterature> argList, 
														Class<T> type
													   )
	{	
		return NSListUtils.search(argList, 
				  item -> type.isInstance(item) );
	}
}
