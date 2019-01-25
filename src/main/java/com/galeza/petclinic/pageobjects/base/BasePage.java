package com.galeza.petclinic.pageobjects.base;

import org.openqa.selenium.WebDriver;

import com.galeza.petclinic.setup.BrowserDriver;

public class BasePage implements BasePageInterface {

	private WebDriver driver;
	
	
	
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public boolean urlContains(String url) {
		try {
			return ((BrowserDriver) driver).urlContains(url);
		}
		catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean titleContains(String title) {
		try {
			return ((BrowserDriver) driver).titleContains(title);
		}
		catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean urlIs(String url) {
		try {
			return ((BrowserDriver) driver).urlIs(url);
		}
		catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean titleIs(String title) {
		try {
			return ((BrowserDriver) driver).titleIs(title);
		}
		catch (Exception ex) {
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

}
