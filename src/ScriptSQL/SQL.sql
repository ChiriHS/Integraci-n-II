CREATE DATABASE marcajeasistencia ;

USE marcajeasistencia;

CREATE TABLE usuario(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    clave VARCHAR(20) NOT NULL,
    rol VARCHAR(30) NOT NULL
);

CREATE TABLE asistencia(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    UsuarioId BIGINT,
    HoraEntrada DATETIME,
    HoraSalida DATETIME,
    FOREIGN KEY (UsuarioId) REFERENCES usuario (id) ON DELETE CASCADE
);

INSERT INTO usuario (nombre, email, clave, rol) VALUES 
("Angel Saez","angel.saez@gmail.com","Hola1234","USUARIO"),
("Christofer Hidalgo","christofer.hidalgo@gmail.com","Chao1234","ADMIN"),
("Stefan Reschke","stefan.reschke@gmail.com","Alo1234","USUARIO");