package com.example.todemoto;


public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String descricao;

    public Usuario(String nome, String email, String senha, String telefone, String descricao) {
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.setTelefone(telefone);
        this.setDescricao(descricao);
    }

    public void deletarPerfil(String email){

    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
