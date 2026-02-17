package guiPopups;

import java.awt.Component;

import javax.swing.JOptionPane;

public class CErrorPopup
{
	public CErrorPopup(Component parent, String str)
	{
		this(parent, str, "Error");
	}
	
    public CErrorPopup(Component parent, String str, String title)
    {
	     JOptionPane.showMessageDialog
	     (
	        parent,
	        str,
	        title,
	        JOptionPane.ERROR_MESSAGE
	     );
    }
}
