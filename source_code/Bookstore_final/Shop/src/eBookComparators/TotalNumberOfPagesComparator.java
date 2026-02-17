package eBookComparators;

import java.util.Comparator;
import cargos.CEBook;

public class TotalNumberOfPagesComparator implements Comparator<CEBook>
{
    @Override
    public int compare(CEBook eb1, CEBook eb2) 
    {
    	return Long.compare
    		   (
    			  eb1.getTotalNumberOfPages(), 
    			  eb2.getTotalNumberOfPages() 
    		   );
    }
}
