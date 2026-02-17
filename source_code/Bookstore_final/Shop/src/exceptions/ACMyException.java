package exceptions;

public abstract class ACMyException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7524296330384003725L;

	public ACMyException()
	{
		super();
	}
	
	public ACMyException(String mess)
	{
		super(mess);
	}
	
	public static String getMessageForContructor(String about)
	{
		return   "\nException: Incorrect arguments were entered during object initialisation:\n" +
				   "What is more:\n" + 
				   "-------------\n" +
				    about + "\n";
   	                
	}
	
	public static <T> String getMessageForNegativeValueInSetter(
																String valueName, 
																T value, 
																String objName
															   )
	{
		return   "\nException: Incorrect argument in setter!\n" + 
		         "Value: " + valueName + " = " + value + "\n" +
		         "About:\n" +
		         "The " + valueName + " of " + objName + " cannot be negative!\n";
	}
}
