package date;

public class NSCalendarGlobals 
{

	public final static int MONTH_IN_DAYS = 30, 
							YEAR_IN_MONTHS = 12;
	
	public final static int LEAP_YEAR_IN_DAYS      = 366, // ilosc dni w roku przestepnym,
							NON_LEAP_YEAR_IN_DAYS  = 365, // ilosc dni w roku nie przestepnym,
							LEAP_MONTH_IN_DAYS     = 29, // ilosc dni w lutym w roku przestepnym,
							NON_LEAP_MONTH_IN_DAYS = 28; // ilosc dni w lutym w roku nie przestepnym,
	
	public final static int WEEK_IN_DAYS = 7;
	
	public final static int NUMBER_OF_FIELDS_IN_CALENDAR = 3;
	
	public enum ENCalendar
	{
		DAYS,
		MONTHS,
		YEARS
	}
	
	public final static int WINDOWS_STARTING_YEAR  = 1601,
							WINDOWS_STARTING_MONTH = 1,
							WINDOWS_STARTING_DAY   = 1;
	
	public final static int EASTER_BORDER_YEAR = 1583;
	
	
	
}
