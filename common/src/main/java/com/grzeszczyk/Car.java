package com.grzeszczyk;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Immutable
public class Car {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    @Enumerated(STRING)
    private TypeOfCar typeOfCar;
    private boolean isAvailable;
    private Double engineCapacity;
    private Integer enginePower;
    @Enumerated(STRING)
    private FuelType fuelType;
    private Integer numberOfDoors;
    private Integer numberOfSeats;
    private Integer yearOfProduction;
    private String color;
    @Enumerated(STRING)
    private Gearbox gearbox;
    private Integer numberVIN;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dealer_id")
    private Dealer dealer;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "client_id")
    private Client client;






    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getNumberVIN() {
        return numberVIN;
    }

    public void setNumberVIN(Integer numberVIN) {
        this.numberVIN = numberVIN;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", name='" + name + '\'' +
                ", typeOfCar=" + typeOfCar +
                ", engineCapacity=" + engineCapacity +
                ", enginePower=" + enginePower +
                ", fuelType=" + fuelType +
                ", numberOfDoors=" + numberOfDoors +
                ", numberOfSeats=" + numberOfSeats +
                ", yearOfProduction=" + yearOfProduction +
                ", color='" + color + '\'' +
                ", gearbox=" + gearbox +
                ", numberVIN=" + numberVIN +
                '}';
    }
}
