package com.rentalcars.cars.ms_car.model.dto.in;

import com.rentalcars.cars.ms_car.enums.BrandEnum;

import java.time.LocalDate;

public record CarRequestUpdateDTO(
        String model,

        BrandEnum brandEnum,

        String color,

        LocalDate fabricationYear
) {
}
