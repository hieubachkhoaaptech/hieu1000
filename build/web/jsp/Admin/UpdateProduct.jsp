<%-- 
    Document   : updateCatelog
    Created on : Aug 6, 2019, 10:45:57 PM
    Author     : Admin
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <div id="content-wrapper">

                <!-- Main Content -->
                <div id="content">

                    <!-- Header -->
                    <jsp:include page="header.jsp" flush="true"/>
                    <!-- End of Header -->

                    <!-- Begin Page Content -->
                    <div class="page-content">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="x_panel">
                                    <div class="x_title" >
                                        <h5 style="margin-left: 30px"><b>Quản lí sản phẩm </b><small>  >> Sửa thông tin</small></h5>
                                        <div class="clearfix"></div>
                                        <f:form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/saveUpdateProduct.htm" method="post" modelAttribute="upProduct">
                                            <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                                <label for="inputProductId" class="col-sm-2 control-label" style=" font-weight: bold;">Mã sản phẩm:</label>
                                                <div class="col-sm-8" >
                                                    <f:input required="*" type="text" class="form-control" id="productId" placeholder="Mã sản phẩm" path="productId" readOnly="true"/>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                                <label for="inputProductName" class="col-sm-2 control-label" style=" font-weight: bold;">Tên sản phẩm:</label>
                                                <div class="col-sm-6" >
                                                    <f:input required="*" type="text" class="form-control" id="productName"  placeholder="" path="productName"/>
                                                </div>
                                            </div>
<!--                                            <div class="form-group" style="margin-left: 250px; margin-top: 30px">
                                                <label for="inputProName" class="col-sm-10 control-label" style=" font-weight: bold;">Ngày tạo:</label>
                                                <div class="col-sm-6">
                                                    <f:input type="date" class="form-control" placeholder="" value="${upProduct.createDate}" id="createDate" path="createDate"/>
                                                </div>
                                            </div>-->
                                            <div class="form-group" style="margin-left: 250px">
                                                <label for="inputCatelog" class="col-sm-10 control-label" style=" font-weight: bold">Danh mục</label>
                                                <div class="col-sm-6" style="margin-right: 200px">
                                                    <f:select id="catelogId" class="form-control col-md-7 col-xs-12" path="catelogId.catelogId">
                                                        <f:options items="${listCatelog}" itemLabel="catelogName" itemValue="catelogId" />
                                                    </f:select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-left: 250px">
                                                <label for="inputProvider" class="col-sm-10 control-label" style=" font-weight: bold">Nhà cung cấp</label>
                                                <div class="col-sm-6" style="margin-right: 200px">
                                                    <f:select id="providerId" class="form-control col-md-7 col-xs-12" path="providerId.providerId">
                                                        <f:options items="${listProvider}" itemLabel="providerName" itemValue="providerId" />
                                                    </f:select>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-left: 250px">
                                                <label for="inputQuantity" class="col-sm-10 control-label" style=" font-weight: bold">Số lượng</label>
                                                <div class="col-sm-6" style="margin-right: 200px">
                                                    <f:input type="text" class="form-control" placeholder="" id="quantity" path="quantity"/>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-left: 250px">
                                                <label for="inputPrice" class="col-sm-10 control-label" style=" font-weight: bold">Gía tiền</label>
                                                <div class="col-sm-6" style="margin-right: 200px">
                                                    <f:input type="text" class="form-control" placeholder="" id="price" path="price"/>
                                                </div>  
                                            </div>
                                            <div class="form-group"  style="margin-left: 250px">
                                                <label for="inputImages" class="col-sm-2 control-label" style=" font-weight: bold">Ảnh sản phẩm:</label>
                                                <div class="col-sm-8">
                                                    <a href="#">
                                                        <img class="img border-gray" src="/ShopFashion/jsp/Admin/images/${upProduct.images}" alt="..." ></a>
                                                        <f:input type="file" name="file" class="form-control" id="images" path="images"/>
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-left: 250px">
                                                <label for="inputStatus" class="col-sm-10 control-label" style=" font-weight: bold">Trạng thái</label>
                                                <div class="col-sm-12" style="margin-right: 200px">
                                                    <f:checkbox class="form-control" id="status" path="status" checked="true"/>Còn hàng
                                                </div>
                                            </div>
                                            <div class="form-group" style="margin-left: 250px">
                                                <label for="inputdescription" class="col-sm-10 control-label" style=" font-weight: bold">Mô tả</label>
                                                <div class="col-sm-10" style="margin-right: 200px">
                                                    <f:textarea class="form-control" placeholder="" id="descriptions" path="descriptions"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-6" style="margin-left: 250px">
                                                    <button type="submit" class="btn btn-success">Sửa</button>
                                                    <button type="reset" class="btn btn-warning" style="margin-left: 120x; margin-right: -150px">Nhập lại</button>
                                                </div>
                                            </div>
                                        </f:form>
                                        <!-- /.container-fluid -->

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
                                    <div class="msodal-header">
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
                        <script src="/ShopFashion/jsp/ckeditor/adapters/jquery.js" type="text/javascript"></script>
                        <script src="/ShopFashion/jsp/ckfinder/ckfinder.js" type="text/javascript"></script>
                        <script type="text/javascript">
                            var editor = CKEDITOR.replace('descriptions');
                            CKFinder.setupCKEditor(editor, 'jsp/ckfinder/')
                        </script>
                        </body>

                        </html>