/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.role.RoleDTO;
import isp392.user.UserDAO;
import isp392.user.UserDTO;
import isp392.user.UserError;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anhng
 */
@WebServlet(name = "UpdateUserController", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {

    private static final String ERROR = "SearchUserController";
    private static final String SUCCESS = "SearchUserController";

    private static final String EMAIL_REGEX = "^(?=.*[A-Za-z])[A-Za-z0-9+_.-]+@gmail\\.com$";
    private static final String NAME_REGEX = "^[A-Za-z\\s]{5,50}$"; // Chỉ chứa chữ cái và khoảng trắng, độ dài từ 5 đến 50
    private static final String PHONE_REGEX = "^0\\d{9}$"; // Bắt đầu bằng 0 và gồm chính xác 10 chữ số
    private static final String NUMBER_EMAIL_REGEX = "^\\d+@gmail\\.com$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        UserError userError = new UserError();
        boolean checkValidation = true;
        UserDAO dao = new UserDAO();
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            int roleID = Integer.parseInt(request.getParameter("roleID"));

            if (name.isEmpty()) {
                userError.setNameError("Not be empty!!!");
                checkValidation = false;
            }
            if (!name.matches(NAME_REGEX)) {
                userError.setNameError("Not available name");
                checkValidation = false;
            }
            if (email.isEmpty()) {
                userError.setEmailError("Not be empty");
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
            if (phone.isEmpty()) {
                userError.setPhoneError("Not be empty");
                checkValidation = false;
            }
            if (!phone.matches(PHONE_REGEX)) {
                userError.setPhoneError("Not available phone");
                checkValidation = false;
            }
            if (checkValidation) {
                UserDTO user = new UserDTO(userID, name, email, phone, phone, 0, roleID);
                RoleDTO role = new RoleDTO(roleID, name);
                boolean checkUpdate = dao.update(user);
                HttpSession session = request.getSession();
                UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
                if (checkUpdate){
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("UPDATE_USER_ERROR", userError);
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
