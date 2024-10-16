/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.google.GoogleAccount;
import isp392.google.GoogleLogin;
import isp392.user.CustomerDTO;
import isp392.user.UserDAO;
import isp392.user.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duyhc
 */
public class LoginGoogleController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "HomeController";
    private static final String ERROR = "signin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = ERROR;
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        HttpSession ses = request.getSession();
        if (code == null || code.isEmpty()) {
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            GoogleLogin gg = new GoogleLogin();
            String accessToken = gg.getToken(code);
            GoogleAccount account = gg.getUserInfo(accessToken);
            request.setAttribute("ACCOUNT_ID", account.getId());
            request.setAttribute("ACCOUNT_NAME", account.getName());
            request.setAttribute("ACCOUNT_EMAIL", account.getEmail());
            String id = account.getId();
            String email = account.getEmail();
            String name = account.getName();
            UserDTO newUser = null;
            CustomerDTO newCust = null;
            UserDAO dao = new UserDAO();
            try {
                if (!dao.checkEmailExisted(email)) {
                    String password = UUID.randomUUID().toString();
                    int roleID = 4;
                    newUser = new UserDTO(0, name, email, password, "", roleID, 1);
                    newCust = new CustomerDTO(0, "", "", "", "", null);
                    boolean checkAdd = dao.addNewUser(newUser, newCust);
                    if (checkAdd) {
                        url = "SendEmailController?email=" + email + "&password=" + password + "&action=RegisterGoogleAccount";
                        request.getRequestDispatcher(url).include(request, response);
                        ses.setAttribute("LOGIN_USER", newUser);
                        System.out.println(newUser);
                        url = SUCCESS;
                    }
                } else {
                    UserDTO user = dao.getUserByGoogleEmail(email);
                    CustomerDTO customer = dao.getCustInfoByID(user.getUserID());
                    newUser = dao.getUserByGoogleEmail(email);
                    ses.setAttribute("LOGIN_USER", newUser);
                    ses.setAttribute("LOGIN_CUSTOMER", customer);
                    url = SUCCESS;
                }
            } catch (Exception e) {
                log("Error at LoginGoogleServler: " + e.toString());
            } finally {
                request.getRequestDispatcher(url).forward(request, response);
            }

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
