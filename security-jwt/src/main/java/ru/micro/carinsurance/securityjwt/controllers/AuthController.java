package ru.micro.carinsurance.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import ru.micro.carinsurance.securityjwt.dtos.JwtRequest;
import ru.micro.carinsurance.securityjwt.dtos.JwtResponse;
import ru.micro.carinsurance.securityjwt.exceptions.AppError;
import ru.micro.carinsurance.securityjwt.services.UserService;
import ru.micro.carinsurance.securityjwt.utils.JwtTokenUtils;
@RestController
@RequiredArgsConstructor
public class AuthController {
private final UserService userService;
private final JwtTokenUtils jwtTokenUtils;
private final AuthenticationManager authenticationManager;
@PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest){
    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
    } catch (BadCredentialsException e) {
        return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
    }
    UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
    String token = jwtTokenUtils.generateToken(userDetails);
    return ResponseEntity.ok(new JwtResponse(token));
}
}
