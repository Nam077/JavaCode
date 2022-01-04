/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 100422
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 100422
 File Encoding         : 65001

 Date: 04/01/2022 22:16:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `pass` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `rule` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (7, 'Long', 'long@long.comd', 'Hà Tĩnh', '01/01/2000', 'namnam', '0337994575', 'admin');
INSERT INTO `account` VALUES (8, 'namnamn', 'namnam', NULL, NULL, NULL, 'mnamnam', NULL);

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `category_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `condition_b` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `quantily` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');
INSERT INTO `book` VALUES (2, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');
INSERT INTO `book` VALUES (3, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');
INSERT INTO `book` VALUES (4, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');
INSERT INTO `book` VALUES (5, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');
INSERT INTO `book` VALUES (8, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');
INSERT INTO `book` VALUES (16, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');
INSERT INTO `book` VALUES (17, 'df', '1', 'sdfsd', 'fdsfds', 'ds', 'ds', 'dsfds');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, 'Truyện Dài', 'Chưa có');
INSERT INTO `category` VALUES (2, 'Truyện Cười', 'Chưa có');
INSERT INTO `category` VALUES (3, 'Truyện Hài', 'Chưa có');

SET FOREIGN_KEY_CHECKS = 1;
