package cargos;

import java.util.Objects;

import exceptions.BookException;
import exceptions.CargoException;
import exceptions.DateException;
import exceptions.LiteratureException;

public final class CBook extends CLiterature
{
//public:	
	
	public CBook()
	{
		super();
		this.setBookToDefault();
	}
	
	public CBook(
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
 		   		 
 		   		 int argDepth,
 		   		 ENTypeOfCover argTypeOfCover,
 		   		 float argWeight
			    ) 
					  throws DateException, CargoException, LiteratureException, BookException
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
		 	  argIsbn
		 	 );
		
		try
		{
			this.setBook(argDepth, argTypeOfCover, argWeight);
		}
		catch(BookException be)
		{
			throw 
			new 
			BookException
			(
				BookException.getMessageForContructor(be.getMessage())
			);
		}
	}
	
	public CBook(CBook otherBook) 
			throws DateException, CargoException, LiteratureException, BookException
	{
		super(otherBook);
		
		try
		{
			this.setBook
			(
				otherBook.getDepth(), 
				otherBook.getTypeOfCover(), 
				otherBook.getWeight()
			);
		}
		catch(BookException be)
		{
			throw 
			new 
			BookException
			(
				BookException.getMessageForContructor(be.getMessage())
			);
		}
	}
	
	public CBook(CLiterature otherLiterature) 
			throws DateException, CargoException, LiteratureException
	{
		super(otherLiterature);
		this.setBookToDefault();
	}
	
	public int getDepth() 
	{
		return this.depth;
	}
	
	public void setDepth(int argDepth) throws BookException
	{
		if(argDepth < 0)
		{
			throw 
			new 
			BookException
			(
				BookException.getMessageForNegativeValueInSetter
				("depth", argDepth, "book")
			);
		}
		
		this.depth = argDepth;
	}
	
	public ENTypeOfCover getTypeOfCover() 
	{
		return this.typeOfCover;
	}
	
	public void setTypeOfCover(ENTypeOfCover argTypeOfCover) 
	{
		this.typeOfCover = argTypeOfCover;
	}
	
	public float getWeight() 
	{
		return this.weight;
	}
	
	public void setWeight(float argWeight) throws BookException
	{
		if(argWeight < 0)
		{
			throw 
			new 
			BookException
			(
				BookException.getMessageForNegativeValueInSetter
				("weight", argWeight, "book")
			);
		}
		
		this.weight = argWeight;
	}
	
	@Override
	public String toString()
	{
		return super.toString() +
			   ", \"depth\": " + depth + 
			   ", \"typeOfCover\": \"" + typeOfCover + "\"" +
			   ", \"weight\": " + weight;
	}
	
	@Override
	public String toCsv()
	{
		return super.toCsv() + ";" +
			   depth + ";" +
			   typeOfCover + ";" +
			   weight;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(depth, typeOfCover, weight);
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
		CBook other = (CBook) obj;
		return depth == other.depth && typeOfCover == other.typeOfCover
				&& Float.floatToIntBits(weight) == Float.floatToIntBits(other.weight);
	}


    @Override
    public int compareTo(CCargo argOther)
    {
    	
    	int resultOfComparingLiterature = super.compareTo(argOther);
    	
        if (resultOfComparingLiterature != 0)
        {
            return resultOfComparingLiterature;
        }
    	
        CBook other = (CBook) argOther;
    	
        if( this.depth != other.depth )
        {
        	return Integer.compare(this.depth, other.depth);
        }
        
        if( !this.typeOfCover.equals(other.typeOfCover) )
        {
        	return this.typeOfCover.compareTo(other.typeOfCover);
        }
        
        return Float.compare(this.weight, other.weight);
    }
	
	
	public enum ENTypeOfCover
	{
		INVALID,
		SOFT,
		HARD
	}

//private:
	private int depth;
	private ENTypeOfCover typeOfCover;
	private float weight;
	
	private void setBook(
						 int depth,
						 ENTypeOfCover typeOfCover,
						 float weight
						) throws BookException
	{
		this.setDepth(depth);
		this.setTypeOfCover(typeOfCover);
		this.setWeight(weight);
	}
	
	private void setBookToDefault()
	{
		try
		{
			this.setBook(0, ENTypeOfCover.INVALID, 0.0f);
		}
		catch(BookException be){}
	}
	
}
