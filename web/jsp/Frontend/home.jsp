<%-- 
    Document   : home
    Created on : Aug 23, 2019, 3:42:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="myTag" uri="../tlds/MyCustomTag.tld" %>
<html>
    <head>
        <title>Shoes-Men</title>
        <meta charset="utf-8">
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true"/>
        <jsp:include page="banner.jsp" flush="true"/>
        <div class="colorlib-loader"></div>

        <div id="page">
            <nav class="colorlib-nav" role="navigation">
                <div class="top-menu">
                    <div class="container">

                        <div class="row">
                            <div class="col-sm-12 text-left menu-1">
                                <ul>
                                    <li class="has-dropdown">
                                        <a href="${pageContext.request.contextPath}/client/catelog.htm?catelogId=${c.catelogId}">Loại giày</a>
                                        <ul class="dropdown" style="display: none;">
                                            <c:forEach items="${listCatelog}" var="c">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/client/catelog.htm?catelogId=${c.catelogId}" class="${c.catelogId}">${c.catelogName}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <li><span> | </span></li>
                                    <li class="has-dropdown">
                                        <a href="${pageContext.request.contextPath}/client/provider.htm?providerId=${c.providerId}">Thương hiệu</a>
                                        <ul class="dropdown" style="display: none;">
                                            <c:forEach items="${listProvider}" var="c">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/client/provider.htm?providerId=${c.providerId}" class="${c.providerId}">${c.providerName}</a>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                    <!--                                    <li class="cart"><a href="cart.html"><i class="icon-shopping-cart"></i> Cart [0]</a></li>-->
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <div class="colorlib-product">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <p><a href="${pageContext.request.contextPath}/client/ShowPro.htm" class="btn btn-primary btn-lg">Tất cả sản phẩm</a></p>
                        </div>
                    </div>
                    <div class="row row-pb-md">
                        <c:forEach items="${listProduct}" var="p">
                            <div class="col-lg-3 mb-4 text-center">
                                <div class="product-entry border">
                                    <a href="${pageContext.request.contextPath}/client/detailPro.htm?productId=${p.productId}" class="${p.productName}">
                                        <img src="/ShopFashion/jsp/Admin/images/${p.images}" alt="${p.productName}" style="width: 250px; height: 250px">
                                    </a>
                                    <div class="desc">
                                        <h2><a href="${pageContext.request.contextPath}/client/detailPro.htm?productId=${p.productId}" title="${p.productName}">${p.productName}</a></h2>
                                        <span class="price">Giá: ${p.price} ₫</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <div class="w-100"></div>

                    </div>
                        <div class="row mt-5" style="margin-left: 90%">
                        <div class="col text-center">
                            <div class="block-27">
                                <myTag:PaginationTaglib max="8" offset="${offset}" count="${count}" next="&raquo;" previous="&laquo;" uri="${pageContext.request.contextPath}/client/home.htm"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" flush="true"/>
    </body>
</html>

