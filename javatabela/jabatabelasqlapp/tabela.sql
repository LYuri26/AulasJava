CREATE DATABASE brasileirao;
USE brasileirao;

CREATE TABLE times (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    pontuacao INT NOT NULL
);

INSERT INTO times (nome, pontuacao) VALUES
    ('América Mineiro', 0),
    ('Athletico-PR', 0),
    ('Atlético Mineiro', 0),
    ('Bahia', 0),
    ('Botafogo', 0),
    ('Corinthians', 0),
    ('Coritiba', 0),
    ('Cruzeiro', 0),
    ('Cuiabá', 0),
    ('Flamengo', 0),
    ('Fluminense', 0),
    ('Fortaleza', 0),
    ('Goiás', 0),
    ('Grêmio', 0),
    ('Internacional', 0),
    ('Palmeiras', 0),
    ('Red Bull Bragantino', 0),
    ('Santos', 0),
    ('São Paulo', 0),
    ('Vasco', 0);


DESC times;
