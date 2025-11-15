USE gestao_veiculos;

-- Inserir marcas
INSERT IGNORE INTO marcas (nome, descricao) VALUES 
('Toyota', 'Marca japonesa conhecida por confiabilidade'),
('Volkswagen', 'Marca alemã líder no mercado brasileiro'),
('Ford', 'Marca americana tradicional'),
('Chevrolet', 'Marca americana muito popular no Brasil'),
('Honda', 'Marca japonesa conhecida por tecnologia'),
('Fiat', 'Marca italiana com forte presença no Brasil'),
('Hyundai', 'Marca coreana conhecida por design e tecnologia'),
('Renault', 'Marca francesa com modelos populares');

-- Inserir modelos
INSERT IGNORE INTO modelos (nome, descricao, marca_id) VALUES 
-- Toyota
('Corolla', 'Sedan médio confiável e confortável', 1),
('Hilux', 'Picape robusta para trabalho e lazer', 1),
('RAV4', 'SUV compacto versátil', 1),
('Yaris', 'Hatchback compacto econômico', 1),

-- Volkswagen
('Gol', 'Hatchback compacto e econômico', 2),
('Polo', 'Hatchback premium alemão', 2),
('Virtus', 'Sedan compacto moderno', 2),
('T-Cross', 'SUV compacto urbano', 2),

-- Ford
('Ranger', 'Picape de trabalho versátil', 3),
('Fiesta', 'Hatchback compacto esportivo', 3),
('EcoSport', 'SUV compacto popular', 3),
('Mustang', 'Esportivo icônico americano', 3),

-- Chevrolet
('Onix', 'Hatchback compacto moderno', 4),
('S10', 'Picape de trabalho robusta', 4),
('Tracker', 'SUV compacto tecnológico', 4),
('Cruze', 'Sedan esportivo premium', 4),

-- Honda
('Civic', 'Sedan esportivo e tecnológico', 5),
('HR-V', 'SUV compacto versátil', 5),
('Fit', 'Hatchback compacto espaçoso', 5),
('City', 'Sedan compacto elegante', 5);

-- Inserir veículos
INSERT IGNORE INTO veiculos (modelo_id, ano, cor, preco, quilometragem, status) VALUES 
-- Toyota
(1, 2022, 'Prata', 95000.00, 15000, 'DISPONIVEL'),
(2, 2021, 'Branco', 120000.00, 35000, 'DISPONIVEL'),
(3, 2023, 'Preto', 110000.00, 8000, 'RESERVADO'),
(4, 2022, 'Vermelho', 65000.00, 22000, 'DISPONIVEL'),

-- Volkswagen
(5, 2020, 'Vermelho', 45000.00, 42000, 'VENDIDO'),
(6, 2023, 'Preto', 85000.00, 8000, 'DISPONIVEL'),
(7, 2022, 'Cinza', 72000.00, 18000, 'DISPONIVEL'),
(8, 2023, 'Branco', 98000.00, 5000, 'DISPONIVEL'),

-- Ford
(9, 2019, 'Azul', 78000.00, 68000, 'MANUTENCAO'),
(10, 2022, 'Cinza', 52000.00, 22000, 'RESERVADO'),
(11, 2021, 'Prata', 68000.00, 32000, 'DISPONIVEL'),
(12, 2023, 'Amarelo', 320000.00, 2000, 'DISPONIVEL'),

-- Chevrolet
(13, 2021, 'Branco', 48000.00, 38000, 'DISPONIVEL'),
(14, 2020, 'Prata', 92000.00, 45000, 'DISPONIVEL'),
(15, 2023, 'Azul', 89000.00, 6000, 'DISPONIVEL'),
(16, 2022, 'Preto', 105000.00, 15000, 'DISPONIVEL'),

-- Honda
(17, 2023, 'Preto', 110000.00, 5000, 'DISPONIVEL'),
(18, 2022, 'Vermelho', 98000.00, 18000, 'DISPONIVEL'),
(19, 2021, 'Branco', 55000.00, 35000, 'DISPONIVEL'),
(20, 2023, 'Cinza', 75000.00, 9000, 'DISPONIVEL');