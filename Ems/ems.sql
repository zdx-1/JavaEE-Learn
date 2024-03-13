/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50744
Source Host           : localhost:3306
Source Database       : ems

Target Server Type    : MYSQL
Target Server Version : 50744
File Encoding         : 65001

Date: 2024-03-13 00:25:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `position` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('2', 'John', '20', 'developer');
INSERT INTO `employee` VALUES ('3', 'Bob', '21', 'developer');
INSERT INTO `employee` VALUES ('4', '测试员01', '22', 'developer');
INSERT INTO `employee` VALUES ('5', '张三', '20', 'manager');
INSERT INTO `employee` VALUES ('6', '张三', '20', 'manager');
INSERT INTO `employee` VALUES ('7', '张三', '20', 'manager');
INSERT INTO `employee` VALUES ('8', '张三', '20', 'manager');
