package com.galeza.petclinic.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Properties;
import com.galeza.petclinic.setup.SetupException;

public class Property {

	private Properties properties;
	
	
	public Property() {		
		validateFileExists();
		loadPropertyContent();		
	}

	private void validateFileExists() {
		File propertyFile = null;
		try {
			propertyFile = new File(this.getClass().getResource( "/project.properties" ).toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TODO
		if (!propertyFile.exists())
			throw new SetupException("property file does not exist");		
	}

	private void loadPropertyContent() {
		
		properties = new Properties();
		File file = null;
		try {
			file = new File(this.getClass().getResource( "/project.properties" ).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
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
