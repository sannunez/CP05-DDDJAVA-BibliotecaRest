package com.fiap.biblioteca.repository;

import com.fiap.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    Optional<Emprestimo> findByLivroId(Long livroId);
}