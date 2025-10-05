package com.fiap.biblioteca.controller;

import com.fiap.biblioteca.model.Usuario;
import com.fiap.biblioteca.service.UsuarioService;

import jakarta.validation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service){this.service = service;}

    @GetMapping
    public String listar(Model model){
        model.addAttribute("listaUsuarios", service.listarTodos());
        return "usuarios";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "form-cad-usuario";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Usuario usuario, BindingResult resultado){
        if (resultado.hasErrors()) {
            return "form-cad-usuario";

        }
        service.salvar(usuario);
        return "redirect:/usuarios";
    }




}
