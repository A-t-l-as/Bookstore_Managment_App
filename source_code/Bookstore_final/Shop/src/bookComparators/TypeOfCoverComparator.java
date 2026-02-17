package bookComparators;

import java.util.Comparator;
import cargos.CBook;

public class TypeOfCoverComparator implements Comparator<CBook>
{
    @Override
    public int compare(CBook b1, CBook b2) 
    {
        return b1.getTypeOfCover().compareTo( b2.getTypeOfCover() );
    }
}