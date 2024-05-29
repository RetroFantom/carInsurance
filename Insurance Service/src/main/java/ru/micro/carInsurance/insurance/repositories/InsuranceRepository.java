package ru.micro.carInsurance.insurance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.micro.carInsurance.insurance.entities.Insurance;

import java.util.List;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
    List<Insurance> findByUserId(Long UserId);
}
