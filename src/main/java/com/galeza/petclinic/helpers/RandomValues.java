package com.galeza.petclinic.helpers;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class RandomValues {

    public String getRandomAlphaNumericWithSize(int sizeOfRandomString) {
        return randomAlphanumeric(sizeOfRandomString).toLowerCase();
    }
    
    public String getRandomNumericWithSize(int sizeOfRandomString) {
        return randomNumeric(sizeOfRandomString);
    }
}
