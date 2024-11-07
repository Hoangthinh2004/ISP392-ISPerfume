<%-- 
    Document   : shopping
    Created on : Sep 26, 2024, 3:55:52 PM
    Author     : User
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Shop</title>
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
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/bootstrap.min2.css" rel="stylesheet">

        <style>
            .text-container {
                max-height: 50px; 
                overflow: hidden;
                transition: max-height 0.5s ease-in-out;
            }

            .text-container.expanded {
                max-height: 500px; 
            }
            #toggle-btn {
                transition: transform 0.3s ease; 
                cursor: pointer;
            }

            #toggle-btn.expanded {
                transform: rotate(180deg);
            }


            .custom-control-input {
                display: none;
            }

            .checkbox-wrapper {
                position: relative;
            }

            .btn-checkbox {
                display: inline-block;
                padding: 5px 5px;
                border: 1px solid #e5e7eb; 
                border-radius: 12px;
                cursor: pointer;
                background-color: #f3f4f6;
                transition: border-color 0.3s;
            }

            .custom-control-input:checked + .btn-checkbox {
                border: 2px solid #FE980F; 
                border-color: orange; 
                background: #FE980F;
                color: white;
            }

            .btn-checkbox:hover {
                transform: scale(1.05); 
                transition: transform 0.3s ease, box-shadow 0.3s ease, border 0.3s ease; 
                border: 1px solid #FE980F;
            }

            .custom-control-input:focus + .btn-checkbox {
                outline: none;
                box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
            }
            .product-img {
                height: 300px; 
                width: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                background-color: transparent; 
            }

            .product-image {
                height: 100%;
                width: auto; 
                object-fit: cover; 
                transition: transform 0.3s ease-in-out; 
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
                                        <a href="MainController?action=Category&CategoryID=${Category.categoryID}" class="nav-link dropdown-toggle ${Category.categoryID == param.CategoryID ? "active" : ""}" data-toggle="dropdown">${Category.name}</a>
                                        <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                            <a href="MainController?action=Category&CategoryID=${Category.categoryID}" class="btn dropdown-item  ${Category.categoryID == param.CategoryID && param.brandID == null ? "active" : ""}">All ${Category.name}</a>
                                            <c:forEach var="brand" items="${sessionScope.LIST_BRAND_BY_CATE}">
                                                <c:if test="${Category.categoryID == brand.categoryID}">
                                                    <a href="MainController?action=Category&CategoryID=${Category.categoryID}&brandID=${brand.brandID}" class="dropdown-item btn ${Category.categoryID == param.CategoryID && brand.brandID == param.brandID ? "active" : ""}">${brand.brandName}</a>
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
        <div id="modalOverlay" class="modal-overlay" style="display: none;">
            <div id="deleteConfirmation" class="card">
                <div class="card-content">
                    <p class="card-heading">ISPerfume</p>
                    <p class="card-description">Please sign in to buy perfume</p>
                </div>
                <div class="card-button-wrapper">
                    <a href="signup.jsp" class="card-button secondary btn">Sign up</a>
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
                        <c:choose>
                            <c:when test="${requestScope.BRAND != null}">
                                <c:forEach var="category" items="${sessionScope.LIST_CATEGORY}">
                                    <c:if test="${sessionScope.LIST_BRAND_BY_CATE!= null}">
                                        <c:if test="${category.categoryID == requestScope.CATEID}">
                                            <a class="breadcrumb-item text-dark" href="MainController?action=Category&Category=${category.categoryID}">${category.name}</a>
                                            <span class="breadcrumb-item active">${sessionScope.LIST_PRODUCT[0].brandName}</span>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${requestScope.BRA_NAME != null}">
                                        <c:forEach var="category" items="${sessionScope.LIST_CATEGORY}">
                                            <c:if test="${category.categoryID == requestScope.CATEID}">
                                                <a class="breadcrumb-item text-dark" href="MainController?action=Category&Category=${Category.categoryID}">${category.name}</a>
                                                <c:if test="${category.categoryID == requestScope.CATEID}">
                                                    <span class="breadcrumb-item text-dark">${requestScope.BRA_NAME}</span>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="category" items="${sessionScope.LIST_CATEGORY}">
                                            <c:if test="${category.categoryID == sessionScope.LIST_PRODUCT[0].categoryID}">
                                                <span class="breadcrumb-item active">${category.name}</span>
                                            </c:if>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!--Banner Start-->
        <div class="container-fluid">
            <c:forEach var="brand" items="${sessionScope.BRAND_INFOR}">
                <div class="row px-xl-5 mb-5">
                    <div class="col-lg-12 bg-transparent">
                        <div class="justify-content-center align-content-center d-flex">
                            <img src="${brand.image}" style="width: auto; height: 490px;">
                        </div>
                    </div>
                    <div class="col-lg-12 bg-transparent">
                        <div class="description-box bg-transparent p-4">
                            <div class="description-header d-flex justify-content-center align-items-center">
                                <img id="toggle-btn" class="icon-down-black" src="//theme.hstatic.net/1000340570/1000964732/14/icon-down-black.svg?v=6179" style="cursor: pointer;">
                            </div>
                            <div id="description-content" class="mt-2 text-container bg-transparent">
                                <p>${brand.description}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!--Banner End-->

        <!-- Shop Start -->
        <form action="MainController" method="POST">
            <div class="container-fluid">
                <div class="row px-xl-5">
                    <!-- Shop Sidebar Start -->
                    <div class="col-lg-3 col-md-4">
                        <!-- Filter By Brand Start -->
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter By Brand</span></h5>
                        <div class="panel-group category-products bg-light" id="accordian">
                            <!--category-productsr-->
                            <c:forEach var="brand" items="${sessionScope.LIST_BRAND}">
                                <div class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                                    <a href="MainController?action=FilterByBrand&brandID=${brand.brandID}">${brand.name}</a>
                                </div>
                            </c:forEach>
                        </div>
                        <!--/category-products-->

                        <!-- Filter By Size Start -->
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Filter by size</span></h5>
                        <div
                            class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
                            <input type="checkbox" class="custom-control-input" id="color-1">
                        </div>
                        <div class="bg-light p-4 mb-30 panel-group m-auto">
                            <c:forEach var="size" items="${sessionScope.LIST_SIZE}">
                                <div class="checkbox-wrapper mb-3 d-flex align-items-center justify-content-between">
                                    <input type="checkbox" class="custom-control-input" name="sizeID[]" value="${size.sizeID}" id="size-${size.sizeID}"/>
                                    <label class="btn-checkbox" for="size-${size.sizeID}">
                                        ${size.name}
                                    </label>
                                </div>
                            </c:forEach>
                            <button type="submit" name="action" value="ViewResultInShopping" class="btn btn-primary mt-3">View Result</button>
                            <div class="text-danger mt-2">${requestScope.MESSAGE}</div>
                        </div>

                        <!-- Filter By Size End -->
                    </div>
                    <!-- Shop Sidebar End -->


                    <!-- Shop Product Start -->
                    ${requestScope.MESSAGE}
                    <div class="col-lg-9 col-md-8">
                        <div class="row pb-3">
                            <div class="col-12 pb-1">
                                <div class="d-flex align-items-center justify-content-end mb-4">
                                    <div class="ml-2">
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">Sorting</button>
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="dropdown-item" href="MainController?action=DescendingSortByPrice">Descending Price</a>
                                                <a class="dropdown-item" href="MainController?action=AscendingSortByPrice">Ascending price</a>
                                                <a class="dropdown-item" href="MainController?action=SortByPurchasing">Best Seller</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <c:forEach var="Product" items="${sessionScope.LIST_PRODUCT}">
                                <input type="hidden" name="productDetailID" value="${Product.productDetailID}"/>
                                <div class="col-lg-4 col-md-6 col-sm-6 pb-1">
                                    <div class="product-item bg-light mb-4">
                                        <div class="product-img position-relative overflow-hidden">
                                            <img class="img-fluid w-100" src="${Product.image}" alt="">
                                            <div class="product-action">
                                                <c:choose>
                                                    <c:when test="${not empty sessionScope.CUSTOMER_ID}">
                                                        <a class="btn btn-outline-dark btn-square" href="MainController?action=quickAddToCart&productDetailID=${Product.productDetailID}&quantity=1"><i class="fa fa-shopping-cart"></i>
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a onclick="openDeleteModal(this, event)" class="btn btn-outline-dark btn-square" href=""><i class="fa fa-shopping-cart"></i></a>
                                                        </c:otherwise>
                                                    </c:choose>
                                                <a class="btn btn-outline-dark btn-square" href="MainController?action=NavigateProductDetail&productID=${Product.productID}&sizeID=${Product.sizeID}"><i class="fa fa-search"></i></a>
                                            </div>
                                        </div>
                                        <div class="text-center py-4">
                                            <h4>${Product.brandName}</h4>
                                            <a class="h6 text-decoration-none text-truncate" href="MainController?action=NavigateProductDetail&productID=${Product.productID}&sizeID=${Product.sizeID}">${Product.productName} ${Product.sizeName}</a>
                                            <div class="d-flex align-items-center justify-content-center mt-2">
                                                <h5><fmt:formatNumber type="number" value="${Product.price}"/> VND</h5> 
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <!-- Shop Product End -->
                </div>
            </div>
        </form>
        <!-- Shop End -->


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
        <script>
                                                            const toggleBtn = document.getElementById("toggle-btn");
                                                            const descriptionContent = document.getElementById("description-content");

                                                            toggleBtn.addEventListener("click", function () {
                                                                if (descriptionContent.classList.contains("expanded")) {
                                                                    descriptionContent.classList.remove("expanded");
                                                                    toggleBtn.classList.remove("expanded");
                                                                } else {
                                                                    descriptionContent.classList.add("expanded");
                                                                    toggleBtn.classList.add("expanded");
                                                                }
                                                            });
                                                            function openDeleteModal(button, event) {
                                                                event.preventDefault();
                                                                deleteButtonRef = button; // Store the reference to the delete button

                                                                // Show the modal
                                                                document.getElementById('deleteConfirmation').style.display = 'block';
                                                                document.getElementById('modalOverlay').style.display = 'block';
                                                            }

                                                            function cancelDelete() {
                                                                // Hide the modal and overlay
                                                                document.getElementById('deleteConfirmation').style.display = 'none';
                                                                document.getElementById('modalOverlay').style.display = 'none';
                                                            }
        </script>
    </body>
</html>
