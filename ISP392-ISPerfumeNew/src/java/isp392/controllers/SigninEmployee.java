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
    private static final String CUS_PAGE = "HomeController"; // Customer
    private static final String AD_PAGE = "AD_AccountManagement.jsp"; // Admin
    private static final String MGR_PAGE = "ListDashboardController"; // Manager
    private static final String SHIPPER_PAGE = "SHIPPER_SearchOrderController";
    private static final String STAFF_PAGE = "GetAllInfoForOrder";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDAO dao = new UserDAO();
        CustomerViewProfileDTO cust = null;
        try {
            HttpSession session = request.getSession();
            Map<String, Integer> CustomerIDS = new HashMap<>();
            session.setAttribute("CUSTOMER_ID", CustomerIDS);
            String email = request.getParameter("Email");
            String password = request.getParameter("Password");
            UserDTO loginUser = dao.checkLogin(email, password);           
            if (loginUser != null) {
                CustomerIDS.put("customerID", loginUser.getUserID());
                if (loginUser.getRoleID() == 1) { // customer
                    cust = dao.getCustInfoByUserID(loginUser.getUserID());
                    if (cust != null) {
                        session.setAttribute("CUSTOMER", cust);
                        url = CUS_PAGE;
                    }
                } else if (loginUser.getRoleID() == 2) { // shipper
                    session.setAttribute("LOGIN_USER", loginUser);
                    url = SHIPPER_PAGE;
                } else if (loginUser.getRoleID() == 3) { // staff
                    session.setAttribute("LOGIN_USER", loginUser);
                    url = STAFF_PAGE;
                } else if (loginUser.getRoleID() == 4) { // manager
                    session.setAttribute("LOGIN_USER", loginUser);
                    url = MGR_PAGE;
                } else if (loginUser.getRoleID() == 5) { // admin
                    session.setAttribute("LOGIN_USER", loginUser);
                    url = AD_PAGE;
                }
            } else {
                request.setAttribute("ERROR_MESSAGE", "Incorrect email or password!");
            }
        } catch (Exception e) {
            log("Error at SigninEmployee: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

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
