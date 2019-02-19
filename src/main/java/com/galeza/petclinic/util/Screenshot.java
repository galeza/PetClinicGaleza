package com.galeza.petclinic.util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.property.*;
import com.galeza.petclinic.environment.*;

public class Screenshot {

	private WebDriver driver;	
	private final String folderPath;
	

	
	public Screenshot(WebDriver driver) throws Exception {		
		this.driver = driver;
		folderPath = new Property().get(EnvValues.SCREENSHOTS_FOLDER_PATH);
		validateFolderExists();				
	}

	private void validateFolderExists() {
		File screenShotFolder = new File(folderPath);
		if (!screenShotFolder.exists()) {
//			BaseTest.LOG.fatal(EnvValues.FOLDER_NOT_EXIST_ERROR);
			throw new RuntimeException(EnvValues.FOLDER_NOT_EXIST_ERROR);
		}
	}
	
	public void cleanFolder()
	{		
		try{					
			File screenShotFolder = new File(folderPath);
			for(File file: screenShotFolder.listFiles()) 
				file.delete();
		}
		catch(Exception ex) {
//			BaseTest.LOG.fatal(EnvValues.CANNOT_CLEAN_FOLDER_ERROR);
			throw new RuntimeException(EnvValues.CANNOT_CLEAN_FOLDER_ERROR, ex);
		}
	}	
	
	public void capture(String methodName) 
	{		
		File scrFile;
		 
		 try {
			 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(scrFile, new File(getScreenshotName(methodName)));	
			 return;
		 } 
		 catch (IOException e) {
			 e.printStackTrace();
		 }
		 
//		 BaseTest.LOG.fatal(EnvValues.CANNOT_CAPTURE_SCREENSHOT_ERROR);
		 throw new RuntimeException(EnvValues.CANNOT_CAPTURE_SCREENSHOT_ERROR);
        
    }
	
	private String getScreenshotName(String methodName) {
		 String localDateTime = LocalDateTime.now().toString().replaceAll("[^0-9a-zA-Z]", "");
		 StringBuilder name = new StringBuilder().append(folderPath) 
				       							 .append(methodName)
				       							 .append("_")
				       							 .append(localDateTime)
				       							 .append(".png");
		 return name.toString();
	 }

	
}
