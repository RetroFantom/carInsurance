package ru.micro.carInsurance.auditservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.micro.carInsurance.auditservice.AuditServiceApplication;

import java.io.FileWriter;
import java.io.IOException;

@Controller
public class AuditController {

    @PostMapping ("/audit")
    public void AddAuditLog(@RequestBody String str) throws IOException {
        java.util.Date date = new java.util.Date();
        FileWriter FileWriter = new FileWriter(AuditServiceApplication.fileAudit, true);
        FileWriter.write(date + "\t" + str + "\n");
        FileWriter.close();
    }
}