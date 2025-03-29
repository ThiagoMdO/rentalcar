package com.rentalcars.cars.ms_car.model.entities;

import com.rentalcars.cars.ms_car.enums.BrandEnum;
import com.rentalcars.cars.ms_car.model.dto.in.CarRequestDTO;
import com.rentalcars.cars.ms_car.model.dto.in.CarRequestUpdateDTO;
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

    public static Car createEntityByRequest(CarRequestDTO requestDTO) {
        return Car.builder()
                .model(requestDTO.model())
                .brandEnum(requestDTO.brandEnum())
                .color(requestDTO.color())
                .fabricationYear(requestDTO.fabricationYear())
                .build();
    }

    public static Car updateEntityByRequestUpdate(Car carInDB, CarRequestUpdateDTO requestUpdateDTO) {
        if (requestUpdateDTO.model() != null
            && !requestUpdateDTO.model().isEmpty())
                carInDB.setModel(requestUpdateDTO.model());

        if (requestUpdateDTO.brandEnum() != null
            && !requestUpdateDTO.brandEnum().toString().isEmpty())
                    carInDB.setBrandEnum(requestUpdateDTO.brandEnum());

        if (requestUpdateDTO.color() != null
            &&  !requestUpdateDTO.color().isEmpty())
                    carInDB.setColor(requestUpdateDTO.color());

        if (requestUpdateDTO.fabricationYear() != null
            &&  !requestUpdateDTO.fabricationYear().toString().isEmpty())
                    carInDB.setFabricationYear(requestUpdateDTO.fabricationYear());

        return carInDB;
    }

}
