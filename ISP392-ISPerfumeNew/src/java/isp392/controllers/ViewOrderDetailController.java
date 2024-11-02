/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.order.OrderDAO;
import isp392.order.OrderDTO;
import isp392.order.OrderDetailDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyhc
 */
@WebServlet(name = "viewOrderDetailController", urlPatterns = {"/viewOrderDetailController"})
public class ViewOrderDetailController extends HttpServlet {

    private static final String ERROR = "viewOrderHistoryController";
    private static final String SUCCESS = "viewOrderDetail.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        OrderDAO dao = new OrderDAO();
        try {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            List<OrderDetailDTO> listOrderDetail = dao.getListOrderDetail(orderID);
            OrderDTO order = dao.getOrder(orderID);
            if( order!= null || listOrderDetail!=null){
                request.setAttribute("ORDER_CUSTOMER", order);
                request.setAttribute("LIST_ORDER_DETAIL_CUSTOMER", listOrderDetail);
                request.setAttribute("ORDERID", orderID);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at viewOrderDetailController: "+e.toString());
        }finally{
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
