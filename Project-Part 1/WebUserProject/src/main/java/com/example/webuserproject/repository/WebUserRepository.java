package com.example.webuserproject.repository;

import com.example.webuserproject.entity.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
}