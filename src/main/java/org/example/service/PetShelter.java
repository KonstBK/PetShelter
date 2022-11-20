package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.enums.Extension;
import org.example.model.Pet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetShelter {

    private final ObjectMapper mapper;
    private final Extension extension;
    private final String path = "src/main/resources/pet";
//    private final File pets = new File();

    public PetShelter(ObjectMapper mapper, Extension extension) {
        this.mapper = mapper;
        this.extension = extension;
    }

    public void givePetToShelter(List<Pet> pets){
        try {
            //mapper.writeValue(new File(path + extension.getExtension()), animal);
            OutputStream fos = new FileOutputStream(path + extension.getExtension());
            mapper.writeValue(fos, pets);
        } catch (IOException e) {
            System.out.println("cannot create file");
        }
    }

    public List<Pet> adoptPetFromShelter(){
        try {
            return Arrays.stream(mapper.readValue(new File(path + extension.getExtension()), Pet[].class)).toList();
        } catch (IOException e) {
            System.out.println("cannot read file" + e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
