package com.galeza.petclinic.htmlelements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@Name("PETS AND VISITS")
@FindBy(xpath = "//body/div/table[2]")
public class PetsAndVisitsTbl  extends HtmlElement{

	
	@Name("PET NAME")
	@FindBy(xpath = "//body/div/table[2]/tbody/tr/td[1]/dl/dt[. = 'Name']/following-sibling::dd[1]")
	private HtmlElement petName;	

	@Name("PET BIRTH DATE")
	@FindBy(xpath = "//body/div/table[2]/tbody/tr/td[1]/dl/dt[. = 'Name']/following-sibling::dd[2]")
	private HtmlElement petBirthDate;

	@Name("PET TYPE")
	@FindBy(xpath = "//body/div/table[2]/tbody/tr/td[1]/dl/dt[. = 'Name']/following-sibling::dd[3]")
	private HtmlElement petType;
	
	public PetsAndVisitsTbl() {
		super();
	}

	public String getPetName(){
		return petName.getText();
	}

	public String getPetBirthDate(){
		return petBirthDate.getText();
	}
	
	public String getPetType(){
		return petType.getText();
	}
	
}
