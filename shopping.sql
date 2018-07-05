/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-06-27 08:50:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `shopping_active`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_active`;
CREATE TABLE `shopping_active` (
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `category2_id` bigint(20) unsigned NOT NULL COMMENT '二级类目的id',
  `hits` bigint(20) unsigned NOT NULL COMMENT '该用户在该二级类目的点击次数',
  PRIMARY KEY (`user_id`,`category2_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_active
-- ----------------------------
INSERT INTO `shopping_active` VALUES ('1', '1', '1040');
INSERT INTO `shopping_active` VALUES ('1', '2', '837');
INSERT INTO `shopping_active` VALUES ('1', '3', '880');
INSERT INTO `shopping_active` VALUES ('1', '4', '892');
INSERT INTO `shopping_active` VALUES ('1', '5', '969');
INSERT INTO `shopping_active` VALUES ('1', '6', '907');
INSERT INTO `shopping_active` VALUES ('1', '7', '925');
INSERT INTO `shopping_active` VALUES ('1', '8', '1812');
INSERT INTO `shopping_active` VALUES ('1', '9', '1763');
INSERT INTO `shopping_active` VALUES ('1', '10', '1679');
INSERT INTO `shopping_active` VALUES ('1', '11', '1702');
INSERT INTO `shopping_active` VALUES ('1', '12', '1652');
INSERT INTO `shopping_active` VALUES ('1', '13', '65');
INSERT INTO `shopping_active` VALUES ('1', '14', '26');
INSERT INTO `shopping_active` VALUES ('1', '15', '46');
INSERT INTO `shopping_active` VALUES ('1', '16', '37');
INSERT INTO `shopping_active` VALUES ('1', '17', '23');
INSERT INTO `shopping_active` VALUES ('1', '18', '35');
INSERT INTO `shopping_active` VALUES ('1', '19', '35');
INSERT INTO `shopping_active` VALUES ('1', '20', '45');
INSERT INTO `shopping_active` VALUES ('1', '21', '55');
INSERT INTO `shopping_active` VALUES ('1', '22', '135');
INSERT INTO `shopping_active` VALUES ('1', '23', '77');
INSERT INTO `shopping_active` VALUES ('1', '24', '29');
INSERT INTO `shopping_active` VALUES ('1', '25', '98');
INSERT INTO `shopping_active` VALUES ('1', '26', '152');
INSERT INTO `shopping_active` VALUES ('1', '27', '76');
INSERT INTO `shopping_active` VALUES ('1', '28', '69');
INSERT INTO `shopping_active` VALUES ('1', '29', '1413');
INSERT INTO `shopping_active` VALUES ('1', '30', '45');
INSERT INTO `shopping_active` VALUES ('1', '31', '35');
INSERT INTO `shopping_active` VALUES ('1', '32', '28');
INSERT INTO `shopping_active` VALUES ('1', '33', '18');
INSERT INTO `shopping_active` VALUES ('1', '34', '23');
INSERT INTO `shopping_active` VALUES ('1', '35', '18');
INSERT INTO `shopping_active` VALUES ('2', '1', '10');
INSERT INTO `shopping_active` VALUES ('2', '2', '20');
INSERT INTO `shopping_active` VALUES ('2', '3', '30');
INSERT INTO `shopping_active` VALUES ('2', '4', '40');
INSERT INTO `shopping_active` VALUES ('2', '5', '50');
INSERT INTO `shopping_active` VALUES ('2', '6', '60');
INSERT INTO `shopping_active` VALUES ('2', '7', '70');
INSERT INTO `shopping_active` VALUES ('2', '8', '80');
INSERT INTO `shopping_active` VALUES ('2', '9', '90');
INSERT INTO `shopping_active` VALUES ('2', '10', '80');
INSERT INTO `shopping_active` VALUES ('2', '11', '70');
INSERT INTO `shopping_active` VALUES ('2', '12', '60');
INSERT INTO `shopping_active` VALUES ('2', '13', '50');
INSERT INTO `shopping_active` VALUES ('2', '14', '40');
INSERT INTO `shopping_active` VALUES ('2', '15', '30');
INSERT INTO `shopping_active` VALUES ('2', '16', '20');
INSERT INTO `shopping_active` VALUES ('2', '17', '10');
INSERT INTO `shopping_active` VALUES ('2', '18', '20');
INSERT INTO `shopping_active` VALUES ('2', '19', '30');
INSERT INTO `shopping_active` VALUES ('2', '20', '40');
INSERT INTO `shopping_active` VALUES ('2', '21', '50');
INSERT INTO `shopping_active` VALUES ('2', '22', '60');
INSERT INTO `shopping_active` VALUES ('2', '23', '70');
INSERT INTO `shopping_active` VALUES ('2', '24', '80');
INSERT INTO `shopping_active` VALUES ('2', '25', '90');
INSERT INTO `shopping_active` VALUES ('2', '26', '80');
INSERT INTO `shopping_active` VALUES ('2', '27', '70');
INSERT INTO `shopping_active` VALUES ('2', '28', '60');
INSERT INTO `shopping_active` VALUES ('2', '29', '50');
INSERT INTO `shopping_active` VALUES ('2', '30', '40');
INSERT INTO `shopping_active` VALUES ('2', '31', '30');
INSERT INTO `shopping_active` VALUES ('2', '32', '20');
INSERT INTO `shopping_active` VALUES ('2', '33', '10');
INSERT INTO `shopping_active` VALUES ('2', '34', '10');
INSERT INTO `shopping_active` VALUES ('2', '35', '0');
INSERT INTO `shopping_active` VALUES ('3', '1', '10');
INSERT INTO `shopping_active` VALUES ('3', '2', '20');
INSERT INTO `shopping_active` VALUES ('3', '3', '10');
INSERT INTO `shopping_active` VALUES ('3', '4', '40');
INSERT INTO `shopping_active` VALUES ('3', '5', '50');
INSERT INTO `shopping_active` VALUES ('3', '6', '60');
INSERT INTO `shopping_active` VALUES ('3', '7', '0');
INSERT INTO `shopping_active` VALUES ('3', '8', '118');
INSERT INTO `shopping_active` VALUES ('3', '9', '90');
INSERT INTO `shopping_active` VALUES ('3', '10', '80');
INSERT INTO `shopping_active` VALUES ('3', '11', '70');
INSERT INTO `shopping_active` VALUES ('3', '12', '60');
INSERT INTO `shopping_active` VALUES ('3', '13', '10');
INSERT INTO `shopping_active` VALUES ('3', '14', '40');
INSERT INTO `shopping_active` VALUES ('3', '15', '30');
INSERT INTO `shopping_active` VALUES ('3', '16', '20');
INSERT INTO `shopping_active` VALUES ('3', '17', '10');
INSERT INTO `shopping_active` VALUES ('3', '18', '10');
INSERT INTO `shopping_active` VALUES ('3', '19', '30');
INSERT INTO `shopping_active` VALUES ('3', '20', '0');
INSERT INTO `shopping_active` VALUES ('3', '21', '10');
INSERT INTO `shopping_active` VALUES ('3', '22', '60');
INSERT INTO `shopping_active` VALUES ('3', '23', '70');
INSERT INTO `shopping_active` VALUES ('3', '24', '80');
INSERT INTO `shopping_active` VALUES ('3', '25', '90');
INSERT INTO `shopping_active` VALUES ('3', '26', '80');
INSERT INTO `shopping_active` VALUES ('3', '27', '70');
INSERT INTO `shopping_active` VALUES ('3', '28', '60');
INSERT INTO `shopping_active` VALUES ('3', '29', '50');
INSERT INTO `shopping_active` VALUES ('3', '30', '40');
INSERT INTO `shopping_active` VALUES ('3', '31', '10');
INSERT INTO `shopping_active` VALUES ('3', '32', '20');
INSERT INTO `shopping_active` VALUES ('3', '33', '10');
INSERT INTO `shopping_active` VALUES ('3', '34', '10');
INSERT INTO `shopping_active` VALUES ('3', '35', '0');
INSERT INTO `shopping_active` VALUES ('4', '1', '0');
INSERT INTO `shopping_active` VALUES ('4', '2', '0');
INSERT INTO `shopping_active` VALUES ('4', '3', '10');
INSERT INTO `shopping_active` VALUES ('4', '4', '0');
INSERT INTO `shopping_active` VALUES ('4', '5', '50');
INSERT INTO `shopping_active` VALUES ('4', '6', '0');
INSERT INTO `shopping_active` VALUES ('4', '7', '10');
INSERT INTO `shopping_active` VALUES ('4', '8', '80');
INSERT INTO `shopping_active` VALUES ('4', '9', '0');
INSERT INTO `shopping_active` VALUES ('4', '10', '87');
INSERT INTO `shopping_active` VALUES ('4', '11', '0');
INSERT INTO `shopping_active` VALUES ('4', '12', '0');
INSERT INTO `shopping_active` VALUES ('4', '13', '0');
INSERT INTO `shopping_active` VALUES ('4', '14', '40');
INSERT INTO `shopping_active` VALUES ('4', '15', '10');
INSERT INTO `shopping_active` VALUES ('4', '16', '0');
INSERT INTO `shopping_active` VALUES ('4', '17', '0');
INSERT INTO `shopping_active` VALUES ('4', '18', '0');
INSERT INTO `shopping_active` VALUES ('4', '19', '30');
INSERT INTO `shopping_active` VALUES ('4', '20', '0');
INSERT INTO `shopping_active` VALUES ('4', '21', '0');
INSERT INTO `shopping_active` VALUES ('4', '22', '1160');
INSERT INTO `shopping_active` VALUES ('4', '23', '0');
INSERT INTO `shopping_active` VALUES ('4', '24', '80');
INSERT INTO `shopping_active` VALUES ('4', '25', '20');
INSERT INTO `shopping_active` VALUES ('4', '26', '0');
INSERT INTO `shopping_active` VALUES ('4', '27', '0');
INSERT INTO `shopping_active` VALUES ('4', '28', '0');
INSERT INTO `shopping_active` VALUES ('4', '29', '50');
INSERT INTO `shopping_active` VALUES ('4', '30', '0');
INSERT INTO `shopping_active` VALUES ('4', '31', '0');
INSERT INTO `shopping_active` VALUES ('4', '32', '20');
INSERT INTO `shopping_active` VALUES ('4', '33', '10');
INSERT INTO `shopping_active` VALUES ('4', '34', '10');
INSERT INTO `shopping_active` VALUES ('4', '35', '0');
INSERT INTO `shopping_active` VALUES ('5', '1', '10');
INSERT INTO `shopping_active` VALUES ('5', '2', '60');
INSERT INTO `shopping_active` VALUES ('5', '3', '30');
INSERT INTO `shopping_active` VALUES ('5', '4', '10');
INSERT INTO `shopping_active` VALUES ('5', '5', '50');
INSERT INTO `shopping_active` VALUES ('5', '6', '60');
INSERT INTO `shopping_active` VALUES ('5', '7', '70');
INSERT INTO `shopping_active` VALUES ('5', '8', '80');
INSERT INTO `shopping_active` VALUES ('5', '9', '91');
INSERT INTO `shopping_active` VALUES ('5', '10', '80');
INSERT INTO `shopping_active` VALUES ('5', '11', '70');
INSERT INTO `shopping_active` VALUES ('5', '12', '10');
INSERT INTO `shopping_active` VALUES ('5', '13', '20');
INSERT INTO `shopping_active` VALUES ('5', '14', '42');
INSERT INTO `shopping_active` VALUES ('5', '15', '30');
INSERT INTO `shopping_active` VALUES ('5', '16', '20');
INSERT INTO `shopping_active` VALUES ('5', '17', '10');
INSERT INTO `shopping_active` VALUES ('5', '18', '1');
INSERT INTO `shopping_active` VALUES ('5', '19', '10');
INSERT INTO `shopping_active` VALUES ('5', '20', '40');
INSERT INTO `shopping_active` VALUES ('5', '21', '50');
INSERT INTO `shopping_active` VALUES ('5', '22', '10');
INSERT INTO `shopping_active` VALUES ('5', '23', '10');
INSERT INTO `shopping_active` VALUES ('5', '24', '80');
INSERT INTO `shopping_active` VALUES ('5', '25', '10');
INSERT INTO `shopping_active` VALUES ('5', '26', '20');
INSERT INTO `shopping_active` VALUES ('5', '27', '70');
INSERT INTO `shopping_active` VALUES ('5', '28', '60');
INSERT INTO `shopping_active` VALUES ('5', '29', '50');
INSERT INTO `shopping_active` VALUES ('5', '30', '40');
INSERT INTO `shopping_active` VALUES ('5', '31', '10');
INSERT INTO `shopping_active` VALUES ('5', '32', '20');
INSERT INTO `shopping_active` VALUES ('5', '33', '10');
INSERT INTO `shopping_active` VALUES ('5', '34', '10');
INSERT INTO `shopping_active` VALUES ('5', '35', '10');
INSERT INTO `shopping_active` VALUES ('6', '1', '14');
INSERT INTO `shopping_active` VALUES ('6', '2', '60');
INSERT INTO `shopping_active` VALUES ('6', '3', '230');
INSERT INTO `shopping_active` VALUES ('6', '4', '10');
INSERT INTO `shopping_active` VALUES ('6', '5', '50');
INSERT INTO `shopping_active` VALUES ('6', '6', '10');
INSERT INTO `shopping_active` VALUES ('6', '7', '70');
INSERT INTO `shopping_active` VALUES ('6', '8', '1');
INSERT INTO `shopping_active` VALUES ('6', '9', '91');
INSERT INTO `shopping_active` VALUES ('6', '10', '280');
INSERT INTO `shopping_active` VALUES ('6', '11', '70');
INSERT INTO `shopping_active` VALUES ('6', '12', '10');
INSERT INTO `shopping_active` VALUES ('6', '13', '220');
INSERT INTO `shopping_active` VALUES ('6', '14', '42');
INSERT INTO `shopping_active` VALUES ('6', '15', '130');
INSERT INTO `shopping_active` VALUES ('6', '16', '220');
INSERT INTO `shopping_active` VALUES ('6', '17', '10');
INSERT INTO `shopping_active` VALUES ('6', '18', '21');
INSERT INTO `shopping_active` VALUES ('6', '19', '10');
INSERT INTO `shopping_active` VALUES ('6', '20', '40');
INSERT INTO `shopping_active` VALUES ('6', '21', '250');
INSERT INTO `shopping_active` VALUES ('6', '22', '10');
INSERT INTO `shopping_active` VALUES ('6', '23', '210');
INSERT INTO `shopping_active` VALUES ('6', '24', '80');
INSERT INTO `shopping_active` VALUES ('6', '25', '110');
INSERT INTO `shopping_active` VALUES ('6', '26', '20');
INSERT INTO `shopping_active` VALUES ('6', '27', '170');
INSERT INTO `shopping_active` VALUES ('6', '28', '160');
INSERT INTO `shopping_active` VALUES ('6', '29', '50');
INSERT INTO `shopping_active` VALUES ('6', '30', '140');
INSERT INTO `shopping_active` VALUES ('6', '31', '10');
INSERT INTO `shopping_active` VALUES ('6', '32', '20');
INSERT INTO `shopping_active` VALUES ('6', '33', '110');
INSERT INTO `shopping_active` VALUES ('6', '34', '10');
INSERT INTO `shopping_active` VALUES ('6', '35', '10');

-- ----------------------------
-- Table structure for `shopping_car`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_car`;
CREATE TABLE `shopping_car` (
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `product_id` bigint(20) unsigned NOT NULL COMMENT '商品id',
  `product_name` varchar(255) NOT NULL COMMENT '商品的名称',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除的标识',
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
  `category1_id` bigint(100) unsigned NOT NULL AUTO_INCREMENT COMMENT '一级类目id',
  `category1_name` varchar(20) NOT NULL COMMENT '一级类目名称',
  `category1_record` varchar(255) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录修改的时间',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否显示该分类，1显示，0隐藏',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`category1_id`),
  KEY `idx_category1_name` (`category1_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_category1
-- ----------------------------
INSERT INTO `shopping_category1` VALUES ('1', '女装男装', '此分类为女装男装', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '1', '0');
INSERT INTO `shopping_category1` VALUES ('2', '鞋靴箱包', '此分类为鞋靴箱包', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '1', '0');
INSERT INTO `shopping_category1` VALUES ('3', '日常生活用品', '此分类为日常生活用品', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '1', '0');
INSERT INTO `shopping_category1` VALUES ('4', '珠宝配饰', '此分类为珠宝配饰', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '1', '0');
INSERT INTO `shopping_category1` VALUES ('5', '手机数码', '此分类为手机数码', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '1', '0');
INSERT INTO `shopping_category1` VALUES ('6', '家用电器', '此分类为家用电器', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '1', '0');
INSERT INTO `shopping_category1` VALUES ('7', '食品', '此分类为食品', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '1', '0');
INSERT INTO `shopping_category1` VALUES ('8', '测试类目', '用于测试', '2018-03-19 09:37:57', '2018-03-19 09:37:57', '1', '1');

-- ----------------------------
-- Table structure for `shopping_category2`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_category2`;
CREATE TABLE `shopping_category2` (
  `category2_id` bigint(100) unsigned NOT NULL AUTO_INCREMENT COMMENT '二级类目id',
  `category2_name` varchar(20) NOT NULL COMMENT '二级类目名称',
  `category2_record` varchar(255) DEFAULT NULL COMMENT '二级类目的备注',
  `category1_id` bigint(20) NOT NULL COMMENT '所属的一级类目的id',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录被修改的时间',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否显示分类，1显示，0隐藏',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除的标识',
  PRIMARY KEY (`category2_id`),
  KEY `idx_category1_id` (`category1_id`) USING BTREE,
  KEY `idx_category2_name` (`category2_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_category2
-- ----------------------------
INSERT INTO `shopping_category2` VALUES ('1', '潮流女装', 'fashion', '1', '2018-02-24 23:08:21', '2018-03-09 09:41:03', '1', '0');
INSERT INTO `shopping_category2` VALUES ('2', '初冬羽绒', '默认备注', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('3', '毛皮大衣', '默认备注', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('4', '温暖毛衣', '默认备注', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('5', '精选男装', '默认备注', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('6', '冬季外套', '默认备注', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('7', '羽绒服', '默认备注', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('8', '女鞋', '默认备注', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('9', '短靴', '默认备注', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('10', '男鞋', '默认备注', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('11', '女包', '默认备注', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('12', '男包', '默认备注', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('13', '服饰配件', '默认备注', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('14', '雨伞雨具', '默认备注', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('15', '洗嗮/熨烫', '默认备注', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('16', '净化除味', '默认备注', '3', '2018-02-24 23:08:21', '2018-03-09 16:25:03', '1', '0');
INSERT INTO `shopping_category2` VALUES ('17', '缝纫针织', '默认备注', '3', '2018-02-24 23:08:21', '2018-03-10 08:51:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('18', '骑行装备', '默认备注', '3', '2018-02-24 23:08:21', '2018-03-09 15:39:13', '1', '0');
INSERT INTO `shopping_category2` VALUES ('19', '珠宝首饰', '默认备注', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('20', '时尚饰品', '默认备注', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('21', '品质手表', '默认备注', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('22', '眼镜配饰', '默认备注', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('23', '手机', '默认备注', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('24', '平板', '默认备注', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('25', '电脑', '默认备注', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('26', '相机', '默认备注', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('27', '大家电', '默认备注', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('28', '厨房电器', '默认备注', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('29', '生活电器', '默认备注', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('30', '个户电器', '默认备注', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('31', '办公耗材', '默认备注', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('32', '休闲零食', '默认备注', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('33', '饼干糕点', '默认备注', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('34', '生鲜果蔬', '默认备注', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('35', '粮油干货', '默认备注', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '1', '0');
INSERT INTO `shopping_category2` VALUES ('36', '二级测试类目', '专门用于二级类目的测试', '8', '2018-03-19 09:38:22', '2018-03-19 09:38:22', '1', '1');

-- ----------------------------
-- Table structure for `shopping_order`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_order`;
CREATE TABLE `shopping_order` (
  `order_id` bigint(100) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` bigint(100) unsigned NOT NULL COMMENT '谁的订单',
  `username` varchar(100) NOT NULL COMMENT '谁的订单',
  `order_memo` varchar(255) DEFAULT NULL COMMENT '给卖家的留言',
  `address` varchar(255) NOT NULL COMMENT '收获地址',
  `mobile` char(11) NOT NULL COMMENT '联系电话',
  `status` tinyint(1) unsigned NOT NULL COMMENT '订单状态：0未付款，1已付款，2待发货',
  `total` decimal(10,0) unsigned NOT NULL COMMENT '订单总金额',
  `gmt_create` datetime NOT NULL COMMENT '订单创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '订单修改时间',
  `id_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`order_id`),
  KEY `idx_status` (`status`) USING HASH,
  KEY `idx_user_id` (`user_id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_order
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_order_item`;
CREATE TABLE `shopping_order_item` (
  `item_id` bigint(100) unsigned NOT NULL COMMENT '订单明细id',
  `order_id` bigint(100) unsigned NOT NULL DEFAULT '0' COMMENT '订单编号',
  `product_id` bigint(100) unsigned NOT NULL DEFAULT '0' COMMENT '商品编号',
  `product_num` int(10) unsigned NOT NULL COMMENT '商品数量',
  `sub_total` decimal(10,0) unsigned NOT NULL COMMENT '小计',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`item_id`,`order_id`,`product_id`),
  UNIQUE KEY `uk_order_product` (`product_id`) USING BTREE,
  KEY `idx_order_id` (`order_id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_product`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_product`;
CREATE TABLE `shopping_product` (
  `product_id` bigint(100) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `product_name` varchar(40) NOT NULL COMMENT '商品名称',
  `category1_id` bigint(20) unsigned NOT NULL COMMENT '商品所属的一级类目',
  `category2_id` bigint(20) unsigned NOT NULL COMMENT '商品所属的二级类目',
  `purchase_price` decimal(30,0) unsigned NOT NULL COMMENT '采购价',
  `sale_price` decimal(30,0) unsigned NOT NULL COMMENT '销售价',
  `inventory` int(10) unsigned NOT NULL COMMENT '库存',
  `hits` bigint(30) unsigned NOT NULL DEFAULT '0' COMMENT '该商品的点击量',
  `img_src` varchar(255) NOT NULL COMMENT '图片地址',
  `description` varchar(255) NOT NULL COMMENT '商品描述',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录修改的日期',
  `is_show` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT '是否展示该商品，1展示，0隐藏',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`product_id`),
  KEY `idx_category1_id` (`category1_id`) USING HASH,
  KEY `idx_category2_id` (`category2_id`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_product
-- ----------------------------
INSERT INTO `shopping_product` VALUES ('1', '时尚潮流女装', '1', '1', '280', '998', '100', '66', '/images/product/women_man_clothes/cs10001.jpg', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('2', '坦博尔羽绒服', '1', '2', '380', '1098', '100', '1', '/images/product/women_man_clothes/cs10002.jpg', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('3', '貂皮大衣', '1', '3', '380', '1098', '100', '0', '/images/product/women_man_clothes/cs10003.jpg', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('4', '情侣毛衣111', '1', '1', '111', '1111', '10011', '0', '/images/product/a2677116-5d04-4d22-8a68-6c52a0a2995d.jpg', '爆款特卖aaaaa', '2018-03-13 09:29:15', '2018-03-18 16:54:04', '1', '0');
INSERT INTO `shopping_product` VALUES ('5', '海澜之家男装', '1', '5', '380', '1998', '100', '61', '/images/product/women_man_clothes/cs60010.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-23 23:37:24', '1', '0');
INSERT INTO `shopping_product` VALUES ('6', '冬季卫衣', '1', '6', '380', '1098', '100', '23', '/images/product/women_man_clothes/cs70007.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('7', '深冬羽绒', '1', '7', '380', '1098', '100', '6', '/images/product/women_man_clothes/cs70010.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('12', '高跟鞋', '2', '8', '120', '320', '100', '1', '/images/product/shoes_package/100102.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('13', '女士短靴', '2', '9', '120', '320', '100', '0', '/images/product/shoes_package/100101.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('14', '鳄鱼皮鞋', '2', '10', '120', '320', '100', '3', '/images/product/shoes_package/10004.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('15', '香奈儿包包', '2', '11', '120', '320', '100', '0', '/images/product/shoes_package/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('16', '男士公文包', '2', '12', '120', '320', '100', '0', '/images/product/shoes_package/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('17', '红领巾', '3', '13', '120', '320', '100', '0', '/images/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('18', '共享雨伞', '3', '14', '120', '320', '100', '0', '/images/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('19', '电熨斗', '3', '15', '120', '320', '100', '0', '/images/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('20', '除湿剂', '3', '16', '120', '320', '100', '0', '/images/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('21', '缝纫机', '3', '17', '120', '320', '100', '0', '/images/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('22', '车轮胎', '3', '18', '120', '320', '100', '0', '/images/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('23', '帅气墨镜', '4', '22', '120', '320', '100', '1', '/images/product/jewellery/10007.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('24', '潜水眼镜', '4', '22', '120', '320', '100', '49', '/images/product/jewellery/10008.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('25', '北极星手表', '4', '21', '120', '320', '100', '0', '/images/product/jewellery/10013.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('26', '学生眼镜', '4', '22', '120', '320', '100', '3', '/images/product/jewellery/10010.png', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '0');
INSERT INTO `shopping_product` VALUES ('27', '香蕉手机', '5', '23', '120', '320', '100', '0', '/product/mobile_phone/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('28', '草莓平板', '5', '24', '120', '320', '100', '0', '/product/mobile_phone/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('29', '联想电脑', '5', '25', '120', '320', '100', '0', '/product/mobile_phone/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('30', '摩卡相机', '5', '26', '120', '320', '100', '0', '/product/mobile_phone/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('31', '电视机', '1', '1', '120', '320', '100', '0', '/images/product/fa753768-398b-4cc6-9fd7-f3564fa56ccf.jpg', '爆款特卖', '2018-03-13 09:29:15', '2018-03-25 22:32:06', '1', '1');
INSERT INTO `shopping_product` VALUES ('32', '抽油烟机', '1', '1', '120', '320', '100', '0', '/images/product/0f06771a-0389-4ece-bdf4-77b33f05065f.jpg', '爆款特卖', '2018-03-13 09:29:15', '2018-03-25 22:33:09', '1', '1');
INSERT INTO `shopping_product` VALUES ('33', '豆浆机', '6', '29', '120', '320', '100', '0', '/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('34', '充电器', '6', '30', '120', '320', '100', '0', '/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('35', '办公袋', '6', '31', '120', '320', '100', '0', '/product/life_thing/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('36', '薯片', '7', '32', '120', '320', '100', '0', '/product/food/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('37', '蛋挞', '7', '33', '120', '320', '100', '0', '/product/food/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('38', '盒马生鲜', '7', '34', '120', '320', '100', '0', '/product/food/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('39', '7+1粮油', '7', '35', '120', '320', '100', '0', '/product/food/', '爆款特卖', '2018-03-13 09:29:15', '2018-03-13 09:29:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('56', '美妆', '1', '1', '11', '1', '1', '0', '/images/product/9426e270-d6f2-44e3-bf1f-9a91aa16259e.jpg', '嗯恩恩嫩恩恩额额', '2018-03-18 16:15:35', '2018-03-18 17:00:42', '1', '1');
INSERT INTO `shopping_product` VALUES ('57', '测试商品', '3', '15', '100', '230', '200', '0', '/www', '测试描述', '2018-03-18 17:10:32', '2018-03-18 17:10:32', '1', '1');
INSERT INTO `shopping_product` VALUES ('58', '测试商品', '8', '36', '110', '1110', '12', '0', '/images/product/fc9dae9d-c523-47db-8f81-d8fddaea2c9b.jpg', '多级反馈角度看', '2018-03-19 09:39:03', '2018-03-19 09:40:07', '1', '1');
INSERT INTO `shopping_product` VALUES ('59', 'test', '8', '36', '998', '1998', '112', '0', '/images/product/cd263942-cdd5-432b-91b0-b77dcf5be1f5.jpg', '爆款', '2018-03-19 09:42:45', '2018-03-19 09:42:45', '1', '1');
INSERT INTO `shopping_product` VALUES ('60', '测试商品二', '8', '36', '333', '23', '45', '0', '/images/product/698b8450-f167-44a5-ac0a-ee72db034862.jpg', '这是测试二', '2018-03-19 18:39:37', '2018-03-19 18:39:37', '1', '1');
INSERT INTO `shopping_product` VALUES ('61', '21212', '8', '36', '787', '7878', '777', '0', '/images/product/b7b788f6-838f-4999-8c86-cdbbe8e85ef8.jpg', 'qqwqw', '2018-03-19 18:48:15', '2018-03-19 18:48:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('62', '34434', '8', '36', '1212', '12', '33', '0', '/images/product/0cb5afa5-a6b6-48ab-9879-fd34e83d8cf5.jpg', 'ddddd', '2018-03-19 18:49:25', '2018-03-19 18:49:25', '1', '1');
INSERT INTO `shopping_product` VALUES ('63', '11', '8', '36', '11', '1', '1', '0', '/images/product/682aa30e-846c-4913-8655-fd0705b44734.jpg', '111', '2018-03-19 18:57:38', '2018-03-19 18:57:38', '1', '1');
INSERT INTO `shopping_product` VALUES ('64', '2', '8', '36', '2', '2', '2', '0', '/images/product/5b2c86d3-e1c7-49f7-8944-3880b64bdcb0.jpg', '2', '2018-03-19 18:57:56', '2018-03-19 18:57:56', '1', '1');
INSERT INTO `shopping_product` VALUES ('65', '潮流女装', '1', '1', '123', '232', '12', '115', '/images/product/192737e5-cc30-4d28-933e-b8a0a2d2f564.png', 'dfdsfsdf', '2018-03-23 23:50:34', '2018-03-23 23:50:34', '1', '0');
INSERT INTO `shopping_product` VALUES ('66', '男装', '1', '5', '345', '543', '232', '0', '/images/product/2b2bd253-0a61-4414-8f6f-c41867cfc220.png', '地方大幅度发', '2018-03-23 23:51:11', '2018-03-23 23:51:11', '1', '0');
INSERT INTO `shopping_product` VALUES ('67', '外套外套', '1', '6', '111', '333', '23', '1', '/images/product/4d094fb0-7185-42a3-bf40-c299ff30a4e2.png', '打发打发', '2018-03-23 23:53:03', '2018-03-23 23:53:03', '1', '0');
INSERT INTO `shopping_product` VALUES ('68', '毛衣', '1', '4', '34', '3434', '12', '1', '/images/product/e81cb1c2-452e-4518-8efd-c3d9027d2c47.jpg', '的方法打发打发', '2018-03-23 23:54:31', '2018-03-23 23:54:31', '1', '0');
INSERT INTO `shopping_product` VALUES ('69', '女鞋', '2', '8', '34', '555', '323', '1', '/images/product/00816061-f842-472d-be8a-bd6da92b2a5e.jpg', '333233', '2018-03-23 23:56:01', '2018-03-23 23:56:01', '1', '0');
INSERT INTO `shopping_product` VALUES ('70', '女鞋', '2', '9', '123', '32', '656', '57', '/images/product/b069d414-b0f4-4ca1-8e91-fb77a40fce43.png', '', '2018-03-23 23:56:20', '2018-03-23 23:56:20', '1', '0');
INSERT INTO `shopping_product` VALUES ('71', '女鞋', '2', '8', '444', '666', '23', '0', '/images/product/c86e8259-cd5f-4df2-901f-a0cc78527c46.png', '复古风格', '2018-03-23 23:56:40', '2018-03-23 23:56:40', '1', '0');
INSERT INTO `shopping_product` VALUES ('72', '电视机', '6', '27', '1212', '33', '121', '0', '', '1', '2018-03-25 15:01:54', '2018-03-25 15:01:54', '1', '1');
INSERT INTO `shopping_product` VALUES ('73', '电视机', '6', '27', '3', '3', '55', '0', '', '', '2018-03-25 15:02:21', '2018-03-25 15:02:21', '1', '1');
INSERT INTO `shopping_product` VALUES ('74', '电视机', '6', '27', '121', '21', '3', '0', '', 'f', '2018-03-25 15:02:36', '2018-03-25 15:02:36', '1', '1');
INSERT INTO `shopping_product` VALUES ('75', '外套外套', '1', '6', '12', '23', '23', '0', '/images/product/f985ec77-cf40-4eb5-9140-ed936d8ab64d.png', '232323', '2018-03-25 16:26:41', '2018-03-25 16:26:41', '1', '0');
INSERT INTO `shopping_product` VALUES ('76', '外套外套', '1', '6', '232', '23', '23', '0', '/images/product/a1cdb333-7816-44c8-a537-be842f519019.png', '2323', '2018-03-25 16:27:08', '2018-03-25 16:27:08', '1', '0');
INSERT INTO `shopping_product` VALUES ('77', '外套外套', '1', '6', '7878', '78', '23', '3', '/images/product/df40521b-68a3-4dd7-9912-7be87ce79780.png', '撒大声地撒多', '2018-03-25 16:27:46', '2018-03-25 16:27:46', '1', '0');
INSERT INTO `shopping_product` VALUES ('78', '服饰配件', '3', '13', '56', '56', '56', '0', '', '56', '2018-03-25 22:22:57', '2018-03-25 22:22:57', '1', '1');
INSERT INTO `shopping_product` VALUES ('79', '服饰配件', '3', '13', '67', '67', '67', '0', '', '6767', '2018-03-25 22:23:10', '2018-03-25 22:23:10', '1', '1');
INSERT INTO `shopping_product` VALUES ('80', '服饰配件', '3', '14', '54', '64', '45', '0', '', '', '2018-03-25 22:23:27', '2018-03-25 22:23:27', '1', '1');
INSERT INTO `shopping_product` VALUES ('81', '眼镜', '4', '22', '34', '34', '34', '0', '', '5353', '2018-03-25 22:24:15', '2018-03-25 22:24:15', '1', '1');
INSERT INTO `shopping_product` VALUES ('82', '眼镜', '4', '22', '111', '12', '32', '0', '/images/product/9ad6911b-84a5-4d4b-96f8-64a444a6b0ad.png', '232', '2018-03-25 22:24:41', '2018-03-25 22:24:41', '1', '1');
INSERT INTO `shopping_product` VALUES ('83', '眼镜', '4', '22', '454', '211', '334', '0', '/images/product/f34fed19-e5ec-4c62-a9c1-a51a5a9cbec7.png', '', '2018-03-25 22:25:00', '2018-03-25 22:25:00', '1', '1');
INSERT INTO `shopping_product` VALUES ('84', '眼镜', '4', '22', '54', '54', '64', '0', '/images/product/61fa9d31-4713-4c86-8389-b17f8b6fe28e.png', '梵蒂冈的风格', '2018-03-25 22:25:21', '2018-03-25 22:25:21', '1', '1');
INSERT INTO `shopping_product` VALUES ('85', '手机', '5', '23', '21', '21', '21', '0', '/images/product/aef79d1f-0a64-450e-8dc2-b827a1d79a2e.jpg', '21', '2018-03-25 22:27:05', '2018-03-25 22:27:05', '1', '0');
INSERT INTO `shopping_product` VALUES ('86', '手机', '5', '23', '4444', '4444', '123', '0', '/images/product/22eadcba-e87d-4f6e-9f41-a1fc5cb44b53.jpg', '2323', '2018-03-25 22:27:41', '2018-03-25 22:27:41', '1', '0');
INSERT INTO `shopping_product` VALUES ('87', '平板', '5', '24', '121', '313', '232', '1', '/images/product/0c3f749d-407e-4b0a-ba3a-ba2083d3489d.jpg', '是的是的', '2018-03-25 22:28:45', '2018-03-25 22:28:45', '1', '0');
INSERT INTO `shopping_product` VALUES ('88', '电脑', '5', '25', '23', '23', '23', '1', '/images/product/7dbd8efd-4429-4b5d-9bc8-e56056837fa1.jpg', '水电费第三方', '2018-03-25 22:29:32', '2018-03-25 22:29:32', '1', '0');
INSERT INTO `shopping_product` VALUES ('89', '相机', '5', '26', '23', '232', '424', '62', '/images/product/57411a8c-1531-4fac-ada2-eb02d28471eb.jpg', '地方斯蒂芬', '2018-03-25 22:30:22', '2018-03-25 22:30:22', '1', '0');
INSERT INTO `shopping_product` VALUES ('90', '电视机', '6', '29', '1212', '3131', '12', '0', '/images/product/c85965ef-dd30-421c-91f2-e0a04b646611.jpg', '是的发顺丰', '2018-03-25 22:35:38', '2018-03-25 22:35:38', '1', '0');
INSERT INTO `shopping_product` VALUES ('91', '电视机', '6', '29', '232', '2323', '12', '0', '/images/product/4c8ae988-3339-4f6c-9cf9-1919c1194a82.jpg', '的的非官方', '2018-03-25 22:36:33', '2018-03-25 22:36:33', '1', '0');
INSERT INTO `shopping_product` VALUES ('92', '电视机', '6', '29', '1212', '2323', '12', '0', '/images/product/6cf01a7f-f55e-4067-adff-c79dadc9f27e.jpg', '第三方的所发生的', '2018-03-25 22:37:17', '2018-03-25 22:37:17', '1', '0');
INSERT INTO `shopping_product` VALUES ('93', '电视机', '6', '29', '34', '3434', '21', '1248', '/images/product/ce00d849-71ce-46ea-8617-340a638219b9.jpg', '帝国时代发', '2018-03-25 22:37:46', '2018-03-25 22:37:46', '1', '0');
INSERT INTO `shopping_product` VALUES ('94', '抽油烟机', '6', '28', '34', '2323', '121', '1', '/images/product/1f0e977e-64c4-4d32-8506-0e905cdd8513.jpg', '大幅度所发生的', '2018-03-25 22:38:55', '2018-03-25 22:38:55', '1', '0');
INSERT INTO `shopping_product` VALUES ('95', '办公电脑', '6', '31', '1212', '323', '23', '0', '/images/product/a572f426-d01e-46ef-aa5e-4f61d2c01928.jpg', '是的是的', '2018-03-25 22:39:46', '2018-03-25 22:39:46', '1', '0');
INSERT INTO `shopping_product` VALUES ('96', '薯片', '7', '32', '3242', '3434', '121', '0', '/images/product/ad55c435-2322-470c-bb7c-4d9116d869d8.jpg', '地方大幅度', '2018-03-25 22:41:47', '2018-03-25 22:41:47', '1', '0');
INSERT INTO `shopping_product` VALUES ('97', '蔬菜', '7', '34', '3434', '3434', '1213', '1', '/images/product/bd13d505-1b39-4302-b4ea-fca1ddf80046.jpg', '地方水电费孙大夫', '2018-03-25 22:42:49', '2018-03-25 22:42:49', '1', '0');
INSERT INTO `shopping_product` VALUES ('98', '蛋糕', '7', '33', '1343', '232', '121', '0', '/images/product/b847907b-9045-45ea-8854-1bf3e5e6a385.jpg', '2132', '2018-03-25 22:43:39', '2018-03-25 22:43:39', '1', '0');
INSERT INTO `shopping_product` VALUES ('99', '粮油', '7', '35', '343', '232', '123', '0', '/images/product/fcf590e2-2559-497c-91b9-1e09ca1230b0.jpg', '的发送端发送端', '2018-03-25 22:44:16', '2018-03-25 22:44:16', '1', '0');
INSERT INTO `shopping_product` VALUES ('100', '服饰配件', '3', '13', '2323', '121', '232', '1', '/images/product/eb50d812-776e-4f63-8cfe-4727435acfd7.jpg', '的发送端发送端', '2018-03-25 22:48:04', '2018-03-25 22:48:04', '1', '0');
INSERT INTO `shopping_product` VALUES ('101', '抽油烟机', '3', '13', '232', '2323', '21', '0', '/images/product/3fa1b40b-b16b-4035-bb55-bba3e180a580.jpg', '斯蒂芬斯蒂芬', '2018-03-25 22:48:49', '2018-03-25 22:48:49', '1', '0');
INSERT INTO `shopping_product` VALUES ('102', '雨伞雨具', '3', '14', '3434', '232', '232', '0', '/images/product/d14feaa2-f5ab-42de-833c-0a6610b75020.jpg', '大范甘迪发', '2018-03-25 22:49:48', '2018-03-25 22:49:48', '1', '0');
INSERT INTO `shopping_product` VALUES ('103', '净化除味', '3', '16', '3434', '23', '2213', '0', '/images/product/02fcf591-e811-4e8e-9bdf-291860edc11b.jpg', '发鬼地方', '2018-03-25 22:50:29', '2018-03-25 22:50:29', '1', '0');
INSERT INTO `shopping_product` VALUES ('104', '骑行装备', '3', '18', '2323', '1231', '23', '0', '/images/product/68a27541-78bf-4a7d-ab73-7946a0ca0226.jpg', '打发打发', '2018-03-25 22:51:13', '2018-03-25 22:51:13', '1', '0');
INSERT INTO `shopping_product` VALUES ('105', '缝纫针织', '3', '17', '343', '232', '232', '0', '/images/product/414344b0-14cc-4cae-a092-3a6f230e80b6.jpg', '地方', '2018-03-25 22:52:16', '2018-03-25 22:52:16', '1', '0');
INSERT INTO `shopping_product` VALUES ('106', '熨斗', '3', '15', '343', '2323', '11', '0', '/images/product/ce62b5e6-1a2e-4ded-9678-0e8c65607f06.jpg', '地方', '2018-03-25 22:53:09', '2018-03-25 22:53:09', '1', '0');
INSERT INTO `shopping_product` VALUES ('107', '女包', '2', '11', '23', '23', '23', '0', '/images/product/b32bcd04-aaf7-4f32-9028-beeea11ac367.jpg', '二恶烷若', '2018-03-25 22:57:11', '2018-03-25 22:57:11', '1', '0');
INSERT INTO `shopping_product` VALUES ('108', '男包', '2', '12', '1212', '313', '12', '0', '/images/product/132c9627-4a84-4b7f-bdc5-ba8e51caadc5.jpg', 'SDR孙大夫', '2018-03-25 22:58:14', '2018-03-25 22:58:14', '1', '0');
INSERT INTO `shopping_product` VALUES ('109', '品质手表', '4', '21', '1212', '2323', '121', '0', '/images/product/4c563ae1-f550-4a83-bbc0-e0c6324d0a9b.png', '谁是谁的谁多所', '2018-03-25 22:59:54', '2018-03-25 22:59:54', '1', '0');
INSERT INTO `shopping_product` VALUES ('110', '钻戒', '4', '19', '99999', '99999', '121', '0', '/images/product/59f94f8b-9eea-478d-aa0f-d054becd0b91.jpg', '打发打发是', '2018-03-25 23:01:12', '2018-03-25 23:01:12', '1', '0');
INSERT INTO `shopping_product` VALUES ('111', '时尚饰品', '4', '20', '3435', '123', '1223', '0', '/images/product/77131fe2-d50f-46c0-b20d-e2057ef403e9.jpg', '打发打发', '2018-03-25 23:02:35', '2018-03-25 23:02:35', '1', '0');
INSERT INTO `shopping_product` VALUES ('112', '大冰箱', '6', '27', '5555', '3434', '1212', '0', '/images/product/dec3c318-9fdb-4afe-8533-86afa678b481.jpg', '肥嘟嘟', '2018-03-25 23:03:53', '2018-03-25 23:03:53', '1', '0');
INSERT INTO `shopping_product` VALUES ('113', '个户电器', '6', '30', '3434', '232', '121', '0', '/images/product/cabad2d6-a8cc-47f1-8358-08adf350f8f9.jpg', '打发打发', '2018-03-25 23:05:13', '2018-03-25 23:05:13', '1', '0');

-- ----------------------------
-- Table structure for `shopping_similarity`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_similarity`;
CREATE TABLE `shopping_similarity` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_ref_id` bigint(20) NOT NULL COMMENT '被参考的用户id',
  `similarity` decimal(8,7) NOT NULL COMMENT 'user_id与user_ref_id之间的相似度',
  PRIMARY KEY (`user_id`,`user_ref_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_similarity
-- ----------------------------
INSERT INTO `shopping_similarity` VALUES ('1', '2', '0.9994891');
INSERT INTO `shopping_similarity` VALUES ('1', '3', '0.9510095');
INSERT INTO `shopping_similarity` VALUES ('1', '4', '0.6101699');
INSERT INTO `shopping_similarity` VALUES ('1', '5', '0.8290315');
INSERT INTO `shopping_similarity` VALUES ('1', '6', '0.7550847');
INSERT INTO `shopping_similarity` VALUES ('2', '3', '0.9514955');
INSERT INTO `shopping_similarity` VALUES ('2', '4', '0.6104818');
INSERT INTO `shopping_similarity` VALUES ('2', '5', '0.8284235');
INSERT INTO `shopping_similarity` VALUES ('2', '6', '0.7550809');
INSERT INTO `shopping_similarity` VALUES ('3', '4', '0.6408098');
INSERT INTO `shopping_similarity` VALUES ('3', '5', '0.7858549');
INSERT INTO `shopping_similarity` VALUES ('3', '6', '0.6873625');
INSERT INTO `shopping_similarity` VALUES ('4', '5', '0.6673668');
INSERT INTO `shopping_similarity` VALUES ('4', '6', '0.5847285');
INSERT INTO `shopping_similarity` VALUES ('5', '6', '0.7201599');

-- ----------------------------
-- Table structure for `shopping_sys_admin`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_sys_admin`;
CREATE TABLE `shopping_sys_admin` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `login_name` varchar(255) NOT NULL COMMENT '登录名',
  `admin_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `mobile` char(11) NOT NULL COMMENT '移动电话',
  `age` tinyint(3) unsigned NOT NULL COMMENT '年龄',
  `sex` char(1) NOT NULL DEFAULT '男',
  `address` varchar(255) NOT NULL COMMENT '用户地址',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '用户状态：0正常，1冻结',
  `gmt_create` datetime NOT NULL COMMENT '用户创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '用户修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除的标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_login_name` (`login_name`) USING HASH,
  KEY `idx_username` (`admin_name`) USING BTREE,
  KEY `idx_status` (`status`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_sys_admin
-- ----------------------------
INSERT INTO `shopping_sys_admin` VALUES ('1', 'admin', '曲健磊', '8c20ee34f92493fe6bb33aa59d317d54534e7f7b3a0cd7a7b3602c66', '909301740@qq.com', '13954501821', '23', '男', '山东', '0', '2018-02-24 23:13:46', '2018-03-07 19:09:17', '0');
INSERT INTO `shopping_sys_admin` VALUES ('3', 'xiaoming', '小明', '6db577c1eab45ca48c56a0fe6d45189e5ac9cda9dcf0f73ad33343ee', '994564536@qq.com', '13765648897', '18', '女', '深圳', '0', '2018-02-26 19:12:13', '2018-02-26 19:12:13', '0');
INSERT INTO `shopping_sys_admin` VALUES ('4', 'array', '小王', 'f8ac215f6525bf6009278bdd9c7404f458116aa0bbc90f426b3255dd', '776546342@qq.com', '17806342234', '40', '男', '广东', '0', '2018-02-26 21:44:39', '2018-02-26 21:44:39', '0');
INSERT INTO `shopping_sys_admin` VALUES ('5', 'ss', 'qqq', '049a6c279f4e05bc1620d8b2497a44fdc16b2f8204409f045a8f7b80', '22222@qq.com', '12222222222', '112', '女', '1111111111', '0', '2018-02-27 18:58:07', '2018-02-28 21:28:17', '1');
INSERT INTO `shopping_sys_admin` VALUES ('7', 'dd', '小亮红', '7c5bb92486cd4972a802e3dbc665a4dcc52fd1fb2cd9d7f4e0009505', '991281927@qq.com', '15753506293', '43', '女', 'dfdfdf', '0', '2018-02-27 19:06:13', '2018-03-03 19:45:44', '0');
INSERT INTO `shopping_sys_admin` VALUES ('8', 'qwq', '小明', '5f27f07d1184afe2518c5e701db51e9084ea3cfb484467f84c9c5932', '1212', '12111111111', '121', '男', 'dfsdfsd', '0', '2018-02-27 19:08:33', '2018-03-03 20:05:19', '0');
INSERT INTO `shopping_sys_admin` VALUES ('9', 'xiaohua', '小花', '63da62e7d3df8355ee4b2ef9aadb9b56004f815b9f9ae3383b74075c', '545434323@qq.com', '14653436453', '25', '女', '张家口', '0', '2018-02-28 18:33:46', '2018-02-28 18:33:46', '0');
INSERT INTO `shopping_sys_admin` VALUES ('10', 'hello', '老刘', 'cd3ac2193579104915b77f19575a4eb84a53d92866b7bf4b91d43be1', '9098765651@qq.com', '11111111111', '111', '男', '深圳1', '0', '2018-02-28 18:35:59', '2018-03-02 14:29:56', '0');
INSERT INTO `shopping_sys_admin` VALUES ('11', 'zhangsan', '张珊', 'd4edb5264405b1f9d2a0acedb9732a092b4f3e3470013440095dd60e', '1212@qq.com', '12345678767', '21', '女', '广州', '0', '2018-02-28 18:38:33', '2018-02-28 18:38:33', '0');
INSERT INTO `shopping_sys_admin` VALUES ('12', 'df', 'd', '39e1cd85220ca3f21ab572b2c8b9be504f14c1c2c1f0426ce158fbb4', '1', '11111111111', '12', '女', '1', '0', '2018-02-28 18:40:54', '2018-02-28 18:40:54', '1');
INSERT INTO `shopping_sys_admin` VALUES ('13', 'zw', '赵武', '26a10b10e941fb994be6821508f812f6d356a433d6c99acde060f00e', '12121@qq.com', '11245343546', '18', '男', 'China', '0', '2018-03-03 14:06:44', '2018-03-03 14:06:44', '0');

-- ----------------------------
-- Table structure for `shopping_sys_member`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_sys_member`;
CREATE TABLE `shopping_sys_member` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `login_name` varchar(255) NOT NULL COMMENT '登录名',
  `member_name` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `mobile` char(11) NOT NULL COMMENT '移动电话',
  `age` tinyint(3) unsigned NOT NULL COMMENT '年龄',
  `sex` char(1) NOT NULL DEFAULT '男',
  `address` varchar(255) NOT NULL COMMENT '用户地址',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '用户状态：0正常，1冻结',
  `gmt_create` datetime NOT NULL COMMENT '用户创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '用户修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除的标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_login_name` (`login_name`) USING HASH,
  KEY `idx_username` (`member_name`) USING BTREE,
  KEY `idx_status` (`status`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_sys_member
-- ----------------------------
INSERT INTO `shopping_sys_member` VALUES ('1', 'cus1', '曲健磊h', '8c20ee34f92493fe6bb33aa59d317d54534e7f7b3a0cd7a7b3602c66', '909301740@qq.com', '15653577659', '21', '男', '山东', '0', '2018-02-24 23:13:46', '2018-02-24 23:13:46', '0');
INSERT INTO `shopping_sys_member` VALUES ('3', 'cus2', '小明h', '6db577c1eab45ca48c56a0fe6d45189e5ac9cda9dcf0f73ad33343ee', '994564536@qq.com', '13765648897', '18', '女', '深圳', '0', '2018-02-26 19:12:13', '2018-02-26 19:12:13', '0');
INSERT INTO `shopping_sys_member` VALUES ('4', 'cus3', '小王h', 'f8ac215f6525bf6009278bdd9c7404f458116aa0bbc90f426b3255dd', '776546342@qq.com', '17806342234', '40', '女', '广东', '0', '2018-02-26 21:44:39', '2018-04-17 19:19:06', '0');
INSERT INTO `shopping_sys_member` VALUES ('5', 'cus4', '老李h', '049a6c279f4e05bc1620d8b2497a44fdc16b2f8204409f045a8f7b80', '223487656@qq.com', '13876464546', '41', '男', '山东', '0', '2018-02-27 18:58:07', '2018-02-27 18:58:07', '0');
INSERT INTO `shopping_sys_member` VALUES ('7', 'cus5', '小红h', '7c5bb92486cd4972a802e3dbc665a4dcc52fd1fb2cd9d7f4e0009505', '1212', '12121212121', '21', '女', 'dfdfdf', '0', '2018-02-27 19:06:13', '2018-02-27 19:06:13', '0');
INSERT INTO `shopping_sys_member` VALUES ('8', 'hhone', '会员一号', '801d4668e38c0e9881ec03daf82296298084c6d544a8b9cf8919eb6f', '123@163.com', '12345454345', '34', '男', '深圳', '0', '2018-04-17 19:20:31', '2018-04-17 19:20:31', '0');
INSERT INTO `shopping_sys_member` VALUES ('11', 'tt_y', '131331', '6ae921a23d34dec7689b388e7064d4271ad361e3d7010fd602d8761e', '123@163.com', 'efsdf', '10', '男', 'sdsd', '0', '2018-04-23 20:52:49', '2018-04-23 20:52:49', '0');
