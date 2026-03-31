package com.example.shoppinginfoproject.repository;

import com.example.shoppinginfoproject.entity.ShoppingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingInfoRepository extends JpaRepository<ShoppingInfo, Long> {
    List<ShoppingInfo> findByLoginId(Long loginId);
}