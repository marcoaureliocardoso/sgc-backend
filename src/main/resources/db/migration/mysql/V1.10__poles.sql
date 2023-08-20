-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sgc
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `poles`
--

DROP TABLE IF EXISTS `poles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poles` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(110) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poles`
--

LOCK TABLES `poles` WRITE;
/*!40000 ALTER TABLE `poles` DISABLE KEYS */;
INSERT INTO `poles` VALUES 
(1,'SEAD','Superintendência de Educação a Distância',NULL,NULL),
(2,'Vitória','Polo de Vitória',NULL,NULL),
(3,'Afonso Cláudio','Polo de Afonso Cláudio',NULL,NULL),
(4,'Alegre','Polo de Alegre',NULL,NULL),
(5,'Aracruz','Polo de Aracruz',NULL,NULL),
(6,'Baixo Guandu','Polo de Baixo Guandu',NULL,NULL),
(7,'Bom Jesus do Norte','Polo de Bom Jesus do Norte',NULL,NULL),
(8,'Cachoeiro de Itapemirim','Polo de Cachoeiro de Itapemirim',NULL,NULL),
(9,'Castelo','Polo de Castelo',NULL,NULL),
(10,'Colatina','Polo de Colatina',NULL,NULL),
(11,'Conceição da Barra','Polo de Conceição da Barra',NULL,NULL),
(12,'Domingos Martins','Polo de Domingos Martins',NULL,NULL),
(13,'Ecoporanga','Polo de Ecoporanga',NULL,NULL),
(14,'Itapemirim','Polo de Itapemirim',NULL,NULL),
(15,'Iúna','Polo de Iúna',NULL,NULL),
(16,'Linhares','Polo de Linhares',NULL,NULL),
(17,'Mantenópolis','Polo de Mantenópolis',NULL,NULL),
(18,'Mimoso do Sul','Polo de Mimoso do Sul',NULL,NULL),
(19,'Montanha','Polo de Montanha',NULL,NULL),
(20,'Nova Venécia','Polo de Nova Venécia',NULL,NULL),
(21,'Pinheiros','Polo de Pinheiros',NULL,NULL),
(22,'Piúma','Polo de Piúma',NULL,NULL),
(23,'Santa Leopoldina','Polo de Santa Leopoldina',NULL,NULL),
(24,'Santa Teresa','Polo de Santa Teresa',NULL,NULL),
(25,'São Mateus','Polo de São Mateus',NULL,NULL),
(26,'Vargem Alta','Polo de Vargem Alta',NULL,NULL),
(27,'Venda Nova do Imigrante','Polo de Venda Nova do Imigrante',NULL,NULL),
(28,'Vila Velha','Polo de Vila Velha',NULL,NULL);
/*!40000 ALTER TABLE `poles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-20  2:01:06
