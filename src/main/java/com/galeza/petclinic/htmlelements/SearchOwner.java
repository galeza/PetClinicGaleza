package com.galeza.petclinic.htmlelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("SEARCH_OWNER")
@FindBy(id = "search-owner-form")
public class SearchOwner extends HtmlElement{

	
	@Name("SEARCH OWNERS INPUT")	
	@FindBy(css = "div[class='control-group'] input[type='text']")
	private HtmlElement searchOwnerNameInput;
	
	@Name("SEARCH OWNERS BUTTON")
	@FindBy(css = "div.form-actions button")
	private HtmlElement searchOwnerButton;
	
	public void searchOwners(){
		searchOwnerButton.click();
	}
	
	public void searchSpecficOwner(String lastName, WebDriver driver){
//		System.out.println(" last name = " + lastName);
//		Actions actions = new Actions(driver);
//		actions.moveToElement(searchOwnerNameInput).click();
//		//actions.click();
//		actions.sendKeys(lastName).perform();;
//		//actions.build().perform();
		searchOwnerNameInput.click();
		searchOwnerNameInput.clear();
		searchOwnerNameInput.sendKeys(lastName);
		searchOwnerButton.click();
	}
}
