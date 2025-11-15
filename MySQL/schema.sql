-- Criar o banco de dados
CREATE DATABASE IF NOT EXISTS gestao_veiculos;
USE gestao_veiculos;

-- Tabela de Marcas
CREATE TABLE IF NOT EXISTS marcas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL UNIQUE,
    descricao VARCHAR(500),
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabela de Modelos
CREATE TABLE IF NOT EXISTS modelos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(500),
    marca_id BIGINT NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (marca_id) REFERENCES marcas(id) ON DELETE CASCADE,
    UNIQUE KEY unique_modelo_marca (nome, marca_id)
);

-- Tabela de Veículos
CREATE TABLE IF NOT EXISTS veiculos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    modelo_id BIGINT NOT NULL,
    ano INT NOT NULL,
    cor VARCHAR(50) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quilometragem INT NOT NULL,
    status ENUM('DISPONIVEL', 'VENDIDO', 'MANUTENCAO', 'RESERVADO') NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (modelo_id) REFERENCES modelos(id) ON DELETE CASCADE
);

-- Índices para melhor performance
CREATE INDEX idx_veiculos_status ON veiculos(status);
CREATE INDEX idx_veiculos_ano ON veiculos(ano);
CREATE INDEX idx_veiculos_preco ON veiculos(preco);
CREATE INDEX idx_veiculos_quilometragem ON veiculos(quilometragem);
CREATE INDEX idx_modelos_marca ON modelos(marca_id);