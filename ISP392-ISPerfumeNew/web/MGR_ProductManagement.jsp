<%-- 
    Document   : MGR_ProductManagement
    Created on : Sep 25, 2024, 3:04:54 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="isp392.product.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>DASHMIN - Bootstrap Admin Template</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="dashmin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="dashmin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="dashmin/css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="dashmin/css/style.css" rel="stylesheet">

    </head>
    <body>
        <div class="container-fluid position-relative bg-white d-flex p-0">
            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->


            <!-- Sidebar Start -->
            <div class="sidebar pe-4 pb-3">
                <nav class="navbar bg-light navbar-light">
                    <a href="MainController?action=ListDashboard" class="navbar-brand mx-4 mb-3">
                        <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>DASHMIN</h3>
                    </a>
                    <div class="d-flex align-items-center ms-4 mb-4">
                        <div class="position-relative">
                            <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                        </div>
                        <div class="ms-3">
                            <h6 class="mb-0">Jhon Doe</h6>
                            <span>Admin</span>
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                        <form action="MainController" method="POST" id="myForm">
                            <a href="MGR_Dashboard.jsp" class="nav-item nav-link active" onclick="document.getElementById('myForm').submit(); return false;"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                            <input type="hidden" name="action" value="ListDashboard">
                        </form>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle active" data-bs-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Management</a>
                            <div class="dropdown-menu bg-transparent border-0">
                                <a href="MainController?action=SearchProduct&search=" class="dropdown-item">Product Management</a>
                                <a href="MainController?action=Search&search=" class="dropdown-item">Brand Management</a>
                                <a href="MainController?action=ViewPromotion&search=" class="dropdown-item ">Promotion Management</a>
                            </div>
                        </div>

                    </div>
            </div>
        </nav>
    </div>
    <!-- Sidebar End -->


    <!-- Content Start -->
    <div class="content">
        <!-- Navbar Start -->
        <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
            <a href="MGR_Dashboard.jsp" class="navbar-brand d-flex d-lg-none me-4">
                <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
            </a>
            <a href="#" class="sidebar-toggler flex-shrink-0">
                <i class="fa fa-bars"></i>
            </a>
            <form class="d-none d-md-flex ms-4" action="MainController" method="get">
                <input class="form-control border-0" type="search" placeholder="Search" name="search">
                <button class="btn btn-primary" type="submit" name="action" value="SearchProduct" style="margin-left: 10px;">
                    <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                    <path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z"/>
                    </svg>
                </button>
            </form>
            <div class="navbar-nav align-items-center ms-auto">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                        <i class="fa fa-envelope me-lg-2"></i>
                        <span class="d-none d-lg-inline-flex">Message</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                        <a href="#" class="dropdown-item">
                            <div class="d-flex align-items-center">
                                <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <div class="ms-2">
                                    <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                    <small>15 minutes ago</small>
                                </div>
                            </div>
                        </a>
                        <hr class="dropdown-divider">
                        <a href="#" class="dropdown-item">
                            <div class="d-flex align-items-center">
                                <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <div class="ms-2">
                                    <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                    <small>15 minutes ago</small>
                                </div>
                            </div>
                        </a>
                        <hr class="dropdown-divider">
                        <a href="#" class="dropdown-item">
                            <div class="d-flex align-items-center">
                                <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                                <div class="ms-2">
                                    <h6 class="fw-normal mb-0">Jhon send you a message</h6>
                                    <small>15 minutes ago</small>
                                </div>
                            </div>
                        </a>
                        <hr class="dropdown-divider">
                        <a href="#" class="dropdown-item text-center">See all message</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                        <i class="fa fa-bell me-lg-2"></i>
                        <span class="d-none d-lg-inline-flex">Notificatin</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                        <a href="#" class="dropdown-item">
                            <h6 class="fw-normal mb-0">Profile updated</h6>
                            <small>15 minutes ago</small>
                        </a>
                        <hr class="dropdown-divider">
                        <a href="#" class="dropdown-item">
                            <h6 class="fw-normal mb-0">New user added</h6>
                            <small>15 minutes ago</small>
                        </a>
                        <hr class="dropdown-divider">
                        <a href="#" class="dropdown-item">
                            <h6 class="fw-normal mb-0">Password changed</h6>
                            <small>15 minutes ago</small>
                        </a>
                        <hr class="dropdown-divider">
                        <a href="#" class="dropdown-item text-center">See all notifications</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                        <img class="rounded-circle me-lg-2" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <span class="d-none d-lg-inline-flex">John Doe</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                        <a href="#" class="dropdown-item">My Profile</a>
                        <a href="#" class="dropdown-item">Settings</a>
                        <a href="#" class="dropdown-item">Log Out</a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Navbar End -->


        <!-- Blank Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="row vh-100 bg-light rounded justify-content-center mx-0" style="height: auto !important">
                <!--                        <div class="col-md-6 text-center">-->
                <!-- Recent Sales Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">   
                            <h6 class="mb-0">Product Management</h6>
                            <a href="MGR_CreateProduct.jsp" class="btn btn-primary">Create product</a>
                            <!--                                    <button class="btn btn-primary">
                                                                    <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                                                    <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h14m-7 7V5"/>
                                                                    </svg>
                                                                </button>-->
                        </div>
                        <div class="table-responsive">
                            <c:if test="${requestScope.SHOW_ALL_PRODUCT_MANAGER!=null}">
                                <table class="table text-start align-middle table-bordered table-hover mb-0">
                                    <thead>
                                        <tr class="text-dark">
                                            <th scope="col" class="text-center">Name</th>
                                            <th scope="col" class="text-center">Brand</th>
                                            <th scope="col" class="text-center">Image</th>
                                            <th scope="col" class="text-center">Status</th>                                                   
                                            <th scope="col" class="text-center">Update</th>                                                   
                                            <th scope="col" class="text-center">Detail</th>                                                   
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="pro" varStatus="counter" items="${requestScope.SHOW_ALL_PRODUCT_MANAGER}">
                                            <tr>
                                                <td class="text-center">
                                                    ${pro.name}
                                                </td>
                                                <td class="text-center">
                                                    <c:forEach var="brand" items="${sessionScope.BRAND_LIST_MANAGER}">
                                                        <c:if test="${brand.brandID == pro.brandID}">
                                                            ${brand.name}
                                                        </c:if>
                                                    </c:forEach>

                                                <td class="d-flex justify-content-center">
                                                    <img src="${pro.image}" style="width: 100px; height: 100px; margin-right: 10px; border-radius: 16px;">
                                                </td>
                                                <td class="text-center">
                                                    <c:choose>
                                                        <c:when test="${pro.status == 1}">
                                                            AVAILABLE
                                                        </c:when>
                                                        <c:otherwise>
                                                            UNAVAILABLE
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>                                                     
                                                <td>
                                                    <a class="d-flex justify-content-center" data-bs-toggle="modal" data-bs-target="#updateModal-${counter.count}">
                                                        <svg class="w-6 h-6 text-gray-800" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m14.304 4.844 2.852 2.852M7 7H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-4.5m2.409-9.91a2.017 2.017 0 0 1 0 2.853l-6.844 6.844L8 14l.713-3.565 6.844-6.844a2.015 2.015 0 0 1 2.852 0Z"/>
                                                        </svg>

                                                    </a>
                                                    <!-- Modal Update -->
                                                    <div class="modal fade" id="updateModal-${counter.count}" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true" >
                                                        <div class="modal-dialog">
                                                            <div class="modal-content" style="border-radius: 24px;">
                                                                <div class="modal-header">
                                                                    <h1 class="modal-title fs-5" id="updateModalLabel">Promotion Information</h1>
                                                                    <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <form action="UpdateProductManager" method="post" enctype="multipart/form-data">
                                                                    <div class="modal-body">
                                                                        <div class="mb-3">
                                                                            <label  class="form-label">Product Name</label>
                                                                            <input type="text" name="productName" value="${pro.name}" class="form-control">                                                                   
                                                                        </div>
                                                                        <label  class="form-label">Brand</label>
                                                                        <select name="brandID" class="form-select mb-3 form-control bg-transparent">
                                                                            <c:forEach var="brand" items="${sessionScope.BRAND_LIST_MANAGER}">
                                                                                <option value="${brand.brandID}"
                                                                                        <c:if test="${brand.brandID == pro.brandID}">
                                                                                            SELECTED
                                                                                        </c:if>
                                                                                        >
                                                                                    ${brand.name}
                                                                                </option>
                                                                            </c:forEach>
                                                                        </select>
                                                                        <div class="form-floating mb-3">
                                                                            <textarea class="form-control" style="height: 100px;"
                                                                                      id="floatingTextarea" name="description">${pro.description}</textarea>
                                                                            <label for="floatingTextarea">Description</label>
                                                                        </div>
                                                                        <div class="mb-3">
                                                                            <label  class="form-label">Country</label>
                                                                            <input type="text" name="country"  value="${pro.country}" class="form-control bg-transparent">                                                                   
                                                                        </div>
                                                                        <div class="form-floating mb-3">
                                                                            <textarea class="form-control" style="height: 80px;"
                                                                                      id="floatingTextarea-1" name="fragranceFamilies">${pro.fragranceFamilies}</textarea>
                                                                            <label for="floatingTextarea-1">Fragrance Families</label>
                                                                        </div>
                                                                        <div class="mb-3">
                                                                            <input type="hidden" value="${pro.image}" name="existingImage">
                                                                            <label for="image"  class="col-sm-2 col-form-label">Image</label>
                                                                            <input type="file" name="image" class="form-control">
                                                                        </div>
                                                                        <label  class="form-label">Status</label>
                                                                        <select name="status" class="form-select mb-3 form-control bg-transparent" aria-label="Default select example">
                                                                            <option value="1" ${pro.status == 1 ? 'selected' : ''}>Available</option>
                                                                            <option value="0" ${pro.status == 0 ? 'selected' : ''}>Unavailable</option>
                                                                        </select>
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <input type="hidden" name="releaseDate" value="${pro.releaseDate}" >
                                                                        <input type="hidden" name="productID" value="${pro.productID}">
                                                                        <input type="hidden" name="search" value="${requestScope.SEARCH}">
                                                                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                                                        <button type="submit" class="btn" name="action" value="Update">Update</button>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <form action="MainController" method="get" class="d-flex justify-content-around"> 
                                                        <button type="submit" name="action" value="ProductDetailPage" class="btn btn-sm btn-primary"><i class="fa fa-search"></i></button>
                                                        <input type="hidden" name="productID" value="${pro.productID}">
                                                    </form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>
                        </div>
                    </div>
                </div>
                <!-- Recent Sales End -->
                <!--</div>-->
            </div>
        </div>
        <!-- Blank End -->
        <!--                Footer Start -->
        <div class="container-fluid pt-4 px-4">
            <div class="bg-light rounded-top p-4">
                <div class="row">
                    <div class="col-12 col-sm-6 text-center text-sm-start">
                        &copy; <a href="#">Your Site Name</a>, All Right Reserved. 
                    </div>
                    <div class="col-12 col-sm-6 text-center text-sm-end">
                        Designed By <a href="https://htmlcodex.com">HTML Codex</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->
    </div>
    <!-- Content End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
</div>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="dashmin/lib/chart/chart.min.js"></script>
<script src="dashmin/lib/easing/easing.min.js"></script>
<script src="dashmin/lib/waypoints/waypoints.min.js"></script>
<script src="dashmin/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="dashmin/lib/tempusdominus/js/moment.min.js"></script>
<script src="dashmin/lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="dashmin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="dashmin/js/main.js"></script>
<script>
                                window.onload = function () {
                                    const searchInput = document.querySelector('input[name="search"]');
                                    const form = searchInput.form;
                                    if (!sessionStorage.getItem('isSubmitted')) {
                                        const hiddenAction = document.createElement('input');
                                        hiddenAction.type = 'hidden';
                                        hiddenAction.name = 'action';
                                        hiddenAction.value = 'Search product';
                                        form.appendChild(hiddenAction);
                                        form.submit();
                                        sessionStorage.setItem('isSubmitted', 'true');
                                    }
                                };
</script>
</body>
</html>
