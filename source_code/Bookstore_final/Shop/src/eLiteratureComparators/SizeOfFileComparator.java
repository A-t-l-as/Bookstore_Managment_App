package eLiteratureComparators;

import java.util.Comparator;
import cargos.CELiterature;

public class SizeOfFileComparator implements Comparator<CELiterature>
{
    @Override
    public int compare(CELiterature el1, CELiterature el2) 
    {
        return Float.compare(el1.getSizeOfFile(), el2.getSizeOfFile());
    }
}
