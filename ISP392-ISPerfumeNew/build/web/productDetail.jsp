<%-- 
    Document   : productDetail
    Created on : Sep 27, 2024, 12:40:32 PM
    Author     : User
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Product Detail</title>
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
        <link href="css/stylePopup.css" rel="stylesheet">
        <style>
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

            .alert {
                padding: 20px 30px;
                font-size: 18px;
                max-width: 400px; 
                position: fixed; 
                top: 100px; 
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

            .size-button {
                display: inline-block; 
                border: 2px solid orange;
                padding: 5px 10px; 
                background-color: transparent; 
                color: orange; 
                text-decoration: none; 
                border-radius: 5px; 
                transition: background-color 0.3s; 
            }

            .size-button:hover {
                transform: scale(1.1);
                transition: transform 0.4s ease, box-shadow 0.4s ease, border 0.3s ease; 
            }

            .size-button.active {
                background-color: orange; 
                color: white
            }


            .product-img {
                position: relative;
                overflow: hidden;
                width: 100%;
                height: 300px; 
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .product-img img {
                max-width: 100%;
                max-height: 100%;
                object-fit: cover; 
            }

            .product-action {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                opacity: 0;
                transition: opacity 0.3s ease-in-out;
            }

            .product-item:hover .product-action {
                opacity: 1;
            }

            .text-truncate {
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                display: block;
            }

            h5, .d-flex {
                margin: 0;
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
                                <a href="MainController?action=HomeController" class="nav-item nav-link">Home</a>
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

        <!--Pop-up start-->
        <c:if test="${not empty requestScope.MESSAGE}">
            <div class="alert alert-success alert-dismissible fade show fade-out" role="alert" id="autoDismissAlert" >
                <i class="fa fa-check-circle me-2"></i> ${requestScope.MESSAGE}
                <button type="button" class="btn-close text-right" data-bs-dismiss="alert" aria-label="Close">
                    <i class="fa fa-times"></i>
                </button>
                <div class="progress-bar-timer bg-success" id="progressBar"></div>
            </div>
        </c:if>
        <div id="modalOverlay" class="modal-overlay" style="display: none;">
            <div id="deleteConfirmation" class="card">
                <div class="card-content">
                    <p class="card-heading">ISPerfume</p>
                    <p class="card-description">Please sign in to buy perfume</p>
                </div>
                <div class="card-button-wrapper">
                    <a href="signup.jsp" class="card-button secondary btn ">Sign up</a>
                    <a href="signin.jsp" class="card-button primary btn">Sign in</a>
                </div> 
                <button class="exit-button" onclick="cancelDelete()">
                    <svg height="20px" viewBox="0 0 384 512">
                    <path
                        d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z">
                    </path>
                    </svg>
                </button>
            </div>
        </div>

        <!--Pop-up End-->




        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="MainController?action=HomeController">Home</a>
                        <a class="breadcrumb-item text-dark" href="MainController?action=NavigateShopping&brandID=${requestScope.CURRENT_BRAND_ID}">${sessionScope.BRAND_BY_PRODUCT}</a>
                        <span class="breadcrumb-item active">${sessionScope.PRODUCT_NAME}</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Shop Detail Start -->
        <form action="MainController">
            <c:forEach var="product" items="${sessionScope.PRODUCT_INFORMATION}">
                <input type="hidden" name="productID" value="${product.productID}">
                <div class="container-fluid pb-5">
                    <div class="row px-xl-5">
                        <div class="col-lg-5 mb-30">
                            <div id="product-carousel" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner bg-light">
                                    <c:forEach var="image" items="${sessionScope.LIST_IMAGE}">
                                        <div class="carousel-item active">
                                            <img class="w-100 h-100" src="${image.image}" alt="Image">
                                        </div>
                                    </c:forEach>
                                </div>
                                <a class="carousel-control-prev" href="#product-carousel" data-slide="prev">
                                    <i class="fa fa-2x fa-angle-left text-dark"></i>
                                </a>
                                <a class="carousel-control-next" href="#product-carousel" data-slide="next">
                                    <i class="fa fa-2x fa-angle-right text-dark"></i>
                                </a>
                            </div>
                        </div>

                        <div class="col-lg-7 h-auto mb-30">
                            <div class="h-100 bg-light p-30">
                                <h3>${product.name}</h3>
                                <c:forEach var="price" items="${sessionScope.PRICE_BY_SIZE}">
                                    <input type="hidden" name="productDetailID" value="${price.productDetailID}"/>
                                 
                                    <input type="hidden" name="sizeID" value="${price.sizeID}">
                                    <h3 class="font-weight-semi-bold mb-4"><fmt:formatNumber type="number" value="${price.price}"/>  VND</h3>
                                </c:forEach>
                                <div class="d-flex mb-3">
                                    <strong class="text-dark mr-2 mt-1">Sizes:</strong>
                                    <c:forEach var="size" items="${sessionScope.AVAILABLE_SIZE}">
                                        <a href="MainController?action=PriceBySize&sizeID=${size.sizeID}&productID=${size.productID}" 
                                           class="size-button ml-2 ${size.sizeID == param.sizeID ? "active" : ""}">${size.sizeName}</a>
                                    </c:forEach>
                                </div>
                                <div class="d-flex align-items-center mb-4 pt-2">
                                    <div class="input-group quantity mr-3" style="width: 130px;">
                                        <div class="input-group-btn">
                                            <button class="btn btn-primary btn-minus" type="button">
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                        <input type="text" id="quantityInput" name="quantity" class="form-control bg-secondary border-0 text-center" value="1" readonly>
                                        <div class="input-group-btn">
                                            <button class="btn btn-primary btn-plus" type="button">
                                                <i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <script>
                                        document.querySelector('.btn-minus').addEventListener('click', function () {
                                            let input = document.getElementById('quantityInput');
                                            let currentValue = parseInt(input.value);
                                            if (currentValue > 1) {
                                                input.value = currentValue - 1;
                                            }
                                        });

                                        document.querySelector('.btn-plus').addEventListener('click', function () {
                                            let input = document.getElementById('quantityInput');
                                            let currentValue = parseInt(input.value);
                                            input.value = currentValue + 1;
                                        });
                                    </script>                                  
                                    <c:choose>
                                        <c:when test="${not empty sessionScope.CUSTOMER_ID}">
                                            <i class="fa fa-shopping-cart mr-1"></i>
                                            <input type="submit" name="action" value="AddToCart" class="btn btn-primary px-3"/>
                                        </c:when>
                                        <c:otherwise>
                                            <button class="btn btn-primary px-3" onclick="openDeleteModal(this, event)">
                                                <i class="fa fa-shopping-cart mr-1">Add To Cart</i>
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="row px-xl-5">
                        <div class="col">
                            <div class="bg-light p-30">
                                <div class="nav nav-tabs mb-4">
                                    <a class="nav-item nav-link text-dark active" data-toggle="tab" href="#tab-pane-1">Description</a>
                                    <a class="nav-item nav-link text-dark" data-toggle="tab" href="#tab-pane-2">Information</a>
                                </div>
                                <div class="tab-content">
                                    <div class="tab-pane fade show active" id="tab-pane-1">
                                        <h4 class="mb-3">Product Description</h4>
                                        <p>${product.description}</p>

                                    </div>
                                    <div class="tab-pane fade" id="tab-pane-2">
                                        <h5 class="mb-3">Country: ${product.country}</h5>
                                        <h5 class="mb-3">Release Date:  ${product.releaseDate}</h5>
                                        <h5 class="mb-3">Fragrance Families: ${product.fragranceFamilies}</h5>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
        </form>
        <!-- Shop Detail End -->


        <!-- Products Start -->
        <div class="container-fluid py-5">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">You May Also Like</span></h2>
            <div class="row px-xl-5">
                <div class="col">
                    <div class="owl-carousel related-carousel">
                        <c:forEach var="product" items="${sessionScope.SUGGEST_PRODUCT}">
                            <div class="product-item bg-light">
                                <div class="product-img position-relative overflow-hidden">
                                    <img class="img-fluid w-100" src="${product.image}" alt="">
                                    <div class="product-action">
                                        <c:choose>
                                            <c:when test="${not empty sessionScope.CUSTOMER_ID}">
                                                <a class="btn btn-outline-dark btn-square" href="MainController?action=quickAddToCart&productDetailID=${product.productDetailID}&quantity=1"><i class="fa fa-shopping-cart"></i>
                                                </a>
                                            </c:when>
                                            <c:otherwise>
                                                <a onclick="openDeleteModal(this, event)" class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                                </c:otherwise>
                                            </c:choose>
                                        <a class="btn btn-outline-dark btn-square" href="MainController?action=NavigateRelatedProductDetail&categoryID=${product.categoryID}&productID=${product.productID}&sizeID=${product.sizeID}"><i class="fa fa-search"></i></a>
                                    </div>
                                </div>
                                <div class="text-center py-4">
                                    <a class="h6 text-decoration-none text-truncate" href="">${product.productName} ${product.sizeName}</a>
                                    <div class="d-flex align-items-center justify-content-center mt-2">
                                        <h5><fmt:formatNumber type="number" value="${product.price}"/>  VND</h5>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
        <!-- Products End -->


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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

        <script>
                                                    function updateQuantity(change, event) {
                                                        event.preventDefault();
                                                        const quantityInput = document.getElementById('quantity-input');
                                                        let quantity = parseInt(quantityInput.value) + change;
                                                        if (quantity < 1) {
                                                            quantity = 1;
                                                        }
                                                        quantityInput.value = quantity;
                                                    }
                                                    function openDeleteModal(button, event) {
                                                        event.preventDefault();
                                                        deleteButtonRef = button;

                                                        // Show the modal
                                                        document.getElementById('deleteConfirmation').style.display = 'block';
                                                        document.getElementById('modalOverlay').style.display = 'block';
                                                    }

                                                    function cancelDelete() {
                                                        document.getElementById('deleteConfirmation').style.display = 'none';
                                                        document.getElementById('modalOverlay').style.display = 'none';
                                                    }

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
