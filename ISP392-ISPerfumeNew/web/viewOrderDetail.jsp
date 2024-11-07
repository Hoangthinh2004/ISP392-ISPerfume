<%-- 
    Document   : changePassword
    Created on : Oct 5, 2024, 12:16:41 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Order Detail</title>
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
                                <a href="MainController?action=HomeController" class="nav-item nav-link active btn">Home</a>
                                <c:forEach var="Category" items="${sessionScope.LIST_CATEGORY}">
                                    <div class="nav-item dropdown">
                                        <a href="MainController?action=Category&Category=${Category.categoryID}" class="nav-link dropdown-toggle btn" data-toggle="dropdown">${Category.name}</a>
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
                                <a href="MainController?action=NavigateBlog" class="nav-item nav-link btn">Blog</a>
                                <c:if test="${not empty sessionScope.CUSTOMER_ID}">
                                    <a href="MainController?action=viewOrderHistory&customerID=${CUSTOMER_ID.customerID}" class="nav-item nav-link btn"> Order History</a>
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


        <div class="container-fluid pt-4 px-4">
            <div class="row vh-100 bg-light rounded align-items-center justify-content-center mx-0 " style="height: auto !important">
                <div class="table-responsive">
                    <div class="col-sm-12 col-xl-12">
                        <div class="bg-light rounded h-100 p-4">
                            <c:if test="${requestScope.ORDER_CUSTOMER.shipperID!=0}">
                                <div class="d-flex flex-column align-items-start justify-content-between mb-4">
                                    <h6 class="mb-0">Information</h6>
                                </div>
                                <c:forEach var="user" items="${sessionScope.LIST_USER}">
                                    <c:if test="${requestScope.ORDER_CUSTOMER.shipperID == user.userID}">
                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                            <p class="mb-0"><strong>Shipper: </strong>${user.name} </p>
                                            <p class="mb-0"><strong>Phone: </strong>${user.phone}</p>
                                            <p class="mb-0"><strong>Address: </strong>${requestScope.ORDER_CUSTOMER.address}, Ward ${requestScope.ORDER_CUSTOMER.ward}, ${requestScope.ORDER_CUSTOMER.district}, ${requestScope.ORDER_CUSTOMER.city} </p>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                            <div class="d-flex flex-column align-items-start justify-content-between mb-4">
                                <h6 class="mb-0">Order Detail</h6>
                            </div>
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Product</th>
                                        <th scope="col">Size</th>
                                        <th scope="col">Quantity</th>
                                        <th scope="col">Unit Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="orderDetail" items="${requestScope.LIST_ORDER_DETAIL_CUSTOMER}">
                                        <!--                                        product-->
                                        <tr>
                                            <td>
                                                <c:forEach var="productDetail" items="${sessionScope.LIST_PRODUCT_DETAIL}">
                                                    <c:if test="${orderDetail.productDetailID == productDetail.productDetailID}">
                                                        <c:forEach var="product" items="${sessionScope.LIST_PRODUCT}">
                                                            <c:if test="${product.productID == productDetail.productID}">
                                                                ${product.name}
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <!--                                            size-->
                                            <td>
                                                <c:forEach var="productDetail" items="${sessionScope.LIST_PRODUCT_DETAIL}">
                                                    <c:if test="${orderDetail.productDetailID == productDetail.productDetailID}">
                                                        <c:forEach var="size" items="${sessionScope.LIST_SIZE}">
                                                            <c:if test="${size.sizeID == productDetail.sizeID}">
                                                                ${size.name}
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:if>
                                                </c:forEach>
                                            </td>
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
                            <div class="d-flex justify-content-between">
                                <div class="">
                                    <div class="d-flex justify-content-start align-items-center">
                                        <h6 class="mb-0">Total Price:</h6>
                                        <p class="mb-0 ml-3">
                                            <c:forEach var="orderDetail" items="${requestScope.LIST_ORDER_DETAIL_CUSTOMER}" >
                                                <c:set var="unitTotal" value="${orderDetail.unitPrice * orderDetail.quantity}"/>
                                                <c:set var="Total" value="${unitTotal + Total}"/>
                                            </c:forEach>
                                            <fmt:formatNumber value="${Total}" type="number"/> VNĐ
                                        </p>
                                    </div>
                                    <c:choose>
                                        <c:when test="${requestScope.ORDER_CUSTOMER.promotionID != 0}">
                                            <div class="d-flex justify-content-start align-items-center">
                                                <h6 class="mb-0">Promotion Applied:</h6>
                                                <c:forEach var="promotion" items="${sessionScope.LIST_PROMOTION}">
                                                    <c:if test="${requestScope.ORDER_CUSTOMER.promotionID == promotion.promotionID}">
                                                        <p class="mb-0 ml-3">${promotion.promotionName} - ${promotion.discountPer}% off</p>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                            <div class="d-flex justify-content-start align-items-center">
                                                <h6 class="mb-0 ">Final Price:</h6>
                                                <c:forEach var="promotion" items="${sessionScope.LIST_PROMOTION}">
                                                    <c:if test="${requestScope.ORDER_CUSTOMER.promotionID == promotion.promotionID}">
                                                        <p class="mb-0 ml-3">
                                                            <fmt:formatNumber value="${Total * (1 - promotion.discountPer / 100.0)}" type="number"/> VNĐ
                                                        </p>
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="d-flex justify-content-start align-items-center">
                                                <h6 class="mb-0">Final Price</h6>
                                                <p class="mb-0 ml-3">
                                                    <fmt:formatNumber value="${Total}" type="number"/> VNĐ
                                                </p>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div>
                                    <a class="btn btn-primary" href="MainController?action=viewOrderHistory&customerID=${CUSTOMER_ID.customerID}">
                                        Back
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
