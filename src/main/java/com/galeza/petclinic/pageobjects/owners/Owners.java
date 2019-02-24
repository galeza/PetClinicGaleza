package com.galeza.petclinic.pageobjects.owners;

import org.openqa.selenium.WebDriver;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.property.Property;

import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Owners extends BasePage{

	//private Property property = new Property();
	String subUrl = "owners.html";
	
	public Owners(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.contains(subUrl))
			throw new HtmlElementsException("OWNERS" + EnvValues.PAGE_ERROR);
	}

}
