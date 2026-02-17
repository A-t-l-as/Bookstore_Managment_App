package bookComparators;

import java.util.Comparator;
import cargos.CBook;

public class WeightComparator implements Comparator<CBook>
{
    @Override
    public int compare(CBook b1, CBook b2) 
    {
        return Float.compare(b1.getWeight(), b2.getWeight());
    }
}
