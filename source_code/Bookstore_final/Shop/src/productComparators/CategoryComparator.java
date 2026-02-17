package productComparators;

import java.util.Comparator;
import cargos.CProduct;

public class CategoryComparator implements Comparator<CProduct>
{
    @Override
    public int compare(CProduct p1, CProduct p2) 
    {
    	return p1.getCategory().compareTo( p2.getCategory() );
    }
}
