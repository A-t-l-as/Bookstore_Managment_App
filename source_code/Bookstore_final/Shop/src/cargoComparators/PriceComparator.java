package cargoComparators;

import java.util.Comparator;
import cargos.CCargo;

public class PriceComparator implements Comparator<CCargo>
{
    @Override
    public int compare(CCargo c1, CCargo c2) 
    {
        return Integer.compare(c1.getPrice(), c2.getPrice());
    }
}