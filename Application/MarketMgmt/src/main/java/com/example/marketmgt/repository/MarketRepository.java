package com.example.marketmgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marketmgt.entity.MarketTransaction;

public interface MarketRepository extends JpaRepository<MarketTransaction, Long> {

    List<MarketTransaction> findByOrderId(Long orderId);

}