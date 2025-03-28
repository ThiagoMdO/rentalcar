package com.rentalcars.cars.ms_car.model.entities;

import com.rentalcars.cars.ms_car.enums.BrandEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String model;

    @Enumerated(EnumType.STRING)
    private BrandEnum brandEnum;

    private String color;

    private LocalDate fabricationYear;

}
