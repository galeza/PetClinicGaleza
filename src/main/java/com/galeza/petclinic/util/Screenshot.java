package com.galeza.petclinic.util;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.property.*;
import com.galeza.petclinic.environment.*;

public class Screenshot {

	private WebDriver driver;	
	private final String folderPath;
	private String timestamp = DateAndTimeFormatter.getLocalDate();


	public Screenshot(WebDriver driver) throws Exception {		
		this.driver = driver;
		folderPath = new Property().get(EnvValues.SCREENSHOTS_FOLDER_PATH);
		//BaseTest.LOG.info("folderPath = " + folderPath);
		//validateFolderExists();				
	}

	private void validateFolderExists() {
		File screenShotFolder = null;
		screenShotFolder = new File(folderPath);
		if (!screenShotFolder.exists()) {
			//BaseTest.LOG.fatal(EnvValues.FOLDER_NOT_EXIST_ERROR);
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
			//BaseTest.LOG.fatal(EnvValues.CANNOT_CLEAN_FOLDER_ERROR);
			throw new RuntimeException(EnvValues.CANNOT_CLEAN_FOLDER_ERROR, ex);
		}
	}	
	
	public void capture(String methodName) 
	{		
		File scrFile;

		 
		 try {
			 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 File targetFile = 
			            new File(folderPath + "screenshot_"
			                + timestamp 
			                + "/"
			                + getScreenshotName(methodName));
			 FileUtils.copyFile(scrFile, targetFile);	
			 return;
		 } 
		 catch (IOException e) {
			 e.printStackTrace();
		 }
		 
		 //BaseTest.LOG.fatal(EnvValues.CANNOT_CAPTURE_SCREENSHOT_ERROR);
		 throw new RuntimeException(EnvValues.CANNOT_CAPTURE_SCREENSHOT_ERROR);
        
    }
	
	private String getScreenshotName(String methodName) {
		 StringBuilder name = new StringBuilder() 
				       							 .append(methodName)
				       							 .append("_")
				       							 .append(timestamp)
				       							 .append(".png");
		 return name.toString();
	 }

	
}
