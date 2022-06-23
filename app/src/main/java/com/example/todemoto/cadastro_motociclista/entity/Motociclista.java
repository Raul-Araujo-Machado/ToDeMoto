package com.example.todemoto.cadastro_motociclista.entity;

import java.io.Serializable;

public class Motociclista implements Serializable {

    private String nome;
    private String email;
    private String descricao;
    private String telefone;
    private String senha;
    private String id;

    public Motociclista() {
    }

    public Motociclista(String nome, String email, String descricao, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.telefone = telefone;
        this.senha = senha;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Motociclista{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
