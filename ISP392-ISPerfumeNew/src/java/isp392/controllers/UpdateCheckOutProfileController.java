/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.user.CustomerViewProfileDTO;
import isp392.user.UserDAO;
import isp392.user.UserError;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ThinhHoang
 */
public class UpdateCheckOutProfileController extends HttpServlet {

    private static final String ERROR = "NavigateToCheckOutController";
    private static final String SUCCESS = "NavigateToCheckOutController";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PHONE_REGEX = "^(?:\\+84|0)(3[2-9]|5[6|8|9]|7[0|6|7|8|9]|8[1-9]|9[0-9])[0-9]{7}$";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserDAO userDao = new UserDAO();
        HttpSession ses = request.getSession();
        UserError userErr = new UserError();
        String url = ERROR;

        try {
            // Retrieve updated information from the form
            Map<String, Integer> total = (Map<String, Integer>) ses.getAttribute("TOTAL_PRICE");
            if (total.size() > 0) {
                ses.removeAttribute("TOTAL_PRICE");
            }
            
            boolean checkValidation = true;
            int userID = Integer.parseInt(request.getParameter("userID"));
            String username = request.getParameter("userName");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String area = request.getParameter("area");
            String district = request.getParameter("district");
            String ward = request.getParameter("ward");
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            String phone = request.getParameter("phone");
            //validation
            if (username.length() < 5) {
                userErr.setNameError("User name must have more than 5 characters!");
                checkValidation = false;
            }
            if (!email.matches(EMAIL_REGEX)) {
                userErr.setEmailError("This email is invalid!");
                checkValidation = false;
            }
            if (userDao.checkEmailExistedForUp(email, userID)) {
                userErr.setEmailError("This email has already existed!");
                checkValidation = false;
            }
            if (!phone.matches(PHONE_REGEX)) {
                userErr.setPhoneError("This phone number is invalid!");
                checkValidation = false;
            }
            if (userDao.checkPhoneNumExistedForUp(phone, userID)) {
                userErr.setPhoneError("This phone number has already existed!");
                checkValidation = false;
            }
            if (checkValidation) {
                CustomerViewProfileDTO cust = new CustomerViewProfileDTO(userID, area, district, ward, address, birthday, username, email, "", phone, 0, 1);
                boolean check = userDao.updateCustomerProfile(cust);
                if (check) {
                    CustomerViewProfileDTO newCust = userDao.getCustInfoByUserID(userID);
                    ses.setAttribute("CUSTOMER", newCust);
                    request.setAttribute("MESSAGE", "UPDATED SUCCESSFULLY !");
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("UPDATE_PROFILE_MESSAGE", userErr);
            }
        } catch (Exception e) {
            log("Error at UpdateProfileController: " + e.toString());
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
