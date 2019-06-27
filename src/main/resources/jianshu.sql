/*
 Navicat Premium Data Transfer

 Source Server         : 10.25.44.204
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : 10.25.44.204:3306
 Source Schema         : jianshu

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 27/06/2019 10:08:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alembic_version
-- ----------------------------
DROP TABLE IF EXISTS `alembic_version`;
CREATE TABLE `alembic_version` (
  `version_num` varchar(32) NOT NULL,
  PRIMARY KEY (`version_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(50) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `last_update_time` varchar(50) DEFAULT NULL,
  `font_num` varchar(50) DEFAULT NULL,
  `read_num` varchar(50) DEFAULT NULL,
  `like_num` varchar(50) DEFAULT NULL,
  `comment_num` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `url` varchar(50) DEFAULT NULL,
  `content` text,
  `key_words` varchar(50) DEFAULT NULL,
  `vector` text,
  `frequence` text,
  `other_text` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for attend
-- ----------------------------
DROP TABLE IF EXISTS `attend`;
CREATE TABLE `attend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL,
  `attend_id` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `attend` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL,
  `comment_id` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `comment` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for join
-- ----------------------------
DROP TABLE IF EXISTS `join`;
CREATE TABLE `join` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(50) DEFAULT NULL,
  `like_id` varchar(50) DEFAULT NULL,
  `time` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `concern` varchar(50) DEFAULT NULL,
  `fan` varchar(50) DEFAULT NULL,
  `page_num` varchar(50) DEFAULT NULL,
  `font_num` varchar(50) DEFAULT NULL,
  `introduce` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

create table user_action(
                            id int primary key auto_increment,
                            uid varchar(50),
                            action varchar(30),
                            time varchar(50),
                            pid varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
