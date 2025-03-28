package com.rentalcars.cars.ms_car.services;

import com.rentalcars.cars.ms_car.model.dto.out.CarResponseDTO;
import com.rentalcars.cars.ms_car.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CarService.class);

    private final CarRepository carRepository;

    public List<CarResponseDTO> getAllCars() {
        return carRepository.findAll().stream().map(CarResponseDTO::createResponseDTO).toList();
    }

}
