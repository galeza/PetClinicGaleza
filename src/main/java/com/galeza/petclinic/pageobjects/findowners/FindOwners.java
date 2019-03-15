package com.galeza.petclinic.pageobjects.findowners;

import org.openqa.selenium.WebDriver;
import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.SearchOwner;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.ownerinformation.OwnerInformation;
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
			throw new HtmlElementsException("FIND OWNERS" + EnvValues.PAGE_ERROR);
	}
	
	public Owners showAllOwners(){
		search.searchOwners();
		return new Owners(driver);

	}
	
	public OwnerInformation showSpecificOwner(String lastName){
		search.searchSpecficOwner(lastName, driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OwnerInformation(driver);

	}
}
