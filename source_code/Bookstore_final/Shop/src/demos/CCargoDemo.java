package demos;

import cargos.CCargo;
import date.CDate;
import exceptions.CargoException;
import exceptions.DateException;

public class CCargoDemo extends ACObjectDemo
{
	public CCargoDemo()
	{
		super(new CCargo());
		
		CCargo  testShopCargo, 
				testShopCargo2, 
				testShopCargo3, 
				testShopCargo4, 
				invalidShopCargo;
		
		try
		{
			testShopCargo = new CCargo();
			this.printConstructor("testShopCargo", "");
			System.out.println("testShopCargo = [" + testShopCargo + "]");
		
			System.out.println();
		
			testShopCargo2 = new CCargo("abcdefgh", "24.11.2025", 1, 500);
			this.printConstructor("testShopCargo2", "\"abcdefgh\", \"24.11.2025\", 1, 500");
			System.out.println("testShopCargo2 = [" + testShopCargo2 + "]");
		
			System.out.println();
		
			testShopCargo3 = new CCargo("123456abc", "22.11.2025", 2, 1000);
			this.printConstructor("testShopCargo3", "\"123456abc\", \"22.11.2025\", 2, 1000");
			System.out.println("testShopCargo3 = [" + testShopCargo3 + "]");
		
			System.out.println();
			
			testShopCargo3 = new CCargo(testShopCargo2);
			this.printConstructor("testShopCargo3", "testShopCargo2");
			System.out.println("testShopCargo3 = [" + testShopCargo3 + "]");
			
			System.out.println("testShopCargo3.equals(testShopCargo2) = " 
					+ testShopCargo3.equals(testShopCargo2));
					
			System.out.println();
					
			testShopCargo4 = new CCargo(testShopCargo3);
			this.printConstructor("testShopCargo4", "testShopCargo3");
					
			System.out.println("testShopCargo4.equals(testShopCargo3) = " 
					+ testShopCargo4.equals(testShopCargo3));
					
			System.out.println("testShopCargo4.setIdentifier(\"LPM123456\");");
			testShopCargo4.setIdentifier("LPM123456");
					
			System.out.println("testShopCargo4.equals(testShopCargo3) = " 
					+ testShopCargo4.equals(testShopCargo3));
					
			System.out.println();
			
		
			testShopCargo2 = new CCargo();
			this.printConstructor("testShopCargo2", "");
			System.out.println("testShopCargo2 = [" + testShopCargo2 + "]");
			System.out.println("testShopCargo3 = [" + testShopCargo3 + "]");
		
			System.out.println("testShopCargo2.equals(testShopCargo3) = " 
					+ testShopCargo2.equals(testShopCargo3));
			
			System.out.println();
			System.out.println("Getters presentation:");
			System.out.println("testShopCargo3.getIdentifier() = " + testShopCargo3.getIdentifier());
			System.out.println("testShopCargo3.getDateOfAcceptance() = " + testShopCargo3.getDateOfAcceptance());
			System.out.println("testShopCargo3.getAmount() = " + testShopCargo3.getAmount());
			System.out.println("testShopCargo3.getPrice() = " + testShopCargo3.getPrice());
		
			System.out.println();
			System.out.println("Setters presentation:");
		
			System.out.println("testShopCargo3.setIdentifier(\"ean_pl123456\");");
			testShopCargo3.setIdentifier("ean_pl123456");
		
			testShopCargo3.setDateOfAcceptance(new CDate("1-12-2025"));
			System.out.println("testShopCargo3.setDateOfAcceptance(new CDate(\"1-12-2025\"));");
		
			testShopCargo3.setAmount(2000);
			System.out.println("testShopCargo3.setAmount(2000);");
		
			testShopCargo3.setPrice(3999);
			System.out.println("testShopCargo3.setPrice(3999);");
		
			System.out.println("testShopCargo3 = [" + testShopCargo3 + "]");
		
			System.out.println();
			System.out.println();
			
			this.printConstructor("invalidShopCargo", "\"123456abc\", \"22.11.2025\", -5, 1000");
			invalidShopCargo = new CCargo("123456abc", "22.11.2025", -5, 1000);
			invalidShopCargo.incAmount();
		}
		catch(DateException | CargoException e)
		{
	    	 e.printStackTrace();
	    	 System.err.println();
		}
		
		
		try
		{
			this.printConstructor("invalidShopCargo", "\"123456abc\", \"22.11.2025\", 20, -100");
			invalidShopCargo = new CCargo("123456abc", "22.11.2025", 20, -100);
		}
		catch(DateException | CargoException e)
		{
	    	e.printStackTrace();
	    	System.err.println();
		}
	}
}
