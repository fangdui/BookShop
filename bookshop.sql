/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50562
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2020-05-14 15:57:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tp_cart`
-- ----------------------------
DROP TABLE IF EXISTS `tp_cart`;
CREATE TABLE `tp_cart` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `cart_p_filename` varchar(128) DEFAULT NULL,
  `cart_p_name` varchar(64) DEFAULT NULL,
  `cart_p_price` decimal(10,2) DEFAULT NULL,
  `cart_quantity` int(11) DEFAULT NULL,
  `cart_p_stock` int(11) DEFAULT NULL,
  `cart_p_id` int(11) DEFAULT NULL,
  `cart_u_id` varchar(64) DEFAULT NULL,
  `cart_valid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_cart
-- ----------------------------
INSERT INTO `tp_cart` VALUES ('40', '0bf587e1b7d5de74.jpg', '细说PHP 第四版', '158.00', '4', '3000', '1', 'ftp', '1');
INSERT INTO `tp_cart` VALUES ('55', '5624b582Nbc01af5b.jpg', 'Java编程思想', '109.00', '4', '3223', '4', 'hww', '1');
INSERT INTO `tp_cart` VALUES ('56', '74a5a5dcd83ecc09.jpg', 'Java经典案例', '88.00', '2', '55', '6', 'hww', '1');
INSERT INTO `tp_cart` VALUES ('57', '5acb3627N8191c867.jpg', 'Python编程技术', '120.00', '1', '77', '10', 'hww', '1');
INSERT INTO `tp_cart` VALUES ('58', '0bf587e1b7d5de74.jpg', '细说PHP 第四版', '158.00', '4', '3000', '1', 'hww', '1');

-- ----------------------------
-- Table structure for `tp_category`
-- ----------------------------
DROP TABLE IF EXISTS `tp_category`;
CREATE TABLE `tp_category` (
  `CATE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CATE_NAME` varchar(20) NOT NULL,
  `CATE_PARENT_ID` decimal(10,0) NOT NULL,
  PRIMARY KEY (`CATE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_category
-- ----------------------------
INSERT INTO `tp_category` VALUES ('12', 'Java图书', '0');
INSERT INTO `tp_category` VALUES ('13', 'Python图书', '0');
INSERT INTO `tp_category` VALUES ('14', 'PHP图书', '0');
INSERT INTO `tp_category` VALUES ('16', 'Linux图书', '0');
INSERT INTO `tp_category` VALUES ('17', 'JavaSE图书', '12');
INSERT INTO `tp_category` VALUES ('18', 'JAVAEE图书', '12');
INSERT INTO `tp_category` VALUES ('19', 'JavaEE框架', '12');
INSERT INTO `tp_category` VALUES ('20', 'Python基础', '13');
INSERT INTO `tp_category` VALUES ('21', 'Python人工智能', '13');
INSERT INTO `tp_category` VALUES ('22', 'PHP基础', '14');
INSERT INTO `tp_category` VALUES ('23', 'PHP高级', '14');
INSERT INTO `tp_category` VALUES ('24', 'Linux系统', '16');
INSERT INTO `tp_category` VALUES ('25', 'Linux网络服务', '16');
INSERT INTO `tp_category` VALUES ('26', 'Linux运维', '16');
INSERT INTO `tp_category` VALUES ('30', 'Go语言图书', '0');
INSERT INTO `tp_category` VALUES ('31', 'Go语言入门', '30');

-- ----------------------------
-- Table structure for `tp_product`
-- ----------------------------
DROP TABLE IF EXISTS `tp_product`;
CREATE TABLE `tp_product` (
  `PRODUCT_ID` int(10) NOT NULL AUTO_INCREMENT,
  `PRODUCT_NAME` varchar(128) NOT NULL,
  `PRODUCT_DESCRIPTION` varchar(512) DEFAULT NULL,
  `PRODUCT_PRICE` decimal(10,2) NOT NULL,
  `PRODUCT_STOCK` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_CID` decimal(10,0) DEFAULT NULL,
  `PRODUCT_FILENAME` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PRODUCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_product
-- ----------------------------
INSERT INTO `tp_product` VALUES ('1', '细说PHP 第四版', '这是一本学习PHP的书', '158.00', '2000', '14', '22', '0bf587e1b7d5de74.jpg');
INSERT INTO `tp_product` VALUES ('2', 'PHP学习手册', '自学可以使用的手册，很全面', '51.00', '21', '14', '22', '592fb45cNac23b876.jpg');
INSERT INTO `tp_product` VALUES ('3', 'PHP项目案例', '通过这本书，可以完成PHP的项目案例', '104.00', '55', '14', '23', '56f63c22Nbb294bc0.jpg');
INSERT INTO `tp_product` VALUES ('4', 'Java编程思想', '这是一个好书呀', '109.00', '3223', '12', '17', '5624b582Nbc01af5b.jpg');
INSERT INTO `tp_product` VALUES ('5', 'Java从入门到精通', '新手使用的好书', '68.00', '99', '12', '17', '99742c91174d3d7a.jpg');
INSERT INTO `tp_product` VALUES ('6', 'Java经典案例', '这本书很好， 在是一个不错书', '88.00', '55', '12', '17', '74a5a5dcd83ecc09.jpg');
INSERT INTO `tp_product` VALUES ('7', 'Java核心技术', '这个书对Java介绍的很全面', '128.00', '120', '12', '17', '57e09a03Nc57334e1.jpg');
INSERT INTO `tp_product` VALUES ('8', '深入理解Java虚拟机', '对新手很有用的书', '89.00', '55', '12', '17', '592bf167Naf49f7f6.jpg');
INSERT INTO `tp_product` VALUES ('9', 'Java精彩编程', '这个例子很多，很全面', '106.00', '555', '12', '17', 'ccc877ab66ae0b5e.jpg');
INSERT INTO `tp_product` VALUES ('10', 'Python编程技术', '这个学Ptyhon很好', '120.00', '77', '13', '20', '5acb3627N8191c867.jpg');

-- ----------------------------
-- Table structure for `tp_user`
-- ----------------------------
DROP TABLE IF EXISTS `tp_user`;
CREATE TABLE `tp_user` (
  `USER_ID` varchar(32) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_PASSWORD` varchar(20) NOT NULL,
  `USER_SEX` varchar(1) NOT NULL,
  `USER_BIRTHDAY` datetime DEFAULT NULL,
  `USER_IDENTITY_CODE` varchar(60) DEFAULT NULL,
  `USER_EMAIL` varchar(60) DEFAULT NULL,
  `USER_MOBILE` varchar(11) DEFAULT NULL,
  `USER_ADDRESS` varchar(200) NOT NULL,
  `USER_STATUS` decimal(6,0) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_user
-- ----------------------------
INSERT INTO `tp_user` VALUES ('admin', 'admin', '123', 'F', '2019-10-08 00:00:00', null, 'aaa@bbb.com', '222222', '4323323232323232', '2');
INSERT INTO `tp_user` VALUES ('admin1', 'admin', '123', 'T', '2019-10-08 00:00:00', null, 'aaa@bbb.com', '222222', '4323323232323232', '2');
INSERT INTO `tp_user` VALUES ('ftp', '方铤沛', '123', 'T', '1998-01-15 00:00:00', null, 'tp@qq.com', '13790698435', '汕头市龙湖区', '1');
INSERT INTO `tp_user` VALUES ('hww', '胡文蔚', '123', 'F', '2014-06-03 00:00:00', null, 'ww@qq.com', '1313313131', '河南省信阳市', '1');
INSERT INTO `tp_user` VALUES ('wangwu1', '王五', '111', 'T', '2019-11-01 00:00:00', null, 'wangwu@lmonkey.com', '18810090000', '中关村软件园', '1');
INSERT INTO `tp_user` VALUES ('wangwu2', '王五', '111', 'T', '2019-11-01 00:00:00', null, 'wangwu@lmonkey.com', '18810090000', '中关村软件园', '1');
INSERT INTO `tp_user` VALUES ('wangwu3', '王五', '111', 'T', '2019-11-01 00:00:00', null, 'wangwu@lmonkey.com', '18810090000', '中关村软件园', '1');
INSERT INTO `tp_user` VALUES ('wangwu4', '王五', '111', 'T', '2019-11-01 00:00:00', null, 'wangwu@lmonkey.com', '18810090000', '中关村软件园', '1');
INSERT INTO `tp_user` VALUES ('wangwu5', '王五', '111', 'T', '2019-11-01 00:00:00', null, 'wangwu@lmonkey.com', '18810090000', '中关村软件园', '1');
INSERT INTO `tp_user` VALUES ('yzm', '叶泽明', '123', 'F', '1998-02-15 00:00:00', null, 'zm@qq.com', '12313131', '河源', '1');
INSERT INTO `tp_user` VALUES ('zhangsan1', '张三', '111', 'T', '2020-05-15 00:00:00', null, 'zhangsan@lmonkey.com', '1192121221', '北京西二期软件园', '1');
INSERT INTO `tp_user` VALUES ('zhangsan2', '张三', '111', 'T', '2019-11-08 00:00:00', null, 'zhangsan@lmonkey.com', '1192121221', '北京西二期软件园', '1');
INSERT INTO `tp_user` VALUES ('zhangsan3', '张三', '111', 'T', '2019-11-08 00:00:00', null, 'zhangsan@lmonkey.com', '1192121221', '北京西二期软件园', '1');
INSERT INTO `tp_user` VALUES ('zhangsan4', '张三', '111', 'T', '2019-11-08 00:00:00', null, 'zhangsan@lmonkey.com', '1192121221', '北京西二期软件园', '1');
INSERT INTO `tp_user` VALUES ('zhangsan5', '张三', '111', 'T', '2019-11-08 00:00:00', null, 'zhangsan@lmonkey.com', '1192121221', '北京西二期软件园', '1');
