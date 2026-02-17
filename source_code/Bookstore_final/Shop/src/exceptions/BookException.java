package exceptions;

public class BookException extends ACMyException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2918881783741567165L;

	public BookException()
	{
		super();
	}
	
	public BookException(String mess)
	{
		super(mess);
	}
}
