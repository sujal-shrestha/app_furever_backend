package com.example.app_furever_backend;

import com.example.app_furever_backend.pojo.Pet;
import com.example.app_furever_backend.repo.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.assertj.core.api.Assertions;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PetRepositoryTests {

    @Autowired
    private PetRepository petRepository;

    @Test
    public void testFindAllPets() {
        List<Pet> pets = petRepository.findAll();
        Assertions.assertThat(pets).isNotNull();
    }

}
