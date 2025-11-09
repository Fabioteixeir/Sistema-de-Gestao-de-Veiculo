package com.estoqueveiculos.controller;

import com.estoqueveiculos.model.Marca;
import com.estoqueveiculos.model.Modelo;
import com.estoqueveiculos.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;
    
    @GetMapping
    public List<Marca> listarTodas() {
        return marcaService.listarTodas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Marca> buscarPorId(@PathVariable Long id) {
        Optional<Marca> marca = marcaService.buscarPorId(id);
        return marca.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Marca cadastrar(@RequestBody Marca marca) {
        return marcaService.salvar(marca);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Marca> atualizar(@PathVariable Long id, @RequestBody Marca marca) {
        Optional<Marca> existente = marcaService.buscarPorId(id);
        if (existente.isPresent()) {
            marca.setId(id);
            return ResponseEntity.ok(marcaService.salvar(marca));
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Marca> marca = marcaService.buscarPorId(id);
        if (marca.isPresent()) {
            marcaService.deletar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/{id}/modelos")
    public ResponseEntity<Marca> adicionarModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        Optional<Marca> marca = marcaService.adicionarModelo(id, modelo);
        return marca.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
}