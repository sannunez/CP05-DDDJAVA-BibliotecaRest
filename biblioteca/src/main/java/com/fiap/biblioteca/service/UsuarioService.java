package com.fiap.biblioteca.service;

import com.fiap.biblioteca.model.Usuario;
import com.fiap.biblioteca.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){this.repository = repository;}

    public List<Usuario> listarTodos(UsuarioRepository repository){return repository.findAll();}

    public Usuario salvar (Usuario usuario){return repository.save(usuario);}

}
