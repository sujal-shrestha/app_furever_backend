package com.example.app_furever_backend.repo;

import com.example.app_furever_backend.pojo.Pet;
import com.example.app_furever_backend.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByOwner(User owner);
}
