package com.keviny.springmvc.shoprecord.service;

import com.keviny.springmvc.shoprecord.entity.Store;

import java.util.List;

public interface StoreService {

    List<Store> findAllStoreList();

    Store findById(int theId);

    Store findByStoreName(String theStoreName);

    Store saveStore(Store theStore);

    void deleteByStoreName(String theStoreName);

    void deleteById(int theId);
}
