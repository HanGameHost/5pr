package com.example.demo.Repo;

import com.example.demo.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findBySurname(String surname);
}
