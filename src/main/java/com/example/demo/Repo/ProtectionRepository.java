package com.example.demo.Repo;

import com.example.demo.Model.Protection;
import org.springframework.data.repository.CrudRepository;

public interface ProtectionRepository extends CrudRepository<Protection, Long> {
    Protection findBylevelprotection(String levelprotection);
}
