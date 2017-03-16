-- CREATE DATABASE
CREATE DATABASE IF NOT EXISTS condominio;
USE condominio;

CREATE TABLE IF NOT EXISTS user(
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
cpf VARCHAR(14),
name VARCHAR(2000),
email VARCHAR(2000)
-- sexo VARCHAR(15),
-- dataNascimento VARCHAR(15),
-- telefone VARCHAR(2000),
-- empresa VARCHAR(2000),
-- username VARCHAR(200),
-- password VARCHAR(44)
);

-- SELECT * FROM user;
-- drop table user;

CREATE TABLE IF NOT EXISTS company(
id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
cnpj VARCHAR(40),
razaoSocial VARCHAR(2000),
horarioEmpresa VARCHAR(200),
temperaturaAr DECIMAL(4,2),
horarioAr VARCHAR(200)
);

-- SELECT * FROM company;
-- drop table company;