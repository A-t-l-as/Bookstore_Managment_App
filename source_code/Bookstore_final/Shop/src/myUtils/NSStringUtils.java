package myUtils;

public class NSStringUtils
{
	public static boolean startsWithIgnoreCase(String str1, String str2)
	{	
		return str1.toUpperCase().startsWith(  str2.toUpperCase() );
	}
	
    public static String truncate(String text, int maxLength)
    {
        if (text.length() <= maxLength)
        {
            return text;
        }
        
        return text.substring(0, maxLength - 3) + "...";
    }
    
    public static int compareAuthors(String thisAuthor, String otherAuthor)
    {
    	String[] authorParts      = thisAuthor.split(" ", 2);
    	String[] otherAuthorParts = otherAuthor.split(" ", 2);
    	
    	String authorSurname = authorParts[0];
    	String authorName    = authorParts[1];
    	
    	String otherAuthorSurname = otherAuthorParts[0];
    	String otherAuthorName    = otherAuthorParts[1];
    	
        if( !authorSurname.equals(otherAuthorSurname) )
        {
        	return authorSurname.compareTo(otherAuthorSurname);
        }
        
        return authorName.compareTo(otherAuthorName);
    }
}
