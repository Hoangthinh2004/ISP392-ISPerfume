/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.user.UserDAO;
import isp392.user.UserError;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anhng
 */
public class CreateEmployeeAccountController extends HttpServlet {

    private static final String ERROR = "AD_CreateAccount.jsp";
    private static final String SUCCESS = "SearchUserController";
    private static final String EMAIL_REGEX = "^(?=.*[a-zA-Z])[a-zA-Z0-9._%+-]+@gmail\\.com$";
    private static final String NAME_REGEX = "^[a-zA-Z]+( [a-zA-Z]+)*$";
    private static final String PHONE_REGEX = "^(?:\\+84|0)(3[2-9]|5[6|8|9]|7[0|6|7|8|9]|8[1-9]|9[0-9])[0-9]{7}$";
    private static final String NUMBER_EMAIL_REGEX = "^\\d+@gmail.com$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        boolean checkValidation = true;
        UserDAO dao = new UserDAO();
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            int status = Integer.parseInt(request.getParameter("status"));
            int roleID = Integer.parseInt(request.getParameter("roleID"));

            if (!name.matches(NAME_REGEX)) {
                userError.setNameError("Chi bao gom chu!!!");
                checkValidation = false;
            }
            if (email.matches(NUMBER_EMAIL_REGEX)) {
                userError.setEmailError("Not available email");
                checkValidation = false;
            }
            if (!email.matches(EMAIL_REGEX)) {
                userError.setEmailError("Not available email");
                checkValidation = false;
            }
            if (!phone.matches(PHONE_REGEX)) {
                userError.setPhoneError("Not available phone");
                checkValidation = false;
            }
            if (checkValidation) {
                boolean checkInsert = dao.createEmployeeAccount(name, email, password, phone, status, roleID);
                if (checkInsert) {
                    url = SUCCESS;
                } else {
                    userError.setError("Insert fail, unknow error!");
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            log("Error at CreateEmployeeAccountController: " + e.toString());
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
