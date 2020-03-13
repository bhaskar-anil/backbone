CREATE TABLE `t_task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `budget_amount` int(11) DEFAULT NULL,
  `budget_hours` int(11) DEFAULT NULL,
  `budget_type` int(11) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `details` text,
  `due_date` date DEFAULT NULL,
  `due_time` int(11) DEFAULT NULL,
  `must_haves` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `task_type` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  `seeker_id` bigint(20) DEFAULT NULL,
  `sys_create_datetime` datetime NOT NULL,
  `sys_create_program` varchar(255) DEFAULT NULL,
  `sys_create_staff` varchar(255) DEFAULT NULL,
  `sys_delete_flag` bit(1) DEFAULT NULL,
  `sys_update_datetime` datetime DEFAULT NULL,
  `sys_update_program` varchar(255) DEFAULT NULL,
  `sys_update_staff` varchar(255) DEFAULT NULL,
  `sys_update_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_offer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `is_accepted` bit(1) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  `seeker_id` bigint(20) DEFAULT NULL,
  `sys_create_datetime` datetime NOT NULL,
  `sys_create_program` varchar(255) DEFAULT NULL,
  `sys_create_staff` varchar(255) DEFAULT NULL,
  `sys_delete_flag` bit(1) DEFAULT NULL,
  `sys_update_datetime` datetime DEFAULT NULL,
  `sys_update_program` varchar(255) DEFAULT NULL,
  `sys_update_staff` varchar(255) DEFAULT NULL,
  `sys_update_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` text,
  `offer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `sys_create_datetime` datetime NOT NULL,
  `sys_create_program` varchar(255) DEFAULT NULL,
  `sys_create_staff` varchar(255) DEFAULT NULL,
  `sys_delete_flag` bit(1) DEFAULT NULL,
  `sys_update_datetime` datetime DEFAULT NULL,
  `sys_update_program` varchar(255) DEFAULT NULL,
  `sys_update_staff` varchar(255) DEFAULT NULL,
  `sys_update_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sys_update_count` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `valid_tasker` bit(1) DEFAULT NULL,
  `sys_create_datetime` datetime NOT NULL,
  `sys_create_program` varchar(255) DEFAULT NULL,
  `sys_create_staff` varchar(255) DEFAULT NULL,
  `sys_delete_flag` bit(1) DEFAULT NULL,
  `sys_update_datetime` datetime DEFAULT NULL,
  `sys_update_program` varchar(255) DEFAULT NULL,
  `sys_update_staff` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i6qjjoe560mee5ajdg7v1o6mi` (`email`),
  UNIQUE KEY `UK_m5bu5erj83eubjsa1nyms0t89` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `vicinity` text,
  `tasker_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `sys_create_datetime` datetime NOT NULL,
  `sys_create_program` varchar(255) DEFAULT NULL,
  `sys_create_staff` varchar(255) DEFAULT NULL,
  `sys_delete_flag` bit(1) DEFAULT NULL,
  `sys_update_datetime` datetime DEFAULT NULL,
  `sys_update_program` varchar(255) DEFAULT NULL,
  `sys_update_staff` varchar(255) DEFAULT NULL,
  `sys_update_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gid` varchar(255) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `place_id` varchar(255) DEFAULT NULL,
  `vicinity` varchar(255) DEFAULT NULL,
  `sys_create_datetime` datetime NOT NULL,
  `sys_create_program` varchar(255) DEFAULT NULL,
  `sys_create_staff` varchar(255) DEFAULT NULL,
  `sys_delete_flag` bit(1) DEFAULT NULL,
  `sys_update_datetime` datetime DEFAULT NULL,
  `sys_update_program` varchar(255) DEFAULT NULL,
  `sys_update_staff` varchar(255) DEFAULT NULL,
  `sys_update_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` text,
  `offer_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `sys_create_datetime` datetime NOT NULL,
  `sys_create_program` varchar(255) DEFAULT NULL,
  `sys_create_staff` varchar(255) DEFAULT NULL,
  `sys_delete_flag` bit(1) DEFAULT NULL,
  `sys_update_datetime` datetime DEFAULT NULL,
  `sys_update_program` varchar(255) DEFAULT NULL,
  `sys_update_staff` varchar(255) DEFAULT NULL,
  `sys_update_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






