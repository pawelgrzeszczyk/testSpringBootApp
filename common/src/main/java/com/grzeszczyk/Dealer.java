package com.grzeszczyk;


import com.google.common.collect.Lists;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private Date purchaseOfDate;
    private Integer quantity;



    /*@OneToMany(
            mappedBy = "dealer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Client> dealerClientsList = Lists.newArrayList();*/


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "car_id")
    private Car car;

    @OneToMany(
            mappedBy = "dealer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Car> dealerCarList = Lists.newArrayList();


    public Dealer(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPurchaseOfDate() {
        return purchaseOfDate;
    }

    public void setPurchaseOfDate(Date purchaseOfDate) {
        this.purchaseOfDate = purchaseOfDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Car> getDealerCarList() {
        return dealerCarList;
    }

    public void setDealerCarList(List<Car> dealerCarList) {
        this.dealerCarList = dealerCarList;
    }
}