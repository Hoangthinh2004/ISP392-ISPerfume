/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.promotion.PromotionDAO;
import isp392.promotion.PromotionDTO;
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
public class ApplyVoucherController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "checkout.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            PromotionDAO promotionDAO = new PromotionDAO();
            Map<String, Integer> promotions = new HashMap<>();
            session.setAttribute("CUR_PROMOTION", promotions);

            int promotionID = Integer.parseInt(request.getParameter("promotionID"));
            promotions.put("promotionID", promotionID);
            int finalPrice = 0;
            List<PromotionDTO> promotion = promotionDAO.getDetail(promotionID);

            Map<String, Integer> total = (Map<String, Integer>) session.getAttribute("TOTAL_PRICE");
            int price = total.get("total");
            for (PromotionDTO promo : promotion) {
                finalPrice = price - (price*promo.getDiscountPer()/100);
            }
            
            session.setAttribute("CUR_PROMOTION", promotions);
            request.setAttribute("FINAL_PRICE", finalPrice);
            session.setAttribute("PROMOTION_DETAIL", promotion);
            url = SUCCESS;
        } catch (Exception e) {
            log("Error at ApplyVoucherController: " + e.toString());
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
