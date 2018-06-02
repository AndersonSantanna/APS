-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: Game
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

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

DROP DATABASE IF EXISTS `Game`;
CREATE DATABASE `Game`;
USE `Game`;

--
-- Table structure for table `Arvores`
--

DROP TABLE IF EXISTS `Arvores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Arvores` (
  `IdArvore` int(11) NOT NULL AUTO_INCREMENT,
  `ExpArvore` double(4,2) NOT NULL,
  `NivelArvore` int(11) NOT NULL,
  `IdJogador` int(11) NOT NULL,
  `NomeArvore` varchar(45) NOT NULL,
  `QtdPodar` int(11) NOT NULL,
  `QtdRegar` int(11) NOT NULL,
  `QtdDedetizar` int(11) NOT NULL,
  `QtdAdubar` int(11) NOT NULL,
  PRIMARY KEY (`IdArvore`),
  KEY `IdJogador` (`IdJogador`),
  CONSTRAINT `Arvores_ibfk_1` FOREIGN KEY (`IdJogador`) REFERENCES `Players` (`IdJogador`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Players`
--

DROP TABLE IF EXISTS `Players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Players` (
  `IdJogador` int(11) NOT NULL AUTO_INCREMENT,
  `NomeJogador` varchar(350) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Senha` varchar(500) NOT NULL,
  `Idade` int(8) NOT NULL,
  `Sexo` varchar(15) NOT NULL,
  PRIMARY KEY (`IdJogador`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Questoes`
--

DROP TABLE IF EXISTS `Questoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Questoes` (
  `IdQuestao` int(11) NOT NULL AUTO_INCREMENT,
  `questao` varchar(1000) DEFAULT NULL,
  `IdRespostaCorreta` int(11) NOT NULL,
  PRIMARY KEY (`IdQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questoes`
--

LOCK TABLES `Questoes` WRITE;
/*!40000 ALTER TABLE `Questoes` DISABLE KEYS */;
INSERT INTO `Questoes` VALUES (1,'Qual das alternativas descreve melhor o processo conhecido por Reciclagem?',4),(2,'Como separar corretamente seu lixo?',6),(3,'O que é coleta seletiva?',9);
/*!40000 ALTER TABLE `Questoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Respostas`
--

DROP TABLE IF EXISTS `Respostas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Respostas` (
  `IdResposta` int(11) NOT NULL AUTO_INCREMENT,
  `IdQuestao` int(11) NOT NULL,
  `resposta` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`IdResposta`),
  KEY `IdQuestao` (`IdQuestao`),
  CONSTRAINT `Respostas_ibfk_1` FOREIGN KEY (`IdQuestao`) REFERENCES `Questoes` (`IdQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Respostas`
--

LOCK TABLES `Respostas` WRITE;
/*!40000 ALTER TABLE `Respostas` DISABLE KEYS */;
INSERT INTO `Respostas` VALUES (1,1,'“Jogar fora” o lixo produzido.'),(2,1,'Coletar todo tipo de material existente em lixos recicláveis.'),(3,1,'Nome dado para todo o processo do lixo após seu descarte.'),(4,1,'Processo de transformação de materiais usados em novos produtos para consumo.'),(5,2,'Juntar tudo na lixeira, pois os prédios já fazem o trabalho de separação.\n'),(6,2,'Separar o lixo orgânico (restos de alimentos, papel sujo e lixo sanitário) dos resíduos sólidos (como plástico, vidro, papel, metal e embalagens longa vida).\n'),(7,2,'Deixar plásticos sujos junto com lixo orgânico.'),(8,2,'Juntar todo tipo de lixo e descartar em ponto de coleta.'),(9,3,'Processo de separação e recolhimento dos resíduos para o reaproveitamento por meio de reciclagem.'),(10,3,'Destinação de resíduos para lixões e aterros.'),(11,3,'Processo de envio de todo o lixo produzido para cooperativas ou entrega para catadores de rua.'),(12,3,'A escolha aleatória do melhor lixo produzido.');
/*!40000 ALTER TABLE `Respostas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-02 10:07:38
