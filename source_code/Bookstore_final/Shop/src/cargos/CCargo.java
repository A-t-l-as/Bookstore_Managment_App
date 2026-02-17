package cargos;

import java.util.Objects;

import date.CDate;
import exceptions.CargoException;
import exceptions.DateException;

// CTowar
public class CCargo implements Comparable<CCargo>
{
//public:
	
	public CCargo()
	{
		try 
		{ 
			this.setCargo(null, null, 0, 0); 
		} 
		catch(CargoException ce)
		{ /* nothing to do because its default constructor */ }
	}
	
	public CCargo(
			      String argIdentifier, 
			      String argDateOfAcceptance, 
			      int argAmount,
			      int argPrice
			      ) 
			    		  throws DateException, CargoException
	{	
		try
		{
			this.setCargo(
						  argIdentifier, 
						  new CDate(argDateOfAcceptance), 
				          argAmount, 
				          argPrice
				         );
			
		}
		catch(CargoException ce)
		{
			throw 
			new 
			CargoException
			(
				CargoException.getMessageForContructor(ce.getMessage())
			);
		}
	}
	
	public CCargo(CCargo otherCargo) throws DateException, CargoException
	{
		
		try
		{
			this.setCargo(
				          otherCargo.getIdentifier(), 
				          new CDate(otherCargo.getDateOfAcceptance()),
				          otherCargo.getAmount(), 
				          otherCargo.getPrice()
				         );
		}
		catch(CargoException ce)
		{
			throw 
			new 
			CargoException
			(
				CargoException.getMessageForContructor(ce.getMessage())
			);
		}
		
	}
	
	public String getIdentifier() 
	{ 
		return this.identifier;
	}
	
	public void setIdentifier(String argIdentifier)
	{
		this.identifier = argIdentifier;
	}
	
	public CDate getDateOfAcceptance()
	{
		return this.dateOfAcceptance;
	}
	
	public void setDateOfAcceptance(CDate argDateOfAcceptance)
	{
		this.dateOfAcceptance = argDateOfAcceptance;
	}
	
	public void incAmount()
	{
		++this.amount;
	}
	
	public void decAmount()
	{
		--this.amount;
	}
	
	public void addToAmount(int value)
	{
		this.amount += value;
	}
	
	public void subFromAmount(int value)
	{
		this.amount -= value;
	}
	
	//-------------------------------------------------------
	// Metoda, ktora bezpiecznie odejmuje ze stanu zwracajac 
	// reszte ile zostalo jeszcze do odjecia.
	public int safeSubFromAmount(int value)
	{
		this.amount -= value;
		int result = 0;
		
		if(this.amount < 0)
		{
			result = Math.abs(this.amount);
			this.amount = 0;
		}
		
		return result;
	}
	
	public int getAmount()
	{
		return this.amount;
	}
	
	public void setAmount(int argAmount) throws CargoException
	{
		if(argAmount < 0)
		{
			throw 
			new 
			CargoException
			(
				CargoException
				.
				getMessageForNegativeValueInSetter("amount", argAmount, "cargo")
			);
		}
		
		this.amount = argAmount;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	public void setPrice(int argPrice) throws CargoException
	{
		if(argPrice < 0)
		{
			throw 
			new 
			CargoException
			(
				CargoException.getMessageForNegativeValueInSetter
				("price", argPrice, "cargo")
			);
		}
		
		this.price = argPrice;
	}
	
    @Override
    public int compareTo(CCargo other)
    {
        if( !this.identifier.equals(other.identifier) )
        {
        	return this.identifier.compareTo(other.identifier);
        }
        
        if( !this.dateOfAcceptance.equals(other.dateOfAcceptance) )
        {
        	return this.dateOfAcceptance.compareTo(other.dateOfAcceptance);
        }
        
        if( this.amount != other.amount )
        {
        	return Integer.compare(this.amount, other.amount);
        }
        
        return Integer.compare(this.price, other.price);
    }
	
	
	
	@Override
	public String toString() 
	{
		return "\"identifier\": \"" + identifier + "\"" + 
			   ", \"dateOfAcceptance\": " + "\"" + dateOfAcceptance + "\"" +
			   ", \"amount\": " + amount + 
			   ", \"price\": " + price ;
	}

	public String toCsv()
	{
		return identifier + ";" + 
			   dateOfAcceptance + ";" +
			   amount + ";" +
			   price;
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(amount, dateOfAcceptance, identifier, price);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CCargo other = (CCargo) obj;
		return amount == other.amount && Objects.equals(dateOfAcceptance, other.dateOfAcceptance)
				&& Objects.equals(identifier, other.identifier) && price == other.price;
	}


//private:
	private String identifier; //identyfikator
	private CDate dateOfAcceptance; //data przyjecia
	private int amount; //ilosc
	private int price; //cena
	
	private void setCargo(
		                  String argIdentifier, 
		                  CDate argDateOfAcceptance, 
		                  int argAmount,
		                  int argPrice
		                 ) 
		                		 throws CargoException
	{
		this.setIdentifier(argIdentifier);
		this.setDateOfAcceptance(argDateOfAcceptance);
		this.setAmount(argAmount);
		this.setPrice(argPrice);
	}

}
