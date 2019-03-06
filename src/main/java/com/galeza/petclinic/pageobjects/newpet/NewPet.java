package com.galeza.petclinic.pageobjects.newpet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.PetForm;
import com.galeza.petclinic.pageobjects.base.BasePage;

import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class NewPet extends BasePage{

	private PetForm petForm;
	private WebElement monthDatePiker;
	private WebElement yearDatePiker;
	private WebElement datePickerTable;
	
	public NewPet(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.endsWith("/pets/new.html"))
			throw new HtmlElementsException("NEW PET " + EnvValues.PAGE_ERROR);
	}
	
	public void addNewPet(String petName, String day){
		System.out.println("Day = " + day);
		petForm.enterName(petName);
		petForm.enterBirthDate();
		monthDatePiker = driver.findElement(By.className("ui-datepicker-month"));
		System.out.println("Month " + this.monthDatePiker.getText());
		this.monthDatePiker.getText();
		yearDatePiker = driver.findElement(By.className("ui-datepicker-year"));
		System.out.println("Year " + this.yearDatePiker.getText());
		this.yearDatePiker.getText();
		datePickerTable = driver.findElement(By.className("ui-datepicker-calendar"));
		List<WebElement> rows = datePickerTable.findElements(By.tagName("tr"));
		List<WebElement> cells;
		for(int x = 0; x<rows.size(); x++){
			cells = rows.get(x).findElements(By.tagName("td"));
			for(int j =0; j<cells.size(); j++){
				String dayCell = cells.get(j).getText();
				System.out.println(dayCell);
				if(dayCell.equals(day)){
					cells.get(j).click();
					break;
				}
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
