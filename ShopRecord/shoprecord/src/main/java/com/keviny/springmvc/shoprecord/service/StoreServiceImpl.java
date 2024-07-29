package com.keviny.springmvc.shoprecord.service;

import com.keviny.springmvc.shoprecord.dao.StoreDAO;
import com.keviny.springmvc.shoprecord.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    private StoreDAO storeDAO;

    @Autowired
    public StoreServiceImpl(StoreDAO theStoreDAO) {
        storeDAO = theStoreDAO;
    }

    @Override
    public List<Store> findAllStoreList() {
        return storeDAO.findAllStoreList();
    }

    @Override
    public Store findById(int theId) {
        return storeDAO.findById(theId);
    }

    @Override
    public Store findByStoreName(String theStoreName) {
        return storeDAO.findByStoreName(theStoreName);
    }

    @Transactional
    @Override
    public Store saveStore(Store theStore) {
        return storeDAO.saveStore(theStore);
    }

    @Transactional
    @Override
    public void deleteByStoreName(String theStoreName) {
        storeDAO.deleteByStoreName(theStoreName);
    }
}
