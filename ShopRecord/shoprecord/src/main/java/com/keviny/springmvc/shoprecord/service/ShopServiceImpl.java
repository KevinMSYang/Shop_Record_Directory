package com.keviny.springmvc.shoprecord.service;

import com.keviny.springmvc.shoprecord.dao.ShopDAO;
import com.keviny.springmvc.shoprecord.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private ShopDAO shopDAO;

    @Autowired
    public ShopServiceImpl(ShopDAO theShopDAO) {
        shopDAO = theShopDAO;
    }

    @Override
    public List<Shop> findAllShopList() {
        return shopDAO.findallShopListOrderByItem();
    }

    @Override
    public List<Shop> findByShopItem(String theShopItem) {
        return shopDAO.findByShopItem(theShopItem);
    }

    @Override
    public Shop findById(int theId) {
        return shopDAO.findById(theId);
    }

    @Override
    public Shop findByShopExactItem(String theShopItem) {
        return shopDAO.findByShopExactItem(theShopItem);
    }

    @Transactional
    @Override
    public Shop saveShopItem(Shop theShop) {
        return shopDAO.saveShopItem(theShop);
    }

    @Transactional
    @Override
    public void deleteByShopItem(String theShopItem) {
        shopDAO.deleteByShopItem(theShopItem);
    }
}
