package myUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class NSClassUtils
{
	
	// Pobieranie wszystkich pol z klasy (doslownie wraz z superklasami)
    public static List<Field> getAllFields(Class<?> someClass)
    {
        List<Field> allFields = new ArrayList<>();
        Class<?> currClass = someClass;
        
        while (currClass != null && currClass != Object.class)
        {
            Field[] currentClassFields = currClass.getDeclaredFields();
            for (Field field : currentClassFields)
            {
            	allFields.add(field);
            }
            currClass = currClass.getSuperclass(); 
        }
        
        return allFields;
    }
    
	// Pobieranie wszystkich nazw pol z klasy (doslownie wraz z superklasami)
    public static List<String> getAllFieldNames(Class<?> someClass)
    {
        List<String> allFieldNames = new ArrayList<>();
        Class<?> currClass = someClass;
        
        while (currClass != null && currClass != Object.class)
        {
            Field[] currentClassFields = currClass.getDeclaredFields();
            for (Field field : currentClassFields)
            {
            	allFieldNames.add(field.getName());
            }
            currClass = currClass.getSuperclass(); 
        }
        
        return allFieldNames;
    }
}
