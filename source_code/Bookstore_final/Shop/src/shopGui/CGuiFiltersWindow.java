package shopGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CGuiFiltersWindow extends ACGuiSubWindowWithButtons
{
//public:
	  public CGuiFiltersWindow(
			  				   CGuiWindowAndTableService argWindowAndTableService, 
			  				   JButton argButton, 
			  				   String argTitle
			  				  )
	  {
		  // 640 x 480
		  super(argWindowAndTableService, argButton, argTitle, 640, 480);
	  }

	  
//protected:
	  
	  //----------------
	  // FILTER BUTTONS:
	  //----------------
	   
	  @Override
	  protected void createAllButtons(JPanel panel)
	  {
		    panel.add( this.buttonsFac.createResetButton("reset all filters") );
	        
	        // Stworzenie przyciskow filtrujacych po wcisnieciu ktorych wprowadza 
		    // sie tylko string.
	        for(CDatabase.ENTextField field : CDatabase.ENTextField.values())
	        {
	        	panel.add( this.buttonsFac.createFilterBySthButStringButton(field) );
	        }
	        
	        // Stworzenie przyciskow filtrujacych po wcisnieciu ktorych 
	        // wprowadza sie tylko jeden int.
	        for(CDatabase.ENIntField field : CDatabase.ENIntField.values())
	        {
	        	panel.add( this.buttonsFac.createFilterBySthButIntButton(field) );
	        }
	        
	        // Stworzenie przyciskow filtrujacych po wcisnieciu ktorych wprowadza sie zakres.
	        for(CDatabase.ENIntRangeField field : CDatabase.ENIntRangeField.values())
	        {
	        	panel.add( this.buttonsFac.createFilterBySthInRangeButton(field) );
	        }
	        
	        // Stworzenie przyciskow filtrujacych po wcisnieciu ktorych wprowadza sie date.
	        for(CDatabase.ENDateField field : CDatabase.ENDateField.values())
	        {
	        	panel.add( this.buttonsFac.createFilterBySthButDateButton(field) );
	        }
	        
	        // Stworzenie przyciskow filtrujacych po wcisnieciu ktorych wprowadza sie zakres dat.
	        for(CDatabase.ENDateField field : CDatabase.ENDateField.values())
	        {
	        	panel.add( this.buttonsFac.createFilterBySthButDateInRangeButton(field) );
	        }
	    }
	   
}
