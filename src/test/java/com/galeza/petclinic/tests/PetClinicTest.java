package com.galeza.petclinic.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.galeza.petclinic.testlistener.TestListener;
import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.pageobjects.findowners.FindOwners;
import com.galeza.petclinic.pageobjects.home.Home;
import com.galeza.petclinic.pageobjects.ownerinformation.OwnerInformation;
import com.galeza.petclinic.pageobjects.owners.Owners;
import com.galeza.petclinic.pojo.Owner;

//@Listeners(TestListener.class)
public class PetClinicTest extends BaseTest {

	@Test()
	public void modifyOwnerTest() {
		Owner owner = null;
		LOG.info("Hej");
		Home homePage = new Home(driver);
		OwnerInformation ownerInfo = homePage.open().goToFindOwners().showAllOwners().goToOwner("Jean Coleman");

	}

}
