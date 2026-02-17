package filters;

import java.util.ArrayList;
import java.util.List;

import cargos.CAudioBook;
import cargos.CLiterature;
import myUtils.NSListUtils;
import myUtils.NSStringUtils;

import java.time.LocalTime;

public class AudioBookFilters
{
	public static List<CLiterature> filterByDuration(List<CLiterature> argList, LocalTime t)
	{
		List<CAudioBook> onlyAudioBooks = NSListUtils.filterByType( argList, CAudioBook.class );
		
		List<CAudioBook> filteredAudioBooksList = NSListUtils.search(
																	 onlyAudioBooks, 
																	 item 
																	 -> 
																	 t 
																	 .
																	 equals
																	  (
																	   item.getDuration()
																	  )
								                           			);
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredAudioBooksList);
		
		return result;
	}
	
	public static List<CLiterature> filterByLector(List<CLiterature> argList, String str)
	{
		List<CAudioBook> onlyAudioBooks = NSListUtils.filterByType( argList, CAudioBook.class );
		
		List<CAudioBook> filteredAudioBooksList = 
				NSListUtils.search
				(
				   onlyAudioBooks, 
				   item -> NSStringUtils.startsWithIgnoreCase(item.getLector(), str)
				);
		
		List<CLiterature> result = new ArrayList<CLiterature>();
		result.addAll(filteredAudioBooksList);
		
		return result;
	}
}
