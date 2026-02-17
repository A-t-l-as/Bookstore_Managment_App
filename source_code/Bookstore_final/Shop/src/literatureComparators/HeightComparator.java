package literatureComparators;

import java.util.Comparator;
import cargos.CLiterature;

public class HeightComparator implements Comparator<CLiterature>
{
    @Override
    public int compare(CLiterature l1, CLiterature l2) 
    {
        return Integer.compare(l1.getHeight(), l2.getHeight());
    }
}