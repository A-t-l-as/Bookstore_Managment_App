package shopGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CGuiAcceptanceOfGoodsWindow extends ACGuiSubWindowWithButtons
{
//public:
	  public CGuiAcceptanceOfGoodsWindow(
			  							 CGuiWindowAndTableService argWindowAndTableService, 
			  							 JButton argButton, 
			  							 String argTitle
			  			   				)
	  {
		  // 400 x 130
		  super(argWindowAndTableService, argButton, argTitle, 400, 130);
	  }

//protected:
	  
	  	//--------------------
	  	// Acceptance BUTTONS:
	  	//--------------------
	   
	  	@Override
	  	protected void createAllButtons(JPanel panel)
	  	{	
			panel.add( this.buttonsFac.createAcceptGoodsButton()      );
			panel.add( this.buttonsFac.createAddSingleProductButton() );
	  	}
}
