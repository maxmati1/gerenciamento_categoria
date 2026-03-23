package com.bn.ex5.controllers;

import com.bn.ex5.models.CategoriaModel;
import com.bn.ex5.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaModel>> findAll() {
        List<CategoriaModel> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoria) {
        CategoriaModel nova = service.criarCategoria(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nova.getId())
                .toUri();
        return ResponseEntity.created(uri).body(nova);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModel> buscarPorId(@PathVariable Long id) {
        CategoriaModel categoria = service.buscarPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        service.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}