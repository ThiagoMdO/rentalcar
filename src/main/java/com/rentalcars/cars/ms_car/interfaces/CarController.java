package com.rentalcars.cars.ms_car.interfaces;

import com.rentalcars.cars.ms_car.enums.BrandEnum;
import com.rentalcars.cars.ms_car.model.dto.in.CarRequestDTO;
import com.rentalcars.cars.ms_car.model.dto.out.CarResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarController {

    ResponseEntity<List<CarResponseDTO>> getAll();

    ResponseEntity<CarResponseDTO> getById(String id);

    ResponseEntity<List<CarResponseDTO>> searchCars(
            String model,
            String color,
            BrandEnum brandEnum,
            Integer startYear,
            Integer endYear
    );

    ResponseEntity<CarResponseDTO> create(CarRequestDTO carRequestDTO);
}
