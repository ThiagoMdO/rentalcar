package com.rentalcars.cars.ms_car.config;

import com.rentalcars.cars.ms_car.enums.BrandEnum;
import com.rentalcars.cars.ms_car.model.entities.Car;
import com.rentalcars.cars.ms_car.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class Instantiation implements CommandLineRunner {

    private final CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {

        carRepository.deleteAll();

        var car1 = Car.builder()
//                .id(UUID.fromString("7a1b7eb6-2d43-4a2e-9013-500cbc9d4d38"))
//                .id(UUID.randomUUID())
                .model("Uno")
                .brandEnum(BrandEnum.FORD)
                .color("Gray")
                .fabricationYear(LocalDate.of(2004, 1, 31))
                .build();
        var car2 = Car.builder()
                .model("Palio")
                .brandEnum(BrandEnum.FORD)
                .color("White")
                .fabricationYear(LocalDate.of(2009, 1, 31))
                .build();
        var car3 = Car.builder()
                .model("iX")
                .brandEnum(BrandEnum.BMW)
                .color("gray")
                .fabricationYear(LocalDate.of(2025, 1, 31))
                .build();

        carRepository.saveAll(Arrays.asList(car1, car2, car3));
    }
}
