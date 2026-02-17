package productComparators;

import java.util.Comparator;
import cargos.CProduct;

public class ModelComparator implements Comparator<CProduct>
{
    @Override
    public int compare(CProduct p1, CProduct p2) 
    {
    	return p1.getModel().compareTo( p2.getModel() );
    }
}