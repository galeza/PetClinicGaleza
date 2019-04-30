package com.galeza.petclinic.pageobjects.ownerinformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.galeza.petclinic.environment.EnvValues;
import com.galeza.petclinic.htmlelements.OwnerTbl;
import com.galeza.petclinic.pageobjects.base.BasePage;
import com.galeza.petclinic.pageobjects.newowner.NewOwner;
import com.galeza.petclinic.pageobjects.newpet.NewPet;
import com.galeza.petclinic.pojo.Owner;
import com.galeza.petclinic.setup.BrowserDriver;

import ru.yandex.qatools.htmlelements.element.Table;
import ru.yandex.qatools.htmlelements.exceptions.HtmlElementsException;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class OwnerInformation extends BasePage{

	private OwnerTbl ownertbl;

	
	public OwnerInformation(WebDriver driver) {
		super(driver);
		String curentUrl = getUrl();
		HtmlElementLoader.populatePageObject(this, driver);
		if (!curentUrl.matches("^.*\\d#?$"))
			throw new HtmlElementsException("OWNER INFORMATION" + EnvValues.PAGE_ERROR);
	}

	public Owner readInformationAboutOwner(){
		return ownertbl.readSpecificOwnerData();
	}
	
	public Collection<List<String>> readPetDetails(){
		List<String> petsDetails = new ArrayList<>();
		List<WebElement> tables = driver.findElements(By.className("table"));
		for (int x =1; x<tables.size(); ++x){
			Table table = new Table(tables.get(x));
			List<WebElement> columns = table.getColumnByIndex(1);
			List<WebElement> ddElements = columns.get(0).findElements(By.xpath(".//dd"));
			for(int i =0; i<ddElements.size();i++){
				petsDetails.add(ddElements.get(i).getText());
			}
			
		}
		AtomicInteger counter = new AtomicInteger(0);
		return petsDetails.stream().collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 3))
                .values();
	}

	public NewOwner openNewOwnerPage(){
		ownertbl.clickOnEditOwner();
		return new NewOwner(driver);
	}

	public NewPet openNewPetPage(){
		ownertbl.clickAddNewPet();
		return new NewPet((BrowserDriver)driver);
	}
	
}
