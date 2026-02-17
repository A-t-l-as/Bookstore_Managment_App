package demos;

import cargos.CEBook;
import exceptions.CargoException;
import exceptions.DateException;
import exceptions.LiteratureException;
import exceptions.ELiteratureException;
import exceptions.EBookException;

public class CEBookDemo extends ACObjectDemo
{
	public CEBookDemo()
	{
		super(new CEBook());

		CEBook  testEBook, 
		        testEBook2, 
		        testEBook3, 
		        testEBook4, 
		        invalidEBook;
	
		testEBook = new CEBook();
		this.printConstructor("testEBook", "");
		System.out.println("testEBook = [" + testEBook + "]");

		System.out.println();
	
		try
		{
			testEBook2 = new CEBook("9788328737785", "24.11.2025", 40, 60, "Literatura piekna obca", "Tuza", "I", "23-07-2025", "Mistrz i Malgorzata", "Bulhakow Michail", 560, 23, 17, "9788328737785", 12.34f, "PDF", true, 562);
			this.printConstructor("testEBook2", "\"9788328737785\", \"24.11.2025\", 40, 60, \"Literatura piekna obca\", \"Tuza\", \"I\", \"23-07-2025\", \"Mistrz i Malgorzata\", \"Bulhakow Michail\", 560, 23, 17, \"9788328737785\", 12.34f, \"PDF\", true, 562");
			System.out.println("testEBook2 = [" + testEBook2 + "]");
		
			testEBook3 = new CEBook("1243503400", "14.11.2025", 40, 30, "Kryminal, sensacja, thriller", "Tuza", "II", "23-06-2024", "Krolestwo", "Nesbo Jo", 480, 20, 13, "9788327170316", 12.31f, "EPUB", false, 480);
			this.printConstructor("testEBook3", "\"1243503400\", \"14.11.2025\", 40, 30, \"Kryminal, sensacja, thriller\", \"Tuza\", \"II\", \"23-06-2024\", \"Krolestwo\", \"Nesbo Jo\", 480, 20, 13, \"9788327170316\", 12.31f, \"EPUB\", false, 480");
			System.out.println("testEBook3 = [" + testEBook3 + "]");
		
			System.out.println();
		
			testEBook3 = new CEBook(testEBook2);
			this.printConstructor("testEBook3", "testEBook2");
			System.out.println("testEBook3 = [" + testEBook3 + "]");
		
			System.out.println("testEBook3.equals(testEBook2) = " 
					+ testEBook3.equals(testEBook2));
				
			System.out.println();
		
			testEBook4 = new CEBook(testEBook3);
			this.printConstructor("testEBook4", "testEBook3");
				
			System.out.println("testEBook4.equals(testEBook3) = " 
					+ testEBook4.equals(testEBook3));
		
			System.out.println("testEBook4.setAuthor(\"Zulczyk Jakub\");");
			testEBook4.setAuthor("Zulczyk Jakub");
				
			System.out.println("testEBook4.equals(testEBook3) = " 
					+ testEBook4.equals(testEBook3));
				
			System.out.println();

			testEBook2 = new CEBook();
			this.printConstructor("testEBook2", "");
			System.out.println("testEBook2 = [" + testEBook2 + "]");
			System.out.println("testEBook3 = [" + testEBook3 + "]");
	
			System.out.println("testEBook2.equals(testEBook3) = " 
					+ testEBook2.equals(testEBook3));
		
			System.out.println();
			System.out.println("Getters presentation:");
			System.out.println("testEBook3.getIsScanned() = " + testEBook3.getIsScanned());
			System.out.println("testEBook3.getSizeOfFile() = " + testEBook3.getSizeOfFile());
			System.out.println("testEBook3.getFileExtension() = " + testEBook3.getFileExtension());
			System.out.println("testEBook3.getTotalNumberOfPages() = " + testEBook3.getTotalNumberOfPages());
			
			System.out.println();
			System.out.println("Setters presentation:");
	
			System.out.println("testEBook3.setIsScanned(false);");
			testEBook3.setIsScanned(false);
			
			System.out.println("testEBook3.setSizeOfFile(350);");
			testEBook3.setSizeOfFile(350);
	
			testEBook3.setFileExtension("DVI");
			System.out.println("testEBook3.setFileExtension(\"DVI\");");
	
			testEBook3.setTotalNumberOfPages(200);
			System.out.println("testEBook3.setTotalNumberOfPages(200);");
	
			System.out.println("testEBook3 = [" + testEBook3 + "]");
	
			System.out.println();
			System.out.println();
		
			this.printConstructor("invalidEBook", "\"1243503400\", \"14.11.2025\", 40, 30, \"Kryminal, sensacja, thriller\", \"Tuza\", \"II\", \"23-06-2024\", \"Krolestwo\", \"Nesbo Jo\", 480, 20, 13, \"9788327170316\", -500, \"PDF\", false, -100");
			invalidEBook = new CEBook("1243503400", "14.11.2025", 40, 30, "Kryminal, sensacja, thriller", "Tuza", "II", "23-06-2024", "Krolestwo", "Nesbo Jo", 480, 20, 13, "9788327170316", -500, "PDF", false, -100);
			invalidEBook.incAmount();
		}
		catch(
			 DateException 
			  | CargoException 
			  | LiteratureException 
			  | ELiteratureException
			  | EBookException e
			 )
		{
			e.printStackTrace();
			System.err.println();
		}

	}
	
}
