<%-- 
    Document   : signin
    Created on : Sep 28, 2024, 4:01:55 PM
    Author     : User
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPER FUME | Sign In</title>
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
            .alert {
                display: flex;
                align-items: center;
                padding: 15px 20px;
                font-size: 16px;
                max-width: 400px;
                position: fixed;
                top: 50px;
                right: 20px;
                z-index: 1050;
                border: 1px solid transparent;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                background-color: #f8d7da;
                border-color: #f5c6cb;
                color: #721c24;
            }

            .alert-icon {
                font-size: 1.5rem;
                color: #721c24; 
            }

            .alert-content {
                flex: 1;
                font-weight: 500;
                color: #721c24;
                margin: 0 10px; 
            }

            .btn-close {
                background: none;
                border: none;
                font-size: 1.2rem;
                color: #721c24; 
                transition: color 0.2s ease;
                cursor: pointer;
            }

            .btn-close:hover {
                color: #000;
            }

            .progress-bar-timer {
                border-radius: 24px;
                position: absolute;
                bottom: 0;
                left: 0;
                height: 5px;
                width: 100%;
                background-color: #721c24 !important;
                transition: width linear;
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
                        </div>
                    </div>
                </div>
            </div>          
        </div>
        <!-- Topbar End -->
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex justify-content-center">
            <div class="col-lg-4 justify-content-center text-center">
                <a href="MainController?action=HomeController" class="text-decoration-none">
                    <span class="h1 text-uppercase text-primary bg-dark px-2">IS</span>
                    <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Perfume</span>
                </a>
            </div>
        </div>
        <!-- Breadcrumb End -->
        <c:if test="${requestScope.ERROR_MESSAGE != null}">
        <div class="alert alert-danger alert-dismissible fade show fade-out d-flex align-items-center" role="alert" id="autoDismissAlert">
            <i class="fa fa-times-circle alert-icon me-2"></i> 
            <div class="alert-content">${requestScope.ERROR_MESSAGE}</div>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
                <i class="fa fa-times"></i>
            </button>
            <div class="progress-bar-timer bg-danger" id="progressBar" style="width: 100%;"></div>
        </div>
        </c:if>


        <!--Sigin in form Start-->
        <div class="container-fluid">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-2"><span class="bg-secondary pr-3">Sign
                    In</span></h2>
            <div class="row px-xl-5">
                <div class="col-lg-12 mb-5">
                    <div class="row h-100 align-items-center justify-content-center">
                        <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5 justify-content-center">
                            <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3 justify-content-center">
                                <div class="d-flex align-items-center justify-content-between mb-3">
                                    <a href="MainController?action=HomeController" class="">
                                        <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>ISPERFUME</h3>
                                    </a>
                                    <h3>Sign In</h3>
                                </div>
                                <form action="MainController" method="POST">
                                    <div class="form-floating mb-3">
                                        <label for="floatingInput">Email</label>
                                        <input type="text" class="form-control" placeholder="Email" name="Email" required="">
                                    </div>
                                    <div class="form-floating mb-4">
                                        <label for="floatingPassword">Password</label>
                                        <input type="password" class="form-control" placeholder="Password" name="Password" required="">
                                    </div>
                                    <div class="d-flex align-items-center justify-content-between mb-4">

                                        <a href="forgotPassword.jsp">Forgot Password</a>
                                    </div>
                                    <button type="submit" class="btn btn-primary py-3 w-100 mb-4" name="action" value="Sign In">Sign In</button>
                                    <!--                                    <div class="input-group-append">
                                                                            <button class="btn btn-primary" type="submit" name="action" value="Sign In">Sign In</button>
                                                                        </div>-->
                                </form>
                                <p class="text-center mb-4">Don't have an Account? <a href="signup.jsp">Sign Up</a></p>
                                <div class="d-flex align-items-center justify-content-center mb-4">
                                    <button class="button-signin text-center" style="width: 300px; height: 50px; display: flex; align-items: center; justify-content: center; gap: 10px;">
                                        <svg xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid" viewBox="0 0 256 262" class="svg" style="width: 24px; height: 24px;">
                                        <path fill="#4285F4" d="M255.878 133.451c0-10.734-.871-18.567-2.756-26.69H130.55v48.448h71.947c-1.45 12.04-9.283 30.172-26.69 42.356l-.244 1.622 38.755 30.023 2.685.268c24.659-22.774 38.875-56.282 38.875-96.027" class="blue"></path>
                                        <path fill="#34A853" d="M130.55 261.1c35.248 0 64.839-11.605 86.453-31.622l-41.196-31.913c-11.024 7.688-25.82 13.055-45.257 13.055-34.523 0-63.824-22.773-74.269-54.25l-1.531.13-40.298 31.187-.527 1.465C35.393 231.798 79.49 261.1 130.55 261.1" class="green"></path>
                                        <path fill="#FBBC05" d="M56.281 156.37c-2.756-8.123-4.351-16.827-4.351-25.82 0-8.994 1.595-17.697 4.206-25.82l-.073-1.73L15.26 71.312l-1.335.635C5.077 89.644 0 109.517 0 130.55s5.077 40.905 13.925 58.602l42.356-32.782" class="yellow"></path>
                                        <path fill="#EB4335" d="M130.55 50.479c24.514 0 41.05 10.589 50.479 19.438l36.844-35.974C195.245 12.91 165.798 0 130.55 0 79.49 0 35.393 29.301 13.925 71.947l42.211 32.783c10.59-31.477 39.891-54.251 74.414-54.251" class="red"></path>
                                        </svg>
                                        <span class="text">Sign in with Google</span>
                                    </button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!--Sigin in form End-->
        
        <!-- Footer Start -->
        <div class="container-fluid bg-dark text-secondary mt-5 pt-5">
            <div class="row px-xl-5 pt-5">
                <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                    <h5 class="text-secondary text-uppercase mb-4">Get In Touch</h5>
                    <p class="mb-4">Contact us for fast and friendly support. ISPerfume is here to help you find the perfect scent that speaks to your personality.</p>
                    <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Lô E2a-7, Đường D1, Đ. D1</p>
                    <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>isperfume1803@gmail.com</p>
                    <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>0384767323</p>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
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
