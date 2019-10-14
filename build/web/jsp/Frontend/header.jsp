<%-- 
    Document   : header
    Created on : Aug 19, 2019, 10:06:31 PM
    Author     : Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Shoes-Men</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Rokkitt:100,300,400,700" rel="stylesheet">

        <!-- Animate.css -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/icomoon.css">
        <!-- Ion Icon Fonts-->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/ionicons.min.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/bootstrap.min.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/magnific-popup.css">

        <!-- Flexslider  -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/flexslider.css">

        <!-- Owl Carousel -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/owl.carousel.min.css">
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/owl.theme.default.min.css">

        <!-- Date Picker -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/bootstrap-datepicker.css">
        <!-- Flaticons  -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/fonts/flaticon/font/flaticon.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="/ShopFashion/jsp/Frontend/css/style.css">

    </head>
    <body>

        <div class="colorlib-loader"></div>

        <div id="page">
            <nav class="colorlib-nav" role="navigation">
                <div class="top-menu">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-7 col-md-9">
                                <div id="colorlib-logo"><a href="${pageContext.request.contextPath}/client/home.htm">Shoes Men's</a></div>
                            </div>
                            <div class="col-sm-5 col-md-3">
                                <form action="${pageContext.request.contextPath}/client/searchPro.htm" class="search-wrap">
                                    <div class="form-group">
                                        <input type="search" name="productName" class="form-control search" placeholder="Search">
                                        <button  class="btn btn-primary submit-search text-center" type="submit"><i class="icon-search"></i></button>
                                    </div> 
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 text-left menu-1">
                                <ul>
                                    <li class="active"><a href="${pageContext.request.contextPath}/client/home.htm  ">Trang chủ</a></li>
                                    <li class="has-dropdown">
                                        <a href="${pageContext.request.contextPath}/client/ShowPro.htm">Sản phẩm</a>
                                    </li>
                                    <li><a href="${pageContext.request.contextPath}/client/About.htm">Giới thiệu</a></li>
                                    <li><a href="${pageContext.request.contextPath}/client/Contact.htm">Liên lạc</a></li>
                                    <li class="cart">
                                        <a href="${pageContext.request.contextPath}/client/Carts.htm"><i class="icon-shopping-cart"></i> Cart</a>
                                    </li>
                                    <li class="cart">
                                        <span> || </span>
                                    </li>
                                    <c:choose>
                                        <c:when test="${idCus==null}">
                                            <li class="cart">
                                                <a href="${pageContext.request.contextPath}/client/Login.htm"><i class=""></i> Đăng nhập</a>
                                                <span> | </span>
                                                <a href="${pageContext.request.contextPath}/client/Register.htm"><i class=""></i> Đăng ký</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <li class="has-dropdown cart">
                                                <a href="#">Xin chào: ${nameCus}</a>
                                                <ul class="dropdown">
                                                    <li class="">
                                                        <a href="${pageContext.request.contextPath}/client/cusDetail.htm?cusId=${sessionScope.frontend.customerId}">Tài khoản</a>

                                                        <a href="${pageContext.request.contextPath}/client/Logout.htm">Đăng xuất</a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
    </body>
</html>

