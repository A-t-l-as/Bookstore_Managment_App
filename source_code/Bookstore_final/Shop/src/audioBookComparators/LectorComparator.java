package audioBookComparators;

import java.util.Comparator;
import cargos.CAudioBook;
import myUtils.NSStringUtils;

public class LectorComparator implements Comparator<CAudioBook>
{
    @Override
    public int compare(CAudioBook ab1, CAudioBook ab2) 
    {
    	return NSStringUtils.compareAuthors
    		   ( 
    		     ab1.getLector(), 
    		     ab2.getLector() 
    		   );
    }
}
