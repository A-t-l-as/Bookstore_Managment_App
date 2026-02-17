package demos;

import cargos.CBook;
import exceptions.LiteratureException;
import exceptions.BookException;
import exceptions.DateException;
import exceptions.CargoException;

public class CBookDemo extends ACObjectDemo
{
	public CBookDemo()
	{
		super(new CBook());
		
		CBook  testBook, 
			   testBook2, 
			   testBook3, 
			   testBook4, 
			   invalidBook;
		
		testBook = new CBook();
		this.printConstructor("testBook", "");
		System.out.println("testBook = [" + testBook + "]");
	
		System.out.println();
		
		try
		{
			testBook2 = new CBook("9788328737785", "24.11.2025", 40, 60, "Literatura piekna obca", "Tuza", "I", "23-07-2025", "Mistrz i Malgorzata", "Bulhakow Michail", 560, 23, 17, "9788328737785", 10, CBook.ENTypeOfCover.SOFT, 13.5f);
			this.printConstructor("testBook2", "\"9788328737785\", \"24.11.2025\", 40, 60, \"Literatura piekna obca\", \"Tuza\", \"I\", \"23-07-2025\", \"Mistrz i Malgorzata\", \"Bulhakow Michail\", 560, 23, 17, \"9788328737785\", 10, ENTypeOfCover.soft, 13.5f");
			System.out.println("testBook2 = [" + testBook2 + "]");
			
			testBook3 = new CBook("1243503400", "14.11.2025", 40, 30, "Kryminal, sensacja, thriller", "Tuza", "II", "23-06-2024", "Krolestwo", "Nesbo Jo", 480, 20, 13, "9788327170316", 3, CBook.ENTypeOfCover.HARD, 15.5f);
			this.printConstructor("testBook3", "\"1243503400\", \"14.11.2025\", 40, 30, \"Kryminal, sensacja, thriller\", \"Tuza\", \"II\", \"23-06-2024\", \"Krolestwo\", \"Nesbo Jo\", 480, 20, 13, \"9788327170316\", 3, ENTypeOfCover.hard, 15.5f");
			System.out.println("testBook3 = [" + testBook3 + "]");
			
			System.out.println();
			
			testBook3 = new CBook(testBook2);
			this.printConstructor("testBook3", "testBook2");
			System.out.println("testBook3 = [" + testBook3 + "]");
			
			System.out.println("testBook3.equals(testBook2) = " 
					+ testBook3.equals(testBook2));
					
			System.out.println();
			
			testBook4 = new CBook(testBook3);
			this.printConstructor("testBook4", "testBook3");
					
			System.out.println("testBook4.equals(testBook3) = " 
					+ testBook4.equals(testBook3));
			
			System.out.println("testBook4.setAuthor(\"Zulczyk Jakub\");");
			testBook4.setAuthor("Zulczyk Jakub");
					
			System.out.println("testBook4.equals(testBook3) = " 
					+ testBook4.equals(testBook3));
					
			System.out.println();
	
			testBook2 = new CBook();
			this.printConstructor("testBook2", "");
			System.out.println("testBook2 = [" + testBook2 + "]");
			System.out.println("testBook3 = [" + testBook3 + "]");
		
			System.out.println("testBook2.equals(testBook3) = " 
					+ testBook2.equals(testBook3));
			
			System.out.println();
			System.out.println("Getters presentation:");
			System.out.println("testBook3.getDepth() = " + testBook3.getDepth());
			System.out.println("testBook3.getWeight() = " + testBook3.getWeight());
			System.out.println("testBook3.getTypeOfCover() = " + testBook3.getTypeOfCover());
		
			System.out.println();
			System.out.println("Setters presentation:");
		
			System.out.println("testBook3.setDepth(30);");
			testBook3.setDepth(30);
		
			testBook3.setWeight(5.6f);
			System.out.println("testBook3.setWeight(5.6f);");
		
			testBook3.setTypeOfCover(CBook.ENTypeOfCover.INVALID);
			System.out.println("testBook3.setTypeOfCover(ENTypeOfCover.invalid);");
		
			System.out.println("testBook3 = [" + testBook3 + "]");
		
			System.out.println();
			System.out.println();
			
			this.printConstructor("invalidBook", "\"1243503400\", \"14.11.2025\", 40, 30, \"Kryminal, sensacja, thriller\", \"Tuza\", \"II\", \"23-06-2024\", \"Krolestwo\", \"Nesbo Jo\", 480, 20, 13, \"9788327170316\", 3, ENTypeOfCover.hard, -15.5f");
			invalidBook = new CBook("1243503400", "14.11.2025", 40, 30, "Kryminal, sensacja, thriller", "Tuza", "II", "23-06-2024", "Krolestwo", "Nesbo Jo", 480, 20, 13, "9788327170316", 3, CBook.ENTypeOfCover.HARD, -15.5f);
			invalidBook.incAmount();
		}
		catch(
			    DateException 
			  | CargoException 
			  | LiteratureException 
			  | BookException e
			 )
		{
	    	e.printStackTrace();
	    	System.err.println();
		}
		
		
	}
}
