package com.grzeszczyk.apiREST;

import com.grzeszczyk.Car;
import com.grzeszczyk.services.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.grzeszczyk.FuelType.BENZINE;
import static com.grzeszczyk.Gearbox.MANUAL;
import static com.grzeszczyk.TypeOfCar.COUPE;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/cars")
public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);


    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Car save(@RequestBody Car car) {
        Car savedCar = carService.save(car);

        log.info("Add car {}", savedCar);

        return savedCar;
    }

    @GetMapping("/{id}")
    public Car find(@PathVariable  Long id) {
        return carService.find(id);
    }

    @RequestMapping("/all_car")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Car> getUsers() {
        List<Car> cars = carService.findAll();

        log.info("Retrieve objects {}", cars);

        return cars;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);

        log.info("Delete car with id {}", id);

        return new ResponseEntity(NO_CONTENT);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    public Car update(@RequestBody Car car) {
        Car updatedCar = carService.update(car);

        log.info("Updated Car {}", updatedCar);

        return updatedCar;
    }

    @GetMapping("/fill")
    public String fillData(){
        Car bmw = new Car();
        bmw.setName("BMW E46");
        bmw.setNumberOfDoors(2);
        bmw.setColor("black");
        bmw.setEngineCapacity(2.8);
        bmw.setEnginePower(200);
        bmw.setFuelType(BENZINE);
        bmw.setGearbox(MANUAL);
        bmw.setNumberVIN(789456123);
        bmw.setNumberOfSeats(5);
        bmw.setYearOfProduction(2018);
        bmw.setTypeOfCar(COUPE);
        bmw.setAvailable(true);
        carService.save(bmw);
        return "Created some users.";
    }
}
