    package com.rentalcars.cars.ms_car.repositories;

    import com.rentalcars.cars.ms_car.model.entities.Car;
    import org.springframework.data.jpa.repository.JpaRepository;

    import java.util.UUID;

    public interface CarRepository extends JpaRepository<Car, UUID> {
    }
