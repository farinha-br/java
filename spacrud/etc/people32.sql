/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-06-19 09:06:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `id` mediumint(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `place` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('9', 'Emma', 'New York');
INSERT INTO `people` VALUES ('10', 'Noah', 'Los Angeles');
INSERT INTO `people` VALUES ('11', 'Olivia ', 'Chicago');
INSERT INTO `people` VALUES ('12', 'Liam', 'Houston');
INSERT INTO `people` VALUES ('13', 'Ava ', 'Phoenix');
INSERT INTO `people` VALUES ('14', 'William', 'Philadelphia');
INSERT INTO `people` VALUES ('15', 'Sophia ', 'San Antonio');
INSERT INTO `people` VALUES ('16', 'Mason', 'San Diego');
INSERT INTO `people` VALUES ('17', 'Isabella ', 'Dallas');
INSERT INTO `people` VALUES ('18', 'James', 'San Jose');
INSERT INTO `people` VALUES ('19', 'Mia ', 'Austin');
INSERT INTO `people` VALUES ('20', 'Benjamin', 'Jacksonville');
INSERT INTO `people` VALUES ('21', 'Charlotte ', 'San Francisco');
INSERT INTO `people` VALUES ('22', 'Jacob', 'Columbus');
INSERT INTO `people` VALUES ('23', 'Abigail ', 'Indianapolis');
INSERT INTO `people` VALUES ('24', 'Michael', 'Fort Worth');
INSERT INTO `people` VALUES ('25', 'Emily ', 'Charlotte');
INSERT INTO `people` VALUES ('26', 'Elijah', 'Seattle');
INSERT INTO `people` VALUES ('27', 'Harper ', 'Denver');
INSERT INTO `people` VALUES ('28', 'Ethan', 'El Paso');
INSERT INTO `people` VALUES ('29', 'Amelia ', 'Washington');
INSERT INTO `people` VALUES ('30', 'Alexander', 'Boston');
INSERT INTO `people` VALUES ('31', 'Evelyn ', 'Detroit');
INSERT INTO `people` VALUES ('32', 'Oliver', 'Nashville');
