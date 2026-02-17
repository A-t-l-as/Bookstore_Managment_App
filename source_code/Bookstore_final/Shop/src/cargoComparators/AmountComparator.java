package cargoComparators;

import java.util.Comparator;
import cargos.CCargo;

public class AmountComparator implements Comparator<CCargo>
{
    @Override
    public int compare(CCargo c1, CCargo c2) 
    {
        return Integer.compare(c1.getAmount(), c2.getAmount());
    }
}