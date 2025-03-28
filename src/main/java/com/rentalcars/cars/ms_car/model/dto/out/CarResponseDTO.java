package com.rentalcars.cars.ms_car.model.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rentalcars.cars.ms_car.enums.BrandEnum;

import java.time.LocalDate;

public record CarResponseDTO (
    String model,
    BrandEnum brandEnum,
    String color,
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate fabricationYear
){
}
