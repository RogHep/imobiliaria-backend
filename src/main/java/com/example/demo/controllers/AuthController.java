package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CorretorModel;
import com.example.demo.services.AuthService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService service;

    public static class LoginDTO {
        public String email;
        public String senha;
    }

    @PostMapping("/login")
    public CorretorModel login(@RequestBody LoginDTO login) {
        return service.login(login.email, login.senha);
    }
}
