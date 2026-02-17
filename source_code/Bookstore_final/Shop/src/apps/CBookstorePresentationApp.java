package apps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.*;


public class CBookstorePresentationApp implements IApp
{
//public:
	public CBookstorePresentationApp()
	{}

	@Override
	public void run(String args[])
	{
		try
		{
			BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in, "UTF-8") );
			this.runAppShowSelector(stdin, args);
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}
	
	
//private:
	private void runAppShowSelector(BufferedReader stdin, String[] args) throws IOException
	{
		System.out.println("Select application:");
		System.out.println("1. Bookstore console app.");
		System.out.println("2. Bookstore GUI app.");
		
		IApp app;
		
		try
		{
			int applicationShowOption = Integer.parseInt( stdin.readLine().trim() );
			
			switch(applicationShowOption)
			{
				case 1:
					app = new CBookstoreConsoleApp();
				break;
					
				case 2:
					app = new CBookstoreGuiApp();
				break;
			
				default:
					throw new NumberFormatException();
				
			}
			
			app.run(args);
		}
		catch (NumberFormatException e) 
		{
			System.out.println("Unknown option. The program is terminated.");
			return;
		}
		
	}
	
	

}
