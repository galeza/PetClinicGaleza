package com.galeza.petclinic.pageobjects.newpet;

import org.openqa.selenium.WebDriver;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.pageobjects.base.BasePage;

import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class NewPet extends BasePage{

	public NewPet(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.endsWith("/pets/new.html"))
			throw new HtmlElementsException("NEW PET " + EnvValues.PAGE_ERROR);
	}

}
