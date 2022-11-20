package org.example.service;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.example.enums.Extension;
import org.example.model.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PetShelterTest {

    PetShelter petShelter = new PetShelter(new JsonMapper(), Extension.JSON);
    Pet[] pets = {new Pet("Barsik", "16.11.2022", 5, "male", "persian")};

    @Test
    public void givePetToShelterTest(){
        petShelter.givePetToShelter(Arrays.stream(pets).toList());
    }

    @Test
    public void adoptPetFromShelterTest(){
        List<Pet> adoptedPets = petShelter.adoptPetFromShelter();
        Assertions.assertArrayEquals(pets, adoptedPets.toArray());
    }
}