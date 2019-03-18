package com.galeza.petclinic.tests;

import org.assertj.core.api.SoftAssertions;
import org.omg.CORBA.PERSIST_STORE;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.galeza.petclinic.testlistener.TestListener;
import com.galeza.petclinic.util.enumeration.PetType;
import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.helpers.RandomValues;
import com.galeza.petclinic.pageobjects.findowners.FindOwners;
import com.galeza.petclinic.pageobjects.home.Home;
import com.galeza.petclinic.pageobjects.newowner.NewOwner;
import com.galeza.petclinic.pageobjects.newpet.NewPet;
import com.galeza.petclinic.pageobjects.ownerinformation.OwnerInformation;
import com.galeza.petclinic.pageobjects.owners.Owners;
import com.galeza.petclinic.pojo.Owner;
import com.galeza.petclinic.pojo.Pet;
import com.galeza.petclinic.setup.BrowserDriver;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;

//@Listeners(TestListener.class)
public class PetClinicTest extends BaseTest {
//
//	@DataProvider(name = "ownerInformation")
//
//	public static Object[][] ownerInformation() {
//
//		return new Object[][] {
//				{ "Jean", "Coleman", "ModifiedJean", "ModifiedColeman", "Kijowska", "Krakow", "123456789" }, };
//
//	}
//
//	@Test(dataProvider = "ownerInformation")
//	public void modifyOwnerTest(String firstName, String lastName, String modifiedFirstName, String modifiedLastName,
//			String address, String city, String telephone) {
//		Home homePage = new Home(driver);
//		OwnerInformation ownerInfoPage = homePage.open().goToFindOwners().showAllOwners()
//				.goToOwner(firstName + " " + lastName);
//		Owner existingOwner = ownerInfoPage.readInformationAboutOwner();
//		assertThat(existingOwner.getFirstName()).isEqualToIgnoringCase(firstName);
//		assertThat(existingOwner.getLastName()).isEqualToIgnoringCase(lastName);
//		NewOwner newOwnerPage = ownerInfoPage.openNewOwnerPage();
//		Owner modifiedOwner = setOwnerInformation(modifiedFirstName, modifiedLastName, address, city, telephone);
//		newOwnerPage.updateOwnerInformation(modifiedOwner);
//		ownerInfoPage = newOwnerPage.updateOwner();
//		Owner readModifiedOwner = ownerInfoPage.readInformationAboutOwner();
//		assertThat(readModifiedOwner).isEqualToComparingFieldByField(modifiedOwner);
//	}
//
//	@DataProvider(name = "findSpecificOwner")
//
//	public static Object[][] findSpecificOwner() {
//
//		return new Object[][] {
//				{ "Peter", "McTavish", "2387 S. Fair Way", "Madison", "6085552765" }, };
//
//	}
//
//	@Test(dataProvider = "findSpecificOwner")
//	public void showSpecificOwnerTest(String firstName, String lastName,
//			String address, String city, String telephone) {
//		Home homePage = new Home(driver);
//		OwnerInformation ownerInfoPage = homePage.open().goToFindOwners().showSpecificOwner(lastName);
//		Owner foundOwner = ownerInfoPage.readInformationAboutOwner();
//		assertThat(foundOwner.getFirstName()).isEqualToIgnoringCase(firstName);
//		assertThat(foundOwner.getLastName()).isEqualToIgnoringCase(lastName);
//		assertThat(foundOwner.getAddress()).isEqualToIgnoringCase(address);
//		assertThat(foundOwner.getCity()).isEqualToIgnoringCase(city);
//		assertThat(foundOwner.getTelephone()).isEqualToIgnoringCase(telephone);
//	}
//
//	@DataProvider(name = "ownerAddPet")
//
//	public static Object[][] ownerAddPet() {
//
//		return new Object[][] {
//				{ "Peter", "McTavish", 
//					RandomValues.getRandomAlphaNumericWithSize(5), getLocatDate(), 
//					PetType.getRandomPetType().toString().toLowerCase()}, };
//
//	}
//
//	@Test(dataProvider = "ownerAddPet")
//	public void AddPetTest(String firstName, String lastName, String petName, String petBirthDate, String petType) {
//		Home homePage = new Home((BrowserDriver) driver);
//		OwnerInformation ownerInfoPage = homePage.open().goToFindOwners().showSpecificOwner(lastName);
//		Owner foundOwner = ownerInfoPage.readInformationAboutOwner();
//		assertThat(foundOwner.getFirstName()).isEqualToIgnoringCase(firstName);
//		assertThat(foundOwner.getLastName()).isEqualToIgnoringCase(lastName);
//		String dateParts[] = petBirthDate.split("-");
//		Collection<List<String>> petsDetails = ownerInfoPage.openNewPetPage()
//				.addNewPet(petName, dateParts[2], petType).readPetDetails();
//		List<String> petDetail = petsDetails.stream().filter(el -> el.contains(petName)).findFirst().get();
//		SoftAssertions softly = new SoftAssertions();
//		softly.assertThat(petDetail.get(0)).as("Pet name").isEqualTo(petName);
//		softly.assertThat(petDetail.get(1)).as("Pet birthdate").isEqualTo(petBirthDate);
//		softly.assertThat(petDetail.get(2)).as("Pet type").isEqualTo(petType);
//		softly.assertAll();
//	}
	

	@DataProvider(name = "petNameValidation")

	public static Object[][] petNameValidation() {

		return new Object[][] {
				{ "Jeff", "Black","Lucky", getLocatDate(), 
					PetType.getRandomPetType().toString().toLowerCase()}, };

	}

	@Test(dataProvider = "petNameValidation")
	public void validatePetName(String firstName, String lastName, String petName, String petBirthDate,
			String petType) {
		String dateParts[] = petBirthDate.split("-");
		Home homePage = new Home((BrowserDriver) driver);
		NewPet newPetPage = homePage.open().goToFindOwners().showSpecificOwner(lastName).openNewPetPage();
		assertThat(newPetPage.addNewPetWithExistingName(petName, dateParts[2], petType))
				.as("validation existing pet %s name", petName).isTrue();

	}
	
	@DataProvider(name = "unexistingOwnerValidation")
	public static Object[][] unexistingOwnerValidation() {

		return new Object[][] {
				{"Unexisting"}, };

	}

	@Test(dataProvider = "unexistingOwnerValidation")
	public void validateUnexistingOwner(String lastName) {
		Home homePage = new Home((BrowserDriver) driver);
		LOG.info("LOG unexisting Owner Validation");
		FindOwners findOwnersPage = homePage.open().goToFindOwners();
		assertThat(findOwnersPage.showNonExistingOwner(lastName))
				.as("validation non existing owner %s name", lastName).isTrue();

	}
	
	

	public static String getLocatDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-d");
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate);
	}

//	private Pet setPetInformation(String name, String birthdate, String type){
//		Pet pet = new Pet();
//		pet.setName(name);
//		pet.setBirthDate(birthdate);
//		pet.setType(type);
//		return pet;
//		
//	}
	private Owner setOwnerInformation(String firstName, String lastName, String address, String city,
			String telephone) {
		Owner owner = new Owner();
		owner.setFirstName(firstName);
		owner.setLastName(lastName);
		owner.setAddress(address);
		owner.setCity(city);
		owner.setTelephone(telephone);
		return owner;
	}
}
