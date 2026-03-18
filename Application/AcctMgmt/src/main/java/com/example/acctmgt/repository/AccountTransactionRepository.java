package com.example.acctmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.acctmgt.entity.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    List<AccountTransaction> findByOrderId(Long orderId);
}