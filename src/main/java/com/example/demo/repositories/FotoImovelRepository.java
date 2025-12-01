package com.example.demo.repositories;

import com.example.demo.models.FotoImovelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FotoImovelRepository extends JpaRepository<FotoImovelModel, Integer> {

    // Lista todas as fotos de um imóvel específico
    List<FotoImovelModel> findByImovelId(Long imovelId);
}
