package com.galeza.petclinic.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.galeza.petclinic.testlistener.TestListener;
import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.pageobjects.findowners.FindOwners;
import com.galeza.petclinic.pageobjects.home.Home;
import com.galeza.petclinic.pageobjects.newowner.NewOwner;
import com.galeza.petclinic.pageobjects.ownerinformation.OwnerInformation;
import com.galeza.petclinic.pageobjects.owners.Owners;
import com.galeza.petclinic.pojo.Owner;
import static org.assertj.core.api.Assertions.*;

//@Listeners(TestListener.class)
public class PetClinicTest extends BaseTest {

	@DataProvider(name = "ownerInformation")

	public static Object[][] ownerInformation() {

		return new Object[][] {
				{ "Jean", "Coleman", "ModifiedJean", "ModifiedColeman", "Kijowska", "Krakow", "123456789" }, };

	}

	@Test(dataProvider = "ownerInformation")
	public void modifyOwnerTest(String firstName, String lastName, String modifiedFirstName, String modifiedLastName,
			String address, String city, String telephone) {
		Home homePage = new Home(driver);
		OwnerInformation ownerInfoPage = homePage.open().goToFindOwners().showAllOwners()
				.goToOwner(firstName + " " + lastName);
		Owner existingOwner = ownerInfoPage.readInformationAboutOwner();
		assertThat(existingOwner.getFirstName()).isEqualToIgnoringCase(firstName);
		assertThat(existingOwner.getLastName()).isEqualToIgnoringCase(lastName);
		NewOwner newOwnerPage = ownerInfoPage.openNewOwnerPage();
		Owner modifiedOwner = setOwnerInformation(modifiedFirstName, modifiedLastName, address, city, telephone);
		newOwnerPage.updateOwnerInformation(modifiedOwner);
		ownerInfoPage = newOwnerPage.updateOwner();
		Owner readModifiedOwner = ownerInfoPage.readInformationAboutOwner();
		assertThat(readModifiedOwner).isEqualToComparingFieldByField(modifiedOwner);
	}

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
