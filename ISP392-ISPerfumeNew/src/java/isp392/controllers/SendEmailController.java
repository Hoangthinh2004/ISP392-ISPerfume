/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyhc
 */
public class SendEmailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS_SEND_MAIL_GOOGLE_USER = "LoginGoogleServlet";
    private static final String REGISTER_GOOGLE_ACCCOUNT = "RegisterGoogleAccount";
    private static final String FORGOT_PASSWORD_EMAIL = "ForgotPasswordEmail";
    private static final String ERROR = "signin.jsp";
    private static final String SUCCESS_FORGOT_PASSWORD_EMAIL = "ForgotPasswordController";
    private static final String CONFIRM_EMAIL = "ConfirmEmail";
    private static final String SUCCESS_CONFIRM_EMAIL = "AssignShipperStaffController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String action = request.getParameter("action");
        try {
            if (REGISTER_GOOGLE_ACCCOUNT.equals(action)) {
                url = createGoogleUser(request, response);
            } else if (FORGOT_PASSWORD_EMAIL.equals(action)) {
                url = sendEmailForgotPassword(request, response);
            } else if (CONFIRM_EMAIL.equals(action)) {
                url = sendEmailConfirm(request, response);
            }
        } catch (Exception e) {
            log("Error at SendMailController: " + e.toString());
        } finally {
            response.sendRedirect(url);
        }
    }

    private boolean sendEmail(String to, String messageBody, String subject, boolean html) {
        final String FROM_EMAIL = "isperfume1803@gmail.com";
        final String PASSWORD = "rnxf gfef mbrn xjqg";
        Properties properties = new Properties();
        boolean check = false;
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, PASSWORD);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            if (html) {
                message.setContent(messageBody, "text/html; charset=utf-8");
            } else {
                message.setText(messageBody);
            }
            Transport.send(message);
            check = true;
        } catch (MessagingException e) {
            log("Error at SendEmailController: " + e.toString());
            check = false;
        }
        return check;
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

    private String createGoogleUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String subject = "Successfully registered account by ISSPERFUME";
        String messageBody = "Hi, welcome to ISPERFUME <br><br>"
                + "From now on you can login with your Google account or with our account.<br><br>"
                + "Here is your ACCOUNT INFORMATION: <br>"
                + "<b>Email</b>: " + email + "<br>"
                + "<b>Password</b>: " + password + "<br><br>"
                + "Wishing you a great shopping experience !!<br>";
        boolean result = sendEmail(email, messageBody, subject, true);
        if (result) {
            return SUCCESS_SEND_MAIL_GOOGLE_USER;
        } else {
            return ERROR;
        }
    }

    private String sendEmailForgotPassword(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String token = request.getParameter("token");
        String subject = "RESET PASSWORD - ISPerfume";
        String messageBody = "Hi, welcome back to ISPERFUME <br><br>"
                + "Please verify with OTP code <br><br>"
                + "Your OTP code: " + token + "<br><br>"
                + "Please enter your OTP code to change password!";
        boolean result = sendEmail(email, messageBody, subject, true);
        if (result) {
            return SUCCESS_FORGOT_PASSWORD_EMAIL;
        } else {
            return ERROR;
        }
    }

    private String sendEmailConfirm(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String orderID = request.getParameter("orderID");
        String subject = "SUCCESSFULLY CONFIRM - ISPerfume";
        String messageBody = "Hi, welcome back to ISPERFUME <br><br>"
                + "Your order has been confirmed <br><br>"
                + "Your Order ID : " + orderID + "<br><br>"
                + "Thank you for choosing and trusting us!";
        boolean result = sendEmail(email, messageBody, subject, true);
        if (result) {
            return SUCCESS_CONFIRM_EMAIL;
        } else {
            return ERROR;
        }
    }
}
