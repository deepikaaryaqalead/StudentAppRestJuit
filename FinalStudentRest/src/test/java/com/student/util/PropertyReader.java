package com.student.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	private static volatile PropertyReader propInstance;
	
	private PropertyReader() {
		
		
	}
	
	public static synchronized PropertyReader getInstance() {
		
		if (propInstance ==null)
		{
			propInstance = new PropertyReader();
			
		}
		return propInstance;
	}

	public String getProperty(String propetyName)
	{
		Properties prop  = new Properties();
		try {
			
			InputStream is = getClass().getClassLoader().getResourceAsStream("application.properties"); 
					//new FileInputStream(".\\src\\test\\resources\\application.properties");
			prop.load(is);
			
			if(prop.getProperty(propetyName)!=null) {
				
				return prop.getProperty(propetyName);
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
		
		
	}
	
	
	
}
