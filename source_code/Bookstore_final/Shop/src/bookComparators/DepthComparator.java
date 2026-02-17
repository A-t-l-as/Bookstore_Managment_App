package bookComparators;

import java.util.Comparator;
import cargos.CBook;

public class DepthComparator implements Comparator<CBook>
{
    @Override
    public int compare(CBook b1, CBook b2) 
    {
        return Integer.compare(b1.getDepth(), b2.getDepth());
    }
}