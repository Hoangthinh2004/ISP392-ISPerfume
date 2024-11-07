<%-- 
    Document   : checkoout
    Created on : Sep 27, 2024, 12:44:04 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Checkout</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free HTML Templates" name="keywords">
        <meta content="Free HTML Templates" name="description">

        <!-- Favicon -->
        <link href="img/fragrance.png" rel="icon">

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
            .product-info {
                border: 1px solid #ddd; 
                border-radius: 5px;
                padding: 15px; 
            }

            .total-price {
                font-weight: bold; 
                color: black; 
            }
            .address-infor{
                border: 1px solid #ddd; 
                border-radius: 5px;
            }
            .voucher-options {
                display: flex;
                flex-wrap: wrap;
                gap: 10px;
            }

            .voucher-option {
                display: flex;
                align-items: center;
                border: 1px solid #ddd;
                padding: 10px 15px;
                border-radius: 5px;
                cursor: pointer;
                transition: all 0.3s ease;
                font-weight: 500;
            }

            .voucher-option input[type="radio"] {
                display: none;
            }

            .voucher-option span {
                margin-left: 5px;
                color: #333;
            }

            .voucher-option:hover {
                background-color: #f0f0f0; 
                border-color: orange; 
            }

            .voucher-option input[type="radio"]:checked + span {
                color: orange;
                font-weight: bold;
            }

            .voucher-option input[type="radio"]:checked + span::before {
                content: "✓ ";
                color: orange; 
            }
            .btn-outline-primary:hover{
                background-color: #f0f0f0;
                color: orange
            }
            .btn-primary:not(:disabled):not(.disabled):active, .btn-primary:not(:disabled):not(.disabled).active, .show > .btn-primary.dropdown-toggle {
                background-color: orange;
                color: white !important;
            }   

        </style>
    </head>
    <body>
        <!-- Topbar Start -->
        <div class="container-fluid">
            <div class="row bg-secondary py-1 px-xl-5">
                <div class="col-lg-6 d-none d-lg-block">
                    <div class="d-inline-flex align-items-center h-100">
                        <a class="text-body mr-3" href="MGR_Dashboard.jsp">MANAGER</a>
                        <a class="text-body mr-3" href="AD_AccountManagement.jsp">ADMIN</a>
                        <a class="text-body mr-3" href="STAFF_OrderManagement.jsp">STAFF</a>
                        <a class="text-body mr-3" href="SHIPPER_OrderManagement.jsp">SHIPPER</a>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right col-md-12 col-sm-12">
                    <div class="d-inline-flex align-items-center justify-content-between">  
                        <div class="col-md-8 col-sm-10 text-left d-flex d-lg-none">
                            <form action="MainController" method="POST" class="w-100 d-flex mb-2 mb-lg-0">
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
                                            <a href="MainController?action=Category&Category=${Category.categoryID}" class="dropdown-item">All ${Category.name}</a>
                                            <c:forEach var="brand" items="${sessionScope.LIST_BRAND_BY_CATE}">
                                                <c:if test="${Category.categoryID == brand.categoryID}">
                                                    <a href="MainController?action=FilterByBrand" class="dropdown-item">${brand.brandName}</a>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:forEach>
                                <a href="blog.jsp" class="nav-item nav-link">Blog</a>
                                <c:if test="${not empty sessionScope.CUSTOMER_ID}">
                                    <a href="orderStatus.jsp" class="nav-item nav-link">History</a>
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
                        <a class="breadcrumb-item text-dark" href="MainController?action=HomeController">Home</a>
                        <a class="breadcrumb-item text-dark" href="#">Shop</a>
                        <span class="breadcrumb-item ">Checkout</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Checkout Start -->
        <form action="MainController" method="POST">
            <div class="container-fluid">
                <div class="row px-xl-5">
                    <div class="col-lg-8">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>
                        <div class="bg-light p-30 mb-5 address-infor">
                            ${requestScope.INFOR_MESSAGE}
                            <div class="row ">
                                <div class="col-md-6 form-group">
                                    <label>Name</label>
                                    <input class="form-control bg-transparent" type="text" value="${sessionScope.CUSTOMER.name}" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>E-mail</label>
                                    <input class="form-control bg-transparent" type="text" value="${sessionScope.CUSTOMER.email}" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Phone Number</label>
                                    <input class="form-control bg-transparent" type="text" value="${sessionScope.CUSTOMER.phone}" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>City</label>
                                    <input class="form-control bg-transparent" type="text" value="${sessionScope.CUSTOMER.area}" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>district</label>
                                    <input class="form-control bg-transparent" type="text" value="${sessionScope.CUSTOMER.district}" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Ward</label>
                                    <input class="form-control bg-transparent" type="text" value="${sessionScope.CUSTOMER.ward}" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Detail Address</label>
                                    <input class="form-control bg-transparent" type="text" value="${sessionScope.CUSTOMER.detailAddress}" readonly="">
                                </div>
                                <div class="col-lg-5 col-md-5 col-sm-12 mb-3 mt-3 text-right">
                                    <button class="btn btn-primary bg-transparent border-0" data-bs-toggle="modal" data-bs-target="#UpdateProfile" type="button">
                                        <span class=" bg-transparent text-primary" style="cursor: pointer;">
                                            <svg class="" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m14.304 4.844 2.852 2.852M7 7H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-4.5m2.409-9.91a2.017 2.017 0 0 1 0 2.853l-6.844 6.844L8 14l.713-3.565 6.844-6.844a2.015 2.015 0 0 1 2.852 0Z"/>
                                            </svg>
                                        </span>
                                    </button>
                                    <div class="modal fade" id="UpdateProfile" tabindex="-1" aria-labelledby="UpdateProfileLabel" aria-hidden="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="UpdateProfileLabel">User Information</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="fa fa-times"></i></button>
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
                                                    <button type="submit" name="action" value="UpdateCheckOutProfile" class="btn btn-primary">Update</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mb-5">
                            <h5 class="section-title position-relative text-uppercase mb-3">
                                <span class="bg-secondary pr-3">Payment</span>
                            </h5>
                            <div class="bg-light p-30 address-infor">
                                <div class="d-flex justify-content-between">

                                    <label class="btn btn-outline-primary d-flex align-items-center p-3 payment-option" for="cod" style="width: 48%;">
                                        <input type="radio" class="d-none" name="payment" value="1" id="cod" onchange="updateSelection(this)">
                                        <img src="img/COD.png" alt="COD" style="width: 30px; height: 30px;" class="mr-2">
                                        <span>COD</span>
                                    </label>

                                    <label class="btn btn-outline-primary d-flex align-items-center p-3 payment-option" for="zalo" style="width: 48%;">
                                        <input type="radio" class="d-none" name="payment" value="2" id="zalo" onchange="updateSelection(this)">
                                        <img src="img/zalopay.png" alt="Zalo Pay" style="width: 30px; height: 30px;" class="mr-2">
                                        <span>Zalo Pay</span>
                                    </label>
                                </div> 
                                <button type="submit" name="action" value="checkQuantity" class="btn btn-block btn-primary font-weight-bold py-3 mt-4" disabled="" id="placeOrderBtn">Place Order</button>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                        <c:forEach var="check" items="${sessionScope.CHECK_LIST.cart.values()}" varStatus="counter">
                            <input type="hidden" name="productDetailID" value="${check.productDetailID}"/>
                            <c:set var="unitTotal" value="${check.price * check.totalQuantity}"/>
                            <div class="product-info bg-light p-3 mb-3 align-items-center" id="product-${counter.count}" style=" display: ${counter.count > 1 ? "none" : "flex"}">
                                <img src="${check.image}" alt="${check.productName}" style="width: 50px; height: auto; margin-right: 15px;">
                                <div class="product-details">
                                    <h6 class="mb-1">${check.productName}</h6>
                                    <p class="mb-1">Size: ${check.sizeName}</p>
                                    <p class="mb-1">Quantity: ${check.totalQuantity}</p>
                                    <h6 class="total-price">
                                        <fmt:formatNumber type="number" value="${unitTotal}"/>
                                    </h6>
                                </div>
                            </div>
                        </c:forEach>      

                        <div style="text-align: center; margin-top: 10px;" class="d-flex justify-content-center text-primary">
                            <button type="button" id="viewMoreBtn" class="text-primary" onclick="toggleProducts()" 
                                    style="border: none; background: none; outline: none; display: flex; align-items: center; gap: 5px;">
                                View More
                                <img id="arrowIcon" src="//theme.hstatic.net/1000340570/1000964732/14/icon-down-black.svg?v=6179" 
                                     alt="View more" style="width: 20px; height: 20px; transition: transform 0.3s;
                                     filter: brightness(0) saturate(100%) invert(47%) sepia(89%) saturate(5925%) hue-rotate(356deg) brightness(103%) contrast(102%);">
                            </button>
                        </div>
                        <!-- Modal Popup voucher -->
                        <div class="modal fade" id="voucherModal" tabindex="-1" role="dialog" aria-labelledby="voucherModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="voucherModalLabel">Choose a Voucher</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="voucher-options mb-3">
                                            ${requestScope.MESSAGE}
                                            <c:forEach var="promotion" items="${sessionScope.PROMOTION}">
                                                <label class="voucher-option d-flex align-items-center border rounded p-3 mb-3">
                                                    <input type="radio" name="promotionID" value="${promotion.promotionID}" onclick="enableApplyButton()" class="d-none" />
                                                    <div class="flex-grow-1 ms-3">
                                                        <h6 class="mb-0">${promotion.promotionName}</h6>
                                                        <small class="text-muted">${promotion.description}</small>
                                                        <div class="d-flex justify-content-between mt-1">
                                                            <span class="text-primary">${promotion.discountPer}% OFF</span>
                                                            <span class="text-secondary">${promotion.condition}</span>
                                                        </div>
                                                    </div>
                                                    <i class="fa fa-check-circle fa-2x text-primary" aria-hidden="true" style="display: none;"></i>
                                                </label>
                                            </c:forEach>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary" name="action" value="ApplyVoucher" id="applyButton" disabled>
                                            Apply Voucher
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Modal Popup voucher -->
                        <div class="bg-light p-30 mb-5 address-infor mt-5">
                            <div class="border-bottom pt-3 pb-2">
                                <c:if test="${sessionScope.PROMOTION_DETAIL != null}">
                                    <div class="d-flex justify-content-between mb-3">
                                        <h6>Voucher</h6>
                                    </div>
                                    <div class="d-flex justify-content-between">
                                        <c:forEach var="promo" items="${sessionScope.PROMOTION_DETAIL}">
                                            <h6 class="font-weight-light">${promo.promotionName}</h6>
                                            <h6 class="font-weight-light">${promo.discountPer}%</h6>
                                        </c:forEach>
                                    </div>
                                </c:if>
                                <div class="pt-2">
                                    <div class="d-flex justify-content-between mt-2">
                                        <h5>Total</h5>
                                        <h5><fmt:formatNumber type="number" value="${requestScope.TOTAL_PRICE}"/> VND</h5>
                                        <input type="hidden" name="orderPrice" value="${requestScope.TOTAL_PRICE}"/>
                                        ${requestScope.CHECKOUT_MESSAGE}
                                    </div>
                                </div>
                            </div>
                            <div class="input-group-append mt-4 d-flex justify-content-end">
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#voucherModal">
                                    Choose Voucher
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- Checkout End -->


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


        <!-- Back to Top -->
        <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


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
                                                        let isExpanded = false;

                                                        function toggleProducts() {
                                                            const products = document.querySelectorAll('.product-info');

                                                            if (!isExpanded) {
                                                                products.forEach(product => product.style.display = 'flex');
                                                                document.getElementById("arrowIcon").style.transform = "rotate(180deg)";
                                                                isExpanded = true;
                                                            } else {
                                                                products.forEach((product, index) => product.style.display = index === 0 ? 'flex' : 'none');
                                                                document.getElementById("arrowIcon").style.transform = "rotate(0deg)";
                                                                isExpanded = false;
                                                            }
                                                        }

                                                        function enableApplyButton() {
                                                            const applyButton = document.getElementById('applyButton');
                                                            applyButton.disabled = false;

                                                            document.querySelectorAll('.voucher-option i').forEach(icon => {
                                                                icon.style.display = 'none';
                                                            });
                                                            const selectedVoucher = document.querySelector('input[name="promotionID"]:checked');
                                                            if (selectedVoucher) {
                                                                selectedVoucher.closest('.voucher-option').querySelector('i').style.display = 'inline'; // Hiện biểu tượng tick cho voucher được chọn
                                                            }
                                                        }


                                                        function updateSelection(selectedRadio) {
                                                            document.querySelectorAll('.payment-option').forEach(option => {
                                                                option.classList.remove('active', 'btn-primary');
                                                                option.classList.add('btn-outline-primary');
                                                            });

                                                            selectedRadio.closest('label').classList.add('active', 'btn-primary');
                                                            selectedRadio.closest('label').classList.remove('btn-outline-primary');
                                                            const placeOrderBtn = document.getElementById('placeOrderBtn');
                                                            const paymentSelected = document.querySelector('input[name="payment"]:checked');

                                                            placeOrderBtn.disabled = !paymentSelected;
                                                        }
        </script>
    </body>
</html>