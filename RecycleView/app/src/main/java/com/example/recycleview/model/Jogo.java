package com.example.recycleview.model;

public class Jogo {
    private String nome;
    private String plataforma;

    public Jogo(String nome, String plataforma) {
        this.nome = nome;
        this.plataforma = plataforma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
