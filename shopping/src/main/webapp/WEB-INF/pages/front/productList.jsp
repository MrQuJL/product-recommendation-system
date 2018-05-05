<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>网上商城</title>
    <link href="${ctxJsAndCss}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctxJsAndCss}/css/product.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="container header">
        <%@ include file="/WEB-INF/pages/front/main/menu.jsp"%>
    </div>

    <div class="container productList">
        <!-- 左侧边栏的一二级类目列表 -->
        <div class="span6">
            <div class="hotProductCategory">
                <c:forEach var="c" items="${category1List}">
                    <dl>
                        <!-- 一级类目 -->
                        <dt>
                            <a href="${ctx}/findProductListByCategory1Id/${c.category1Id}/1/${applicationScope.pageSize}">
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

        <!-- 右边的商品列表 -->
        <div class="span18 last">
            <!-- 各项商品 -->
            <form id="productForm" action="">
                <div id="result" class="result table clearfix">
                    <ul>
                        <c:forEach var="p" items="${productList}">
                            <li>
                                <a href="${ctx}/getProductDetail/${p.productId}">
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
                    <!-- 当前是第几页/共多少页 -->
                    <span>第 ${currPage} / ${totalPage} 页</span>
                    <!-- 首页 -->
                    <span>
                        <a class="firstPage" href="${ctx}/${pageType}/${categoryId}/1/${applicationScope.pageSize}"> << </a>
                    </span>
                    <!-- 上一页 -->
                    <c:if test="${currPage != 1}">
                        <span>
                            <a class="previousPage" href="${ctx}/${pageType}/${categoryId}/${prePage}/${applicationScope.pageSize}"> < </a>
                        </span>
                    </c:if>
                    <!-- 具体的页数 -->
                    <c:forEach var="i" begin="1" end="${totalPage}">
                        <span>
                           <!-- 如果是当前页则不能够点击 -->
                           <c:if test="${i == currPage}">
                                <span class="currentPage">${currPage}</span>
                           </c:if>
                           <c:if test="${i != currPage }">
                             <a href="${ctx}/${pageType}/${categoryId}/${i}/${applicationScope.pageSize}">${i}</a>
                           </c:if>
                        </span>
                    </c:forEach>

                    <!-- 下一页 -->
                    <c:if test="${currPage != lastPage}">
                        <span>
                            <a class="nextPage" href="${ctx}/${pageType}/${categoryId}/${nextPage}/${applicationScope.pageSize}"> > </a>
                        </span>
                    </c:if>

                    <!-- 尾页 -->
                    <a class="lastPage" href="${ctx}/${pageType}/${categoryId}/${lastPage}/${applicationScope.pageSize}"> >> </a>
                </div>
            </form>
        </div>
    </div>
    <div class="container footer"></div>
</body>
</html>