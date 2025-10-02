package com.fiap.biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataRetirada;
    private LocalDate dataEntrega;

//    private Livro livro;
//    private Usuario usuario;
}
