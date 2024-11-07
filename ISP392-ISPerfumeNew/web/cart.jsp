<%-- 
    Document   : cart
    Created on : Sep 26, 2024, 3:39:52 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>ISPERFUME | Cart</title>
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
            input[type="checkbox"] {
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                width: 16px;
                height: 16px;
                border: 2px solid #ccc;
                border-radius: 3px;
                position: relative;
            }

            input[type="checkbox"]:checked {
                background-color: orange;
                border-color: orange;
            }

            input[type="checkbox"]:checked::after {
                content: "";
                position: absolute;
                top: 2px;
                left: 4px;
                width: 4px;
                height: 8px;
                border: solid white;
                border-width: 0 2px 2px 0;
                transform: rotate(45deg);
            }
            .btn-close {
                background: none;
                border: none;
                font-size: 1.5rem; 
                color: #6c757d; 
                transition: color 0.2s ease;
                position: absolute;
                right: 15px; 
                top: 50%;
                transform: translateY(-50%); 
                cursor: pointer;
            }

            .btn-close:hover {
                color: #000;
            }

            .fade-out {
                opacity: 1;
                transition: opacity 0.3s ease-out;
            }

            .fade-out.hide {
                opacity: 0;
            }

            .alert {
                padding: 20px 30px;
                font-size: 18px;
                max-width: 400px; 
                position: fixed; 
                top: 20px; 
                right: 20px;
                z-index: 1050; 
                border: 1px solid transparent;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
                border-color: #c3e6cb;
                color: #e67e22;
            }

            .progress-bar-timer {
                border-radius: 24px;
                position: absolute;
                bottom: 0;
                left: 0;
                height: 8px;
                width: 100%;
                transition: width linear;
            }

            .alert-dismissible {
                padding-right: 60px; 
            }

        </style>
    </head>
    <body>
        <div class="container-fluid bg-dark text-secondary mb-4 pt-5">
            <div class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex justify-content-center">
                <div class="col-lg-4 justify-content-center text-center">
                    <a href="HomeController" class="text-decoration-none">
                        <span class="h1 text-uppercase text-primary bg-dark px-2">IS</span>
                        <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Perfume</span>
                    </a>
                </div>

            </div>
        </div>
        <!-- Pop-up start -->
        <div id="modalOverlay" class="modal-overlay" style="display: none;">
            <div id="deleteConfirmation" class="card">
                <div class="card-content">
                    <p class="card-heading">Delete product?</p>
                    <p class="card-description">Are you sure you want to delete this Product?</p>
                </div>
                <div class="card-button-wrapper">
                    <button class="card-button secondary" onclick="cancelDelete()">Cancel</button>
                    <a class="card-button primary btn" href="#">Delete</a> 
                </div>
                <button class="exit-button" onclick="cancelDelete()">
                    <svg height="20px" viewBox="0 0 384 512">
                    <path d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"></path>
                    </svg>
                </button>
            </div>
        </div>

        <c:if test="${not empty requestScope.MESSAGE}">
            <div class="alert alert-warning alert-dismissible fade show fade-out" role="alert" id="autoDismissAlert" >
                <i class="fa fa fa-exclamation-circle me-2"></i> ${requestScope.MESSAGE}
                <button type="button" class="btn-close text-right" data-bs-dismiss="alert" aria-label="Close">
                    <i class="fa fa-times"></i>
                </button>
                <div class="progress-bar-timer bg-warning" id="progressBar"></div>
            </div>
        </c:if>
        <!-- Pop-up End -->


        <!-- Cart Start -->

        <form action="MainController" method="POST">
            <div class="container-fluid">
                <div class="row px-xl-5">
                    <div class="col-lg-8 table-responsive mb-2">
                        <table class="table table-light table-borderless table-hover text-center mb-0">
                            <thead class="thead-dark">
                                <tr>
                                    <th>
                                        <input type="checkbox" id="selectAll" style="height: 16px; width: 16px;"/>
                                    </th>
                                    <th></th>
                                    <th>Products</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Unit Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                                <c:forEach var="cart" items="${requestScope.CART}">
                                    <c:set var="unitTotal" value="${cart.price * cart.totalQuantity}"/>
                                    <c:set var="Total" value="${unitTotal + Total}"/>
                                    <tr>
                                        <td class="align-middle m-auto">
                                            <input type="checkbox" name="productDetailID" value="${cart.productDetailID}" style="height: 16px; width: 16px;"/>
                                        </td>
                                        <td class="align-middle">
                                            <img src="${cart.image}" alt="" style="width: 50px;"> 
                                            <input type="hidden" name="image" value="${cart.image}"/>
                                        </td>
                                        <td class="align-middle">
                                            ${cart.productName} ${cart.sizeName}
                                            <input type="hidden" name="proName" value="${cart.productName}"/>
                                            <input type="hidden" name="sizeName" value="${cart.sizeName}"/>
                                        </td>
                                        <td class="align-middle price">
                                            <span class="amount"><fmt:formatNumber type="number" value="${cart.price}"/></span><span class="currency"></span>
                                            <input type="hidden" name="price" value="${cart.price}"/>
                                        </td>
                                        <td class="align-middle">
                                            <div class="input-group quantity mx-auto" style="width: 100px;">
                                                <div class="input-group-btn">
                                                    <button class="btn btn-sm btn-primary btn-minus"
                                                            onclick="updateQuantity(this, -1, event)">
                                                        <i class="fa fa-minus"></i>
                                                    </button>
                                                </div>
                                                <input type="text" name="currentQuantity" readonly
                                                       class="form-control form-control-sm bg-secondary border-0 text-center quantity-input"
                                                       value="${cart.totalQuantity}">
                                                <div class="input-group-btn">
                                                    <button class="btn btn-sm btn-primary btn-plus"
                                                            onclick="updateQuantity(this, 1, event)">
                                                        <i class="fa fa-plus"></i>
                                                    </button>
                                                </div>
                                            </div>
                                        </td>
                                        <td class="align-middle total">
                                            <span class="amount"><fmt:formatNumber type="number" value="${unitTotal}"/></span><span class="currency"></span>
                                        </td>
                                        <td class="align-middle">
                                            <button type="submit" name="productDetailID" value="${cart.productDetailID}" class="btn btn-sm btn-danger" onclick="openDeleteModal(this, event, ${cart.productDetailID})">                                               
                                                <i class="fa fa-times" id="${cart.productDetailID}"></i>
                                            </button>                                       
                                        </td>
                                    </tr>
                                </c:forEach>                         
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
                                        <span></span>
                                        <span id="subtotal"></span>
                                    </h6>

                                </div>
                                <div class="d-flex justify-content-between">
                                    <h6 class="font-weight-medium">Voucher</h6>
                                    <h6 class="font-weight-medium"></h6>
                                </div>
                            </div>
                            <div class="pt-2">
                                <div class="d-flex justify-content-between mt-2">
                                    <h5>Total</h5>
                                    <h5 >
                                        <span></span>
                                        <span id="total-cart"><fmt:formatNumber type="number" value="${Total}"/></span>
                                    </h5> 
                                </div>
                                <button  type="submit" name="action" class="btn btn-block btn-primary font-weight-bold my-3 py-3" value="NavigateToCheckOut">Proceed To Checkout</button>
                            </div>
                        </div>
                    </div>
                    <button type="submit" name="action" value="HomeController" class="btn btn-primary py-3">Continue Shopping</button>
                </div>
            </div>
        </form>
        <!-- Cart End -->




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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

        <script>
                                                window.onload = function () {
                                                    updateCartTotal();
                                                    updateAllProductTotals();
                                                    const selectAllCheckbox = document.getElementById('selectAll');
                                                    selectAllCheckbox.addEventListener('change', function () {
                                                        const checkboxes = document.querySelectorAll('tbody input[type="checkbox"]');
                                                        checkboxes.forEach((checkbox) => {
                                                            checkbox.checked = selectAllCheckbox.checked;
                                                        });
                                                        updateCartTotal();
                                                    });
                                                    const checkboxes = document.querySelectorAll('tbody input[type="checkbox"]');
                                                    checkboxes.forEach((checkbox) => {
                                                        checkbox.addEventListener('change', function () {
                                                            updateCartTotal();
                                                        });
                                                    });
                                                };
                                                function formatCurrency(value) {
                                                    return new Intl.NumberFormat('vi-VN', {
                                                        style: 'decimal',
                                                        minimumFractionDigits: 0,
                                                        maximumFractionDigits: 2
                                                    }).format(value).replace(/\./g, ',');
                                                }

                                                function updateQuantity(button, change, event) {
                                                    event.preventDefault();

                                                    const row = button.closest('tr');
                                                    const quantityInput = row.querySelector('.quantity-input');

                                                    const price = parseFloat(row.querySelector('.price .amount').innerText.replace(/[^0-9.-]+/g, ""));
                                                    let quantity = parseInt(quantityInput.value) + change;
                                                    if (quantity < 1) {
                                                        quantity = 1;
                                                    }
                                                    quantityInput.value = quantity;

                                                    const total = (quantity * price).toFixed(2);
                                                    row.querySelector('.total .amount').innerText = formatCurrency(total);

                                                    updateCartTotal();
                                                }

                                                function updateCartTotal() {
                                                    const rows = document.querySelectorAll('tbody tr');
                                                    let subtotal = 0;

                                                    rows.forEach((row) => {
                                                        const checkbox = row.querySelector('input[type="checkbox"]');
                                                        if (checkbox && checkbox.checked) {
                                                            const totalText = row.querySelector('.total .amount').innerText;
                                                            const total = parseFloat(totalText.replace(/[^0-9.-]+/g, ""));
                                                            subtotal += total;
                                                        }
                                                    });
                                                    document.getElementById('subtotal').innerText = formatCurrency(subtotal.toFixed());
                                                    const shipping = 0;
                                                    const totalCart = subtotal + shipping;
                                                    document.getElementById('total-cart').innerText = formatCurrency(totalCart.toFixed());
                                                }


                                                function removeProduct(button, event) {
                                                    event.preventDefault();
                                                    const row = button.closest('tr');
                                                    row.remove();
                                                    updateCartTotal();
                                                }
                                                function updateAllProductTotals() {
                                                    const rows = document.querySelectorAll('tr');
                                                    rows.forEach((row) => {
                                                        const quantityInput = row.querySelector('.quantity-input');
                                                        const priceText = row.querySelector('.price .amount') ? row.querySelector('.price .amount').innerText : null;
                                                        if (quantityInput && priceText) {
                                                            const price = parseFloat(priceText.replace(/[^0-9.-]+/g, ""));
                                                            const quantity = parseInt(quantityInput.value);
                                                            const total = (quantity * price).toFixed(2);
                                                            row.querySelector('.total .amount').innerText = formatCurrency(total);
                                                        }
                                                    });
                                                }
                                                function openDeleteModal(button, event, productDetailID) {
                                                    event.preventDefault();
                                                    document.getElementById('deleteConfirmation').style.display = 'block';
                                                    document.getElementById('modalOverlay').style.display = 'block';

                                                    const deleteLink = document.querySelector('#deleteConfirmation .card-button.primary');
                                                    deleteLink.href = `MainController?action=DeleteCart&productDetailID=` + productDetailID;
                                                }

                                                function cancelDelete() {
                                                    document.getElementById('deleteConfirmation').style.display = 'none';
                                                    document.getElementById('modalOverlay').style.display = 'none';
                                                }


                                                function proceedDelete() {
                                                    if (deleteButtonRef) {
                                                        removeProduct(deleteButtonRef, event);
                                                    }
                                                    document.getElementById('deleteConfirmation').style.display = 'none';
                                                    document.getElementById('modalOverlay').style.display = 'none';
                                                }
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
