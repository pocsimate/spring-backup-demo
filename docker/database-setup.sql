CREATE USER 'test'@'%' IDENTIFIED BY 'test';

GRANT ALL PRIVILEGES ON * . * TO 'test'@'%';

DROP SCHEMA IF EXISTS `demo`;

CREATE SCHEMA `demo`;
USE `demo` ;