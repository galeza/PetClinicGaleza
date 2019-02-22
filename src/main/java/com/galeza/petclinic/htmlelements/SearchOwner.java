package com.galeza.petclinic.htmlelements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("SEARCH_OWNER")
@FindBy(id = "search-owner-form")
public class SearchOwner extends HtmlElement{

	
	@Name("SEARCH OWNERS INPUT")	
	@FindBy(id = "lastName")
	private HtmlElement searchOwnerNameInput;
	
	@Name("SEARCH OWNERS BUTTON")
	@FindBy(css = "div.form-actions button")
	private HtmlElement searchOwnerButton;
	
	public void searchOwner(){
		searchOwnerButton.click();
	}
}
