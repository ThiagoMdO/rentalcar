package com.rentalcars.cars.ms_car.exceptions.customException;

import com.rentalcars.cars.ms_car.exceptions.StandardCustomException;
import com.rentalcars.cars.ms_car.exceptions.build.ErrorCodeEnum;
import org.springframework.http.HttpStatus;

public class CarNotFoundException extends StandardCustomException {
    public CarNotFoundException() {
        super(ErrorCodeEnum.CAR_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
