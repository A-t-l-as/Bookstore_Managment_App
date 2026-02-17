package demos;

import javax.swing.*;

import shopGui.CShopGui;

public class CShopGuiDemo
{
    public CShopGuiDemo()
    {
        SwingUtilities.invokeLater
        (
        		new Runnable() 
        		{
        			@Override
        			public void run() 
        			{
        				new CShopGui("Shop GUI", 1920, 1080).setVisible(true);
        			}
        		}
        );
    }
}
