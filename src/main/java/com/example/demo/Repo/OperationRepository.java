package com.example.demo.Repo;

import com.example.demo.Model.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository  extends CrudRepository<Operation, Long> {
}
