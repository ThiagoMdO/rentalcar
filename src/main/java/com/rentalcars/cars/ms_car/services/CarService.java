package com.rentalcars.cars.ms_car.services;

import com.rentalcars.cars.ms_car.enums.BrandEnum;
import com.rentalcars.cars.ms_car.exceptions.customException.CarNotFoundException;
import com.rentalcars.cars.ms_car.model.dto.in.CarRequestDTO;
import com.rentalcars.cars.ms_car.model.dto.in.CarRequestUpdateDTO;
import com.rentalcars.cars.ms_car.model.dto.out.CarResponseDTO;
import com.rentalcars.cars.ms_car.model.entities.Car;
import com.rentalcars.cars.ms_car.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CarService.class);

    private final CarRepository carRepository;

    public List<CarResponseDTO> getAllCars() {
        return carRepository.findAll().stream()
                .peek(car -> logger.info("Car Id {}", car.getId()))
                .map(CarResponseDTO::createResponseDTO)
                .toList();
    }

    public CarResponseDTO getACarById(String id) {
        //refatorar com metodo de busca por ID, depois usar map com method reference
        return carRepository.findById(UUID.fromString(id)).map(CarResponseDTO::createResponseDTO)
                .orElseThrow(CarNotFoundException::new);
    }

    public List<CarResponseDTO> search(String model, String color, BrandEnum brandEnum, Integer startYear, Integer endYear) {
        return carRepository.searchCars(model, color, brandEnum, startYear, endYear)
                .stream()
                .map(CarResponseDTO::createResponseDTO)
                .toList();
    }

    public CarResponseDTO registerCar(CarRequestDTO carRequestDTO) {
        var car = createEntity(carRequestDTO);

        return carSaved(car);
    }

    public CarResponseDTO updateCar(String id, CarRequestUpdateDTO carRequestDTO) {
        var carInDB = getACar(id);

        return updateCarEntity(carInDB, carRequestDTO);
    }

    private CarResponseDTO updateCarEntity(Car carInDB, CarRequestUpdateDTO requestUpdateDTO) {
        var car = Car.updateEntityByRequestUpdate(carInDB, requestUpdateDTO);
        var carSaved = carRepository.save(car);

        return CarResponseDTO.createResponseDTO(carSaved);
    }

    private Car getACar(String id) {
        return carRepository.findById(UUID.fromString(id)).orElseThrow(CarNotFoundException::new);
    }

    private Car createEntity(CarRequestDTO requestDTO) {
        return Car.createEntityByRequest(requestDTO);
    }

    private CarResponseDTO carSaved(Car car) {
        return CarResponseDTO
                .createResponseDTO(
                        Optional.of(carRepository.save(car)).get()
                );
    }
}
