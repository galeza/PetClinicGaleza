package com.galeza.petclinic.htmlelements;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
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

	@Name("PET Type")
	@FindBy(id = "type")
	private Select typeSelect;

	@Name("PET Type")
	@FindBy(css = "div[class='form-actions'] button[type='submit']")
	private Button addPetButton;
	
	public void enterName(String name){
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void enterBirthDate(){
		this.birthDate.clear();
		this.birthDate.click();

	}
	
	public void selectPetType(String type){
		this.typeSelect.selectByVisibleText(type);
	}
	
	public void addPet(){
		this.addPetButton.click();
	}
}
