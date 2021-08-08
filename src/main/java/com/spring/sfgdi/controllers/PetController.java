package com.spring.sfgdi.controllers;

import com.spring.pets.PetService;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/28/19.
 */
@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
