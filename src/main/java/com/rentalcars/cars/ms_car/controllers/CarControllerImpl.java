package com.rentalcars.cars.ms_car.controllers;

import com.rentalcars.cars.ms_car.interfaces.CarController;
import com.rentalcars.cars.ms_car.model.dto.out.CarResponseDTO;
import com.rentalcars.cars.ms_car.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/cars")
@RequiredArgsConstructor
public class CarControllerImpl implements CarController {

    private final CarService carService;

    @Override
    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> getAll() {
        var list = carService.getAllCars();
        return ResponseEntity.ok(list);
    }
}
