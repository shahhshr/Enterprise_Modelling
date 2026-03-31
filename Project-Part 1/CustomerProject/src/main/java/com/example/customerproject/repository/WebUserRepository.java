package com.example.customerproject.repository;

import com.example.customerproject.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
}