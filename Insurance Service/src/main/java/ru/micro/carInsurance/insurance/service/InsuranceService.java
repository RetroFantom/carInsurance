package ru.micro.carInsurance.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.micro.carInsurance.insurance.entities.Insurance;
import ru.micro.carInsurance.insurance.repositories.InsuranceRepository;
import ru.micro.carInsurance.insurance.dtos.InsuranceDto;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Service
public class InsuranceService {
    private InsuranceRepository insuranceRepository;

    @Autowired
    public void setInsuranceRepository(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public static void audit(String str){
        try {
            URL url = new URL("http://localhost:9092/audit");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String params = "INFO=" + str;
            byte[] postData = params.getBytes(StandardCharsets.UTF_8);

            try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
                wr.write(postData);
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Insurance> findByUserId(Long id) {
        audit("List of insurances sent");
        return insuranceRepository.findByUserId(id);
    }

    public Insurance createNewInsurance(InsuranceDto insuranceDto) {
        Insurance insurance = new Insurance();

        insurance.setUserId(insuranceDto.getUserId());
        insurance.setVIN(insuranceDto.getVIN());
        insurance.setCarPlate(insuranceDto.getCarPlate());
        insurance.setFIO(insuranceDto.getFIO());
        insurance.setDriverLicence(insuranceDto.getDriverLicence());
        insurance.setSTS(insuranceDto.getSTS());
        audit("Insurance added");
        return insuranceRepository.save(insurance);
    }
}
