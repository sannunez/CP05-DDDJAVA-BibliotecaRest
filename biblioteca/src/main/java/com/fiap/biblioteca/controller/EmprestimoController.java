package com.fiap.biblioteca.controller;

import com.fiap.biblioteca.model.Emprestimo;
import com.fiap.biblioteca.model.Livro;
import com.fiap.biblioteca.service.EmprestimoService;
import com.fiap.biblioteca.service.LivroService;
import com.fiap.biblioteca.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class EmprestimoController {
    private final EmprestimoService service;
    private final LivroService livroService;
    private final UsuarioService usuarioService;

    public EmprestimoController(EmprestimoService service, LivroService livroService, UsuarioService usuarioService) {
        this.service = service;
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/emprestar/{id}")
    public String cadastrar(@PathVariable("id") Long id, Model model){
        Livro livro = livroService.buscarPorId(id);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);

        model.addAttribute("livro", livro);
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("emprestimo", emprestimo);

        return "form-cad-emprestimo";
    }

    @PostMapping("/emprestar")
    public String salvar(@Valid @ModelAttribute Emprestimo emprestimo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("livro", livroService.buscarPorId(emprestimo.getLivro().getId()));
            model.addAttribute("usuarios", usuarioService.listarTodos());
            return "form-cad-emprestimo";
        }

        Livro livro = livroService.buscarPorId(emprestimo.getLivro().getId());
        emprestimo.setLivro(livro);

        var usuario = usuarioService.buscarPorId(emprestimo.getUsuario().getId());
        emprestimo.setUsuario(usuario);

        service.salvar(emprestimo);

        return "redirect:/livros";
    }


    @GetMapping("/devolver/{id}")
    public String devolver(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);
        if (livro != null) {
            livro.setStatus(false);
            livroService.salvar(livro);

            Emprestimo emprestimo = service.buscarPorLivro(id);
            if (emprestimo != null) {
                service.deletar(emprestimo.getId());
            }
        }

        return "redirect:/livros";
    }
}
