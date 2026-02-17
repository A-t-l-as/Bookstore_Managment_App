package myUtils;

import java.io.File;
import java.nio.file.Path;

public class NSFileUtils 
{
    public static String getFileExtension(Path argPath)
    {
        if (argPath == null)
        {
            return "";
        }

        String fileName = argPath.getFileName().toString();
        int lastDot = fileName.lastIndexOf('.');

        if (lastDot == -1 || lastDot == fileName.length() - 1)
        {
            return ""; 
        }

        return fileName.substring(lastDot + 1).toUpperCase();
    }

    public static boolean checkThatFileExist(Path argPath)
    {
		// File marker
		File file = new File( argPath.toString() );
		
		if(file.exists())
		{
			System.out.println("The file with the path " + argPath + " has been found.");
		}
		else
		{
			System.out.println("The file with the path " + argPath + " does not exist!");
			return false;
		}
		
		return true;
    }
    
    
    public static final String csvFormatName = "CSV";
    public static final String txtFormatName = "TXT";
}