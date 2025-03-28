package com.rentalcars.cars.ms_car.exceptions.build;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum {
    NOT_FOUND("Data not found"),

    CAR_NOT_FOUND("Car not found"),

    BAD_REQUEST("Invalid data"),

    SYSTEM_ERROR("Unavailable server");

    private final String message;

}
