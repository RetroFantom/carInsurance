package ru.micro.carinsurance.securityjwt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.micro.carinsurance.securityjwt.entities.Role;
import ru.micro.carinsurance.securityjwt.repositories.RoleRepository;

import java.util.Optional;
import java.util.SimpleTimeZone;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole(){
        return roleRepository.findByName("ROLE_USER").get();
    }
}
