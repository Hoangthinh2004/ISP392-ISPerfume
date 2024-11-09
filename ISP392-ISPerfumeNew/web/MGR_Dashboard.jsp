<%-- 
    Document   : MGR_Dashboard
    Created on : Sep 25, 2024, 3:40:40 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Manager | Home</title>
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
        <link href="dashmin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="dashmin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

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
                    <a href="MGR_Dashboard.jsp" class="navbar-brand mx-4 mb-3">
                        <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>ISPERFUME</h3>
                    </a>
                    <div class="d-flex align-items-center ms-4 mb-4">
                        <div class="position-relative">
                            <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                        </div>
                        <div class="ms-3">
                            <h6 class="mb-0">${sessionScope.LOGIN_USER.name}</h6>
                            <span>Manager</span>
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                        <form action="MainController" method="POST" id="myForm">
                            <a href="MGR_Dashboard.jsp" class="nav-item nav-link active" onclick="document.getElementById('myForm').submit(); return false;"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                            <input type="hidden" name="action" value="ListDashboard">
                        </form>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-briefcase me-2"></i>Management</a>
                            <div class="dropdown-menu bg-transparent border-0">
                                <a href="MainController?action=Manage_Product_Page" class="dropdown-item">Product Management</a>
                                <a href="MainController?action=Search&search=" class="dropdown-item">Brand Management</a>
                                <a href="MainController?action=ViewPromotion&search=" class="dropdown-item ">Promotion Management</a>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
            <!-- Sidebar End -->


            <!-- Content Start -->
            <div class="content">
                <!-- Navbar Start -->
                <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0  ">
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
                                <i class="fa fa-user"></i>
                                <span class="d-none d-lg-inline-flex">${sessionScope.LOGIN_USER.name}</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <a href="MainController?action=Sign out" class="dropdown-item">Sign Out</a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Navbar End -->

                <!-- Sales Chart Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="row g-4">
                        <div class="col-sm-12 col-xl-12">
                            <div class="row g-4">

                            </div>
                        </div>
                    </div>
                </div>
                <!-- Sale & Revenue End -->


                <!-- Sales Chart Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="row g-4">
                        <div class="col-md-6">
                            <div class="row g-4">
                                <!-- Total Promotion -->
                                <div class="col-sm-6">
                                    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4 h-100">
                                        <i class="fa fa-chart-area fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Total Promotion</p>
                                            <c:forEach var="pro" items="${requestScope.ALL_PROMOTION}">
                                                <h6 class="mb-0 text-end">${pro.promotionID}</h6>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>

                                <!-- Total Revenue -->
                                <div class="col-sm-6 ">
                                    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4 h-100">
                                        <i class="fa fa-dollar-sign fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Total Revenue</p>
                                            <c:forEach var="unitP" items="${requestScope.REVENUE}">
                                                <h6 class="mb-0 text-end">
                                                    <fmt:formatNumber type="number" value="${unitP.unitPrice}" /> VND
                                                </h6>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-boxes fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Total Product </p>
                                            <c:forEach var="product" items="${requestScope.ALL_PRODUCT}">
                                                <h6 class="mb-0 text-end">${product.productID}</h6>

                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-building fa-3x text-primary"></i>                                        
                                        <div class="ms-3">
                                            <p class="mb-2">Total Brand</p>
                                            <c:forEach var="brand" items="${requestScope.ALL_BRAND}">
                                                <h6 class="mb-0 text-end">${brand.brandID}</h6>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-check-circle fa-3x text-primary"></i>                                        
                                        <div class="ms-3">
                                            <p class="mb-2">Order Completed</p>
                                            <c:forEach var="order" items="${requestScope.ALL_ORDER_COMPLETED}">
                                                <h6 class="mb-0 text-end">${order.orderID}</h6>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>  

                                <div class="col-sm-6">
                                    <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                        <i class="fa fa-spinner fa-3x text-primary"></i>
                                        <div class="ms-3">
                                            <p class="mb-2">Order Is Processing</p>
                                            <c:forEach var="orderP" items="${requestScope.ALL_ORDER_PROCESSING}">
                                                <h6 class="mb-0 text-end">${orderP.orderID}</h6>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div> 
                                <!-- Category Chart -->
                                <div class="col-12">
                                    <div class="bg-light text-center rounded p-4 h-100">
                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                            <h6 class="mb-0">Category</h6>
                                        </div>
                                        <canvas id="worldwide-sales"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Left Column - Orders Chart -->
                        <div class="col-md-6">
                            <div class="bg-light text-center rounded p-4 h-100">
                                <div class="d-flex align-items-center justify-content-between mb-4">
                                    <h6 class="mb-0">Orders</h6>
                                </div>
                                <canvas id="doughnut-chart"></canvas>
                            </div>
                        </div>

                    </div>

                </div>

                <!-- Sales Chart End -->

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
        <script>
                                // Worldwide Sales Chart
                                var ctx1 = $("#worldwide-sales").get(0).getContext("2d");

                                const Men = ${QUANTITY_PRODUCT_BY_CATEGORYID1};
                                const Women = ${QUANTITY_PRODUCT_BY_CATEGORYID2};
                                const Unisex = ${QUANTITY_PRODUCT_BY_CATEGORYID3};
                                var myChart1 = new Chart(ctx1, {
                                    type: "bar",
                                    data: {
                                        labels: [""],
                                        datasets: [{
                                                label: "Men",
                                                data: [Men],
                                                backgroundColor: "rgba(255, 159, 64, .7)"
                                            },
                                            {
                                                label: "Women",
                                                data: [Women],
                                                backgroundColor: "rgba(255, 159, 64, .5)"
                                            },
                                            {
                                                label: "Unisex",
                                                data: [Unisex],
                                                backgroundColor: "rgba(255, 159, 64, .3)"
                                            }
                                        ]
                                    },
                                    options: {
                                        responsive: true
                                    }
                                });

                                // Doughnut Chart
                                var ctx6 = $("#doughnut-chart").get(0).getContext("2d");
                                const Confirmation = ${QUANTITY_ORDER_STATUS1};
                                const Pickup = ${QUANTITY_ORDER_STATUS2};
                                const Delivery = ${QUANTITY_ORDER_STATUS3};
                                const Successfully = ${QUANTITY_ORDER_STATUS4};
                                var myChart6 = new Chart(ctx6, {
                                    type: "doughnut",
                                    data: {
                                        labels: ["Confirmation", "Pickup", "Delivery", "Successfully"],
                                        datasets: [{
                                                backgroundColor: [
                                                    "rgba(255, 159, 64, .8)",
                                                    "rgba(255, 159, 64, .6)",
                                                    "rgba(255, 159, 64, .4)",
                                                    "rgba(255, 159, 64, .2)"
                                                ],
                                                data: [Confirmation, Pickup, Delivery, Successfully]
                                            }]
                                    },
                                    options: {
                                        responsive: true
                                    }
                                });
        </script>
    </body>
</html>
