package shopGui;


import java.awt.*;
import javax.swing.*;


public class CGuiTextAreaWindow extends ACGuiSubWindow
{
//public:
	public CGuiTextAreaWindow(
							  CGuiWindowAndTableService argWindowAndTableService, 
							  JButton argButton, 
							  String argTitle
							 )
	{
		// 1000 x 600
		super(argWindowAndTableService, argButton, argTitle, 1000, 600);
	}
	
//protected:
	
	@Override
	protected void showWindowDialog(JFrame argParent, String argTitle, int argWidth, int argHeight)
	{	    
		// Tworzenie okna
		JFrame infoWindow = new JFrame(argTitle);
		infoWindow.setSize(argWidth, argHeight);
		infoWindow.setLocationRelativeTo(argParent);
		    
		// TextArea do wyświetlania
		JTextArea textArea = new JTextArea( 
										   this
										   .
										   pWindowAndTableService
										   .
										   getPShopDatabase()
										   .
										   getDetailedViewStr()
										  );
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial", Font.PLAIN, 14));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		    
		// ScrollPane
		JScrollPane scrollPane = new JScrollPane(textArea);
		infoWindow.add(scrollPane);
		    
		infoWindow.setVisible(true);
	}
	
	
	
}
