package com.example.demo.Repo;

import com.example.demo.Model.Cryptocurrency;
import org.springframework.data.repository.CrudRepository;

public interface CryptocurrencyRepository extends CrudRepository<Cryptocurrency, Long> {
    Cryptocurrency findByName(String name);
}
