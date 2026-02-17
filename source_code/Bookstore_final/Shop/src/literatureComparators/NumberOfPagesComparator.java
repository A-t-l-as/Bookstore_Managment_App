package literatureComparators;

import java.util.Comparator;
import cargos.CLiterature;

public class NumberOfPagesComparator implements Comparator<CLiterature>
{
    @Override
    public int compare(CLiterature l1, CLiterature l2) 
    {
        return Long.compare(l1.getNumberOfPages(), l2.getNumberOfPages());
    }
}