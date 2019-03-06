package com.galeza.petclinic.htmlelements;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("ADD PET FORM")
@FindBy(css = "form.form-horizontal")
public class PetForm extends HtmlElement {

	@Name("PET NAME")
	@FindBy(id = "name")
	private TextInput name;
	
	@Name("PET BIRTHDATE")
	@FindBy(id = "birthDate")
	private TextInput birthDate;


	
	public void enterName(String name){
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void enterBirthDate(){
		this.birthDate.clear();
		this.birthDate.click();

	}
}
