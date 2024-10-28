/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.forgotpassword.ForgotPasswordDAO;
import isp392.forgotpassword.ForgotPasswordDTO;
import isp392.user.UserDAO;
import isp392.user.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyhc
 */
@WebServlet(name = "ForgetPasswordController", urlPatterns = {"/ForgetPasswordController"})
public class ForgetPasswordController extends HttpServlet {

    private static final String SUCCESS = "verifyOTP.jsp";
    private static final String ERROR = "forgotPassword.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserDAO userDAO = new UserDAO();
        ForgotPasswordDAO forPasDAO = new ForgotPasswordDAO();
        try {
            String email = request.getParameter("emailReset");
            boolean checkExisted = userDAO.checkEmailExisted(email);
            if(checkExisted){
                UserDTO user = userDAO.getUserByGoogleEmail(email);
                int userID = user.getUserID();
                request.setAttribute("USERID_FORGOTPASSWORD", userID);
                boolean checkAdd = forPasDAO.insertToken(userID);
                if(checkAdd){
                    ForgotPasswordDTO forgotPassword = forPasDAO.getInforByUserID(userID);
                    if(forgotPassword!=null){
                       url = "SendEmailController?email="+email+"&token="+forgotPassword.getToken()+"&action=ForgotPasswordEmail";
                       request.getRequestDispatcher(url).include(request, response);
                       url = SUCCESS;
                    }
                }
            }else{
                request.setAttribute("ERROR_FORGOT_PASSWORD", "Email not exist!!");
            }
        } catch (Exception e) {
            log("Error at ForgotPasswordController: "+e.toString());
        }finally{
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
