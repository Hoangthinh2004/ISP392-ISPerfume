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
public class checkOrderQuantityController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            CartDAO cartDAO = new CartDAO();
            Cart listChecked = (Cart) session.getAttribute("CHECK_LIST");
            String[] productDetailIDs = request.getParameterValues("productDetailID");
            Map<String, Integer> CustomerIDS = (Map<String, Integer>) session.getAttribute("CUSTOMER_ID");
            Map<String, Integer> promotionIDS = (Map<String, Integer>) session.getAttribute("CUR_PROMOTION");
            
            int paymentID = Integer.parseInt(request.getParameter("payment"));
            int customerID = CustomerIDS.get("customerID");
            int promotionID = 0;
            if (promotionIDS != null) {
                promotionID = promotionIDS.get("promotionID");
            }
            int price = Integer.parseInt(request.getParameter("orderPrice"));

            boolean checkQuanity = false;
            for (ViewCartDTO product : listChecked.getCart().values()) {
                int productDetailID = product.getProductDetailID();
                int quantity = product.getTotalQuantity();
                boolean checkQuantity = cartDAO.checkQuantity(productDetailID, quantity);
                if (!checkQuantity) {
                    checkQuanity = false;
                    break;
                }
                checkQuanity = true;
            }
            if (checkQuanity) {
                StringBuilder productDetailIDParams = new StringBuilder();
                for (String id : productDetailIDs) {
                    if (productDetailIDParams.length() > 0) {
                        productDetailIDParams.append("&");
                    }
                    productDetailIDParams.append("productDetailIDs=").append(id);
                }
                if (paymentID == 2) {
                    url = "ZaloPaymentController?" + "price=" + price + "&customerID=" + customerID + "&promotionID=" + promotionID + "&" + productDetailIDParams.toString();
                } else if (paymentID == 1) {
                    url ="CODCheckOutController";
                }
            }
        } catch (Exception e) {
            log("Error at checkOrderQuantityController: " + e.toString());
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
