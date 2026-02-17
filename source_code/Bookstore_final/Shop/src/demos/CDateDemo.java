package demos;

import exceptions.DateException;
import date.CDate;

public class CDateDemo extends ACObjectDemo
{
	public void raiseAnException(String value)
	{
	      try
	      {
	    	 CDate incorrectDate = new CDate(value);
	    	 this.printConstructor("incorrectDate", "" + value);
	    	 
	    	 incorrectDate.calculateYesterday();
	      }
	      catch(DateException de)
	      {
	    	 de.printStackTrace();
	    	 System.err.println();
	      }
	}
	
	public void raiseAnException(int day, int month, int year)
	{
	      try
	      {
	    	  CDate incorrectDate = new CDate(day, month, year);
	    	  this.printConstructor("incorrectDate", "" + day + ", " + month + ", " + year);
	    	  
	    	  incorrectDate.calculateYesterday();
	      }
	      catch(DateException de)
	      {
	    	 de.printStackTrace();
	    	 System.err.println();
	      }
	}
	
	public void raiseAnExceptionWithSetters(int day, int month, int year)
	{
	      try
	      {
	    	 CDate incorrectDate = new CDate();
	    	 this.printConstructor("incorrectDate", "");
	    	 
	    	 this.printAllSetters("incorrectDate", day, month, year);
	         incorrectDate.setDay  (day  );
	         incorrectDate.setMonth(month);
	         incorrectDate.setYear (year );
	      }
	      catch(DateException de)
	      {
	    	 de.printStackTrace();
		     System.err.println();
	      }
	}
	
	public void exceptionsPresentation()
	{
        System.out.println("\nTest Wyjatkow:");
        this.raiseAnException("3212002");
        this.raiseAnException("\"\"");
        this.raiseAnException("13&02&2005");
        this.raiseAnException( 32,  1, 2000);
        this.raiseAnException(  1, 13, 2014);
        this.raiseAnException(  1,  1,   -1);
        this.raiseAnException( 32, 14,  -33);
        this.raiseAnException( 1, 12,  1600);
        this.raiseAnException("2-02-1500");
        this.raiseAnException("1/1/2005/2004");
        this.raiseAnExceptionWithSetters(32, 1,  2005);
        this.raiseAnExceptionWithSetters(1, -1,  2005);
        this.raiseAnExceptionWithSetters(1,  1,  -100);
        this.presentEasterDateMethod(1581);
	}
	
	public void easterDatePresentation()
	{
		System.out.println("\nTest daty wielkanocy:");
        this.presentEasterDateMethod(1961);
        this.presentEasterDateMethod(2025);
        this.presentEasterDateMethod(2026);
        this.presentEasterDateMethod(1583);
        
        CDate easterCDate = CDate.createEasterDateObj(1600);
        System.out.println();
        this.printConstructor("easterCDate", "1600");
        System.out.println(easterCDate);
	}
	
	public void gettersPresentation(CDate someDate, String dateObjName)
	{
        System.out.println();
        System.out.println(dateObjName + " getters test:");
        System.out.println(dateObjName + ".getDay() = "   + someDate.getDay()  );
        System.out.println(dateObjName + ".getMonth() = " + someDate.getMonth());
        System.out.println(dateObjName + ".getYear() = "  + someDate.getYear() );
	}
	
	public void settersPresentation(
									CDate someDate, 
									String dateObjName, 
									int day, 
									int month, 
									int year
								   )
	{
        System.out.println();
        System.out.println(dateObjName + " setters test:");
        this.printAllSetters(dateObjName, day, month, year);
        
        try
        {
        	someDate.setDay(day);
        	someDate.setMonth(month);
        	someDate.setYear(year);
        }
        catch(DateException de)
        {
	    	 de.printStackTrace();
		     System.err.println();
        }
        
        System.out.println(dateObjName + " = " + someDate);
	}
	
	
	public void printAllSetters(String objName, int day, int month, int year)
	{
        System.out.println(objName + ".setDay(" + day + ")");
        System.out.println(objName + ".setMonth(" + month + ")");
        System.out.println(objName + ".setYear(" + year + ")");
	}
	
	public void presentEasterDateMethod(int year)
	{
		System.out.print("\nEasterDate test: CDate.easterDate(" + year + ") = ");
		
		try
		{
			int[] date = CDate.easterDate(year);
			for(int i = 0; i < date.length ; ++i)
			{
				System.out.print(date[i] + ( i < date.length - 1 ? "." : "") );
			}
			System.out.println();
		}
		catch(DateException de)
		{
	    	 de.printStackTrace();
	    	 System.err.println();
		}
	}
	
	public CDateDemo()
	{
		super(new CDate());
		
		int shiftInDays = 924;
		
		CDate baseDate,
		 	  otherDate,
		 	  nullDate,
		 	  strDate,
		 	  strDate2,
		 	  strDate3,
		 	  gregorianDateTest,
		 	  gregorianDateTest2;
		
		try
		{
			baseDate = new CDate(24,11,2020); 
			this.printConstructor("baseDate", "24,11,2020");
		
			otherDate = new CDate(30,12,2021);
			this.printConstructor("otherDate", "30,12,2021");
        
			nullDate = new CDate(); 
			this.printConstructor("nullDate", "");
			System.out.println("Data nullDate = " + nullDate 
        		+ " // test konstruktora domyslnego");
        
			System.out.println();

		
			strDate = new CDate("10.03.2000"); 
			this.printConstructor("strDate", "\"10.03.2000\"");
			System.out.println("Data strDate = " + strDate 
        		+ " // test konstruktora ze Stringiem ale z symbolem .");
        
			System.out.println();
        
			strDate2 = new CDate("11/04/2001"); 
			this.printConstructor("strDate2", "\"11/04/2001\"");
        
			System.out.println("Data strDate2 = " + strDate2 
        		+ " // test konstruktora ze Stringiem ale z symbolem /");
        
			System.out.println();
        
			strDate3 = new CDate("12-05-2002"); 
			this.printConstructor("strDate3", "\"12-05-2002\"");
        
			System.out.println("Data strDate3 = " + strDate3 
        		+ " // test konstruktora ze Stringiem ale z symbolem -");
        
			System.out.println();
        
			System.out.print("Data bazowa baseDate = ");
			baseDate.println();
        
			this.gettersPresentation(baseDate, "baseDate");
			this.gettersPresentation(otherDate, "otherDate");
        
			settersPresentation(baseDate, "baseDate",  1,  2, 2000);
			settersPresentation(baseDate, "baseDate", 24, 11, 2020);
        
			System.out.println("");
        
			System.out.print("Data bazowa po przesunieciu o " + shiftInDays + " dni: ");
			System.out.println(baseDate.calculateFuture(shiftInDays));
        
			System.out.print("Data bazowa ale jutrzejsza: ");
			System.out.println(baseDate.calculateTomorrow());

			System.out.print("Data bazowa ale wczorajsza: ");
			System.out.println(baseDate.calculateYesterday());
        
			System.out.print("Data bazowa ale tydzien temu: ");
			System.out.println(baseDate.calculateWeekBefore());
        
			System.out.print("Data bazowa ale za tydzien: ");
			System.out.println(baseDate.calculateNextWeek());
        
			System.out.print("Data bazowa po cofnieciu o " + shiftInDays + " dni: ");
			System.out.println(baseDate.calculatePast(shiftInDays));
        
			System.out.print("Data bazowa po cofnieciu o " + 153363 + " dni: ");
			System.out.println(baseDate.calculatePast(153363));
			
			System.out.print("Data bazowa po cofnieciu o " + 153364 + " dni: ");
			System.out.println(baseDate.calculatePast(153364));
			
			System.out.print("Data bazowa po cofnieciu o " + 153367 + " dni: ");
			System.out.println(baseDate.calculatePast(153367));
			
			System.out.println();
			
			CDate test2018 = new CDate("15.5.2018");
			this.printConstructor("test2018", "\"15.5.2018\"");
			
			System.out.println("Czy rok z daty test2018 jest rokiem przestepnym?: " 
			+ test2018.isLeap());
			
			System.out.println();
        
			System.out.print("Data otherDate: ");
			otherDate.println();
        
			System.out.print("Data otherDate po przesunieciu o " + 1 + " dni: ");
			otherDate.calculateFuture(1).println();
        
			System.out.println("Data otherDate po zmianie wartosci:");
			System.out.println("otherDate := otherDate.calculateFuture(7)");
			otherDate = otherDate.calculateFuture(7);
			System.out.println("otherDate = " + otherDate);
       
			System.out.println();
        
			System.out.println("Data other date po zmianie wartosci (tydzien przed):");
			System.out.println("otherDate := otherDate.calculateWeekBefore()");
			otherDate = otherDate.calculateWeekBefore();
			System.out.println("otherDate = " + otherDate);
			System.out.println("otherDate.toString() = " + otherDate.toString());
        
			System.out.println();
        
			System.out.print("Data otherDate po cofnieciu o " + 30 + " dni: ");
			otherDate.calculatePast(30).println();
        
			System.out.print("Data otherDate po cofnieciu o tydzien: ");
			otherDate.calculateWeekBefore().println();
        
			System.out.print("Data otherDate po cofnieciu o " + 360 + " dni: ");
			otherDate.calculatePast(360).println();
        
			System.out.println();
        
        	System.out.println
        	(
        		"baseDate = " + baseDate + "\n" +
        		"otherDate = " + otherDate + "\n" +
        		"Roznica miedzy data bazowa a otherDate wynosi: " +
        		baseDate.dateDifference(otherDate)
        	);
        
        	System.out.println("Czy data bazowa jest pozniejsza od otherDate?: " 
        			+ baseDate.isLaterThan(otherDate));
        
        	System.out.println("Czy data bazowa jest rowna otherDate?: " 
        			+ baseDate.compareDates(otherDate));
        
        	System.out.println("Czy data otherDate jest pozniejsza od bazowej?: " 
        			+ otherDate.isLaterThan(baseDate));
        
        	System.out.println("Czy data otherDate jest rowna bazowej?: " 
        			+ otherDate.compareDates(baseDate));
        
        
        	System.out.println();
        
        	System.out.println("Test statycznych metod:");
        
        	System.out.println("baseDate = " + baseDate);
        	System.out.println("otherDate = " + otherDate);
        
        	System.out.println
        	(
        		"Roznica miedzy data bazowa a otherDate wynosi: " 
        		+ 
        		CDate.dateDifference(baseDate, otherDate)
        	);
        
        	System.out.println("Czy data bazowa jest rowna otherDate?: " 
        			+ CDate.compareDates(baseDate, otherDate));
        
        	System.out.println("Czy data otherDate jest rowna bazowej?: " 
        			+ CDate.compareDates(otherDate, baseDate));
        
       
        	System.out.println();
        
        	baseDate = new CDate(30,12,2021);
        	this.printConstructor("baseDate", "30,12,2021");
        
        	System.out.println("baseDate = " + baseDate);
        	System.out.println("otherDate = " + otherDate);
        
        	System.out.println
        	(
        		"Roznica miedzy data bazowa a otherDate wynosi: " 
        		+ 
        		CDate.dateDifference(baseDate, otherDate)
        	);
        
        	System.out.println("Czy data bazowa jest rowna otherDate?: " 
        			+ CDate.compareDates(baseDate, otherDate));
        
        	System.out.println("Czy data otherDate jest rowna bazowej?: " 
        			+ CDate.compareDates(otherDate,baseDate));
        
        	this.easterDatePresentation();
        
        	this.exceptionsPresentation();
        
        	
        	System.out.println("Krotki dodatkowy pokaz podkreslajacy mozliwosci kalendarza gregorianskiego:");
        	
        	gregorianDateTest = new CDate(31, 1, 2025);
        	this.printConstructor("gregorianDateTest", "31, 1, 2025");
        	System.out.println("gregorianDateTest = " + gregorianDateTest);
        	
        	System.out.println();
        	
        	gregorianDateTest = gregorianDateTest.calculateTomorrow();
        	System.out.println("gregorianDateTest := gregorianDateTest.calculateTomorrow()");
        	System.out.println("gregorianDateTest = " + gregorianDateTest);
        	System.out.println
        	(
        		"Czy rok z daty " 
        		+ gregorianDateTest 
        	    + " jest rokiem przestepnym?: " 
        	    + gregorianDateTest.isLeap()
        	);
        	
        	System.out.println();
        	
        	gregorianDateTest = gregorianDateTest.calculateFuture(27);
        	System.out.println("gregorianDateTest := gregorianDateTest.calculateFuture(27)");
        	System.out.println("gregorianDateTest = " + gregorianDateTest);
        	
        	System.out.println();
        	
        	gregorianDateTest = gregorianDateTest.calculateTomorrow();
        	System.out.println("gregorianDateTest := gregorianDateTest.calculateTomorrow()");
        	System.out.println("gregorianDateTest = " + gregorianDateTest);
        	
        	System.out.println();
        	
        	gregorianDateTest2 = new CDate(5, 3, 2028);
        	this.printConstructor("gregorianDateTest2", "5, 3, 2028");
        	System.out.println("gregorianDateTest2 = " + gregorianDateTest2);
        	
        	System.out.println();
        	
        	gregorianDateTest2 = gregorianDateTest2.calculateTomorrow();
        	System.out.println("gregorianDateTest2 := gregorianDateTest2.calculateTomorrow()");
        	System.out.println("gregorianDateTest2 = " + gregorianDateTest2);
           	System.out.println
        	(
        		"Czy rok z daty " 
        		+ gregorianDateTest2 
        	    + " jest rokiem przestepnym?: " 
        	    + gregorianDateTest2.isLeap()
        	);
        	
        	System.out.println();
        	
        	gregorianDateTest2 = gregorianDateTest2.calculatePast(6);
        	System.out.println("gregorianDateTest2 := gregorianDateTest2.calculatePast(6)");
        	System.out.println("gregorianDateTest2 = " + gregorianDateTest2);
        	
        	System.out.println();
        	
        	gregorianDateTest2 = gregorianDateTest2.calculatePast(29 + 31);
        	System.out.println("gregorianDateTest2 := gregorianDateTest2.calculatePast(29 + 31)");
        	System.out.println("gregorianDateTest2 = " + gregorianDateTest2);
        	
        	for(int i = CDate.YEAR_IN_MONTHS; i >= 1; --i)
        	{
        		int shift = gregorianDateTest2.daysInMonth
        		(
        			gregorianDateTest2.getMonth(),
    				gregorianDateTest2.getYear()
        		);
        	
        		gregorianDateTest2 = gregorianDateTest2.calculatePast(shift);
        		
        		System.out.println("gregorianDateTest2 := gregorianDateTest2.calculatePast("+ shift +")");
        		System.out.println("gregorianDateTest2 = " + gregorianDateTest2);
        		System.out.println();
        	}
        	
        	System.out.println
        	(
        		"Wywolanie statyczne Date.isLeap(gregorianDateTest2):\n" 
        		+ "Date.isLeap(" + gregorianDateTest2 + ") = " 
        	    + CDate.isLeap(gregorianDateTest2)
        	);
        	
        	System.out.println();
        	
        	gregorianDateTest2 = new CDate("31-3-2016");
        	this.printConstructor("gregorianDateTest2", "\"31-3-2016\"");
        	
        	System.out.println
        	(
        		"Wywolanie statyczne Date.isLeap(gregorianDateTest2):\n" 
        		+ "Date.isLeap(" + gregorianDateTest2 + ") = " 
        	    + CDate.isLeap(gregorianDateTest2)
        	);
        	
        	System.out.println();
        	
        	System.out.println
        	(
        		"Wywolanie statyczne Date.isLeap(int year):\n" 
        		+ "Date.isLeap(" + gregorianDateTest2.getYear() + ") = " 
        	    + CDate.isLeap(gregorianDateTest2.getYear())
        	);
        	
        	gregorianDateTest2 = new CDate(31,12,2024);
        	gregorianDateTest2 = gregorianDateTest2.calculateFuture(1);
        	System.out.println(gregorianDateTest2);
        	
        	gregorianDateTest2 = gregorianDateTest2.calculatePast(1);
        	System.out.println(gregorianDateTest2);
        	
        	gregorianDateTest2 = gregorianDateTest2.calculatePast(CDate.LEAP_YEAR_IN_DAYS);
        	System.out.println(gregorianDateTest2);
        	System.out.println();
        	
        	System.out.println("Koniec programu...");
        	
		}
		catch(DateException de)
		{
	    	 de.printStackTrace();
	    	 System.err.println();
		}
	}
	
}
