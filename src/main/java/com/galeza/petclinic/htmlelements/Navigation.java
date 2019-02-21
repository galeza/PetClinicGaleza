package com.galeza.petclinic.htmlelements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("NAVIGATION")
@FindBy(css = "div[class='navbar']")
public class Navigation extends HtmlElement{

	@Name("FIND OWNERS LINK")
	@FindBy(css = "div[class='navbar'] a[href*='/owners/find.html']")
	private HtmlElement findOwnersNavLink;

	@Name("VETERINARIANS LINK")
	@FindBy(css = "div[class='navbar'] a[href*='/vets.html']")
	private HtmlElement veterinariansNavLink;
	
	public void clickFindOwnersLink() {
		findOwnersNavLink.click();
	}

	public void clickVeterinariansLink() {
		veterinariansNavLink.click();
	}
	
}
