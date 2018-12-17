package com.grzeszczyk.services;


import com.google.common.collect.Lists;
import com.grzeszczyk.Car;
import com.grzeszczyk.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car save(Car car) {
        Car savedCar = carRepository.save(car);
        return savedCar;
    }

    public Car find(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            return car.get();
        }
        return null;
    }

    public List<Car> findAll() {
        Iterable<Car> carsIterable = carRepository.findAll();
        List<Car> carsList = Lists.newArrayList(carsIterable);
        return carsList;
    }

    public Car update(Car car) {
        Car updatedCar = carRepository.save(car);
        return updatedCar;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
