package com.fiap.biblioteca.controller;

import com.fiap.biblioteca.model.Livro;
import com.fiap.biblioteca.service.EmprestimoService;
import com.fiap.biblioteca.service.LivroService;

import jakarta.validation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private final LivroService service;
    private EmprestimoService emprestimoService;

    public LivroController(LivroService service, EmprestimoService emprestimoService){
        this.service = service;
        this.emprestimoService = emprestimoService;
    }



    @GetMapping
    public String listar(@RequestParam(required = false) Boolean disponiveis, Model model){
        List<Livro> livros;

        if (Boolean.TRUE.equals(disponiveis)){
            livros = service.listarDisponiveis();
        } else {
            livros = service.listarTodos();
        }

        model.addAttribute("listaLivros", livros);
        model.addAttribute("listaEmprestimos", emprestimoService.listarTodos());
        return "/livros";
    }


    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("livro", new Livro());
        return "form-cad-livro"
        ;}

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute Livro livro, BindingResult resultado){
        if (resultado.hasErrors()){
            return "form-cad-livro";
        }
        service.salvar(livro);
        return "redirect:/livros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        model.addAttribute("livro", service.buscarPorId(id));
        return "form-cad-livro";
    }


    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        service.deletar(id);
        return "redirect:/livros";
    }
}


