package ru.micro.carinsurance.securityjwt.utils;

import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;

public class JwtTokenUtils {
    @Value("{jwt.secret}")
    private String secret;

    @Value("${jwt.lifetime")
    private Duration jwtLifetime;

}
