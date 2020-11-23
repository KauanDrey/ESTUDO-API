CREATE TABLE pessoa(
 	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
 	nome VARCHAR(50) NOT NULL,
 	ativo BOOLEAN NOT NULL,
 	logradouro VARCHAR (100),
 	complemento VARCHAR (60),
 	numero VARCHAR (10),
 	bairro VARCHAR (40),
 	cep VARCHAR (9),
 	cidade VARCHAR (20),
 	estado VARCHAR (20)
 	
 	
 	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoa (nome, ativo, logradouro, complemento, numero, bairro, cep, cidade, estado) values ('Kauan Drey', '1', 'R Cabo Diogo Oliver', 'CS 04', '311', 'Vila Mogilar', '08773-000', 'Mogi das Cruzes', 'São Paulo');