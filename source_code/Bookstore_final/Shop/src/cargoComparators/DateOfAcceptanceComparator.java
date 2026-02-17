package cargoComparators;

import java.util.Comparator;
import cargos.CCargo;

public class DateOfAcceptanceComparator implements Comparator<CCargo>
{
    @Override
    public int compare(CCargo c1, CCargo c2) 
    {
        return c1.getDateOfAcceptance().compareTo( c2.getDateOfAcceptance() );
    }
}