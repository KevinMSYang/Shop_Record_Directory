package com.keviny.springmvc.shoprecord.dao;

import com.keviny.springmvc.shoprecord.entity.Shop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class ShopDAOImpl implements ShopDAO {

    private EntityManager entityManager;

    @Autowired
    public ShopDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Shop> findAllShopList() {
        // create a query
        TypedQuery<Shop> theQuery = entityManager.createQuery("from Shop", Shop.class);
        // execute query and get result list
        List<Shop> shopes = theQuery.getResultList();
        // return the results
        return shopes;
    }

    @Override
    public List<Shop> findByShopItem(String theShopItem) {
        TypedQuery<Shop> theQuery = entityManager.createQuery(
                "SELECT s FROM Shop s WHERE s.item LIKE :item", Shop.class
        ).setParameter("item", "%"+theShopItem+"%");
        List<Shop> shopsItem = theQuery.getResultList();
        return shopsItem;
    }

    @Override
    public Shop findById(int theId) {
        Shop theShop = entityManager.find(Shop.class, theId);
        return theShop;
    }

    @Override
    public Shop findByShopExactItem(String theShopItem) {
        TypedQuery<Shop> theQuery = entityManager.createQuery(
                "SELECT s FROM Shop s WHERE s.item = :item", Shop.class
        ).setParameter("item", theShopItem);
        Shop shopItem = theQuery.getSingleResult();
        return shopItem;
    }

    @Override
    public Shop saveShopItem(Shop theShop) {
        Shop dbStore = entityManager.merge(theShop);
        return dbStore;
    }

    @Override
    public void deleteByShopItem(String theShopItem) {
        TypedQuery<Shop> theQuery = entityManager.createQuery(
                "SELECT s FROM Shop s WHERE s.item = :item", Shop.class
        ).setParameter("item", theShopItem);
        Shop shopItem = theQuery.getSingleResult();
        entityManager.remove(shopItem);
    }

    @Override
    public void deleteById(int theId) {
        Shop theShop = entityManager.find(Shop.class,theId);
        entityManager.remove(theShop);
    }

    @Override
    public List<Shop> findallShopListOrderByItem() {
        TypedQuery<Shop> theQuery = entityManager.createQuery(
                "SELECT s FROM Shop s ORDER BY s.item", Shop.class
        );
        List<Shop> shopes = theQuery.getResultList();
        return shopes;
    }
}