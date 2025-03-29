    package com.rentalcars.cars.ms_car.repositories;

    import com.rentalcars.cars.ms_car.enums.BrandEnum;
    import com.rentalcars.cars.ms_car.model.entities.Car;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;

    import java.util.List;
    import java.util.UUID;

    public interface CarRepository extends JpaRepository<Car, UUID> {

        @Query("SELECT c " +
                "FROM Car c " +
                "WHERE " +
                    "(:model IS NULL OR LOWER(c.model) LIKE LOWER(CONCAT('%', :model, '%'))) " +
                    "AND (:color IS NULL OR LOWER(c.color) = LOWER(:color)) " +
                    "AND (:brandEnum IS NULL OR c.brandEnum = :brandEnum)" +
                    "AND (:startYear IS NULL OR FUNCTION('YEAR', c.fabricationYear) >= :startYear)" +
                    "AND (:endYear IS NULL OR FUNCTION('YEAR', c.fabricationYear) <= :endYear)"
        )
        List<Car> searchCars(@Param("model") String model,
                             @Param("color") String color,
                             @Param("brandEnum") BrandEnum brandEnum,
                             @Param("startYear") Integer startYear,
                             @Param("endYear") Integer endYear);
    }
