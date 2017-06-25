
DROP DATABASE bdpizzaria;
CREATE DATABASE bdpizzaria;


USE bdpizzaria;

DROP TABLE produto;
DROP TABLE pizza_ingrediente;
DROP TABLE cliente;
DROP TABLE ingrediente;
DROP TABLE fornecedor;
DROP TABLE pedido_detalhe;
DROP TABLE pedido;
DROP TABLE usuario;

INSERT INTO usuario(usr_nome,usr_login,usr_senha,usr_nivel)VALUES('Gabriel','gabriel@gmail.com','12345',2);
CREATE TABLE usuario(usr_id INT AUTO_INCREMENT NOT NULL,
					 usr_nome VARCHAR(200) NOT NULL,
                     usr_login VARCHAR(200) NOT NULL,
                     usr_senha VARCHAR(200) NOT NULL,
                     usr_nivel INT NOT NULL,
                     CONSTRAINT PK_usuario PRIMARY KEY(usr_id),
                     CONSTRAINT UNQ_usuario_login UNIQUE(usr_login),
                     CONSTRAINT CHK_usuario_nivel CHECK (usr_nivel <=3));

CREATE TABLE cliente(cli_id INT AUTO_INCREMENT NOT NULL,
					 cli_nome VARCHAR(500) NOT NULL,
                     cli_end VARCHAR(500) NOT NULL,
                     cli_num VARCHAR(500) NOT NULL,
                     cli_bair VARCHAR(500) NOT NULL,
                     cli_compl VARCHAR(500) NOT NULL,
                     cli_cid VARCHAR(500) NOT NULL,
                     cli_est CHAR(2) NOT NULL,
                     cli_cep CHAR(8) NOT NULL,
                     cli_tel BIGINT NOT NULL,
                     CONSTRAINT PK_cliente PRIMARY KEY(cli_id),
                     CONSTRAINT UNQ_cliente UNIQUE(cli_tel));
                     
CREATE TABLE fornecedor(forn_id INT AUTO_INCREMENT NOT NULL,
					 forn_nome VARCHAR(500) NOT NULL,
                     forn_cnpj BIGINT NOT NULL,
					 forn_end VARCHAR(500) NOT NULL,
                     forn_num VARCHAR(500) NOT NULL,
                     forn_bair VARCHAR(500) NOT NULL,
                     forn_compl VARCHAR(500) NOT NULL,
                     forn_cid VARCHAR(500) NOT NULL,
                     forn_est CHAR(2) NOT NULL,
                     forn_cep CHAR(8) NOT NULL,
                     forn_tel LONG NOT NULL,
                     forn_ativo BOOL DEFAULT TRUE,
                     CONSTRAINT PK_fornecedor PRIMARY KEY(forn_id),
                     CONSTRAINT UNQ_fornecedor_cnpj UNIQUE(forn_cnpj));

                         
CREATE TABLE produto(prod_id INT AUTO_INCREMENT NOT NULL,
					 prod_desc VARCHAR(100) NOT NULL,
                     prod_prec NUMERIC(15,2) NOT NULL,
                     prod_tam_vol VARCHAR(100) NOT NULL,
                     prod_forn_id INT DEFAULT NULL,
                     prod_qntd NUMERIC(15,2) NOT NULL DEFAULT 0,
                     DTYPE VARCHAR(100) NOT NULL,
                     CONSTRAINT PK_produto PRIMARY KEY(prod_id),
                     CONSTRAINT UNQ_produto_tamanho_volume UNIQUE(prod_desc,prod_tam_vol,prod_forn_id),
                     CONSTRAINT FK_produto_fornecedor FOREIGN KEY(prod_forn_id) REFERENCES fornecedor(forn_id)
                     ON DELETE CASCADE);
                     

CREATE TABLE pizza_ingrediente(pizza_id INT NOT NULL,
							   ingr_id INT NOT NULL,
                               ingr_qntd NUMERIC(15,2) NOT NULL,
                               CONSTRAINT PK_pizza_ingrediente PRIMARY KEY(pizza_id,ingr_id),
                               CONSTRAINT FK_pizza_ingrediente_pizza FOREIGN KEY(pizza_id) REFERENCES produto(prod_id),
                               CONSTRAINT FK_pizza_ingrediente_ingrediente FOREIGN KEY(ingr_id) REFERENCES produto(prod_id)
                               ON DELETE CASCADE);

CREATE TABLE pedido(ped_id INT AUTO_INCREMENT NOT NULL,
					ped_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
                    ped_total NUMERIC(15,2) NOT NULL,
                    ped_cli_id INT DEFAULT NULL,
                    ped_num_mesa INT DEFAULT NULL,
                    ped_solic_pag BOOLEAN DEFAULT FALSE,
                    DTYPE VARCHAR(200) NOT NULL,
                    CONSTRAINT PK_pedido PRIMARY KEY(ped_id),
                    CONSTRAINT FK_pedido_cliente FOREIGN KEY(ped_cli_id) REFERENCES cliente(cli_id));
                    
CREATE TABLE pedido_detalhe(ped_id INT NOT NULL,
                            prod_id INT NOT NULL,
                            prod_qntd NUMERIC(15,2) NOT NULL,
                            CONSTRAINT PK_pedido_detalhe PRIMARY KEY(ped_id,prod_id),
                            CONSTRAINT FK_pedido_detalhe_pedido FOREIGN KEY(ped_id) REFERENCES pedido(ped_id),
                            CONSTRAINT FK_pedido_detalhe_produto FOREIGN KEY(prod_id) REFERENCES produto(prod_id));
                            
                            

SELECT * FROM cliente;
SELECT * FROM fornecedor;
SELECT * FROM produto;
SELECT * FROM pizza_ingrediente;
SELECT * FROM pedido;
SELECT * FROM pedido_detalhe;
SELECT * FROM usuario;