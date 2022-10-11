package com.example.demo.Repo;

import com.example.demo.Model.Onlinewallet;
import org.springframework.data.repository.CrudRepository;

public interface OnlinewalletRepository extends CrudRepository<Onlinewallet, Long> {
    Onlinewallet findByNamewell(String namewell);
}
