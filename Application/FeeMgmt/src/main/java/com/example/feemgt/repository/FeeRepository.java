package com.example.feemgt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.feemgt.entity.Fee;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    List<Fee> findByOrderId(Long orderId);
}