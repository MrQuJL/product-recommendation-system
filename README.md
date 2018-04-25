# 商品推荐系统（product-recommendation-system）

## 项目介绍

> 商品推荐是针对用户面对海量的商品信息而不知从何下手的一种解决方案，它可以根据用户的喜好，年龄，点击量，购买量以及各种购买行为来为用户推荐合适的商品。在本项目中采用的是基于用户的协同过滤的推荐算法来实现商品的推荐并在前台页面进行展示，我将会使用余弦相似度的度量方法来计算用户与用户之间相似性，最终将相似度较高的用户浏览的商品推荐给用户。<a href="https://github.com/MrQuJL/product-recommendation-system/tree/master/shopping-recommendate" target="blank">更多关于机器学习推荐算法的内容详见这里</a>

## 项目目标

* **商品推荐**：根据不同用户之间的相似性来推荐给用户合适的商品 **（finished）**
* 购物车管理：用户登录时显示上次添加到购物车中的商品
* 支付管理：调用第三方支付接口，实现商品的支付
* 一级类目管理：管理一级类目的相关功能 **（finished）**
* 二级类目管理：管理二级类目的相关功能 **（finished）**
* 商品管理：对商品进行上架，下架，修改信息 **（finished）**
* 订单管理：对客户的订单进行处理
* 管理员管理：管理管理员，用于商城后台的管理平台页面 **（finished）**
* 商城会员管理：管理商城会员，对商城页面的会员进行管理 **（finished）**
* 商城会员登录及注册：实现商城用户的登录功能以及注册功能 **（finished）**

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
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/shopping.png)

## 项目阶段性成果

### 用户相似度计算功能完成（2018-3-26 20:51）
以下为通过余弦相似度公式计算得出的用户与用户之间的相似度：
具体的代码实现见<a href="https://github.com/MrQuJL/product-recommendation-system/blob/master/shopping/src/main/java/com/lyu/shopping/recommendate/util/RecommendUtils.java" target="_blank">RecommendUtils.java</a>
```
1	2	0.999489144283392
1	3	0.951009468591049
1	4	0.6101699194694563
2	3	0.9514955455298099
2	4	0.6104817875805268
3	4	0.6408097907695536
```

### 余弦相似度的原理
1. 在三角形中，cos30°=二分之根三，cos60°=1/2。很明显，cos30°相比于cos60°更接近于 1，可以看出角度越接近于 0°，对应的余弦值越接近于 1，构成这个角度的两条边也就越接近于重合，也就可以认为这两条边越相似。

2. 在二维的平面向量中，两个向量之间夹角的余弦值公式为：<br/>
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/cos1.jpg)<br/>
假设两个向量a，b的坐标分别为(x1,y1)、(x2,y2)，所以最终可以化简为：<br/>
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/cos2.jpg)<br/>
**注：其中的x和y是两个不同的维度，在向量直角坐标系中可以认为是距x和y轴的距离，但是在实际的应用中，可以是把它理解为一个物体的任何一个可以衡量它与其他物体不同之处的属性...咳咳，还是说人话吧，在商品推荐中可以把向量 a 和向量 b 理解为两个不同的用户，把 (x1,y1) 理解为 a 用户对 x 商品的点击次数和对 y 商品的点击次数，再把对应的值带入上述公式即可求出两个用户之间的相似性，越接近于 1 ，说明两个用户的浏览行为越相似，就可以把一个用户浏览过的商品推荐给另一个没有浏览过该商品的用户，从而完成商品推荐。**

3. 设向量 A = (A1,A2,A3,...,An), B = (B1,B2,B3,...,Bn)，推广到多维，公式为：<br/>
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/cos3.jpg)<br/>
其中的 A1,A2,A3...就可以理解为该用户对不同的商品的点击量。

### 初步确定要推荐给用户的二级类目（2018-3-30 22:48）
通过上一阶段对用户相似度之间的求解，可以获得与某个用户最相似的前N个用户，（假设需要被推荐商品的用户为X）然后在这N个用户的浏览记录中查找X没有浏览的类目，但是这N个用户浏览的二级类目的类目的id，作为推荐给用户的二级类目id<br/>
具体的代码实现见<a href="https://github.com/MrQuJL/product-recommendation-system/blob/master/shopping/src/main/java/com/lyu/shopping/recommendate/util/RecommendUtils.java" target="_blank">RecommendUtils.java</a><br/>
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/recommendCategory2.png)<br/>

### 初步完成对用户的商品推荐（2018-4-4 21:33）
在上一个阶段确定了要推荐给用户的二级类目之后，找出每个类目下点击量最高的商品推荐给用户。<br/>
直观感受一下：<br/>
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/recommendateProduct.png)<br/>
ps：由于还没有实现前台的用户管理功能，所以这里的用户只能使用固定的ID模拟。<br/>

## 致谢
感谢您对项目的关注，如果项目中有任何错误或不妥，欢迎指正。

