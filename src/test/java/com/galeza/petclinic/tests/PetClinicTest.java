package com.galeza.petclinic.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.galeza.petclinic.testlistener.TestListener;
import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.pageobjects.findowners.FindOwners;
import com.galeza.petclinic.pageobjects.home.Home;
import com.galeza.petclinic.pageobjects.owners.Owners;


//@Listeners(TestListener.class)
public class PetClinicTest extends BaseTest{

	@Test()
	public void modifyOwnerTest(){
		LOG.info("Hej");
		Home homePage = new Home(driver);
		//homePage.open();
//		FindOwners findOwners = homePage.findOwners();
//		Owners owners = findOwners.searchOwners();
		Owners owners = homePage.open().goToFindOwners().showAllOwners();
		
	}
	
	
}
