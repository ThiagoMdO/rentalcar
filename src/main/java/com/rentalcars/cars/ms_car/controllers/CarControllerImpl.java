package com.rentalcars.cars.ms_car.controllers;

import com.rentalcars.cars.ms_car.interfaces.CarController;
import com.rentalcars.cars.ms_car.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/cars")
@RequiredArgsConstructor
public class CarControllerImpl implements CarController {

    private final CarService carService;

}
