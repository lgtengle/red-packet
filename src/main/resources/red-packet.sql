/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : red-packet

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 02/04/2019 17:49:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grab_record
-- ----------------------------
DROP TABLE IF EXISTS `grab_record`;
CREATE TABLE `grab_record`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL COMMENT '抢红包人的ID',
  `redpacket_id` int(11) NOT NULL COMMENT '红包ID',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '抢到的红包金额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名字',
  `account_balance` int(11) NOT NULL DEFAULT 0 COMMENT '账户余额，精确到分，整数表示',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for redpacket
-- ----------------------------
DROP TABLE IF EXISTS `redpacket`;
CREATE TABLE `redpacket`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL COMMENT '发送者ID',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '红包金额',
  `numbers` int(11) NOT NULL DEFAULT 1 COMMENT '红包个数',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '大吉大利，恭喜发财！' COMMENT '注释',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
