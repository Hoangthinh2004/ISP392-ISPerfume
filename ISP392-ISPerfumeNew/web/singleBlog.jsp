<%-- 
    Document   : singleBlog
    Created on : Oct 16, 2024, 2:43:34 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .blog-post {
                background-color: #fff;
                border-radius: 8px; 
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
                padding: 20px; 
            }

            img {
                border-radius: 8px; 
            }

            .blog-post p {
                margin-bottom: 15px;
            }

            blockquote {
                padding: 15px;
                background-color: #e9ecef;
                border-left: 5px solid #007bff;
                margin-bottom: 30px;
            }
            .sidebar .list-group-item {
                border-radius: 8px;
                margin-bottom: 10px;
                transition: background-color 0.3s ease;
            }

            .sidebar .list-group-item:hover {
                background-color: #f1f1f1;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            /* Sidebar Title Styling */
            .sidebar-title {
                font-size: 18px;
                font-weight: 600;
                color: #343a40;
                border-bottom: 2px solid orange;
                padding-bottom: 10px;
                margin-bottom: 15px;
            }


            .recent-post img {
                border-radius: 5px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            .recent-post .post-title {
                font-size: 16px;
                font-weight: 500;
                color: #007bff;
            }

            .recent-post:hover .post-title {
                color: #0056b3;
                text-decoration: none;
            }

            .list-group-item {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 15px;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .list-group-item:hover {
                background-color: #f8f9fa;
            }


            .tag-cloud {
                padding: 15px;
                background-color: transparent;
                border-radius: 10px; /* Bo góc cho khối tag cloud */

            }

            .tags {
                display: flex;
                flex-wrap: wrap; 
                gap: 10px; 
            }

            .tag-item {
                font-size: 14px;
                color: orange;
                background-color: white;
                padding: 8px 15px;
                border-radius: 10px;
                text-decoration: none;
                transition: background-color 0.3s ease, color 0.3s ease; 
            }

            .tag-item:hover {
                background-color: orange; 
                color: #fff; 
            }

        </style>
    </head>
    <body>
        <!-- Topbar Start -->
        
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
                                        <a href="MainController?action=Category&CategoryID=${Category.categoryID}" class="nav-link dropdown-toggle" data-toggle="dropdown">${Category.name}</a>
                                        <div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
                                            <a href="MainController?action=Category&CategoryID=${Category.categoryID}" class="dropdown-item ${Category == param.Category ? "active" : ""}">All ${Category.name}</a>
                                            <c:forEach var="brand" items="${sessionScope.LIST_BRAND_BY_CATE}">
                                                <c:if test="${Category.categoryID == brand.categoryID}">
                                                    <a href="MainController?action=Category&CategoryID=${Category.categoryID}&brandID=${brand.brandID}" class="dropdown-item">${brand.brandName}</a>
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
                        <span class="breadcrumb-item active">Blog</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->

        <!-- Blog Posts -->
        <div class="container p-0">
            <div class="row">
                <div class="col-lg-8">
                    <div class="blog-post">
                        <img src="${requestScope.BLOG_DETAIL.image}" alt="Blog Post Image" class="img-fluid">
                        <h2 class="mt-4">${requestScope.BLOG_DETAIL.title}</h2>
                        <p class="text-muted">${requestScope.BLOG_DETAIL.createDate} by <a href="#"> ${requestScope.BLOG_DETAIL.staffID}</a></p>
                        <p>${requestScope.BLOG_DETAIL.description}</p>
                        <div class="back-to-blog">
                            <a href="MainController?action=NavigateBlog" class="btn btn-primary">Back to Blog</a>
                        </div>
                    </div>
                </div>
                <!-- Blog Content End -->

                <!-- Sidebar Start -->
                <div class="col-lg-4 sidebar">
                    <!-- Recent Posts Section -->
                    <div class="recent-posts mb-5">
                        <h4 class="sidebar-title mb-4">New Posts</h4>
                        <c:forEach var="blog" items="${requestScope.BLOG_RECENT_LIST}" >
                            <div class="list-group mb-5">
                                <a href="MainController?action=ViewBlogDetail&blogID=${blog.blogID}" class="list-group-item-blog list-group-item-action d-flex">
                                    <img src="${blog.image}" class="img-thumbnail" style="width: 60px; height: 60px;" alt="Blog Post Image">
                                    <div class="ml-3">
                                        <h5>${blog.title}</h5>
                                        <p class="text-muted">${blog.createDate}</p>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
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
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Lô E2a-7, Đường D1, Đ. D1</p>
                    <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>isperfume1803@gmail.com</p>
                    <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>0384767323</p>
                </div>
            </div>
            <div class="row border-top mx-xl-5 py-4" style="border-color: rgba(256, 256, 256, .1) !important;">
                <div class="col-md-6 px-xl-0">
                    <p class="mb-md-0 text-center text-md-left text-secondary">
                        <a class="text-primary" href="">ISPerfume</a>
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
