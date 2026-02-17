package cargoComparators;

import java.util.Comparator;
import cargos.CCargo;

public class IdentifierComparator implements Comparator<CCargo>
{
    @Override
    public int compare(CCargo c1, CCargo c2) 
    {
        return c1.getIdentifier().compareTo(  c2.getIdentifier()  );
    }
}
