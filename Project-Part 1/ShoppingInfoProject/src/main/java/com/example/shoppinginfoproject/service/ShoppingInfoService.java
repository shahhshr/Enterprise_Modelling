package com.example.shoppinginfoproject.service;

import com.example.shoppinginfoproject.dto.ShoppingInfoResponse;
import com.example.shoppinginfoproject.entity.ShoppingInfo;
import com.example.shoppinginfoproject.entity.WebUser;
import com.example.shoppinginfoproject.repository.ShoppingInfoRepository;
import com.example.shoppinginfoproject.repository.WebUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingInfoService {

    private final WebUserRepository webUserRepository;
    private final ShoppingInfoRepository shoppingInfoRepository;

    public ShoppingInfoService(WebUserRepository webUserRepository,
                               ShoppingInfoRepository shoppingInfoRepository) {
        this.webUserRepository = webUserRepository;
        this.shoppingInfoRepository = shoppingInfoRepository;
    }

    public ShoppingInfoResponse getShoppingInfoByLoginId(Long loginId) {
        WebUser user = webUserRepository.findById(loginId).orElse(null);

        if (user == null) {
            return null;
        }

        List<ShoppingInfo> items = shoppingInfoRepository.findByLoginId(loginId);

        return new ShoppingInfoResponse(
                user.getId(),
                user.getUsername(),
                user.getStateOfUser(),
                items
        );
    }
}