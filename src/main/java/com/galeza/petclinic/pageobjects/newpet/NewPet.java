package com.galeza.petclinic.pageobjects.newpet;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.PetForm;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.ownerinformation.OwnerInformation;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class NewPet extends BasePage{

	private PetForm petForm;
	private WebElement existingPetNameErrorMessage;
	
	public NewPet(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.endsWith("/pets/new.html"))
			throw new HtmlElementsException("NEW PET " + EnvValues.PAGE_ERROR);
	}
	
	public OwnerInformation addNewPet(String petName, String day, String petType){
		addPet(petName, day, petType);
		return new OwnerInformation(driver);
	
	}

	public boolean addNewPetWithExistingName(String petName, String day, String petType){
		addPet(petName, day, petType);
		existingPetNameErrorMessage = driver.findElement(By.cssSelector("span.help-inline"));
		return existingPetNameErrorMessage.isDisplayed();
	
	}
	
   private void addPet(String petName, String day, String petType){
		petForm.enterName(petName);
		petForm.enterBirthDate();
		WebElement monthDatePiker = driver.findElement(By.className("ui-datepicker-month"));
		monthDatePiker.getText();
		WebElement yearDatePiker = driver.findElement(By.className("ui-datepicker-year"));
		yearDatePiker.getText();
		WebElement datePickerTable = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> rows = datePickerTable.findElements(By.tagName("tr"));
		clickOnCellInTable(rows, day);
		WebElement petTypeElement = driver.findElement(By.id("type"));
		Select petTypeSelect = new Select(petTypeElement);
		petTypeSelect.selectByVisibleText(petType);
		//flacky test -> must find element once more
		WebElement addPetButton = driver.findClickableElement(By.cssSelector("div[class='form-actions'] button[type='submit']"));
		addPetButton.click();
		//petForm.addPet();
	
	}
}
