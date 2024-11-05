/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.order.OrderDAO;
import isp392.order.OrderDTO;
import isp392.order.OrderDetailDAO;
import isp392.order.OrderDetailDTO;
import isp392.product.ProductDAO;
import isp392.product.ProductDTO;
import isp392.product.ProductDetailDAO;
import isp392.product.ProductDetailDTO;
import isp392.promotion.PromotionDAO;
import isp392.promotion.PromotionDTO;
import isp392.size.SizeDAO;
import isp392.size.SizeDTO;
import isp392.user.UserDAO;
import isp392.user.UserDTO;
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
        HttpSession ses = request.getSession();
        UserDAO userDAO = new UserDAO();
        OrderDAO dao = new OrderDAO();
        ProductDAO proDAO = new ProductDAO();
        ProductDetailDAO proDeDAO = new ProductDetailDAO();
        SizeDAO sizeDAO = new SizeDAO();
        PromotionDAO promoDAO = new PromotionDAO();
        try {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            List<UserDTO> listUser = userDAO.getListUser();
            List<OrderDetailDTO> listOrderDetail = dao.getListOrderDetail(orderID);
            List<ProductDTO> listProduct = proDAO.getListProductManager("");
            List<ProductDetailDTO> listProductDetail = proDeDAO.getListAllProductDetail();
            List<SizeDTO> listSize = sizeDAO.getListSize();
            List<PromotionDTO> listPromotion = promoDAO.getListPromotion();
            OrderDTO order = dao.getOrder(orderID);
            if (order != null || listOrderDetail != null || listProduct != null || listProductDetail != null || listSize != null || listPromotion != null || listUser!=null) {
                ses.setAttribute("LIST_PRODUCT", listProduct);
                ses.setAttribute("LIST_PRODUCT_DETAIL", listProductDetail);
                ses.setAttribute("LIST_SIZE", listSize);
                ses.setAttribute("LIST_PROMOTION", listPromotion);
                ses.setAttribute("LIST_USER", listUser);
                request.setAttribute("ORDER_SHIPPER", order);
                request.setAttribute("LIST_ORDER_DETAIL_SHIPPER", listOrderDetail);
                request.setAttribute("ORDERID", orderID);
                url = SUCCESS;

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
