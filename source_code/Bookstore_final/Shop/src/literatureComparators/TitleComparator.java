package literatureComparators;

import java.util.Comparator;
import cargos.CLiterature;

public class TitleComparator implements Comparator<CLiterature>
{
    @Override
    public int compare(CLiterature l1, CLiterature l2) 
    {
    	return l1.getTitle().compareTo( l2.getTitle() );
    }
}