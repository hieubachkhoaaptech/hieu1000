<%-- 
    Document   : checkout
    Created on : Aug 23, 2019, 4:52:14 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<!DOCTYPE HTML>
<html>
    <body>
        <jsp:include page="header.jsp" flush="true"/>
        <div class="colorlib-loader"></div>

        <div id="page">


            <div class="breadcrumbs">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <p class="bread"><span><a href="${pageContext.request.contextPath}/client/home.htm">Trang chủ</a></span> / <span>Giỏ hàng</span></p>
                        </div>
                    </div>
                </div>
            </div>


            <div class="colorlib-product">
                <div class="container">
                    <div class="row row-pb-lg">
                        <div class="col-md-10 offset-md-1">
                            <div class="process-wrap">
                                <div class="process text-center active">
                                    <p><span>01</span></p>
                                    <h3>Giỏ hàng</h3>
                                </div>
                                <div class="process text-center">
                                    <p><span>02</span></p>
                                    <h3>Đặt hàng</h3>
                                </div>
                                <div class="process text-center">
                                    <p><span>03</span></p>
                                    <h3>Đặt hàng hoàn tất</h3>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-lg-8">
                            <form action="" modelAttribute="upCus" method="post" class="colorlib-form">
                                <h2>Thông tin đặt hàng</h2>
                                <div class="row">

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="fname">Tên khách hàng:</label>
                                            <input readonly="true" type="text" id="fname" value="${frontend.customerName}" path="customerName" class="form-control" placeholder=""/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="fname">Địa chỉ nhận hàng:</label>
                                            <input type="text" value="${frontend.address}" path="address" id="address" class="form-control" placeholder=""/>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="companyname">Email nhận hàng:</label>
                                            <input type="email" value="${frontend.email}" path="email" id="towncity" class="form-control" placeholder=""/>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="stateprovince">Số điện thoại nhận hàng:</label>
                                            <input type="text" value="${frontend.phone}" path="phone" id="fname" class="form-control" placeholder=""/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="stateprovince">Phương thức vận chuyển:</label>
                                            <input type="text" readonly="true" value="Chuyển phát nhanh" path="#" id="fname" class="form-control" placeholder=""/>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="row">
                                            <div class="col-md-12 text-right">
                                                <p><a href="#" class="btn btn-primary">Đặt hàng</a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="col-lg-4">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="cart-detail">
                                        <h2>Giỏ hàng</h2>
                                        <ul>
                                            <li>
                                                <span>Subtotal</span> <span></span>
                                                <ul>
                                                    <c:set var="s" value="0"></c:set>
                                                    <c:forEach items="${sessionScope.cart}" var="cart">
                                                        <c:set var="s" value="${s + cart.productId.price * cart.quantity}"></c:set>
                                                        <li>
                                                            <span>${cart.quantity} x ${cart.productId.productName}</span> <span>${cart.productId.price} ₫</span>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </li>
                                            <li><span>Chi phí vận chuyển</span> <span>20.000 ₫</span></li>
                                            <li><span>Tổng hóa đơn:</span> <span>${s} ₫</span></li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="w-100"></div>

                                <div class="col-md-12">
                                    <div class="cart-detail">
                                        <h2>Phương thức thanh toán</h2>
                                        <div class="form-group">
                                            <div class="col-md-12">
                                                <div class="">
                                                    <label>Thanh toán khi nhận hàng</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-12 text-center">
                            <p><a href="${pageContext.request.contextPath}/client/ShowPro.htm" class="btn btn-primary btn-lg">Tiếp tục mua hàng</a></p>
                        </div>
                    </div>
                    <div class="row">
                    </div>
                </div>
            </div>

            <jsp:include page="footer.jsp" flush="true"/>
        </div>

        <div class="gototop js-top">
            <a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
        </div>

        <!-- jQuery -->
        <script src="js/jquery.min.js"></script>
        <!-- popper -->
        <script src="js/popper.min.js"></script>
        <!-- bootstrap 4.1 -->
        <script src="js/bootstrap.min.js"></script>
        <!-- jQuery easing -->
        <script src="js/jquery.easing.1.3.js"></script>
        <!-- Waypoints -->
        <script src="js/jquery.waypoints.min.js"></script>
        <!-- Flexslider -->
        <script src="js/jquery.flexslider-min.js"></script>
        <!-- Owl carousel -->
        <script src="js/owl.carousel.min.js"></script>
        <!-- Magnific Popup -->
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>
        <!-- Date Picker -->
        <script src="js/bootstrap-datepicker.js"></script>
        <!-- Stellar Parallax -->
        <script src="js/jquery.stellar.min.js"></script>
        <!-- Main -->
        <script src="js/main.js"></script>

    </body>
</html>
