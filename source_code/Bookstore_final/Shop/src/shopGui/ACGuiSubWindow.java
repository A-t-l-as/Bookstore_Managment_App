package shopGui;

import javax.swing.JButton;
import javax.swing.JFrame;

// Okno ktore jest podoknem jakiegos parenta i doczepiane jest do jakiegos buttona.
public abstract class ACGuiSubWindow
{
//public:
	public ACGuiSubWindow(
						  CGuiWindowAndTableService argWindowAndTableService, 
						  JButton argButton, 
						  String argTitle,
						  int argWidth,
						  int argHeight
						 )
	{
		this.pWindowAndTableService = argWindowAndTableService;
		
		argButton.addActionListener
		(
			e -> 
			showWindowDialog
			( 
				pWindowAndTableService.getPParent(), 
				argTitle, 
				argWidth, 
				argHeight 
			)
		);
		
	}

	
//protected:
	protected CGuiWindowAndTableService pWindowAndTableService;
	
	protected abstract void showWindowDialog(
											 JFrame argParent,
											 String argTitle, 
											 int argWidth, 
											 int argHeight
											);
	
	
}
