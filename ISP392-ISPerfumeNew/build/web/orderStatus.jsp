<%-- 
    Document   : orderStatus
    Created on : Sep 28, 2024, 8:18:28 PM
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
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">
        <link href="css/styleOrderStatus.css" rel="stylesheet">
        <style>
            /* General Modal Styling */
            .modal-content {
                border-radius: 10px; /* Rounded corners for a smooth look */
                box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2); /* Soft shadow for depth */
                background-color: #f8f9fa; /* Light grey background */
                padding: 20px; /* Internal padding for content */
            }

            /* Modal Header */
            .modal-header {
                border-bottom: 1px solid #e9ecef; /* Subtle border between header and body */
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
                color: #dc3545; /* Red on hover */
            }

            .modal-body {
                padding-top: 10px;
            }

            /* Product List Styling */
            h6 {
                font-size: 1.2rem;
                font-weight: bold;
                margin-top: 15px;
                margin-bottom: 10px;
                color: #343a40;
            }

            /* Styling for the product list */
            .product-list {
                list-style: none; /* Remove bullet points */
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
                        <a class="text-body mr-3" href="">Contact</a>
                        <a class="text-body mr-3" href="">Help</a>
                        <a class="text-body mr-3" href="">FAQs</a>
                    </div>
                </div>
                <div class="col-lg-6 text-center text-lg-right">
                    <div class="d-inline-flex align-items-center">
                        <div class="btn-group">

                            <div class="dropdown-menu dropdown-menu-right">
                                <c:if test="${sessionScope.CUSTOMER.name == null}">
                                    <a class="dropdown-item btn" type="button" href="signin.jsp">Sign in</a>
                                    <a class="dropdown-item btn" type="button" href="signup.jsp">Sign up</a>
                                </c:if>
                                <c:if test="${sessionScope.CUSTOMER.name != null}">
                                    <a class="dropdown-item btn" type="button" href="MainController?action=Sign out">Sign out</a>
                                    <a class="dropdown-item btn" type="button" href="profile.jsp">Profile</a>
                                </c:if>
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
                                    <a href="blog.jsp" class="nav-item nav-link">Blog</a>
                                    <a href="orderStatus.jsp" class="nav-item nav-link active">Order Status</a>
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

        <div class="container-fluid mb-30">
            <div class="order-status">
                <!-- Order Status Start -->
                <section class="step-wizard">
                    <ul class="step-wizard-list">
                        <li class="step-wizard-item" data-status="1">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-hourglass-half"></i>
                                    <span class="order-count">15</span>
                                </span>
                                <span class="progress-label">Waiting for confirmation</span>
                            </a>
                        </li>
                        <li class="step-wizard-item" data-status="2">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-box"></i>
                                    <span class="order-count">10</span>
                                </span>
                                <span class="progress-label">Waiting for pickup</span>
                            </a>
                        </li>
                        <li class="step-wizard-item" data-status="3">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-truck"></i>
                                    <span class="order-count">8</span>
                                </span>
                                <span class="progress-label">Waiting for delivery</span>
                            </a>
                        </li>
                        <li class="step-wizard-item" data-status="4">
                            <a href="#">
                                <span class="progress-count">
                                    <i class="fa fa-clipboard-check"></i>
                                    <span class="order-count">20</span>
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
                        <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="img/product-1.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #123456</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 1</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-15 10:45 AM</p>
                                    <p class="mb-1"><strong>Total:</strong> $120.50</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-primary" data-bs-toggle="modal" data-bs-target="#orderDetailsModal-123456">View Details</button>
                                </div>
                            </div>
                        </div>

                        <!-- Modal for Order Details -->
                        <div class="modal fade" id="orderDetailsModal-123456" tabindex="-1" aria-labelledby="orderDetailsLabel-123456" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="orderDetailsLabel-123456">Order #123456 Details</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"><i class="fa fa-times"></i></button>
                                    </div>
                                    <div class="modal-body">
                                        <p><strong>Order ID:</strong> 123456</p>

                                        <h6><strong>Products:</strong></h6>
                                        <ul class="product-list">
                                            <li>
                                                <p><strong>Product Name:</strong> Product 1</p>
                                                <p><strong>Quantity:</strong> 2</p>
                                                <p><strong>Price:</strong> $60.25</p>
                                            </li>
                                            <li>
                                                <p><strong>Product Name:</strong> Product 2</p>
                                                <p><strong>Quantity:</strong> 1</p>
                                                <p><strong>Price:</strong> $45.00</p>
                                            </li>
                                        </ul>

                                        <p><strong>Shipper:</strong> Fast Shipping Inc.</p>
                                        <p><strong>Order Date:</strong> 2024-10-15 10:45 AM</p>
                                        <p><strong>Shipping Address:</strong> 123 Main Street, City, Country</p>

                                        <!-- Add classes for specific fields -->
                                        <p class="promotion"><strong>Promotion:</strong> 10% off (Promo Code: SAVE10)</p>
                                        <p class="total"><strong>Total:</strong> $135.25</p>

                                        <p><strong>Status:</strong> Shipped</p>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Order List Status 2 -->
                    <div class="order-list" id="order-list-2" style="display: none;">

                        <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="img/product-2.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #654321</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 2</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-16 12:30 PM</p>
                                    <p class="mb-1"><strong>Total:</strong> $150.00</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-primary">View Details</button>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- Order List Status 3 -->
                    <div class="order-list" id="order-list-3" style="display: none;">

                        <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="img/product-3.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #987654</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 3</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-17 09:00 AM</p>
                                    <p class="mb-1"><strong>Total:</strong> $75.25</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-primary">View Details</button>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- Order List Status 4 -->
                    <div class="order-list" id="order-list-4" style="display: none;">
                        <div class="order-item border p-4 mb-3 d-flex flex-column bg-light">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="img/product-4.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #246810</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 4</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-18 02:15 PM</p>
                                    <p class="mb-1"><strong>Total:</strong> $220.75</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-primary">View Details</button>
                                </div>
                            </div>
                        </div>
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
