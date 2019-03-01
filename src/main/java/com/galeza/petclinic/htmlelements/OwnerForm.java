package com.galeza.petclinic.htmlelements;

import org.openqa.selenium.support.FindBy;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("ADD OWNER")
@FindBy(id = "add-owner-form")
public class OwnerForm extends HtmlElement{

	@Name("FIRST NAME")
	@FindBy(id = "firstName")
	private TextInput firstName;
	
	@Name("LAST NAME")
	@FindBy(id = "lastName")
	private TextInput lastName;
	
	@Name("ADDRESS")
	@FindBy(id = "address")
	private TextInput address;
	
	@Name("CITY")
	@FindBy(id = "city")
	private TextInput city;
	
	@Name("TELEPHONE")
	@FindBy(id = "telephone")
	private TextInput telephone;
	
	@Name("UPDATE BUTTON")
	@FindBy(css = "div[class='form-actions'] button[type='submit']")
	private Button updateOwner;
	
	public void enterFirstName(String firstName){
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName){
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}
	
	public void enterAddress(String address){
		this.address.clear();
		this.address.sendKeys(address);
	}

	public void enterCity(String city){
		this.city.clear();
		this.city.sendKeys(city);
	}
	
	public void enterTelephone(String telephone){
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
	}
	
	public void updateOwner(){
		updateOwner.click();
	}
}
