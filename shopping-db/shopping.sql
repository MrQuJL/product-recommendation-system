/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : shopping

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-02-24 23:21:09
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`category1_id`),
  UNIQUE KEY `idx_category1_name` (`category1_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_category1
-- ----------------------------
INSERT INTO `shopping_category1` VALUES ('1', '女装男装', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '0');
INSERT INTO `shopping_category1` VALUES ('2', '鞋靴箱包', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '0');
INSERT INTO `shopping_category1` VALUES ('3', '日常生活用品', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '0');
INSERT INTO `shopping_category1` VALUES ('4', '珠宝配饰', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '0');
INSERT INTO `shopping_category1` VALUES ('5', '手机数码', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '0');
INSERT INTO `shopping_category1` VALUES ('6', '家用电器', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '0');
INSERT INTO `shopping_category1` VALUES ('7', '食品', '2018-02-24 22:55:02', '2018-02-24 22:55:02', '0');

-- ----------------------------
-- Table structure for `shopping_category2`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_category2`;
CREATE TABLE `shopping_category2` (
  `category2_id` bigint(100) unsigned NOT NULL AUTO_INCREMENT COMMENT '二级类目id',
  `category2_name` varchar(20) NOT NULL COMMENT '二级类目名称',
  `category1_id` bigint(20) NOT NULL COMMENT '所属的一级类目的id',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录被修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除的标识',
  PRIMARY KEY (`category2_id`),
  UNIQUE KEY `idx_category2_name` (`category2_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_category2
-- ----------------------------
INSERT INTO `shopping_category2` VALUES ('1', '潮流女装', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('2', '初冬羽绒', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('3', '毛皮大衣', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('4', '温暖毛衣', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('5', '精选男装', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('6', '冬季外套', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('7', '羽绒服', '1', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('8', '女鞋', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('9', '短靴', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('10', '男鞋', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('11', '女包', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('12', '男包', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('13', '服饰配件', '2', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('14', '雨伞雨具', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('15', '洗嗮/熨烫', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('16', '净化除味', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('17', '缝纫针织', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('18', '骑行装备', '3', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('19', '珠宝首饰', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('20', '时尚饰品', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('21', '品质手表', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('22', '眼镜配饰', '4', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('23', '手机', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('24', '平板', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('25', '电脑', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('26', '相机', '5', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('27', '大家电', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('28', '厨房电器', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('29', '生活电器', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('30', '个户电器', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('31', '办公耗材', '6', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('32', '休闲零食', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('33', '饼干糕点', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('34', '生鲜果蔬', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');
INSERT INTO `shopping_category2` VALUES ('35', '粮油干货', '7', '2018-02-24 23:08:21', '2018-02-24 23:08:21', '0');

-- ----------------------------
-- Table structure for `shopping_order`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_order`;
CREATE TABLE `shopping_order` (
  `order_id` bigint(100) unsigned NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `order_memo` varchar(255) DEFAULT NULL COMMENT '给卖家的留言',
  `address` varchar(255) NOT NULL COMMENT '收获地址',
  `mobile` char(11) NOT NULL COMMENT '联系电话',
  `status` tinyint(1) unsigned NOT NULL COMMENT '订单状态：0未付款，1已付款，2待发货',
  `total` decimal(10,0) unsigned NOT NULL COMMENT '订单总金额',
  `gmt_create` datetime NOT NULL COMMENT '订单创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '订单修改时间',
  `id_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`order_id`),
  KEY `idx_status` (`status`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_order
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_order_item`;
CREATE TABLE `shopping_order_item` (
  `order_id` bigint(100) unsigned NOT NULL DEFAULT '0' COMMENT '订单编号',
  `product_id` bigint(100) unsigned NOT NULL DEFAULT '0' COMMENT '商品编号',
  `product_num` int(10) unsigned NOT NULL COMMENT '商品数量',
  `sub_total` decimal(10,0) unsigned NOT NULL COMMENT '小计',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
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
  `product_id` bigint(100) unsigned NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `product_name` varchar(40) NOT NULL COMMENT '商品名称',
  `category1_id` bigint(20) unsigned NOT NULL COMMENT '商品所属的一级类目',
  `category2_id` bigint(20) unsigned NOT NULL COMMENT '商品所属的二级类目',
  `purchase_price` decimal(30,0) unsigned NOT NULL COMMENT '采购价',
  `sale_price` decimal(30,0) unsigned NOT NULL COMMENT '销售价',
  `inventory` int(10) unsigned NOT NULL COMMENT '库存',
  `img_src` varchar(255) NOT NULL COMMENT '图片地址',
  `description` varchar(255) NOT NULL COMMENT '商品描述',
  `is_hot` tinyint(1) unsigned NOT NULL COMMENT '是否是热门商品',
  `gmt_create` datetime NOT NULL COMMENT '记录创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '记录修改的日期',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`product_id`),
  KEY `idx_category1_id` (`category1_id`) USING HASH,
  KEY `idx_category2_id` (`category2_id`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_product
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_user`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_user`;
CREATE TABLE `shopping_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `login_name` varchar(255) NOT NULL COMMENT '登录名',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile` char(11) DEFAULT NULL COMMENT '移动电话',
  `age` tinyint(1) unsigned NOT NULL COMMENT '用户年龄',
  `address` varchar(255) NOT NULL COMMENT '用户地址',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '用户状态：0正常，1冻结',
  `is_admin` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否是管理员',
  `gmt_create` datetime NOT NULL COMMENT '用户创建的时间',
  `gmt_modified` datetime NOT NULL COMMENT '用户修改的时间',
  `is_deleted` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '逻辑删除的标识',
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`) USING BTREE,
  KEY `idx_status` (`status`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_user
-- ----------------------------
INSERT INTO `shopping_user` VALUES ('1', 'admin', '曲健磊', '123456', '909301740@qq.com', '15653577659', '23', '山东', '0', '1', '2018-02-24 23:13:46', '2018-02-24 23:13:46', '0');
INSERT INTO `shopping_user` VALUES ('2', 'lisi', '李四', '654321', '123456@qq.com', '17806346654', '45', '北京', '0', '0', '2018-02-24 23:16:36', '2018-02-24 23:16:36', '0');
