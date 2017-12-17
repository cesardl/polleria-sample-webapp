CREATE SCHEMA IF NOT EXISTS polleria;

SET SCHEMA "polleria";

CREATE TABLE `carta` (
  `id_carta` INT(10) NOT NULL AUTO_INCREMENT,
  `variedad` VARCHAR(50)      DEFAULT NULL,
  PRIMARY KEY (`id_carta`)
);

CREATE TABLE `variedades` (
  `id_variedad` INT(10) NOT NULL AUTO_INCREMENT,
  `id_carta`    INT(10) NOT NULL,
  `Nombre`      VARCHAR(50)      DEFAULT NULL,
  `descripcion` VARCHAR(100)     DEFAULT NULL,
  `precio`      DOUBLE           DEFAULT NULL,
  PRIMARY KEY (`id_variedad`),
);

CREATE TABLE `usuario` (
  `id_usuario`     INT(10) NOT NULL AUTO_INCREMENT,
  `usuario`        VARCHAR(50) DEFAULT NULL,
  `nombres`        VARCHAR(50) DEFAULT NULL,
  `apellidos`      VARCHAR(50) DEFAULT NULL,
  `clave`          VARCHAR(50) DEFAULT NULL,
  `dni`            VARCHAR(8)  DEFAULT NULL,
  `direccion`      VARCHAR(50) DEFAULT NULL,
  `telefono_fijo`  INT(11)     DEFAULT NULL,
  `telefono_Movil` INT(11)     DEFAULT NULL,
  `confirmado`     BOOLEAN     DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
);