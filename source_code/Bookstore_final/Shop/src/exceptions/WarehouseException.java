package exceptions;

import java.nio.file.Path;

public class WarehouseException extends Exception
{
	/**
	 *  Generuje serial version UID za pomoca IDE bo mam warning
	 */
	private static final long serialVersionUID = -8327763383114336195L;


	public WarehouseException()
	{
		super();
	}
	
	public WarehouseException(String mess)
	{
		super(mess);
	}
	
	public WarehouseException(LiteratureFactoryException e, Path p)
	{
		super(
				"\nException: The file being loaded with the path:\n" +
				p + "\n" +
				"Containts invalid data...\n" + 
				"What is more:\n" + 
			    "-------------\n" +
				e.getMessage() +
				"\n"
		     );
	}
	
	
	public static String getMessageForSellProductsFromList(String ean)
	{
		return "*************************************************\n" +
			   "The item specified in the list is out of stock.\n" + 
			   "The sale will continue, but the product with EAN:\n" +
				ean + " will be omitted.\n";
	}
	
}
