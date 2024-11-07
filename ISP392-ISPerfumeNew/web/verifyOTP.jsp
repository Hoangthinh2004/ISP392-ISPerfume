<%-- 
    Document   : changePassword
    Created on : Oct 5, 2024, 12:16:41 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | VerifyOTP</title>
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
                width: 100% ;
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

        <!--Pop-up End-->
        <c:if test="${not empty requestScope.ERROR_FORGOT_PASSWORD.tokenError}">
            <div class="alert alert-dismissible fade show fade-out d-flex align-items-center" role="alert" id="autoDismissAlert">
                <i class="fa fa-times-circle alert-icon me-2"></i> 
                <div class="alert-content">${requestScope.ERROR_FORGOT_PASSWORD.tokenError}</div>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">
                    <i class="fa fa-times"></i>
                </button>
                <div class="progress-bar-timer bg-danger" id="progressBar" style="width: 100%;"></div>
            </div>

        </c:if>

        <!--Pop-up End-->


        <!--Change passwword form Start-->
        <div class="container-fluid">
            <form action="MainController" method="get">
                <div class="row px-xl-5">
                    <div class="col-lg-12 mb-5">
                        <div class="row h-100 align-items-center justify-content-center">
                            <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                                <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3" style="padding-bottom: 15px !important; width: 455px;">
                                    <div class="d-flex align-items-center justify-content-between mb-3">
                                        <h3 class="text-primary"></i>Forgot Password</h3>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <label for="floatingInput">OTP confirm</label>
                                        <input name="otp" type="number" class="form-control input_field" id="floatingInput"
                                               placeholder="${requestScope.ERROR_FORGOT_PASSWORD.tokenError}" pattern="[0-9]{4}" min="1000" max="9999">
                                    </div>
                                    <button type="submit" value="VerifyOTP" name="action" class="btn btn-primary py-3 w-100 mb-4">Reset Password</button>
                                    <p class="text-center mb-0">
                                        <a href="">Continue login</a> OR
                                        <a href="">Login Again</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!--Change password form End-->
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
