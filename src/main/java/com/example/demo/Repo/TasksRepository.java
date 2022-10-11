package com.example.demo.Repo;

import com.example.demo.Model.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Long> {
    Tasks findBytypetasks(String tasks);
}
