CREATE TABLE `enam_dua_teknologi`.`businesses` (
    `id` varchar(50) NOT NULL,
    `alias` varchar(50) DEFAULT NULL,
    `name` varchar(200) DEFAULT NULL,
    `image_url` varchar(250) DEFAULT NULL,
    `is_closed` tinyint(1) DEFAULT NULL,
    `url` varchar(250) DEFAULT NULL,
    `review_count` varchar(10) DEFAULT NULL,
    `categories_id` bigint(10) DEFAULT NULL,
    `rating` varchar(10) DEFAULT NULL,
    `latitude` varchar(50) DEFAULT NULL,
    `longitude` varchar(50) DEFAULT NULL,
    `transactions` varchar(100) DEFAULT NULL,
    `price` varchar(100) DEFAULT NULL,
    `location_id` bigint(10) DEFAULT NULL,
    `phone` varchar(15) DEFAULT NULL,
    `display_phone` varchar(15) DEFAULT NULL,
    `distance` varchar(150) DEFAULT NULL,
    `is_open_now` time DEFAULT NULL,
    `open_at` time DEFAULT NULL,
    `total` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`)
);