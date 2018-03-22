<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>网上商城</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="container header">
        <%@ include file="/WEB-INF/pages/front/main/menu.jsp"%>
    </div>

    <div class="container productList">
        <!-- 左侧边栏的一二级类目列表 -->
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
                                <a href="${ctx}/findProductListByCategory2Id/${cs.category2Id}">
                                    ${cs.category2Name}
                                </a>
                            </dd>
                        </c:forEach>
                    </dl>
                </c:forEach>
            </div>
        </div>
        
        <!-- 右侧边栏的所有二级类目 -->
        <div class="span18 last">
            <!-- 各项商品 -->
            <form id="productForm" action="">
                <div id="result" class="result table clearfix">
                    <ul>
                        <c:forEach var="p" items="${productList}">
                            <li>
                                <a href="${ctx}/findByPid/${p.productId}">
                                    <img src="${p.imgSrc}" width="170" height="170" style="display: inline-block;" />
                                    <span style='color: green'>${p.productName}</span>
                                    <span class="price"> 商城价： ￥${p.salePrice}</span>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>

                <!-- 分页 -->
                <div class="pagination">
                    <!-- 根据一级分类的cid是不是为空来显示上一页下一页的状况 -->
                    <c:if test="${cid != null }">
                        <span>第 <c:out value="${page}" />/<c:out value="${count}" />页
                        </span>
                        <!-- 首页 -->
                        <span><a class="firstPage"
                            href="${pageContext.request.contextPath}/findByCid/${cid}/1"></a></span>
                        <c:if test="${page != 1}">
                            <span><a class="previousPage"
                                href="${pageContext.request.contextPath}/findByCid/${cid}/<c:out value="${page-1}"/>"></a></span>
                        </c:if>

                        <c:forEach var="i" begin="1" end="${count }">
                            <span>
                               <!-- 如果是当前页则不能够点击 -->
                               <c:if test="${i == page }">
                                    <span class="currentPage">${page }</span>
                               </c:if>
                               <c:if test="${i != page }">
                                 <a href="${pageContext.request.contextPath}/findByCid/${cid}/${i}">
                                    ${i}
                                 </a>
                               </c:if>
                            </span>
                        </c:forEach>

                        <!-- 下一页 -->
                        <c:if test="${page !=count }">
                            <span><a class="nextPage"
                                href="${pageContext.request.contextPath}/findByCid/${cid}/<c:out value="${page+1}"/>"></a></span>
                        </c:if>

                        <!-- 尾页 -->
                        <a class="lastPage"
                            href="${pageContext.request.contextPath}/findByCid/${cid}/<c:out value="${count}"/>"></a>
                    </c:if>

                    <!-- 二级分类的上一页和下一页 -->
                    <c:if test="${csid != null }">
                        <span>第 <c:out value="${page}" />/<c:out value="${count}" />页
                        </span>

                        <!-- 首页 -->
                        <span>
                            <a class="firstPage" href="${pageContext.request.contextPath}/findByCsid/${csid}/1"></a>
                        </span>

                        <c:if test="${page != 1}">
                            <span><a class="previousPage"
                                href="${pageContext.request.contextPath}/findByCsid/${csid}/<c:out value="${page-1}"/>"></a></span>
                        </c:if>

                        <c:forEach var="i" begin="1" end="${count }">
                            <span>
                               <!-- 如果是当前页则不能够点击 -->
                               <c:if test="${i == page }">
                                    <span class="currentPage">${page }</span>
                               </c:if>
                               <c:if test="${i != page }">
                                 <a href="${pageContext.request.contextPath}/findByCsid/${csid}/<c:out value="${i}"/>">
                                    <c:out value="${i}" /></a>
                                </c:if>
                            </span>
                        </c:forEach>

                        <!-- 下一页 -->
                        <c:if test="${page !=count }">
                            <span><a class="nextPage"
                                href="${pageContext.request.contextPath}/findByCsid/${csid}/<c:out value="${page+1}"/>"></a></span>
                        </c:if>

                        <!-- 尾页 -->
                        <a class="lastPage"
                            href="${pageContext.request.contextPath}/findByCsid/${csid}/<c:out value="${count}"/>"></a>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
    <div class="container footer">

        <%--<div class="span24">
                <div class="copyright">Copyright © 2017-2017  版权所有</div>
        </div>--%>
    </div>
</body>
</html>