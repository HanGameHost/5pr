package com.example.demo.Repo;

import com.example.demo.Model.Typeopeation;
import org.springframework.data.repository.CrudRepository;

public interface TypeopeationRepository extends CrudRepository<Typeopeation, Long> {
    Typeopeation findBynameoperation(String nameoperation);
}
