package shopGui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import guiPopups.CInfoPopup;

public class CGuiWindowAndTableService
{
//public:
	
	public CGuiWindowAndTableService(
									 JFrame argPParent, 
									 CDatabase argShopDatabase
									)
	{
		this.pParent        = argPParent;
	    this.pShopDatabase = argShopDatabase;
		
        // Tabela z danymi
        // Tutaj tworze tableModel i przypisuje mu etykiety z magazynu.
        this.pTableModel = new DefaultTableModel( argShopDatabase.getLabelsArrayFromStock(), 0);
        this.pTable = new JTable(pTableModel);
        
        // Wlacz sortowanie po kliknięciu naglowka
        this.pTable.setAutoCreateRowSorter(true);
        
        this.pStatsLabel = new JLabel("Number of items: 0");
        
        // Gorny panel ze stanem pieniedzy:
        this.pMoneyStatusLabel = new JLabel( this.pShopDatabase.getMoneyStatus() );
        this.pMoneyStatusLabel.setFont( new Font("Arial", Font.BOLD, 16) );
        this.pMoneyStatusLabel.setForeground(new Color(0, 100, 0)); 
	}
	
	//---------
	// Refresh:
    public void refreshTableAndWindow()
    {
        // Czyszczenie tabeli
        pTableModel.setRowCount(0);
        
        // Dodawanie danych z magazynu
        Object[][] data = this.pShopDatabase.getDataForTableFromStockView();
        
        for (Object[] row : data) 
            pTableModel.addRow(row);
        
        pStatsLabel.setText("Number of items: " + this.pShopDatabase.getStockViewSize() );
        pMoneyStatusLabel.setText( this.pShopDatabase.getMoneyStatus() );
    }
    
   
    //----------------------
    // Two clicks on labels:
    public void programLabelsThatWillBeClickedTwice()
    {
    	final int twoClicks = 2;
    	
        // Podwójny klik na nagłówku resetuje sortowanie
        pTable.getTableHeader().addMouseListener
        (
        	new MouseAdapter() 
        	{
        		@Override
        		public void mouseClicked(MouseEvent e) 
        		{
        			if (e.getClickCount() == twoClicks) 
        			{
        				resetSorting();
        			}
        		}
        	}
        );
    }
    
    //---------------
    // Reset sorting:
    public void resetSorting() 
    {
    	// Resetowanie sortowania
    	pTable.setRowSorter(null);
    	pTable.setAutoCreateRowSorter(true);
    	new CInfoPopup( pParent, "Sorting reset!\nClick the header again to sort.");
    }
    
    //-------
    // Debug:
    public void programSituationWhenTableWillBeSorted()
    {
        // Debug:
    	// Dodanie listenera do sledzenia sortowania
        pTable.getRowSorter().addRowSorterListener
        (
        	e -> 
        	{
        		System.out.println("The table has been sorted.");
        	}
        );
    	
    }
    
    //---------
    // Getters:
    public JFrame getPParent()
    {
    	return this.pParent;
    }
    
    public CDatabase getPShopDatabase()
    {
    	return this.pShopDatabase;
    }
    
	public JTable getPTable()
	{
		return this.pTable;
	}
	
	public DefaultTableModel getPTableModel()
	{
		return this.pTableModel;
	}
	
	public JLabel getPStatsLabel()
	{
		return this.pStatsLabel;
	}
	
	public JLabel getPMoneyStatusLabel()
	{
		return this.pMoneyStatusLabel;
	}
   
	
//private:
    private JFrame pParent;
    private CDatabase pShopDatabase;

    private JTable pTable;
    private DefaultTableModel pTableModel;
    
    private JLabel pStatsLabel;
    private JLabel pMoneyStatusLabel;
}
