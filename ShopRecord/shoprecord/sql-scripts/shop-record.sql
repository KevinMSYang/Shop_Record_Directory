CREATE DATABASE IF NOT EXISTS `shop_record`;
USE `shop_record`;


-- ALTER TABLE `shoplist` DROP FOREIGN KEY `shoplist_ibfk_1`;
DROP TABLE IF EXISTS `shoplist`;
DROP TABLE IF EXISTS `storelist`;

--
-- Table structure for table `shoplist`
--

CREATE TABLE `storelist` (
    `id` int NOT NULL AUTO_INCREMENT,
    `store` varchar(50) NOT NULL,
    `rank` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `storelist` (`store`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `shoplist` (
    `id` int NOT NULL AUTO_INCREMENT,
    `item` varchar(50) DEFAULT NULL,
    `price` varchar(50) DEFAULT NULL,
    `store` VARCHAR(50) DEFAULT NULL,
    `date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    `special_deal` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`store`) REFERENCES `storelist` (`store`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `storelist` (`store`, `rank`) VALUES
    ('IKEA', 5),
    ('99Ranch', 4),
    ('COSTCO', 5),
    ('TARGET', 3),
    ('SAFEWAY', 3),
    ('WALMART', 3),
    ('QFC', 4);


INSERT INTO `shoplist` (`item`, `price`, `store`, `special_deal`) VALUES
    ('Banana', '0.89', 'SAFEWAY', '0.29/ea'),
    ('Green Seedless Grapes', '1.69', 'SAFEWAY', '3.38/ea'),
    ('Strawberries Prepacked', '2.99', 'SAFEWAY', '2.99/ea'),
    ('Red Seedless Grapes', '1.69', 'SAFEWAY', '3.38/ea'),
    ('Medium Ripe Avocado', '1.99', 'QFC', 'NULL'),
    ('Banana', '0.69', 'QFC', '0.29/ea'),
    ('Strawberries', '4.49', 'QFC', 'NULL'),
    ('Red Onions', '1.99', 'QFC', '1.00/ea');
