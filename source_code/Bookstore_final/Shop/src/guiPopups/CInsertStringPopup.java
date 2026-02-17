package guiPopups;

import javax.swing.JOptionPane;
import java.awt.*;

public class CInsertStringPopup
{
//public:	
	public CInsertStringPopup(Component parent)
	{
		this(parent, "Insert text: " , "Input popup");
	}
	
	public CInsertStringPopup(Component parent, String str)
	{
		this(parent, str, "Input popup");
	}
	
	public CInsertStringPopup(Component parent, String str, String title)
	{
        this.result = 
        JOptionPane.showInputDialog
        (
        	parent,                    
            str,       
            title,            
            JOptionPane.PLAIN_MESSAGE 
        );
        
        
        if (this.result != null && !this.result.trim().isEmpty())
        {      
            new CInfoPopup(parent, "Entered text: " + this.result);
            return;
        } 
     
        new CInfoPopup(parent, "Cancelled or empty text entered.");
        this.result = "";
	}
	
	public String getResult()
	{
		return this.result;
	}
	
	
//private:
	private String result;
}
