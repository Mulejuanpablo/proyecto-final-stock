DROP DATABASE IF EXISTS `stock`;
CREATE DATABASE IF NOT EXISTS `stock` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
DROP USER IF EXISTS `springuser`@localhost;
CREATE USER `springuser` @localhost IDENTIFIED BY 'ThePassword';
GRANT USAGE ON *.* TO `springuser` @localhost;
GRANT ALL PRIVILEGES ON `stock`.* TO `springuser`@localhost;
USE `stock`;
DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
    `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
    `producto` varchar(255) DEFAULT NULL,
    `cantidad` varchar(255) DEFAULT NULL,
    `precio` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 10 DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `stock` (`id`, `producto`, `cantidad`, `precio`)
VALUES
(101, 'tornillo', '2000', '4'),
(102, 'tuerca', '2000', '2.5'),
(103, 'arandela', '4000', '1.5'),
(104, 'clavo', '5000', '3'),
(105, 'tarugo', '2000', '2'),
(106, 'destornillador', '200', '890'),
(107, 'martillo', '120', '1200'),
(108, 'pulseana', '50', '2500'),
(109, 'cerrucho', '10', '4500');

