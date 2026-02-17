package cargos;

import java.util.Objects;

import date.CDate;
import exceptions.CargoException;
import exceptions.DateException;

// CProdukt
public class CProduct extends CCargo
{
//public:
	public CProduct()
	{
		super();
		this.setProduct(null, null, null, null);
	}
	
	public CProduct(
		            String argIdentifier, 
		            String argDateOfAcceptance, 
		            int argAmount,
		            int argPrice,
		            String argCategory,
	                String argProducer,
	                String argModel,
	                String argProdDate
		           ) 
		        		   throws DateException, CargoException
	{
		super(
			  argIdentifier, 
	          argDateOfAcceptance, 
	          argAmount,
	          argPrice
	         );
		
		
		this.setProduct(
						argCategory,
						argProducer,
						argModel,
						new CDate(argProdDate)
				       );
	}
	
	public CProduct(CProduct otherProduct) throws DateException, CargoException
	{
		super(otherProduct);
		
		this.setProduct(
						otherProduct.getCategory(),
						otherProduct.getProducer(),
						otherProduct.getModel(),
						new CDate(otherProduct.getProductionDate())
				       );
		
	}
	
	public String getCategory()
	{
		return this.category;
	}
	
	public void setCategory(String argCategory)
	{
		this.category = argCategory;
	}
	
	public String getProducer()
	{
		return this.producer;
	}
	
	public void setProducer(String argProducer)
	{
		this.producer = argProducer;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public void setModel(String argModel)
	{
		this.model = argModel;
	}
	
	public CDate getProductionDate()
	{
		return this.productionDate;
	}
	
	public void setProductionDate(CDate argProdDate)
	{
		this.productionDate = argProdDate;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + 
				", \"category\": \"" + category + "\"" +
				", \"producer\": \"" + producer + "\"" +
				", \"model\": \"" + model + "\"" +
				", \"productionDate\": \"" + productionDate + "\"";
	}
	
	@Override
	public String toCsv()
	{
		return super.toCsv() + ";" +
			   category + ";" +
			   producer + ";" +
			   model + ";" +
			   productionDate;    
	}
	
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(category, model, producer, productionDate);
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
		CProduct other = (CProduct) obj;
		
		return  Objects.equals(category, other.category) 
				&& 
				Objects.equals(model, other.model)
				&& 
				Objects.equals(producer, other.producer) 
				&& 
				Objects.equals(productionDate, other.productionDate);
	}

    @Override
    public int compareTo(CCargo argOther)
    {
        if ( !(argOther instanceof CProduct) )
        {
            return super.compareTo(argOther);
        }
    	
        CProduct other = (CProduct) argOther;
        
        if( !this.category.equals(other.category) )
        {
        	return this.category.compareTo(other.category);
        }
        
        if( !this.model.equals(other.model) )
        {
        	return this.model.compareTo(other.model);
        }
        
        if( !this.producer.equals(other.producer) )
        {
        	return this.producer.compareTo(other.producer);
        }
        
        if( !this.productionDate.equals(other.productionDate) )
        {
        	return this.productionDate.compareTo(other.productionDate);
        }
        
        return super.compareTo(argOther);
    }

//private:
	private String category; //kategoria
	private String producer; //producent
	private String model; //model
	private CDate productionDate; //data produkcji
	
	private void setProduct(
			                String argCategory,
			                String argProducer,
			                String argModel,
			                CDate argProdDate
			               )
	{
		this.setCategory(argCategory);
		this.setProducer(argProducer);
		this.setModel(argModel);
		this.setProductionDate(argProdDate);
	}
	
}
