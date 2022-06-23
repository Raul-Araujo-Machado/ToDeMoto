package com.example.todemoto.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private String email;
    private String id;

    public Cliente() {
    }

    public Cliente(String nome, String email, String id) {
        this.nome = nome;
        this.email = email;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void salvarCliente(){
        DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
        referencia.child("Usuarios/Cliente").child(getId()).setValue(this);
    }
}
