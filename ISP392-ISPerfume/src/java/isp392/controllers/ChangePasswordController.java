/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.user.CustomerViewProfileDTO;
import isp392.user.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GIGABYTE
 */
public class ChangePasswordController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "changePassword.jsp";
    private static final String SUCCESS = "HomeController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDAO dao = new UserDAO();
        HttpSession ses = request.getSession();
        boolean checkValid = true;
        
        try {
            CustomerViewProfileDTO cust = (CustomerViewProfileDTO) ses.getAttribute("CUSTOMER");
            int userID = cust.getId();
            String currentPass = request.getParameter("currentPass");
            String newPass = request.getParameter("newPass");
            String confirm = request.getParameter("confirmPass");
            
            if (!currentPass.equals(dao.getPasswordByID(userID))) {
                // gui loi // request.setA("ten cua loi","noi dung");
                request.setAttribute("ERROR", "THE CURRENT PASSWORD IS NOT MATCHED!!");
                checkValid = false;
            }
            if (!confirm.equals(newPass)) {
                // gui loi
                request.setAttribute("ERROR", "THE CONFIRM PASSWORD IS NOT MATCHED!");
                checkValid = false;
            }
            if (checkValid) {
                boolean changePass = dao.updatePassword(userID, newPass);
                CustomerViewProfileDTO newCust = dao.getCustInfoByUserID(userID);
                ses.setAttribute("CUSTOMER", newCust);
                url = SUCCESS;
            }
// if (checkValid) {
//            boolean changePass = dao.updatePassword(userID, newPass);
//            if (changePass) {
//                ses.setAttribute("SUCCESS", "Password updated successfully!");
//                CustomerViewProfileDTO newCust = dao.getCustInfoByUserID(userID);
//                ses.setAttribute("CUSTOMER", newCust);
//                url = SUCCESS;
//            } else {
//                request.setAttribute("ERROR", "Failed to update password!");
//            }}

        } catch (Exception e) {
            log("Error at ChangePasswordController: " + e.toString());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
