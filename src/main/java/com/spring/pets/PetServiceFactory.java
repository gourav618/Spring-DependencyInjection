package com.spring.pets;

public class PetServiceFactory {

    public PetService getPetService(String type){
        switch(type){
            case "dog":
                return new DogPetService();
            case "cat":
                return new CatPetService();
            default:
                return new DogPetService();
        }
    }
}
