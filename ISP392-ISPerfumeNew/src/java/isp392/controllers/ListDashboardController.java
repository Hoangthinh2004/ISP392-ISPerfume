/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.brand.BrandDAO;
import isp392.brand.BrandDTO;
import isp392.order.OrderDAO;
import isp392.order.OrderDTO;
import isp392.product.ProductDAO;
import isp392.product.ProductDTO;
import isp392.promotion.PromotionDAO;
import isp392.promotion.PromotionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anhng
 */
public class ListDashboardController extends HttpServlet {

    private static final String ERROR = "MGR_Dashboard.jsp";
    private static final String SUCCESS = "MGR_Dashboard.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            PromotionDAO dao = new PromotionDAO();
            ProductDAO pDao = new ProductDAO();
            BrandDAO bDao = new BrandDAO();
            OrderDAO oDao = new OrderDAO();
            List<PromotionDTO> listPromotion = dao.countAllPromotion();
            List<ProductDTO> listProduct = pDao.countAllProduct();
            List<BrandDTO> listBrand = bDao.countAllBrand();
            List<OrderDTO> listOrder = oDao.countAllOrder();
            if (listPromotion.size() > 0) {
                if (listProduct.size() > 0) {
                    if (listBrand.size() > 0) {
                        if (listOrder.size() > 0) {
                            request.setAttribute("ALL_PROMOTION", listPromotion);
                            request.setAttribute("ALL_PRODUCT", listProduct);
                            request.setAttribute("ALL_BRAND", listBrand);
                            request.setAttribute("ALL_ORDER", listOrder);
                            url = SUCCESS;
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("Error at ListDashboardController: " + e.toString());
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
