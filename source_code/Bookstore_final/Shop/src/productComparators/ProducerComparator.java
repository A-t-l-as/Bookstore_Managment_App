package productComparators;

import java.util.Comparator;
import cargos.CProduct;

public class ProducerComparator implements Comparator<CProduct>
{
    @Override
    public int compare(CProduct p1, CProduct p2) 
    {
    	return p1.getProducer().compareTo( p2.getProducer() );
    }
}