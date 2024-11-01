/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.order.OrderDetailDAO;
import isp392.order.OrderDetailDTO;
import isp392.promotion.PromotionDAO;
import isp392.promotion.PromotionDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anhng
 */
public class SHIPPER_ViewOrderDetailController extends HttpServlet {

    private static final String SUCCESS = "SHIPPER_OrderDetailManagement.jsp";
    private static final String ERROR = "SHIPPER_OrderDetailManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            int promotionID = 1;
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            OrderDetailDAO odDao = new OrderDetailDAO();
            PromotionDAO pDao = new PromotionDAO();
            List<OrderDetailDTO> listOrderDetail = odDao.getListOrderDetail(orderID);
            List<PromotionDTO> listPromotion = pDao.getShipperListPromotion(promotionID);
            if (listOrderDetail.size() > 0) {
                if (listPromotion.size() > 0) {
                    HttpSession session = request.getSession();
                    session.setAttribute("LIST_ORDER_DETAIL", listOrderDetail);
                    session.setAttribute("LIST_PROMOTION", listPromotion);
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at SHIPPER_ViewOrderDetailController: " + e.toString());
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
