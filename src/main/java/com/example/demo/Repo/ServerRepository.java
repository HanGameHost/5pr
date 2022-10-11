package com.example.demo.Repo;

import com.example.demo.Model.Server;
import org.springframework.data.repository.CrudRepository;

public interface ServerRepository extends CrudRepository<Server, Long> {
    Server findByipaddress(String servers);
}
