package com.estoqueveiculos.service;

import com.estoqueveiculos.model.Veiculo;
import com.estoqueveiculos.model.StatusVeiculo;
import com.estoqueveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    
    @Autowired
    private VeiculoRepository veiculoRepository;
    
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }
    
    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }
    
    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
    
    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
    
    // Métodos de filtro
    public List<Veiculo> filtrarPorMarca(String marca) {
        return veiculoRepository.findByModeloMarcaNome(marca);
    }
    
    public List<Veiculo> filtrarPorModelo(String modelo) {
        return veiculoRepository.findByModeloNome(modelo);
    }
    
    public List<Veiculo> filtrarPorAno(Integer ano) {
        return veiculoRepository.findByAno(ano);
    }
    
    public List<Veiculo> filtrarPorPreco(BigDecimal precoMin, BigDecimal precoMax) {
        return veiculoRepository.findByPrecoBetween(precoMin, precoMax);
    }
    
    public List<Veiculo> filtrarPorStatus(StatusVeiculo status) {
        return veiculoRepository.findByStatus(status);
    }
    
    public List<Veiculo> filtrarVeiculos(String marca, String modelo, Integer ano, 
                                        BigDecimal precoMin, BigDecimal precoMax, 
                                        StatusVeiculo status) {
        return veiculoRepository.findByFiltros(marca, modelo, ano, precoMin, precoMax, status);
    }
    
    // Atualizações específicas
    public Optional<Veiculo> atualizarPreco(Long id, BigDecimal novoPreco) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);
        if (veiculoOpt.isPresent()) {
            Veiculo veiculo = veiculoOpt.get();
            veiculo.setPreco(novoPreco);
            return Optional.of(veiculoRepository.save(veiculo));
        }
        return Optional.empty();
    }
    
    public Optional<Veiculo> atualizarQuilometragem(Long id, Integer novaQuilometragem) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);
        if (veiculoOpt.isPresent()) {
            Veiculo veiculo = veiculoOpt.get();
            veiculo.setQuilometragem(novaQuilometragem);
            return Optional.of(veiculoRepository.save(veiculo));
        }
        return Optional.empty();
    }
    
    public Optional<Veiculo> atualizarStatus(Long id, StatusVeiculo novoStatus) {
        Optional<Veiculo> veiculoOpt = veiculoRepository.findById(id);
        if (veiculoOpt.isPresent()) {
            Veiculo veiculo = veiculoOpt.get();
            veiculo.setStatus(novoStatus);
            return Optional.of(veiculoRepository.save(veiculo));
        }
        return Optional.empty();
    }
}