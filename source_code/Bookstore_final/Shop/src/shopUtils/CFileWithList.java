package shopUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

import myUtils.NSFileUtils;
import exceptions.FileWithListException;

public class CFileWithList
{
//public:
	public CFileWithList(Path argFilePath, ENItemType itemType)
			throws IOException, FileWithListException
	{
		
		this.mList = new ArrayList<CPosition>();
		
		String formatStr = NSFileUtils.getFileExtension(argFilePath);
		
		if( !formatStr.equals(NSFileUtils.csvFormatName) )
		{
			throw new FileWithListException
			(
				"The file should be in csv format!"
			);
		}
		
		this.loadFromFile(argFilePath, itemType);
	}
	
	public enum ENItemType
	{
		INVALID,
		IDENTIFIER,
		TITLE
	}
	
	public List<CPosition> getListOfPositions()
	{
		return this.mList;
	}
	
//private:
	private List<CPosition> mList;
	
	private void loadFromFile(Path argCsvFilePath, ENItemType itemType) 
			throws IOException, FileWithListException
	{
		BufferedReader fin = new BufferedReader( new FileReader( argCsvFilePath.toString() ) );
		
		String line = new String();
		String[] parts;
		
		while((line = fin.readLine()) != null)
		{	
			parts = line.split(";");
			
			if(parts.length != 2)
			{
				fin.close();
				
				throw new FileWithListException
				(
					"The file containing the list of items contains incorrect data."
				);
			}
			
			switch(itemType)
			{
				case ENItemType.IDENTIFIER:
					this.mList.add( new CPosition(parts[0].trim(), parts[1]) );
				break;
					
				case ENItemType.TITLE:
					this.mList.add( new CPosition(parts[0], parts[1]) );
				break;
					
				default:
					fin.close();
					
					throw new FileWithListException
					(
						"The position should be either an identifier or a title."
					);
			}
			
		}
		
		fin.close();
	}
}
