/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.user.UserDAO;
import isp392.user.UserDTO;
import isp392.user.UserError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anhng
 */
public class UpdateUserStatusController extends HttpServlet {

    private static final String ERROR = "SearchUserController";
    private static final String EMPLOYEE = "FilterByEmployeeController";
    private static final String CUSTOMER = "FilterByCustomerController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        boolean checkValidation = true;
        UserDAO dao = new UserDAO();
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            int status = Integer.parseInt(request.getParameter("status"));
            int roleID = Integer.parseInt(request.getParameter("roleID"));
            if (checkValidation) {
                UserDTO user = new UserDTO(userID, "", "", "", "", status, 0);
                boolean checkUpdateS = dao.updateUserStatus(user);
                HttpSession session = request.getSession();
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (checkUpdateS) {
                    if (roleID == 1) {
                        url = CUSTOMER;
                    } else {
                        url = EMPLOYEE;
                    }                   
                } else {
                    request.setAttribute("UPDATE_USER_ERROR", userError);
                }
            }
        } catch (Exception e) {
            log("Error at UpdateUserController: " + e.toString());
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
