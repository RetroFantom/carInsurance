package ru.micro.carInsurance.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "sts")
    private String sts;

    @Column(name = "VIN")
    private String VIN;

    @Column(name = "driverLicence")
    private String driverLicence;

    public Insurance(Long id, Long userId, String brand, String vehicle, String sts, String VIN, String driverLicence) {
        this.id = id;
        this.brand = brand;
        this.vehicle = vehicle;
        this.sts = sts;
        this.VIN = VIN;
        this.driverLicence = driverLicence;
    }

    public Insurance(Insurance ins) {
        this.id = ins.id;
        this.brand = ins.brand;
        this.vehicle = ins.vehicle;
        this.sts = ins.sts;
        this.VIN = ins.VIN;
        this.driverLicence = ins.driverLicence;
    }
}
