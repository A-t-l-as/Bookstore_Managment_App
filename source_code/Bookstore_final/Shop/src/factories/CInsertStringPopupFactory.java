package factories;

import java.awt.*;

import guiPopups.CInsertStringPopup;

public class CInsertStringPopupFactory
{
//public:
	public CInsertStringPopupFactory( Component argParent )
	{
		this.parent = argParent;
	}
	
	public String createAndGetStr()
	{
		return new CInsertStringPopup(this.parent).getResult();
	}
	
	public String createAndGetStr(String str)
	{
		return new CInsertStringPopup(this.parent, str).getResult();
	}
	
	public String createAndGetStr(String str, String title)
	{
		return new CInsertStringPopup(this.parent, str, title).getResult();
	}
	
//private:
	private Component parent;
	
}
