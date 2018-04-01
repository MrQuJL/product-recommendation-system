<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html;charset=utf-8' />
	<title>商城主页</title>
	<meta name="keywords" content="商城,网上购物,网购,进口食品,美容护理,母婴玩具,家用电器,手机数码,家居生活,服饰内衣,营养保健,钟表珠宝,饰品箱包,汽车生活,图书音像,礼品卡"/>
    <meta name="description" content="网上商城，中国线上购物的地标网站，亚洲超大的综合性购物平台，拥有10万多品牌商家。每日发布大量国内外商品！正品网购，上网上商城！网上商城千万大牌正品,品类全，一站购，支付安全，退换无忧！理想生活上网上商城!"/>
    <link href="${ctxJsAndCss}/css/slider.css" rel="stylesheet" type="text/css" />
    <link href="${ctxJsAndCss}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctxJsAndCss}/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="container header">
        <!-- 包含进去首页头部的文件 -->
        <%@ include file="/WEB-INF/pages/front/main/menu.jsp"%>
    </div>

    <div class="container index">
        <div class="span24">
            <div id="hotProduct" class="hotProduct clearfix">
                <div class="title">
                    <strong>推荐商品</strong>
                    <!-- <a  target="_blank"></a> -->
                </div>
                <ul class="tab">
                    <li class="current"><a href="#" target="_blank"></a></li>
                    <li><a target="_blank"></a></li>
                    <li><a target="_blank"></a></li>
                </ul>

                <ul class="tabContent" style="display: block;">
                    <c:forEach var="p" items="${recommendateList}">
                        <li>
                            <a href="${ctx}/getProductDetail/${p.productId}">
                                <img src="${p.imgSrc}" width="170" height="170" style="display: inline-block;" />
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="span24">
            <div id="newProduct" class="newProduct clearfix">
                <div class="title">
                    <strong>最新商品</strong> <a target="_blank"></a>
                </div>
                <ul class="tab">
                    <li class="current"><a href="#" target="_blank"></a></li>
                    <li><a target="_blank"></a></li>
                    <li><a target="_blank"></a></li>
                </ul>

                <ul class="tabContent" style="display: block;">
                    <c:forEach items="${nList}" var="p">
                        <li>
                            <a href="${ctx}/findByPid/${p.productId}" target="_blank">
                                <img src="${ctx}/${p.imgSrc}" style="display: block;" />
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <div class="span24">
            <div class="friendLink">
                <dl>
                    <dt>新手指南</dt>
                    <dd>
                        <a target="_blank">支付方式</a> |
                    </dd>
                    <dd>
                        <a target="_blank">配送方式</a> |
                    </dd>
                    <dd>
                        <a target="_blank">售后服务</a> |
                    </dd>
                    <dd>
                        <a target="_blank">购物帮助</a> |
                    </dd>
                    <dd>
                        <a target="_blank">蔬菜卡</a> |
                    </dd>
                    <dd>
                        <a target="_blank">礼品卡</a> |
                    </dd>
                    <dd>
                        <a target="_blank">银联卡</a> |
                    </dd>
                    <dd>
                        <a target="_blank">亿家卡</a> |
                    </dd>

                    <dd class="more">
                        <a>更多</a>
                    </dd>
                </dl>
            </div>
        </div>
    </div>

    <div class="container footer">
        <div class="span24">
            <div class="copyright">Copyright © 2018-2018 版权所有</div>
        </div>
    </div>
</body>
</html>