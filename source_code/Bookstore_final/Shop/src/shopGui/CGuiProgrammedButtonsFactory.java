package shopGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import exceptions.DateException;

import javax.swing.JButton;

import guiPopups.CChooseFilePopup;
import guiPopups.CErrorPopup;

import factories.CInsertStringPopupFactory;

public class CGuiProgrammedButtonsFactory
{  
//public:
	  public CGuiProgrammedButtonsFactory(CGuiWindowAndTableService argWindowAndTableService)
	  {
		  this.pWindowAndTableService = argWindowAndTableService;
		  this.pShopDatabase = this.pWindowAndTableService.getPShopDatabase();
		  this.pParent = this.pWindowAndTableService.getPParent();
		  
		  this.pInsStrPopupFac = this.pShopDatabase.getInsStrPopupFac();
	  }
	
	  //--------------
	  // Reset button:
	  public JButton createResetButton()
	  {
		  return createResetButton("reset");
	  }
	    
	  public JButton createResetButton(String buttonName)
	  {          
	        JButton resetFiltersButton = new JButton(buttonName);
		  
	        resetFiltersButton.addActionListener
	        ( 
	        	e -> 
	        	{
	        		this.pShopDatabase.refreshStockView(); 
	        		this.pWindowAndTableService.refreshTableAndWindow(); 
	        	} 
	        );
	        
	        return resetFiltersButton;
	  }
	  
	  //--------------------
	  // Simple view button:
	  public JButton createSimpleViewButton()
	  {
		  JButton simpleViewButton = new JButton("Simple view");
		  
	  	  simpleViewButton.addActionListener
	      (
	          new ActionListener()
	          {
	        	  @Override
	        	  public void actionPerformed(ActionEvent e) 
	        	  {
	        		  pShopDatabase.setStockViewToSimpleView();
	        		  pWindowAndTableService.refreshTableAndWindow();
	        	  }
	          }
	      );
	  	  
	  	  return simpleViewButton;
	  }
	  
	  //----------------------
	  // Detailed view button:
	  public JButton createDetailedViewButton()
	  {
		  final String detailedViewStr = "Detailed view";
		  
		  JButton detailedViewButton = new JButton(detailedViewStr);
		  
		  new CGuiTextAreaWindow
		  (
		    pWindowAndTableService, 
		    detailedViewButton, 
		    detailedViewStr
		  );
		  
		  return detailedViewButton;
	  }
	  
	  //-----------------------------------
	  // Acceptance of goods parent button:
	  public JButton createAceeptanceOfGoodsParentButton()
	  {
	      JButton acceptanceOfGoodsParentButton = new JButton("Acceptance of Goods");
	        
	      new CGuiAcceptanceOfGoodsWindow
	      (
	    	pWindowAndTableService, 
	    	acceptanceOfGoodsParentButton, 
	    	"Acceptance of goods window"
	      );
			
		  return acceptanceOfGoodsParentButton;
	  }
	  
	  //---------------------
	  // Accept goods button:
	  public JButton createAcceptGoodsButton()
	  {
		  JButton acceptGoodsButton = new JButton("Accept goods from file");
		  
	        acceptGoodsButton.addActionListener
	        (
	        	new ActionListener()
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			pShopDatabase.acceptanceOfGoods
	        			( 
	        				new CChooseFilePopup(pParent).getResult() 
	        			);
	        			
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
		  
	       return acceptGoodsButton;
	  }
	  
	  //---------------------------
	  // Add single product button:
	  public JButton createAddSingleProductButton()
	  {
		    JButton addSingleProductButton = new JButton("Add single product");
		  
			// add single product button:
			addSingleProductButton.addActionListener
	        (
	        	new ActionListener()
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			pShopDatabase.addSingleProduct
	        			( 
	        				pInsStrPopupFac
	        				.
	        				createAndGetStr("Insert CSV string with ';': ")
	        			); 
	        			
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
			
			return addSingleProductButton;
		}
	  
	  	//-----------------------------
	  	// Sell products parent button:
	  	public JButton createSellProductsParentButton()
	  	{
		    JButton sellProductsParentButton = new JButton("Sell products");
		        
		    new CGuiSellGoodsWindow
		    (
		    	pWindowAndTableService, 
		    	sellProductsParentButton, 
		    	"Sell products window"
		    );
				
			return sellProductsParentButton;
	  	}
	  
		//-------------------------------
	  	// Sell multiple products button:
		public JButton createSellMultipleProductButton()
		{
			JButton sellMultipleProductsButton = new JButton("Sell multiple products");
			
			sellMultipleProductsButton.addActionListener
	        (
	        	new ActionListener()
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			pShopDatabase.sellProductsFromList
	        			( 
	        				new CChooseFilePopup(pParent).getResult() 
	        			);
	        			
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
			
			return sellMultipleProductsButton;
		}
	  
		//----------------------------
		// sell single product button: 
		public JButton createSellSingleProductButton()
		{
			JButton sellSingleProductButton = new JButton("Sell single product");
			
			// SellSingleProductButton:
			sellSingleProductButton.addActionListener
	        (
	        	new ActionListener()
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			String ean = 
	        					pInsStrPopupFac
	        					.
	        					createAndGetStr("Insert EAN: ");
	        			
	        			try
	        			{
	        				String valueInStr = 
	        						pInsStrPopupFac
	        						.
	        						createAndGetStr("How much?: ");
	        				
	        				if(!valueInStr.trim().isEmpty())
	        				{
	        					int howMuch = Integer.parseInt(valueInStr);	
	        					pShopDatabase.sellSingleProduct(ean, howMuch); 
	        				}
	        				
	        			}
	        			catch(NumberFormatException nfe)
	        			{
	        				new CErrorPopup
	        				(
	        					pParent, 
	        					"The value has been entered incorrectly. " + 
	        					"Please ensure that it is a numerical value."
	        			    );
	        			}
	        			
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
			
			return sellSingleProductButton;
		}
		
		//-------------------------------
		// Remove products parent button:
		public JButton createRemoveProductsParentButton()
		{
		    JButton removeProductsParentButton = new JButton("Remove products");
	        
		    new CGuiRemoveProductsWindow
		    (
		    	pWindowAndTableService, 
		    	removeProductsParentButton, 
		    	"Remove products window"
		    );
				
			return removeProductsParentButton;
		}
		
		
		//--------------------------
		// Remove Single Row Button:
		public JButton createRemoveSingleRowButton()
		{
			JButton removeSingleRowButton = new JButton("Remove single row");
			
			removeSingleRowButton.addActionListener
	        (
	        	new ActionListener()
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			pShopDatabase.removeSingleRow
	        			( 
	        				pInsStrPopupFac.createAndGetStr("Insert EAN: ")
	        			); 
	        			
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
			
			return removeSingleRowButton;
		}
		
		//---------------------------
		// Remove zero states button:
		public JButton createRemoveZeroStatesButton()
		{
			JButton removeZeroStatesButton = new JButton("Remove zero states");
			
			// removeZeroStatesButton:
			removeZeroStatesButton.addActionListener
	        (
	        	new ActionListener()
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			pShopDatabase.removeProductsWithZeroStock();
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
			
			return removeZeroStatesButton;
		}
		
		//----------------
		// Reverse button:
		public JButton createReverseButton()
		{
			JButton reverseButton = new JButton("Reverse");
			
			reverseButton.addActionListener
	        (
	        	new ActionListener()
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			pShopDatabase.reverseStockView();
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
			
			return reverseButton;
		}
		
		//----------------------
		// Filter parent button:
		public JButton createFilterParentButton()
		{
	        JButton filterButton = new JButton("Filter");
	        
			new CGuiFiltersWindow(pWindowAndTableService, filterButton, "Filters window");
			
			return filterButton;
		}
		
		//----------------
	    // Filter buttons:
	    public JButton createFilterBySthButStringButton(CDatabase.ENTextField field)
	    {          
	        JButton filterBtn = new JButton( "by " + field.toString().toLowerCase() );
	            
	        filterBtn.addActionListener
	        (
	             e ->
	             {
	            	 pShopDatabase.filterBySthButString(field, pInsStrPopupFac.createAndGetStr());
	            	 pWindowAndTableService.refreshTableAndWindow();
	             }
	        );
	               
	        return filterBtn;
	    }
	    
	    public JButton createFilterBySthButDateButton(CDatabase.ENDateField field)
	    {          
	        JButton filterBtn = 
	        		new JButton( "by " + field.toString().toLowerCase() + " that equals");
	            
	        filterBtn.addActionListener
	        (
	             e ->
	             {
	            	 try
	            	 {
	            		 pShopDatabase.filterBySthButDate
	            		 (
	            			field, 
	            			pInsStrPopupFac.createAndGetStr("Insert date: ") 
	            		 );
	            		 
	            		 pWindowAndTableService.refreshTableAndWindow();
	            	 }
	            	 catch(DateException de)
	            	 {
	            		 new CErrorPopup(pParent, de.getMessage());
	            	 }
	             }
	        );
	               
	        return filterBtn;
	    }
	    
	    public JButton createFilterBySthButDateInRangeButton(CDatabase.ENDateField field)
	    {          
	        JButton filterBtn = new JButton( "by " + field.toString().toLowerCase() + " in range");
	            
	        filterBtn.addActionListener
	        (
	             e ->
	             {
	            	 try
	            	 {
	            		 pShopDatabase.filterBySthButDateInRange
	            		 (
	            			field, 
	            			pInsStrPopupFac.createAndGetStr("Enter the date from: "),
	            			pInsStrPopupFac.createAndGetStr("Enter the date to: ") 
	            		 );
	            		 
	            		 pWindowAndTableService.refreshTableAndWindow();
	            	 }
	            	 catch(DateException de)
	            	 {
	            		 new CErrorPopup(pParent, de.getMessage());
	            	 }
	             }
	        );
	               
	        return filterBtn;
	    }

	    public JButton createFilterBySthButIntButton(CDatabase.ENIntField field)
	    {          
	        JButton filterBtn = 
	        		new JButton( "by " + field.toString().toLowerCase() + " that equal");
	            
	        
	        filterBtn.addActionListener
	        (
	             e ->
	             { 
	            	 try
	            	 {
	            		String valueInStr = 
	            				pInsStrPopupFac.createAndGetStr("Insert value: ");
	            		
	            		if(!valueInStr.trim().isEmpty())
	            		{
	            			int value = Integer.parseInt( valueInStr );
	            			pShopDatabase.filterBySthButInt(field, value );
	            		}
	            		
	            	 }
	            	 catch(NumberFormatException nfe)
	            	 {
	       				new CErrorPopup
	    				(
	    					pParent, 
	    					"The value has been entered incorrectly. " + 
	    					"Please ensure that it is a numerical value."
	    			    );
	            	 }
	            	 
	            	 pWindowAndTableService.refreshTableAndWindow();
	             }
	        );
	               
	        return filterBtn;
	    }
	    
	    public JButton createFilterBySthInRangeButton(CDatabase.ENIntRangeField field)
	    {          
	        JButton filterBtn = 
	        		new JButton( "by " + field.toString().toLowerCase() + " in closed range");
	            
	        filterBtn.addActionListener
	        (
	             e ->
	             { 
	            	 try
	            	 {
	            		String valueInStr1 = 
	            				pInsStrPopupFac
	            				.
	            				createAndGetStr("Enter the range from: ");
	            		
	            		String valueInStr2 = 
	            				pInsStrPopupFac
	            				.
	            				createAndGetStr("Enter the range to: ");
	            		
	            		if(!valueInStr1.trim().isEmpty() && !valueInStr2.trim().isEmpty())
	            		{
	            			int val1 = Integer.parseInt( valueInStr1 );
	            			int val2 = Integer.parseInt( valueInStr2 );
	            			pShopDatabase.filterBySthButInRange(field, val1, val2);
	            		}
	            		
	            	 }
	            	 catch(NumberFormatException nfe)
	            	 {
	       				new CErrorPopup
	    				(
	    					pParent, 
	    					"The value has been entered incorrectly. " + 
	    					"Please ensure that it is a numerical value."
	    			    );
	            	 }
	            	 
	            	 pWindowAndTableService.refreshTableAndWindow();
	             }
	        );
	               
	        return filterBtn;
	    }
		
		
		//--------------------
	    // Sort Parent button:
	 	public JButton createSortParentButton()
	 	{
	 		JButton sortButton = new JButton("Sort");
	 		
	 		new CGuiSortWindow(pWindowAndTableService, sortButton, "Sort window");
	 		
	 		return sortButton;
	 	}
	 	
		//--------------------
	    // Sort by sth button:
	    public JButton createSortBySthButton(CDatabase.ENAllSortingTypes field)
	    {          
	        JButton sortBySthButton;
	  		
	  		if(field == CDatabase.ENAllSortingTypes.DEFAULT)
	  		{
	  			sortBySthButton = new JButton("default sort");
	  		}
	  		else
	  		{
	  			sortBySthButton = new JButton( "by " + field.toString().toLowerCase() );
	  		}
	        
	  		sortBySthButton.addActionListener
	        (
	             e ->
	             {
	            	 this.pShopDatabase.sortBySth(field);
	            	 this.pWindowAndTableService.refreshTableAndWindow();
	             }
	        );
	               
	  		return sortBySthButton;
	    }
	 	
	 	//----------------
	 	// Refresh button:
	 	public JButton createRefreshButton()
	 	{
	 		JButton refreshButton = new JButton("Refresh");
	        
	        refreshButton.addActionListener
	        (
	        	new ActionListener() 
	        	{
	        		@Override
	        		public void actionPerformed(ActionEvent e) 
	        		{
	        			pWindowAndTableService.refreshTableAndWindow();
	        		}
	        	}
	        );
	 		
	 		return refreshButton;
	 	}
		
		
//private:
	 private JFrame pParent;
	 private CGuiWindowAndTableService pWindowAndTableService;
	 private CDatabase pShopDatabase;
	 private CInsertStringPopupFactory pInsStrPopupFac;
}
