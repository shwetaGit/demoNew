DROP TABLE IF EXISTS `art_menu`;

CREATE TABLE `art_menu` (`menu_id` INT(11) NOT NULL AUTO_INCREMENT,`menu_tree_id` VARCHAR(256) NOT NULL, `menu_icon` VARCHAR(256) DEFAULT NULL,`menu_action` VARCHAR(256) NOT NULL,`menu_commands` VARCHAR(256) DEFAULT NULL,`display` TINYINT(1) DEFAULT '1',`head_menu` TINYINT(1) DEFAULT '1',`menu_label` VARCHAR(256) DEFAULT NULL,`ui_type` VARCHAR(2) DEFAULT NULL,`updated_by` INT(11) DEFAULT NULL,`updated_date` DATETIME DEFAULT NULL,`created_by` INT(11) DEFAULT NULL,`created_date` DATETIME DEFAULT NULL,`version_id` INT(11) DEFAULT NULL,`active_status` TINYINT(1) DEFAULT '1',`project_id` VARCHAR(256) ,`project_version_id` VARCHAR(256),`app_creator_id` VARCHAR(256) DEFAULT NULL,`reff_id` INT(11) DEFAULT NULL,  PRIMARY KEY (`menu_id`));

