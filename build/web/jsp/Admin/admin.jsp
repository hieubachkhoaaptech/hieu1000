<%-- 
    Document   : catelog
    Created on : Jul 28, 2019, 11:02:59 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link href="/ShopFashion/jsp/Admin/datatable/css/datatables.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
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
                    <div class="container-fluid">
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3" style="background: #f8ccc8">
                                <h6 class="m-0 font-weight-bold text-primary">Danh sách Danh Mục sản phẩm</h6>
                                <br>
                                <a href="${pageContext.request.contextPath}/initNewAdmin.htm">Thêm mới</a>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <div id="dataTable_wrapper" class="dataTable_wrapper dt-boostrap4">
                                        <div class="row">
                                            <div class="col-sm-12">
                                                <table class="table table-bordered" id="table_catelog">
                                                    <thead>
                                                        <tr>
                                                            <th>Mã</th>
                                                            <th>Tên</th>
                                                            <th>Tên đăng nhập</th>
                                                            <th>Mật khẩu</th>
                                                            <th>Hòm thư điện tử</th>
                                                            <th>Địa chỉ</th>
                                                            <th>Số điện thoại</th>
                                                            <th>Hành động</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach items="${listAdmin}" var="ad">
                                                            <tr>
                                                                <td>${ad.adminId}</td>
                                                                <td>${ad.fullName}</td>
                                                                <td>${ad.userName}</td>
                                                                <td>${ad.password}</td>
                                                                <td>${ad.email}</td>
                                                                <td>${ad.address}</td>
                                                                <td>${ad.phone}</td>
                                                                <td>
                                                                    <a href="updateAdmin.htm?adminId=${ad.adminId}" class="ace-icon far fa-edit bigger-130">Sửa</a>
                                                                    <a href="detailAdmin.htm?adminId=${ad.adminId}" class="ace-icon fas fa-eye bigger-130">Chi tiết</a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
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
        <script src="/ShopFashion/jsp/Admin/datatable/js/datatables.js" type="text/javascript"></script>
        <script src="/ShopFashion/jsp/ckeditor/ckeditor.js" type="text/javascript"></script>
        <script src="/ShopFashion/jsp/ckfinder/ckfinder.js" type="text/javascript"></script>
        <script src="/ShopFashion/jsp/ckeditor/adapters/jquery.js" type="text/javascript"></script>
        <script type="text/javascript">
            var editor = CKEDITOR.replace('descriptions');
            CKFinder.setupCKEditor(editor, 'jsp/ckfinder/')
        </script>
        <script>
            $(document).ready(function () {
                $('#table_catelog').DataTable();
            });
        </script>
    </body>

</html>