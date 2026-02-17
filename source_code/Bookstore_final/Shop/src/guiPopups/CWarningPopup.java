package guiPopups;

import java.awt.Component;

import javax.swing.JOptionPane;

public class CWarningPopup
{
	public CWarningPopup(Component parent, String str)
	{
		this(parent, str, "Warning");
	}
	
	public CWarningPopup(Component parent, String str, String title)
	{
		JOptionPane.showMessageDialog
		(
			parent,
	        str,
	        title,
			JOptionPane.WARNING_MESSAGE
		);
	}
}
