<%-- 
    Document   : orderStatus
    Created on : Sep 28, 2024, 8:18:28 PM
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
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">
        <link href="css/styleOrderStatus.css" rel="stylesheet">
        <style>
            /* General Modal Styling */
            .modal-content {
                border-radius: 10px; 
                box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2); 
                background-color: #f8f9fa; /* Light grey background */
                padding: 20px; /* Internal padding for content */
            }

            .modal-header {
                border-bottom: 1px solid #e9ecef; 
                padding-bottom: 15px;
            }

            .modal-title {
                font-size: 1.5rem;
                font-weight: bold;
                color: #343a40; /* Dark grey text */
            }

            /* Close Button Styling */
            .btn-close {
                background: none;
                border: none;
                font-size: 1.2rem;
                color: #6c757d; /* Grey for icon */
                transition: color 0.2s ease;
            }

            .btn-close:hover {
                color: #dc3545; 
            }

            .modal-body {
                padding-top: 10px;
            }

            h6 {
                font-size: 1.2rem;
                font-weight: bold;
                margin-top: 15px;
                margin-bottom: 10px;
                color: #343a40;
            }

            /* Styling for the product list */
            .product-list {
                list-style: none; 
                padding: 0;
                margin-bottom: 20px; /* Spacing at the bottom */
            }

            .product-list li {
                margin-bottom: 15px; /* Spacing between products */
                padding-bottom: 10px;
                border-bottom: 1px solid #e9ecef; /* Light border between products */
            }

            .product-list p {
                margin: 5px 0;
                font-size: 1rem;
            }

            .product-list p strong {
                color: #495057; /* Medium dark grey */
            }

            /* Promotion and Total Styling */
            .promotion {
                color: #28a745; /* Green for promotion */
                font-size: 1.1rem;
                font-weight: bold;
            }

            .total {
                color: #007bff; /* Primary blue for total */
                font-size: 1.1rem;
                font-weight: bold;
            }

            /* Modal Footer */
            .modal-footer {
                border-top: 1px solid #e9ecef; /* Subtle border */
                padding-top: 10px;
                justify-content: center; /* Center the footer content */
            }

            /* Buttons */
            .btn-secondary {
                background-color: #6c757d; /* Bootstrap secondary color */
                border: none;
                color: white;
                padding: 10px 20px; /* Larger padding for more clickable area */
                font-size: 1rem;
                border-radius: 5px;
                transition: background-color 0.3s ease, transform 0.3s ease;
            }

            .btn-secondary:hover {
                background-color: #5a6268; /* Darker on hover */
            }

            /* Primary Button Styling */
            .btn-primary {
                background-color: orange;
                color: white;
                padding: 10px 20px;
                font-size: 1.05rem;
                font-weight: bold;
                border-radius: 6px;
                transition: background-color 0.3s ease, transform 0.3s ease;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }



            .btn-primary:active {
                background-color: #004494;
                border-color: #004494;
                transform: translateY(0);
                box-shadow: 0 3px 5px rgba(0, 0, 0, 0.1);
            }

            /* Responsive Design */
            @media (max-width: 576px) {
                .modal-content {
                    padding: 15px;
                }

                .modal-title {
                    font-size: 1.2rem;
                }

                .modal-body p {
                    font-size: 0.9rem;
                }


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
                                <a href="MainController?action=NavigateBlog" class="nav-item nav-link active">Blog</a>
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

        <div class="container-fluid mb-30">
            <div class="order-status">
                <!-- Order Status Start -->
                <section class="step-wizard">
                    <ul class="step-wizard-list">
                        <li class="step-wizard-item" data-status="1">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-hourglass-half"></i>
                                    <span class="order-count">${sessionScope.QUANTITY_STATUS_1}</span>
                                </span>
                                <span class="progress-label">Waiting for confirmation</span>
                            </a>
                        </li>
                        <li class="step-wizard-item" data-status="2">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-box"></i>
                                    <span class="order-count">${sessionScope.QUANTITY_STATUS_2}</span>
                                </span>
                                <span class="progress-label">Waiting for pickup</span>
                            </a>
                        </li>
                        <li class="step-wizard-item" data-status="3">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-truck"></i>
                                    <span class="order-count">${sessionScope.QUANTITY_STATUS_3}</span>
                                </span>
                                <span class="progress-label">Waiting for delivery</span>
                            </a>
                        </li>
                        <li class="step-wizard-item" data-status="4">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-clipboard-check"></i>
                                    <span class="order-count">${sessionScope.QUANTITY_STATUS_4}</span>
                                </span>
                                <span class="progress-label">Delivered successfully</span>
                            </a>
                        </li>
                    </ul>

                </section>
                <!-- Order Status End -->
            </div>
        </div>

        <!-- Order Lists for Each Status -->
        <div class="container-fluid">
            <div class="row">
                <div id="order-lists" class="col-lg-12">

                    <!-- Order List Status 1 -->
                    <div class="order-list" id="order-list-1" style="display: none;">
                        <c:forEach var="order" items="${sessionScope.ORDER_STATUS_1}">
                            <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                                <div class="d-flex justify-content-between align-items-start mb-3">
                                    <div class="order-item-image">
                                        <img src="https://cdn-icons-png.flaticon.com/256/4990/4990422.png" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                    </div>
                                    <div class="order-item-details flex-grow-1 mx-3">
                                        <h6 class="mb-1"><strong>Order #${order.orderID}</strong></h6>
                                        <p class="mb-1"><strong>Date:</strong> ${order.orderDate}</p>
                                        <p class="mb-1"><strong>Recipient phone number</strong> ${order.phone}</p>
                                        <c:forEach var="user" items="${sessionScope.LIST_USER}">
                                            <c:if test="${order.shipperID == user.userID}">
                                                <p class="mb-1"><strong>Shipper name: </strong> ${user.name}</p>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="text-right">
                                        <form action="MainController">
                                            <input type="hidden" name="orderID" value="${order.orderID}">
                                            <button  type="submit" name="action" value="viewOrderDetail"class="btn btn-sm btn-primary" data-bs-toggle="modal">View Details</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <!-- Order List Status 2 -->
                    <div class="order-list" id="order-list-2" style="display: none;">

                        <c:forEach var="order" items="${sessionScope.ORDER_STATUS_2}">
                            <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                                <div class="d-flex justify-content-between align-items-start mb-3">
                                    <div class="order-item-image">
                                        <img src="https://cdn-icons-png.flaticon.com/256/17959/17959498.png" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                    </div>
                                    <div class="order-item-details flex-grow-1 mx-3">
                                        <h6 class="mb-1"><strong>Order #${order.orderID}</strong></h6>
                                        <p class="mb-1"><strong>Date:</strong> ${order.orderDate}</p>
                                        <p class="mb-1"><strong>Recipient phone number</strong> ${order.phone}</p>
                                        <c:forEach var="user" items="${sessionScope.LIST_USER}">
                                            <c:if test="${order.shipperID == user.userID}">
                                                <p class="mb-1"><strong>Shipper name: </strong> ${user.name}</p>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="text-right">
                                        <form action="MainController">
                                            <input type="hidden" name="orderID" value="${order.orderID}">
                                            <button  type="submit" name="action" value="viewOrderDetail"class="btn btn-sm btn-primary" data-bs-toggle="modal">View Details</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>

                    <!-- Order List Status 3 -->
                    <div class="order-list" id="order-list-3" style="display: none;">
                        <c:forEach var="order" items="${sessionScope.ORDER_STATUS_3}">
                            <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                                <div class="d-flex justify-content-between align-items-start mb-3">
                                    <div class="order-item-image">
                                        <img src="https://cdn-icons-png.flaticon.com/256/14306/14306803.png" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                    </div>
                                    <div class="order-item-details flex-grow-1 mx-3">
                                        <h6 class="mb-1"><strong>Order #${order.orderID}</strong></h6>
                                        <p class="mb-1"><strong>Date:</strong> ${order.orderDate}</p>
                                        <p class="mb-1"><strong>Recipient phone number</strong> ${order.phone}</p>
                                        <c:forEach var="user" items="${sessionScope.LIST_USER}">
                                            <c:if test="${order.shipperID == user.userID}">
                                                <p class="mb-1"><strong>Shipper name: </strong> ${user.name}</p>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="text-right">
                                        <form action="MainController">
                                            <input type="hidden" name="orderID" value="${order.orderID}">
                                            <button  type="submit" name="action" value="viewOrderDetail"class="btn btn-sm btn-primary" data-bs-toggle="modal">View Details</button>
                                        </form>                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- Order List Status 4 -->
                    <div class="order-list" id="order-list-4" style="display: none;">
                        <c:forEach var="order" items="${sessionScope.ORDER_STATUS_4}">
                            <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                                <div class="d-flex justify-content-between align-items-start mb-3">
                                    <div class="order-item-image">
                                        <img src="https://cdn-icons-png.flaticon.com/256/9403/9403187.png" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                    </div>
                                    <div class="order-item-details flex-grow-1 mx-3">
                                        <h6 class="mb-1"><strong>Order #${order.orderID}</strong></h6>
                                        <p class="mb-1"><strong>Date:</strong> ${order.orderDate}</p>
                                        <p class="mb-1"><strong>Recipient phone number</strong> ${order.phone}</p>
                                        <c:forEach var="user" items="${sessionScope.LIST_USER}">
                                            <c:if test="${order.shipperID == user.userID}">
                                                <p class="mb-1"><strong>Shipper name: </strong> ${user.name}</p>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="text-right">
                                        <form action="MainController">
                                            <input type="hidden" name="orderID" value="${order.orderID}">
                                            <button  type="submit" name="action" value="viewOrderDetail"class="btn btn-sm btn-primary" data-bs-toggle="modal">View Details</button>
                                        </form> 
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </div>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                document.querySelectorAll('.step-wizard-item a').forEach(function (link) {
                    link.addEventListener('click', function (event) {
                        event.preventDefault();
                        const currentItem = this.closest('.step-wizard-item');
                        const status = currentItem.getAttribute('data-status');
                        const allItems = document.querySelectorAll('.step-wizard-item');
                        allItems.forEach((item, index) => {
                            item.classList.remove('completed');
                            item.classList.remove('current-item');
                            const icon = item.querySelector('.progress-count i');
                            icon.classList.remove('fa-check-circle');
                            if (index === 0) {
                                icon.classList.add('fa-hourglass-half');
                            } else if (index === 1) {
                                icon.classList.add('fa-box');
                            } else if (index === 2) {
                                icon.classList.add('fa-truck');
                            } else if (index === 3) {
                                icon.classList.add('fa-clipboard-check');
                            }
                        });

                        allItems.forEach((item, index) => {
                            if (index < Array.from(allItems).indexOf(currentItem)) {
                                item.classList.add('completed');
                                const icon = item.querySelector('.progress-count i');
                                icon.classList.remove('fa-hourglass-half', 'fa-box', 'fa-truck', 'fa-clipboard-check');
                                icon.classList.add('fa-check-circle');
                            }
                        });

                        currentItem.classList.add('current-item');

                        // Hiển thị danh sách đơn hàng tương ứng
                        document.querySelectorAll('.order-list').forEach(orderList => {
                            orderList.style.display = 'none';
                        });

                        const selectedOrderList = document.querySelector(`#order-list-` + status);
                        if (selectedOrderList) {
                            selectedOrderList.style.display = 'block';
                        }
                    });
                });
            });
        </script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
