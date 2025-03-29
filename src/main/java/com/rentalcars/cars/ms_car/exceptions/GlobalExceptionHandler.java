package com.rentalcars.cars.ms_car.exceptions;

import com.rentalcars.cars.ms_car.exceptions.build.Problem;
import com.rentalcars.cars.ms_car.exceptions.customException.CarNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        Problem errorResponse = new Problem(ex.getMessage(), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Problem errorResponse = new Problem(ex.getMessage(), HttpStatus.BAD_REQUEST);

        return ResponseEntity.status(errorResponse.getCode()).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        var problem = new Problem(ex);
        return ResponseEntity.status(problem.getCode()).body(problem);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        var problem = new Problem(ex);
        return ResponseEntity.status(problem.getCode()).body(problem);
    }

}
