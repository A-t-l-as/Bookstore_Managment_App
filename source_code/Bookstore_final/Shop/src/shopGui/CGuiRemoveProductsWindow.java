package shopGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CGuiRemoveProductsWindow extends ACGuiSubWindowWithButtons
{
//public:
	  public CGuiRemoveProductsWindow(
			  						  CGuiWindowAndTableService argWindowAndTableService, 
			  						  JButton argButton, 
			  						  String argTitle
			  			   			 )
	  {
		  // 400 x 130
		  super(argWindowAndTableService, argButton, argTitle, 400, 130);
	  }

//protected:
	  
	  	//-------------------------
	  	// Remove products BUTTONS:
	  	//-------------------------
	   
	  	@Override
	  	protected void createAllButtons(JPanel panel)
	  	{	
	        panel.add( buttonsFac.createRemoveSingleRowButton()  );
	        panel.add( buttonsFac.createRemoveZeroStatesButton() );
	  	}
}
