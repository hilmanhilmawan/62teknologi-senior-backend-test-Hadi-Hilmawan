CREATE TABLE `enam_dua_teknologi`.`location` (
    `id` bigint(10) NOT NULL AUTO_INCREMENT,
    `reft_id` varchar(50) DEFAULT NULL,
    `address1` text DEFAULT NULL,
    `address2` text DEFAULT NULL,
    `address3` text DEFAULT NULL,
    `city` varchar(100) DEFAULT NULL,
    `zip_code` varchar(50) DEFAULT NULL,
    `country` varchar(100) DEFAULT NULL,
    `state` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
);