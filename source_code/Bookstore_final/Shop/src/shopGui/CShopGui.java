package shopGui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import guiPopups.CInfoPopup;
import guiPopups.CConfirmPopup;

public class CShopGui extends JFrame
{
    /*
     * 
	 * 
	*/
	private static final long serialVersionUID = 9022193614917495229L;

	//public:
    public CShopGui(String title, int sizeX, int sizeY)
    {
		this.initialize();
        initializeUI(title, sizeX, sizeY);
    }
  
//private:
    
    private CGuiProgrammedButtonsFactory buttonsFac;
    private CDatabase shopDatabase;
    private CGuiWindowAndTableService windowAndTableService;

    private JFrame pThisFrame;
    
    // Inicjalizacja wstepna:
	private void initialize()
	{
		this.pThisFrame = this;
		this.shopDatabase = new CDatabase(this);
		
		this.windowAndTableService = new CGuiWindowAndTableService
				 					 (
				 						this.pThisFrame, 
				 						this.shopDatabase
				 					 );
		
		this.buttonsFac = new CGuiProgrammedButtonsFactory(this.windowAndTableService);

	}
	
    private void initializeUI(String title, int sizeX, int sizeY)
    {
        setTitle(title);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(sizeX, sizeY);
        setLayout(new BorderLayout());
        
        // Gorny panel z przyciskami
        JPanel topPanel = new JPanel();
        
        topPanel.add( buttonsFac.createResetButton("Normal view")      );
        topPanel.add( buttonsFac.createSimpleViewButton()              );	
        topPanel.add( buttonsFac.createDetailedViewButton()            );
        
        topPanel.add( buttonsFac.createAceeptanceOfGoodsParentButton() );
        
        topPanel.add( buttonsFac.createSellProductsParentButton()      );
   
        topPanel.add( buttonsFac.createRemoveProductsParentButton()    );
        
        topPanel.add( buttonsFac.createReverseButton()                 );
        
        topPanel.add( buttonsFac.createFilterParentButton()            );
        topPanel.add( buttonsFac.createSortParentButton()              );
        
        topPanel.add( buttonsFac.createRefreshButton()                 );
        
        watchWindowOpened();
        watchWindowClosing();
          
        // Dodanie listenera do sledzenia sortowania
        this.windowAndTableService.programSituationWhenTableWillBeSorted();
        this.windowAndTableService.programLabelsThatWillBeClickedTwice();
        //------------------------------------------
        
        JScrollPane scrollPane = new JScrollPane( this.windowAndTableService.getPTable() );
        
        // Dolny panel ze statystykami:
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottomPanel.add( this.windowAndTableService.getPStatsLabel() );
        
        // Gorny panel z przyciskami i stanem pieniedzy
        topPanel.add( this.windowAndTableService.getPMoneyStatusLabel() );
        
        // Dodanie komponentow do ramki
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
		    
        windowAndTableService.refreshTableAndWindow();
    }
   
   
   
	//--------------------------------------------------------------------------
	// Sytuacje dziejace sie na starcie aplikacji czyli wtedy gdy wyskoczy okno:
	//--------------------------------------------------------------------------
	
	// obserwator wyskakujacego okna:
	private void watchWindowOpened()
	{
		addWindowListener
		(
			new WindowAdapter()
			{
				@Override
				public void windowOpened(WindowEvent e)
				{
					shopDatabase.load();
					windowAndTableService.refreshTableAndWindow();
				}
			}
		);
	}
	
	//------------------------------------------------
	// Sytuacje dziejace sie przy zamykaniu aplikacji:
	//------------------------------------------------
	
	// obserwator zamykania aplikacji:
	private void watchWindowClosing()
	{  	
	    	addWindowListener
	    	(
	    		new WindowAdapter()
	    		{
	    			@Override
	    			public void windowClosing(WindowEvent e)
	    			{
	    				int option = new CConfirmPopup
	    							 (
	    								pThisFrame,
	    								"Are you sure you want to close the application?"
	    							 )
	    							 .
	    							 getOptionResult();
	                
	    				if (option == JOptionPane.YES_OPTION)
	    				{
	    					// Wyświetl komunikat o zapisywaniu
	    					new CInfoPopup
	    					(
	    						pThisFrame, 
	    						"The database and safe will be saved.",
	    						"Saving"
	    					);
	    				
	    					shopDatabase.save();
	                    
	    					dispose();
	    					System.exit(0);
	    				}
	   
	    				
	    			}
	    		}
	    	);
	    	
	}
	
}