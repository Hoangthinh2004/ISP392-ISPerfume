<%-- 
    Document   : orderHistory
    Created on : Oct 9, 2024, 1:17:58 PM
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
        <link href="css/styleOrderStatus.css" rel="stylesheet">    
        <style>
            .order-info {
                position: sticky;
                top: 0;
                z-index: 100;
                background: #fff;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            #order-info {
                display: none; /* Ẩn phần order info ban đầu */
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
                            <button type="button" class="btn btn-sm btn-light dropdown-toggle" data-toggle="dropdown">My Account</button>
                            <div class="dropdown-menu dropdown-menu-right">
                                <a class="dropdown-item btn" type="button" href="signin.jsp">Sign in</a>
                                <a class="dropdown-item btn" type="button" href="signup.jsp">Sign up</a>
                                <a class="dropdown-item btn" type="button" href="MainController?action=Signout">Sign out</a>                                
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
                    <form action="">
                        <div class="input-group">
                            <form action="MainController" method="POST">
                                <input type="text" class="form-control" placeholder="Search for products" name="search">
                                <div class="input-group-append">
                                    <span class="input-group-text bg-transparent text-primary" style="padding-bottom: 5px ">                                 
                                        <button name="action" value="Seacrh" type="submit" class="btn btn-block" style="padding: 0"><i class="fa fa-search"></i></button>
                                    </span>
                                </div>
                            </form>
                        </div>
                    </form>
                </div>
                <div class="col-lg-4 col-6 text-right">
                    <p class="m-0">Customer Service</p>
                    <h5 class="m-0">+012 345 6789</h5>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->
        <div class="container-fluid bg-dark mb-30">
            <div class="row px-xl-5">
                <div class="col-lg-3 d-none d-lg-block">
                    <a class="btn d-flex align-items-center justify-content-between bg-primary w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; padding: 0 30px;">
                        <h6 class="text-dark m-0"><i class="fa fa-bars mr-2"></i>Categories</h6>
                        <i class="fa fa-angle-down text-dark"></i>
                    </a>
                    <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
                        <div class="navbar-nav w-100">                         
                            <a href="" class="nav-item nav-link">Shirts</a>
                            <a href="" class="nav-item nav-link">Jeans</a>
                            <a href="" class="nav-item nav-link">Jackets</a>
                            <a href="" class="nav-item nav-link">Shoes</a>
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
                                <a href="home.jsp" class="nav-item nav-link">Home</a>
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
        <!-- Navbar End -->

        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="home.jsp">Home</a>
                        <span class="breadcrumb-item active">History</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <div class="container-fluid">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
                <span class="bg-secondary pr-3">History</span>
            </h2>
            <div class="row">
                <!-- Order List -->
                <div id="order-list" class="col-lg-12">
                    <div class="order-list">
                        <!-- Individual Order Item -->
                        <div class="order-item border p-4 mb-3 d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="product-image-1.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #123456</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 1</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-15 10:45 AM</p>
                                    <p class="mb-1"><strong>Total:</strong> $120.50</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-outline-primary" onclick="showOrderInfo('123456')">View Details</button>
                                </div>
                            </div>
                        </div>

                        <!-- Another Order Item -->
                        <div class="order-item border p-4 mb-3 d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="product-image-2.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #123457</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 2</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-12 02:30 PM</p>
                                    <p class="mb-1"><strong>Total:</strong> $85.00</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-outline-primary" onclick="showOrderInfo('123457')">View Details</button>
                                </div>
                            </div>
                        </div>
                        <div class="order-item border p-4 mb-3 d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="product-image-2.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #123457</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 2</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-12 02:30 PM</p>
                                    <p class="mb-1"><strong>Total:</strong> $85.00</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-outline-primary" onclick="showOrderInfo('123457')">View Details</button>
                                </div>
                            </div>
                        </div>
                        <div class="order-item border p-4 mb-3 d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="product-image-2.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #123457</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 2</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-12 02:30 PM</p>
                                    <p class="mb-1"><strong>Total:</strong> $85.00</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-outline-primary" onclick="showOrderInfo('123457')">View Details</button>
                                </div>
                            </div>
                        </div>
                        <div class="order-item border p-4 mb-3 d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="product-image-2.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #123457</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 2</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-12 02:30 PM</p>
                                    <p class="mb-1"><strong>Total:</strong> $85.00</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-outline-primary" onclick="showOrderInfo('123457')">View Details</button>
                                </div>
                            </div>
                        </div>
                        <div class="order-item border p-4 mb-3 d-flex flex-column">
                            <div class="d-flex justify-content-between align-items-start mb-3">
                                <div class="order-item-image">
                                    <img src="product-image-2.jpg" alt="Product Image" class="img-fluid" style="width: 80px; height: 80px; object-fit: cover;">
                                </div>
                                <div class="order-item-details flex-grow-1 mx-3">
                                    <h6 class="mb-1"><strong>Order #123457</strong></h6>
                                    <p class="mb-1"><strong>Product:</strong> Product 2</p>
                                    <p class="mb-1"><strong>Date:</strong> 2024-10-12 02:30 PM</p>
                                    <p class="mb-1"><strong>Total:</strong> $85.00</p>
                                </div>
                                <div class="text-right">
                                    <button class="btn btn-sm btn-outline-primary" onclick="showOrderInfo('123457')">View Details</button>
                                </div>
                            </div>
                        </div>

                        <!-- Add more order items as needed -->
                    </div>
                </div>

                <!-- Order Status and Order Info -->
                <div id="order-info" class="col-lg-7 fixed-info mt-4" style="display: none;">
                    <div class="order-status mb-4">
                        <section class="step-wizard">
                            <ul class="step-wizard-list">
                                <li class="step-wizard-item">
                                    <span class="progress-count">1</span>
                                    <span class="progress-label">Billing Info</span>
                                </li>
                                <li class="step-wizard-item">
                                    <span class="progress-count">2</span>
                                    <span class="progress-label">Payment Method</span>
                                </li>
                                <li class="step-wizard-item current-item">
                                    <span class="progress-count">3</span>
                                    <span class="progress-label">Checkout</span>
                                </li>
                                <li class="step-wizard-item">
                                    <span class="progress-count">4</span>
                                    <span class="progress-label">Success</span>
                                </li>
                            </ul>
                        </section>
                    </div>

                    <!-- Order Info -->
                    <div class="order-info border p-4">
                        <h4>Order #<span id="order-id">123456</span> Details</h4>
                        <p><strong>Date:</strong> <span id="order-date">2024-10-15 10:45 AM</span></p>
                        <p><strong>Status:</strong> <span id="order-status">Shipped</span></p>

                        <h5>Items in Order</h5>
                        <ul id="order-items">
                            <li>Product 1 - Quantity: 2 - Price: $50.00 each</li>
                            <li>Product 2 - Quantity: 1 - Price: $30.50</li>
                        </ul>
                        <p><strong>Total Price:</strong> <span id="total-price">$130.50</span></p>
                    </div>
                </div>
            </div>
        </div>

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
        <script>
                                        function showOrderInfo(orderId) {
                                            // Chỉ hiển thị order info cho đơn hàng đã chọn
                                            document.getElementById('order-info').style.display = 'block';
                                            document.getElementById('order-list').classList.remove('col-lg-12');
                                            document.getElementById('order-list').classList.add('col-lg-5');

                                            // Cập nhật thông tin cho order-info
                                            document.getElementById('order-id').textContent = orderId;

                                            // Bạn có thể thay đổi dữ liệu này dựa trên orderId
                                            if (orderId === '123456') {
                                                document.getElementById('order-date').textContent = '2024-10-15 10:45 AM';
                                                document.getElementById('order-status').textContent = 'Shipped';
                                                document.getElementById('order-items').innerHTML = `
                 <li>Product 1 - Quantity: 2 - Price: $50.00 each</li>
                 <li>Product 2 - Quantity: 1 - Price: $30.50</li>
             `;
                                                document.getElementById('total-price').textContent = '$130.50';
                                            } else if (orderId === '123457') {
                                                document.getElementById('order-date').textContent = '2024-10-12 02:30 PM';
                                                document.getElementById('order-status').textContent = 'Processing';
                                                document.getElementById('order-items').innerHTML = `
                 <li>Product 2 - Quantity: 1 - Price: $85.00 each</li>
             `;
                                                document.getElementById('total-price').textContent = '$85.00';
                                            }
                                        }
        </script>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>
</html>
