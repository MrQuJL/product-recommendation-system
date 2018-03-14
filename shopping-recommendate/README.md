# 机器学习算法——协同过滤推荐算法

## 推荐系统的概念
推荐系统(Recommendation System, RS)，简单来说就是根据用户的日常行为，自动预测用户的喜好，为用户提供更多完善的服务。举个简单的例子，在天猫商城，我们浏览一本书之后，系统会为我们推荐购买了这本书的其他用户购买的其他的书：

推荐系统在很多方面都有很好的应用，尤其在现在的个性化方面发挥着重要的作用。

## 推荐算法的分类

推荐算法使用了一系列不同的技术，主要可以分为以下两类：

* 基于内容（content-based）的推荐：主要依据的是推荐项的性质，适合"用户焦点比较集中"的使用场景，比如垂直领域的内容推送。（非社交系统）

* 基于协同过滤（collaborative filtering）的推荐：主要是依据用户或者项之间的相似性，比较适合"给用户带点新鲜的东西"的使用场景，比如逛淘宝。（社交系统）
	* 基于项的协同过滤推荐：主要是依据项与项之间的相似性。
	* 基于用户的协同过滤推荐：主要是依据用户与用户之间的相似性。

## 相似度的度量方法

相似度的度量方法主要有以下三种：

* **欧式距离**<br/>
	欧式距离是使用较多的相似性的度量方法，在kMeans中就使用到欧式距离作为相似项的发现。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/欧几里得距离.png)

* **皮尔逊相关系数(Pearson Correlation)**<br/>
	皮尔逊相似性的度量对量级不敏感。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/皮尔逊相关系数.png)

* **余弦相似度(Cosine Similarity)**<br/>
	计算两个向量夹角的余弦，余弦值越接近1，就表明夹角越接近0度，也就是两个向量越相似，夹角等于0，说明两个向量相等，这就叫余弦相似性。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/余弦相似度.png)

## UserCF的原理（基于用户的协同过滤推荐）
1. 分析各个用户对 item 的评价（衡量的维度可以是浏览记录、购买记录等），列出用户和 item 之间的矩阵。
2. 依据用户对 item 的评价计算得出所有用户之间的相似度（采用余弦相似度度量公式）。
3. 选出与当前用户最相似的 N 个用户。
4. 将这 N 个用户评价最高并且当前用户又没有浏览过的 item 推荐给当前用户。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/UserCF.jpg)

## ItemCF的原理（基于项的协同过滤推荐）
1. 分析各个用户对 item 的浏览记录，列出 item 和用户之间的矩阵。
2. 依据浏览记录了分析得出所有 item 之间的相似度（任然采用余弦相似度度量公式）。
3. 对于当前用户正在浏览的 item，找出与之相似度最高的item。
4. 将这 N 个 item 推荐给用户。

![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/ItemCF.jpg)

## 基于内容的推荐算法的原理
1. 分析用户和 item 之间的属性（例如：用户喜欢买鼠标买外设，某个商品也具有外设这个属性）。
2. 把用户和 item 所拥有的属性分解成两个向量，计算这两个向量的相似度。
3. 找出用户和 item 之间相似度最高的前 N 个 item。
4. 将这个 N 个 item推荐给用户。
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/content.png)
用户和 item 分解成的向量如图：
![image](https://github.com/MrQuJL/online-shop/raw/master/shopping-imgs/vector.png)






