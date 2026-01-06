package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TipoImovelModel;
import com.example.demo.services.TipoImovelService;

@RestController
@RequestMapping(value = "/tiposimoveis")
@CrossOrigin(origins = "*")
public class TipoImovelController {

    @Autowired
    private TipoImovelService service;

    // LISTAR TODOS
    @GetMapping()
    public ResponseEntity<List<TipoImovelModel>> getAllTipos() {
        List<TipoImovelModel> list = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    // PAGINADO (opcional)
    @GetMapping("/tipos-page")
    public Page<TipoImovelModel> getPosts(Pageable pageable) {
        return service.getAll(pageable);
    }

    // BUSCAR POR ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<TipoImovelModel> find(@PathVariable Integer id) {
        TipoImovelModel model = service.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }

    // CRIAR TIPO DE IMÓVEL (CORRIGIDO)
    @PostMapping
    public ResponseEntity<TipoImovelModel> insert(@RequestBody TipoImovelModel model) {
        model = service.insert(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    // ATUALIZAR
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody TipoImovelModel model, @PathVariable Integer id) {
        model.setId(id);
        model = service.update(model);
        return ResponseEntity.noContent().build();
    }

    // EXCLUIR
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
