<%-- 
    Document   : changePassword
    Created on : Oct 5, 2024, 12:16:41 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                    <a href="HomeController" class="text-decoration-none">
                        <span class="h1 text-uppercase text-primary bg-dark px-2">IS</span>
                        <span class="h1 text-uppercase text-dark bg-primary px-2 ml-n1">Perfume</span>
                    </a>
                </div>
            </div>
        </div>
        <!-- Topbar End -->


        <!-- Navbar Start -->

        <!-- Navbar End -->


        <div class="container-fluid pt-4 px-4">
            <div class="row vh-100 bg-light rounded align-items-center justify-content-center mx-0 " style="height: auto !important">
                <div class="table-responsive">
                    <div class="col-sm-12 col-xl-12">
                        <div class="bg-light rounded h-100 p-4">
                            <c:if test="${requestScope.ORDER_CUSTOMER.shipperID!=0}">
                                <div class="d-flex flex-column align-items-start justify-content-between mb-4">
                                    <h6 class="mb-0">Information</h6>
                                </div>
                                <c:forEach var="user" items="${sessionScope.LIST_USER}">
                                    <c:if test="${requestScope.ORDER_CUSTOMER.shipperID == user.userID}">
                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                            <p class="mb-0"><strong>Shipper: </strong>${user.name} </p>
                                            <p class="mb-0"><strong>Phone: </strong>${user.phone}</p>
                                            <p class="mb-0"><strong>Address: </strong>${requestScope.ORDER_CUSTOMER.address}, Ward ${requestScope.ORDER_CUSTOMER.ward}, ${requestScope.ORDER_CUSTOMER.district}, ${requestScope.ORDER_CUSTOMER.city} </p>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                            <div class="d-flex flex-column align-items-start justify-content-between mb-4">
                                <h6 class="mb-0">Order Detail</h6>
                            </div>

                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Product</th>
                                        <th scope="col">Size</th>
                                        <th scope="col">Quantity</th>
                                        <th scope="col">Unit Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="orderDetail" items="${requestScope.LIST_ORDER_DETAIL_CUSTOMER}">
                                        <!--                                        product-->
                                        <tr>
                                            <td>
                                                <c:forEach var="productDetail" items="${sessionScope.LIST_PRODUCT_DETAIL}">
                                                    <c:if test="${orderDetail.productDetailID == productDetail.productDetailID}">
                                                        <c:forEach var="product" items="${sessionScope.LIST_PRODUCT}">
                                                            <c:if test="${product.productID == productDetail.productID}">
                                                                ${product.name}
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <!--                                            size-->
                                            <td>
                                                <c:forEach var="productDetail" items="${sessionScope.LIST_PRODUCT_DETAIL}">
                                                    <c:if test="${orderDetail.productDetailID == productDetail.productDetailID}">
                                                        <c:forEach var="size" items="${sessionScope.LIST_SIZE}">
                                                            <c:if test="${size.sizeID == productDetail.sizeID}">
                                                                ${size.name}
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:if>
                                                </c:forEach>
                                            </td>
                                            <td>
                                                ${orderDetail.quantity}
                                            </td>
                                            <td>
                                                <fmt:formatNumber type="number" value="${orderDetail.unitPrice}"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="d-flex justify-content-between align-items-center mt-4">
                                <h6 class="mb-0">Total Price:</h6>
                                <p class="mb-0 ml-auto">
                                    <c:forEach var="orderDetail" items="${requestScope.LIST_ORDER_DETAIL_CUSTOMER}" >
                                        <c:set var="unitTotal" value="${orderDetail.unitPrice * orderDetail.quantity}"/>
                                        <c:set var="Total" value="${unitTotal + Total}"/>
                                    </c:forEach>
                                    <fmt:formatNumber value="${Total}" type="number"/> VNĐ
                                </p>
                            </div>
                            <c:choose>
                                <c:when test="${requestScope.ORDER_CUSTOMER.promotionID != 0}">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <h6 class="mb-0">Promotion Applied:</h6>
                                        <c:forEach var="promotion" items="${sessionScope.LIST_PROMOTION}">
                                            <c:if test="${requestScope.ORDER_CUSTOMER.promotionID == promotion.promotionID}">
                                                <p class="mb-0 ml-auto">${promotion.promotionName} - ${promotion.discountPer}% off</p>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <h6 class="mb-0">Final Price</h6>
                                        <c:forEach var="promotion" items="${sessionScope.LIST_PROMOTION}">
                                            <c:if test="${requestScope.ORDER_CUSTOMER.promotionID == promotion.promotionID}">
                                                <p class="mb-0 ml-auto">
                                                    <fmt:formatNumber value="${Total * (1 - promotion.discountPer / 100.0)}" type="number"/> VNĐ
                                                </p>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div class="d-flex justify-content-between align-items-center">
                                        <h6 class="mb-0">Final Price</h6>
                                        <p class="mb-0 ml-auto">
                                            <fmt:formatNumber value="${Total}" type="number"/> VNĐ
                                        </p>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Change password form End-->
    </body>
</html>
