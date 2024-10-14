/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.user.CustomerDTO;
import isp392.user.UserDAO;
import isp392.user.UserDTO;
import isp392.user.UserError;
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
@WebServlet(name = "CreateNewUserCustomerController", urlPatterns = {"/CreateNewUserCustomerController"})
public class CreateNewUserCustomerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "signup.jsp";
    private static final String SUCCESS = "signin.jsp";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PHONE_REGEX = "^(?:\\+84|0)(3[2-9]|5[6|8|9]|7[0|6|7|8|9]|8[1-9]|9[0-9])[0-9]{7}$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userErr = new UserError();
        UserDAO dao = new UserDAO();
        boolean checkValidation = true;
        try {
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            String phoneNum = request.getParameter("phoneNum");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirmPassword");
            int status = 1;
            int roleID = 1; // role: customer
            //Validation
            if (userName.length() < 5) {
                userErr.setNameErr("User name must have more than 5 characters!");
                checkValidation = false;
            }
            if (!email.matches(EMAIL_REGEX)) {
                userErr.setEmailErr("This email is invalid!");
                checkValidation = false;
            }
            if (dao.checkEmailExisted(email)) {
                userErr.setEmailErr("This email has already existed!");
                checkValidation = false;
            }
            if (!phoneNum.matches(PHONE_REGEX)) {
                userErr.setPhoneErr("This phone number is invalid!");
                checkValidation = false;
            }
            if (dao.checkPhoneNumExisted(phoneNum)) {
                userErr.setPhoneErr("This phone number has already existed!");
                checkValidation = false;
            }
            if (!confirm.equals(password)) {
                userErr.setConfirmPasswordErr("Confirmation does not match password!");
                checkValidation = false;
            }
            if (checkValidation) {
                    UserDTO user = new UserDTO(0, userName, email, password, phoneNum, roleID, status);
                CustomerDTO cust = new CustomerDTO(0, "", "", "", "", null);
                boolean checkAdd = dao.addNewUser(user, cust);
                if (checkAdd) {
                    url = SUCCESS;
                } else {
                    userErr.setError("Insert failed!");
                }
            } else {
                request.setAttribute("INSERT_USER_CUST_ERROR", userErr);
            }

        } catch (Exception e) {
            log("Error at CreateNewUserCustomerController: " + e.toString());
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
