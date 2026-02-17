package audioBookComparators;

import java.util.Comparator;
import cargos.CAudioBook;

public class DurationComparator implements Comparator<CAudioBook>
{
    @Override
    public int compare(CAudioBook ab1, CAudioBook ab2) 
    {
    	return ab1.getDuration().compareTo( ab2.getDuration() );
    }
}
