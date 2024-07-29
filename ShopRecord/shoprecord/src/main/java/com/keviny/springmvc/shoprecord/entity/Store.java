package com.keviny.springmvc.shoprecord.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "storelist")
public class Store {

    // define fields
    @Id // @Id:defines the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

        //The problem is in the generated query, due to the usage of "store"/"rank"
        // since it's a reserved word in MySQL.
        // use @Column(name="[...]")
    @Column(name = "[store]")
    private String store;

    @Column(name = "[rank]")
    private int rank;

    // define constructors
    public Store () {
        // No-arg constructor required by JPA
    }

    public Store(String store, int rank) {
        this.store = store;
        this.rank = rank;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    // define toString

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", store='" + store + '\'' +
                ", rank=" + rank +
                '}';
    }
}
