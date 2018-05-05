<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
    <meta http-equiv='Content-Type' content='text/html;charset=utf-8' />
    <title>购物车</title>
    <meta name='keywords' content='关键词,关键词' />
    <meta name='description' content='网站描述' />
    <link href="${ctxJsAndCss}/css/slider.css" rel="stylesheet" type="text/css" />
    <link href="${ctxJsAndCss}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctxJsAndCss}/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <!-- 商品页面头部 -->
    <div class="container header">
        <%@ include file="/WEB-INF/pages/front/main/menu.jsp"%>
    </div>
    
    <!-- 当购物车不为空的情况  -->
    <div class="container cart">
        <c:if test="${sessionScope.cart.cartItems.size() != 0 }">
            <div class="span24">
                <table>
                <tbody>
                <tr>
                    <th>图片</th>
                    <th>商品</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>
                    <th>操作</th>
                </tr>
                
                 <c:forEach var="cartItem" items="${sessionScope.cart.cartItems}">
                <tr>
                    <td width="60">
                        <a href="${pageContext.request.contextPath }/findByPid/<c:out value="${cartItem.product.pid}"/>">
                            <img src="${pageContext.request.contextPath}/<c:out value="${cartItem.product.image}"/>"/>
                        </a>
                    </td>
                    <td>
                        <a target="_blank" href="${ pageContext.request.contextPath }/findByPid/<c:out value="${cartItem.product.pid}"/>">
                            <c:out value="${cartItem.product.pname}"/></a>
                     </td>
                     <td>${cartItem.product.shopPrice }</td>
                     <td class="quantity" width="60"><c:out value="${cartItem.count}"/></td>
                     <td width="140">
                        <span class="subtotal">￥<c:out value="${cartItem.subtotal}"/></span>
                     </td>
                     <td><a href="${ pageContext.request.contextPath }/removeCart/<c:out value="${cartItem.product.pid}"/>"
                                class="delete">删除</a>
                     </td>
                </tr>
                </c:forEach>
                </tbody>
                </table>
             
                
                <div class="bottom">

                <a href="${ pageContext.request.contextPath }/clearCart"
                        id="clear" class="clear">清空购物车</a> 
                        <a href="#"  id="submit" class="submit">提交订单</a>
            </div>
            </div>
        </c:if>
    </div>
     
     <!-- 当购物车为空的情况  -->
     <c:if test="${sessionScope.cart.cartItems == 0 }">
        <div class="span24">
            <div class="step step1">
                <center style="color: red">
                    <span>
                        <h2>您还没有
                            <a href="${ pageContext.request.contextPath }/index" style="color: #843d11">购物</a>
                                                                             或未
                            <a href="${ pageContext.request.contextPath }/userLogin" style="color: #843d11">登录</a>
                                                                ！！！ </h2>
                   </span>
                </center>
            </div>
        </div>
    </c:if>
    <!-- 页脚  -->
    <div class="container footer">
        <div class="span24">
            <div class="copyright">曲健磊 Copyright © 2018-2018 版权所有</div>
        </div>
    </div>
</body>
</html>
