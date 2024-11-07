<%-- 
    Document   : profile
    Created on : Oct 5, 2024, 9:51:43 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Profile</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">  

        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">    
        <style>
            .alert {
                padding: 20px 30px;
                font-size: 18px;
                max-width: 400px; 
                position: fixed; 
                top 10px; 
                right: 20px;
                z-index: 1050; 
                border: 1px solid transparent;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                background-color: #d4edda;
                border-color: #c3e6cb;
                color: #155724;
            }

            .progress-bar-timer {
                border-radius: 24px;
                position: absolute;
                bottom: 0;
                left: 0;
                height: 8px;
                width: 100%;
                background-color: #28a745;
                transition: width linear;
            }

            .alert-dismissible {
                padding-right: 60px; 
            }
            .btn-close {
                background: none;
                border: none;
                font-size: 1.5rem; 
                color: #6c757d; 
                transition: color 0.2s ease;
                position: absolute;
                right: 15px; 
                top: 50%;
                transform: translateY(-50%); 
                cursor: pointer;
            }

            .btn-close:hover {
                color: #000;
            }

            .fade-out {
                opacity: 1;
                transition: opacity 0.3s ease-out;
            }

            .fade-out.hide {
                opacity: 0;
            }
        </style>

    </head>
    <body>
        <!-- Topbar Start -->
        <div class="container-fluid">
            <div class="row bg-secondary py-1 px-xl-5">
                <div class="col-lg-6 d-none d-lg-block">
                    <div class="d-inline-flex align-items-center h-100">
                        <span class="text-primary ml-3"><i class="fa fa-envelope mr-2"></i>isperfume1803@gmail.com</span>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right col-md-12 col-sm-12">
                    <span class="text-primary text- ml-3 d-none d-lg-inline" ><i class="fa fa-map-marker-alt mr-2"></i>123 D1 Street, Thu Duc, HCM</span>
                    <div class="d-inline-flex align-items-center justify-content-between">  
                        <div class="col-md-8 col-sm-10 text-left d-flex d-lg-none">
                            <form action="MainController" method="get" class="w-100 d-flex mb-2 mb-lg-0">
                                <input type="text" class="form-control" placeholder="Search..." name="search" style="border-radius: 20px 0 0 20px; padding: 10px;">
                                <button name="action" value="SeacrhProduct" type="submit" class="btn" style="border-radius: 0 20px 20px 0; background-color: orange; color: white;">
                                    <i class="fa fa-search"></i>
                                </button>
                            </form>
                        </div>
                        <div class="d-inline-flex align-items-center d-block d-lg-none">
                            <c:choose>
                                <c:when test="${empty sessionScope.CUSTOMER_ID}">
                                    <button class="btn btn-sm d-flex align-items-center" data-toggle="dropdown">
                                        <i class="fas fa fa-user text-primary"></i>
                                        <span class="ml-1 text-primary">Account</span>
                                    </button>                                        
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item btn" type="button" href="signin.jsp">Sign in</a>
                                        <a class="dropdown-item btn" type="button" href="signup.jsp">Sign up</a>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-sm align-items-center d-flex" data-toggle="dropdown">
                                        <i class="fas fa fa-user text-primary"></i>
                                        <span class="ml-2"> ${sessionScope.CUSTOMER.name}</span>
                                    </button>
                                    <div class="dropdown-menu dropdown-menu-right">
                                        <a class="dropdown-item btn" type="button" href="MainController?action=Sign out">Sign out</a>
                                        <a class="dropdown-item btn" type="button" href="profile.jsp">Profile</a>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${not empty sessionScope.CUSTOMER_ID}">
                                    <a href="MainController?action=NavigateToCart" class="btn btn-sm d-flex align-items-center justify-content-center">
                                        <i class="fas fa-shopping-cart text-primary"></i>
                                        <span class="badge text-primary border border-primary rounded-circle ml-1" style="padding-bottom: 2px; top: 0">${sessionScope.CART_SIZE}</span>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-sm d-flex align-items-center" onclick="openDeleteModal(this, event)">
                                        <i class="fas fa-shopping-cart text-primary"></i>
                                        <span class="ml-1 text-primary">Cart</span>
                                    </button>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>          
        </div>
        <!-- Topbar End -->



        <!-- Navbar Start -->
        <div class="container-fluid bg-dark mb-30">
            <div class="row px-xl-5">
                <div class="col-lg-3 d-none d-lg-block mt-2">
                    <a href="MainController?action=HomeController" class="text-decoration-none d-flex justify-content-center">
                        <span class="h1 text-uppercase text-primary bg-dark px-2">IS</span>
                        <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Perfume</span>
                    </a>
                </div>
                <div class="col-lg-9 ml-auto">
                    <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">                           
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav mr-auto py-0">
                                <a href="MainController?action=HomeController" class="nav-item nav-link active">Home</a>
                                <c:forEach var="Category" items="${sessionScope.LIST_CATEGORY}">
                                    <div class="nav-item dropdown">
                                        <a href="MainController?action=Category&Category=${Category.categoryID}" class="nav-link dropdown-toggle" data-toggle="dropdown">${Category.name}</a>
                                        <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                            <a href="MainController?action=Category&CategoryID=${Category.categoryID}" class="btn dropdown-item ${Category == param.Category ? "active" : ""}">All ${Category.name}</a>
                                            <c:forEach var="brand" items="${sessionScope.LIST_BRAND_BY_CATE}">
                                                <c:if test="${Category.categoryID == brand.categoryID}">
                                                    <a href="MainController?action=Category&CategoryID=${Category.categoryID}&brandID=${brand.brandID}" class="dropdown-item btn">${brand.brandName}</a>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:forEach>
                                <a href="MainController?action=NavigateBlog" class="nav-item nav-link">Blog</a>
                                <c:if test="${not empty sessionScope.CUSTOMER_ID}">
                                    <a href="MainController?action=viewOrderHistory&customerID=${CUSTOMER_ID.customerID}" class="nav-item nav-link"> Order History</a>
                                </c:if>
                            </div>
                            <div class="col-md-4 col-sm-12 text-left d-none d-lg-flex">
                                <form action="MainController" method="POST" class="w-100 d-flex mb-2 mb-lg-0">
                                    <input type="text" class="form-control" placeholder="Search for products" name="search" style="border-radius: 20px 0 0 20px; padding: 10px;">
                                    <button name="action" value="SeacrhProduct" type="submit" class="btn" style="border-radius: 0 20px 20px 0; background-color: orange; color: white;">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </form>
                            </div>
                            <div class="navbar-nav ml-auto py-0 d-none d-lg-flex">                            
                                <c:choose>
                                    <c:when test="${empty sessionScope.CUSTOMER_ID}">
                                        <button class="btn btn-sm d-flex align-items-center" data-toggle="dropdown">
                                            <i class="fas fa fa-user text-primary"></i>
                                            <span class="ml-1 text-primary">Account</span>
                                        </button>                                        
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item btn" type="button" href="signin.jsp">Sign in</a>
                                            <a class="dropdown-item btn" type="button" href="signup.jsp">Sign up</a>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-sm align-items-center d-flex" data-toggle="dropdown">
                                            <i class="fas fa fa-user text-primary"></i>
                                            <span class="ml-1 text-primary">${sessionScope.CUSTOMER.name}</span>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <a class="dropdown-item btn" type="button" href="MainController?action=Sign out">Sign out</a>
                                            <a class="dropdown-item btn" type="button" href="profile.jsp">Profile</a>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                <c:choose>
                                    <c:when test="${not empty sessionScope.CUSTOMER_ID}">
                                        <a href="MainController?action=NavigateToCart" class="btn btn-sm d-flex align-items-center ml-1">
                                            <i class="fas fa-shopping-cart text-primary"></i>
                                            <span class="badge text-secondary border border-secondary rounded-circle ml-1" style="padding-bottom: 2px;">${sessionScope.CART_SIZE}</span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-sm d-flex align-items-center " onclick="openDeleteModal(this, event)">
                                            <i class="fas fa-shopping-cart text-primary"></i>
                                            <span class="ml-1 text-primary">Cart</span>
                                        </button>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Navbar End -->

        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="HomeController">Home</a>
                        <span class="breadcrumb-item active">Profile</span>
                    </nav>
                </div>
                <c:if test="${not empty requestScope.MESSAGE}">
                    <div class="alert alert-success alert-dismissible fade show fade-out" role="alert" id="autoDismissAlert" >
                        <i class="fa fa-check-circle me-2"></i> ${requestScope.MESSAGE}
                        <button type="button" class="btn-close text-right" data-bs-dismiss="alert" aria-label="Close">
                            <i class="fa fa-times"></i>
                        </button>
                        <div class="progress-bar-timer bg-success" id="progressBar"></div>
                    </div>
                </c:if>
            </div>
        </div>

        <!-- Breadcrumb End -->




        <!--Profile form Start-->
        <div class="container-fluid">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Profile</span></h2>
            <div class="row px-xl-5">
                <div class="container mb-5"> 
                    <div class="row h-100 d-flex align-items-center justify-content-center">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-10 col-xl-10">
                            <div class="bg-light rounded p-4 my-4 row d-flex justify-content-between">
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3">
                                    <label  class="form-label">Username</label>
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.name}" placeholder="Enter username" name="userName">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.nameError}
                                </div>

                                <div class="col-lg-5 col-md-5 col-sm- mb-3">
                                    <label class="form-label">Email</label>
                                    <div class="input-group">
                                        <input type="email" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.email}" placeholder="Enter email" name="email">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.nameError}
                                </div>

                                <div class="col-lg-5 col-md-5 col-sm- mb-3">
                                    <label class="form-label">Address</label> 
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.detailAddress}" placeholder="Enter address" name="address">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.nameError}
                                </div> 
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3">
                                    <label class="form-label">Area</label> 
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.area}" placeholder="Enter area" name="area">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.nameError}
                                </div>  
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3">
                                    <label for="floatingInput3" class="form-label">District</label> 
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.district}" placeholder="Enter district" name="district">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.nameError}
                                </div>  
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3">
                                    <label class="form-label">Ward</label> 
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.ward}" placeholder="Enter ward" name="ward">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.nameError}
                                </div>  
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3">
                                    <label class="form-label">Birthday</label>
                                    <div class="input-group">
                                        <input type="date" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.dayOfBirth}" placeholder="Enter birthday" name="birthday">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.nameError}
                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3">
                                    <label for="floatingInput3" class="form-label">Phone</label>
                                    <div class="input-group">                                  
                                        <input type="text" class="form-control bg-transparent" readonly="" value="${sessionScope.CUSTOMER.phone}" placeholder="Enter phone" name="phone">
                                    </div>
                                    ${requestScope.UPDATE_PROFILE_MESSAGE.phoneError}
                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3">
                                    <a href="changePassword.jsp">Change Password</a>
                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3 mt-3 text-right">
                                    <button class="btn btn-primary bg-transparent border-0" data-bs-toggle="modal" data-bs-target="#UpdateProfile">
                                        <span class=" bg-transparent text-primary" style="cursor: pointer;">
                                            <svg class="" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m14.304 4.844 2.852 2.852M7 7H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-4.5m2.409-9.91a2.017 2.017 0 0 1 0 2.853l-6.844 6.844L8 14l.713-3.565 6.844-6.844a2.015 2.015 0 0 1 2.852 0Z"/>
                                            </svg>
                                        </span>
                                    </button>
                                    <div class="modal fade" id="UpdateProfile" tabindex="-1" aria-labelledby="UpdateProfileLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <form action="MainController" method="get">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="UpdateProfileLabel">User Information</h5>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="row">
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label">Username</label>
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" value="${sessionScope.CUSTOMER.name}" placeholder="Enter username" name="userName">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label">Email</label>
                                                                <div class="input-group">
                                                                    <input type="email" class="form-control" value="${sessionScope.CUSTOMER.email}" placeholder="Enter email" name="email">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label ">Address</label>
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" value="${sessionScope.CUSTOMER.detailAddress}" placeholder="Enter address" name="address">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label ">Area</label>
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" value="${sessionScope.CUSTOMER.area}" placeholder="Enter area" name="area">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label ">District</label>
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" value="${sessionScope.CUSTOMER.district}" placeholder="Enter district" name="district">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label ">Ward</label>
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" value="${sessionScope.CUSTOMER.ward}" placeholder="Enter ward" name="ward">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="row">
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label ">Birthday</label>
                                                                <div class="input-group">
                                                                    <input type="date" class="form-control" value="${sessionScope.CUSTOMER.dayOfBirth}" placeholder="Enter birthday" name="birthday">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6 mb-3 text-left">
                                                                <label class="form-label ">Phone</label>
                                                                <div class="input-group">
                                                                    <input type="text" class="form-control" value="${sessionScope.CUSTOMER.phone}" placeholder="Enter phone" name="phone">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <input type="hidden" name="userID" value="${sessionScope.CUSTOMER.id}">
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                        <button type="submit" name="action" value="UpdateProfile" class="btn btn-primary">Update</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!--Pròile in form End-->

        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-secondary mt-5 pt-5">
            <div class="row px-xl-5 pt-5">
                <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                    <h5 class="text-secondary text-uppercase mb-4">Get In Touch</h5>
                    <p class="mb-4">Contact us for fast and friendly support. ISPerfume is here to help you find the perfect scent that speaks to your personality.</p>
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Lô E2a-7, Đường D1, Thu Duc, TP HoChiMinh</p>
                    <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>isperfume1803@gmail.com</p>
                    <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+84 xxx xxx 000</p>
                </div>
                <div class="col-lg-3 col-md-12 mb-5 pr-3 pr-xl-5">                 
                </div>
                <div class="col-lg-5 col-md-12">
                    <div class="row">
                        <div class="col-md-6 mb-5">
                            <h5 class="text-secondary text-uppercase mb-4">Quick Shop</h5>
                            <div class="d-flex flex-column justify-content-start">
                                <a class="text-secondary mb-2" href="MainController?action=HomeController"><i class="fa fa-angle-right mr-2"></i>Home</a>
                                <a class="text-secondary mb-2" href="MainController?action=NavigateBlog"><i class="fa fa-angle-right mr-2"></i>Blog</a>
                                <a class="text-secondary mb-2" href="MainController?action=SeacrhProduct&search="><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            </div>
                        </div>
                        <div class="col-md-6 mb-5">
                            <h5 class="text-secondary text-uppercase mb-4">My Account</h5>
                            <div class="d-flex flex-column justify-content-start">
                                <c:choose>
                                    <c:when test="${not empty sessionScope.CUSTOMER_ID}">
                                        <a class="text-secondary mb-2" href="profile.jsp"><i class="fa fa-angle-right mr-2"></i>Profile</a>
                                        <a class="text-secondary mb-2" href="MainController?action=viewOrderHistory&customerID=${CUSTOMER_ID.customerID}"><i class="fa fa-angle-right mr-2"></i>Order History</a>
                                        <a class="text-secondary mb-2" href="MainController?action=NavigateToCart"><i class="fa fa-angle-right mr-2"></i>My Cart</a>
                                        <a class="text-secondary mb-2" href="MainController?action=Sign out"><i class="fa fa-angle-right mr-2"></i>Sign out</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="text-secondary mb-2" href="signin.jsp"><i class="fa fa-angle-right mr-2"></i>Sign in</a>
                                        <a class="text-secondary mb-2" href="signup.jsp"><i class="fa fa-angle-right mr-2"></i>Sign up</a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <script>
                                            document.addEventListener('DOMContentLoaded', function () {
                                                var duration = 5000;
                                                var progressBar = document.getElementById('progressBar');
                                                var alertElement = document.getElementById('autoDismissAlert');

                                                progressBar.style.width = '100%';

                                                requestAnimationFrame(function () {
                                                    setTimeout(function () {
                                                        progressBar.style.transitionDuration = duration + 'ms';
                                                        progressBar.style.width = '0%';
                                                    }, 10);
                                                });

                                                setTimeout(function () {
                                                    alertElement.classList.add('hide');
                                                    setTimeout(function () {
                                                        alertElement.remove();
                                                    }, 200);
                                                }, duration);
                                            });
        </script>
    </body>
</html>
