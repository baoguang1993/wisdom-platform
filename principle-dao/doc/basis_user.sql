/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.148
Source Server Version : 50622
Source Host           : 192.168.1.148:3306
Source Database       : wisdom-platform

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2020-08-19 16:43:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for basis_user
-- ----------------------------
DROP TABLE IF EXISTS `basis_user`;
CREATE TABLE `basis_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_address` varchar(255) DEFAULT NULL,
  `user_age` int(4) DEFAULT NULL COMMENT '年龄',
  `user_name` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8;
