<%-- 
    Document   : blog
    Created on : Sep 27, 2024, 9:03:58 PM
    Author     : User
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <style>
            .text-muted {
                color: rgba(0, 0, 0, 0.3) !important;
            }
            img {
                border-radius: 10px;
            }

            .blog-post {
                border-radius: 15px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                padding: 20px;
                background-color: #fff;
            }           

            .list-group-item-blog {
                margin-bottom: 10px;
                padding: 15px;
            }
            .blog-post, .list-group-item-blog {
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.05); /* Hiệu ứng bóng nhẹ */
            }

            .blog-post:hover, .list-group-item-blog:hover {
                box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);
            }
            img, .btn, .list-group-item-blog {
                transition: all 0.3s ease;
            }

            img:hover, .btn:hover, .list-group-item-blog:hover {
                transform: scale(1.05); 
                box-shadow: 0 8px 16px rgba(0, 0, 0, 0.1); 
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
                        <a class="text-body mr-3" href="">Contact</a>
                        <a class="text-body mr-3" href="">Help</a>
                        <a class="text-body mr-3" href="">FAQs</a>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <div class="d-inline-flex align-items-center">

                            <div class="btn-group">
                                <!-- Display when not logged in. -->
                                <c:choose>
                                    <c:when test="${sessionScope.LOGIN_USER == null}">
                                        <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">${sessionScope.LOGIN_USER.name}</button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                            <div class="dropdown-menu dropdown-menu-right">
                                                <a class="dropdown-item btn" type="button" href="signin.jsp">Sign in</a>
                                                <a class="dropdown-item btn" type="button" href="signup.jsp">Sign up</a>
                                            </div>
                                    </c:when>
                                    <!-- Display when logged in. -->
                                    <c:otherwise>
                                        <a class="dropdown-item btn" type="button" href="MainController?action=Sign out">Sign out</a>
                                        <a class="dropdown-item btn" type="button" href="profile.jsp">Profile</a>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>                                            

                        </div>
                    </div>
                    <div class="d-inline-flex align-items-center d-block d-lg-none">
                        <a href="" class="btn px-0 ml-2">
                            <i class="fas fa-heart text-dark"></i>
                            <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                        </a>
                        <a href="" class="btn px-0 ml-2">
                            <i class="fas fa-shopping-cart text-dark"></i>
                            <span class="badge text-dark border border-dark rounded-circle" style="padding-bottom: 2px;">0</span>
                        </a>
                    </div>
                </div>
            </div>
            <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
                <div class="col-lg-4">
                    <a href="home.jsp" class="text-decoration-none">
                        <span class="h1 text-uppercase text-primary bg-dark px-2">IS</span>
                        <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Perfume</span>
                    </a>
                </div>
                <div class="col-lg-4 col-6 text-left">
                    <div class="input-group">
                        <form action="MainController" method="POST" class="w-100">
                            <div class="input-group-append">
                                <input type="text" class="form-control" placeholder="Search for products" name="search" 
                                       style="border-radius: 20px 0 0 20px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); padding: 10px; height: 100%;">
                                <button name="action" value="SearchProduct" type="submit" class="btn" 
                                        style="border-radius: 0 20px 20px 0; background-color:orange; color: white; padding: 7.5px 20px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); height: 100%;">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-lg-4 col-6 text-right">
                    <p class="m-0">Customer Service</p>
                    <h5 class="m-0">+012 345 6789</h5>
                </div>
            </div>
        </div>
        <!-- Topbar End -->

        <!-- Navbar Start -->
        <form action="MainController">
            <div class="container-fluid bg-dark mb-30">
                <div class="row px-xl-5">
                    <div class="col-lg-3 d-none d-lg-block">
                        <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                            <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Category</h6>
                            <i class="fa fa-angle-down text-dark"></i>
                        </a>
                        <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                            <div class="navbar-nav w-100">
                                <c:forEach var="Category" items="${sessionScope.LIST_CATEGORY}">
                                    <a href="MainController?action=Category&Category=${Category.categoryID}" class="nav-item nav-link">${Category.name}</a>
                                </c:forEach>
                                <!--                            <div class="nav-item dropdown dropright">
                                                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Dresses <i class="fa fa-angle-right float-right mt-1"></i></a>
                                                                <div class="dropdown-menu position-absolute rounded-0 border-0 m-0">
                                                                    <a type="submit" name="action" value="men" class="dropdown-item">Men's Dresses</a>
                                                                    <a href="" class="dropdown-item">Women's Dresses</a>
                                                                    <a href="" class="dropdown-item">Baby's Dresses</a>
                                                                </div>
                                                            </div>-->
                            </div>
                        </nav>
                    </div>
                    <div class="col-lg-9">
                        <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
                            <a href="" class="text-decoration-none d-block d-lg-none">
                                <span class="h1 text-uppercase text-dark bg-light px-2">Multi</span>
                                <span class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
                            </a>
                            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                                <div class="navbar-nav mr-auto py-0">
                                    <a href="home.jsp" class="nav-item nav-link ">Home</a>
                                    <a href="shopping.jsp" class="nav-item nav-link">Shop</a>
                                    <a href="productDetail.jsp" class="nav-item nav-link">Shop Detail</a>
                                    <div class="nav-item dropdown">
                                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages <i class="fa fa-angle-down mt-1"></i></a>
                                        <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                            <a href="cart.jsp" class="dropdown-item">Shopping Cart</a>
                                            <a href="checkout.jsp" class="dropdown-item">Checkout</a>
                                        </div>
                                    </div>
                                    <a href="blog.jsp" class="nav-item nav-link active">Blog</a>
                                    <a href="orderStatus.jsp" class="nav-item nav-link">Order Status</a>
                                </div>
                                <div class="navbar-nav ml-auto py-0 d-none d-lg-block">                            
                                    <a href="cart.jsp" class="btn px-0 ml-3">
                                        <i class="fas fa-shopping-cart text-primary"></i>
                                        <span class="badge text-secondary border border-secondary rounded-circle" style="padding-bottom: 2px;">0</span>
                                    </a>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </form>
        <!-- Navbar End -->

        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <span class="breadcrumb-item active">Blog</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Blog Posts -->
        <div class="container d-flex justify-content-between">
            <div class="row">
                <!-- Blog Start -->
                <div class="col-lg-8">
                    <div class="blog-post mb-5">
                        <img src="img/blog/blog-one.jpg" class="img-fluid" alt="Blog Post Image">
                        <h2 class="mt-3">Blog Title 1</h2>
                        <p class="text-muted">16/11/2024 by <a href="#">Author</a></p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum. 
                            Sed feugiat, nisl ut facilisis facilisis, est arcu consequat neque, a tempus neque ligula at lorem. 
                            Curabitur placerat sapien vel orci bibendum, at dignissim libero cursus.</p>
                        <a href="singleBlog.jsp" class="btn btn-primary">Read more</a>
                    </div>

                    <div class="blog-post mb-5">
                        <img src="img/blog/blog-two.jpg" class="img-fluid" alt="Blog Post Image">
                        <h2 class="mt-3">Blog title 2</h2>
                        <p class="text-muted">16/11/2024 by <a href="#">Author</a></p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus lacinia odio vitae vestibulum. 
                            Sed feugiat, nisl ut facilisis facilisis, est arcu consequat neque, a tempus neque ligula at lorem. 
                            Curabitur placerat sapien vel orci bibendum, at dignissim libero cursus.</p>
                        <a href="singleBlog.jsp" class="btn btn-primary">Read more</a>
                    </div>
                </div>
                <!-- Blog End -->

                <!-- Sidebar Start -->
                <div class="col-lg-4">
                    <h4 class="mb-4">New</h4>
                    <div class="list-group mb-5">
                        <a href="#" class="list-group-item-blog list-group-item-action d-flex">
                            <img src="img/blog/blog-one.jpg" class="img-thumbnail" style="width: 60px; height: 60px;" alt="Blog Post Image">
                            <div class="ml-3">
                                <h5>Blog Title 1</h5>
                                <p class="text-muted">16/11/2024</p>
                            </div>
                        </a>
                        <a href="#" class="list-group-item-blog list-group-item-action d-flex">
                            <img src="img/blog/blog-two.jpg" class="img-thumbnail" style="width: 60px; height: 60px;" alt="Blog Post Image">
                            <div class="ml-3">
                                <h5>Blog Title 2</h5>
                                <p class="text-muted">16/11/2024</p>
                            </div>
                        </a>
                        <a href="#" class="list-group-item-blog list-group-item-action d-flex">
                            <img src="img/blog/blog-three.jpg" class="img-thumbnail" style="width: 60px; height: 60px;" alt="Blog Post Image">
                            <div class="ml-3">
                                <h5>Blog Title 3</h5>
                                <p class="text-muted">16/11/2024</p>
                            </div>
                        </a>
                    </div>

                    <h4 class="mb-4">Danh mục</h4>
                    <div class="list-group mb-5">
                        <a href="#" class="list-group-item list-group-item-action d-flex">
                            <img src="img/carousel-1.jpg" class="img-thumbnail" style="width: 60px; height: 60px;" alt="Category Image">
                            <div class="ml-3">
                                <h5>Danh mục 1</h5>
                            </div>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action d-flex">
                            <img src="img/category/category-two.jpg" class="img-thumbnail" style="width: 60px; height: 60px;" alt="Category Image">
                            <div class="ml-3">
                                <h5>Danh mục 2</h5>
                            </div>
                        </a>
                        <a href="#" class="list-group-item list-group-item-action d-flex">
                            <img src="img/category/category-three.jpg" class="img-thumbnail" style="width: 60px; height: 60px;" alt="Category Image">
                            <div class="ml-3">
                                <h5>Danh mục 3</h5>
                            </div>
                        </a>
                    </div>
                </div>
                <!-- Sidebar End -->

            </div>
        </div>

        <!-- Blog End -->



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

