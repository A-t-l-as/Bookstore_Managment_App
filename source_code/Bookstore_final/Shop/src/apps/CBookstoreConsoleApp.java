package apps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import myUtils.NSIntRangeUtils;
import shop.CShop;

public class CBookstoreConsoleApp implements IApp
{
//public:
	public CBookstoreConsoleApp()
	{}

	@Override
	public void run(String[] args)
	{
		try
		{
			BufferedReader stdin = 
					new BufferedReader( new InputStreamReader(System.in, "UTF-8") );
			
			this.startMainLoop(stdin);
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}

//private:
	private void startMainLoop(BufferedReader stdin) throws IOException
	{
		CShop myShop = new CShop();
		
		boolean loopCondition = true;
		
		int inputOptionNumber = 0,
			inputVal1         = 0,
			inputVal2         = 0;
		
		String inputString    = "";
		
		Path inputPath = Path.of("");
		
		while(loopCondition)
		{
			System.out.print("Enter num value:");
			try
			{
				
				inputOptionNumber = Integer.parseInt( stdin.readLine().trim() );
				
				if(inputOptionNumber == 4 || inputOptionNumber == 6) 
				{
					System.out.print("Enter text:");
					inputPath = Paths.get( stdin.readLine() ); 
				}
				
				if( 
					inputOptionNumber == 5 || 
					NSIntRangeUtils.isInClosedRange(inputOptionNumber, 21, 25) 
				  )
				{
					System.out.print("Enter text:");
					inputString = stdin.readLine();
				}
				
				
				if(inputOptionNumber == 7 )
				{
					System.out.print("Enter identifier:");
					inputString = stdin.readLine().trim();
					
					System.out.print("Enter how much:");
					inputVal1 = Integer.parseInt( stdin.readLine().trim() );
				}
				
				if(inputOptionNumber == 8 )
				{
					System.out.print("Enter identifier:");
					inputString = stdin.readLine().trim();
				}
				
				if( inputOptionNumber == 26 || inputOptionNumber == 28 )
				{
					System.out.print("Enter value:");
					inputVal1 = Integer.parseInt( stdin.readLine().trim() );
				}
				
				if( inputOptionNumber == 27 || inputOptionNumber == 29)
				{
					System.out.print("Enter range 1:");
					inputVal1 = Integer.parseInt( stdin.readLine().trim() );
					
					System.out.print("Enter range 2:");
					inputVal2 = Integer.parseInt( stdin.readLine().trim() );
				}
				
				loopCondition = myShop.pressTheButton( 
													  inputOptionNumber, 
													  inputString, 
													  inputVal1, 
													  inputVal2,
													  inputPath
													 );
			} 
			catch (NumberFormatException e) 
			{
				System.out.println("Unknown format...");
			}
		}
		
		System.out.println("CBookstoreApp has been successfully terminated...");
	}
}
