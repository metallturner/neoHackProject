package com.example.neohackproject.controllers;

import com.example.neohackproject.model.Credential;
import com.example.neohackproject.model.Employee;
import com.example.neohackproject.service.EmployeeService;
import com.example.neohackproject.utils.Authorization;
import com.example.neohackproject.utils.AuthorizationEx;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorization")
public class CredentialController {
    private final EmployeeService employeeService;

    public CredentialController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/login")
    ResponseEntity<Employee> chekCredentialsEmployee(@RequestBody Credential credential){
        if(employeeService.chekCredentialsEmployee(credential) != null){
            Authorization.isAuthorization = true;
            return new ResponseEntity<>(employeeService.chekCredentialsEmployee(credential), HttpStatus.OK);
        }
        else throw new AuthorizationEx();
    }
    @GetMapping("/logout")
    public ResponseEntity<String> updateIsAuthorizationLogOut() {
        Authorization.isAuthorization = false;
        return new ResponseEntity<>("User logged out", HttpStatus.OK);
    }
}
