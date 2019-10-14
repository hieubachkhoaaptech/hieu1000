<%-- 
    Document   : OrderDetail
    Created on : Aug 22, 2019, 12:23:23 PM
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
                    <form action="${pageContext.request.contextPath}/client/updateCart.htm">
                        <div class="row row-pb-lg">
                            <div class="col-md-12">
                                <div class="product-name d-flex">
                                    <div class="one-forth text-left px-4">
                                        <span>Tên sản phẩm</span>
                                    </div>
<!--                                    <div class="one-eight text-left">
                                        <span>Cỡ sản phẩm</span>
                                    </div>-->
                                    <div class="one-eight text-center">
                                        <span>Giá sản phẩm</span>
                                    </div>
                                    <div class="one-eight text-center">
                                        <span>Số lượng</span>
                                    </div>
                                    <div class="one-eight text-center">
                                        <span>Tổng tiền</span>
                                    </div>
                                    <div class="one-eight text-center px-4">
                                        <span>Xóa</span>
                                    </div>
                                </div>
                                <c:set var="s" value="0"></c:set>
                                <c:forEach items="${sessionScope.cart}" var="cart">
                                    <c:set var="s" value="${s + cart.productId.price * cart.quantity}"></c:set>
                                        <div class="product-cart d-flex">
                                            <div class="one-forth">
                                                <div class="product-img" style="background-image: url(/ShopFashion/jsp/Admin/images/${cart.productId.images});">
                                            </div>
                                            <div class="display-tc">
                                                <h3>${cart.productId.productName}</h3>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <span class="price">${cart.productId.price}</span>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <input type="text" name="quantity" class="form-control input-number text-center" value="${cart.quantity}" min="1" max="100"/>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <span class="price">${cart.productId.price * cart.quantity} vnđ</span>
                                            </div>
                                        </div>
                                        <div class="one-eight text-center">
                                            <div class="display-tc">
                                                <a href="${pageContext.request.contextPath}/client/deleteCart.htm?id=${cart.productId.productId}" onclick="return confirm('Bạn có chắc muốn xóa?')" class="closed"></a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <button type="submit" class="btn btn-primary btn-lg" style="margin-left: 80%">
                                Cập nhập giỏ hàng
                            </button>
                        </div>
                    </form>
                    <div class="row row-pb-lg">
                        <div class="col-md-12">
                            <div class="total-wrap">
                                <div class="row">
                                    <div class="col-sm-8">
                                    </div>
                                    <div class="col-sm-4 text-right">
                                        <div class="total">
                                            <div class="sub">
                                                <p><span>Tổng giá sản phẩm:</span> <span>${s} ₫</span></p>
                                                <p><span>Phí vận chuyển:</span> <span>20.000 ₫</span></p>
                                            </div>
                                            <div class="grand-total">
                                                <p><span><strong>Total:</strong></span> <span>${s+20000} ₫</span></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-right">
                        <p><a href="${pageContext.request.contextPath}/client/Checkout.htm" class="btn btn-primary btn-lg">Tiếp tục đặt hàng</a></p>
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


