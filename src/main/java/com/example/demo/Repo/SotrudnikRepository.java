package com.example.demo.Repo;

import com.example.demo.Model.Sotrudnik;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SotrudnikRepository extends CrudRepository<Sotrudnik, Long> {
    Sotrudnik findByUsername(String username);

    List<Sotrudnik> findBySurname(String surname);
}
