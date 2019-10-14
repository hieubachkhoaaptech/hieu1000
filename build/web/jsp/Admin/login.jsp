<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Login</title>

        <!-- Custom fonts for this template-->
        <link href="/ShopFashion/jsp/Admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="/ShopFashion/jsp/Admin/css/sb-admin-2.min.css" rel="stylesheet">
        <script>
            function validate() {
                var username = document.getElementById("username").value;
                var password = document.getElementById("password").value;
                if (username != "" && password != "") {
                    return true;
                } else {
                    if (username == "") {
                        alert("Ban phai nhap ten dang nhap.");
                        document.getElementById("username").focus();
                        return false;
                    }
                    if (password == "") {
                        alert("Ban phai nhap mat khau.");
                        document.getElementById("password").focus();
                        return false;
                    }
                }
            }
        </script>
    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">Welcome!</h1>
                                        </div>
                                        <form class="user" action="${pageContext.request.contextPath}/login.htm" method="POST">
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user" id="username" name="username" path="userName" placeholder=""/>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" class="form-control form-control-user" id="password" name="password" path="password" placeholder=""/>
                                            </div>
                                            <label class="block clearfix">
                                                <div class="message">
                                                    ${message}
                                                </div>
                                            </label>
                                            <div class="form-group">
                                                <div class="custom-control custom-checkbox small">
                                                    <input type="checkbox" class="custom-control-input" id="customCheck">
                                                    <label class="custom-control-label" for="customCheck">Remember Me</label>
                                                </div>
                                            </div>
                                            <button class="btn btn-primary btn-user btn-block" type="submit">
                                                Login
                                            </button>
                                            <hr>


                                            <hr>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="/ShopFashion/jsp/Admin/vendor/jquery/jquery.min.js"></script>
        <script src="/ShopFashion/jsp/Admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="/ShopFashion/jsp/Admin/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="/ShopFashion/jsp/Admin/js/sb-admin-2.min.js"></script>

    </body>

</html>
