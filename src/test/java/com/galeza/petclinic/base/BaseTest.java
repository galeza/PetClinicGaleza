package com.galeza.petclinic.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.galeza.petclinic.setup.BrowserDriver;
import com.galeza.petclinic.util.DateAndTimeFormatter;
import com.galeza.petclinic.util.TestsResultsFolderNameFormatter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

import java.io.File;

import org.apache.logging.log4j.LogManager;


public class BaseTest {

	public WebDriver driver;
	public static String TIMESTAMP = DateAndTimeFormatter.getLocalDate();
	public static String RESULTS_FOLDER_PATH = TestsResultsFolderNameFormatter.setTestsResultsFolderPath(TIMESTAMP); 
	public static Logger LOG = LogManager.getLogger(BaseTest.class);

	
	@BeforeMethod
	public void setUp() {	
		System.setProperty("resultsPath", RESULTS_FOLDER_PATH);
		LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        ctx.reconfigure();
		File dir = new File(RESULTS_FOLDER_PATH);
		dir.mkdirs();
		driver = new BrowserDriver("chrome"); 	
		driver.manage().window().maximize(); 
	}   
	      
	@AfterMethod
	public void tearDown() { 
		driver.quit(); 
	} 
	
}
