package filters;

import java.util.ArrayList;
import java.util.List;

import cargos.CLiterature;
import cargos.CELiterature;

import myUtils.NSListUtils;
import myUtils.NSStringUtils;

public class ELiteratureFilters
{
	public static List<CLiterature> filterBySizeOfFile(List<CLiterature> argList, float val)
	{
		List<CELiterature> onlyELiterature = NSListUtils.filterByType(argList, CELiterature.class);
		
		List<CELiterature> filteredELiteratureList = NSListUtils.search(
														                onlyELiterature, 
														                item 
														                -> 
														                val 
														                == 
														                item.getSizeOfFile() 
								                         	 	       );
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredELiteratureList);
		
		return result;
	}
	
	public static List<CLiterature> filterByFileExtension(List<CLiterature> argList, String str)
	{
		List<CELiterature> onlyELiterature = NSListUtils.filterByType(argList, CELiterature.class);
		
		List<CELiterature> filteredELiteratureList = 
				NSListUtils.search
				(
					onlyELiterature, 
					item -> NSStringUtils.startsWithIgnoreCase(item.getFileExtension(), str) 
				);
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredELiteratureList);
		
		return result;
	}
	

}
