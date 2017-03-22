CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `birthdate` date NOT NULL,
  `passport` varchar(20) NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `password_hash` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `client_contract` (
  `id` bigint(20) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `contract_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `client_id` (`client_id`),
  KEY `contract_id` (`contract_id`),
  CONSTRAINT `client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `contract_id` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `contract` (
  `id` bigint(20) NOT NULL,
  `number` varchar(20) NOT NULL,
  `tariff_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contract_id_tariff_id` (`tariff_id`),
  CONSTRAINT `fk_contract_id_tariff_id` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tariff` (
  `id` bigint(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tariff_option` (
  `id` bigint(20) NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `intial_price` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tariff_tariff_option` (
  `id` bigint(20) NOT NULL,
  `tariff_id` bigint(20) DEFAULT NULL,
  `tariff_option_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tariff_id` (`tariff_id`),
  KEY `fk_tariff_option_id` (`tariff_option_id`),
  CONSTRAINT `fk_tariff_id` FOREIGN KEY (`tariff_id`) REFERENCES `tariff` (`id`),
  CONSTRAINT `fk_tariff_option_id` FOREIGN KEY (`tariff_option_id`) REFERENCES `tariff_option` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

