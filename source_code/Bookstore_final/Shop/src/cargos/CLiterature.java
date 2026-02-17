package cargos;

import java.util.Objects;

import exceptions.CargoException;
import exceptions.DateException;
import exceptions.LiteratureException;
import myUtils.NSStringUtils;

public class CLiterature extends CProduct
{
//public:
	public CLiterature()
	{
		super();
		
		try
		{
			this.setLiterature(null, null, 0, 0, 0, null);
		}
		catch(LiteratureException le){}
	}
	
	public CLiterature(
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
            		   String argIsbn
					  ) 
							  throws DateException, CargoException, LiteratureException
	{
		super(
	          argIdentifier, 
	          argDateOfAcceptance, 
	          argAmount,
	          argPrice,
	          argCategory,
	          argProducer,
	          argModel,
	          argProdDate
		     );


		try
		{
			this.setLiterature(
           		   		    	argTitle,
           		   		    	argAuthor,
           		   		    	argNumberOfPages,
           		   		    	argHeight,
           		   		    	argWidth,
           		   		    	argIsbn
						  	  );
		}
		catch(LiteratureException le)
		{
			throw 
			new 
			LiteratureException
			(
				LiteratureException.getMessageForContructor(le.getMessage())
			);
		}
	}
	
	
	public CLiterature(CLiterature otherLiterature) 
			throws DateException, CargoException, LiteratureException
	{
		super(otherLiterature);
		
		try
		{
			this.setLiterature(
								otherLiterature.getTitle(),
								otherLiterature.getAuthor(),
								otherLiterature.getNumberOfPages(),
								otherLiterature.getHeight(),
								otherLiterature.getWidth(),
								otherLiterature.getIsbn()
				       	  	  );
		}
		catch(LiteratureException le)
		{
			throw 
			new 
			LiteratureException
			(
				LiteratureException.getMessageForContructor(le.getMessage())
			);
		}
	}
	
	
	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String argTitle)
	{
		this.title = argTitle;
	}

	public String getAuthor()
	{
		return this.author;
	}

	public void setAuthor(String argAuthor)
	{
		this.author = argAuthor;
	}

	public long getNumberOfPages()
	{
		return this.numberOfPages;
	}

	public void setNumberOfPages(long argNumberOfPages) throws LiteratureException
	{
		if(argNumberOfPages < 0)
		{
			throw 
			new 
			LiteratureException
			(
				LiteratureException.getMessageForNegativeValueInSetter
				("numberOfPages", argNumberOfPages, "literature")
			);
		}
		
		this.numberOfPages = argNumberOfPages;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void setHeight(int argHeight) throws LiteratureException
	{
		if(argHeight < 0)
		{
			throw 
			new 
			LiteratureException
			(
				LiteratureException.getMessageForNegativeValueInSetter
				("height", argHeight, "literature")
			);
		}
		
		this.height = argHeight;
	}

	public int getWidth()
	{
		return this.width;
	}

	public void setWidth(int argWidth) throws LiteratureException
	{
		if(argWidth < 0)
		{
			throw 
			new 
			LiteratureException
			(
				LiteratureException.getMessageForNegativeValueInSetter
				("width", argWidth, "literature")
			);
		}
		
		this.width = argWidth;
	}

	public String getIsbn()
	{
		return this.isbn;
	}

	public void setIsbn(String argIsbn)
	{
		this.isbn = argIsbn;
	}

    @Override
    public int compareTo(CCargo argOther)
    {
        if (!(argOther instanceof CLiterature))
        {
            return super.compareTo(argOther);
        }
    	
        CLiterature other = (CLiterature) argOther;
        
        final int authorsCompareResult = NSStringUtils.compareAuthors(this.author, other.author);
        
        if( authorsCompareResult != 0 )
        {
        	return authorsCompareResult;
        }
        
        if( !this.title.equals(other.title) )
        {
        	return this.title.compareTo(other.title);
        }
        
        if( !this.isbn.equals(other.isbn) )
        {
        	return this.isbn.compareTo(other.isbn);
        }
        
        if( this.numberOfPages != other.numberOfPages )
        {
        	return Long.compare(this.numberOfPages, other.numberOfPages);
        }
        
        if( this.width != other.width )
        {
        	return Integer.compare(this.width, other.width);
        }
        
        if( this.height != other.height )
        {
        	return Integer.compare(this.height, other.height);
        }
        
        return super.compareTo(argOther);
    }
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(author, height, isbn, numberOfPages, title, width);
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
		CLiterature other = (CLiterature) obj;
		
		return  Objects.equals(author, other.author) 
				&& 
				height == other.height 
				&& 
				Objects.equals(isbn, other.isbn)
				&& 
				numberOfPages == other.numberOfPages 
				&& 
				Objects.equals(title, other.title) 
				&& 
				width == other.width;
	}

	@Override
	public String toString() 
	{
		return super.toString() + 
			   ", \"title\": \"" + title + "\"" +
			   ", \"author\": \"" + author + "\"" +
			   ", \"numberOfPages\": " + numberOfPages + 
			   ", \"height\": " + height + 
			   ", \"width\": " + width + 
			   ", \"isbn\": \"" + isbn + "\"";
	}
	
	@Override
	public String toCsv() 
	{
		return super.toCsv() + ";" +
			   title + ";" +
			   author + ";" +
			   numberOfPages + ";" +
			   height + ";" +
			   width + ";" +
			   isbn;
	}


//private:
	private String title;
	private String author;
	
	private long numberOfPages;
	
	private int height;
	private int width;
	
	private String isbn;
	
	
	private void setLiterature(
			  					String argTitle,
			  					String argAuthor,
			  					long argNumberOfPages,
			  					int argHeight,
			  					int argWidth,
			  					String argIsbn
			 				  )
								throws LiteratureException
	{
		this.setTitle(argTitle);
		this.setAuthor(argAuthor);

		this.setNumberOfPages(argNumberOfPages);

		this.setHeight(argHeight);
		this.setWidth(argWidth);

		this.setIsbn(argIsbn);
	}
	
	
}
