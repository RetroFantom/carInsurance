package ru.micro.carinsurance.securityjwt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.micro.carinsurance.securityjwt.entities.User;

import java.util.Optional;

@Repository
public interface DtoRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}