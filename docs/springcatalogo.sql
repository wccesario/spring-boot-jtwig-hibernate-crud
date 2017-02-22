# Host: localhost  (Version 5.6.26)
# Date: 2017-02-22 00:03:49
# Generator: MySQL-Front 5.3  (Build 5.21)

/*!40101 SET NAMES latin1 */;

#
# Structure for table "categoria"
#

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "categoria"
#

INSERT INTO `categoria` VALUES (1,'Games'),(2,'DVD'),(3,'Blu Ray'),(4,'Rap');

#
# Structure for table "produto"
#

DROP TABLE IF EXISTS `produto`;
CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `categoria_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKopu9jggwnamfv0c8k2ri3kx0a` (`categoria_id`),
  CONSTRAINT `FKopu9jggwnamfv0c8k2ri3kx0a` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "produto"
#

INSERT INTO `produto` VALUES (1,'Nintendo Switch !',20,1),(2,'Mario Kart 8 Deluxe',20,3),(3,'Shin Gojira',30,3);
