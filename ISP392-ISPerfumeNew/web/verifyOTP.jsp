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
                color: #721c24; /* Màu đỏ cho icon lỗi */
            }

            .alert-content {
                flex: 1;
                font-weight: 500;
                color: #721c24;
                margin: 0 10px; /* Giãn cách nội dung */
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
                                        <input name="otp" type="number" class="form-control" id="floatingInput"
                                               placeholder="${requestScope.ERROR_FORGOT_PASSWORD.tokenError}" pattern="[0-9]{4}" min="1000" max="9999">
                                    </div>
                                    <button type="submit" value="VerifyOTP" name="action" class="btn btn-primary py-3 w-100 mb-4">Reset Password</button>
                                    <p class="text-center mb-0">
                                        <a href="signup.jsp">Sign Up</a> OR
                                        <a href="signin.jsp">Login Again</a>
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
                    }, 10); // Đợi một chút trước khi áp dụng transition
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
