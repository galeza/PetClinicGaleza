package com.galeza.petclinic.pageobjects.findowners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.galeza.petclinic.pageobjects.base.BasePage;

public class FindOwners extends BasePage{

	public FindOwners(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
}
