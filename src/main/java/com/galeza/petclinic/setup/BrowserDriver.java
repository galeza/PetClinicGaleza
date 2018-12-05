package com.galeza.petclinic.setup;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.property.*;

public class BrowserDriver implements SetupDriver{

	private WebDriver driver;
	//private JavascriptExecutor jsExecutor;
	private WebDriverWait wait;
	private String browser;
	private final String chromeDriverPath = new Property().get(EnvValues.CHROME_DRIVER_PATH);
	

	
	public BrowserDriver(String browserName) {
		browser = browserName;
		createDriver(browserName);
		wait = new WebDriverWait(driver, 60);
	}

	private void createDriver(String browser){
		if(browser.equalsIgnoreCase(EnvValues.CHROME)){
			createChromeDriver();
		}
	}
	
	private void createChromeDriver(){
		try{
			driver = new ChromeDriver();
		}catch(Exception ex){
			throw new SetupException("Chrome driver was not created");
		}
	}
	
	@Override
	public void close() {
		driver.close();
		
	}

	@Override
	public WebElement findElement(By locator) {
		return wait.until(visibilityOfElementLocated(locator));
	}

	@Override
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	//method to navigate to a URL
	@Override
	public void get(String url) {
		driver.get(url);
		
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public void quit() {
		driver.quit();
		
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		return ((TakesScreenshot) driver).getScreenshotAs(arg0);
	}

	@Override
	public WebElement findClickableElement(By locator) {
		return wait.until(elementToBeClickable(locator));
	}

	@Override
	public WebElement findVisibleElement(By locator) {
		return wait.until(visibilityOfElementLocated(locator));
	}

	@Override
	public WebElement findHiddenElement(By locator) {
		return wait.until(presenceOfElementLocated(locator));
	}

	@Override
	public Boolean titleIs(String title) {
		try{
			return wait.until(ExpectedConditions.titleIs(title));
		}
		catch(Exception e){
			BaseTest.LOG.fatal("titleIs exception");
			return false;
		}
	}

	@Override
	public Boolean titleContains(String title) {
		try{
			return wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e){
			BaseTest.LOG.fatal("titleContains exception");
			return false;
		}
	}

	@Override
	public Boolean urlIs(String url) {
		try{
			return wait.until(ExpectedConditions.urlToBe(url));
		}
		catch(Exception e){
			BaseTest.LOG.fatal("urlIs exception");
			return false;
		}
	}

	@Override
	public Boolean urlContains(String url) {
		try{
			return wait.until(ExpectedConditions.urlContains(url));
		}
		catch(Exception e){
			BaseTest.LOG.fatal("urlContains exception");
			return false;
		}
	}

	@Override
	public void waitUntilVisible(WebElement element) {
		try {
			wait.until(visibilityOf(element));
		}
		catch (Exception ex) {
			throw new SetupException(element.toString() + " is still not visible");		
		}
		
	}

	@Override
	public void waitUntilElementIncludesValue(WebElement element, String text) {
		try {
			wait.until(textToBePresentInElement(element, text));
		}
		catch (Exception ex) {
			throw new SetupException(text + " is not included in " + element.toString());		
		}
		
	}

}
