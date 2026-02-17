package guiPopups;

import java.io.File;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class CChooseFilePopup
{
	public CChooseFilePopup(Component pParent)
	{
		this(pParent, "CSV files", "csv");
	}
	
	public CChooseFilePopup(Component pParent, String formatDescription, String format )
	{
		JFileChooser chooser = new JFileChooser();

		// Filtr: tylko pliki o podanym formacie
		FileNameExtensionFilter filter = new FileNameExtensionFilter(formatDescription, format);
		chooser.setFileFilter(filter);

		chooser.setAcceptAllFileFilterUsed(false); // ukrywa opcje "Wszystkie pliki (*.*)"
		
		int result = chooser.showOpenDialog(pParent); // otwarcie okna wyboru

		if (result == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = chooser.getSelectedFile();
			
			this.result = selectedFile.toPath();
			return;
		} 
		

		new CInfoPopup(pParent, "The selection has been canceled.");
		this.result = Path.of("");
	}
	
	public Path getResult()
	{
		return this.result;
	}
	
//private:
	private Path result;
   
}
