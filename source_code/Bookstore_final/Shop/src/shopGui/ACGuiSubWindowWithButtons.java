package shopGui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;


public abstract class ACGuiSubWindowWithButtons extends ACGuiSubWindow
{
//public:
	public ACGuiSubWindowWithButtons(
			  						 CGuiWindowAndTableService argWindowAndTableService, 
			  						 JButton argButton, 
			  						 String argTitle,
			  						 int argWidth,
			  						 int argHeight
			  						)
	{
		  super(argWindowAndTableService, argButton, argTitle, argWidth, argHeight);
		  this.buttonsFac = new CGuiProgrammedButtonsFactory(pWindowAndTableService);
	}
	  
//protected:
	protected CGuiProgrammedButtonsFactory buttonsFac;
	  
	@Override
	protected void showWindowDialog(JFrame argParent, String argTitle, int argWidth, int argHeight)
	{
		  	
	       	JDialog windowDialog = new JDialog(argParent, argTitle, true);
	        windowDialog.setSize(argWidth, argHeight);
	        windowDialog.setLayout( new BorderLayout() );
	        
	        // Panel z przyciskami, ktore beda robic X
	        JPanel panel = new JPanel( new GridLayout(0, 2, 10, 10) );
	        panel.setBorder( BorderFactory.createEmptyBorder(10, 10, 10, 10) );
	        
	        // tworze wszystkie przyciski, ktore robia X
	        createAllButtons(panel);
	        
	        // Przycisk zamknięcia
	        JButton closeButton = new JButton("Close");
	        closeButton.addActionListener(e -> windowDialog.dispose());
	        // --------------------
	        
	        windowDialog.add(panel, BorderLayout.CENTER);
	        windowDialog.add(closeButton, BorderLayout.SOUTH);
	        windowDialog.setLocationRelativeTo(argParent);
	        windowDialog.setVisible(true);
	 }  
	  
	  
	 protected abstract void createAllButtons(JPanel panel);
}
