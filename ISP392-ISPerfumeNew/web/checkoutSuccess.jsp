<%-- 
    Document   : checkoutSuccess
    Created on : Nov 7, 2024, 9:23:58 AM
    Author     : User
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Checkout Success</title>
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
        <div class="container-fluid pt-4 px-4">
            <div class="row bg-light rounded align-items-center justify-content-center mx-0 my-4 py-5 px-3">
                <div class="text-center">
                    <img src="img/success-icon-10-300x300.png" class="mb-3" alt="Success Icon" style="width: 100px; height: 100px;">
                    <h1 class="text-success mb-4">Order Successfully!</h1>
                    <form action="MainController" method="POST">
                        <input type="hidden" name="Email" value="${requestScope.EMAIL}">
                        <input type="hidden" name="Password" value="${requestScope.PASSWORD}">
                        <button type="submit" name="action" value="Sign In" class="btn btn-success text-uppercase px-4 py-2">
                            Continue Shopping
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
