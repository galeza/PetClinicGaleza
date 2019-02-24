package com.galeza.petclinic.pageobjects.findowners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.SearchOwner;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.owners.Owners;
import com.galeza.petclinic.property.Property;

import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class FindOwners extends BasePage{

	private Property property = new Property();
	private SearchOwner search;
	
	public FindOwners(WebDriver driver){
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
		if (!urlContains(property.get(EnvValues.FINDOWNERS_EXPECTED_URL)))
			throw new HtmlElementsException(EnvValues.HOME_PAGE_ERROR);
	}
	
	public Owners showAllOwners(){
		search.searchOwner();
		return new Owners(driver);

	}
}
