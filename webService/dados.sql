CREATE DATABASE  IF NOT EXISTS `dados` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dados`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: dados
-- ------------------------------------------------------
-- Server version	5.7.10-log

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

--
-- Table structure for table `abastecimento`
--

DROP TABLE IF EXISTS `abastecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abastecimento` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `HORARIO` longblob,
  `QTDELITROS` double DEFAULT NULL,
  `QUILOMETRAGEM` double DEFAULT NULL,
  `TIPODECOMBUSTIVEL` varchar(255) DEFAULT NULL,
  `VALORLITRO` double DEFAULT NULL,
  `VALORPAGO` double DEFAULT NULL,
  `POSTODECOMBUSTIVEL_ID` bigint(20) DEFAULT NULL,
  `USUARIO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ABASTECIMENTO_POSTODECOMBUSTIVEL_ID` (`POSTODECOMBUSTIVEL_ID`),
  KEY `FK_ABASTECIMENTO_USUARIO_ID` (`USUARIO_ID`),
  CONSTRAINT `FK_ABASTECIMENTO_POSTODECOMBUSTIVEL_ID` FOREIGN KEY (`POSTODECOMBUSTIVEL_ID`) REFERENCES `postodecombustivel` (`ID`),
  CONSTRAINT `FK_ABASTECIMENTO_USUARIO_ID` FOREIGN KEY (`USUARIO_ID`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abastecimento`
--

LOCK TABLES `abastecimento` WRITE;
/*!40000 ALTER TABLE `abastecimento` DISABLE KEYS */;
INSERT INTO `abastecimento` VALUES (1,'¨\Ì\0sr\0\rjava.time.Serï]Ñ∫\"H≤\0\0xpw\0\0\‚55*¥Äx',5,56,'ETANOL_COMUM',3.99,0,1,1);
/*!40000 ALTER TABLE `abastecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postodecombustivel`
--

DROP TABLE IF EXISTS `postodecombustivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postodecombustivel` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CIDADE` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `UF` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postodecombustivel`
--

LOCK TABLES `postodecombustivel` WRITE;
/*!40000 ALTER TABLE `postodecombustivel` DISABLE KEYS */;
INSERT INTO `postodecombustivel` VALUES (1,'Sousa','Queirog√£o','PB');
/*!40000 ALTER TABLE `postodecombustivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'laerton240311@gmail.com','Laerton Marques de Figueiredo','5555');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-06  8:12:23
