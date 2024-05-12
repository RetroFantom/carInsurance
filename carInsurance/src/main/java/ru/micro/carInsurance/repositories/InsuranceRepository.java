package ru.micro.carInsurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.micro.carInsurance.entities.Insurance;

import java.util.Optional;
@Repository
public interface InsuranceRepository  extends CrudRepository<Insurance, Long> {
    Insurance findByUserId(String name);

}
