<%-- 
    Document   : STAFF_OrderManagement
    Created on : Oct 8, 2024, 3:31:41 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>STAFF | Order</title>
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
                    <a href="MainController?action=ManageOrderPage" class="navbar-brand mx-4 mb-3">
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
                        <a href="MainController?action=ShowAllBlogManager" class="nav-item nav-link "><i class="fa fa-pencil-alt me-2"></i>Manage Blog</a>                     
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
                    <div class="navbar-nav align-items-center ms-auto">
                        <!--                        <div class="nav-item dropdown">
                                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                                        <i class="fa fa-envelope me-lg-2"></i>
                                                        <span class="d-none d-lg-inline-flex">Message</span>
                                                    </a>
                                                    <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                                        <a href="#" class="dropdown-item">
                                                            <div class="d-flex align-items-center">
                                                                <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                                                <div class="ms-2">
                                                                    <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                                                    <small>15 minutes ago</small>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <hr class="dropdown-divider">
                                                        <a href="#" class="dropdown-item">
                                                            <div class="d-flex align-items-center">
                                                                <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                                                <div class="ms-2">
                                                                    <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                                                    <small>15 minutes ago</small>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <hr class="dropdown-divider">
                                                        <a href="#" class="dropdown-item">
                                                            <div class="d-flex align-items-center">
                                                                <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                                                <div class="ms-2">
                                                                    <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                                                    <small>15 minutes ago</small>
                                                                </div>
                                                            </div>
                                                        </a>
                                                        <hr class="dropdown-divider">
                                                        <a href="#" class="dropdown-item text-center">See all message</a>
                                                    </div>
                                                </div>
                                                <div class="nav-item dropdown">
                                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                                        <i class="fa fa-bell me-lg-2"></i>
                                                        <span class="d-none d-lg-inline-flex">Notificatin</span>
                                                    </a>
                                                    <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                                        <a href="#" class="dropdown-item">
                                                            <h6 class="fw-normal mb-0">Profile updated</h6>
                                                            <small>15 minutes ago</small>
                                                        </a>
                                                        <hr class="dropdown-divider">
                                                        <a href="#" class="dropdown-item">
                                                            <h6 class="fw-normal mb-0">New user added</h6>
                                                            <small>15 minutes ago</small>
                                                        </a>
                                                        <hr class="dropdown-divider">
                                                        <a href="#" class="dropdown-item">
                                                            <h6 class="fw-normal mb-0">Password changed</h6>
                                                            <small>15 minutes ago</small>
                                                        </a>
                                                        <hr class="dropdown-divider">
                                                        <a href="#" class="dropdown-item text-center">See all notifications</a>
                                                    </div>
                                                </div>-->
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
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
                    <div class="row vh-100 bg-light rounded  justify-content-center mx-0 " style="height: auto !important; min-height: 540px;">
                        <div class="table-responsive">
                            <div class="col-sm-12 col-xl-12">
                                <div class="bg-light rounded h-100 p-4">
                                    <div class="d-flex align-items-center justify-content-between mb-4">
                                        <h6 class="mb-0">Order Management</h6>

                                    </div>
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th scope="col">Staff</th>
                                                <th scope="col">Customer</th>
                                                <th scope="col">Order Date</th>
                                                <th scope="col">OrderStatus</th>
                                                <th scope="col">Shipper</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="order" items="${requestScope.ORDER_LIST_STAFF}" varStatus="counter">
                                                <tr>
                                                    <!--                                                staff-->
                                                    <td>
                                                        <c:forEach var="user" items="${sessionScope.LIST_USER_STAFF}">
                                                            <c:if test="${order.staffID == user.userID}">
                                                                ${user.name}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <!--                                                    customer-->
                                                    <td>
                                                        <c:forEach var="user" items="${sessionScope.LIST_USER_STAFF}">
                                                            <c:if test="${order.customerID == user.userID}">
                                                                ${user.name}
                                                            </c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <!--                                                    order date-->
                                                    <td>
                                                        ${order.orderDate}
                                                    </td>
                                                    <td>
                                                        <c:choose>
                                                            <c:when test="${order.orderStatus == 1}">
                                                                PROCESSING
                                                            </c:when>
                                                            <c:when test="${order.orderStatus == 2}">
                                                                APPROVED
                                                            </c:when>
                                                            <c:when test="${order.orderStatus == 3}">
                                                                SHIPPING
                                                            </c:when>
                                                            <c:when test="${order.orderStatus == 4}">
                                                                COMPLETED
                                                            </c:when>
                                                            <c:otherwise>
                                                                Trạng thái không xác định
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <c:choose>
                                                        <c:when test="${order.shipperID != 0}">
                                                            <td>
                                                                <c:forEach var="user" items="${sessionScope.LIST_USER_STAFF}">
                                                                    <c:if test="${order.shipperID == user.userID}">
                                                                        ${user.name}
                                                                    </c:if>
                                                                </c:forEach>
                                                            </td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td>
                                                                No shipper assigned yet!
                                                            </td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <td>
                                                        <form action="MainController" method="get" class="d-flex justify-content-around">
                                                            <input type="hidden" name="orderID" value="${order.orderID}">
                                                            <button type="submit" name="action" value="OrderDetailPage" class="btn btn-sm btn-primary"><i class="fa fa-search"></i></button>
                                                        </form>
                                                    </td>
                                                    <c:if test="${order.shipperID == 0}">
                                                        <td>
                                                            <a class="d-flex justify-content-center" data-bs-toggle="modal" data-bs-target="#updateModal-${counter.count}">
                                                                <i class="fa fa-check"></i>
                                                                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m14.304 4.844 2.852 2.852M7 7H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-4.5m2.409-9.91a2.017 2.017 0 0 1 0 2.853l-6.844 6.844L8 14l.713-3.565 6.844-6.844a2.015 2.015 0 0 1 2.852 0Z"/>
                                                            </a>
                                                            <!-- Modal Update -->
                                                            <div class="modal fade" id="updateModal-${counter.count}" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true" >
                                                                <div class="modal-dialog">
                                                                    <div class="modal-content" style="border-radius: 24px;">
                                                                        <div class="modal-header">
                                                                            <h1 class="modal-title fs-5" id="updateModalLabel">Promotion Information</h1>
                                                                            <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                        </div>
                                                                        <form action="MainController" method="get">
                                                                            <div class="modal-body">
                                                                                <div class="mb-3">
                                                                                    <label  class="form-label">Shipper</label>
                                                                                    <c:forEach var="shipper" items="${sessionScope.LIST_USER_STAFF}">
                                                                                        <c:if test="${shipper.roleID == 2}">
                                                                                            <div>
                                                                                                <input type="radio" name="shipperID" value="${shipper.userID}" id="${shipper.userID}" checked="">
                                                                                                <label for="${shipper.userID}">${shipper.name}</label>
                                                                                            </div>
                                                                                        </c:if>
                                                                                    </c:forEach>
                                                                                </div>
                                                                                <!--                                                                                <input type="text" name="productName" value="" class="form-control">                                                                   -->
                                                                            </div>
                                                                            <div class="modal-footer">
                                                                                <input type="hidden" name="orderID" value="${order.orderID}">
                                                                                <c:forEach var="user" items="${sessionScope.LIST_USER_STAFF}">
                                                                                    <c:if test="${order.customerID == user.userID}">
                                                                                        <input type="hidden" name="email" value="${user.email}">
                                                                                    </c:if>
                                                                                </c:forEach>
                                                                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                                                                <button type="submit" class="btn" name="action" value="AssignShipperStaff">Approve</button>
                                                                            </div>
                                                                        </form>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </c:if>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
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
