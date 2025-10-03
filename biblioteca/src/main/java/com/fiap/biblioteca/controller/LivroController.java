package com.fiap.biblioteca.controller;

import com.fiap.biblioteca.model.Livro;
import com.fiap.biblioteca.service.LivroService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private final LivroService service;

    public LivroController(LivroService service){this.service = service;}

    @GetMapping
    public String livros() {
        return "livros";
    }


    @GetMapping("/cadastrar")
    public String  novoProdutoForm(Model model){
        model.addAttribute("livros", new Livro());
        return "formCadLivro"
        ;}

}


