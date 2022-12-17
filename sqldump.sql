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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificao`
--

LOCK TABLES `classificao` WRITE;
/*!40000 ALTER TABLE `classificao` DISABLE KEYS */;
INSERT INTO `classificao` VALUES (1,1),(2,2),(3,3),(4,4),(5,5),(6,6),(7,7),(8,8);
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
INSERT INTO `classificao_das_selecoes` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(1,2,5),(2,2,6),(3,2,7),(4,2,8),(1,3,9),(2,3,10),(3,3,11),(4,3,12),(1,4,13),(2,4,14),(3,4,15),(4,4,16),(1,5,17),(2,5,18),(3,5,19),(4,5,20),(1,6,21),(2,6,22),(3,6,23),(4,6,24),(1,7,25),(2,7,26),(3,7,27),(4,7,28),(1,8,29),(2,8,30),(3,8,31),(4,8,32),(1,9,1),(2,9,9),(3,9,22),(4,9,25),(5,9,13),(6,9,5),(7,9,21),(8,9,29),(1,10,9),(2,10,22),(3,10,13),(4,10,21),(1,11,9),(2,11,13);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edicao`
--

LOCK TABLES `edicao` WRITE;
/*!40000 ALTER TABLE `edicao` DISABLE KEYS */;
INSERT INTO `edicao` VALUES (1,2022,'Catar'),(2,2018,'Russia'),(3,1958,'Suécia'),(4,2014,'Brasil'),(5,2010,'Africa do Sul');
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
INSERT INTO `estadio` VALUES (1,'Doha','974'),(2,'Doha','Al Thumama'),(3,'Doha','Khalifa International'),(4,'Al Rayyan','Ahmad bin Ali'),(5,'Al Khor','Al Bayt'),(6,'Lusail','Lusail'),(7,'Al Wakrah','Al Janoub'),(8,'Al Rayyan','Education City');
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Chute'),(2,'Gol'),(3,'Pssse'),(4,'Faltas'),(5,'Cartão Amarelo'),(6,'Cartão Vermelho'),(7,'Impedimentos'),(8,'Escanteios'),(9,'Substituição');
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
  PRIMARY KEY (`evento_id_evento`,`jogador_has_partida_jogador_id_jogador`,`jogador_has_partida_partida_id_partida`,`tempo_do_evento`),
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
INSERT INTO `evento_de_partida` VALUES (69,9,38,1),(79,9,39,1),(79,9,40,1),(6,2,44,1),(80,9,44,1),(46,9,46,1),(46,9,47,1),(80,9,48,1),(57,5,66,1),(90,9,70,1),(74,9,71,1),(90,9,72,1),(49,2,74,1),(90,9,74,1),(74,9,75,1),(90,9,77,1);
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
INSERT INTO `fase` VALUES (1,'Grupo A'),(2,'Grupo B'),(3,'Grupo C'),(4,'Grupo D'),(5,'Grupo E'),(6,'Grupo F'),(7,'Grupo G'),(8,'Grupo H'),(9,'Oitavas'),(10,'Quartas'),(11,'Semifinais'),(12,'Final');
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
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador`
--

LOCK TABLES `jogador` WRITE;
/*!40000 ALTER TABLE `jogador` DISABLE KEYS */;
INSERT INTO `jogador` VALUES (1,'Catar','Saad','Al Sheeb','1990-02-19'),(2,'Catar','Meshaal','Barsham','1998-02-14'),(3,'Catar','Yousuf','Hassan','1996-05-24'),(4,'Catar','Pedro','Miguel','1990-08-06'),(5,'Catar','Musaab','Khidir','1993-09-26'),(6,'Catar','Tarek','Salman','1997-12-05'),(7,'Catar','Bassam','Al Rawi','1997-12-16'),(8,'Catar','Khoukhi','Baualem','1990-09-07'),(9,'Catar','Abdelkarim','Hassan','1993-08-28'),(10,'Catar','Ismaeel','Mohammad','1990-04-05'),(11,'Catar','Homam','Al Amin','1999-08-25'),(12,'Catar','Jassim','Jabir','1984-07-25'),(13,'Catar','Ali','Asad','1993-01-19'),(14,'Catar','Mohammed','Waad','1999-09-18'),(15,'Catar','Salem','Al Hajri','1996-05-10'),(16,'Catar','Assim','Madibo','1996-10-22'),(17,'Catar','Mustafa','Meshaal','2001-04-28'),(18,'Catar','Karim','Boudiaf','1990-09-16'),(19,'Catar','Abdulaziz','Hatim','1990-10-28'),(20,'Catar','Naif','Al Hadhrami','2001-07-18'),(21,'Catar','Hassan','Al Haydos','1990-12-11'),(22,'Catar','Akram','Afif','1996-11-18'),(23,'Catar','Almoez','Ali','1996-08-19'),(24,'Catar','Mohammed','Muntari','1993-12-20'),(25,'Catar','Ahmed','Alaa','1994-01-01'),(26,'Catar','Khalid','Muneer','1998-02-24'),(27,'Holanda','Justin','Bijlow','1998-01-22'),(28,'Holanda','Andries','Noppert','1994-04-07'),(29,'Holanda','Remko','Pasveer','1983-11-08'),(30,'Holanda','Daley','Blind','1990-05-09'),(31,'Holanda','Denzel','Dumfires','1996-04-18'),(32,'Holanda','Tyrell','Malacia','1999-08-17'),(33,'Holanda','Jeremie','Frimpong','2000-12-10'),(34,'Holanda','Van','Dijk','1991-07-08'),(35,'Holanda','De','Vrij','1992-02-05'),(36,'Holanda','Nathan','Aké','1995-02-18'),(37,'Holanda','Jurriën','Timber','2001-06-17'),(38,'Holanda','Davy','Klaassen','1993-02-21'),(39,'Holanda','Marten','De Roon','1991-05-29'),(40,'Holanda','Teun','Koopmeiners','1998-02-28'),(41,'Holanda','Kenneth','Taylor','2002-04-16'),(42,'Holanda','Frenkie','De Jong','1997-04-12'),(43,'Holanda','Steven','Berghuis','1991-12-19'),(44,'Holanda','Cody','Gakpo','1999-04-07'),(45,'Holanda','Xavi','Simons','2003-04-21'),(46,'Holanda','Memphis','Depay','1994-02-13'),(47,'Holanda','Steven','Bergwijn','1997-10-08'),(48,'Holanda','Wout','Weghorst','1992-08-07'),(49,'Holanda','Vicent','Janssen','1994-06-15'),(50,'Holanda','Luuk','De Jong','1990-08-27'),(51,'Holanda','Noa','Lang','1999-06-17'),(52,'Equador','Alexander','Domínguez','1987-06-05'),(53,'Equador','Hernán','Galíndez','1987-05-30'),(54,'Equador','Moisés','Ramírez','2000-09-09'),(55,'Equador','Piero','Hincapié','2002-01-09'),(56,'Equador','Félix','Torres','1997-01-11'),(57,'Equador','Robert','Arboleda','1991-10-22'),(58,'Equador','Xavier','Arreaga','1994-09-28'),(59,'Equador','Jackson','Porozo','2000-08-04'),(60,'Equador','Angelo','Preciado','1998-02-18'),(61,'Equador','Pervis','Estupiñán','1998-01-21'),(62,'Equador','William','Pacho','2001-10-16'),(63,'Equador','Diego','Palacios','1999-07-12'),(64,'Equador','Moisés','Caicedo','2001-11-02'),(65,'Equador','Carlos','Gruezo','1995-04-19'),(66,'Equador','Jhegson','Méndez','1997-04-26'),(67,'Equador','Alan','Franco','1996-10-11'),(68,'Equador','José','Cifuentes','1999-05-12'),(69,'Equador','Ángel','Mena','1988-01-21'),(70,'Equador','Gonzalo','Plata','2000-11-01'),(71,'Equador','Jeremy','Sarmiento','2002-07-16'),(72,'Equador','Romario','Ibarra','1994-09-24'),(73,'Equador','Ayrton','Preciado','1994-07-17'),(74,'Equador','Énner','Valencia','1989-11-04'),(75,'Equador','Michael','Estrada','1996-04-07'),(76,'Equador','Djorkaeff','Reasco','1999-01-18'),(77,'Equador','Kevin','Rodríguez','2000-05-04'),(78,'Brasil','Alisson','Becker','1992-10-02'),(79,'Brasil','Weverton','Pereira da Silva','1987-12-13'),(80,'Brasil','Ederson','Santana de Moraes','1993-08-17'),(81,'Brasil','Danilo','Luiz da Silva','1991-07-15'),(82,'Brasil','Thiago','Silva','1984-09-22'),(83,'Brasil','Marcos','Aoás Corrêa','1994-03-14'),(84,'Brasil','Alex','Sandro Lobo Silva','1991-01-26'),(85,'Brasil','Dani','Alves','1983-03-06'),(86,'Brasil','Éder','Gabriel Militão','1998-01-18'),(87,'Brasil','Alex','Nicolao Telles','1992-12-15'),(88,'Brasil','Gleison','Bremer Silva Nascimento','1997-05-18'),(89,'Brasil','Carlos','Henrique Casimiro','1992-02-23'),(90,'Brasil','Lucas','olentino Coelho de Lima','1997-08-27'),(91,'Brasil','Frederico','Rodrigues de Paula Santos','1993-05-05'),(92,'Brasil','Bruno','Guimarães Rodrigues Moura','1997-11-16'),(93,'Brasil','Éverton','Augusto de Barros Ribeiro','1989-04-10'),(94,'Brasil','Richarlison','de Andrade','1997-03-10'),(95,'Brasil','Neymar','da Silva Santos Júnior','1992-02-05'),(96,'Brasil','Raphael','Dias Belloli','1996-12-14'),(97,'Brasil','Gabriel','Fernando de Jesus','1997-04-03'),(98,'Brasil','Antony','Matheus dos Santos','2000-02-14'),(99,'Brasil','Vinícius','José Paixão de Oliveira Júnior','2000-07-12'),(100,'Brasil','Rodrygo','Silva de Goes','2001-01-09'),(101,'Brasil','Pedro','Guilherme Abreu dos Santos','1997-06-20'),(102,'Brasil','Gabriel',' Teodoro Martinelli Silva','2001-06-18'),(103,'Brasil','Edson','Arantes do Nascimento','1940-10-23');
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
INSERT INTO `jogadores_da_partida` VALUES (1,28,1),(1,53,1),(1,30,2),(1,36,2),(1,59,2),(1,60,2),(1,31,3),(1,37,3),(1,55,3),(1,61,3),(1,40,4),(1,50,4),(1,64,4),(1,66,4),(1,34,5),(1,56,5),(1,38,6),(1,39,6),(1,72,6),(1,75,6),(1,77,6),(1,44,7),(1,46,7),(1,47,7),(1,48,7),(1,70,7),(1,71,7),(1,74,7);
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
INSERT INTO `partida` VALUES (1,'2022-11-25',3,1,3);
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
INSERT INTO `partidas_da_edicao` VALUES (1,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posicao`
--

LOCK TABLES `posicao` WRITE;
/*!40000 ALTER TABLE `posicao` DISABLE KEYS */;
INSERT INTO `posicao` VALUES (1,'Goleiro'),(2,'Lateral Direito'),(3,'Lateral Esquerdo'),(4,'Zagueiro'),(5,'Volante'),(6,'Meia'),(7,'Atacante'),(8,'Defesa');
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
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selecao`
--

LOCK TABLES `selecao` WRITE;
/*!40000 ALTER TABLE `selecao` DISABLE KEYS */;
INSERT INTO `selecao` VALUES (1,'Holanda',1),(2,'Senegal',1),(3,'Equador',1),(4,'Catar',1),(5,'Inglaterra',1),(6,'Estados Unidos',1),(7,'Irã',1),(8,'Gales',1),(9,'Argentina',1),(10,'Polonia',1),(11,'Mexico',1),(12,'Arábia Saudita',1),(13,'França',1),(14,'Austrália',1),(15,'Tunísia',1),(16,'Dinamarca',1),(17,'Japão',1),(18,'Espanha',1),(19,'Alemanha',1),(20,'Costa Rica',1),(21,'Marrocos',1),(22,'Croácia',1),(23,'Bélgica',1),(24,'Canadá',1),(25,'Brasil',1),(26,'Suiça',1),(27,'Camarões',1),(28,'Servia',1),(29,'Portugal',1),(30,'Coreia do Sul',1),(31,'Uruguai',1),(32,'Gana',1),(35,'Brasil',3),(36,'Brasil',4),(37,'Brasil',5),(38,'Brasil',2);
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
INSERT INTO `selecao_do_jogador` VALUES (4,1),(4,2),(4,3),(4,4),(4,5),(4,6),(4,7),(4,8),(4,9),(4,10),(4,11),(4,12),(4,13),(4,14),(4,15),(4,16),(4,17),(4,18),(4,19),(4,20),(4,21),(4,22),(4,23),(4,24),(4,25),(4,26),(1,27),(1,28),(1,29),(1,30),(1,31),(1,32),(1,33),(1,34),(1,35),(1,36),(1,37),(1,38),(1,39),(1,40),(1,41),(1,42),(1,43),(1,44),(1,45),(1,46),(1,47),(1,48),(1,49),(1,50),(1,51),(3,52),(3,53),(3,54),(3,55),(3,56),(3,57),(3,58),(3,59),(3,60),(3,61),(3,62),(3,63),(3,64),(3,65),(3,66),(3,67),(3,68),(3,69),(3,70),(3,71),(3,72),(3,73),(3,74),(3,75),(3,76),(3,77),(25,78),(25,79),(25,80),(25,81),(25,82),(25,83),(25,84),(25,85),(25,86),(25,87),(25,88),(25,89),(38,89),(25,90),(25,91),(38,91),(25,92),(25,93),(25,94),(25,95),(38,95),(25,96),(25,97),(25,98),(25,99),(25,100),(25,101),(25,102),(35,103);
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
INSERT INTO `selecao_do_tecnico` VALUES (4,1),(1,2),(25,3);
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES (1,'Espanha','Felix','Sanchez','1975-12-13'),(2,'Holanda','Louis','Van Gaal','1951-08-08'),(3,'Brasil','Adenor','Leonardo Bacchi','1961-03-25');
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

-- Dump completed on 2022-12-17 14:02:32
