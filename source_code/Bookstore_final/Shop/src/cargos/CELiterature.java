package cargos;

import java.util.Objects;

import exceptions.CargoException;
import exceptions.DateException;
import exceptions.ELiteratureException;
import exceptions.LiteratureException;

public class CELiterature extends CLiterature
{
//public:
	public CELiterature()
	{
		super();
		this.setELiteratureToDefault();
	}
	
	public CELiterature(
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
	   		 			String argFileExtension
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
			  argIsbn
			);
	
		try
		{
			this.setELiterature(argSizeOfFile, argFileExtension);
		}
		catch(ELiteratureException ele)
		{
			throw 
			new 
			ELiteratureException
			(
				ELiteratureException.getMessageForContructor(ele.getMessage())
			);
		}
	}
	
	public CELiterature(CELiterature otherELiterature) 
			throws DateException, CargoException, 
			       LiteratureException, ELiteratureException 
	{
		super(otherELiterature);
		
		try
		{
			this.setELiterature(
								otherELiterature.getSizeOfFile(), 
								otherELiterature.getFileExtension()
				           	   );
		}
		catch(ELiteratureException ele)
		{
			throw 
			new 
			ELiteratureException
			(
				ELiteratureException.getMessageForContructor(ele.getMessage())
			);
		}
		
	}
	
	public CELiterature(CLiterature otherLiterature) 
			throws DateException, CargoException, LiteratureException
	{
		super(otherLiterature);
		this.setELiteratureToDefault();
	}
	
	
	public float getSizeOfFile()
	{
		return this.sizeOfFile;
	}
	
	public void setSizeOfFile(float argSizeOfFile) throws ELiteratureException
	{
		if(argSizeOfFile < 0)
		{
			throw 
			new 
			ELiteratureException
			(
				ELiteratureException.getMessageForNegativeValueInSetter
				("sizeOfFile", argSizeOfFile, "ELiterature")
			);
		}
		
		this.sizeOfFile = argSizeOfFile;
	}
	
	public String getFileExtension()
	{
		return this.fileExtension;
	}
	
	public void setFileExtension(String argFileExtension)
	{
		this.fileExtension = argFileExtension;
	}
	

	@Override
	public String toString()
	{
		return  super.toString() + 
				", \"sizeOfFile\": " + sizeOfFile + 
				", \"fileExtension\": \"" + fileExtension + "\"";
	}
	
	@Override
	public String toCsv()
	{
		return  super.toCsv() + ";" +
				sizeOfFile + ";" +
				fileExtension;
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fileExtension, sizeOfFile);
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
		CELiterature other = (CELiterature) obj;
		
		return  Objects.equals(fileExtension, other.fileExtension) 
				&& 
				sizeOfFile == other.sizeOfFile;
	}

    @Override
    public int compareTo(CCargo argOther)
    {
    	int resultOfComparingLiterature = super.compareTo(argOther);
    	
        if (resultOfComparingLiterature != 0)
        {
            return resultOfComparingLiterature;
        }
    	
        CELiterature other = (CELiterature) argOther;
    	
        if( this.sizeOfFile != other.sizeOfFile )
        {
        	return Float.compare(this.sizeOfFile, other.sizeOfFile);
        }
        
        return this.fileExtension.compareTo(other.fileExtension);
    }
	
	
	
//private:
	private float sizeOfFile;
	private String fileExtension;
	
	private void setELiterature(float argSizeOfFile, String argFileExtension)
			throws ELiteratureException
	{
		this.setSizeOfFile(argSizeOfFile);
		this.setFileExtension(argFileExtension);
	}
	
	private void setELiteratureToDefault()
	{
		try
		{
			this.setELiterature(0, null);
		}
		catch(ELiteratureException ele){}
	}
	
	
}
