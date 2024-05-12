package ru.micro.carinsurance.securityjwt.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.micro.carinsurance.securityjwt.dtos.JwtRequest;
import ru.micro.carinsurance.securityjwt.dtos.JwtResponse;
import ru.micro.carinsurance.securityjwt.dtos.RegistrationUserDto;
import ru.micro.carinsurance.securityjwt.services.AuthService;
@Controller
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

 //   @PostMapping("/auth")
 //   public ResponseEntity<?> createAuthToken(JwtRequest authRequest) {
  //       authService.createAuthToken(authRequest);
   //      return "index";
    //}
    @RequestMapping("/auth")
    public String aut(JwtRequest authRequest, Model model){
        //String str= authService.createAuthToken(authRequest).toString();
        JwtResponse jwtResponse = new JwtResponse(authService.createAuthToken(authRequest));
        model.addAttribute("token", jwtResponse);
        return "success-login";
    }
@RequestMapping("/")
public String main(){ return  "index";}
    @RequestMapping("/registration")
    public String registration(){ return "registration";}

    @RequestMapping("/login")
    public String login(){ return "login";}
    @RequestMapping("/addInsurance")
    public String addInsurance(){ return "addInsurance";}
    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}