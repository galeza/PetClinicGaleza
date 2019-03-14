package com.galeza.petclinic.helpers;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class RandomValues {

	private RandomValues() {
		throw new IllegalStateException("Utility class");
    }
	  
    public static String getRandomAlphaNumericWithSize(int sizeOfRandomString) {
        return randomAlphanumeric(sizeOfRandomString).toLowerCase();
    }
    
    public static String getRandomNumericWithSize(int sizeOfRandomString) {
        return randomNumeric(sizeOfRandomString);
    }
}
