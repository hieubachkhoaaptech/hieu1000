<%-- 
    Document   : ProviderLogo
    Created on : Aug 19, 2019, 10:15:43 PM
    Author     : Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shoes-Fashion</title>
    </head>
    <body>
        <div class="colorlib-partner">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8 offset-sm-2 text-center colorlib-heading colorlib-heading-sm">
                        <h2>Trusted Partners</h2>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${listProvider}" var="pro">
                        <div class="col partner-col text-center">
                            <h2>${pro.providerName}</h2>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
