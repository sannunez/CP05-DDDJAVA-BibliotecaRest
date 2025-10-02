package com.fiap.biblioteca.model;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String nome;
   private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}