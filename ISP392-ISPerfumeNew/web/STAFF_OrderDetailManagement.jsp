<%-- 
    Document   : STAFF_OrderManagement
    Created on : Oct 8, 2024, 3:31:41 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Staff | Order Detail</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/fragrance.png" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="dashmin/css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="dashmin/css/style.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-fluid position-relative bg-white d-flex p-0">
            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->


            <!-- Sidebar Start -->
            <div class="sidebar pe-4 pb-3">
                <nav class="navbar bg-light navbar-light">
                    <a href="" class="navbar-brand mx-4 mb-3">
                        <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>ISPERFUME</h3>
                    </a>
                    <div class="d-flex align-items-center ms-4 mb-4">
                        <div class="position-relative">
                            <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                        </div>
                        <div class="ms-3">
                            <h6 class="mb-0">${sessionScope.LOGIN_USER.name}</h6>
                            <span>Staff</span>
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                        <a href="MainController?action=ManageOrderPage" class="nav-item nav-link active"><i class="fa fa-shipping-fast me-2"></i>Manage Order</a>                     
                        <a href="STAFF_BlogManagement.jsp" class="nav-item nav-link "><i class="fa fa-pencil-alt me-2"></i>Manage Blog</a>                     
                    </div>
                </nav>
            </div>
            <!-- Sidebar End -->


            <!-- Content Start -->
            <div class="content">
                <!-- Navbar Start -->
                <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                    <a href="MGR_Dashboard.jsp" class="navbar-brand d-flex d-lg-none me-4">
                        <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                    </a>
                    <a href="#" class="sidebar-toggler flex-shrink-0">
                        <i class="fa fa-bars"></i>
                    </a>
                    <!--                    <form class="d-none d-md-flex ms-4" action="MainController" method="get">
                                            <input class="form-control border-0" type="search" placeholder="Search" name="">
                                            <button class="btn btn-primary" type="submit" name="action" value="" style="margin-left: 10px;">
                                                <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                                <path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z"/>
                                                </svg>
                                            </button>
                                        </form>-->
                    <div class="navbar-nav align-items-center ms-auto">
                        <!--                        
                        -->                        <div class="nav-item dropdown"><!--
                            -->                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <span class="d-none d-lg-inline-flex">${sessionScope.LOGIN_USER.name}</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <a href="MainController?action=Sign out" class="dropdown-item">Log Out</a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Navbar End -->

                <!-- Blank Start -->

                <div class="container-fluid pt-4 px-4">
                    <div class="row vh-100 bg-light rounded align-items-center justify-content-center mx-0 " style="height: auto !important">
                        <div class="table-responsive">
                            <div class="col-sm-12 col-xl-12">
                                <div class="bg-light rounded h-100 p-4">
                                    <div class="d-flex align-items-center justify-content-between mb-4">
                                        <h6 class="mb-0">Order Detail</h6>
                                    </div>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th scope="col">Product Detail</th>
                                                <th scope="col">Size</th>
                                                <th scope="col">Quantity</th>
                                                <th scope="col">Unit Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="orderDetail" items="${requestScope.LIST_ORDER_DETAIL_STAFF}">
                                                <tr>
                                                    <!--                                                    productName-->
                                                    <td>
                                                        <c:forEach var="productDetail" items="${sessionScope.LIST_PRODUCT_DETAIL_STAFF}">
                                                            <c:if test="${orderDetail.productDetailID == productDetail.productDetailID}">
                                                                <c:forEach var="product" items="${sessionScope.LIST_PRODUCT_STAFF}">
                                                                    <c:if test="${product.productID == productDetail.productID}">
                                                                        ${product.name}
                                                                    </c:if>
                                                                </c:forEach>
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <!--                                                    size-->
                                                    <td>
                                                        <c:forEach var="productDetail" items="${sessionScope.LIST_PRODUCT_DETAIL_STAFF}">
                                                            <c:if test="${orderDetail.productDetailID == productDetail.productDetailID}">
                                                                <c:forEach var="size" items="${sessionScope.LIST_SIZE_STAFF}">
                                                                    <c:if test="${size.sizeID == productDetail.sizeID}">
                                                                        ${size.name}
                                                                    </c:if>
                                                                </c:forEach>
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <!--                                                    Quantity-->
                                                    <td>
                                                        ${orderDetail.quantity}
                                                    </td>
                                                    <td>
                                                        <fmt:formatNumber type="number" value="${orderDetail.unitPrice}"/>
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

                <div class="container-fluid">
                    <form action="MainController" method="get">
                        <div class="row px-xl-5">
                            <div class="container mb-5"> 
                                <div class="row h-100 align-items-center justify-content-between">
                                    <div class="col-12">
                                        <div class="bg-light rounded p-4 my-4">
                                            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span>Customer Information</span></h2>
                                            <!-- Username and Email -->
                                            <div class="row mb-3">
                                                <div class="col-lg-6 col-md-12">
                                                    <label for="floatingInput1" class="form-label">Username</label>
                                                    <div class="input-group">
                                                        <c:forEach var="user" items="${sessionScope.LIST_USER_STAFF}">
                                                            <c:if test="${requestScope.ORDER.customerID == user.userID}">
                                                                <input type="text" class="form-control bg-transparent" id="floatingInput1" value="${user.name}" readonly="">
                                                            </c:if>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6 col-md-12">
                                                    <label for="floatingInput2" class="form-label">Email</label>
                                                    <div class="input-group">
                                                        <c:forEach var="user" items="${sessionScope.LIST_USER_STAFF}">
                                                            <c:if test="${requestScope.ORDER.customerID == user.userID}">
                                                                <input type="text" class="form-control bg-transparent" id="floatingInput2" value="${user.email}" readonly="">
                                                            </c:if>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Address and City -->
                                            <div class="row mb-3">
                                                <div class="col-lg-6 col-md-12">
                                                    <label for="floatingInput3" class="form-label">Address</label> 
                                                    <div class="input-group">
                                                        <input type="text" class="form-control bg-transparent" id="floatingInput3" value="${ORDER.address}" readonly="">
                                                    </div>
                                                </div>
                                                <div class="col-lg-6 col-md-12">
                                                    <label for="floatingInput4" class="form-label">City</label> 
                                                    <div class="input-group">
                                                        <input type="text" class="form-control bg-transparent" id="floatingInput4" value="${ORDER.city}" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- District and Ward -->
                                            <div class="row mb-3">
                                                <div class="col-lg-6 col-md-12">
                                                    <label for="floatingInput5" class="form-label">District</label> 
                                                    <div class="input-group">
                                                        <input type="text" class="form-control bg-transparent" id="floatingInput5" value="${ORDER.district}" readonly="">
                                                    </div>
                                                </div>
                                                <div class="col-lg-6 col-md-12">
                                                    <label for="floatingInput6" class="form-label">Ward</label> 
                                                    <div class="input-group">
                                                        <input type="text" class="form-control bg-transparent" id="floatingInput6" value="${ORDER.ward}" readonly="">
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Phone -->
                                            <div class="row mb-3">
                                                <div class="col-lg-6 col-md-12">
                                                    <label for="floatingInput7" class="form-label">Phone</label>
                                                    <div class="input-group">
                                                        <c:forEach var="user" items="${sessionScope.LIST_USER_STAFF}">
                                                            <c:if test="${requestScope.ORDER.customerID == user.userID}">
                                                                <input type="text" class="form-control bg-transparent" id="floatingInput7" value="${user.phone}" readonly="">
                                                            </c:if>
                                                        </c:forEach>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6 col-md-12 d-flex justify-content-end align-items-center mt-5">
                                                    <a class="btn btn-primary " href="MainController?action=ManageOrderPage">
                                                        Back
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <!-- Blank End -->


                <!-- Footer Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="bg-light rounded-top p-4">
                        <div class="row">
                            <div class="col-12 col-sm-6 text-center text-sm-start">
                                &copy; <a href="#">ISPERFUME</a>
                            </div>
                            <div class="col-12 col-sm-6 text-center text-sm-end">
                                <a href="#">Privacy Policy</a> | <a href="#">Terms of Use</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Footer End -->
            </div>
            <!-- Content End -->


            <!-- Back to Top -->
            <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
        </div>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="dashmin/lib/chart/chart.min.js"></script>
        <script src="dashmin/lib/easing/easing.min.js"></script>
        <script src="dashmin/lib/waypoints/waypoints.min.js"></script>
        <script src="dashmin/lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="dashmin/lib/tempusdominus/js/moment.min.js"></script>
        <script src="dashmin/lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="dashmin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Template Javascript -->
        <script src="dashmin/js/main.js"></script>
    </body>
</html>
