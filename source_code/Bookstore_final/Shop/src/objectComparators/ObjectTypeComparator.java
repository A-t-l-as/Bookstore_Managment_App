package objectComparators;

import java.util.Comparator;

public class ObjectTypeComparator implements Comparator<Object>
{
    @Override
    public int compare(Object o1, Object o2) 
    {
        return o1.getClass().getSimpleName().compareTo(  o2.getClass().getSimpleName()  );
    }
}