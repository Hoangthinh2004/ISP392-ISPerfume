/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.forgotpassword.ForgotPasswordDAO;
import isp392.forgotpassword.ForgotPasswordDTO;
import isp392.forgotpassword.ForgotPasswordError;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duyhc
 */
@WebServlet(name = "VerifyOTPController", urlPatterns = {"/VerifyOTPController"})
public class VerifyOTPController extends HttpServlet {

    private static final String ERROR ="verifyOTP.jsp";
    private static final String SUCCESS = "changePasswordForgot.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ForgotPasswordDAO dao = new ForgotPasswordDAO();
        ForgotPasswordError err = new ForgotPasswordError();
        HttpSession ses = request.getSession();
        try {
            String otp = request.getParameter("otp");
            ForgotPasswordDTO forgotPasswordDTO = dao.checkExist(otp);
            if(forgotPasswordDTO!=null){
                int userID = forgotPasswordDTO.getUserID();
                ses.setAttribute("USERID", userID);
                boolean checkDel = dao.deleteOTP(otp, userID);
                if(checkDel){
                    url = SUCCESS;
                }
            }else{
                err.setTokenError("Wrong OTP !!!");
                request.setAttribute("ERROR_FORGOT_PASSWORD", err);
            }
        } catch (Exception e) {
            log("Error at VerifyOTPController: "+e.toString());
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
