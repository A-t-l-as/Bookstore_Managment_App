package myUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class NSListUtils
{
	public static final int NOT_FOUND = -1;
	
	public static <T> List<T> filterByType(List<?> list, Class<T> type)
	{
        List<T> result = new ArrayList<>();
        
        for (Object item : list)
        {
            if (type.isInstance(item))
            {
                result.add( type.cast(item) );
            }
        }
        
        return result;
    }
	
	
	public static <T> List<T> search(List<T> literature, Predicate<T> condition)
	 
	{
		return literature.stream()
				         .filter(condition)
				         .collect(Collectors.toList());
	}
	
}
