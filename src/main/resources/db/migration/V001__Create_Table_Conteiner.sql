CREATE TABLE IF NOT EXISTS conteiner(
id INT PRIMARY KEY AUTO_INCREMENT,
cliente VARCHAR(80) NOT NULL,
numero_conteiner CHAR(11) NOT NULL,
tipo_conteiner INT(2) NOT NULL,
status_conteiner CHAR(5) NOT NULL,
categoria_conteiner CHAR(10) NOT NULL
)ENGINE=INNODB;