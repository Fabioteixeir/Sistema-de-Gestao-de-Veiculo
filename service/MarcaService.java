package com.estoqueveiculos.service;

import com.estoqueveiculos.model.Marca;
import com.estoqueveiculos.model.Modelo;
import com.estoqueveiculos.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    public List<Marca> listarTodas() {
        return marcaRepository.findAll();
    }
    
    public Optional<Marca> buscarPorId(Long id) {
        return marcaRepository.findById(id);
    }
    
    public Optional<Marca> buscarPorNome(String nome) {
        return marcaRepository.findByNome(nome);
    }
    
    public Marca salvar(Marca marca) {
        return marcaRepository.save(marca);
    }
    
    public void deletar(Long id) {
        marcaRepository.deleteById(id);
    }
    
    public boolean existePorNome(String nome) {
        return marcaRepository.existsByNome(nome);
    }
    
    public Optional<Marca> adicionarModelo(Long marcaId, Modelo modelo) {
        Optional<Marca> marcaOpt = marcaRepository.findById(marcaId);
        if (marcaOpt.isPresent()) {
            Marca marca = marcaOpt.get();
            marca.addModelo(modelo);
            return Optional.of(marcaRepository.save(marca));
        }
        return Optional.empty();
    }
}