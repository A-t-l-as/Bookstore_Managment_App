package literatureComparators;

import java.util.Comparator;
import cargos.CLiterature;

public class IsbnComparator implements Comparator<CLiterature>
{
    @Override
    public int compare(CLiterature l1, CLiterature l2) 
    {
    	return l1.getIsbn().compareTo( l2.getIsbn() );
    }
}