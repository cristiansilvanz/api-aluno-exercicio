package com.example.demo.model;

public class Aluno {
    private Long id;
    private String nome;
    private String email;
    private Double nota;


    public Aluno() {}

    public Aluno(Long id, String nome, String email, Double nota) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nota = nota;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double getNota() { return nota; }
    public void setNota(Double nota) { this.nota = nota; }
}