package com.bn.ex5.services;

import com.bn.ex5.models.CategoriaModel;
import com.bn.ex5.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public CategoriaModel criarCategoria(CategoriaModel categoria) {
        return repository.save(categoria);
    }

    public List<CategoriaModel> findAll() {
        return repository.findAll();
    }

    public CategoriaModel buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletarCategoria(Long id) {
        repository.deleteById(id);
    }
}