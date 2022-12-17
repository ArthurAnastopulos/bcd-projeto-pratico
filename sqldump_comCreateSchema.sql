CREATE DATABASE  IF NOT EXISTS `pp01arthur` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pp01arthur`;
-- MySQL dump 10.13  Distrib 8.0.29, for Linux (x86_64)
--
-- Host: ampto.sj.ifsc.edu.br    Database: pp01arthur
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `classificao`
--

DROP TABLE IF EXISTS `classificao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classificao` (
  `id_classificao` int NOT NULL AUTO_INCREMENT,
  `classificao` double NOT NULL,
  PRIMARY KEY (`id_classificao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificao`
--

LOCK TABLES `classificao` WRITE;
/*!40000 ALTER TABLE `classificao` DISABLE KEYS */;
/*!40000 ALTER TABLE `classificao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classificao_das_selecoes`
--

DROP TABLE IF EXISTS `classificao_das_selecoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classificao_das_selecoes` (
  `classificao_id_classificao` int NOT NULL,
  `fase_id_fase` int NOT NULL,
  `selecao_id_selecao` int NOT NULL,
  PRIMARY KEY (`classificao_id_classificao`,`fase_id_fase`,`selecao_id_selecao`),
  KEY `FKt7wkss7e2rd6re2sn5gcjgfcj` (`fase_id_fase`),
  KEY `FKfw4qg592br7u0vr0uclbre1n4` (`selecao_id_selecao`),
  CONSTRAINT `FKbiimmdlt8xcvntqgev2cyixf3` FOREIGN KEY (`classificao_id_classificao`) REFERENCES `classificao` (`id_classificao`),
  CONSTRAINT `FKfw4qg592br7u0vr0uclbre1n4` FOREIGN KEY (`selecao_id_selecao`) REFERENCES `selecao` (`id_selecao`),
  CONSTRAINT `FKt7wkss7e2rd6re2sn5gcjgfcj` FOREIGN KEY (`fase_id_fase`) REFERENCES `fase` (`id_fase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificao_das_selecoes`
--

LOCK TABLES `classificao_das_selecoes` WRITE;
/*!40000 ALTER TABLE `classificao_das_selecoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `classificao_das_selecoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edicao`
--

DROP TABLE IF EXISTS `edicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edicao` (
  `id_edicao` int NOT NULL AUTO_INCREMENT,
  `ano` int NOT NULL,
  `pais` varchar(255) NOT NULL,
  PRIMARY KEY (`id_edicao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicao`
--

LOCK TABLES `edicao` WRITE;
/*!40000 ALTER TABLE `edicao` DISABLE KEYS */;
INSERT INTO `edicao` VALUES (1,2022,'Catar');
/*!40000 ALTER TABLE `edicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadio`
--

DROP TABLE IF EXISTS `estadio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadio` (
  `id_estadio` int NOT NULL AUTO_INCREMENT,
  `local` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id_estadio`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadio`
--

LOCK TABLES `estadio` WRITE;
/*!40000 ALTER TABLE `estadio` DISABLE KEYS */;
INSERT INTO `estadio` VALUES (1,'Doha','974'),(2,'Doha','Al Thumama'),(3,'Doha','Khalifa International'),(4,'Al Rayyan','Ahmad bin Ali'),(5,'Al Khor','Al Bayt'),(6,'Lusail','Lusail'),(7,'Doha','Al Janoub'),(8,'Al Rayyan','Education City');
/*!40000 ALTER TABLE `estadio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento` (
  `id_evento` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento_de_partida`
--

DROP TABLE IF EXISTS `evento_de_partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `evento_de_partida` (
  `tempo_do_evento` double NOT NULL,
  `evento_id_evento` int NOT NULL,
  `jogador_has_partida_jogador_id_jogador` int NOT NULL,
  `jogador_has_partida_partida_id_partida` int NOT NULL,
  PRIMARY KEY (`evento_id_evento`,`jogador_has_partida_jogador_id_jogador`,`jogador_has_partida_partida_id_partida`),
  KEY `FKi0fp0a0uheseqv7cpttlmt151` (`jogador_has_partida_jogador_id_jogador`,`jogador_has_partida_partida_id_partida`),
  CONSTRAINT `FK2p17dsirf27ep6gtxa5r2fuf1` FOREIGN KEY (`evento_id_evento`) REFERENCES `evento` (`id_evento`),
  CONSTRAINT `FKi0fp0a0uheseqv7cpttlmt151` FOREIGN KEY (`jogador_has_partida_jogador_id_jogador`, `jogador_has_partida_partida_id_partida`) REFERENCES `jogadores_da_partida` (`jogador_id_jogador`, `partida_id_partida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento_de_partida`
--

LOCK TABLES `evento_de_partida` WRITE;
/*!40000 ALTER TABLE `evento_de_partida` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento_de_partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fase`
--

DROP TABLE IF EXISTS `fase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fase` (
  `id_fase` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id_fase`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fase`
--

LOCK TABLES `fase` WRITE;
/*!40000 ALTER TABLE `fase` DISABLE KEYS */;
INSERT INTO `fase` VALUES (1,'Grupo A'),(2,'Grupo B'),(3,'Grupo C'),(4,'Grupo D'),(5,'Grupo E'),(6,'Grupo F'),(7,'Grupo G'),(8,'Grupo H'),(9,'Oitavas'),(10,'Quartas'),(11,'Seminfinais'),(12,'Final');
/*!40000 ALTER TABLE `fase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogador`
--

DROP TABLE IF EXISTS `jogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogador` (
  `id_jogador` int NOT NULL AUTO_INCREMENT,
  `nacionalidade` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `data_nasc` date NOT NULL,
  PRIMARY KEY (`id_jogador`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador`
--

LOCK TABLES `jogador` WRITE;
/*!40000 ALTER TABLE `jogador` DISABLE KEYS */;
INSERT INTO `jogador` VALUES (1,'Brasil','Neymar','Santos Júnior','1992-02-05'),(2,'Brasil','Richarlison','de Andrade','1997-05-10'),(3,'Brasil','Vinícius','José Paixão de Oliveira Júnior','2000-07-12'),(4,'Brasil','Raphael','Dias Belloli','1996-12-14'),(5,'Brasil','Antony','Matheus dos Santos','2000-02-24'),(6,'Brasil','Pedro','Guilherme Abreu dos Santos','1997-06-20'),(7,'Brasil','Daniel','Alves da Silva','1983-05-06'),(8,'Brasil','Thiago','Emiliano da Silva','1984-09-22'),(9,'Brasil','Lucas','Tolentino Coelho de Lima','1997-08-27'),(10,'Brasil','Gabriel','Fernando de Jesus','1997-04-03'),(11,'Brasil','Gabriel','Teodoro Martinelli Silva','2001-06-18'),(12,'Brasil','Alisson','Ramses Becker','1992-10-02'),(13,'Brasil','Carlos','Henrique Casimiro','1992-02-23'),(14,'Brasil','Rodrygo','Silva de Goes','2001-01-09'),(15,'Brasil','Gleison','Bremer Silva Nascimento','1997-03-18'),(16,'Brasil','Alex','Nicolao Telles','1992-12-15'),(17,'Brasil','Marcos','Aoás Corrêa','1994-03-14'),(18,'Brasil','Fedrerico','Rodrigues de Paula Santos','1993-03-05'),(19,'Brasil','Éverton','Augusto de Barros Ribeiro','1989-04-10'),(20,'Brasil','Ederson','Santana de Moraes','1993-08-17'),(21,'Brasil','Bruno','Guimarães Rodrigues Moura','1997-11-16'),(22,'Brasil','Éder','Gabriel Militão','1998-01-18'),(23,'Brasil','Fábio','Henrique Tavares','1993-10-23'),(24,'Brasil','Weverton','Pereira da Silva','1987-12-13'),(25,'Brasil','Alex','Sandro Lobo Silva','1991-01-26'),(26,'Brasil','Danilo','Luiz da Silva','1991-07-15'),(27,'Croácia','Luka','Modrić','1985-09-09'),(28,'Croácia','Ivan','Perišić','1989-02-02'),(29,'Croácia','Domagoj','Vida','1989-04-29'),(30,'Croácia','Joško','Gvardiol','2002-01-23'),(31,'Croácia','Mateo','Kovačić','1994-02-06'),(32,'Croácia','Dominik','Livaković','1995-01-09'),(33,'Croácia','Dejan','Lovren','1989-07-05'),(34,'Croácia','Marcelo','Brozović','1992-11-16'),(35,'Croácia','Lovro','Majer','1998-01-17'),(36,'Croácia','Josip','Stanišić','2000-04-02'),(37,'Croácia','Borna','Sosa','1998-01-21'),(38,'Croácia','Andrej','Kramarić','1991-06-19'),(39,'Croácia','Marko','Livaja','1993-08-26'),(40,'Croácia','Mario','Pašalić','1995-02-09'),(41,'Croácia','Nikola','Vlašić','1997-10-04'),(42,'Croácia','Luka','Sučić','2002-09-08'),(43,'Croácia','Ante','Budimir','1991-07-22'),(44,'Croácia','Mislav','Oršić','1992-12-29'),(45,'Croácia','Josip','Juranović','1995-08-16'),(46,'Croácia','Bruno','Petković','1994-09-16'),(47,'Croácia','Kristijan','Jakić','1997-05-14'),(48,'Croácia','Ivo','Grbić','1996-01-18'),(49,'Croácia','Martin','Erlić','1998-01-24'),(50,'Croácia','Josip','Šutalo','2000-02-28'),(51,'Croácia','Borna','Barišić','1992-11-10'),(52,'Croácia','Ivica','Ivušić','1995-02-01');
/*!40000 ALTER TABLE `jogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogadores_da_partida`
--

DROP TABLE IF EXISTS `jogadores_da_partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogadores_da_partida` (
  `partida_id_partida` int NOT NULL,
  `jogador_id_jogador` int NOT NULL,
  `posicao_id_posicao` int DEFAULT NULL,
  PRIMARY KEY (`jogador_id_jogador`,`partida_id_partida`),
  KEY `FKmb5k1m707uojeh8gk3aetk3jp` (`partida_id_partida`),
  KEY `FKq594yew7quainaxa3si00kq9v` (`posicao_id_posicao`),
  CONSTRAINT `FKcsquo77vpr6imioomdnsphrjm` FOREIGN KEY (`jogador_id_jogador`) REFERENCES `jogador` (`id_jogador`),
  CONSTRAINT `FKmb5k1m707uojeh8gk3aetk3jp` FOREIGN KEY (`partida_id_partida`) REFERENCES `partida` (`id_partida`),
  CONSTRAINT `FKq594yew7quainaxa3si00kq9v` FOREIGN KEY (`posicao_id_posicao`) REFERENCES `posicao` (`id_posicao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogadores_da_partida`
--

LOCK TABLES `jogadores_da_partida` WRITE;
/*!40000 ALTER TABLE `jogadores_da_partida` DISABLE KEYS */;
INSERT INTO `jogadores_da_partida` VALUES (1,12,1),(1,32,1),(1,1,2),(1,2,2),(1,3,2),(1,4,2),(1,28,2),(1,38,2),(1,40,2),(1,9,3),(1,13,3),(1,27,3),(1,31,3),(1,34,3),(1,8,4),(1,17,4),(1,22,4),(1,26,4),(1,30,4),(1,33,4),(1,37,4),(1,45,4);
/*!40000 ALTER TABLE `jogadores_da_partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partida` (
  `id_partida` int NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `id_estadio` int NOT NULL,
  `id_selecao1` int NOT NULL,
  `id_selecao2` int NOT NULL,
  PRIMARY KEY (`id_partida`),
  KEY `FK7yv91aocwpqb2vgydpskw1xnc` (`id_estadio`),
  KEY `FKp66eqkxe8e4xeq97jici5sfo9` (`id_selecao1`),
  KEY `FKghg82fv9knj4x57brk0qk4j45` (`id_selecao2`),
  CONSTRAINT `FK7yv91aocwpqb2vgydpskw1xnc` FOREIGN KEY (`id_estadio`) REFERENCES `estadio` (`id_estadio`),
  CONSTRAINT `FKghg82fv9knj4x57brk0qk4j45` FOREIGN KEY (`id_selecao2`) REFERENCES `selecao` (`id_selecao`),
  CONSTRAINT `FKp66eqkxe8e4xeq97jici5sfo9` FOREIGN KEY (`id_selecao1`) REFERENCES `selecao` (`id_selecao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
INSERT INTO `partida` VALUES (1,'2022-12-09',8,2,1);
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidas_da_edicao`
--

DROP TABLE IF EXISTS `partidas_da_edicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidas_da_edicao` (
  `partida_id_partida` int NOT NULL,
  `edicao_id_edicao` int NOT NULL,
  `fase_id_fase` int NOT NULL,
  PRIMARY KEY (`edicao_id_edicao`,`fase_id_fase`,`partida_id_partida`),
  UNIQUE KEY `UK_hjt4ksfmw1adbc51qf03t9kt2` (`fase_id_fase`),
  KEY `FKkmeyjtvxcy1cmfu4am7tut0u7` (`partida_id_partida`),
  CONSTRAINT `FKjhwc8autvj2joxry6bf5tbkrc` FOREIGN KEY (`fase_id_fase`) REFERENCES `fase` (`id_fase`),
  CONSTRAINT `FKkmeyjtvxcy1cmfu4am7tut0u7` FOREIGN KEY (`partida_id_partida`) REFERENCES `partida` (`id_partida`),
  CONSTRAINT `FKu07mdcx0emqsqjhomdn80awh` FOREIGN KEY (`edicao_id_edicao`) REFERENCES `edicao` (`id_edicao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidas_da_edicao`
--

LOCK TABLES `partidas_da_edicao` WRITE;
/*!40000 ALTER TABLE `partidas_da_edicao` DISABLE KEYS */;
INSERT INTO `partidas_da_edicao` VALUES (1,1,10);
/*!40000 ALTER TABLE `partidas_da_edicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posicao`
--

DROP TABLE IF EXISTS `posicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posicao` (
  `id_posicao` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  PRIMARY KEY (`id_posicao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posicao`
--

LOCK TABLES `posicao` WRITE;
/*!40000 ALTER TABLE `posicao` DISABLE KEYS */;
INSERT INTO `posicao` VALUES (1,'Goleiro'),(2,'Atacante'),(3,'Meia'),(4,'Zagueiro');
/*!40000 ALTER TABLE `posicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selecao`
--

DROP TABLE IF EXISTS `selecao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `selecao` (
  `id_selecao` int NOT NULL AUTO_INCREMENT,
  `pais` varchar(255) NOT NULL,
  `id_edicao` int NOT NULL,
  PRIMARY KEY (`id_selecao`),
  KEY `FKp4h4yoqsc8sma0cu2a5r5iyhw` (`id_edicao`),
  CONSTRAINT `FKp4h4yoqsc8sma0cu2a5r5iyhw` FOREIGN KEY (`id_edicao`) REFERENCES `edicao` (`id_edicao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selecao`
--

LOCK TABLES `selecao` WRITE;
/*!40000 ALTER TABLE `selecao` DISABLE KEYS */;
INSERT INTO `selecao` VALUES (1,'Brasil',1),(2,'Croácia',1);
/*!40000 ALTER TABLE `selecao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selecao_do_jogador`
--

DROP TABLE IF EXISTS `selecao_do_jogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `selecao_do_jogador` (
  `id_selecao` int NOT NULL,
  `id_jogador` int NOT NULL,
  PRIMARY KEY (`id_selecao`,`id_jogador`),
  KEY `FKmw5oxia2s3tod3ki029cpc1gf` (`id_jogador`),
  CONSTRAINT `FKi9guu3ey68vlhlkn1m8y94d62` FOREIGN KEY (`id_selecao`) REFERENCES `selecao` (`id_selecao`),
  CONSTRAINT `FKmw5oxia2s3tod3ki029cpc1gf` FOREIGN KEY (`id_jogador`) REFERENCES `jogador` (`id_jogador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selecao_do_jogador`
--

LOCK TABLES `selecao_do_jogador` WRITE;
/*!40000 ALTER TABLE `selecao_do_jogador` DISABLE KEYS */;
INSERT INTO `selecao_do_jogador` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20),(1,21),(1,22),(1,23),(1,24),(1,25),(1,26),(2,27),(2,28),(2,29),(2,30),(2,31),(2,32),(2,33),(2,34),(2,35),(2,36),(2,37),(2,38),(2,39),(2,40),(2,41),(2,42),(2,43),(2,44),(2,45),(2,46),(2,47),(2,48),(2,49),(2,50),(2,51),(2,52);
/*!40000 ALTER TABLE `selecao_do_jogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selecao_do_tecnico`
--

DROP TABLE IF EXISTS `selecao_do_tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `selecao_do_tecnico` (
  `id_selecao` int NOT NULL,
  `id_tecnico` int NOT NULL,
  PRIMARY KEY (`id_selecao`,`id_tecnico`),
  KEY `FKajvectqkdkivt18m1qth4g2xo` (`id_tecnico`),
  CONSTRAINT `FKajvectqkdkivt18m1qth4g2xo` FOREIGN KEY (`id_tecnico`) REFERENCES `tecnico` (`id_tecnico`),
  CONSTRAINT `FKn7frkoi6s48iawepgwnfm5wsg` FOREIGN KEY (`id_selecao`) REFERENCES `selecao` (`id_selecao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selecao_do_tecnico`
--

LOCK TABLES `selecao_do_tecnico` WRITE;
/*!40000 ALTER TABLE `selecao_do_tecnico` DISABLE KEYS */;
INSERT INTO `selecao_do_tecnico` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `selecao_do_tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tecnico` (
  `id_tecnico` int NOT NULL AUTO_INCREMENT,
  `nacionalidade` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sobrenome` varchar(255) NOT NULL,
  `data_nasc` date NOT NULL,
  PRIMARY KEY (`id_tecnico`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES (1,'Brasil','Adenor','Leonardo Bacchi','1961-05-25'),(2,'Bósnia','Zlatko','Dalić','1966-10-26');
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pp01arthur'
--

--
-- Dumping routines for database 'pp01arthur'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-17 18:45:17
