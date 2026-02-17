package apps;

import javax.swing.SwingUtilities;

import shopGui.CShopGui;

public class CBookstoreGuiApp implements IApp
{
//public:
    public CBookstoreGuiApp()
    {}

    @Override
    public void run(String[] args)
    {
        SwingUtilities.invokeLater
        (
        	new Runnable() 
        	{
        		@Override
        		public void run() 
        		{
        			new CShopGui("Bookstore GUI", 1920, 1080).setVisible(true);
        		}
        	}
        );
    }
}
