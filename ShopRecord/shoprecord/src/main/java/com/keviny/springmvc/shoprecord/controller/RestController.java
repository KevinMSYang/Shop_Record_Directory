package com.keviny.springmvc.shoprecord.controller;

import com.keviny.springmvc.shoprecord.entity.Shop;
import com.keviny.springmvc.shoprecord.entity.Store;
import com.keviny.springmvc.shoprecord.service.ShopService;
import com.keviny.springmvc.shoprecord.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private StoreService storeService;
    private ShopService shopService;
    // inject store dao
    public RestController(StoreService theStoreService, ShopService theShopService) {
        storeService = theStoreService;
        shopService = theShopService;
    }


    // add mapping for GET - find all records
    @GetMapping("/storelist")
    public List<Store> findAllStoreList() {
        return storeService.findAllStoreList();
    }

    @GetMapping("/shoplist")
    public List<Shop> findAllShopList() {
        return shopService.findAllShopList();
    }

    // add mapping for GET - find record
    @GetMapping("/storelist/{storeName}")
    public Store getStoreName(@PathVariable String storeName) {
        Store theStore = storeService.findByStoreName(storeName);

        if (theStore == null) {
            throw new RuntimeException("Store Name not found - " + storeName);
        }

        return theStore;
    }

    @GetMapping("/shoplist/{shopItem}")
    public List<Shop> getShopItem(@PathVariable String shopItem) {
        List<Shop> theItems = shopService.findByShopItem(shopItem);
        if (theItems.isEmpty()) {
            throw new RuntimeException("Item not found - " + shopItem);
        }
        return theItems;
    }

    // add mapping for POST - add record
    @PostMapping("/storelist")
    public Store addStore(@RequestBody Store theStore) {
        theStore.setId(0);
        Store dbStore = storeService.saveStore(theStore);
        return dbStore;
    }

    @PostMapping("/shoplist")
    public Shop addShopItem(@RequestBody Shop theShop) {
        theShop.setId(0);
        Shop dbShop = shopService.saveShopItem(theShop);
        return dbShop;
    }

    // add mapping for PUT - update record
    @PutMapping("/storelist")
    public Store updateStoreName(@RequestBody Store theStore) {
        Store dbStore = storeService.saveStore(theStore);
        return dbStore;
    }

    @PutMapping("/shoplist")
    public Shop updateShopItem(@RequestBody Shop theShop) {
        Shop dbShop = shopService.saveShopItem(theShop);
        return dbShop;
    }

    // add mapping for DELETE - delete record
    @DeleteMapping("/storelist/{storeName}")
    public String deleteStore(@PathVariable String storeName) {
        Store theStore = storeService.findByStoreName(storeName);

        // throw exception if null
        if (theStore == null) {
            throw new RuntimeException("Store is not found - " +storeName);
        }
        storeService.deleteByStoreName(storeName);
        return "Deleted store name - " + storeName;
    }

    @DeleteMapping("/shoplist/{shopItem}")
    public String deleteShopItem(@PathVariable String shopItem) {
        Shop theShopItem = shopService.findByShopExactItem(shopItem);
        if (theShopItem == null) {
            throw new RuntimeException("Shop Item is not found - " + shopItem);
        }
        shopService.deleteByShopItem(shopItem);
        return "Deleted shop item - " + shopItem;
    }

}
