package com.estoqueveiculos.controller;

import com.estoqueveiculos.model.Veiculo;
import com.estoqueveiculos.model.StatusVeiculo;
import com.estoqueveiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {
    
    @Autowired
    private VeiculoService veiculoService;
    
    // GET - Listar todos os veículos
    @GetMapping
    public List<Veiculo> listarTodos() {
        return veiculoService.listarTodos();
    }
    
    // GET - Buscar veículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarPorId(id);
        return veiculo.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    // POST - Cadastrar novo veículo
    @PostMapping
    public Veiculo cadastrar(@RequestBody Veiculo veiculo) {
        return veiculoService.salvar(veiculo);
    }
    
    // PUT - Atualizar veículo completo
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        Optional<Veiculo> existente = veiculoService.buscarPorId(id);
        if (existente.isPresent()) {
            veiculo.setId(id);
            return ResponseEntity.ok(veiculoService.salvar(veiculo));
        }
        return ResponseEntity.notFound().build();
    }
    
    // DELETE - Remover veículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Veiculo> veiculo = veiculoService.buscarPorId(id);
        if (veiculo.isPresent()) {
            veiculoService.deletar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    // GET - Filtros individuais
    @GetMapping("/filtro/marca/{marca}")
    public List<Veiculo> filtrarPorMarca(@PathVariable String marca) {
        return veiculoService.filtrarPorMarca(marca);
    }
    
    @GetMapping("/filtro/modelo/{modelo}")
    public List<Veiculo> filtrarPorModelo(@PathVariable String modelo) {
        return veiculoService.filtrarPorModelo(modelo);
    }
    
    @GetMapping("/filtro/ano/{ano}")
    public List<Veiculo> filtrarPorAno(@PathVariable Integer ano) {
        return veiculoService.filtrarPorAno(ano);
    }
    
    @GetMapping("/filtro/preco")
    public List<Veiculo> filtrarPorPreco(@RequestParam BigDecimal min, @RequestParam BigDecimal max) {
        return veiculoService.filtrarPorPreco(min, max);
    }
    
    @GetMapping("/filtro/status/{status}")
    public List<Veiculo> filtrarPorStatus(@PathVariable StatusVeiculo status) {
        return veiculoService.filtrarPorStatus(status);
    }
    
    // GET - Filtro combinado
    @GetMapping("/filtro")
    public List<Veiculo> filtrarVeiculos(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) Integer ano,
            @RequestParam(required = false) BigDecimal precoMin,
            @RequestParam(required = false) BigDecimal precoMax,
            @RequestParam(required = false) StatusVeiculo status) {
        
        return veiculoService.filtrarVeiculos(marca, modelo, ano, precoMin, precoMax, status);
    }
    
    // PATCH - Atualizações específicas
    @PatchMapping("/{id}/preco")
    public ResponseEntity<Veiculo> atualizarPreco(@PathVariable Long id, @RequestParam BigDecimal preco) {
        Optional<Veiculo> veiculo = veiculoService.atualizarPreco(id, preco);
        return veiculo.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @PatchMapping("/{id}/quilometragem")
    public ResponseEntity<Veiculo> atualizarQuilometragem(@PathVariable Long id, @RequestParam Integer quilometragem) {
        Optional<Veiculo> veiculo = veiculoService.atualizarQuilometragem(id, quilometragem);
        return veiculo.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @PatchMapping("/{id}/status")
    public ResponseEntity<Veiculo> atualizarStatus(@PathVariable Long id, @RequestParam StatusVeiculo status) {
        Optional<Veiculo> veiculo = veiculoService.atualizarStatus(id, status);
        return veiculo.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
}