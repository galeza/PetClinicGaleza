package com.galeza.petclinic.testlistener;
import java.lang.reflect.Field;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.setup.BrowserDriver;
import com.galeza.petclinic.setup.SetupException;
import com.galeza.petclinic.util.Screenshot;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		 try {
			 Screenshot screenshot = new Screenshot(getDriverFromBaseTest(arg0));
			 screenshot.capture(arg0.getName());
		 } catch (Exception ex) {
			 throw new RuntimeException(ex.getMessage());
		 } 
		
	}

	 @SuppressWarnings("unchecked")
	 private WebDriver getDriverFromBaseTest(ITestResult result) throws IllegalAccessException {
		 WebDriver driver = null;
		 
		 try {	
			 Class<?extends ITestResult> testClass = (Class<? extends ITestResult>) 
					 					             result.getInstance().getClass();
		
			 Class<?extends ITestResult> baseTestClass = (Class<? extends ITestResult>) 
												    testClass.getSuperclass();
		
			 Field driverField = baseTestClass.getDeclaredField(EnvValues.DRIVER);
			 driver = (BrowserDriver)driverField.get(result.getInstance());	
			 return driver;
		 } 
		 catch (SecurityException | NoSuchFieldException | IllegalArgumentException	ex) {	
			 throw new RuntimeException("error getting the driver from base test");
		 }		 		 		 
			
	 }
	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
