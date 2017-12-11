-- MySQL dump 10.13  Distrib 5.1.41, for pc-linux-gnu (i686)
--
-- Host: localhost    Database: polleria
-- ------------------------------------------------------
-- Server version	5.1.41

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE polleria CHARACTER SET utf8 COLLATE utf8_general_ci;

USE polleria;

--
-- Table structure for table `carta`
--

DROP TABLE IF EXISTS `carta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carta` (
  `id_carta` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `variedad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_carta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carta`
--

LOCK TABLES `carta` WRITE;
/*!40000 ALTER TABLE `carta` DISABLE KEYS */;
INSERT INTO `carta` VALUES (1,'Ensaladas'),(2,'Pollos a la Brazas'),(3,'Bebidas'),(4,'Entradas al carbon');
/*!40000 ALTER TABLE `carta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `id_compra` int(10) NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT NULL,
  `hora` datetime DEFAULT NULL,
  `entregado` tinyint(1) DEFAULT NULL,
  `id_usuario` int(10) NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `fk_compra_usuario` (`id_usuario`),
  CONSTRAINT `fk_compra_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_compra` (
  `id_detalle_compra` int(10) NOT NULL AUTO_INCREMENT,
  `id_compra` int(10) NOT NULL,
  `id_variedad` int(10) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `importe` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_compra`),
  KEY `fk_detalle_compra_compra1` (`id_compra`),
  KEY `fk_detalle_compra_variedades1` (`id_variedad`),
  CONSTRAINT `fk_detalle_compras` FOREIGN KEY (`id_compra`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `fk_detalle_variedad` FOREIGN KEY (`id_variedad`) REFERENCES `variedades` (`id_variedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(10) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) DEFAULT NULL,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `dni` varchar(8) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono_fijo` int(11) DEFAULT NULL,
  `telefono_Movil` int(11) DEFAULT NULL,
  `confirmado` enum('True','False') DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','PABLO CESAR','DIAZ LURITA','admin','45236984',NULL,2583361,992163031,'True');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `variedades`
--

DROP TABLE IF EXISTS `variedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `variedades` (
  `id_variedad` int(10) NOT NULL AUTO_INCREMENT,
  `id_carta` int(10) unsigned NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  PRIMARY KEY (`id_variedad`),
  KEY `fk_variedad_carta` (`id_carta`),
  CONSTRAINT `fk_variedad_carta` FOREIGN KEY (`id_carta`) REFERENCES `carta` (`id_carta`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variedades`
--

LOCK TABLES `variedades` WRITE;
/*!40000 ALTER TABLE `variedades` DISABLE KEYS */;
INSERT INTO `variedades` VALUES (1,4,'Anticuchos de lomos','Anticuchos de lomo acompanhado de papas fritas',21),(2,4,'Anticuchos de res','Anticuchos de res acompanhado de papas fritas',17),(3,4,'Brochetas de lomos','Brochetas de lomo(2) acompanhado de papas fritas',22),(4,4,'Brochetas de pollo','Brochetas de pechuga de pollo (2), intercalados',16),(5,4,'Chorizos','Chorizos (2) acompanhados con papas fritas',11),(6,4,'Mollejitas pollo','Chorizos (2) acompanhados con papas fritas',11),(7,4,'Mollejitas res','Mollejitas de Res acompanhadas con papas fritas',13),(8,1,'Ensalada Mixta','Lechuga, tomate, pepinos, palta y vinagreta',8),(9,1,'Ensalada Verano','Lechuga organica, zanahoria rallada, melon, apio, ',9),(10,2,'1/8 de pollo a la braza','1/8 de pollo a la braza con papas y cremas',6),(11,2,'1/4 pollo a la braza','1/4 de pollo a la braza con papas y cremas',8),(12,2,'1/2 pollo a la brasa','1/2 de pollo a la braza con papas y cremas',14),(13,2,'1 pollo a la braza','1 pollo a la braza entero con papas y  cremas',20),(14,2,'1 porcion de papas','1 porcion de papas',5),(15,2,'1 pollo','1 pollo entero',16),(16,3,'1lt gaseosa Inka Kola','gaseosa Inka Kola de litro',4),(17,3,'1,5lt gaseosa Inka Kola','gaseosa Inka Kola de litro y medio',5),(18,3,'2 lt gaseosa Inka Kola','gaseosa Inka Kola de dos litros',6),(19,3,'1lt gaseosa coca cola','gaseosa coca cola de litro',4),(20,3,'1,5Lt gaseosa coca cola','gaseosa coca cola de Litro y medio',5),(21,3,'2lt gaseosa coca cola','gaseosa coca cola de dos litros',6);
/*!40000 ALTER TABLE `variedades` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2010-11-11 15:47:26
