package com.galeza.petclinic.pageobjects.findowners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.galeza.petclinic.pageobjects.base.BasePage;

public class FindOwners extends BasePage{

	@FindBy(id = "lastName")
	private WebElement findOwnerNameInput;

	@FindBy(css = "div.form-actions button")
	private WebElement findOwnerButton;
	
	public FindOwners(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void searchOwners(){
		findOwnerButton.click();

	}
}
