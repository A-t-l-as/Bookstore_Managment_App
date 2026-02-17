package guiPopups;

import java.awt.Component;

import javax.swing.JOptionPane;

public class CConfirmPopup
{
//public:
	
	public CConfirmPopup(Component parent, String str)
	{
		this(parent, str, "Confirmation");
	}
	
	public CConfirmPopup(Component parent, String str, String title)
	{
		 this.optionResult = JOptionPane.showConfirmDialog
				             (
				               parent,
				               str,
				               title,
					           JOptionPane.YES_NO_OPTION,
					           JOptionPane.QUESTION_MESSAGE
				             );
	}
	
	public int getOptionResult()
	{
		return this.optionResult;
	}
	
//private:
	private int optionResult;
	
	
}
