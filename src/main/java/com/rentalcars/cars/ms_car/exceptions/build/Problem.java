package com.rentalcars.cars.ms_car.exceptions.build;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Problem {

    private final int code;

    private final String status;

    private final String message;

    public Problem(String message, HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

}
