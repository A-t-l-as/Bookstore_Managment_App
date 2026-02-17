package eLiteratureComparators;

import java.util.Comparator;
import cargos.CELiterature;

public class FileExtensionComparator implements Comparator<CELiterature>
{
    @Override
    public int compare(CELiterature el1, CELiterature el2) 
    {
        return el1.getFileExtension().compareTo( el2.getFileExtension() );
    }
}
