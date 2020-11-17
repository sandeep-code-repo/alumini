/*Data for the table `dropdown_industry_category` */

insert  into `dropdown_industry_category`(`industry_cat_id`,`industry_cat_name`,`industry_cat_status`,`created_by`,`created_dt`) values 
(1,'Non 17 categories',TRUE,'System',CURRENT_TIMESTAMP),
(2,'Public Location',TRUE,'System',CURRENT_TIMESTAMP),
(3,'Rivers',TRUE,'System',CURRENT_TIMESTAMP),
(4,'Iron and Steel',TRUE,'System',CURRENT_TIMESTAMP),
(5,'Integrated Steels',TRUE,'System',CURRENT_TIMESTAMP),
(6,'Sponge Iron Plants(Stand Alone)',TRUE,'System',CURRENT_TIMESTAMP),
(7,'Alumina Refinery',TRUE,'System',CURRENT_TIMESTAMP),
(8,'Automobile Tyre',TRUE,'System',CURRENT_TIMESTAMP),
(9,'Calcined Petroleum Coke',TRUE,'System',CURRENT_TIMESTAMP),
(10,'CBWTF',TRUE,'System',CURRENT_TIMESTAMP),
(11,'CHWTSDF',TRUE,'System',CURRENT_TIMESTAMP),
(12,'Ferro Alloys',TRUE,'System',CURRENT_TIMESTAMP),
(13,'Iron Ore Pellet',TRUE,'System',CURRENT_TIMESTAMP),
(14,'Refactory',TRUE,'System',CURRENT_TIMESTAMP),
(15,'Iron Ore Mines',TRUE,'System',CURRENT_TIMESTAMP),
(16,'Iron and Manganese Mines',TRUE,'System',CURRENT_TIMESTAMP),
(17,'Pulp and Paper',TRUE,'System',CURRENT_TIMESTAMP),
(18,'Coke Making',TRUE,'System',CURRENT_TIMESTAMP),
(19,'Power Plant',TRUE,'System',CURRENT_TIMESTAMP),
(20,'Sugar',TRUE,'System',CURRENT_TIMESTAMP),
(21,'Chemicals',TRUE,'System',CURRENT_TIMESTAMP),
(22,'Mines',TRUE,'System',CURRENT_TIMESTAMP),
(23,'Cholo Alkali',TRUE,'System',CURRENT_TIMESTAMP),
(24,'High Carbon Ferro Chrome/ Charge Chrome Plant',TRUE,'System',CURRENT_TIMESTAMP),
(25,'Copper Smelting',TRUE,'System',CURRENT_TIMESTAMP),
(26,'Distillery',TRUE,'System',CURRENT_TIMESTAMP),
(27,'Orange',TRUE,'System',CURRENT_TIMESTAMP),
(28,'Petroleum Refinery',TRUE,'System',CURRENT_TIMESTAMP),
(29,'Chromite Mining',TRUE,'System',CURRENT_TIMESTAMP),
(30,'Pharmaceutical',TRUE,'System',CURRENT_TIMESTAMP),
(31,'Mining',TRUE,'System',CURRENT_TIMESTAMP),
(32,'Pesticide',TRUE,'System',CURRENT_TIMESTAMP),
(33,'Cement',TRUE,'System',CURRENT_TIMESTAMP),
(34,'Dyes and Dye Intermediate',TRUE,'System',CURRENT_TIMESTAMP),
(35,'Chromite Mines',TRUE,'System',CURRENT_TIMESTAMP),
(36,'Iron Ore Mines',TRUE,'System',CURRENT_TIMESTAMP),
(37,'Aluminium Smelter',TRUE,'System',CURRENT_TIMESTAMP)

/*Data for the table `mail_header` */
insert  into `mail_header`(`mail_subject`,`mail_body`,`mail_filter`,`created_by`,`created_dt`) values 
('OSASP Password Reset request','Seems like you forgot your password for your CPCB account. Use the button below to reset it. ','change password','System',CURRENT_TIMESTAMP),
('APCB Query submit confirmation','Your query has been submitted successfully.
 Our team is currently looking into the matter and will be in contact with you as soon as possible.','Help Query','System',CURRENT_TIMESTAMP)


/*Data for the table `user_role` */
insert  into `role`(`role_name`,`role_status`,`role_desc`,`created_by`,`created_dt`) values 
('Super Admin',true,'Super Admin role','System',CURRENT_TIMESTAMP),
('Admin',true,'Admin role','System',CURRENT_TIMESTAMP),
('User',true,'User role','System',CURRENT_TIMESTAMP)

/*Data for the table `real_pollutant_level_infos` */
INSERT INTO alumini.real_pollutant_level_infos (plant_id, analyzer, station_id, parameter_code, recorded_time, recorded_level, aggregation, threshold_level) 
	VALUES ('hindalco_lpng', 'AAQ', 'AAQMS-1', 'NO2', '2020-11-13 21:16:00.0', 13.36, '1Hr', 0.00);	
INSERT INTO alumini.real_pollutant_level_infos (plant_id, analyzer, station_id, parameter_code, recorded_time, recorded_level, aggregation, threshold_level) 
	VALUES ('hindalco_lpng', 'Stack', 'CEMS-5', 'PM', '2020-11-13 21:13:00.0', 6.73, '1Hr', 0.00);
INSERT INTO alumini.real_pollutant_level_infos (plant_id, analyzer, station_id, parameter_code, recorded_time, recorded_level, aggregation, threshold_level) 
	VALUES ('hindalco_lpng', 'Water', 'EQMS-1', 'PH', '2020-11-13 21:13:00.0', 7.09, '1Hr', 0.00);

