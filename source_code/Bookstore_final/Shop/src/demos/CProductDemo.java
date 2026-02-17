package demos;

import cargos.CProduct;
import date.CDate;
import exceptions.CargoException;
import exceptions.DateException;

public class CProductDemo extends ACObjectDemo
{
	public CProductDemo()
	{
		super(new CProduct());
		
		CProduct testShopProduct, 
				 testShopProduct2, 
				 testShopProduct3, 
				 testShopProduct4,
				 invalidShopProduct;
		
		try
		{
			testShopProduct = new CProduct();
			this.printConstructor("testShopProduct", "");
			System.out.println("testShopProduct = [" + testShopProduct + "]");
		
			System.out.println();
		
			testShopProduct2 = new CProduct("ean222555666", "24.11.2025", 10, 5, "Dlugopisy", "Pisak Sp. z o.o", "A56L2", "31.05.2025");
			this.printConstructor("testShopProduct2", "\"ean222555666\", \"24.11.2025\", 1, 130, \"Dlugopisy\", \"Pisak Sp. z o.o\", \"A56L2\", \"31.05.2025\"");
			System.out.println("testShopProduct2 = [" + testShopProduct2 + "]");
		
			System.out.println();
		
			testShopProduct3 = new CProduct("ean333666777", "28.2.2025", 20, 10, "Dlugopisy", "PapierNozyce Sp. z o.o", "A56L3", "15.11.2024");
			this.printConstructor("testShopProduct3", "\"ean333666777\", \"28.2.2025\", 20, 10, \"Dlugopisy\", \"PapierNozyce Sp. z o.o\", \"A56L3\", \"15.11.2024\"");
			System.out.println("testShopProduct3 = [" + testShopProduct3 + "]");
		
			System.out.println();
		
			testShopProduct3 = new CProduct(testShopProduct2);
			this.printConstructor("testShopProduct3", "testShopProduct2");
			System.out.println("testShopProduct3 = [" + testShopProduct3 + "]");
		
			System.out.println("testShopProduct3.equals(testShopProduct2) = " 
			+ testShopProduct3.equals(testShopProduct2));
			
			System.out.println();
			
			testShopProduct4 = new CProduct(testShopProduct3);
			this.printConstructor("testShopProduct4", "testShopProduct3");
			
			System.out.println("testShopProduct4.equals(testShopProduct3) = " 
					+ testShopProduct4.equals(testShopProduct3));
			
			System.out.println("testShopProduct4.setCategory(\"Teczki\");");
			testShopProduct4.setCategory("Teczki");
			
			System.out.println("testShopProduct4.equals(testShopProduct3) = " 
					+ testShopProduct4.equals(testShopProduct3));
			
			
			System.out.println();
		
			testShopProduct2 = new CProduct();
			this.printConstructor("testShopProduct2", "");
			System.out.println("testShopProduct2 = [" + testShopProduct2 + "]");
			System.out.println("testShopProduct3 = [" + testShopProduct3 + "]");
			
			System.out.println("testShopProduct3.equals(testShopProduct2) = " 
					+ testShopProduct3.equals(testShopProduct2));
		
			System.out.println();
		
			System.out.println();
			System.out.println("Getters presentation:");
			System.out.println("testShopProduct3.getIdentifier() = " + testShopProduct3.getIdentifier());
			System.out.println("testShopProduct3.getDateOfAcceptance() = " + testShopProduct3.getDateOfAcceptance());
			System.out.println("testShopProduct3.getAmount() = " + testShopProduct3.getAmount());
			System.out.println("testShopProduct3.getPrice() = " + testShopProduct3.getPrice());
			System.out.println("testShopProduct3.getCategory() = " + testShopProduct3.getCategory());
			System.out.println("testShopProduct3.getProducer() = "	+ testShopProduct3.getProducer());
			System.out.println("testShopProduct3.getModel() = " + testShopProduct3.getModel());
			System.out.println("testShopProduct3.getProductionDate() = " + testShopProduct3.getProductionDate());
		
			System.out.println();
			System.out.println("Setters presentation:");
		
			System.out.println("testShopProduct3.setIdentifier(\"ean_pl123555\");");
			testShopProduct3.setIdentifier("ean_pl123555");
		
			testShopProduct3.setDateOfAcceptance(new CDate("31-1-2026"));
			System.out.println("testShopProduct3.setDateOfAcceptance(new CDate(\"31-1-2026\"));");
		
			testShopProduct3.setAmount(100);
			System.out.println("testShopProduct3.setAmount(100);");
		
			testShopProduct3.setPrice(800);
			System.out.println("testShopProduct3.setPrice(800);");
		
			testShopProduct3.setCategory("Zeszyty");
			System.out.println("testShopProduct3.setCategory(\"Zeszyty\");");
		
			testShopProduct3.setProducer("PHU Paradygmat");
			System.out.println("testShopProduct3.setProducer(\"PHU Paradygmat\");");
		
			testShopProduct3.setModel("AL22222");
			System.out.println("testShopProduct3.setModel(\"AL22222\");");
		
			testShopProduct3.setProductionDate(new CDate("30-9-2026"));
			System.out.println("testShopProduct3.setProductionDate(new CDate(\"30-9-2026\"));");
		
			System.out.println("testShopProduct3 = [" + testShopProduct3 + "]");
		
			System.out.println();
			System.out.println();
			
			this.printConstructor("invalidShopProduct", "\"ean333666777\", \"28.2.2025\", -6, 10, \"Dlugopisy\", \"PapierNozyce Sp. z o.o\", \"A56L3\", \"15.11.2024\"");
			invalidShopProduct = new CProduct("ean333666777", "28.2.2025", -6, 10, "Dlugopisy", "PapierNozyce Sp. z o.o", "A56L3", "15.11.2024");
			invalidShopProduct.decAmount();
		}
		catch(DateException | CargoException e)
		{
	    	 e.printStackTrace();
	    	 System.err.println();
		}
		
		try
		{
			this.printConstructor("invalidShopProduct", "\"ean333666777\", \"28.2.2025\", 25, -100, \"Dlugopisy\", \"PapierNozyce Sp. z o.o\", \"A56L3\", \"15.11.2024\"");
			invalidShopProduct = new CProduct("ean333666777", "28.2.2025", 25, -100, "Dlugopisy", "PapierNozyce Sp. z o.o", "A56L3", "15.11.2024");
		}
		catch(DateException | CargoException e)
		{
	    	e.printStackTrace();
	    	System.err.println();
		}
		
	}
}
