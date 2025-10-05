package com.fiap.biblioteca.service;

import com.fiap.biblioteca.model.Emprestimo;
import com.fiap.biblioteca.model.Livro;
import com.fiap.biblioteca.repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {
    private final EmprestimoRepository repository;
    private final LivroService livroService;
    private final UsuarioService usuarioService;

    public EmprestimoService(EmprestimoRepository repository, LivroService livroService, UsuarioService usuarioService) {
        this.repository = repository;
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    public List<Emprestimo> listarTodos(){return repository.findAll();}

    public void salvar(Emprestimo emprestimo) {
        // Define datas
        emprestimo.setDataRetirada(LocalDate.now());
        emprestimo.setDataEntrega(LocalDate.now().plusWeeks(2));

        // Busca livro e usuário do banco
        Livro livro = livroService.buscarPorId(emprestimo.getLivro().getId());
        if (livro == null) throw new IllegalArgumentException("Livro não encontrado");

        var usuario = usuarioService.buscarPorId(emprestimo.getUsuario().getId());
        if (usuario == null) throw new IllegalArgumentException("Usuário não encontrado");

        // Atualiza status do livro
        livro.setStatus(true);
        livroService.salvar(livro);

        // Define livro e usuário no empréstimo
        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);

        // Salva empréstimo
        repository.save(emprestimo);
    }

    public void deletar(Long id){repository.deleteById(id);}

    public Emprestimo buscarPorLivro(Long livroId) {
        return repository.findByLivroId(livroId).orElse(null);
    }

}
