package demos;

import java.time.LocalTime;

import cargos.CAudioBook;
import exceptions.CargoException;
import exceptions.DateException;
import exceptions.ELiteratureException;
import exceptions.LiteratureException;

public class CAudioBookDemo extends ACObjectDemo
{
	public CAudioBookDemo()
	{
		super(new CAudioBook());

		CAudioBook  testAudioBook, 
					testAudioBook2, 
					testAudioBook3, 
					testAudioBook4, 
					invalidAudioBook;
	
		testAudioBook = new CAudioBook();
		this.printConstructor("testAudioBook", "");
		System.out.println("testAudioBook = [" + testAudioBook + "]");

		System.out.println();
	
		try
		{
			testAudioBook2 = new CAudioBook("9788328737785", "24.11.2025", 40, 60, "Literatura piekna obca", "Tuza", "I", "23-07-2025", "Mistrz i Malgorzata", "Bulhakow Michail", 0, 23, 17, "9788328737785", 12.34f, "MP3", LocalTime.of(16, 51, 0), "Jacek Gawron");
			this.printConstructor("testAudioBook2", "\"9788328737785\", \"24.11.2025\", 40, 60, \"Literatura piekna obca\", \"Tuza\", \"I\", \"23-07-2025\", \"Mistrz i Malgorzata\", \"Bulhakow Michail\", 0, 23, 17, \"9788328737785\", 12.34f, \"MP3\", LocalTime.of(16, 51, 0), \"Jacek Gawron\"");
			System.out.println("testAudioBook2 = [" + testAudioBook2 + "]");
		
			testAudioBook3 = new CAudioBook("1243503400", "14.11.2025", 40, 30, "Kryminal, sensacja, thriller", "Tuza", "II", "23-06-2024", "Krolestwo", "Nesbo Jo", 0, 20, 13, "9788327170316", 12.31f, "WAV", LocalTime.of(21, 46, 0), "Jan Kowalski");
			this.printConstructor("testAudioBook3", "\"1243503400\", \"14.11.2025\", 40, 30, \"Kryminal, sensacja, thriller\", \"Tuza\", \"II\", \"23-06-2024\", \"Krolestwo\", \"Nesbo Jo\", 0, 20, 13, \"9788327170316\", 12.31f, \"WAV\", LocalTime.of(21, 46, 0), \"Jan Kowalski\"");
			System.out.println("testAudioBook3 = [" + testAudioBook3 + "]");
		
			System.out.println();
		
			testAudioBook3 = new CAudioBook(testAudioBook2);
			this.printConstructor("testAudioBook3", "testAudioBook2");
			System.out.println("testAudioBook3 = [" + testAudioBook3 + "]");
		
			System.out.println("testAudioBook3.equals(testAudioBook2) = " 
					+ testAudioBook3.equals(testAudioBook2));
				
			System.out.println();
		
			testAudioBook4 = new CAudioBook(testAudioBook3);
			this.printConstructor("testAudioBook4", "testAudioBook3");
				
			System.out.println("testAudioBook4.equals(testAudioBook3) = " 
					+ testAudioBook4.equals(testAudioBook3));
		
			System.out.println("testAudioBook4.setAuthor(\"Zulczyk Jakub\");");
			testAudioBook4.setAuthor("Zulczyk Jakub");
				
			System.out.println("testAudioBook4.equals(testAudioBook3) = " 
					+ testAudioBook4.equals(testAudioBook3));
				
			System.out.println();

			testAudioBook2 = new CAudioBook();
			this.printConstructor("testAudioBook2", "");
			System.out.println("testAudioBook2 = [" + testAudioBook2 + "]");
			System.out.println("testAudioBook3 = [" + testAudioBook3 + "]");
	
			System.out.println("testAudioBook2.equals(testAudioBook3) = " 
					+ testAudioBook2.equals(testAudioBook3));
		
			System.out.println();
			System.out.println("Getters presentation:");
			System.out.println("testAudioBook3.getDuration() = " + testAudioBook3.getDuration());
			System.out.println("testAudioBook3.getLector() = " + testAudioBook3.getLector());
			
			System.out.println();
			System.out.println("Setters presentation:");
			
			System.out.println("testAudioBook3.setDuration(LocalTime.of(3, 15, 2));");
			testAudioBook3.setDuration(LocalTime.of(3, 15, 2));
			
			System.out.println("testAudioBook3.setLector(\"Patrycja Konieczna\");");
			testAudioBook3.setLector("Patrycja Konieczna");
	
			System.out.println("testAudioBook3 = [" + testAudioBook3 + "]");
	
			System.out.println();
			System.out.println();
		
			this.printConstructor("invalidAudioBook", "\"9788328737785\", \"24.11.2025\", -40, 60, \"Literatura piekna obca\", \"Tuza\", \"I\", \"23-07-2025\", \"Mistrz i Malgorzata\", \"Bulhakow Michail\", 0, 23, 17, \"9788328737785\", 12.34f, \"MP3\", LocalTime.of(16, 51, 0), \"Jacek Gawron\"");
			invalidAudioBook = new CAudioBook("9788328737785", "24.11.2025", -40, 60, "Literatura piekna obca", "Tuza", "I", "23-07-2025", "Mistrz i Malgorzata", "Bulhakow Michail", 0, 23, 17, "9788328737785", 12.34f, "MP3", LocalTime.of(16, 51, 0), "Jacek Gawron");
			invalidAudioBook.incAmount();
		}
		catch(
			 DateException 
			  | CargoException 
			  | LiteratureException 
			  | ELiteratureException e
			 )
		{
			e.printStackTrace();
			System.err.println();
		}
		
	}
	
}
