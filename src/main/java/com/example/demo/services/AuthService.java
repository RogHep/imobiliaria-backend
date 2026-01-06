package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CorretorModel;
import com.example.demo.repositories.CorretorRepository;

@Service
public class AuthService {

    @Autowired
    private CorretorRepository repo;

    public CorretorModel login(String email, String senha) {

        CorretorModel c = repo.findByEmail(email);

        if (c == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        if (!c.getSenha().equals(senha)) {
            throw new RuntimeException("Senha incorreta");
        }

        return c;
    }
}
