package com.example.todemoto.perfil_motociclista.entity;

public class CardMotociclista {
    private String imagem;
    private String nome;
    private String id;
    private String nota;
    private String distancia;

    public CardMotociclista(String imagem, String nome, String id, String nota, String distancia) {
        this.imagem = imagem;
        this.nome = nome;
        this.id = id;
        this.nota = nota;
        this.distancia = distancia;
    }

    public CardMotociclista() {
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "CardMotociclista{" +
                "imagem='" + imagem + '\'' +
                ", nome='" + nome + '\'' +
                ", id='" + id + '\'' +
                ", nota=" + nota +
                ", distancia=" + distancia +
                '}';
    }
}
