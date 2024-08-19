package com.example.app_furever_backend.controller;

import com.example.app_furever_backend.pojo.Pet;
import com.example.app_furever_backend.pojo.User;
import com.example.app_furever_backend.service.PetService;
import com.example.app_furever_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Pet>> getUserPets(Principal principal) {
        User user = userService.findByEmail(principal.getName());  // Assume the user's email is the principal name
        if (user != null) {
            List<Pet> pets = petService.getPetsByOwner(user);
            return ResponseEntity.ok(pets);
        } else {
            return ResponseEntity.status(404).body(null); // Not Found if user is not found
        }
    }

    @PostMapping
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        if (user != null) {
            pet.setOwner(user);
            Pet createdPet = petService.addPet(pet);
            return ResponseEntity.status(201).body(createdPet);
        } else {
            return ResponseEntity.status(404).body(null); // Not Found if user is not found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id, Principal principal) {
        Pet pet = petService.getPetById(id);
        if (pet != null && pet.getOwner().getEmail().equals(principal.getName())) {
            petService.deletePet(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(403).build();  // Forbidden if user is not the owner
        }
    }
}
