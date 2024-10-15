<%-- 
    Document   : cart
    Created on : Sep 26, 2024, 3:39:52 PM
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
        <style>
            /* CSS Pop-up */
            /* Center the card in the middle of the screen */
            .card {
                width: 300px;
                height: fit-content;
                background: rgb(255, 255, 255);
                border-radius: 10px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                gap: 20px;
                padding: 30px;
                position: fixed;
                /* Changed from relative to fixed */
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                box-shadow: 20px 20px 30px rgba(0, 0, 0, 0.1);
                z-index: 1001;
            }

            /* Optional: Add a semi-transparent background overlay behind the modal */
            .modal-overlay {
                position: fixed;
                top: 0;
                left: 0;
                width: 100vw;
                height: 100vh;
                background: rgba(0, 0, 0, 0.5);
                /* Semi-transparent black */
                z-index: 1000;
                /* Below the modal itself */
            }

            /* Existing styles for the content */
            .card-content {
                width: 100%;
                height: fit-content;
                display: flex;
                flex-direction: column;
                gap: 5px;
            }

            .card-heading {
                font-size: 20px;
                font-weight: 700;
                color: rgb(27, 27, 27);
            }

            .card-description {
                font-weight: 100;
                color: rgb(102, 102, 102);
            }

            .card-button-wrapper {
                width: 100%;
                display: flex;
                align-items: center;
                justify-content: center;
                gap: 10px;
            }

            .card-button {
                width: 50%;
                height: 35px;
                border-radius: 5px;
                border: none;
                cursor: pointer;
                font-weight: 600;
            }

            .primary {
                background-color: rgb(255, 114, 109);
                color: white;
            }

            .primary:hover {
                background-color: rgb(255, 73, 66);
            }

            .secondary {
                background-color: #ddd;
            }

            .secondary:hover {
                background-color: rgb(197, 197, 197);
            }

            .exit-button {
                display: flex;
                align-items: center;
                justify-content: center;
                border: none;
                background-color: transparent;
                position: absolute;
                top: 20px;
                right: 20px;
                cursor: pointer;
            }

            .exit-button:hover svg {
                fill: black;
            }

            .exit-button svg {
                fill: rgb(175, 175, 175);
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
                                        <a href="#" class="nav-link dropdown-toggle active" data-toggle="dropdown">Pages <i class="fa fa-angle-down mt-1"></i></a>
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
        </form>
        <!-- Navbar End -->


        <!-- Breadcrumb Start -->
        <div class="container-fluid">
            <div class="row px-xl-5">
                <div class="col-12">
                    <nav class="breadcrumb bg-light mb-30">
                        <a class="breadcrumb-item text-dark" href="#">Home</a>
                        <a class="breadcrumb-item text-dark" href="#">Shop</a>
                        <span class="breadcrumb-item">Shopping Cart</span>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->


        <!-- Cart Start -->
        <!--Pop-up start-->
        <div id="modalOverlay" class="modal-overlay" style="display: none;">
            <div id="deleteConfirmation" class="card">
                <div class="card-content">
                    <p class="card-heading">Delete Product</p>
                    <p class="card-description">Are you sure you want to delete this product?</p>
                </div>
                <div class="card-button-wrapper">
                    <button class="card-button secondary" onclick="cancelDelete()">Cancel</button>
                    <button class="card-button primary" onclick="proceedDelete()">Delete</button>
                </div>
                <button class="exit-button" onclick="cancelDelete()">
                    <svg height="20px" viewBox="0 0 384 512">
                    <path
                        d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z">
                    </path>
                    </svg>
                </button>
            </div>
        </div>
        <!--Pop-up End-->
        <form action="MainController">
            <div class="container-fluid">
                <div class="row px-xl-5">

                    <div class="col-lg-8 table-responsive mb-5">
                        <table class="table table-light table-borderless table-hover text-center mb-0">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">                      
                                <tr>
                                    <td class="align-middle">
                                        <img src="img/product-2.jpg" alt="" style="width: 50px;"> Product Name
                                    </td>
                                    <td class="align-middle price">
                                        <span class="currency">$</span><span class="amount">12</span>
                                    </td>
                                    <td class="align-middle">
                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-minus"
                                                        onclick="updateQuantity(this, -1, event)">
                                                    <i class="fa fa-minus"></i>
                                                </button>
                                            </div>
                                            <input type="text" readonly
                                                   class="form-control form-control-sm bg-secondary border-0 text-center quantity-input"
                                                   value="1">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-plus"
                                                        onclick="updateQuantity(this, 1, event)">
                                                    <i class="fa fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle total">
                                        <span class="currency">$</span><span class="amount">12</span>
                                    </td>
                                    <td class="align-middle">
                                        <button class="btn btn-sm btn-danger" onclick="openDeleteModal(this, event)">
                                            <i class="fa fa-times"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-middle">
                                        <img src="img/product-2.jpg" alt="" style="width: 50px;"> Product Name
                                    </td>
                                    <td class="align-middle price">
                                        <span class="currency">$</span><span class="amount">11</span>
                                    </td>
                                    <td class="align-middle">
                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-minus"
                                                        onclick="updateQuantity(this, -1, event)">
                                                    <i class="fa fa-minus"></i>
                                                </button>
                                            </div>
                                            <input type="text" readonly
                                                   class="form-control form-control-sm bg-secondary border-0 text-center quantity-input"
                                                   value="1">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-plus"
                                                        onclick="updateQuantity(this, 1, event)">
                                                    <i class="fa fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle total">
                                        <span class="currency">$</span><span class="amount">11</span>
                                    </td>
                                    <td class="align-middle">
                                        <button class="btn btn-sm btn-danger" onclick="openDeleteModal(this, event)">
                                            <i class="fa fa-times"></i>
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="align-middle">
                                        <img src="img/product-3.jpg" alt="" style="width: 50px;"> Product Name
                                    </td>
                                    <td class="align-middle price">
                                        <span class="currency">$</span><span class="amount">30</span>
                                    </td>
                                    <td class="align-middle">
                                        <div class="input-group quantity mx-auto" style="width: 100px;">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-minus"
                                                        onclick="updateQuantity(this, -1, event)">
                                                    <i class="fa fa-minus"></i>
                                                </button>
                                            </div>
                                            <input type="text" readonly
                                                   class="form-control form-control-sm bg-secondary border-0 text-center quantity-input"
                                                   value="1">
                                            <div class="input-group-btn">
                                                <button class="btn btn-sm btn-primary btn-plus"
                                                        onclick="updateQuantity(this, 1, event)">
                                                    <i class="fa fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle total">
                                        <span class="currency">$</span><span class="amount">30</span>
                                    </td>
                                    <td class="align-middle">
                                        <button class="btn btn-sm btn-danger" onclick="openDeleteModal(this, event)">
                                            <i class="fa fa-times"></i>
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-4">
                        <h5 class="section-title position-relative text-uppercase mb-3"><span class="bg-secondary pr-3">Cart
                                Summary</span></h5>
                        <div class="bg-light p-30 mb-5">
                            <div class="border-bottom pb-2">
                                <div class="d-flex justify-content-between mb-3">
                                    <h6>Subtotal</h6>
                                    <h6>
                                        <span>$</span>
                                        <span id="subtotal">72</span>
                                    </h6>

                                </div>
                                <div class="d-flex justify-content-between">
                                    <h6 class="font-weight-medium">Shipping</h6>
                                    <h6 class="font-weight-medium">$10</h6>
                                </div>
                            </div>
                            <div class="pt-2">
                                <div class="d-flex justify-content-between mt-2">
                                    <h5>Total</h5>
                                    <h5 >
                                        <span>$</span>
                                        <span id="total-cart">82</span>
                                    </h5> 
                                </div>
                                <button  type="submit" class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed To
                                    Checkout</button>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </form>
        <!-- Cart End -->


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
        <script>
                                            window.onload = function () {
                                                updateCartTotal();
                                                updateAllProductTotals();
                                            };

                                            function updateQuantity(button, change, event) {
                                                event.preventDefault();

                                                const row = button.closest('tr');
                                                const quantityInput = row.querySelector('.quantity-input');
                                                const priceText = row.querySelector('.amount').innerText;

                                                const price = parseFloat(priceText);

                                                let quantity = parseInt(quantityInput.value) + change;
                                                if (quantity < 1) {
                                                    quantity = 1;
                                                }
                                                quantityInput.value = quantity;
                                                const total = (quantity * price).toFixed();
                                                row.querySelector('.total .amount').innerText = total;
                                                updateCartTotal();
                                            }

                                            function removeProduct(button, event) {
                                                event.preventDefault();

                                                const row = button.closest('tr');
                                                row.remove();

                                                updateCartTotal();
                                            }

                                            function updateCartTotal() {
                                                const totals = document.querySelectorAll('.total .amount');
                                                let subtotal = 0;
                                                totals.forEach((total) => {
                                                    subtotal += parseFloat(total.innerText);
                                                });

                                                document.getElementById('subtotal').innerText = subtotal.toFixed();

                                                const shipping = 10;
                                                const totalCart = subtotal + shipping;
                                                document.getElementById('total-cart').innerText = totalCart.toFixed();
                                            }

                                            function updateAllProductTotals() {
                                                const rows = document.querySelectorAll('tr');
                                                rows.forEach((row) => {
                                                    const quantityInput = row.querySelector('.quantity-input');
                                                    const priceText = row.querySelector('.amount') ? row.querySelector('.amount').innerText : null;

                                                    if (quantityInput && priceText) {
                                                        const price = parseFloat(priceText);
                                                        const quantity = parseInt(quantityInput.value);
                                                        const total = (quantity * price).toFixed();
                                                        row.querySelector('.total .amount').innerText = total;
                                                    }
                                                });
                                            }
                                            function openDeleteModal(button, event) {
                                                event.preventDefault();
                                                deleteButtonRef = button; // Store the reference to the delete button

                                                // Show the modal
                                                document.getElementById('deleteConfirmation').style.display = 'block';
                                                document.getElementById('modalOverlay').style.display = 'block';
                                            }

                                            function cancelDelete() {
                                                // Hide the modal and overlay
                                                document.getElementById('deleteConfirmation').style.display = 'none';
                                                document.getElementById('modalOverlay').style.display = 'none';
                                            }

                                            function proceedDelete() {
                                                if (deleteButtonRef) {
                                                    // Pass the stored button to removeProduct
                                                    removeProduct(deleteButtonRef, event);
                                                }

                                                // Hide modal and overlay after action
                                                document.getElementById('deleteConfirmation').style.display = 'none';
                                                document.getElementById('modalOverlay').style.display = 'none';
                                            }


        </script>


    </body>
</html>
