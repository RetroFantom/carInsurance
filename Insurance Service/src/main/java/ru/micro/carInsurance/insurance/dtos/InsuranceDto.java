package ru.micro.carInsurance.insurance.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InsuranceDto {
    private Long id;
    private Long userId;
    private String VIN;
    private String carPlate;
    private String FIO;
    private Long driverLicence;
    private String STS;
}
