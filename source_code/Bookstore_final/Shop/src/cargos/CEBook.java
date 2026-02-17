package cargos;

import java.util.Objects;

import exceptions.CargoException;
import exceptions.DateException;
import exceptions.EBookException;
import exceptions.ELiteratureException;
import exceptions.LiteratureException;

public final class CEBook extends CELiterature
{
//public:
	
	public CEBook()
	{
		super();
		this.setEBookToDefault();
	}
	
	public CEBook(
	 			  String argIdentifier, 
	 			  String argDateOfAcceptance, 
	 			  int argAmount,
	 			  int argPrice,
	 			  
	 			  String argCategory,
	 			  String argProducer,
	 			  String argModel,
	 			  String argProdDate,

	 			  String argTitle,
	 			  String argAuthor,
	 			  long argNumberOfPages,
	 			  int argHeight,
	 			  int argWidth,
	 			  String argIsbn,
	 
	 			  float argSizeOfFile,
	 			  String argFileExtension,
	 			  
	 			  boolean argIsScanned,
	 			  long argTotalNumberOfPages
		         ) 
		        		 throws DateException, CargoException, LiteratureException,
		        		        ELiteratureException, EBookException
	{
		super(
	 		  argIdentifier, 
	 		  argDateOfAcceptance, 
	 	      argAmount,
	 		  argPrice,
	 		  argCategory,
	 		  argProducer,
	 		  argModel,
	 		  argProdDate,

	 		  argTitle,
	 		  argAuthor,
	 		  argNumberOfPages,
	 		  argHeight,
	 		  argWidth,
	 		  argIsbn,
	 
	 		  argSizeOfFile,
	 		  argFileExtension
			 );
		
		try
		{
			this.setEBook(argIsScanned, argTotalNumberOfPages);
		}
		catch(EBookException ebe)
		{
			throw 
			new 
			EBookException
			(
				EBookException.getMessageForContructor(ebe.getMessage())
			);
		}
	}

	
	public CEBook(CEBook otherEBook) 
			throws DateException, CargoException, LiteratureException, 
			       ELiteratureException, EBookException
	{
		super(otherEBook);
		
		try
		{
			this.setEBook(otherEBook.getIsScanned(), otherEBook.getTotalNumberOfPages());
		}
		catch(EBookException ebe)
		{
			throw 
			new 
			EBookException
			(
				EBookException.getMessageForContructor(ebe.getMessage())
			);
		}
	}
	
	public CEBook(CELiterature otherELiterature) 
			throws DateException, CargoException, LiteratureException, 
			       ELiteratureException
	{
		super(otherELiterature);
		this.setEBookToDefault();
	}
	
	
	public boolean getIsScanned()
	{
		return this.isScanned;
	}
	
	public void setIsScanned(boolean argIsScanned)
	{
		this.isScanned = argIsScanned;
	}
	
	public long getTotalNumberOfPages()
	{
		return this.totalNumberOfPages;
	}
	
	public void setTotalNumberOfPages(long argTotalNumberOfPages) throws EBookException
	{
		if(argTotalNumberOfPages < 0)
		{
			throw 
			new 
			EBookException
			(
				EBookException.getMessageForNegativeValueInSetter
				("totalNumberOfPages", argTotalNumberOfPages, "EBook")
			);
		}
		
		this.totalNumberOfPages = argTotalNumberOfPages;
	}
	
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(isScanned, totalNumberOfPages);
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CEBook other = (CEBook) obj;
		return isScanned == other.isScanned && totalNumberOfPages == other.totalNumberOfPages;
	}

	@Override
	public String toString()
	{
		return super.toString() + 
			   ", \"isScanned\": " + isScanned + 
			   ", \"totalNumberOfPages\": " + totalNumberOfPages;
	}
	
	@Override
	public String toCsv()
	{
		return super.toCsv() + ";" +
			   isScanned + ";" +
			   totalNumberOfPages;
	}


    @Override
    public int compareTo(CCargo argOther)
    {
    	int resultOfComparingELiterature = super.compareTo(argOther);
    	
        if (resultOfComparingELiterature != 0)
        {
            return resultOfComparingELiterature;
        }
    	
        CEBook other = (CEBook) argOther;
    	
        if( this.isScanned != other.isScanned )
        {
        	return Boolean.compare(this.isScanned, other.isScanned);
        }
        
        return Long.compare(this.totalNumberOfPages, other.totalNumberOfPages);
    }
	
	

//private:
	private boolean isScanned;
	private long totalNumberOfPages;
	
	/*
	 Niektore ksiazki mozna pobrac w formie pdf, w ktorych pierwsza i ostatnia
	 strona sa okladkami, natomiast te wewnatrz sa rzeczywistymi stronami ksiazki.
	 Na niektorych stronach internetowych mamy informacje o ilosci wszystkich stron w ksiazce
	 wraz z okladkami i dodatkowymi wstepnymi bialymi stronami lub po prostu strona podaje 
	 ilosc stron wewnatrz bez okladki i bez dodatkowych stron.
	 
	 W takim wypadku aby odroznic ile rzeczywiscie jest stron to pole totalNumerOfPages
	 przechowuje wartosc wszystkich stron w pliu pdf lub epub, natomiast numberOfPages z 
	 CLiterature przechowuje rzeczywista ilosc stron w ksiazce fizycznej bez okladek.
	*/
	
	private void setEBook(boolean argIsScanned, long argTotalNumberOfPages) 
			throws EBookException
	{
		this.setIsScanned(argIsScanned);
		this.setTotalNumberOfPages(argTotalNumberOfPages);
	}
	
	private void setEBookToDefault()
	{
		try
		{
			this.setEBook(false, 0);
		}
		catch(EBookException ebe){}
	}
}
