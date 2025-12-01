package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.FotoImovelModel;
import com.example.demo.repositories.FotoImovelRepository;

@Service
public class FotoImovelService {
    
    @Autowired
    private FotoImovelRepository repository;

    public List<FotoImovelModel> getAll() {
        return repository.findAll();
    }

    public FotoImovelModel insert(FotoImovelModel objeto) {
        return repository.save(objeto);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    // ==========================================
    // NOVO → usado para deletar + buscar foto
    // ==========================================
    public FotoImovelModel find(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<FotoImovelModel> findByImovelId(Long id) {
        return repository.findByImovelId(id);
    }
}
