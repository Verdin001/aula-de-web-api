package com.example.demo.reposytory;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

// Correção fundamental: <Produto, Long>
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}