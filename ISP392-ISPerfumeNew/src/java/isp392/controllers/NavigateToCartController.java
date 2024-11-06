/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.cart.Cart;
import isp392.cart.CartDAO;
import isp392.cart.ViewCartDTO;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
public class NavigateToCartController extends HttpServlet {

    private static final String ERROR = "home.jsp";
    private static final String SUCCESS = "cart.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            CartDAO dao = new CartDAO();           
            Map<String, Integer> CustomerIDS = (Map<String, Integer>) session.getAttribute("CUSTOMER_ID");
            
            Cart listChecked = (Cart) session.getAttribute("CHECK_LIST");
            if (listChecked != null) {
                session.removeAttribute("CHECK_LIST");
            }
            
            Map<String, String[]> productDetailIDS = (Map<String, String[]>) session.getAttribute("PRODUCTDETAILIDS_CHECKLIST");
            if (productDetailIDS == null || productDetailIDS.isEmpty()) {
                productDetailIDS = new HashMap<>();
                session.setAttribute("PRODUCTDETAILIDS_CHECKLIST", productDetailIDS);
            } else {
                session.removeAttribute("PRODUCTDETAILIDS_CHECKLIST");
            }
            
            Object promotion = session.getAttribute("PROMOTION_DETAIL");
            if (promotion != null) {
                session.removeAttribute("PROMOTION_DETAIL");
            }
            
            Map<String, Integer> promotions = (Map<String, Integer>) session.getAttribute("CUR_PROMOTION");
            if (promotions != null) {
                session.removeAttribute("CUR_PROMOTION");
            } 
            
            int customerID = CustomerIDS.get("customerID");           
            List<ViewCartDTO> cartList = dao.getProductDetailID(customerID);
            if (cartList.size() > 0) {
                session.setAttribute("CART", cartList);
            } else {
                request.setAttribute("MESSAGE", "Your cart is empty ! Please select more products to buy");
            }
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at NavigateToCartController: " + e.toString());
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
