<%-- 
    Document   : updateCus
    Created on : Aug 23, 2019, 2:22:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
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
                        Cập nhật thông tin người dùng
                    </div>
                </div>
            </nav>
            <div class="colorlib-product">
                <div class="row" style="margin-left: 350px">
                    <div class="col-lg-8">
                        <f:form action="${pageContext.request.contextPath}/client/saveUpdateCus.htm" modelAttribute="upCus" method="post" class="colorlib-form">
                            <h2>Cập nhật thông tin người dùng</h2>
                            <div class="row">

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="fname">Tên khách hàng:</label>
                                        <f:input type="text" id="fname" path="customerName" class="form-control" placeholder=""/>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="lname">Tên đăng nhập:</label>
                                        <f:input type="text" id="lname" path="userName" class="form-control" placeholder=""/>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="companyname">Mật khẩu:</label>
                                        <f:input readonly="true" type="password" path="password" id="companyname" class="form-control" placeholder=""/>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="fname">Địa chỉ:</label>
                                        <f:input type="text" path="address" id="address" class="form-control" placeholder=""/>
                                    </div>
                                </div>

                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="companyname">Email:</label>
                                        <f:input type="email" path="email" id="towncity" class="form-control" placeholder=""/>
                                    </div>
                                </div>

                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="stateprovince">Số điện thoại:</label>
                                        <f:input type="text" path="phone" id="fname" class="form-control" placeholder=""/>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <div class="" style="margin-left: 350px">
                                            <p><button type="submit" class="btn btn-primary py-3 px-4">Cập nhật</button></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </f:form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" flush="true"/>
    </body>
</html>
