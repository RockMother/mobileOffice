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
  `birthdate` date NOT NULL,
  `passport` varchar(20) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_id` (`user_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE mobileoffice.manager (
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
  PRIMARY KEY (`id`),
  KEY `fk_contract_id_tariff_id` (`tariff_id`),
  KEY `fk_contract_id_client_id` (`client_id`),
  CONSTRAINT `fk_contract_id_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `fk_contract_id_tariff_id` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `options` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `price` decimal(10,0) NOT NULL,
  `intial_price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
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



