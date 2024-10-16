/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.cart.CartDAO;
import isp392.cart.CartDTO;
import isp392.cart.CartDetailDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThinhHoang
 */
public class AddToCartController extends HttpServlet {

    private static final String ERROR = "productDetail.jsp";
    private static final String SUCCESS = "productDetail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            CartDAO dao = new CartDAO();
            
            int productDetailID = Integer.parseInt(request.getParameter("productDetailID"));
            int customerID = 5;
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int cartID = dao.getCarID(customerID);

            List<CartDTO> list = dao.checkExistProduct(productDetailID, customerID);
            if (list.size() > 0) {
                int existQuan = dao.getQuantity(productDetailID, customerID);
                int newQuantity = quantity + existQuan;
                
                CartDetailDTO cartDetail = new CartDetailDTO(cartID, productDetailID, newQuantity);
                boolean check = dao.updateQuantity(cartDetail, productDetailID);
                if (check) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("MESSAGE", "Add to cart fail");
                }
            } else {
                CartDetailDTO cartDetail = new CartDetailDTO(cartID, productDetailID, quantity);
                boolean check = dao.addToCart(cartDetail);
                if (check) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("MESSAGE", "Add to cart fail");
                }
            }
        } catch (Exception e) {
            log("Error at AddToCartController" + e.toString());
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
