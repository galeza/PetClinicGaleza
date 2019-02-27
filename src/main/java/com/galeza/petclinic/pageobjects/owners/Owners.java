package com.galeza.petclinic.pageobjects.owners;

import org.openqa.selenium.WebDriver;
import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.OwnersTbl;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.ownerinformation.OwnerInformation;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Owners extends BasePage{

	String subUrl = "owners.html";
	private OwnersTbl ownersTbl;
	
	public Owners(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.contains(subUrl))
			throw new HtmlElementsException("OWNERS" + EnvValues.PAGE_ERROR);
	}
	
	

	public OwnerInformation goToOwner(String ownerName){
		ownersTbl.clickOnSpecificOwner(ownerName);
		return new OwnerInformation(driver);
	}
	
	
}
