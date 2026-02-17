package guiPopups;

import java.awt.*;

import javax.swing.JOptionPane;

public class CInfoPopup
{
	public CInfoPopup(Component parent, String str)
	{
		this(parent, str, "Information");
	}
	
	public CInfoPopup(Component parent, String str, String title)
	{
		JOptionPane.showMessageDialog
		(
			parent,
	        str,
	        title,
			JOptionPane.INFORMATION_MESSAGE
		);
	}
	
}
