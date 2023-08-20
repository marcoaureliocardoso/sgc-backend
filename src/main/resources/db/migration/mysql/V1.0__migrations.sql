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
-- Table structure for table `migrations`
--

DROP TABLE IF EXISTS `migrations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `migrations` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `migrations`
--

LOCK TABLES `migrations` WRITE;
/*!40000 ALTER TABLE `migrations` DISABLE KEYS */;
INSERT INTO `migrations` VALUES 
(1,'2019_12_14_000001_create_personal_access_tokens_table',1),
(2,'2021_06_28_205316_create_user_types_table',1),
(3,'2021_06_28_215159_create_roles_table',1),
(4,'2021_06_29_100000_create_password_resets_table',1),
(5,'2021_06_30_000000_create_failed_jobs_table',1),
(6,'2021_07_02_205347_create_document_types_table',1),
(7,'2021_07_03_225525_create_employees_table',1),
(8,'2021_07_04_000000_create_users_table',1),(9,'2021_07_06_000730_create_courses_table',1),
(10,'2021_07_10_024556_create_poles_table',1),
(11,'2021_07_10_061533_create_bonds_table',1),
(12,'2021_07_12_014427_create_applicants_table',1),
(13,'2021_07_14_175000_create_documents_table',1),
(14,'2021_07_27_234254_create_jobs_table',1),
(15,'2021_07_28_014111_create_notifications_table',1),
(16,'2021_08_17_165212_create_responsibilities_table',1),
(17,'2022_08_03_184221_create_bank_accounts_table',1),
(18,'2022_08_03_185525_create_qualifications_table',1),
(19,'2022_08_23_142221_create_institutional_details_table',1),
(20,'2022_08_29_125609_create_activity_log_table',1),
(21,'2022_10_07_203521_create_course_classes_table',1),
(22,'2022_10_25_110433_create_impediments_table',1),
(23,'2022_10_25_111433_create_bond_course_class_table',1),
(24,'2022_10_25_111733_create_phones_table',1),
(25,'2022_10_25_112333_create_bond_course_table',1),
(26,'2022_10_25_112533_create_bond_pole_table',1),
(27,'2022_10_25_112633_create_spouses_table',1),
(28,'2022_10_25_112733_create_addresses_table',1),
(29,'2022_10_25_112933_create_personal_details_table',1),
(30,'2022_10_25_113233_create_identities_table',1);
/*!40000 ALTER TABLE `migrations` ENABLE KEYS */;
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
