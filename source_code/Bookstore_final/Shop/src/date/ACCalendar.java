package date;

import exceptions.DateException;
import myUtils.NSIntRangeUtils;

public abstract class ACCalendar extends NSCalendarGlobals
{
// public:
	public static boolean isLeap(int year)
	{
		return ( ( (year % 4 == 0) && (year % 100 != 0) ) || year % 400 == 0);
	}
	

	//---------------------------------
	// Calculate days in month or year:
	public int daysInMonth(int month, int year)
    {
    	try
    	{
    		this.checkMonth(month);
    	}
    	catch(DateException de)
    	{
    		System.err.println(de);
    	}
    	
        return 	switch(month)
        		{
        			case 1, 3, 5, 7, 8, 10, 12 	-> MONTH_IN_DAYS + 1;
        			case 4, 6, 9, 11 			-> MONTH_IN_DAYS;
        			case 2 						-> isLeap(year) ? 
        					                         LEAP_MONTH_IN_DAYS 
        				                           : 
        					                         NON_LEAP_MONTH_IN_DAYS; 
        			default 					-> 0;
        		};
    }
	
	
	public int daysInYear(int year)
    {
    	return  isLeap(year) ? 
				 LEAP_YEAR_IN_DAYS
				: 
			     NON_LEAP_YEAR_IN_DAYS;
    }

//protected:
	
	//----------------------------------------------------------
	
	//------------
	// Converters:
	protected int convertYearsToPassedDays(int year)
    {
    	int temp_year = year - 1;
    	int result = 0;
    	
    	while(temp_year >= WINDOWS_STARTING_YEAR)
    	{
    		result += daysInYear(temp_year);
    		--temp_year;
    	}
    	
    	return result;
    }
   
	protected int convertMonthsToPassedDays(int month, int year)
    {
    	int temp_month = month - 1;
    	int result = 0;
    	
    	while(temp_month >= WINDOWS_STARTING_MONTH)
    	{
    		result += this.daysInMonth(temp_month, year);    		
    		--temp_month;
    	}
    	
    	return result;
    }
    
	protected int convertDaysToPassedDays(int day) { return day - WINDOWS_STARTING_DAY; }
	
	//-----------------------------------------------------------------------------------
	
	//----------
	// Checkers:
	
	
	protected void checkDay(int day, int daysInMonth) throws DateException
	{
    	if(!NSIntRangeUtils.isInClosedRange(day, 1, daysInMonth))
    	{
    		throw new DateException
    		(
    			DateException.getMessageForCheckDayMethod(day, daysInMonth)
    		);
    	}
	}
	
	protected void checkMonth(int month) throws DateException
    {
    	if(!NSIntRangeUtils.isInClosedRange(month, 1, YEAR_IN_MONTHS))
    	{
    		throw new DateException
    		(
    			DateException.getMessageForCheckMonthMethod(month)
    		);
    	}
    }
	
	protected void checkYear(int year) throws DateException
    {
    	if(!(year >= WINDOWS_STARTING_YEAR))
    	{
    		throw new DateException
    		(
    			DateException.getMessageForCheckYearMethod(year)
    		);
    	}
    }
    
	protected void checkDate(int day, int daysInMonth, int month, int year) throws DateException
    {
      	if(!
          		(
          			NSIntRangeUtils.isInClosedRange(day  , 1, daysInMonth )
          			&&
          			NSIntRangeUtils.isInClosedRange(month, 1, YEAR_IN_MONTHS)
          			&&
          			year >= WINDOWS_STARTING_YEAR
          		)
          )
          	{
          		throw 
          		new 
          		DateException
          		(
          			DateException.getMessageForCheckDateMethod(day, daysInMonth, month, year)
          		);
          	}
    }
    
	protected void checkDateString(String sDate) throws DateException
    {
    	if (sDate == null || sDate.isEmpty())
    	{
            throw 
            new 
            DateException
            (
            	DateException.getMessageForCheckDateStringMethod()
            );
        }
    }
	
	protected void checkSplittedDateLen(String sDate, String[] sDateSplitted) throws DateException
    {
		if (sDateSplitted.length != NUMBER_OF_FIELDS_IN_CALENDAR)
		{
	        throw 
	        new 
	        DateException
	        (
	        	DateException.getMessageForCheckSplittedDateLenMethod(sDate)
	        );
	    }
    }
   

    //----------------
    // Static Methods:
	protected static void checkEasterYear(int year) throws DateException
    {
    	if(year < EASTER_BORDER_YEAR)
    	{
    		throw 
    		new 
    		DateException
    		(
    			DateException.getMessageForEasterDateMethod(year)
    		);
    	}
    }
	
}
