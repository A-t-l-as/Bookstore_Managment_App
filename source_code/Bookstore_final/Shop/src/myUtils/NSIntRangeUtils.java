package myUtils;

// namespace NSIntRangeUtils
public class NSIntRangeUtils
{
	public static boolean isInClosedRange(int number, int lowerBound, int upperBound) 
	{
        return (lowerBound <= number && number <= upperBound);
    }

    public static boolean isInOpenRange(int number, int lowerBound, int upperBound)
    {
        return (lowerBound < number && number < upperBound);
    }

    public static boolean isInOpenClosedRange(int number, int lowerBound, int upperBound)
    {
        return (lowerBound < number && number <= upperBound);
    }

    public static boolean isInClosedOpenRange(int number, int lowerBound, int upperBound)
    {
        return (lowerBound <= number && number < upperBound);
    }
}
