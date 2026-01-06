package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CorretorModel;
import com.example.demo.repositories.CorretorRepository;

@Service
public class CorretorService {

    @Autowired
    private CorretorRepository repo;

    public CorretorModel criar(CorretorModel c) {
        return repo.save(c);
    }

    public CorretorModel buscarPorEmail(String email) {
        return repo.findByEmail(email);
    }
}
