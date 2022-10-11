package com.example.demo.Repo;

import com.example.demo.Model.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Long> {
    Provider findByName(String name);
}
