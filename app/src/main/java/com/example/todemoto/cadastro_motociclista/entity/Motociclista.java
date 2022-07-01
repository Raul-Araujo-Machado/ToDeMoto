package com.example.todemoto.cadastro_motociclista.entity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class Motociclista implements Serializable {

    private String nome;
    private String email;
    private String senha;
    private String descricao;
    private String telefone;
    private String id;

    public Motociclista() {
    }

    public Motociclista(String nome, String email, String senha, String descricao, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.descricao = descricao;
        this.telefone = telefone;
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

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    public String getTelefone() {return telefone;}

    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void salvarMotociclista(){
        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        referencia.child("Usuarios/Motociclista").child(getId()).setValue(this);
    }
}
