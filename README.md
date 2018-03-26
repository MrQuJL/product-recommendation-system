# 商品推荐系统（product-recommendation-system）

## 项目介绍

> 商品推荐是针对用户面对海量的商品信息而不知从何下手的一种解决方案，它可以根据用户的喜好，年龄，点击量，购买量以及各种购买行为来为用户推荐合适的商品。在本项目中采用的是基于用户的协同过滤的推荐算法来实现商品的推荐并在前台页面进行展示，我将会使用余弦相似度的度量方法来计算用户与用户之间相似性，最终将相似度较高的用户浏览的商品推荐给用户。<a href="https://github.com/MrQuJL/product-recommendation-system/tree/master/shopping-recommendate" target="blank">更多关于机器学习推荐算法的内容详见这里</a>

## 项目目标

* **商品推荐**：根据不同用户之间的相似性来推荐给用户合适的商品
* 购物车管理：用户登录时显示上次添加到购物车中的商品
* 支付管理：调用第三方支付接口，实现商品的支付
* 一级类目管理：管理一级类目的相关功能
* 二级类目管理：管理二级类目的相关功能
* 商品管理：对商品进行上架，下架，修改信息
* 订单管理：对客户的订单进行处理
* 客户管理：管理客户，对违规的客户冻结账号

## 项目所采用的技术

### 开发环境

* 操作系统：Windows8.1（计划迁移到linux服务器，敬请期待...）
* IDE：eclipse
* Java版本：1.8
* 数据库：mysql5.6.36
* 服务器：tomcat8
* 项目的构建工具：Maven

### 后台框架

* spring-4.2.1	轻量级的IOC和AOP的容器框架
* springMVC-4.2.1	表示层框架，负责匹配请求，处理请求，返回视图
* mybatis-3.3.1	建立与数据库的会话
* druid-1.1.16	为监控而生的数据库连接池

## 商品推荐流程
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/商品推荐流程.png)

## 界面
### 商城界面
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/shopping.png)

### 后台管理页面
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/界面.png)

## 数据库ER图

![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/er.jpg)

## 数据库表设计

* 用户购买行为表
* 用户相似度表
* 一级类目表
* 二级类目表
* 商品表
* 用户表
* 管理员表
* 订单表
* 订单明细表
* 购物车表

## 致谢
感谢您对项目的关注，如果项目中有任何错误或不妥，欢迎指正，我将不胜感激。
