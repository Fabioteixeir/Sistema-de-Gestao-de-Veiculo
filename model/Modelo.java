package com.estoqueveiculos.model;

import javax.persistence.*;

@Entity
@Table(name = "modelos")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "marca_id", nullable = false)
    private Marca marca;
    
    // Construtores
    public Modelo() {}
    
    public Modelo(String nome, Marca marca) {
        this.nome = nome;
        this.marca = marca;
    }
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public Marca getMarca() { return marca; }
    public void setMarca(Marca marca) { this.marca = marca; }
}