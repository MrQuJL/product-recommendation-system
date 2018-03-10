# 机器学习算法——协同过滤推荐算法

## 推荐系统的概念
推荐系统(Recommendation System, RS)，简单来说就是根据用户的日常行为，自动预测用户的喜好，为用户提供更多完善的服务。举个简单的例子，在天猫商城，我们浏览一本书之后，系统会为我们推荐购买了这本书的其他用户购买的其他的书：

推荐系统在很多方面都有很好的应用，尤其在现在的个性化方面发挥着重要的作用。

## 推荐系统的分类

推荐系统使用了一系列不同的技术，主要可以分为以下两类：

* 基于内容（content-based）的推荐：主要依据的是推荐项的性质，适合"用户焦点比较集中"的使用场景，比如垂直领域的内容推送。（物以类聚）

* 基于协同过滤（collaborative filtering）的推荐：主要是依据用户或者项之间的相似性，比较适合"给用户带点新鲜的东西"的使用场景，比如逛淘宝。（人以群分）

在协同过滤方法中，我们很显然的会发现，基于协同过滤的推荐系统用可以分为两类：

* 基于项的推荐系统：主要是依据项与项之间的相似性。
* 基于用户的推荐系统：主要是依据用户与用户之间的相似性。

## 相似度的度量方法

我们已经知道了可以通过哪些方法来进行商品推荐，那么如何计算相似度呢？

相似度的度量方法主要有以下三种：

* 欧式距离<br/>
	欧式距离是使用较多的相似性的度量方法，在kMeans中就使用到欧式距离作为相似项的发现。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/欧几里得距离.png)

* 皮尔逊相关系数(Pearson Correlation)<br/>
	皮尔逊相似性的度量对量级不敏感。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/皮尔逊相关系数.png)

* 余弦相似度(Cosine Similarity)<br/>
	计算两个向量夹角的余弦，余弦值越接近1，就表明夹角越接近0度，也就是两个向量越相似，夹角等于0，说明两个向量相等，这就叫余弦相似性。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/余弦相似度.png)

* 谷本系数(Tanimoto)<br/>

![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/谷本系数.png)


## 基于相似度的推荐系统

