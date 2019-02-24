package com.galeza.petclinic.pageobjects.owners;

import org.openqa.selenium.WebDriver;
import com.galeza.petclinic.pageobjects.base.BasePage;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Owners extends BasePage{

	public Owners(WebDriver driver) {
		super(driver);
		HtmlElementLoader.populatePageObject(this, driver);
	}

}
