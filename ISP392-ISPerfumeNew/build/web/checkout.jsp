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
        <title>MultiShop - Online Shop Website Template</title>
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
                        <i class="fa fa-leaf"></i>
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
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <a class="breadcrumb-item text-dark" href="#">Shop</a>
                        <span class="breadcrumb-item ">Checkout</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Checkout Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-lg-8">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Billing Address</span></h5>

                    <div class="bg-light p-30 mb-5">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Name</label>
                                <input class="form-control" type="text" value="${sessionScope.CUSTOMER.name}" readonly="">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>E-mail</label>
                                <input class="form-control" type="text" value="${sessionScope.CUSTOMER.email}" readonly="">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Phone Number</label>
                                <input class="form-control" type="text" value="${sessionScope.CUSTOMER.phone}" readonly="">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>City</label>
                                <input class="form-control" type="text" value="${sessionScope.CUSTOMER.area}" readonly="">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>district</label>
                                <input class="form-control" type="text" value="${sessionScope.CUSTOMER.district}" readonly="">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Ward</label>
                                <input class="form-control" type="text" value="${sessionScope.CUSTOMER.ward}" readonly="">
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Detail Address</label>
                                <input class="form-control" type="text" value="${sessionScope.CUSTOMER.detailAddress}" readonly="">
                            </div>
                            <div class="col-md-12">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="shipto">
                                    <label class="custom-control-label" for="shipto"  data-toggle="collapse" data-target="#shipping-address">Ship to different address</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="collapse mb-5" id="shipping-address">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Shipping Address</span></h5>
                        <div class="bg-light p-30">
                            <div class="row">
                                <div class="col-md-6 form-group">
                                    <label>Name</label>
                                    <input class="form-control" type="text" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>E-mail</label>
                                    <input class="form-control" type="text" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Phone Number</label>
                                    <input class="form-control" type="text" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>City</label>
                                    <input class="form-control" type="text" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>District</label>
                                    <input class="form-control" type="text" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Ward</label>
                                    <input class="form-control" type="text" readonly="">
                                </div>
                                <div class="col-md-6 form-group">
                                    <label>Detail Address</label>
                                    <input class="form-control" type="text" readonly="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Order Total</span></h5>
                    <c:forEach var="check" items="${sessionScope.CHECK_LIST.cart.values()}">
                        <c:set var="unitTotal" value="${check.price * check.totalQuantity}"/>
                        <div class="bg-light p-30 mb-5">
                            <img src="${check.image}" alt="" style="width: 50px;"><h6 class="mb-3">${check.productName} ${check.sizeName}      ${check.totalQuantity}          
                                <fmt:formatNumber type="number" value="${unitTotal}"/></h6>
                        </div>
                    </c:forEach>
                    <form action="MainController">
                        <div class="input-group mb-30">
                            <c:forEach var="promotion" items="${sessionScope.PROMOTION}">
                                <input type="radio" name="promotionID" value="${promotion.promotionID}"/>${promotion.promotionName}
                            </c:forEach>
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-primary" name="action" value="ApplyVoucher">Apply Voucher</button>
                            </div>
                        </div>

                        <div class="bg-light p-30 mb-5">
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
                                        <c:choose>
                                            <c:when test="${requestScope.FINAL_PRICE != null}">
                                                <h5><fmt:formatNumber type="number" value="${requestScope.FINAL_PRICE}"/> VND</h5>
                                            </c:when>
                                            <c:otherwise>
                                                <h5><fmt:formatNumber type="number" value="${sessionScope.TOTAL_PRICE.total}"/> VND</h5>
                                            </c:otherwise>
                                        </c:choose>
                                        ${requestScope.CHECKOUT_MESSAGE}
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="mb-5">
                            <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Payment</span></h5>
                            <div class="bg-light p-30">
                                <div class="form-group">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="payment" value="1" id="paypal">
                                        <label class="custom-control-label" for="paypal">Paypal</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="payment" value="2" id="directcheck">
                                        <label class="custom-control-label" for="directcheck">Direct Check</label>
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    <div class="custom-control custom-radio">
                                        <input type="radio" class="custom-control-input" name="payment" value="3" id="banktransfer">
                                        <label class="custom-control-label" for="banktransfer">Bank Transfer</label>
                                    </div>
                                </div>
                                <button type="submit" name="action" value="checkOut" class="btn btn-block btn-primary font-weight-bold py-3">Place Order</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- Checkout End -->


    <!-- Footer Start -->
    <div class="container-fluid bg-dark text-secondary mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <h5 class="text-secondary text-uppercase mb-4">Get In Touch</h5>
                <p class="mb-4">No dolore ipsum accusam no lorem. Invidunt sed clita kasd clita et et dolor sed dolor. Rebum tempor no vero est magna amet no</p>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street, New York, USA</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@example.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        <h5 class="text-secondary text-uppercase mb-4">Quick Shop</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                            <a class="text-secondary" href="#"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="text-secondary text-uppercase mb-4">My Account</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shop Detail</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-secondary mb-2" href="#"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                            <a class="text-secondary" href="#"><i class="fa fa-angle-right mr-2"></i>Contact Us</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="text-secondary text-uppercase mb-4">Newsletter</h5>
                        <p>Duo stet tempor ipsum sit amet magna ipsum tempor est</p>
                        <form action="">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Your Email Address">
                                <div class="input-group-append">
                                    <button class="btn btn-primary">Sign Up</button>
                                </div>
                            </div>
                        </form>
                        <h6 class="text-secondary text-uppercase mt-4 mb-3">Follow Us</h6>
                        <div class="d-flex">
                            <a class="btn btn-primary btn-square mr-2" href="#"><i class="fab fa-twitter"></i></a>
                            <a class="btn btn-primary btn-square mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                            <a class="btn btn-primary btn-square mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                            <a class="btn btn-primary btn-square" href="#"><i class="fab fa-instagram"></i></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row border-top mx-xl-5 py-4" style="border-color: rgba(256, 256, 256, .1) !important;">
            <div class="col-md-6 px-xl-0">
                <p class="mb-md-0 text-center text-md-left text-secondary">
                    &copy; <a class="text-primary" href="#">Domain</a>. All Rights Reserved. Designed
                    by
                    <a class="text-primary" href="https://htmlcodex.com">HTML Codex</a>
                </p>
            </div>
            <div class="col-md-6 px-xl-0 text-center text-md-right">
                <img class="img-fluid" src="img/payments.png" alt="">
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
</body>
</html>
