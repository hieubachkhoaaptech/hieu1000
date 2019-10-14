<%-- 
    Document   : InsertColor
    Created on : Aug 4, 2019, 9:48:53 PM
    Author     : Admin
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SB Admin 2 - Dashboard</title>

        <!-- Custom fonts for this template-->
        <link href="/ShopFashion/jsp/Admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="/ShopFashion/jsp/Admin/css/sb-admin-2.min.css" rel="stylesheet">
    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Menu -->
            <jsp:include page="menu.jsp" flush="true"/>
            <!-- End of Menu -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Header -->
                    <jsp:include page="header.jsp" flush="true"/>
                    <!-- End of Header -->

                    <!-- Begin Page Content -->
                    <div class="page-content">

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h4 style="margin-left: 50px">Xem chi tiết Admin<small>  >> Detail Admin</small></h4>
                                        <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                            <div class="col-sm-12">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Mã quản trị:</label>
                                                <input type="text" value="${ad.adminId}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="clearfix"></div>
                                        <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                            <div class="col-sm-12">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Họ và tên:</label>
                                                <input type="text" value="${ad.fullName}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                            <div class="col-sm-12">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Tên đăng nhập:</label>
                                                <input type="text" value="${ad.userName}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                            <div class="col-sm-12">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Mật khẩu:</label>
                                                <input type="password" value="${ad.password}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                            <div class="col-sm-12">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Email:</label>
                                                <input type="email" value="${ad.email}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                            <div class="col-sm-12">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Địa chỉ:</label>
                                                <input type="text" value="${ad.address}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>
                                        <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                            <div class="col-sm-12">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Số điện thoại:</label>
                                                <input type="text" value="${ad.phone}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>  
<!--                                        <div class="form-group" style="margin-left: 250px">
                                            <div class="col-sm-12" style="margin-right: 200px">
                                                <label for="inputImages" class="col-sm-10 control-label" style=" font-weight: bold">Ngày tạo</label>
                                                <input type="text" value="${ad.createDate}" class="form-control" readonly="true"/>
                                            </div>
                                        </div>-->
                                    </div>
                                </div>
                            </div>

                        </div><!-- /.row -->
                    </div><!-- /.page-content -->
                    <!-- /.container-fluid -->

                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <jsp:include page="footer.jsp" flush="true"/>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
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

        <!-- Page level plugins -->
        <script src="/ShopFashion/jsp/Admin/vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="/ShopFashion/jsp/Admin/js/demo/chart-area-demo.js"></script>
        <script src="/ShopFashion/jsp/Admin/js/demo/chart-pie-demo.js"></script>

        <script src="/ShopFashion/jsp/ckeditor/ckeditor.js" type="text/javascript"></script>
        <script src="/ShopFashion/jsp/ckfinder/ckfinder.js" type="text/javascript"></script>
        <script src="/ShopFashion/jsp/ckeditor/adapters/jquery.js" type="text/javascript"></script>
        <script type="text/javascript">
            var editor = CKEDITOR.replace('descriptions');
            CKFinder.setupCKEditor(editor, 'jsp/ckfinder/')
        </script>
    </body>

</html>