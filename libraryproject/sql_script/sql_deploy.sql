/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  anatole
 * Created: 30 nov. 2015
 */


drop table if EXISTS `book`;
drop table if EXISTS `author`;
drop table if EXISTS `category`;
drop table if EXISTS `user`;
drop table if EXISTS `borrowed`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45),
  `surname` varchar(45),
  `mail` varchar(45) NOT NULL UNIQUE,
  `username` varchar(45) NOT NULL UNIQUE,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);


create table IF NOT EXISTS `author`(
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(16),
    PRIMARY KEY(`id`)
);

CREATE TABLE IF NOT EXISTS `book` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `description` tinytext NOT NULL,
  `category_id` int(10) unsigned NOT NULL,
  `stock` int(10) unsigned NOT NULL,
  `image` blob NOT NULL,
  `author_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`category_id`) REFERENCES `category`(`id`),
  FOREIGN KEY (`author_id`) REFERENCES `author`(`id`)
);

CREATE TABLE IF NOT EXISTS `borrowed` (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    `book_id` int(10) unsigned NOT NULL,
    `user_id` int(10) unsigned NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`book_id`) REFERENCES `book`(`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);
