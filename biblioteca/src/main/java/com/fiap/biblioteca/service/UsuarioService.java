package com.fiap.biblioteca.service;

import com.fiap.biblioteca.model.Livro;
import com.fiap.biblioteca.model.Usuario;
import com.fiap.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository){this.repository = repository;}

    public List<Usuario> listarTodos(){return repository.findAll();}

    public Usuario salvar(Usuario usuario){return repository.save(usuario);}

    public Usuario buscarPorId(Long id) {return repository.findById(id).orElse(null);}
}
