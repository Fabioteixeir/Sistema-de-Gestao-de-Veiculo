package com.estoqueveiculos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "veiculos")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = false)
    private Modelo modelo;
    
    @Column(nullable = false)
    private Integer ano;
    
    @Column(nullable = false)
    private String cor;
    
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
    
    @Column(name = "quilometragem")
    private Integer quilometragem;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVeiculo status;
    
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;
    
    // Construtores
    public Veiculo() {
        this.dataCadastro = LocalDateTime.now();
        this.status = StatusVeiculo.DISPONIVEL;
    }
    
    public Veiculo(Modelo modelo, Integer ano, String cor, BigDecimal preco, 
                  Integer quilometragem, StatusVeiculo status) {
        this();
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.quilometragem = quilometragem;
        this.status = status;
    }
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Modelo getModelo() { return modelo; }
    public void setModelo(Modelo modelo) { this.modelo = modelo; }
    
    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }
    
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    
    public Integer getQuilometragem() { return quilometragem; }
    public void setQuilometragem(Integer quilometragem) { this.quilometragem = quilometragem; }
    
    public StatusVeiculo getStatus() { return status; }
    public void setStatus(StatusVeiculo status) { this.status = status; }
    
    public LocalDateTime getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }
}

enum StatusVeiculo {
    DISPONIVEL,
    VENDIDO,
    MANUTENCAO,
    RESERVADO
}