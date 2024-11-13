<%-- 
    Document   : MGR_CreateProduct
    Created on : Sep 25, 2024, 9:29:34 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Manager | Product</title>
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
                    <a href="MainController?action=ListDashboard" class="navbar-brand mx-4 mb-3">
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
                        <a href="MainController?action=ListDashboard" class="nav-item nav-link"><i class="fa fa-home me-2"></i>Dashboard</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown"><i class="fa fa-briefcase me-2"></i>Management</a>
                            <div class="dropdown-menu bg-transparent border-0">
                                <a href="MainController?action=Manage_Product_Page" class="dropdown-item active">Product Management</a>
                                <a href="MainController?action=Search&search=" class="dropdown-item ">Brand Management</a>
                                <a href="MainController?action=ViewPromotion" class="dropdown-item ">Promotion Management</a>
                            </div>
                        </div>
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


                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <span class="d-none d-lg-inline-flex">${sessionScope.LOGIN_USER.name}</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <a href="MainController?action=Sign out" class="dropdown-item">Sign Out</a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Navbar End -->


                <!-- Blank Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="row vh-100 bg-light rounded justify-content-center mx-0">
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4">
                                <h6 class="mb-4">Create Product Form</h6>
                                <form action="CreateProductManager" method="post" enctype="multipart/form-data">
                                    <div class="row mb-3">
                                        <label  class="col-sm-2 col-form-label">Name</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="productName" required="" class="form-control" placeholder="${requestScope.ERROR.productName}">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label  class="col-sm-2 col-form-label">Decription</label>
                                        <div class="col-sm-10">
                                            <textarea name="description" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label  class="col-sm-2 col-form-label">Country</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="country" class="form-control">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label  class="col-sm-2 col-form-label">Release Year</label>
                                        <div class="col-sm-10">
                                            <input type="number" name="releaaseDate" class="form-control input_field" min="1900" max="2024">
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label  class="col-sm-2 col-form-label">Fragrance</label>
                                        <div class="col-sm-10">
                                            <textarea name="fregranceFamilies" class="form-control"></textarea>
                                        </div>
                                    </div>
                                    <div class="row mb-3">
                                        <label for="brandImage"  class="col-sm-2 col-form-label">Image</label>
                                        <div class="col-sm-10">
                                            <input type="file" name="brandImage" class="form-control" required="">
                                        </div>
                                    </div>
                                    Brand <select name="brandID" class="form-select mb-3 form-control bg-transparent" aria-label="Default select example" required="">
                                        <c:forEach var="brand" items="${sessionScope.BRAND_LIST_MANAGER}">
                                            <option value="${brand.brandID}">${brand.name}</option>
                                        </c:forEach>
                                    </select>
                                    Category <select name="categoryID" class="form-select mb-3 form-control bg-transparent" aria-label="Default select example" required="">
                                        <c:forEach var="cate" items="${sessionScope.CATEGORY_LIST_MANAGER}">
                                            <c:if test="${cate.categoryID!=4}">
                                                <option value="${cate.categoryID}">${cate.name}</option>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                    <div class="d-flex justify-content-between">
                                        <button type="submit"class="btn btn-primary">CREATE</button>
                                        <input type="hidden" name="search" value="${requestScope.SEARCH}">
                                        <a href="MainController?action=Manage_Product_Page" class="btn btn-primary">Back</a>
                                    </div>
                                </form>
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
        <!-- JavaScript Libraries -->
        <!-- JavaScript Libraries -->
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
