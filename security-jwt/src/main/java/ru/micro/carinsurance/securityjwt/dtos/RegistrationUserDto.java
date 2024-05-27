package ru.micro.carinsurance.securityjwt.dtos;

import lombok.Data;

@Data
public class RegistrationUserDto {
private String username;
private  String password;
private  String confirmPassword;

}
