package com.example.demo.Dtos;

import com.example.demo.models.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    public UserDTO(Integer id, String nome, String email, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public UserDTO(UserModel userModel) {
        if (userModel == null) return;
        this.id = userModel.getId();
        this.nome = userModel.getNome();
        this.email = userModel.getEmail();
        this.senha = userModel.getSenha();
        this.tipo = userModel.getTipo();
    }
}
