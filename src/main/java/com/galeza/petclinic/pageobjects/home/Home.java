package com.galeza.petclinic.pageobjects.home;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import com.galeza.petclinic.property.*;
import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.pageobjects.base.BasePage;

public class Home extends BasePage{

	public Home(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public Home open() {
		String siteUrl = new Property().get(EnvValues.WEB_URL);
		getDriver().get(siteUrl);		 
		
		if (!urlContains(EnvValues.EXPECTED_URL) ) 
			throw new HtmlElementsException(EnvValues.HOME_PAGE_ERROR);
				
		return this;
	}	
}
