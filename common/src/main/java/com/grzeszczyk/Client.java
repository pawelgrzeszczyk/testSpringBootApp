package com.grzeszczyk;


import com.google.common.collect.Lists;
import org.hibernate.annotations.Immutable;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Immutable
public class Client {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String emailAdress;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
    )
    private List<Car> carsList = Lists.newArrayList();

    /*@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "dealer_id")
    private Dealer dealer;*/


    public Client(String firstName, String lastName, int age, String emailAdress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAdress = emailAdress;
    }

    public Client(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", emailAdress='" + emailAdress + '\'' +
                ", carsList=" + carsList +
                '}';
    }
}
