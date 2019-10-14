<%-- 
    Document   : CusDetail
    Created on : Aug 22, 2019, 9:24:11 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Shoes-Men</title>
        <meta charset="utf-8">
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true"/>
        <div class="colorlib-loader"></div>

        <div id="page">
            <nav class="colorlib-nav" role="navigation">
                <div class="top-menu">
                    <div class="container">
                        Thông tin người dùng
                    </div>
                </div>
            </nav>
            <div class="colorlib-product">
                <div class="row" style="margin-left: 350px">
                    <div class="col-lg-8">
                        <form modelAttribute="c" method="post" class="colorlib-form">
                            <h2>Thông tin người dùng</h2>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="fname">Tên khách hàng:</label>
                                        <input readonly="true" type="text" id="fname" value="${c.customerName}" class="form-control" placeholder=""/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="lname">Tên đăng nhập:</label>
                                        <input readonly="true" type="text" id="lname" value="${c.userName}" class="form-control" placeholder=""/>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="companyname">Mật khẩu:</label>
                                        <input readonly="true" type="password" value="${c.password}" id="companyname" class="form-control" placeholder=""/>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="fname">Địa chỉ:</label>
                                        <input readonly="true" type="text" value="${c.address}" id="address" class="form-control" placeholder=""/>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="companyname">Email:</label>
                                        <input readonly="true" type="email" value="${c.email}" id="towncity" class="form-control" placeholder=""/>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="stateprovince">Số điện thoại:</label>
                                        <input readonly="true" type="text" value="${c.phone}" id="fname" class="form-control" placeholder=""/>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <div class="" style="margin-left: 350px">
                                            <p><a href="${pageContext.request.contextPath}/client/initupdateCustomer.htm?cusId=${c.customerId}" class="btn btn-primary py-3 px-4">Cập nhật</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" flush="true"/>
    </body>
</html>
