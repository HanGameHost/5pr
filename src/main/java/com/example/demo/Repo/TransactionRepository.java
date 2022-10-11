package com.example.demo.Repo;

import com.example.demo.Model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Transaction findBytotalnumberofoperation(int totalnumberofoperation);
}
