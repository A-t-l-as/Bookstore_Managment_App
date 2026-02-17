package exceptions;

public class MoneySafeException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1725047984747571872L;

	public MoneySafeException()
	{
		super();
	}
	
	public MoneySafeException(String mess)
	{
		super(mess);
	}
}
