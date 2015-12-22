DROP TABLE IF EXISTS `art_user_menu`;

CREATE TABLE `art_user_menu` (  `user_id` varchar(256) NOT NULL, `menu_id` int(11) NOT NULL, `updated_by` int(11) DEFAULT NULL, `updated_date` datetime DEFAULT NULL,  `created_by` int(11) DEFAULT NULL,  `created_date` datetime DEFAULT NULL, `version_id` int(11) DEFAULT NULL,  `active_status` tinyint(1) DEFAULT '1',`project_id` varchar(256) DEFAULT NULL, `project_version_id` varchar(256) DEFAULT NULL,  `app_creator_id` varchar(256) DEFAULT NULL);

