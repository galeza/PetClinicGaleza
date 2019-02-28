package com.galeza.petclinic.htmlelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.galeza.petclinic.pojo.Owner;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("OWNER TABLE")
@FindBy(css = "table[class='table table-striped']")
public class OwnerTbl extends HtmlElement{

	@Name("EDIT OWNER BUTTON")
	@FindBy(css = "a.btn.btn-info")
	private HtmlElement editOwnerNavLink;
	
	public Owner readSpecificOwnerData(){
		Owner owner = new Owner();
		List<WebElement> ownerRows = this.findElements(By.tagName("tr"));
		 for(int i=0; i<ownerRows.size(); i++) {
			 List<WebElement> row = ownerRows.get(i).findElements(By.tagName("td"));
			 	if(i == 0){
			 		System.out.println("here I am " + row.get(0).getText());
					String name[] = row.get(0).getText().split(" ");
					owner.setFirstName(name[0]);
					owner.setLastName(name[1]);
			 	}
		        if(i ==1){
		        	owner.setAddress(row.get(0).getText());
		        }
		        if(i == 2){
		        	owner.setCity(row.get(0).getText());
		        }
		        if(i ==3){
		        	owner.setTelephone(row.get(0).getText());
		        }

		 }
		 return owner;
	}

	public void clickOnEditOwner(){
		editOwnerNavLink.click();
	}
	
}
