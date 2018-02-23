/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-02-24 00:19:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shopping_car`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`product_id`),
  KEY `idx_member` (`user_id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_car
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_category1`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_category1`;
CREATE TABLE `shopping_category1` (
  `category1_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '一级类目id',
  `category1_name` varchar(255) NOT NULL COMMENT '一级类目名称',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`category1_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_category1
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_category2`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_category2`;
CREATE TABLE `shopping_category2` (
  `category2_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `category2_name` varchar(255) NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_deleted` tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`category2_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_category2
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_order`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_order`;
CREATE TABLE `shopping_order` (
  `order_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `order_memo` varchar(255) DEFAULT NULL COMMENT '给卖家的留言',
  `address` varchar(255) NOT NULL COMMENT '收获地址',
  `mobile` char(11) NOT NULL COMMENT '联系电话',
  `status` tinyint(3) unsigned NOT NULL COMMENT '订单状态',
  `total` decimal(10,0) unsigned NOT NULL COMMENT '订单总金额',
  `gmt_create` datetime NOT NULL COMMENT '订单创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '订单修改时间',
  `id_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_order
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_order_item`;
CREATE TABLE `shopping_order_item` (
  `order_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `product_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `product_num` int(10) unsigned NOT NULL,
  `sub_total` decimal(10,0) unsigned NOT NULL,
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`,`product_id`),
  UNIQUE KEY `uk_order_product` (`order_id`,`product_id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_product`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_product`;
CREATE TABLE `shopping_product` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `category1_id` bigint(20) unsigned NOT NULL COMMENT '商品所属的一级类目',
  `category2_id` bigint(20) unsigned NOT NULL COMMENT '商品所属的二级类目',
  `product_name` varchar(255) NOT NULL COMMENT '商品名称',
  `purchase_price` decimal(30,0) unsigned NOT NULL COMMENT '采购价',
  `sale_price` decimal(30,0) unsigned NOT NULL COMMENT '销售价',
  `inventory` int(10) unsigned NOT NULL COMMENT '库存',
  `img_src` varchar(255) NOT NULL COMMENT '图片地址',
  `description` varchar(255) NOT NULL COMMENT '商品描述',
  `is_hot` tinyint(1) unsigned NOT NULL COMMENT '是否是热门商品',
  `product_date` datetime NOT NULL COMMENT '商品的发布日期',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `idx_category1` (`category1_id`) USING HASH,
  UNIQUE KEY `idx_category2` (`category2_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_product
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_user`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_user`;
CREATE TABLE `shopping_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `login_name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `age` tinyint(3) unsigned NOT NULL,
  `address` varchar(255) NOT NULL,
  `status` tinyint(1) unsigned NOT NULL,
  `is_admin` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否是管理员',
  `gmt_create` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_deleted` tinyint(1) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_user
-- ----------------------------
