package com.example.demo.controller;


import com.example.demo.model.Produto;
import com.example.demo.reposytory.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {


    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) {
        System.out.println("Dados do produto: " + produto);

    var id = UUID.randomUUID().toString();
    produto.setId(id);
    produtoRepository.save(produto);
        return produto;
    }

}
