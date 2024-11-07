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
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "QuickAddToCartController", urlPatterns = {"/QuickAddToCartController"})
public class QuickAddToCartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "HomeController";
    private static final String SUCCESS = "HomeController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            CartDAO dao = new CartDAO();
            Map<String, Integer> CustomerIDS = (Map<String, Integer>) session.getAttribute("CUSTOMER_ID");
            if (CustomerIDS != null && !CustomerIDS.isEmpty()) {
                int customerID = CustomerIDS.get("customerID");
                int productDetailID = Integer.parseInt(request.getParameter("productDetailID"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                int cartID = dao.getCarID(customerID);

                List<CartDTO> list = dao.checkExistProduct(productDetailID, customerID);
                if (list.size() > 0) {
                    int existQuan = dao.getQuantity(productDetailID, customerID);
                    int newQuantity = quantity + existQuan;

                    CartDetailDTO cartDetail = new CartDetailDTO(cartID, productDetailID, newQuantity);
                    boolean check = dao.updateQuantity(cartDetail, productDetailID);
                    if (check) {
                        int cartSize = dao.getCartSize(customerID);
                        session.setAttribute("CART_SIZE", cartSize);
                        url = SUCCESS;
                    } else {
                        request.setAttribute("MESSAGE", "Add to cart fail");
                    }
                } else {
                    CartDetailDTO cartDetail = new CartDetailDTO(cartID, productDetailID, quantity);
                    boolean check = dao.addToCart(cartDetail);
                    if (check) {
                        request.setAttribute("MESSAGE", "Add to cart successfully");
                    } else {
                        request.setAttribute("MESSAGE", "Add to cart fail");
                    }
                    int cartSize = dao.getCartSize(customerID);
                        session.setAttribute("CART_SIZE", cartSize);
                    url = SUCCESS;
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
