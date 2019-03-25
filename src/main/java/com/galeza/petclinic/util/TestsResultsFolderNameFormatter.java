package com.galeza.petclinic.util;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.property.Property;

public class TestsResultsFolderNameFormatter {

	private TestsResultsFolderNameFormatter() {
		    throw new IllegalStateException("Utility class");
		  }
	  
    public static String setTestsResultsFolderPath(String timestamp) {
    	String folderPath = new Property().get(EnvValues.RESULTS_FOLDER_PATH);
        String testResultsFolderPath = folderPath + "result_"
                + timestamp 
                + "/";
        System.setProperty("basePath",testResultsFolderPath);
        return testResultsFolderPath;
    }
}
