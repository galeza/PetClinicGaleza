package com.galeza.petclinic.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.galeza.petclinic.testlistener.TestListener;
import com.galeza.petclinic.base.BaseTest;
import com.galeza.petclinic.pageobjects.home.Home;


//@Listeners(TestListener.class)
public class PetClinicTest extends BaseTest{

	@Test()
	public void firstTest(){
		LOG.info("Hej");
		Home homePage = new Home(driver);
		homePage.open();
		
	}
	
	
}
