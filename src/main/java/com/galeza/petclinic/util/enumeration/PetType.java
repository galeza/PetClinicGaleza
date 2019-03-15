package com.galeza.petclinic.util.enumeration;

import java.util.Random;

public enum PetType {

	BIRD,
	CAT,
	DOG,
	HAMSTER,
	LIZARD,
	SNAKE;
	

    public static PetType getRandomPetType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
