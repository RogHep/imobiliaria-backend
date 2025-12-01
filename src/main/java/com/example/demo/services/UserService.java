package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dtos.UserDTO;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserModel> getAll() {
        List<UserModel> lista = repository.findAll();
        return lista;
    }

    public UserModel find(Integer id) {
        Optional<UserModel> usuario = repository.findById(id);
        return usuario.orElse(null);
    }

    @Transactional
    public UserModel insert(UserDTO dto) {
        UserModel model = new UserModel();
        model.setEmail(dto.getEmail());
        model.setNome(dto.getNome());
        model.setSenha(dto.getSenha());
        model.setTipo(dto.getTipo());

        return repository.save(model);
    }

     public UserModel update(UserModel user) {
       try {
             if(find(user.getId()) != null) {
                 return repository.save(user);
          }
          return null;
       }
       catch (Exception e) {
        return null;  
       }
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
