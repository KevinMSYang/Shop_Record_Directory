package com.keviny.springmvc.shoprecord.controller;

import com.keviny.springmvc.shoprecord.entity.Shop;
import com.keviny.springmvc.shoprecord.entity.Store;
import com.keviny.springmvc.shoprecord.service.ShopService;
import com.keviny.springmvc.shoprecord.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shoprecord")
public class ShopRecordController {
    private ShopService shopService;
    private StoreService storeService;

    @Autowired
    public ShopRecordController(ShopService theShopService, StoreService theStoreService) {
        shopService = theShopService;
        storeService = theStoreService;
    }

    @GetMapping("/list")
    public String listDirectory(Model theModel) {
        // get the shoplist from db
        List<Shop> theShops = shopService.findAllShopList();
        // add to the spring model
        theModel.addAttribute("shopsitem", theShops);

        List<Store> theStores = storeService.findAllStoreList();
        theModel.addAttribute("stores", theStores);

        return "shopdirectory/list-directory";
    }

    @GetMapping("/showFormForAddShop")
    public String showFormForAddShop(Model theModel) {
        // create model attribute to bind form data
        Shop theShop = new Shop();
        theModel.addAttribute("shopitem", theShop);
        return "shopdirectory/shopitem-form";
    }

    @PostMapping("/save")
    public String saveShopItem(@ModelAttribute("shopitem") Shop theShop) {
        shopService.saveShopItem(theShop);
        return "redirect:/shoprecord/list";
    }

    @GetMapping("/showFormForAddStore")
    public String showFormForAddStore(Model theModel) {
        Store theStore = new Store();
        theModel.addAttribute("stores", theStore);
        return "shopdirectory/store-form";
    }

    @PostMapping("/saveStore")
    public String saveStore(@ModelAttribute("stores") Store theStore) {
        storeService.saveStore(theStore);
        return "redirect:/shoprecord/list";
    }

    @GetMapping("/showFormForShopUpdate")
    public String showFormForShopUpdate(@RequestParam("shopId") int theId, Model theModel) {
        // get the shop from the service
        Shop theShop = shopService.findById(theId);
        // set shop in the model to prepopulate the form
        theModel.addAttribute("shopitem", theShop);
        // send over to our form
        return "shopdirectory/shopitem-form";
    }
}
