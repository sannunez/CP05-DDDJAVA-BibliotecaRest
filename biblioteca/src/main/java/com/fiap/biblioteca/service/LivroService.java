package com.fiap.biblioteca.service;

import com.fiap.biblioteca.model.Livro;
import com.fiap.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository repository;

    public LivroService(LivroRepository repository){this.repository = repository;}

    public List<Livro> listarTodos(){return  repository.findAll();}

    public Livro salvar(Livro livro){return repository.save(livro);}

    public Livro buscarPorId(Long id) {return repository.findById(id).orElse(null);}

    public void deletar(Long id){repository.deleteById(id);}


}
