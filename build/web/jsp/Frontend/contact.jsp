<%-- 
    Document   : contact
    Created on : Aug 22, 2019, 10:23:52 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <div id="colorlib-contact">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <h3>Thông tin liên hệ</h3>
                            <div class="row contact-info-wrap">
                                <div class="col-md-3">
                                    <p><span><i class="icon-location"></i></span> 236 đường Hoàng Quốc Việt, <br> quận Cầu Giấy, thành phố Hà Nội</p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-phone3"></i></span> <a href="tel://02437554010">+ 024 3755 4010</a></p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-paperplane"></i></span> <a href="mailto:tuyensinh@bachkhoa-aptech.edu.vn">tuyensinh@bachkhoa-aptech.edu.vn</a></p>
                                </div>
                                <div class="col-md-3">
                                    <p><span><i class="icon-globe"></i></span> <a href="https://bachkhoa-aptech.edu.vn">bachkhoa-aptech.edu.vn</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp" flush="true"/>
    </body>
</html>
