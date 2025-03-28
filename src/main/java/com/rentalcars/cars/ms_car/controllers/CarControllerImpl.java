package com.rentalcars.cars.ms_car.controllers;

import com.rentalcars.cars.ms_car.enums.BrandEnum;
import com.rentalcars.cars.ms_car.interfaces.CarController;
import com.rentalcars.cars.ms_car.model.dto.out.CarResponseDTO;
import com.rentalcars.cars.ms_car.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> getById(@PathVariable String id) {
        var car = carService.getACarById(id);
        return ResponseEntity.ok(car);
    }

    @Override
    @GetMapping("/search")
    public ResponseEntity<List<CarResponseDTO>> searchCars(
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) BrandEnum brandEnum,
            @RequestParam(required = false) Integer startYear,
            @RequestParam(required = false) Integer endYear
            ){

        List<CarResponseDTO> cars = carService.search(model, color, brandEnum, startYear, endYear);

        return ResponseEntity.ok(cars);
    }
}
