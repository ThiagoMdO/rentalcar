package com.rentalcars.cars.ms_car.exceptions;

import com.rentalcars.cars.ms_car.exceptions.build.Problem;
import com.rentalcars.cars.ms_car.exceptions.customException.CarNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<Object> handlerCarNotFoundException() {
        StandardCustomException carNotFoundException = new CarNotFoundException();
        var problem = new Problem(carNotFoundException.getMessageErrorCode(), carNotFoundException.getHttpStatus());
        return ResponseEntity.status(carNotFoundException.getHttpStatus()).body(problem);
    }

}
