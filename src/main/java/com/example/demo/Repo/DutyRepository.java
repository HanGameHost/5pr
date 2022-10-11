package com.example.demo.Repo;

import com.example.demo.Model.Duty;
import org.springframework.data.repository.CrudRepository;

public interface DutyRepository extends CrudRepository<Duty, Long> {
    Duty findByNameDuty(String nameDuty);
}
