package com.galeza.petclinic.pageobjects.base;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.galeza.petclinic.setup.BrowserDriver;

public class BasePage implements BasePageInterface {

	protected BrowserDriver driver;
	public static final int TIME_OUT = 5;
	private WebDriverWait wait;



	public BasePage(WebDriver driver) {
		super();
		this.driver = (BrowserDriver)driver;
		this.wait = new WebDriverWait(driver, TIME_OUT);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public boolean urlContains(String url) {
		try {
			return (driver).urlContains(url);
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean titleContains(String title) {
		try {
			return (driver).titleContains(title);
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean urlIs(String url) {
		try {
			return (driver).urlIs(url);
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean titleIs(String title) {
		try {
			return (driver).titleIs(title);
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
	
	@Override
	public void clickOnCellInTable(List<WebElement> rows, String value){
		List<WebElement> cells;
		for(int x = 0; x<rows.size(); x++){
			cells = rows.get(x).findElements(By.tagName("td"));
			boolean breakOuterLoop = false;
			for(int j =0; j<cells.size(); j++){
				String dayCell = cells.get(j).getText();
				if(dayCell.equals(value)){
					cells.get(j).click();
					breakOuterLoop = true;
					break;
				}
				
			}
			if(breakOuterLoop){
				break;
			}
		}
	}


}
