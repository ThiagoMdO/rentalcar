package com.rentalcars.cars.ms_car.exceptions.build;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Problem(MethodArgumentNotValidException ex) {
        this.code = HttpStatus.BAD_REQUEST.value();
        this.status = HttpStatus.BAD_REQUEST.name();
        this.message = Arrays.toString(ex.getDetailMessageArguments());
    }

    public Problem(ConstraintViolationException ex) {
        this.code = HttpStatus.BAD_REQUEST.value();
        this.status = HttpStatus.BAD_REQUEST.name();
        this.message = formatViolationMessage(ex.getConstraintViolations());
    }

    private String formatViolationMessage(Set<ConstraintViolation<?>> violations) {
        return violations.stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.joining(", "));
    }
}
