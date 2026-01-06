package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.CorretorModel;

public interface CorretorRepository extends JpaRepository<CorretorModel, Integer> {
    CorretorModel findByEmail(String email);
}
