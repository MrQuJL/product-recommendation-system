<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>网上商城</title>
    <link href="${ctxJsAndCss}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctxJsAndCss}/css/product.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctxJsAndCss}/js/jquery-1.8.3.js"></script>
    <script>
        function saveCart() {
            //验证购买数量是否非法
            var count = $("#count").val();
            var inventory = $("#inventory").val();
            if (eval(count) > eval(inventory)) {
                alert("库存量不足");
                return fasle;
            }
            //保存商品到购物车
            document.getElementById("cartForm").submit();
        }
    </script>
</head>
<body>
    <% float discount = 0; %>
    <div class="container header">
        <%@ include file="/WEB-INF/pages/front/main/menu.jsp"%>
    </div>
    <div class="container productContent">
        <div class="span6">
            <div class="hotProductCategory">
                <c:forEach var="c" items="${sessionScope.category1List}">
                    <dl>
                        <!-- 一级类目 -->
                        <dt>
                            <a href="${ctx}/findProductListByCategory1Id/${c.category1Id}">
                                ${c.category1Name}
                            </a>
                        </dt>
                        <!-- 当前一级类目下的二级类目 -->
                        <c:forEach var="cs" items="${c.category2List}">
                            <dd>
                                <a href="${ctx}/findProductListByCategory2Id/${cs.category2Id}/1/${applicationScope.pageSize}">
                                    ${cs.category2Name}
                                </a>
                            </dd>
                        </c:forEach>
                    </dl>
                </c:forEach>
            </div>
        </div>

        <div class="span18 last">
            <div class="productImage">
                <a title="" style="outline-style: none; text-decoration: none;"
                    id="zoom" rel="gallery">
                    <img style="opacity: 1;" title="商品图片" class="medium"
                            src="${product.imgSrc}" />
                </a>
            </div>
            
            <!-- 商品的具体信息 -->
            <div class="name">
                ${product.productName}
            </div>
            <div class="info">
                <dl style="font-size:12px;">全商城实物商品通用</dl>
                <dl>价格：<del>${product.salePrice + 400 }</del>
                </dl>
                <dl>
                    <dt style="vertical-align:bottom">促销价:</dt>
                    <dd>
                        <span style="color:#FF0036;">￥</span><strong style="vertical-align:bottom"> ${product.salePrice }</strong>
                        <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">限时抢购</a>
                    </dd>
                </dl>
            </div>

            <form id="cartForm" action="${ctx}/gotoCar" method="post">
                <input type="hidden" name="pid" value="" />
                <div class="action">
                    <dl class="quantity">
                        <dt>购买数量:</dt>
                        <dd>
                            <input id="count" name="count" value="1" maxlength="5" type="number" min="0" 
                                onpaste="return false;"/>
                        </dd>
                        <dd>件</dd>
                        <dd><input id="inventory" type="hidden" value="${product.inventory}"/></dd>
                        <dd>&nbsp;&nbsp;库存 ${product.inventory }件</dd>
                    </dl>
                </div>
                <div class="buy">
                    <a href="#">立即购买</a>
                    <a href="#" class="addCar">加入购物车</a>
                </div>
            </form>

            <div id="bar" class="bar">
                <ul>
                    <li id="introductionTab"><a href="#introduction">商品介绍</a></li>
                    <li id="comments"><a href="#comments">累计评价</a></li>
                </ul>
            </div>
            <div id="introduction" name="introduction" class="introduction">
                <div class="title">
                    <!-- 商品的描述 -->
                    <strong><c:out value="${product.description}" /></strong>
                </div>
                <div>
                    <!-- 商品图片 -->
                    <img src="${product.imgSrc}" />
                </div>
            </div>
        </div>
    </div>
</body>
</html>