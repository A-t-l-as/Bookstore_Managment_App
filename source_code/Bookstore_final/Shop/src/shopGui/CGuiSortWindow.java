package shopGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CGuiSortWindow extends ACGuiSubWindowWithButtons
{
//public:
	  public CGuiSortWindow(
			  				CGuiWindowAndTableService argWindowAndTableService, 
			  				JButton argButton, 
			  				String argTitle
			  			   )
	  {
		  // 640 x 480
		  super(argWindowAndTableService, argButton, argTitle, 640, 480);
	  }
	  
	  

//protected:
	  
	  	//--------------
	  	// SORT BUTTONS:
	  	//--------------
	   
	  	@Override
	  	protected void createAllButtons(JPanel panel)
	  	{	  		
	  		panel.add( this.buttonsFac.createResetButton() );
	        
	        // Stworzenie przyciskow sortujacych dla kazdego pola.
	        for(CDatabase.ENAllSortingTypes field : CDatabase.ENAllSortingTypes.values())
	        {
	        	panel.add(this.buttonsFac.createSortBySthButton(field));
	        }
	  	}  	    
}
