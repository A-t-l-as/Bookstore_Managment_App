package main;

import apps.CBookstorePresentationApp;
import apps.IApp;

//import demos.CAllCargosAndWarehousesDemo;

/*
 * To Do:
 */


public class MainEntry
{
	public static void main(String[] args)
    {
		// Demo mode:
		// new CAllCargosAndWarehousesDemo();
		
		IApp bookstorePresentationApp = new CBookstorePresentationApp();
		bookstorePresentationApp.run(args);
    }	
}
