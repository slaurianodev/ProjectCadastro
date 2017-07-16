DROP DATABASE IF EXISTS my_data;

CREATE DATABASE my_data;

USE my_data;

CREATE TABLE timecoracao (
    id_time INT NOT NULL AUTO_INCREMENT,
    nome_time VARCHAR(100) NOT NULL,
    PRIMARY KEY(id_time)
);

CREATE TABLE usuarios (
    id_user INT NOT NULL AUTO_INCREMENT,
    nome_completo VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    data_nascimento DATE,
    id_time_coracao INT,
    PRIMARY KEY (id_user),
    FOREIGN KEY (id_time_coracao) REFERENCES timecoracao(id_time)
);

CREATE TABLE campanhas(
    id_campanha INT NOT NULL AUTO_INCREMENT,
    nome_campanha varchar(100) NOT NULL,
    id_time_coracao INT NOT NULL,
    data_inicio DATE NOT NULL,
    data_fim DATE NOT NULL,
    PRIMARY KEY (id_campanha),
    FOREIGN KEY (id_time_coracao) REFERENCES timecoracao(id_time)
);

CREATE TABLE campanhas_usuarios(
    id_campanha_usuario INT NOT NULL AUTO_INCREMENT,
    id_user INT,
    id_campanha INT,
    PRIMARY KEY (id_campanha_usuario)
);

