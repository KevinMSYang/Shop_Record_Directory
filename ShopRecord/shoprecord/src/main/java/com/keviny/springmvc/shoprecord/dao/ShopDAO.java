package com.keviny.springmvc.shoprecord.dao;

import com.keviny.springmvc.shoprecord.entity.Shop;
import com.keviny.springmvc.shoprecord.entity.Store;


import java.util.List;

public interface ShopDAO {
    List<Shop> findAllShopList();

    List<Shop> findByShopItem(String theShopItem);

    Shop findById(int theId);

    Shop findByShopExactItem(String theShopItem);

    Shop saveShopItem(Shop theShop);

    void deleteByShopItem(String theShopItem);

    void deleteById(int theId);

    public List<Shop> findallShopListOrderByItem();

    List<Shop> getShopItems();
}
