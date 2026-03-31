package com.example.webuserproject.service;

import com.example.webuserproject.entity.WebUser;
import com.example.webuserproject.repository.WebUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebUserService {

    private final WebUserRepository webUserRepository;

    public WebUserService(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }

    public void saveWebUser(WebUser webUser) {
        webUserRepository.save(webUser);
    }

    public List<WebUser> getAllWebUsers() {
        return webUserRepository.findAll();
    }
}