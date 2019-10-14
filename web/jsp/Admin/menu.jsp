<%-- 
    Document   : menu
    Created on : Jul 22, 2019, 10:53:48 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${pageContext.request.contextPath}/home.htm">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Quản trị Admin</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-laugh-wink"></i>
            <span>Quản lý sản phẩm</span></a>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <!--                <h6 class="collapse-header">Tables Manager:</h6>-->
                <a class="collapse-item" href="${pageContext.request.contextPath}/Admin.htm">Danh sách quản trị viên</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/Customer.htm">Danh sách khách hàng</a>  
                <a class="collapse-item" href="${pageContext.request.contextPath}/Product.htm">Danh sách sản phẩm</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/Catelog.htm">Danh sách Danh Mục</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/Color.htm">Danh sách màu</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/Size.htm">Danh sách size</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/Provider.htm">Danh sách nhà cung cấp</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/Payment.htm">Hình thức thanh toán</a>
                <a class="collapse-item" href="${pageContext.request.contextPath}/Order.htm">Danh sách Đơn hàng</a>
            </div>
        </div>

    </li>
  

    <!--
         Nav Item - Charts 
        <li class="nav-item">
            <a class="nav-link" href="charts.html">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>
    
         Nav Item - Tables 
        <li class="nav-item">
            <a class="nav-link" href="tables.html">
                <i class="material-icons"></i>
                <span>Tables</span></a>
        </li>
    
         Divider 
        <hr class="sidebar-divider d-none d-md-block">
    
         Sidebar Toggler (Sidebar) 
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>-->

</ul>
