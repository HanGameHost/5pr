package com.example.demo.Repo;

import com.example.demo.Model.Systemrepodting;
import org.springframework.data.repository.CrudRepository;

public interface SystemrepodtingRepository extends CrudRepository<Systemrepodting, Long> {
    Systemrepodting findBynumberofconnection(int numberofconnection);
}
