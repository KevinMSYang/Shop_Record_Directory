package com.keviny.springmvc.shoprecord.service;

import com.keviny.springmvc.shoprecord.entity.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> findAllShopList();

    List<Shop> findByShopItem(String theShopItem);

    Shop findById(int theId);

    Shop findByShopExactItem(String theShopItem);

    Shop saveShopItem(Shop theShop);

    void deleteByShopItem(String theShopItem);

    void deleteById(int theId);
}
