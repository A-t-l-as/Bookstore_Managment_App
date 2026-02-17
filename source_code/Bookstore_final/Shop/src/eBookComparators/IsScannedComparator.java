package eBookComparators;

import java.util.Comparator;
import cargos.CEBook;

public class IsScannedComparator implements Comparator<CEBook>
{
    @Override
    public int compare(CEBook eb1, CEBook eb2) 
    {
    	return Boolean.compare( eb1.getIsScanned(), eb2.getIsScanned() );
    }
}
