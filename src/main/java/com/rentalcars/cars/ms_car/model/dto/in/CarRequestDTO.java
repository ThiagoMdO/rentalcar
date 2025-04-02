package com.rentalcars.cars.ms_car.model.dto.in;

import com.rentalcars.cars.ms_car.enums.BrandEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CarRequestDTO(
    @NotBlank(message = "The model have to be declared")
    String model,
    @NotNull(message = "The brand have to be selected")
    BrandEnum brandEnum,
    @NotBlank(message = "The color have to be declared")
    String color,
    @NotNull(message = "The fabrication year need to be declared")
    LocalDate fabricationYear
) {
}
