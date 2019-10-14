<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>

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
                            <p class="bread"><span><a href="${pageContext.request.contextPath}/client/home.htm">Home</a></span> / <span>Product Details</span></p>
                        </div>
                    </div>
                </div>
            </div>


            <div class="colorlib-product">
                <div class="container">
                    <form method="GET" action="${pageContext.request.contextPath}/client/addCart.htm">
                        <div class="row row-pb-lg product-detail-wrap">
                            <div class="col-sm-8">
                                <div class="">
                                    <div class="item">
                                        <div class="product-entry border">
                                            <a href="/ShopFashion/jsp/Admin/images/${p.images}" class="prod-img">
                                                <img src="/ShopFashion/jsp/Admin/images/${p.images}" alt="${p.productName}" style="width: 100%; height: 100%">
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="product-desc">
                                    <h3>${p.productName}</h3>
                                    <p class="price">
                                        <span>${p.price}</span>
                                    </p>
                                    <p>${p.descriptions}</p>
                                    <div class="size-wrap">
                                        <div class="flex-m flex-w p-b-10">
                                            <div class="s-text15 w-size15 t-center">
                                                Size
                                            </div>
                                            <div class="rs2-select2 rs3-select2 bo4 of-hidden w-size16">
                                                <select class="form-control" name="size" >
                                                    <c:forEach items="${s}" var="s">
                                                        <option value="${s.sizeId}">${s.sizeName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="flex-m flex-w">
                                            <div class="s-text15 w-size15 t-center">
                                                Color
                                            </div>

                                            <div class="rs2-select2 rs3-select2 bo4 of-hidden w-size16">
                                                <select class="form-control" name="color" >
                                                    <c:forEach items="${c}" var="c">
                                                        <option value="${c.colorId}">${c.colorName}</option>
                                                    </c:forEach>    
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="input-group mb-4">
                                        <span class="input-group-btn">
                                            <button type="button" class="quantity-left-minus btn"  data-type="minus" data-field="">
                                                <i class="icon-minus2"></i>
                                            </button>
                                        </span>
                                        <input readonly="true" type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
                                        <input readonly="true" hidden="true" type="text"  name="productId" class="form-control input-number" value="${p.productId}">

                                        <span class="input-group-btn ml-1">
                                            <button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
                                                <i class="icon-plus2"></i>
                                            </button>
                                        </span>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 text-center">
                                            <p class="addtocart">
                                                <button type="submit" class="btn btn-primary btn-lg">Add Cart</button>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <jsp:include page="footer.jsp" flush="true"/>
        </div>

        <div class="gototop js-top">
            <a href="#" class="js-gotop"><i class="ion-ios-arrow-up"></i></a>
        </div>

        <!-- jQuery -->
        <script src="/ShopFashion/jsp/Frontend/js/jquery.min.js"></script>
        <!-- popper -->
        <script src="/ShopFashion/jsp/Frontend/js/popper.min.js"></script>
        <!-- bootstrap 4.1 -->
        <script src="/ShopFashion/jsp/Frontend/js/bootstrap.min.js"></script>
        <!-- jQuery easing -->
        <script src="/ShopFashion/jsp/Frontend/js/jquery.easing.1.3.js"></script>
        <!-- Waypoints -->
        <script src="/ShopFashion/jsp/Frontend/js/jquery.waypoints.min.js"></script>
        <!-- Flexslider -->
        <script src="/ShopFashion/jsp/Frontend/js/jquery.flexslider-min.js"></script>
        <!-- Owl carousel -->
        <script src="/ShopFashion/jsp/Frontend/js/owl.carousel.min.js"></script>
        <!-- Magnific Popup -->
        <script src="/ShopFashion/jsp/Frontend/js/jquery.magnific-popup.min.js"></script>
        <script src="/ShopFashion/jsp/Frontend/js/magnific-popup-options.js"></script>
        <!-- Date Picker -->
        <script src="/ShopFashion/jsp/Frontend/js/bootstrap-datepicker.js"></script>
        <!-- Stellar Parallax -->
        <script src="/ShopFashion/jsp/Frontend/js/jquery.stellar.min.js"></script>
        <!-- Main -->
        <script src="/ShopFashion/jsp/Frontend/js/main.js"></script>
        <script>
            $(document).ready(function () {

                var quantitiy = 0;
                $('.quantity-right-plus').click(function (e) {

                    // Stop acting like a button
                    e.preventDefault();
                    // Get the field name
                    var quantity = parseInt($('#quantity').val());

                    // If is not undefined

                    $('#quantity').val(quantity + 1);


                    // Increment

                });

                $('.quantity-left-minus').click(function (e) {
                    // Stop acting like a button
                    e.preventDefault();
                    // Get the field name
                    var quantity = parseInt($('#quantity').val());

                    // If is not undefined

                    // Increment
                    if (quantity > 1) {
                        $('#quantity').val(quantity - 1);
                    } else {

                        alert("Không thể bé hơn 1");
                    }
                });

            });
        </script>


    </body>
</html>



