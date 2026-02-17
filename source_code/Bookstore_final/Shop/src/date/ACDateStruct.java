package date;

import java.util.Objects;

import exceptions.DateException;

public abstract class ACDateStruct extends ACCalendar implements Comparable<ACDateStruct>
{
//public:
	//--------------
	// Constructors:
	
    public ACDateStruct()
    {
    	try
    	{
    		this.setDate
    		( 	
    			WINDOWS_STARTING_DAY, 
    			WINDOWS_STARTING_MONTH, 
    			WINDOWS_STARTING_YEAR
    		);
    	}
    	catch(DateException de)
    	{ /* nothing to do */ }
    }
    
    public ACDateStruct(int day, int month, int year) throws DateException
    {
    	this.setDate(day, month, year);
    }
    
    public ACDateStruct(String sDate) throws DateException
    {
    	super.checkDateString(sDate);
    	
    	String regex = "[./-]";			
		String[] sDateSplitted = sDate.split(regex);
		
		super.checkSplittedDateLen(sDate, sDateSplitted);
		
		this.setDate
		(
			Integer.parseInt(sDateSplitted[0]),
			Integer.parseInt(sDateSplitted[1]),
			Integer.parseInt(sDateSplitted[2]) 
		);
    }
    
    public ACDateStruct(ACDateStruct otherDateStruct) throws DateException
    {
    	this.setDate
    	(
    		otherDateStruct.getDay(), 
    		otherDateStruct.getMonth(), 
    		otherDateStruct.getYear()
    	);
    }
    
    //-------
    // Utils:    
    
    @Override
    public int compareTo(ACDateStruct other)
    {
        return Integer.compare(this.days, other.days);
    }
    
    @Override
	public int hashCode()
    {
		return Objects.hash(days);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ACDateStruct other = (ACDateStruct) obj;
		return days == other.days;
	}
    
   
    //---------------------
    // Getters and setters:

	// Getters:
    public int getDay()
    { 
    	return convertDaysToDateArray()[ENCalendar.DAYS.ordinal()];
    }
    
    public int getMonth()
    {	
    	return convertDaysToDateArray()[ENCalendar.MONTHS.ordinal()];
    }
    
    public int getYear()
    { 
    	return convertDaysToDateArray()[ENCalendar.YEARS.ordinal()];
    }
    
    // Setters:
    public void setDay(int day) throws DateException
    {
    	int tempMonth = this.getMonth(),
    		tempYear  = this.getYear();
    	
    	super.checkDay(day, super.daysInMonth(tempMonth, tempYear) );
    	this.setDate(day, tempMonth, tempYear);
    }
    
    public void setMonth(int month) throws DateException
    {
    	super.checkMonth(month);
    	this.setDate(this.getDay(), month, this.getYear());
    }
    
    public void setYear(int year) throws DateException
    {
    	super.checkYear(year);
    	this.setDate(this.getDay(), this.getMonth(), year);
    }
    
    // ----------------------------------------------------------------------------------

//protected:
    
    // adder:
    protected void addToDays(int value)
    { 
    	if(this.days + value < 0)
    	{
    		this.days = 0;
    		System.err.println
    		(
    			"\nAn attempt was made to exceed the threshold on 1 January 1601 " +
    			  "during addition/subtraction.\n" +
    			  "The CDate object assumes that you wanted to move to the beginning, " +
    			  "i.e. to 1 January 1601."
    		);
    		return;
    	}
    	
    	this.days += value; 
    }   
    
    // allDays getter:
    protected int getAllDays() { return this.days; }
    
//private:
    private int days;

    private void setDate(int day, int month, int year) throws DateException
    {
    	super.checkDate(day, super.daysInMonth(month, year), month, year);
    	
    	this.days = convertYearsToPassedDays(year) 
    				+ convertMonthsToPassedDays(month, year) 
    				+ convertDaysToPassedDays(day);
    }

    private int[] convertDaysToDateArray()
    {
    	int tempDays = this.days,
            day       = WINDOWS_STARTING_DAY,
            month     = WINDOWS_STARTING_MONTH,
            year      = WINDOWS_STARTING_YEAR;

        while(tempDays >= this.daysInYear(year))
        {
        	tempDays -= this.daysInYear(year);
            ++year;
        }
        
        while(tempDays >= this.daysInMonth(month, year))
        {
        	tempDays -= this.daysInMonth(month, year);
            ++month;
        }
        
        day += tempDays;

        return new int[]{day, month, year};
    }
    
    //-----------------------------------------------------------------------------------
}
