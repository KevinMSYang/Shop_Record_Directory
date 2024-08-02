package com.keviny.springmvc.shoprecord.service;

import com.keviny.springmvc.shoprecord.entity.Shop;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ShopService {
    List<Shop> findAllShopList();

    List<Shop> findByShopItem(String theShopItem);

    Shop findById(int theId);

    Shop findByShopExactItem(String theShopItem);

    Shop saveShopItem(Shop theShop);

    void deleteByShopItem(String theShopItem);

    void deleteById(int theId);

    List<Shop> findAllSortBy(String sortBy, Sort.Direction direction);

}
