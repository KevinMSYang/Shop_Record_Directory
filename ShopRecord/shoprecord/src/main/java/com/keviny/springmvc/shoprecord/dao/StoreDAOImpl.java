package com.keviny.springmvc.shoprecord.dao;

import com.keviny.springmvc.shoprecord.entity.Shop;
import com.keviny.springmvc.shoprecord.entity.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreDAOImpl implements StoreDAO{

    // define field for entity manager
    private EntityManager entityManager;
    // EntityManager: allow applications to manage and search for entities in the relational database.


    // set up  constructor injection
    @Autowired
    public StoreDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Store> findAllStoreList() {
        // create a query
        TypedQuery<Store> theQuery = entityManager.createQuery("from Store", Store.class);
        // execute query and get result list
        List<Store> stores = theQuery.getResultList();
        // return the results
        return stores;
    }

    @Override
    public Store findById(int theId) {
        Store theStore = entityManager.find(Store.class,theId);
        return theStore;
    }

    @Override
    public Store findByStoreName(String theStoreName) {
        // get store
        TypedQuery<Store> theQuery = entityManager.createQuery(
                "SELECT s FROM Store s WHERE s.store = :store", Store.class
        ).setParameter("store", theStoreName);
            // entityManager.find: find an entity by its primary key
        Store storeName = theQuery.getSingleResult();
        // return store
        return storeName;
    }

    @Override
    public Store saveStore(Store theStore) {
        // save store
        Store dbStore = entityManager.merge(theStore);
            // EntityManager. merge() can insert new objects and update existing ones.
        // return the dbStore
        return dbStore;
    }

    @Override
    public void deleteByStoreName(String theStoreName) {
        // find store by name
        TypedQuery<Store> theQuery = entityManager.createQuery(
                "SELECT s FROM Store s WHERE s.store = :store", Store.class
        ).setParameter("store", theStoreName);
        Store storeName = theQuery.getSingleResult();
        // remove store
        entityManager.remove(storeName);
    }
}
