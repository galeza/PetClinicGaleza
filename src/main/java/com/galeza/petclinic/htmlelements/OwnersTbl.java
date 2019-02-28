package com.galeza.petclinic.htmlelements;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("OWNERS TABLE")
@FindBy(css = "table[class='table table-striped']")
public class OwnersTbl extends HtmlElement{

	
	public void clickOnSpecificOwner(String ownerName){
		List<WebElement> ownerRows = this.findElements(By.tagName("tr"));
		 for(int i=0; i<ownerRows.size(); i++) {
			 List<WebElement> row = ownerRows.get(i).findElements(By.tagName("td"));
		        if(!row.isEmpty() && row.get(0).getText().endsWith(ownerName)){
		        	row.get(0).click();
		        	break;
		        	//TODO exception name not found
		        }

		 }
	}
	
}
