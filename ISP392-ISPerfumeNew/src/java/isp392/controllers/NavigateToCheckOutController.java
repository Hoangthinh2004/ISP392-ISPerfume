/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.cart.Cart;
import isp392.cart.CartDAO;
import isp392.cart.ViewCartDTO;
import isp392.promotion.PromotionDAO;
import isp392.promotion.PromotionDTO;
import isp392.user.CustomerViewProfileDTO;
import isp392.user.UserDAO;
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
public class NavigateToCheckOutController extends HttpServlet {

    private static final String CHECK_OUT_PAGE = "checkout.jsp";
    private static final String ERROR = "NavigateToCartController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            CartDAO cartDao = new CartDAO();
            UserDAO dao = new UserDAO();
            PromotionDAO promotionDAO = new PromotionDAO();
            Map<String, Integer> total = (Map<String, Integer>) session.getAttribute("TOTAL_PRICE");
            if (total == null || total.size() == 0) {
                total = new HashMap<String, Integer>();
                session.setAttribute("TOTAL_PRICE", total);
            }

            Map<String, String[]> productDetailIDS = (Map<String, String[]>) session.getAttribute("PRODUCTDETAILIDS_CHECKLIST");
            if (productDetailIDS == null || productDetailIDS.size() == 0) {
                productDetailIDS = new HashMap<>();
                session.setAttribute("PRODUCTDETAILIDS_CHECKLIST", productDetailIDS);
            }

            int totalPrice = 0;
            Cart listChecked = (Cart) session.getAttribute("CHECK_LIST");
            if (listChecked == null) {
                listChecked = new Cart();
            }
            Map<String, Integer> CustomerIDS = (Map<String, Integer>) session.getAttribute("CUSTOMER_ID");
            int customerID = CustomerIDS.get("customerID");

            String[] productDetailIDs = new String[0];
            if (productDetailIDS == null || productDetailIDS.size() == 0) {
                productDetailIDs = request.getParameterValues("productDetailID");
                productDetailIDS.put("productDetailID", productDetailIDs);
            } else {
                productDetailIDs = productDetailIDS.get("productDetailID");
            }
            for (int i = 0; i < productDetailIDs.length; i++) {
                List<ViewCartDTO> productInfor = cartDao.getProductInfor(Integer.parseInt(productDetailIDs[i]), customerID);
                for (ViewCartDTO product : productInfor) {
                    ViewCartDTO viewProduct = new ViewCartDTO(
                            customerID,
                            product.getProductDetailID(),
                            product.getProductName(),
                            product.getSizeName(),
                            product.getPrice(),
                            product.getImage(),
                            product.getTotalQuantity()
                    );
                    totalPrice += product.getPrice() * product.getTotalQuantity();
                    total.put("total", totalPrice);
                    listChecked.add(viewProduct);
                }
            }
            List<CustomerViewProfileDTO> custProfile = dao.getPersonalInfor(customerID);
            List<PromotionDTO> listPromotion = promotionDAO.getListPromotion();

            request.setAttribute("TOTAL_PRICE", totalPrice);
            session.setAttribute("PROMOTION", listPromotion);
            session.setAttribute("CHECK_LIST", listChecked);
            session.setAttribute("CUSTOMERINFOR", custProfile);
            url = CHECK_OUT_PAGE;
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
