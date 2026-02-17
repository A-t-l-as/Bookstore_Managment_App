package date;

import exceptions.DateException;

public abstract class ACDateImpl extends ACDateStruct 
{
//public:
	//--------------
	// Constructors:
	public ACDateImpl() { super(); }
	
    public ACDateImpl(int day, int month, int year) throws DateException {super(day, month, year);}
    
    public ACDateImpl(String sDate) throws DateException { super(sDate); }
    
    public ACDateImpl(ACDateImpl otherDate) throws DateException { super(otherDate); }
    
    //--------------------------------------------------------------------------
    
    //---------------------
    // Comparative methods:
    
    // compareDates:
    public boolean compareDates(ACDateImpl otherDateImpl)
    {	
    	return this.equals(otherDateImpl);
    }
    
    // isLaterThan:
    public boolean isLaterThan(ACDateImpl otherDateImpl)
    {	
    	return this.getAllDays() > otherDateImpl.getAllDays();
    }
    
    // dateDifference:
    public int dateDifference(ACDateImpl otherDateImpl)
    {
    	return Math.abs(this.getAllDays() - otherDateImpl.getAllDays());
    }
    
    //--------------------
    // Moving in the date: 
    
    // Przenies sie do przeszlosci:
    public void moveToPast(int shiftInDays) 
    {
    	this.addToDays(-shiftInDays);	
    }
    
    // Przenies sie do przyszlosci:
    public void moveToFuture(int shiftInDays) 
    {
    	this.addToDays(shiftInDays);
    }
    
    // Przenies sie do wczoraj:
    public void moveToYesterday() 
    {
    	this.moveToPast(1);
    }
    
    // Przenies sie do jutra:
    public void moveToTomorrow() 
    {
        this.moveToFuture(1);
    }
    
    // Przenies sie o tydzien wstecz:
    public void moveToWeekBefore() 
    {
    	this.moveToPast(WEEK_IN_DAYS);
    }

    // Przenies sie o tydzien w przod:
    public void moveToNextWeek() 
    {
        this.moveToFuture(WEEK_IN_DAYS);
    }
    
    //-------
    // Other:
    
    // Czy jest przestepny?
    public boolean isLeap()
    {
    	return isLeap(this.getYear());
    }
    
    // toString:
    @Override
    public String toString()
    { 	
    	return String.format("%02d.%02d.%d", this.getDay(), this.getMonth(), this.getYear());
    }
    
    // Printing:
    public void print()   { System.out.print(this.toString());   }
    
    public void println() { System.out.println(this.toString()); }
    
}
