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

/*Table structure for table `industry` */

DROP TABLE IF EXISTS `industry`;

CREATE TABLE `industry` (
  `industry_id` int NOT NULL AUTO_INCREMENT,
  `industry_create_by` varchar(255) DEFAULT NULL,
  `industry_created_date` datetime(6) DEFAULT NULL,
  `industry_description` varchar(255) DEFAULT NULL,
  `industry_modified_by` varchar(255) DEFAULT NULL,
  `industry_modified_date` datetime(6) DEFAULT NULL,
  `industry_name` varchar(255) DEFAULT NULL,
  `industry_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`industry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `industry` */

LOCK TABLES `industry` WRITE;

UNLOCK TABLES;

/*Table structure for table `industry_registration` */

DROP TABLE IF EXISTS `industry_registration`;

CREATE TABLE `industry_registration` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `regional_office` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `industry_registration` */

LOCK TABLES `industry_registration` WRITE;

insert  into `industry_registration`(`id`,`name`,`address`,`category`,`regional_office`,`status`) values 
(13,'M/s. Bhubaneshwar Power Pvt. Ltd.','At-Anantapur,Po- Dhurusia, Cuttack, Pin-754027','power plant','Cuttack','Status'),
(14,'M/s. Bhusan Energy Ltd.','At- Ganthigadia, PO- Nuahat, Via- Banarpal, Dist - Angul -759128','power plant','angul','Register'),
(27,'M/s. FACOR Power Ltd.','At- D.P. nagar, Po - Randia, Dist - Bhadrak - 765135','power plant','Balasore','Register'),
(29,'M/s. GMR Kamalanga Energy Ltd.','At/Po - Kamalanga, Via - Meramandali, Dist - Dhenkanal - 759 121','power plant','Angul','Status'),
(38,'M/s. Indian Metals & Ferro Alloys Ltd. (120 MW)','Po-Kapaleswar, Choudwar, Dist-Cuttack-754 071','power plant','Cuttack','Status');

UNLOCK TABLES;

/*Table structure for table `parameter_info` */

DROP TABLE IF EXISTS `parameter_info`;

CREATE TABLE `parameter_info` (
  `para_id` int NOT NULL AUTO_INCREMENT,
  `sid` int DEFAULT NULL,
  `paramter` varchar(30) DEFAULT NULL,
  `analyser_make` varchar(30) DEFAULT NULL,
  `analyser_model` varchar(30) DEFAULT NULL,
  `analyser_serial_number` varchar(30) DEFAULT NULL,
  `devidce_IMEI_NUMBER` varchar(30) DEFAULT NULL,
  `MAC_ID` varchar(30) DEFAULT NULL,
  `measurement_MIN` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `measurement_MAX` varchar(30) DEFAULT NULL,
  `unit` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`para_id`),
  KEY `sid` (`sid`),
  CONSTRAINT `parameter_info_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `station_info` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `parameter_info` */

LOCK TABLES `parameter_info` WRITE;

insert  into `parameter_info`(`para_id`,`sid`,`paramter`,`analyser_make`,`analyser_model`,`analyser_serial_number`,`devidce_IMEI_NUMBER`,`MAC_ID`,`measurement_MIN`,`measurement_MAX`,`unit`) values 
(1,1,'eeeee','fff','vvvv','gggg','hhhh','yyyyy','iiii',NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `plant_info` */

DROP TABLE IF EXISTS `plant_info`;

CREATE TABLE `plant_info` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `plant_id` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(25) DEFAULT NULL,
  `pin` varchar(10) DEFAULT NULL,
  `plant_nm` varchar(100) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `district` varchar(50) DEFAULT NULL,
  `town` varchar(30) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `web` varchar(40) DEFAULT NULL,
  `zonal` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `group_id` varchar(50) DEFAULT NULL,
  `date_time_stamp` datetime DEFAULT NULL,
  `auth_person` varchar(30) DEFAULT NULL,
  `auth_person_mob` varchar(10) DEFAULT NULL,
  `auth_person_desig` varchar(20) DEFAULT NULL,
  `cpcb_usr` varchar(50) DEFAULT NULL,
  `cpcb_usr_email` varchar(50) DEFAULT NULL,
  `cpcb_usr_mob` varchar(50) DEFAULT NULL,
  `cpcb_usr2` varchar(50) DEFAULT NULL,
  `cpcb_usr_email2` varchar(50) DEFAULT NULL,
  `cpcb_usr_mob2` varchar(50) DEFAULT NULL,
  `lat_long` varchar(100) DEFAULT NULL,
  `connected` tinyint(1) DEFAULT NULL,
  `dept_email` varchar(50) DEFAULT NULL,
  `category` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT 'Industry',
  `plant_name` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `analyzer_count` int DEFAULT '0',
  `HQO_email` varchar(30) DEFAULT NULL,
  `inlet_url` varchar(150) DEFAULT NULL,
  `outlet_url` varchar(150) DEFAULT NULL,
  `ro_usr` varchar(50) DEFAULT NULL,
  `ro_usr_email` varchar(50) DEFAULT NULL,
  `ro_usr_mob` varchar(50) DEFAULT NULL,
  `plant_slug` varchar(200) DEFAULT NULL,
  `auth_req` int DEFAULT '1',
  `station_count` int DEFAULT '1',
  `uid` int DEFAULT NULL,
  `plant_vendor` varchar(30) DEFAULT NULL,
  `CAAQMS_Station` int DEFAULT NULL,
  `CEMS_Station` int DEFAULT NULL,
  `CEQMS_Station` int DEFAULT NULL,
  `secd_person` varchar(30) DEFAULT NULL,
  `secd_person_desig` varchar(30) DEFAULT NULL,
  `secd_person_mob` int DEFAULT NULL,
  `secd_email` varchar(30) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK1f4gxps4d5hwmnbidd0fcip67` (`uid`),
  CONSTRAINT `FK1f4gxps4d5hwmnbidd0fcip67` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

/*Data for the table `plant_info` */

LOCK TABLES `plant_info` WRITE;

insert  into `plant_info`(`pid`,`plant_id`,`password`,`pin`,`plant_nm`,`type`,`district`,`town`,`street`,`state`,`email`,`web`,`zonal`,`group_id`,`date_time_stamp`,`auth_person`,`auth_person_mob`,`auth_person_desig`,`cpcb_usr`,`cpcb_usr_email`,`cpcb_usr_mob`,`cpcb_usr2`,`cpcb_usr_email2`,`cpcb_usr_mob2`,`lat_long`,`connected`,`dept_email`,`category`,`plant_name`,`analyzer_count`,`HQO_email`,`inlet_url`,`outlet_url`,`ro_usr`,`ro_usr_email`,`ro_usr_mob`,`plant_slug`,`auth_req`,`station_count`,`uid`,`plant_vendor`,`CAAQMS_Station`,`CEMS_Station`,`CEQMS_Station`,`secd_person`,`secd_person_desig`,`secd_person_mob`,`secd_email`,`user_name`) values 
(1,'ddd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hindalco');

UNLOCK TABLES;

/*Table structure for table `station_info` */

DROP TABLE IF EXISTS `station_info`;

CREATE TABLE `station_info` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `plant_id` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT '',
  `station_id` varchar(30) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT '',
  `analyzer` varchar(5) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT '',
  `analyzerv2` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `short_name` varchar(30) DEFAULT NULL,
  `LOCATION` varchar(50) DEFAULT NULL,
  `install_date` date DEFAULT NULL,
  `token` varchar(500) DEFAULT NULL,
  `imei_mac_number` varchar(100) DEFAULT NULL,
  `station_number` int DEFAULT '0',
  `stn_type` varchar(20) DEFAULT '',
  `has_threshold` int DEFAULT '0',
  `pid` int DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `uid` int DEFAULT NULL,
  `station_vendor` varchar(30) DEFAULT NULL,
  `certification` varchar(30) DEFAULT NULL,
  `latitude` varchar(30) DEFAULT NULL,
  `longitute` varchar(30) DEFAULT NULL,
  `measurement_Principle` varchar(30) DEFAULT NULL,
  `stack_Height` varchar(30) DEFAULT NULL,
  `stack_Diameter` varchar(30) DEFAULT NULL,
  `stack_Velocity` varchar(30) DEFAULT NULL,
  `flue_gas_discharge_rate` varchar(30) DEFAULT NULL,
  `remarks` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `FKgnicywk7jt6jebocqic8k2g1s` (`uid`),
  CONSTRAINT `FKgnicywk7jt6jebocqic8k2g1s` FOREIGN KEY (`uid`) REFERENCES `user_info` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `station_info` */

LOCK TABLES `station_info` WRITE;

insert  into `station_info`(`sid`,`plant_id`,`station_id`,`analyzer`,`analyzerv2`,`short_name`,`LOCATION`,`install_date`,`token`,`imei_mac_number`,`station_number`,`stn_type`,`has_threshold`,`pid`,`user_id`,`uid`,`station_vendor`,`certification`,`latitude`,`longitute`,`measurement_Principle`,`stack_Height`,`stack_Diameter`,`stack_Velocity`,`flue_gas_discharge_rate`,`remarks`) values 
(1,'ddd','cccccc',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

UNLOCK TABLES;

/*Table structure for table `t_alm_user` */

DROP TABLE IF EXISTS `t_alm_user`;

CREATE TABLE `t_alm_user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `user_status` enum('ACTIVE','INACTIVE') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'ACTIVE',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `t_alm_user` */

LOCK TABLES `t_alm_user` WRITE;

insert  into `t_alm_user`(`user_id`,`user_name`,`password`,`created_by`,`created_date`,`user_status`) values 
(1,'admin','12345',NULL,NULL,'ACTIVE');

UNLOCK TABLES;

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(30) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `mob_no` varchar(15) DEFAULT NULL,
  `user_type` varchar(10) DEFAULT NULL,
  `plant_type` varchar(30) DEFAULT NULL,
  `category` varchar(20) NOT NULL DEFAULT 'Industry',
  `designation` varchar(20) NOT NULL DEFAULT '',
  `reportto` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

/*Data for the table `user_info` */

LOCK TABLES `user_info` WRITE;

insert  into `user_info`(`uid`,`user_id`,`user_name`,`password`,`email`,`department`,`mob_no`,`user_type`,`plant_type`,`category`,`designation`,`reportto`) values 
(90,'hindalco','hindalco','hindalco@123','hindaalco@gmail.com','Plant User','9090961413',NULL,NULL,'Industry','AGM','');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
