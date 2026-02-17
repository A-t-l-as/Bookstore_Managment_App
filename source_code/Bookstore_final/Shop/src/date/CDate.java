package date;

import exceptions.DateException;

public class CDate extends ACDateImpl
{
//public:
	//--------------
	// Constructors:
	public CDate() { super(); }
	public CDate(int day, int month, int year) throws DateException { super(day, month, year); }
	public CDate(String sDate) throws DateException { super(sDate); }
	public CDate(CDate otherDate) throws DateException { super(otherDate); }
	//--------------------------------------------------------------------------
	
	
	//--------------------
    // Calculate the date: 

    // Oblicz przeszlosc:
    public CDate calculatePast(int shiftInDays) throws DateException
    {
    	CDate newDate = new CDate(this);
    	newDate.moveToPast(shiftInDays);
    	return newDate;
    }
    
    // Oblicz przyszlosc:
    public CDate calculateFuture(int shiftInDays) throws DateException
    {
    	CDate newDate = new CDate(this);
    	newDate.moveToFuture(shiftInDays);
    	return newDate;
    }
    
    // Oblicz wczoraj:
    public CDate calculateYesterday() throws DateException
    {
    	CDate newDate = new CDate(this);
    	newDate.moveToYesterday();
    	return newDate;
    }
    
    // Oblicz jutro:
    public CDate calculateTomorrow() throws DateException
    {
    	CDate newDate = new CDate(this);
    	newDate.moveToTomorrow();
    	return newDate;
    }
    
    // Oblicz tydzien temu:
    public CDate calculateWeekBefore() throws DateException
    {
    	CDate newDate = new CDate(this);
    	newDate.moveToWeekBefore();
    	return newDate;
    }
    
    // Oblicz za tydzien:
    public CDate calculateNextWeek() throws DateException
    {
    	CDate newDate = new CDate(this);
    	newDate.moveToNextWeek();
    	return newDate;
    }
    
    //----------------
    // Static Methods:
    
    public static boolean compareDates(CDate x1, CDate x2)
    {
    	return x1.compareDates(x2);
    }
    
    public static int dateDifference(CDate x1, CDate x2)
    {
    	return x1.dateDifference(x2);
    }
    
    public static boolean isLeap(CDate x1)
    {
    	return x1.isLeap();
    }
    
    // isInClosedRange
    public static boolean isInClosedRange(CDate date, CDate range1, CDate range2)
    {
    	 return ( date.isLaterThan(range1) || date.equals(range1) )
    			&&
    	        ( date.equals(range2) || range2.isLaterThan(date)  ) ;
    }
    
    //--------
    // Easter:
    
    public static int[] easterDate(int year) throws DateException
    {
    	ACCalendar.checkEasterYear(year);
    		
    	int a = year % 19,
    	    b = Math.floorDiv(year, 100),
    	    c = year % 100,
    	    d = Math.floorDiv(b, 4),
    	    e = b % 4,
    	    f = Math.floorDiv((b + 8), 25),
    	    g = Math.floorDiv((b - f + 1), 3),
    	    h = (19 * a + b - d - g + 15) % 30,
    	    i = Math.floorDiv(c, 4),
    	    k = c % 4,
    	    l = (32 + 2 * e + 2 * i - h - k) % 7,
    	    m = Math.floorDiv((a + 11 * h + 22 * l), 451),
    	    n = Math.floorDiv((h + l - 7 * m + 114), 31),
    	    o = (h + l - 7 * m + 114) % 31;
    	
    	return new int[]{o + 1, n, year};
    }
    
    public static CDate createEasterDateObj(int year)
    {
    	CDate result = new CDate();
    	int[] dateArray; 
    	
    	try
    	{
    		dateArray = CDate.easterDate(year);
    		result = 
    				new 
    				CDate(
    					  dateArray[ ENCalendar.DAYS.ordinal()   ],
    					  dateArray[ ENCalendar.MONTHS.ordinal() ], 
    					  dateArray[ ENCalendar.YEARS.ordinal()  ]
    					 );
    		
    	}
    	catch(DateException de)
    	{
    		System.err.println(de);
    		System.err.println("The date of Easter could not be found for the specified year.");
    	}
    	
    	return result;
    }
	
}
