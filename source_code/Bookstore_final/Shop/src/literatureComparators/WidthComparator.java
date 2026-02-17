package literatureComparators;

import java.util.Comparator;
import cargos.CLiterature;

public class WidthComparator implements Comparator<CLiterature>
{
    @Override
    public int compare(CLiterature l1, CLiterature l2) 
    {
        return Integer.compare(l1.getWidth(), l2.getWidth());
    }
}