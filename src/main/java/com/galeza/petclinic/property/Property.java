package com.galeza.petclinic.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.setup.SetupException;

public class Property {

	private Properties properties;
	
	
	public Property() {		
		validateFileExists();
		loadPropertyContent();		
	}

	private void validateFileExists() {
		File propertyFile = new File(EnvValues.PROPERTY_FILE);
		if (!propertyFile.exists())
			throw new SetupException("property file does not exist");		
	}

	private void loadPropertyContent() {
		
		properties = new Properties();
		File file = new File(EnvValues.PROPERTY_FILE);
		InputStream input;
		
		try {
			input = new FileInputStream(file);
			properties.load(input);
			return;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		throw new SetupException("could not load the property file content");	
	}
	
	public String get(String name)
	{		
		try {
			return properties.getProperty(name);
		}
		catch(Exception exception) {
			throw new SetupException("cannot find the " + name);	
		}		 
	}
	
}
