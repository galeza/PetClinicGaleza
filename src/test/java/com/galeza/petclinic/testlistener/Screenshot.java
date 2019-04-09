package com.galeza.petclinic.testlistener;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.environment.*;

public class Screenshot {

	private WebDriver driver;	
	

	public Screenshot(WebDriver driver)  {		
		this.driver = driver;
	}

	
	public void cleanFolder()
	{		
		try{					
			File screenShotFolder = new File(BaseTest.RESULTS_FOLDER_PATH);
			for(File file: screenShotFolder.listFiles()) 
				file.delete();
		}
		catch(Exception ex) {
			BaseTest.LOG.fatal(EnvValues.CANNOT_CLEAN_FOLDER_ERROR);
			throw new RuntimeException(EnvValues.CANNOT_CLEAN_FOLDER_ERROR, ex);
		}
	}	
	
	public void capture(String methodName) 
	{		
		File scrFile;

		 
		 try {
			 scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 File targetFile = 
			            new File(BaseTest.RESULTS_FOLDER_PATH
			                + getScreenshotName(methodName));
			 FileUtils.copyFile(scrFile, targetFile);	
			 return;
		 } 
		 catch (IOException e) {
			 e.printStackTrace();
		 }
		 
		 BaseTest.LOG.fatal(EnvValues.CANNOT_CAPTURE_SCREENSHOT_ERROR);
		 throw new RuntimeException(EnvValues.CANNOT_CAPTURE_SCREENSHOT_ERROR);
        
    }
	
	private String getScreenshotName(String methodName) {
		 StringBuilder name = new StringBuilder() 
				       							 .append(methodName)
				       							 .append("_")
				       							 .append(BaseTest.TIMESTAMP)
				       							 .append(".png");
		 return name.toString();
	 }

	
}
