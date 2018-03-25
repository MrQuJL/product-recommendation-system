<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>

<div class="span10 last">
    <div class="topNav clearfix">
        <ul>
            <!-- 若用户未登录 -->
            <c:if test="${sessionScope.user == null}">
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="${ pageContext.request.contextPath }/userLogin">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="${ pageContext.request.contextPath }/userRegister">注册</a>|
                </li>
            </c:if>

            <!-- 若用户已登录 -->
            <c:if test="${sessionScope.user != null}">
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <c:out value="${user.userName }"/>
                </li>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="${ pageContext.request.contextPath }/findOrderByUid/1">我的订单</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="${ pageContext.request.contextPath }/quit">退出</a>|
                </li>
            </c:if>

            <%--<li><a>会员中心</a> |</li>
            <li><a>购物指南</a> |</li>
            <li><a>关于我们</a></li>--%>
        </ul>
    </div>

    <div class="cart">
        <a href="${pageContext.request.contextPath}/myCart">购物车</a>
    </div>

</div>

<div class="span24">
    <ul class="mainNav">
        <li>
            <a href="${ctx}/index">首页</a>|
        </li>
        <c:forEach items="${sessionScope.category1List}" var="c">
            <li>
                <a href="${ctx}/findProductListByCategory1Id/${c.category1Id}/1/4">
                    ${c.category1Name}
                </a>
            </li>
        </c:forEach>
    </ul>
</div>