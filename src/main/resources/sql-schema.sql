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
`item_id` INT(40) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(40) DEFAULT NULL, 
`item_price` DOUBLE(40) DEFAULT NULL, 
PRIMARY KEY (`item_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders` (
`order_id` INT(40) AUTO_INCREMENT NOT NULL,
`customer_id` INT(40) DEFAULT NULL, 
PRIMARY KEY (`order_id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`order_items`(
 `order_items_id` INT(40) AUTO_INCREMENT NOT NULL primary key,
`order_id` INT(40) NOT NULL,
 CONSTRAINT `order_id` foreign key (`order_id`) references orders(`order_id`),
  `item_id` INT (40) NOT NULL,
CONSTRAINT `item_id` foreign key (`item_id`) references items(`item_id`)
);


