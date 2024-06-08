package ru.micro.carInsurance.insurance.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @Column(name = "userId")
    private Long userId;

    @Column(name = "VIN")
    private String VIN;

    @Column(name = "car_Plate")
    private String carPlate;

    @Column(name = "FIO")
    private String FIO;

    @Column(name = "driver_licence")
    private Long driverLicence;

    @Column(name = "STS")
    private String STS;


}
