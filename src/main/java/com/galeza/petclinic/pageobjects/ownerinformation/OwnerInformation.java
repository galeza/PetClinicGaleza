package com.galeza.petclinic.pageobjects.ownerinformation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pojo.Owner;

import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class OwnerInformation extends BasePage{

	
	public OwnerInformation(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.matches("^.*\\d$"))
			throw new HtmlElementsException("OWNER INFORMATION" + EnvValues.PAGE_ERROR);
	}

	
	private Owner setOwner(List<WebElement> row){
		Owner owner = new Owner();
		String name[] = row.get(0).getText().split(" ");
		owner.setFirstName(name[0]);
		owner.setLastName(name[1]);
		owner.setAddress(row.get(1).getText());
		owner.setCity(row.get(2).getText());
		owner.setTelephone(row.get(3).getText());
		return owner;
	}
	
	
}
