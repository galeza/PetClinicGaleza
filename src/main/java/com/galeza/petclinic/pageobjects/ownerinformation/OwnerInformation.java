package com.galeza.petclinic.pageobjects.ownerinformation;

import org.openqa.selenium.WebDriver;
import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.OwnerTbl;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.newowner.NewOwner;
import com.galeza.petclinic.pojo.Owner;

import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class OwnerInformation extends BasePage{

	private OwnerTbl ownertbl;

	
	public OwnerInformation(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.matches("^.*\\d$"))
			throw new HtmlElementsException("OWNER INFORMATION" + EnvValues.PAGE_ERROR);
	}

	public Owner readInformationAboutOwner(String ownerName){
		return ownertbl.readSpecificOwnerData(ownerName);
	}

	public NewOwner openOwnerEditPage(){
		ownertbl.clickOnEditOwner();
		return new NewOwner(driver);
	}
	
}
