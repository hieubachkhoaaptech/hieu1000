<%-- 
    Document   : login
    Created on : Aug 20, 2019, 9:38:04 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login V5</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="/ShopFashion/jsp/Frontend/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/css/util.css">
        <link rel="stylesheet" type="text/css" href="/ShopFashion/jsp/Frontend/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/bg-01.jpg');">
                <div class="wrap-login100 p-l-110 p-r-110 p-t-62 p-b-33">
                    <form class="login100-form validate-form flex-sb flex-w" action="${pageContext.request.contextPath}/client/loginClient.htm" method="POST">
                        <span class="login100-form-title p-b-53">
                            Sign In
                        </span>

                        <div class="p-t-31 p-b-9">
                            <span class="txt1">
                                Username
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" name="username" required="*">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="p-t-13 p-b-9">
                            <span class="txt1">
                                Password
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="password" name="password" required="*">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="container-login100-form-btn m-t-17">
                            <div style="color: red">${status}</div>
                            <button class="login100-form-btn">
                                Sign In
                            </button>
                        </div>

                        <div class="w-full text-center p-t-55">
                            <a href="${pageContext.request.contextPath}/client/home.htm" class="txt2">
                                Trang chủ
                            </a>

                            <a href="${pageContext.request.contextPath}/client/Register.htm" class="txt2 bo1">
                                Đăng ký ngay
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="/ShopFashion/jsp/Frontend/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="/ShopFashion/jsp/Frontend/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="/ShopFashion/jsp/Frontend/vendor/bootstrap/js/popper.js"></script>
        <script src="/ShopFashion/jsp/Frontend/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="/ShopFashion/jsp/Frontend/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="/ShopFashion/jsp/Frontend/vendor/daterangepicker/moment.min.js"></script>
        <script src="/ShopFashion/jsp/Frontend/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="/ShopFashion/jsp/Frontend/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="/ShopFashion/jsp/Frontend/js/main.js"></script>

    </body>
</html>
