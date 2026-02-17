package cargos;

import java.time.LocalTime;
import java.util.Objects;

import exceptions.CargoException;
import exceptions.DateException;
import exceptions.ELiteratureException;
import exceptions.LiteratureException;

import myUtils.NSStringUtils;

public final class CAudioBook extends CELiterature
{

//public:
	public CAudioBook()
	{
		super();
		this.setAudioBook( LocalTime.of(0, 0, 0) , null);
	}
	
	
	public CAudioBook(
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
			  
			  		  LocalTime argDuration,
			  		  String argLector
	         		) 
	         			throws DateException, CargoException, 
	    				       LiteratureException, ELiteratureException 
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

		this.setAudioBook(argDuration, argLector);
	}
	
	public CAudioBook(CAudioBook otherAudioBook) 
		   throws DateException, CargoException, 
		          LiteratureException, ELiteratureException 
	{
		super(otherAudioBook);
		this.setAudioBook(otherAudioBook.getDuration(), otherAudioBook.getLector());
	}
	
	
	public CAudioBook(CELiterature otherELiterature) 
			   throws DateException, CargoException, 
			          LiteratureException, ELiteratureException 
	{
			super(otherELiterature);
			this.setAudioBook( LocalTime.of(0, 0, 0) , null);
	}
	
	
	public LocalTime getDuration()
	{
		return this.duration;
	}
	
	public void setDuration(LocalTime argDuration)
	{
		this.duration = argDuration;
	}
	
	public String getLector()
	{
		return this.lector;
	}
	
	public void setLector(String argLector)
	{
		this.lector = argLector;
	}
	
	
	@Override
	public String toString()
	{
		return super.toString() +
			   ", \"duration\": \"" + duration + "\"" +  
			   ", \"lector\": \"" + lector + "\"";
	}
	
	@Override
	public String toCsv()
	{
		return super.toCsv() + ";" +
			   duration + ";" +
			   lector;
	}


	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(duration, lector);
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
		CAudioBook other = (CAudioBook) obj;
		return Objects.equals(duration, other.duration) && Objects.equals(lector, other.lector);
	}

    @Override
    public int compareTo(CCargo argOther)
    {
    	int resultOfComparingELiterature = super.compareTo(argOther);
    	
        if (resultOfComparingELiterature != 0)
        {
            return resultOfComparingELiterature;
        }
    	
        CAudioBook other = (CAudioBook) argOther;
    	
        final int resultOfLectorCompare = NSStringUtils.compareAuthors(this.lector, other.lector);
        
        if( resultOfLectorCompare != 0 )
        {
        	return resultOfLectorCompare;
        }
        
        return this.duration.compareTo(other.duration);
    }

//private:
	private LocalTime duration;
	private String lector;
	
	private void setAudioBook(LocalTime argDuration, String argLector)
	{
		this.setDuration(argDuration);
		this.setLector(argLector);
	}
	
}
