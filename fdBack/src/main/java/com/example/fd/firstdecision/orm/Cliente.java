package com.example.fd.firstdecision.orm;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "first_decision_cadastros_clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty//adicional
    @Size(min = 3, max = 50)//adicional
    private String nome;

    @NotEmpty
    @Email //adicional
    private String email;

    @NotEmpty
    @Size(min = 6, max = 20)
    private String senha;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getConfirmSenha() {
        return true;

        //TO DO Implementar lógica para confirmar a senha
    }
}
