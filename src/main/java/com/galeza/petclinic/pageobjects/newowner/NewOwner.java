package com.galeza.petclinic.pageobjects.newowner;

import org.openqa.selenium.WebDriver;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.OwnerForm;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.ownerinformation.OwnerInformation;
import com.galeza.petclinic.pojo.Owner;

import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class NewOwner extends BasePage{

	private OwnerForm ownerForm;
	
	public NewOwner(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.endsWith("edit.html"))
			throw new HtmlElementsException("NEW OWNER " + EnvValues.PAGE_ERROR);
	}

	public void updateOwnerInformation (Owner owner){
		ownerForm.enterFirstName(owner.getFirstName());
		ownerForm.enterLastName(owner.getLastName());
		ownerForm.enterAddress(owner.getAddress());
		ownerForm.enterCity(owner.getCity());
		ownerForm.enterTelephone(owner.getTelephone());
	}
	
	public OwnerInformation updateOwner(){
		ownerForm.updateOwner();
		return new OwnerInformation(driver);
	}
}
