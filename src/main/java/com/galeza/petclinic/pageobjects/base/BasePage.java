package com.galeza.petclinic.pageobjects.base;

import static java.util.concurrent.TimeUnit.MICROSECONDS;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.galeza.petclinic.pageobjects.findowners.FindOwners;
import com.galeza.petclinic.setup.BrowserDriver;

public class BasePage implements BasePageInterface {

	protected WebDriver driver;
	//public static final long POLLING_INTERVAL = 250;
	public static final int TIME_OUT = 5;
	private WebDriverWait wait;

	// @FindBy(xpath = "//a[@href='/owners/find]")
	@FindBy(css = "div[class='navbar'] a[href*='/owners/find.html']")
	private WebElement findOwnersNavLink;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		wait = new WebDriverWait(driver, TIME_OUT);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public FindOwners goToFindOwners(){
		System.out.println("goToFindOwners method");
		findOwnersNavLink.click();
		return new FindOwners(driver);
	}
	
	@Override
	public boolean urlContains(String url) {
		try {
			return ((BrowserDriver) driver).urlContains(url);
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean titleContains(String title) {
		try {
			return ((BrowserDriver) driver).titleContains(title);
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean urlIs(String url) {
		try {
			return ((BrowserDriver) driver).urlIs(url);
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean titleIs(String title) {
		try {
			return ((BrowserDriver) driver).titleIs(title);
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public void reload() {
		driver.navigate().refresh();

	}
////TODO jak zrobic streama
//	public boolean waitForPageToLoad() {
//		ExpectedCondition<Boolean> documentIsReady = new ExpectedCondition<Boolean>() {
//			public Boolean apply(WebDriver driver) {
//				JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//				return javascriptExecutor.executeScript("return document.readyState").toString().equals("complete");
//			}
//		};
//
//		return wait.until(documentIsReady);
//	}

//    public void waitForElementsToLoad(WebElement... element) {
//        List<WebElement> listOfWebElement = new ArrayList<WebElement>();
//
//        for (WebElement elementToAdd : element) {
//            listOfWebElement.add(elementToAdd);
//        }
//
//        wait.pollingEvery(Duration.ofMillis(600))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class);
//        wait.until(ExpectedConditions.visibilityOfAllElements(listOfWebElement));
//    }

}
