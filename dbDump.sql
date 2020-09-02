/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.19 : Database - alumini
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`alumini` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `alumini`;

/*Table structure for table `t_alm_industry` */

DROP TABLE IF EXISTS `t_alm_industry`;

CREATE TABLE `t_alm_industry` (
  `industry_id` int NOT NULL AUTO_INCREMENT,
  `industryName` varchar(100) DEFAULT NULL,
  `industryDescription` varchar(100) DEFAULT NULL,
  `industryCreatedDate` datetime DEFAULT NULL,
  `industryCreateBy` varchar(100) DEFAULT NULL,
  `industryModifiedDate` datetime DEFAULT NULL,
  `industryModifiedBy` varchar(10) DEFAULT NULL,
  `industryStatus` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`industry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
