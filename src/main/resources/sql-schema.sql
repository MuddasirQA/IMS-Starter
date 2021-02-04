drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`customer_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items` (
`item_id` INT(40) NOT NULLL AUTO_INCREMENT,
`item_name` VARCHAR(40) DEFAULT NULL, 
`item_price` DOUBLE(40) DEFAULT NULL, 
PRIMARY KEY (`item_id`)
);




