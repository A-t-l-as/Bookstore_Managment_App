package factories;

import cargos.CEBook;
import cargos.CBook;
import cargos.CLiterature;
import cargos.CELiterature;
import cargos.CAudioBook;
import exceptions.BookException;
import exceptions.CargoException;
import exceptions.DateException;
import exceptions.LiteratureException;
import exceptions.ELiteratureException;
import exceptions.EBookException;
import exceptions.LiteratureFactoryException;

import java.time.LocalTime;


public class CLiteratureFactory
{
	public CLiteratureFactory(String input) throws LiteratureFactoryException
	{
		if(input.isEmpty() || input == null)
			throw new LiteratureFactoryException
					  ("Input String in LiteratureFactory is empty or null!!");
		
		this.parts = input.split(";");
		
		try
		{
			this.objType = ENFactoryObjType.valueOf(parts[0]);
		}
		catch(Exception e)
		{
			this.objType = ENFactoryObjType.INVALID;
		}
	}
	
	public ENFactoryObjType getObjType()
	{
		return this.objType;
	}
	
	public CLiterature createObj() throws LiteratureFactoryException
	{
		CLiterature tempLiterature;
		CELiterature tempELiterature;
		
		try
		{
			tempLiterature = createLiteratureFromParts();
			
			switch(objType)
			{
				case ENFactoryObjType.CBOOK:
					return createBookFromLiteratureAndParts(tempLiterature);
		
				case ENFactoryObjType.CEBOOK:
					 tempELiterature = 
						createELiteratureFromLiteratureAndParts(tempLiterature);
					
					return createEBookFromELiteratureAndParts(tempELiterature);
					
				case ENFactoryObjType.CAUDIOBOOK:
					 tempELiterature = 
						createELiteratureFromLiteratureAndParts(tempLiterature);
				
					return createAudioBookFromELiteratureAndParts(tempELiterature);
					
				default:
				    throw new LiteratureFactoryException
				    (
				    	LiteratureFactoryException.getMessageForUnknownProductType(parts[0])
				    );
			}
		
		}
		catch(
			    DateException 
			  | CargoException 
			  | LiteratureException 
			  | BookException 
			  | ELiteratureException
			  | EBookException e
			 )
		{		
			throw new LiteratureFactoryException(e);
		}
	
	}
	
	
	public enum ENFactoryObjType
	{
		INVALID,
		CBOOK,
		CEBOOK,
		CAUDIOBOOK
	}
	
//static:
	
	public static CLiterature createSaveCopyWithType(CLiterature original) 
		    throws LiteratureFactoryException
		{
		    
			try
			{
				if (original instanceof CBook)
				{
					return new CBook((CBook) original);
				} 
				else if (original instanceof CEBook)
				{
					return new CEBook((CEBook) original);
				} 
				else if (original instanceof CAudioBook)
				{
					return new CAudioBook((CAudioBook) original);
				}

				return new CLiterature(original);
		    
			}
			catch(
				    DateException 
				  | CargoException 
				  | LiteratureException 
				  | BookException 
				  | ELiteratureException
				  | EBookException e
				 )
			{		
				throw new LiteratureFactoryException(e);
			}
			
		}
	
	
//private:
	private String[] parts;
	private ENFactoryObjType objType;
	
	private CLiterature createLiteratureFromParts() 
			throws DateException, CargoException, LiteratureException
	{
		int amount 			= Integer.parseInt(parts[3]), 
			price 			= Integer.parseInt(parts[4]),
			height			= Integer.parseInt(parts[12]),
			width			= Integer.parseInt(parts[13]);
				
		long numberOfPages 	= Long.parseLong(parts[11]);
			
			
		return new CLiterature(parts[1], parts[2], amount, price, 
			        			parts[5], parts[6], parts[7], parts[8], parts[9],
			        			parts[10], numberOfPages, height, width, parts[14]);		
	}
	
	
	private CBook createBookFromLiteratureAndParts(CLiterature lit)
			throws DateException, CargoException, LiteratureException, BookException
	{
		int depth 						= Integer.parseInt(parts[15]); 
		CBook.ENTypeOfCover typeOfCover = CBook.ENTypeOfCover.valueOf(parts[16]);
		float weight 					= Float.parseFloat(parts[17]);
	
		CBook result = new CBook( lit );
		result.setDepth(depth);
		result.setTypeOfCover(typeOfCover);
		result.setWeight(weight);
	
		return result;
	}
	

	private CELiterature createELiteratureFromLiteratureAndParts(CLiterature lit)
			throws DateException, CargoException, LiteratureException, ELiteratureException
	{
		float sizeOfFile = Float.parseFloat(parts[15]);
	
		CELiterature result = new CELiterature( lit );
		result.setSizeOfFile(sizeOfFile);
		result.setFileExtension(parts[16]);
	
		return result;
	}
	
	
	private CEBook createEBookFromELiteratureAndParts(CELiterature elit)
		throws DateException, CargoException, LiteratureException, 
		       ELiteratureException, EBookException
	{
		boolean isScanned 		= Boolean.parseBoolean(parts[17]);
		long totalNumberOfPages = Long.parseLong(parts[18]);
		
		CEBook result = new CEBook( elit );
		result.setIsScanned(isScanned);
		result.setTotalNumberOfPages(totalNumberOfPages);

		return result;
	}
	
	
	private CAudioBook createAudioBookFromELiteratureAndParts(CELiterature elit)
		throws DateException, CargoException, LiteratureException, 
			   ELiteratureException
	{
		LocalTime duration = LocalTime.parse(parts[17]);

		CAudioBook result = new CAudioBook( elit );
		result.setDuration(duration);
		result.setLector(parts[18]);

		return result;
	}
	
	
}
