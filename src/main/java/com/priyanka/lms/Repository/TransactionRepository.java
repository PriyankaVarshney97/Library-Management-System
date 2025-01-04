package com.priyanka.lms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.lms.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {}
