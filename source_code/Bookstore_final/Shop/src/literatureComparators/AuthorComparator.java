package literatureComparators;

import java.util.Comparator;
import cargos.CLiterature;
import myUtils.NSStringUtils;

public class AuthorComparator implements Comparator<CLiterature>
{
    @Override
    public int compare(CLiterature l1, CLiterature l2) 
    {
    	return NSStringUtils.compareAuthors(l1.getAuthor(), l2.getAuthor());
    }
}