CREATE TABLE lancamento (

codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
descricao VARCHAR (50) NOT NULL,
data_vencimento DATE NOT NULL,
data_pagamento DATE,
valor DECIMAL(10,2) NOT NULL,
observacao VARCHAR(100),
tipo VARCHAR(20) NOT NULL,
codigo_categoria BIGINT(20) NOT NULL,
codigo_pessoa BIGINT(20) NOT NULL,
FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
FOREIGN KEY (codigo_pessoa) REFERENCES pessoa(codigo)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Salário Mensal', '2020-11-25', null, '6500.00', 'Distribuição de lucros', 'RECEITA', '1','1');
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Cloroquina', '2020-11-24', '2020-12-01', '100.32', null, 'DESPESA', '4','2');
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Compras do mês', '2020-11-25', null, '500.00', 'Compras pra casa', 'DESPESA', '3','3');
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Marmita', '2020-11-25', null, '15.00', 'Marmita de hoje', 'DESPESA', '2','4');
INSERT INTO lancamento (descricao, data_vencimento, data_pagamento, valor, observacao, tipo, codigo_categoria, codigo_pessoa) values ('Games', '2020-11-25', null, '4900.00', 'Compra do PS5', 'DESPESA', '5','5');