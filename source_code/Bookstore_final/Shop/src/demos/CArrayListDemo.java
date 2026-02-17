package demos;

import cargos.CBook;
import cargos.CEBook;
import cargos.CLiterature;
import cargos.CAudioBook;
import exceptions.BookException;
import exceptions.CargoException;
import exceptions.DateException;
import exceptions.LiteratureException;
import exceptions.ELiteratureException;
import exceptions.EBookException;

import java.time.LocalTime;
import java.util.ArrayList;

public class CArrayListDemo extends ACObjectDemo
{
	public CArrayListDemo()
	{
		super(new Object());
		
		CBook testBook,
			  testBook2;
		
		CEBook testEBook;
		
		CAudioBook 	testAudioBook, 
					testAudioBook2,
					testAudioBook3,
					testAudioBook4,
					testAudioBook5,
					testAudioBook6;
		
		ArrayList<CLiterature> books = new ArrayList<CLiterature>();
		
		try
		{
			testBook = new CBook("9788328737785", "24.11.2025", 40, 60, "Literatura piekna obca", "Tuza", "I", "23-07-2025", "Mistrz i Malgorzata", "Bulhakow Michail", 560, 23, 17, "9788328737785", 10, CBook.ENTypeOfCover.SOFT, 13.5f);
			testBook2 = new CBook("1243503400", "14.11.2025", 100, 20, "Kryminal, sensacja, thriller", "Tuza", "II", "23-06-2024", "Krolestwo", "Nesbo Jo", 480, 20, 13, "9788327170316", 3, CBook.ENTypeOfCover.HARD, 15.5f);
			testEBook = new CEBook("1671434253", "15.11.2025", 30, 10, "Horror", "PMedia", "III", "23-06-2024", "Bazar zlych snow", "King Stephen", 480, 20, 13, "4343534534", 12.31f, "EPUB", false, 480);
			testAudioBook = new CAudioBook("234235364575686", "1.11.2025", 40, 80, "Horror", "PMedia", "I", "23-07-2025", "Widmo nad Innsmouth", "Lovecraft Howard Phillips", 0, 23, 17, "9788384081518", 12.31f, "WAV", LocalTime.of(6, 52, 0), "Jan Kowalski");
			testAudioBook2 = new CAudioBook("234235364575686", "1.11.2025", 40, 80, "Horror", "PMedia", "I", "23-07-2025", "Widmo nad Innsmouth", "Lovecraft Howard Phillips", 0, 23, 17, "9788384081518", 12.31f, "WAV", LocalTime.of(6, 52, 0), "Jan Kowalski");
			testAudioBook3 = new CAudioBook("234235364575686", "1.11.2025", 40, 80, "Horror", "PMedia", "I", "23-07-2025", "Widmo nad Innsmouth", "Lovecraft Stephen", 0, 23, 17, "9788384081518", 12.31f, "WAV", LocalTime.of(6, 52, 0), "Jan Kowalski");
			testAudioBook4 = new CAudioBook("234235364575686", "1.11.2025", 40, 80, "Horror", "PMedia", "I", "23-07-2025", "Widmo nad Londynemm", "Lovecraft Stephen", 0, 23, 17, "9788384081518", 12.31f, "WAV", LocalTime.of(6, 52, 0), "Jan Kowalski");
			testAudioBook5 = new CAudioBook("234235364575686", "1.11.2025", 40, 80, "Horror", "PMedia", "I", "23-07-2025", "Widmo nad Londynemm", "Lovecraft Stephen", 0, 23, 17, "9788384081519", 12.31f, "WAV", LocalTime.of(6, 52, 0), "Jan Kowalski");
			testAudioBook6 = new CAudioBook("234235364575676", "1.11.2025", 40, 80, "Horror", "PMedia", "I", "23-07-2025", "Widmo nad Londynemm", "Lovecraft Stephen", 0, 23, 17, "9788384081519", 12.31f, "WAV", LocalTime.of(6, 52, 0), "Jan Kowalski");
			
			System.out.println("testEBook.compareTo(testAudioBook) = " + testEBook.compareTo(testAudioBook));
			System.out.println("testAudioBook.compareTo(testEBook) = " + testAudioBook.compareTo(testEBook));
			System.out.println("testAudioBook.compareTo(testAudioBook2) = " + testAudioBook.compareTo(testAudioBook2));
			System.out.println("testAudioBook3.compareTo(testAudioBook2) = " + testAudioBook3.compareTo(testAudioBook2));
			System.out.println("testAudioBook2.compareTo(testAudioBook3) = " + testAudioBook2.compareTo(testAudioBook3));
			System.out.println("testAudioBook3.compareTo(testAudioBook4) = " + testAudioBook3.compareTo(testAudioBook4));
			System.out.println("testAudioBook4.compareTo(testAudioBook3) = " + testAudioBook4.compareTo(testAudioBook3));
			System.out.println("testAudioBook4.compareTo(testAudioBook5) = " + testAudioBook4.compareTo(testAudioBook5));
			System.out.println("testAudioBook5.compareTo(testAudioBook6) = " + testAudioBook5.compareTo(testAudioBook6));
			
			books.add(testBook);
			books.add(testBook2);
			books.add(testEBook);
			books.add(testAudioBook);
			
			for(var book : books)
			{
				System.out.print("class=" + book.getClass().getSimpleName() + ", ");
				System.out.println(book);
			}
		}
		catch(
			    DateException 
			  | CargoException 
			  | LiteratureException 
			  | BookException 
			  | EBookException 
			  | ELiteratureException e  
			 )
		{
			
		}
	}
}
