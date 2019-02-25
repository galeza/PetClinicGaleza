package com.galeza.petclinic.pageobjects.owners;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pojo.Owner;
import com.galeza.petclinic.property.Property;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class Owners extends BasePage{

	//private Property property = new Property();
	String subUrl = "owners.html";
	@Name("OWNERS TABLE")
	@FindBy(css = "table[class='table table-striped']")
	private HtmlElement ownersTbl;
	
	public Owners(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.contains(subUrl))
			throw new HtmlElementsException("OWNERS" + EnvValues.PAGE_ERROR);
	}

	public Owner readOwnerData(){
		Owner owner = null;
		List<WebElement> ownerRows = ownersTbl.findElements(By.tagName("tr"));
		 for(int i=0; i<ownerRows.size(); i++) {
		        List<WebElement> row = ownerRows.get(i).findElements(By.tagName("td"));
		        if(i == 1){
		        	owner = setOwner(row);
		        }
		 }
		return owner;
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
