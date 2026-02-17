package shopGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CGuiSellGoodsWindow extends ACGuiSubWindowWithButtons
{
//public:
	  public CGuiSellGoodsWindow(
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
	  	// Sell goods BUTTONS:
	  	//--------------------
	   
	  	@Override
	  	protected void createAllButtons(JPanel panel)
	  	{  		
	        panel.add( this.buttonsFac.createSellMultipleProductButton() );
	        panel.add( this.buttonsFac.createSellSingleProductButton()   );
	  	}

}
