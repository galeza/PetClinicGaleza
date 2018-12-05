package com.galeza.petclinic.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.galeza.petclinic.testlistener.TestListener;
import com.galeza.petclinic.base.BaseTest;


@Listeners(TestListener.class)
public class PetClinicTest extends BaseTest{

	@Test()
	public void firstTest(){
		LOG.info("Hej");
	}
	
	
}
