package exceptions;

import myUtils.NSIntRangeUtils;
import date.CDate;


public class DateException extends Exception
{
//public:
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2727248459292163077L;

	//--------------
	// Constructors:
	public DateException()
	{
		super();
	}
	
	public DateException(String mess)
	{
		super(mess);
	}

    //----------------
    // Static Methods:
	public static String getMessageForCheckDateMethod(
			                                          int day, 
			                                          int daysInMonth, 
			                                          int month, 
			                                          int year
			                                         )
	{
		return "\nException: Incorrect arguments were entered during object initialisation!\n" + 
	    		 "Value: day = " + day + ", month = " + month + ", year = " + year + "\n" +
	    		 "About:\n" +
	    		 "One or more values when setting the date are incorrect:\n" 
	    		 +
	    		 (
	    			NSIntRangeUtils.isInClosedRange(month, 1, CDate.YEAR_IN_MONTHS)?	 
	    			"-> The day should be within the range of 1 to " + daysInMonth + ",\n"
	    		   :
	    		    ""
	    	     ) 
	    		 +
	    		 "-> The month should be within the closed range from 1 to " 
	    		 + CDate.YEAR_IN_MONTHS + ",\n" +
	    		 "-> The year should be greater than or equal to " 
	    		 + CDate.WINDOWS_STARTING_YEAR + ".\n";
	}
	
	public static String getMessageForCheckSplittedDateLenMethod(String sDate)
	{
		return "\nException: Incorrect arguments were entered during object initialisation:\n" +
    	         "About:\n" +
    	         "Invalid date string: " + sDate + "\n";
	}
	
	public static String getMessageForCheckDateStringMethod()
	{
        return "\nException: Incorrect arguments were entered during object initialisation!\n" +
    	         "About:\n" + 
    	         "sDate string cannot be null or empty!\n";
	}
	
	public static String getMessageForCheckDayMethod(int day, int daysInMonth)
	{
		return "\nException: Incorrect argument in setter!\n" +
		         "Value: day = " + day + "\n" +
		         "About:\n" +
		         "The day should be within the range of 1 to " + daysInMonth + "!\n";
	}
	
	public static String getMessageForCheckMonthMethod(int month)
	{
		return "\nException: Incorrect argument in setter!\n" +
				 "Value: month = " + month + "\n" +
				 "About:\n" +
				 "The month should be within the closed range from 1 to " 
				 + CDate.YEAR_IN_MONTHS + "!\n";
	}
	
	public static String getMessageForCheckYearMethod(int year)
	{
		return "\nException: Incorrect argument in setter!\n" +
				 "Value: year = " + year + "\n" +
				 "About:\n" + 
				 "The year should be greater than or equal to " 
				 + CDate.WINDOWS_STARTING_YEAR + "!\n";
	}
	
	public static String getMessageForEasterDateMethod(int year)
	{
		return "\nException: An incorrect argument was entered into the method.\n" +
				 "Value: year = " + year + "\n" +
				 "About: \n" +
				 "Gregorian calendar was not utilised for determining Easter before year 1583.\n" + 
				 "Using the algorithm far into the future is questionable,\n" + 
				 "since we know nothing about how different churches will define " +
				 "Easter far ahead.\n";
	}
}
