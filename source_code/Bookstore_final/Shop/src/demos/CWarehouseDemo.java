package demos;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

import exceptions.LiteratureFactoryException;
import exceptions.WarehouseException;
import factories.CLiteratureFactory;
import warehouse.CInteractiveWarehouse;
import cargos.CAudioBook;

public class CWarehouseDemo extends ACObjectDemo
{
	public CWarehouseDemo()
	{
		super(new CInteractiveWarehouse());
		
		System.out.println("Tworze magazyn literatureWarehouse:");
		this.printConstructor("literatureWarehouse", "");
		CInteractiveWarehouse literatureWarehouse = new CInteractiveWarehouse();
		System.out.println();
		
		String literatureDatabaseFileName = "literature_database.csv";
		
		Path literatureDatabaseFilePath = 
				Paths.get("").toAbsolutePath().resolve(literatureDatabaseFileName);
		
		System.out.println("Wczytuję plik o ścieżce:" + literatureDatabaseFilePath);
		try
		{
			System.out.println("literatureWarehouse.loadFromFile(literatureDatabaseFilePath);");
			literatureWarehouse.loadFromFile(literatureDatabaseFilePath);
			
			System.out.println("\nWyświetlam stan magazynu...");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			literatureWarehouse.showWarehouseStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu...");
			System.out.println("literatureWarehouse.sort();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sort(); // testowanie sortowania
			literatureWarehouse.showWarehouseDetailedStatus();
			literatureWarehouse.showWarehouseStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu wzgledem identyfikatorow...");
			System.out.println("literatureWarehouse.sortByIdentifier();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sortByIdentifier(); // testowanie sortowania2
			literatureWarehouse.showWarehouseStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu wzgledem ceny...");
			System.out.println("literatureWarehouse.sortByPrice();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sortByPrice(); // testowanie sortowania2
			literatureWarehouse.showWarehouseStatus();
			
			System.out.println();
			
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu wzgledem daty przyjecia...");
			System.out.println("literatureWarehouse.sortByDateOfAcceptance();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sortByDateOfAcceptance(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println();
			
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu wzgledem typu obiektu...");
			System.out.println("literatureWarehouse.sortByObjType();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sortByObjType(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu wzgledem glebokosci...");
			System.out.println("literatureWarehouse.sortByDepth();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sortByDepth(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu wzgledem rozszerzenia pliku...");
			System.out.println("literatureWarehouse.sortByFileExtension();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sortByFileExtension(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println("\nWyświetlam posortowany stan magazynu wzgledem lektora...");
			System.out.println("literatureWarehouse.sortByLector();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sortByLector(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println("\nWyświetlam standardowy posortowany stan magazynu...");
			System.out.println("literatureWarehouse.sort();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sort(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println("literatureWarehouse.addItem( <Jakis item ktory ma amount = 0> );");
			literatureWarehouse.addItem( new CLiteratureFactory("CBOOK;1243503400;14.11.2025;0;30;Kryminal, sensacja, thriller;Tuza;II;23-06-2024;Krolestwo;Nesbo Jo;480;20;13;9788327170316;3;HARD;15.5f").createObj() );
			
			System.out.println("\nWyświetlam standardowy posortowany stan magazynu...");
			System.out.println("literatureWarehouse.sort();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sort(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			System.out.println();
			
			System.out.println("Usuwam stany zerowe:");
			System.out.println("literatureWarehouse.removeItemsWithZeroAmount();");
			literatureWarehouse.removeItemsWithZeroAmount();
			
			System.out.println("\nWyświetlam standardowy posortowany stan magazynu...");
			System.out.println("literatureWarehouse.sort();");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.sort(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			
			System.out.println();
			System.out.println("Wyświetlam standardowy stan magazynu ale tylko pozycje z");
			System.out.println("kategorii Fantastyka, Horror");
			System.out.println("literatureWarehouse.showByCategory(\"Fantastyka, Horror\");");
			System.out.println();
			
			//literatureWarehouse.showByDepth(60);
			literatureWarehouse.showByCategory("Fantastyka, Horror");
			//literatureWarehouse.showByPriceInClosedRange(0,50);
			//literatureWarehouse.showByProducer("Świat Pięknych Książek");
			
			System.out.println();
			System.out.println("Wyświetlam standardowy stan magazynu ale tylko pozycje z");
			System.out.println("ceną od 0 zł do 30 zł:");
			System.out.println("literatureWarehouse.showByPriceInClosedRange(0,30);");
			System.out.println();
			
			literatureWarehouse.showByPriceInClosedRange(0,30);
			
			System.out.println();
			System.out.println("Wyświetlam standardowy stan magazynu ale tylko pozycje z");
			System.out.println("typem CBook:");
			System.out.println("literatureWarehouse.showByObjectType(\"CBook\");");
			System.out.println();
			
			literatureWarehouse.showByObjectType("CBook");
			
			System.out.println();
			System.out.println("Wyświetlam standardowy stan magazynu ale tylko pozycje z");
			System.out.println("typem CCargo:");
			System.out.println("literatureWarehouse.showByObjectType(\"CCargo\");");
			System.out.println();
			
			literatureWarehouse.showByObjectType("CCargo");
			
			System.out.println();
			System.out.println("Wyświetlam standardowy stan magazynu ale tylko pozycje z");
			System.out.println("typem CAudioBook:");
			System.out.println("literatureWarehouse.showByObjectType(CAudioBook.class);");
			System.out.println();
			
			literatureWarehouse.showByObjectType(CAudioBook.class);
			
			System.out.println();
			System.out.println("Wyświetlam uproszczony stan magazynu ale tylko pozycje z");
			System.out.println("typem CBook:");
			System.out.println("literatureWarehouse.filterByObjectType(\"CBook\").showWarehouseSimpleStatus();");
			System.out.println();
			
			literatureWarehouse.filterByObjectType("CBook").showWarehouseSimpleStatus();
			
			System.out.println();
			System.out.println("Wyświetlam uproszczony stan magazynu ale tylko pozycje z");
			System.out.println("typem CBook:");
			System.out.println("literatureWarehouse.filterByObjectType(\"CBook\").filterByAmount(100).showWarehouseSimpleStatus();");
			System.out.println();
			literatureWarehouse.filterByObjectType("CBook").filterByAmountThatEq(100).showWarehouseSimpleStatus();
			
			System.out.println("literatureWarehouse.subItem(\"9788328902893\", 13);");
			literatureWarehouse.subItem("9788328902893", 13);
			
			System.out.println("\nWyświetlam standardowy posortowany stan magazynu...");
			System.out.println("literatureWarehouse.sort();");
			System.out.println("literatureWarehouse.showWarehouseSimpleStatus();");
			System.out.println();
			
			literatureWarehouse.sort(); // testowanie sortowania2
			literatureWarehouse.showWarehouseDetailedStatus();
			literatureWarehouse.showWarehouseStatus();
			literatureWarehouse.showWarehouseSimpleStatus();
			
			// Warehouse Exception
			System.out.println("literatureWarehouse.subItem(\"9788328902893\", 100);");
			literatureWarehouse.subItem("9788328902893", 100);
			
			literatureWarehouse.showWarehouseDetailedStatus();
			literatureWarehouse.showWarehouseStatus();
			literatureWarehouse.showWarehouseSimpleStatus();
			
		}
		catch(IOException | LiteratureFactoryException | WarehouseException e)
		{
			e.printStackTrace();
		}
	
		
		System.out.println();
		System.out.println();
		
		String literatureDatabaseSaveTestFileName = "literature_database_save_test.csv";
		
		Path literatureDatabaseSaveTestFilePath = 
				Paths.get("").toAbsolutePath().resolve(literatureDatabaseSaveTestFileName);
			
		System.out.println("Zapisuje plik do ścieżki:" + literatureDatabaseSaveTestFilePath);

		try
		{
			System.out.println("literatureWarehouse.saveToFile(literatureDatabaseSaveTestFilePath);");
			literatureWarehouse.saveToFile(literatureDatabaseSaveTestFilePath);
			
			System.out.println();
			System.out.println
			(
				"Wczytuję plik o ścieżce " 
				+ literatureDatabaseSaveTestFilePath 
				+ " do magazynu"
			);
			
			System.out.println("literatureWarehouse.loadFromFile(literatureDatabaseSaveTestFilePath);");
			literatureWarehouse.loadFromFile(literatureDatabaseSaveTestFilePath);
			
			System.out.println();
			System.out.println("Wyświetlam stan magazynu...");
			System.out.println("literatureWarehouse.showWarehouseStatus();");
			System.out.println();
			
			literatureWarehouse.showWarehouseStatus();
			
			System.out.println();
			System.out.println("Pytanie brzmi:\n"
					           + "Czy magazyn ma być czyszczony przy każdym ładowaniu pliku?\n" 
					           + "A może powinien dodawać towary z pliku, bez usuwania poprzednich tak jak teraz?");
		}
		catch(IOException | WarehouseException e)
		{
			e.printStackTrace();
		}
		
	}
}
