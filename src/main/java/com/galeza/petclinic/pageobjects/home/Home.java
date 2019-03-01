package com.galeza.petclinic.pageobjects.home;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import com.galeza.petclinic.property.*;
import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.Navigation;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.findowners.FindOwners;

public class Home extends BasePage{
	
	private Property property = new Property();
	private Navigation nav;
	
	public Home(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

	public Home open() {
		String siteUrl = property.get(EnvValues.WEB_URL);
		String siteTitle = property.get(EnvValues.WEB_TITLE);
		getDriver().get(siteUrl);
		if (!urlContains(property.get(EnvValues.EXPECTED_URL)) || !titleContains(siteTitle))
			throw new HtmlElementsException("HOME" + EnvValues.PAGE_ERROR);
		return this;
	}	

	public FindOwners goToFindOwners(){
		nav.clickFindOwnersLink();
		return new FindOwners(driver);
	}

	
}
