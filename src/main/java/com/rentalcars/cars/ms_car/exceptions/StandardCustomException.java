package com.rentalcars.cars.ms_car.exceptions;

import com.rentalcars.cars.ms_car.exceptions.build.ErrorCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class StandardCustomException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    private final String messageErrorCode;

    private final HttpStatus httpStatus;

    public StandardCustomException(ErrorCodeEnum codeEnum, HttpStatus httpStatus) {
        this.messageErrorCode = codeEnum.getMessage();
        this.httpStatus = httpStatus;
    }
}
