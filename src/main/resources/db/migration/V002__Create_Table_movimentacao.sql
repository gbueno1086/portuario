CREATE TABLE IF NOT EXISTS movimentacao(
id INT PRIMARY KEY AUTO_INCREMENT,
conteiner_id INT NOT NULL,
FOREIGN KEY(conteiner_id) REFERENCES conteiner(id),
tipo_movimentacao VARCHAR(20) NOT NULL,
data_hora_inicio DATE,
data_hora_fim DATE
)ENGINE=INNODB;