<%-- 
    Document   : changePassword
    Created on : Oct 5, 2024, 12:16:41 PM
    Author     : User
--%>

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
    </head>
    <body>
        <!-- Topbar Start -->
        <div class="container-fluid">
            <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
                <div class="col-lg-4">
                    <a href="home.jsp" class="text-decoration-none">
                        <span class="h1 text-uppercase text-primary bg-dark px-2">IS</span>
                        <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Perfume</span>
                    </a>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->

        <!-- Navbar End -->


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
                                        <label for="floatingInput">New Password</label>
                                        <input name="newPass" type="password" class="form-control" id="floatingInput"
                                               placeholder="" required="">
                                    </div>
                                    <div class="form-floating mb-3">
                                        <label for="floatingInput">Confirm password</label>
                                        <input name="confirmPass" type="password" class="form-control" id="floatingInput"
                                               placeholder="${requestScope.ERROR_CHANGE_FORGOT_PASSWORD.confirmPasswordError}" required="">
                                    </div>
                                    <input type="hidden" name="userID" value="${sessionScope.USERID}">
                                    <button type="submit" value="ChangePasswordForgot" name="action" class="btn btn-primary py-3 w-100 mb-4">Change Password</button>
                                    <p class="text-center mb-0">
                                        <a href="signin.jsp">Continue login</a> OR
                                        <a href="signup.jsp">Sign Up</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <!--Change password form End-->
    </body>
</html>
