package exceptions;

public class LiteratureFactoryException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -77926459405608055L;


	public LiteratureFactoryException()
	{
		super();
	}
	
	public LiteratureFactoryException(String mess)
	{
		super(mess);
	}
	
	public LiteratureFactoryException(Exception e)
	{
		super(
				"\nException: Incorrect arguments were entered during object creation in factory:\n" +
				"What is more:\n" + 
			    "-------------\n" +
				e.getMessage() +
				"\n"
		     );
	}
	
	
	public static String getMessageForUnknownProductType(String type)
	{
		return  "\nException:\n"
				+ "An unknown product type was entered when creating the object at the factory.\n" 
				+ "type = " + type + "\n";
	}
}
