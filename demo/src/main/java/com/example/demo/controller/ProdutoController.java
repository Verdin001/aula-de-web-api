package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.reposytory.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // 1. POST: Salvar (Sem mexer no ID, o banco cria)
    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        return produtoRepository.save(produto);
    }

    // 2. GET: Listar todos
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // 3. GET por ID (Recebe Long)
    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable("id") Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        return produtoRepository.findById(id);
    }

    // 4. PUT: Atualizar (Recebe Long)
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produto) {
        produto.setId(id); // Garante que atualiza o ID certo
        return produtoRepository.save(produto);
    }

    // 5. DELETE: Apagar (Recebe Long)
    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        produtoRepository.deleteById(id);
    }
}