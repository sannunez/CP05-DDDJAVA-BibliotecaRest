package com.fiap.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;

@Entity
public class Livro {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título não pode estar vazio")
    @Column(nullable = false) // Gera tabela com NOT NULL no SGBD
    private String titulo;

    private String autor;

    @Min(value = 0)
    @Max(value = 2025, message = "Ano máximo permitido é 2025")
    private Integer ano;

    private boolean status;


    // Getters e Setters
    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAno() {return ano;}

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
