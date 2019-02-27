package com.galeza.petclinic.pageobjects.newowner;

import org.openqa.selenium.WebDriver;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.pageobjects.base.BasePage;

import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class NewOwner extends BasePage{

	public NewOwner(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.endsWith("edit.html"))
			throw new HtmlElementsException("NEW OWNER " + EnvValues.PAGE_ERROR);
	}

}
