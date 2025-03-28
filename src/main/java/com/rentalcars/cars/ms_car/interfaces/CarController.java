package com.rentalcars.cars.ms_car.interfaces;

import com.rentalcars.cars.ms_car.model.dto.out.CarResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarController {

    ResponseEntity<List<CarResponseDTO>> getAll();

    ResponseEntity<CarResponseDTO> getById(String id);
}
