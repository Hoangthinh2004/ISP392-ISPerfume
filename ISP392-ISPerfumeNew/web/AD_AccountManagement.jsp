<%-- 
   Document   : AD_AccountManagement
   Created on : Oct 4, 2024, 9:24:31 AM
   Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="isp392.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Admin | User </title>
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
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="dashmin/css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="dashmin/css/style.css" rel="stylesheet">
        <link href="css/stylePopup.css" rel="stylesheet">

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
                    <a href="AD_AccountManagement.jsp" class="navbar-brand mx-4 mb-3">
                        <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>ISPERFUME</h3>
                    </a>
                    <div class="d-flex align-items-center ms-4 mb-4">
                        <div class="position-relative">
                            <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                            <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                        </div>
                        <div class="ms-3">
                            <h6 class="mb-0">Name Adminitrator</h6>
                            <span>Admin</span>
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                        <a href="MainController?search=&action=SearchUser" class="nav-item nav-link active"><i class="fa fa-user me-2"></i>User Management</a>                   
                    </div>
                </nav>
            </div>
            <!-- Sidebar End -->


            <!-- Content Start -->
            <div class="content">
                <!-- Navbar Start -->
                <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                    <a href="AD_AccountManagement.jsp" class="navbar-brand d-flex d-lg-none me-4">
                        <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                    </a>
                    <a href="#" class="sidebar-toggler flex-shrink-0">
                        <i class="fa fa-bars"></i>
                    </a>
                    <form class="d-none d-md-flex ms-4" action="MainController" method="GET">
                        <input class="form-control border-0" type="text" placeholder="Type Phone Number" name="search" value="${param.search}">
                        <button class="btn btn-primary" type="submit" name="action" value="SearchUser" style="margin-left: 10px;">
                            <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                            <path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z"/>
                            </svg>
                        </button>
                    </form>
                    <div class="navbar-nav align-items-center ms-auto">
                        <!--                        <div class="nav-item dropdown">
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
                                                </div>-->
                        <!--                        <div class="nav-item dropdown">
                                                    <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                                        <i class="fa fa-bell me-lg-2"></i>
                                                        <span class="d-none d-lg-inline-flex">Notification</span>
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
                                                </div>-->
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                <i class="fa fa-user"></i>
                                <span class="d-none d-lg-inline-flex">John Doe</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <a href="#" class="dropdown-item">My Profile</a>
                                <a href="#" class="dropdown-item">Settings</a>
                                <a href="MainController?action=Sign out" class="dropdown-item">Sign Out</a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Navbar End -->

                <!--Pop-up start-->
                <div id="modalOverlay" class="modal-overlay" style="display: none;">
                    <div id="deleteConfirmation" class="card">
                        <div class="card-content">
                            <p class="card-heading">Delete User</p>
                            <p class="card-description">Are you sure you want to delete this user?</p>
                        </div>
                        <div class="card-button-wrapper">
                            <button class="card-button secondary" onclick="cancelDelete()">Cancel</button>
                            <button class="card-button primary" onclick="proceedDelete()">Delete</button>
                        </div>
                        <button class="exit-button" onclick="cancelDelete()">
                            <svg height="20px" viewBox="0 0 384 512">
                            <path d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"></path>
                            </svg>
                        </button>
                    </div>
                </div>
                <!--Pop-up End-->

                <!-- Blank Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="row vh-100 bg-light rounded align-items-center justify-content-center mx-0 " style="height: auto !important;">
                        <div class="table-responsive">
                            <div class="col-sm-12 col-xl-12">
                                <div class="bg-light rounded h-100 p-4" style=" min-height: 540px;">
                                    <div class="d-flex align-items-center justify-content-between mb-4">

                                        <div class="nav-item dropdown" style="width: 150px;">
                                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" role="button" aria-expanded="false">
                                                <span class="d-none d-lg-inline-flex">Filter</span>
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li><a href="MainController?action=FilterByEmployee" class="dropdown-item">Employee</a></li>
                                                <li><a href="MainController?action=FilterByCustomer" class="dropdown-item">Customer</a></li>
                                            </ul>
                                        </div>
                                        <a href="AD_CreateAccount.jsp"><i class="fa fa-plus me-2"></i>Create Account</a>                   
                                    </div>
                                    <c:if test="${requestScope.LIST_USER != null}">
                                        <c:if test="${!empty requestScope.LIST_USER}"> 
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">User ID</th>
                                                        <th scope="col">Name</th>
                                                        <th scope="col">Email</th>
                                                        <th scope="col">Phone</th>
                                                        <th scope="col">Role</th>
                                                            <c:if test="${param.action != 'SearchUser'}">                                                              
                                                            <th scope="col">Status</th>
                                                                <c:if test="${user.roleID > 1}">
                                                                <th scope="col">Update</th>
                                                                </c:if>
                                                            </c:if>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
                                                        <tr>
                                                            <td>
                                                                ${user.userID}
                                                            </td>
                                                            <td>
                                                                ${user.name}
                                                            </td>
                                                            <td>
                                                                ${user.email}
                                                            </td>
                                                            <td>
                                                                ${user.phone}
                                                            </td>
                                                            <td>
                                                                <c:forEach var="role" items="${requestScope.LIST_ROLE}">
                                                                    <c:if test="${role.roleID == user.roleID}">    
                                                                        ${role.name}
                                                                        <input type="hidden" name="roleID" value="${role.roleID}">
                                                                    </c:if>
                                                                </c:forEach>
                                                            </td>
                                                            <c:if test="${param.action != 'SearchUser'}">
                                                                <td>                                                     
                                                                    <form id="updateUserForm-${user.userID}" action="MainController" method="POST">
                                                                        <select id="statusSelect-${user.userID}" name="status" class="form-select mb-3 form-control bg-transparent" aria-label="Default select example" onmousedown="captureOldValue(this)" onchange="openDeleteModal(this, ${user.userID})">
                                                                            <option value="1" ${user.status == 1 ? 'selected="selected"' : ''}>Available</option>
                                                                            <option value="0" ${user.status == 0 ? 'selected="selected"' : ''}>Unavailable</option>
                                                                        </select>
                                                                        <input type="hidden" value="${user.userID}" name="userID">
                                                                        <input type="hidden" value="UpdateUserStatus" name="action">
                                                                        <input type="hidden" name="roleID" value="${user.roleID}">
                                                                    </form>
                                                                </td>
                                                                <c:if test="${user.roleID > 1}">
                                                                    <td>
                                                                        <a class="d-flex justify-content-center" data-bs-toggle="modal" data-bs-target="#updateModal-${user.userID}">
                                                                            <svg class="w-6 h-6 text-gray-800" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                                                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m14.304 4.844 2.852 2.852M7 7H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h11a1 1 0 0 0 1-1v-4.5m2.409-9.91a2.017 2.017 0 0 1 0 2.853l-6.844 6.844L8 14l.713-3.565 6.844-6.844a2.015 2.015 0 0 1 2.852 0Z"/>
                                                                            </svg>
                                                                        </a>
                                                                        <!-- Modal Update -->
                                                                        <div class="modal fade" id="updateModal-${user.userID}" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true" >
                                                                            <div class="modal-dialog">
                                                                                <div class="modal-content" style="border-radius: 24px;">
                                                                                    <div class="modal-header">
                                                                                        <h1 class="modal-title fs-5" id="updateModalLabel">User Information</h1>
                                                                                        <button type="button" class="btn btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                                    </div>
                                                                                    <form action="MainController" method="GET">
                                                                                        <input type="hidden" value="${user.userID}" name ="userID">
                                                                                        <div class="modal-body">
                                                                                            <div class="mb-3">
                                                                                                <label  class="form-label">User Name</label>
                                                                                                <input type="text" class="form-control" value="${user.name}" name="name"> 
                                                                                            </div>
                                                                                            <div class="mb-3">
                                                                                                <label  class="form-label">Email</label>
                                                                                                <input type="email" class="form-control" value="${user.email}" name="email"> 
                                                                                            </div>
                                                                                            <div class="mb-3">
                                                                                                <label  class="form-label">Phone</label>
                                                                                                <input type="text" class="form-control" value="${user.phone}" name="phone"> 
                                                                                            </div>                                                                                      
                                                                                        </div>
                                                                                        <div class="modal-footer">
                                                                                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                                                                                            <button type="submit" class="btn" name="action" value="UpdateUser">Update</button>
                                                                                            <input type="hidden" name="search" value=""/>
                                                                                        </div>
                                                                                        <c:forEach var="role" items="${requestScope.LIST_ROLE}">
                                                                                            <c:if test="${role.roleID == user.roleID}">                                                                                               
                                                                                                <input type="hidden" name="roleID" value="${role.roleID}">
                                                                                            </c:if>
                                                                                        </c:forEach>
                                                                                    </form>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <!--                                                                    <input type="submit" name="action" value="UpdateUser" class="btn btn-sm btn-primary">
                                                                                                                                            <input type="hidden" name="search" value=""/>-->
                                                                    </td>
                                                                </c:if>
                                                            </c:if>
                                                        </tr>

                                                    </c:forEach>
                                                    ${requestScope.UPDATE_USER_ERROR.nameError}
                                                    ${requestScope.UPDATE_USER_ERROR.emailError}
                                                    ${requestScope.UPDATE_USER_ERROR.phoneError}
                                                </tbody>
                                            </table>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Blank End -->

                <!-- Footer Start -->
                <div class="container-fluid pt-4 px-4">
                    <div class="bg-light rounded-top p-4">
                        <div class="row">
                            <div class="col-12 col-sm-6 text-center text-sm-start">
                                &copy; <a href="#">ISPERFUME</a>
                            </div>
                            <div class="col-12 col-sm-6 text-center text-sm-end">
                                <a href="#">Privacy Policy</a> | <a href="#">Terms of Use</a>
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
                                                                            let previousValue;
                                                                            let deleteButtonRef;
                                                                            let formIDToSubmit;


                                                                            function captureOldValue(selectElement) {
                                                                                previousValue = selectElement.value;
                                                                            }


                                                                            function openDeleteModal(selectElement, userID) {
                                                                                deleteButtonRef = selectElement;
                                                                                formIDToSubmit = `updateUserForm-` + userID;

                                                                                document.getElementById('deleteConfirmation').style.display = 'block';
                                                                                document.getElementById('modalOverlay').style.display = 'block';
                                                                            }


                                                                            function cancelDelete() {
                                                                                deleteButtonRef.value = previousValue;

                                                                                document.getElementById('deleteConfirmation').style.display = 'none';
                                                                                document.getElementById('modalOverlay').style.display = 'none';
                                                                            }

                                                                            function proceedDelete() {
                                                                                document.getElementById(formIDToSubmit).submit();
                                                                            }
        </script>

    </body>
</html>
