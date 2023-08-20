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
-- Table structure for table `document_types`
--

DROP TABLE IF EXISTS `document_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document_types` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(110) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document_types`
--

LOCK TABLES `document_types` WRITE;
/*!40000 ALTER TABLE `document_types` DISABLE KEYS */;
INSERT INTO `document_types` VALUES 
(1,'RG','Carteira de Identidade',NULL,NULL),
(2,'CPF','Cadastro de Pessoas Físicas',NULL,NULL),
(3,'CNH','Carteira Nacional de Habilitação',NULL,NULL),
(4,'Passaporte','Passaporte brasileiro emitido pela Polícia Federal ou pelo Ministério das Relações Exteriores',NULL,NULL),
(5,'Carteira de Identidade Profissional','Carteira de Identidade Profissional emitida por entidades de classe (OAB, CRM, CRBio, CREA)',NULL,NULL),
(6,'SIAPE','Sistema Integrado de Administração de Pessoal',NULL,NULL),
(7,'Ficha de Inscrição - Formulário','',NULL,NULL),
(8,'Termo de cessão de direitos','',NULL,NULL),
(9,'Comprobatório do currículo','',NULL,NULL),
(10,'Diploma de maior titulação','',NULL,NULL),
(11,'Comprovante de residência','',NULL,NULL),
(12,'Comprovante de experiência no magistério no ensino superior','',NULL,NULL),
(13,'Comprovante de quitação eleitoral','',NULL,NULL),
(14,'Certificado de reservista','',NULL,NULL),
(15,'Certidão de casamento','',NULL,NULL),
(16,'Ficha de qualificação','',NULL,NULL),
(17,'Experiência - Prática em atividades de processos EAD','',NULL,NULL),
(18,'Experiência - Participação  na  produção  de  materiais didáticos','',NULL,NULL),
(19,'Experiência - Atividades de apoio ao ensino: planejamento pedagógico, coordenação','',NULL,NULL),
(20,'Experiência - Experiência  com  formatação  e  uso  de ambientes virtuais de aprendizagem','',NULL,NULL);
/*!40000 ALTER TABLE `document_types` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-20  2:01:04
