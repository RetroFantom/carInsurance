package ru.micro.carInsurance.insurance.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.micro.carInsurance.insurance.entities.Insurance;
import ru.micro.carInsurance.insurance.dtos.InsuranceDto;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final InsuranceService insuranceService;

    public void createNewInsurance(@RequestBody InsuranceDto insuranceDto) {
        Insurance insurance = insuranceService.createNewInsurance(insuranceDto);
    }
}
