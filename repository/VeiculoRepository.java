package com.estoqueveiculos.repository;

import com.estoqueveiculos.model.Veiculo;
import com.estoqueveiculos.model.StatusVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
    // Consultas por filtros
    List<Veiculo> findByModeloMarcaNome(String marca);
    List<Veiculo> findByModeloNome(String modelo);
    List<Veiculo> findByAno(Integer ano);
    List<Veiculo> findByPrecoBetween(BigDecimal precoMin, BigDecimal precoMax);
    List<Veiculo> findByStatus(StatusVeiculo status);
    
    // Consulta combinada
    @Query("SELECT v FROM Veiculo v WHERE " +
           "(:marca IS NULL OR v.modelo.marca.nome = :marca) AND " +
           "(:modelo IS NULL OR v.modelo.nome = :modelo) AND " +
           "(:ano IS NULL OR v.ano = :ano) AND " +
           "(:precoMin IS NULL OR v.preco >= :precoMin) AND " +
           "(:precoMax IS NULL OR v.preco <= :precoMax) AND " +
           "(:status IS NULL OR v.status = :status)")
    List<Veiculo> findByFiltros(@Param("marca") String marca,
                               @Param("modelo") String modelo,
                               @Param("ano") Integer ano,
                               @Param("precoMin") BigDecimal precoMin,
                               @Param("precoMax") BigDecimal precoMax,
                               @Param("status") StatusVeiculo status);
}