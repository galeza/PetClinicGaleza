package com.galeza.petclinic.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.galeza.petclinic.setup.BrowserDriver;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class BaseTest {

	public WebDriver driver;
	
	public static Logger LOG = LogManager.getLogger(BaseTest.class);

	
	@BeforeMethod
	public void setUp() {			
		driver = new BrowserDriver("chrome"); 	
		driver.manage().window().maximize(); 
	}   
	      
	@AfterMethod
	public void tearDown() { 
		driver.quit(); 
	} 
	
}
