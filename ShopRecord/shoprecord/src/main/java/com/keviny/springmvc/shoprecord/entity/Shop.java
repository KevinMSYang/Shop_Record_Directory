package com.keviny.springmvc.shoprecord.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "shoplist")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedVal:to specify how the primary key values of an entity are generated
    // GenerationType.IDENTITY: This strategy will help us to generate the primary key value by the database itself
    // using the auto-increment column option.
    @Column(name = "id")
    private int id;

    @Column(name = "item")
    private String item;

    @Column(name = "price")
    private String price;

    @Column(name = "store")
    private String storeName;

    @Column(name = "date")
    private java.sql.Date date;

    @Column(name = "special_deal")
    private String specialDeal;

    public Shop () {

    }

    public Shop(String item, String price, String storeName, Date date, String specialDeal) {
        this.item = item;
        this.price = price;
        this.storeName = storeName;
        this.date = date;
        this.specialDeal = specialDeal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpecialDeal() {
        return specialDeal;
    }

    public void setSpecialDeal(String specialDeal) {
        this.specialDeal = specialDeal;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", item='" + item + '\'' +
                ", price=" + price +
                ", storeName='" + storeName + '\'' +
                ", date=" + date +
                ", specialDeal='" + specialDeal + '\'' +
                '}';
    }
}
