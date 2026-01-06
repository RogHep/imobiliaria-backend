package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CorretorModel;
import com.example.demo.services.CorretorService;

@RestController
@RequestMapping("/corretores")
@CrossOrigin(origins = "http://localhost:5173")
public class CorretorController {

    @Autowired
    private CorretorService service;

    // Criar corretor
    @PostMapping
    public CorretorModel criar(@RequestBody CorretorModel c) {
        c.setAdmin(false); // garante que não cria admin
        return service.criar(c);
    }

    // LOGIN DO CORRETOR
    @PostMapping("/login")
    public CorretorModel login(@RequestBody CorretorModel login) {

        CorretorModel c = service.buscarPorEmail(login.getEmail());

        if (c == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        if (!c.getSenha().equals(login.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        return c; // devolve JSON do corretor
    }
}
