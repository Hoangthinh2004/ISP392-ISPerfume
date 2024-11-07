<%-- 
    Document   : forgetPassword
    Created on : Oct 5, 2024, 9:48:46 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Forgot Password</title>
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


        <!-- Logo Start -->
        <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex justify-content-center">
            <div class="col-lg-4 justify-content-center text-center">
                <a href="MainController?action=HomeController" class="text-decoration-none">
                    <span class="h1 text-uppercase text-primary bg-dark px-2">IS</span>
                    <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Perfume</span>
                </a>
            </div>
        </div>

        <!-- Logo End -->


        <!--Sigin in form Start-->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-lg-12 mb-5">
                    <div class="row h-100 align-items-center justify-content-center">
                        <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                            <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3" style="padding-bottom: 15px !important; width: 455px;">
                                <form action="MainController" method="get">
                                    <div class="d-flex align-items-center justify-content-between mb-3">
                                        <h3 class="text-primary"></i>Forgot Password</h3>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <label for="floatingInput">Email</label>
                                        <input type="email" class="form-control" id="floatingInput"
                                               placeholder="Enter your email" name="emailReset">
                                    </div>
                                    <button type="submit" class="btn btn-primary py-3 w-100 mb-4" name="action" value="ForgetPassword">Send OTP</button>
                                    <p class="text-left mb-0">Don't have an Account? <a href="signup.jsp">Sign Up</a></p>
                                    <p class="text-left mb-0">Do you already have an Account? <a href="signup.jsp">Sign In</a></p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Sigin in form End-->
        
        
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
