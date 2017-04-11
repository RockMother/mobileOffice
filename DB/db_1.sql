CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `authority` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_users` (`user_id`),
  CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `birthday` date NOT NULL,
  `passport` varchar(20) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `locked` bit(1) DEFAULT NULL,
  `locked_by_admin` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE manager (
   id BIGINT AUTO_INCREMENT,
   user_id BIGINT,
  CONSTRAINT fk_manager_user_id FOREIGN KEY (user_id) REFERENCES mobileoffice.users (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
  PRIMARY KEY (id)
) ENGINE = InnoDB ROW_FORMAT = DEFAULT;

CREATE TABLE `tariff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(20) NOT NULL,
  `tariff_id` bigint(20) NOT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  `is_blocked` bit(1) NOT NULL,
  `is_admin_blocker` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_id_tariff_id` (`tariff_id`),
  KEY `fk_contract_id_client_id` (`client_id`),
  CONSTRAINT `fk_contract_id_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `fk_contract_id_tariff_id` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `options` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` decimal(10,0) NOT NULL,
  `intial_price` decimal(10,0) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `contract_option_rsp` (
  `id` bigint(20) NOT NULL,
  `contract_id` bigint(20) DEFAULT NULL,
  `option_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_option_rsp_contract_id` (`contract_id`),
  KEY `fk_contract_option_rsp_option_id` (`option_id`),
  CONSTRAINT `fk_contract_option_rsp_contract_id` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`),
  CONSTRAINT `fk_contract_option_rsp_option_id` FOREIGN KEY (`option_id`) REFERENCES `options` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tariff_options_rsp` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tariff_id` bigint(20) DEFAULT NULL,
  `tariff_option_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tariff_id` (`tariff_id`),
  KEY `fk_tariff_option_id` (`tariff_option_id`),
  CONSTRAINT `fk_tariff_id` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`),
  CONSTRAINT `fk_tariff_option_id` FOREIGN KEY (`tariff_option_id`) REFERENCES `options` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE VIEW `mobileoffice`.`v_contract_with_tariff` AS select `c`.`id` AS `id`,`t`.`name` AS `name`,`c`.`number` AS `number`,`c`.`is_blocked` AS `is_blocked`,`c`.`is_admin_blocker` AS `is_admin_blocker`,`c`.`client_id` AS `client_id`,`cl`.`user_id` AS `user_id` from ((`mobileoffice`.`contract` `c` join `mobileoffice`.`tariff` `t` on((`c`.`tariff_id` = `t`.`id`))) join `mobileoffice`.`client` `cl` on((`cl`.`id` = `c`.`client_id`)));

CREATE  VIEW `mobileoffice`.`v_tariff_with_options` AS select `t`.`name` AS `name`,`t`.`id` AS `id`,`t`.`price` AS `price`,`opt`.`name` AS `option_name`,`opt`.`price` AS `OPTION_PRICE`,`opt`.`intial_price` AS `intial_price` from ((`mobileoffice`.`tariff` `t` left join `mobileoffice`.`tariff_options_rsp` `rsp` on((`t`.`id` = `rsp`.`tariff_id`))) left join `mobileoffice`.`options` `opt` on((`opt`.`id` = `rsp`.`tariff_option_id`)));





