package ru.micro.carInsurance.insurance.controllers;

import ru.micro.carInsurance.insurance.entities.Insurance;
import ru.micro.carInsurance.insurance.repositories.InsuranceRepository;
import ru.micro.carInsurance.insurance.service.TransferService;
import ru.micro.carInsurance.insurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.micro.carInsurance.insurance.dtos.InsuranceDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InsuranceController {
    private final TransferService transferService;
    private final InsuranceService insuranceService;
    @Autowired
    private final InsuranceRepository insuranceRepository;

    @RequestMapping("/insurance/add")
    public String showAddForm() {
        return "addInsurance";
    }

    @PostMapping("/insurance/add")
    public String createNewCard(@RequestBody InsuranceDto insuranceDto) {
        transferService.createNewInsurance(insuranceDto);
        return "addInsurance";
    }

    @GetMapping("insurance/all/{id}")
    public String viewCards (@PathVariable Long id, Model model) {
        List <Insurance> list = insuranceService.findByUserId(id);
        model.addAttribute("insurances", list);
        return "insurancesPage";
    }
}