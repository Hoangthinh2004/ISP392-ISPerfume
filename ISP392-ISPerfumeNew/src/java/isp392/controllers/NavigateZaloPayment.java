/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.cart.Cart;
import java.io.IOException;
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
@WebServlet(name = "chooseController", urlPatterns = {"/chooseController"})
public class NavigateZaloPayment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int status = Integer.parseInt(request.getParameter("status"));
        if (status == 1) {
            String[] productDetailIDs = request.getParameterValues("productDetailIDs");
            int promotionID = Integer.parseInt(request.getParameter("promotionID"));
            int customerID = Integer.parseInt(request.getParameter("customerID"));
            int price = Integer.parseInt(request.getParameter("price"));
            
            StringBuilder productDetailIDParams = new StringBuilder();
                for (String id : productDetailIDs) {
                    if (productDetailIDParams.length() > 0) {
                        productDetailIDParams.append("&");
                    }
                    productDetailIDParams.append("productDetailIDs=").append(id);
                }
            response.sendRedirect("checkOutController?price="+price+"&customerID="+customerID+"&promotionID="+promotionID+"&"+productDetailIDParams.toString());
            // update quantity 
        }else{
            // tra ve trang that bai 
            response.sendRedirect("fail.jsp");
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
