/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.user.CustomerDTO;
import isp392.user.CustomerViewProfileDTO;
import isp392.user.UserDAO;
import isp392.user.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GIGABYTE
 */
public class SigninEmployee extends HttpServlet {

    private static final String ERROR = "signin.jsp";
    private static final String HOME_PAGE = "HomeController";
    private static final String CUS_PAGE = "HomeController"; // Customer
    private static final String AD_PAGE = "AD_AccountManagement.jsp"; // Admin
    private static final String MGR_PAGE = "MGR_Dashboard.jsp"; // Manager

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDAO dao = new UserDAO();
        CustomerViewProfileDTO cust = null;
        try {

            String email = request.getParameter("Email");
            String password = request.getParameter("Password");
            UserDTO loginUser = dao.checkLogin(email, password);
            if (loginUser != null) {
                HttpSession ses = request.getSession();
                if (loginUser.getRoleID() == 1) { // customer
                    cust = dao.getCustInfoByUserID(loginUser.getUserID());
                    if (cust != null) {
                        ses.setAttribute("CUSTOMER", cust);
                        url = CUS_PAGE;
                    }
                } else if (loginUser.getRoleID() == 2) { // shipper
                    url = MGR_PAGE;
                } else if (loginUser.getRoleID() == 3) { // staff
                    url = MGR_PAGE;
                } else if (loginUser.getRoleID() == 4) { // manager
                    url = MGR_PAGE;
                } else if (loginUser.getRoleID() == 5) { // admin
                    url = AD_PAGE;
                }
            }
        } catch (Exception e) {
            log("Error at SigninEmployee: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    response.setContentType("text/html;charset=UTF-8");
//    String url = ERROR; // Trang lỗi mặc định
//    UserDAO dao = new UserDAO(); // Tạo đối tượng DAO
//    try {
//        // Lấy thông tin từ form đăng nhập
//        String email = request.getParameter("Email");
//        String password = request.getParameter("Password");
//
//        // Kiểm tra đăng nhập với email và mật khẩu
//        UserDTO loginUser = dao.checkLogin(email, password);
//        if (loginUser != null) {
//            // Nếu thông tin đăng nhập hợp lệ, lưu đối tượng người dùng vào session
//            HttpSession ses = request.getSession();
//            ses.setAttribute("LOGIN_USER", loginUser);
//
//            // Kiểm tra quyền của người dùng dựa trên roleID
//            if (loginUser.getRoleID() == 1) { // Nếu là customer
//                // Tìm thông tin khách hàng dựa trên userID
//                CustomerDTO cust = dao.getCustInfoByUserID(loginUser.getUserID());
//                if (cust != null) {
//                    // Nếu tìm thấy thông tin khách hàng, thêm vào session
//                    ses.setAttribute("CUSTOMER", cust);
//                    url = CUS_PAGE; // Điều hướng tới trang customer
//                } else {
//                    // Không tìm thấy thông tin khách hàng, báo lỗi
//                    request.setAttribute("ERROR_MESSAGE", "Customer information not found.");
//                    url = ERROR; // Hoặc điều hướng tới trang lỗi khác
//                }
//            } else if (loginUser.getRoleID() == 2) { // Shipper
//                url = MGR_PAGE; // Điều hướng tới trang shipper
//            } else if (loginUser.getRoleID() == 3) { // Staff
//                url = MGR_PAGE; // Điều hướng tới trang staff
//            } else if (loginUser.getRoleID() == 4) { // Manager
//                url = MGR_PAGE; // Điều hướng tới trang manager
//            } else if (loginUser.getRoleID() == 5) { // Admin
//                url = AD_PAGE; // Điều hướng tới trang admin
//            }
//        } else {
//            // Nếu loginUser là null, nghĩa là đăng nhập thất bại
//            request.setAttribute("ERROR_MESSAGE", "Invalid email or password.");
//        }
//    } catch (Exception e) {
//        log("Error at SigninEmployee: " + e.toString());
//        request.setAttribute("ERROR_MESSAGE", "An error occurred: " + e.getMessage());
//    } finally {
//        // Điều hướng tới trang xác định dựa trên roleID
//        request.getRequestDispatcher(url).forward(request, response);
//    }
//}
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
