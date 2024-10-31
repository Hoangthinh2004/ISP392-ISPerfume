/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.order.ShipperOrderDAO;
import isp392.order.ShipperOrderDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anhng
 */
public class SHIPPER_UpdateStatusOrderController extends HttpServlet {

    private static final String SUCCESS = "SHIPPER_SearchOrderController";
    private static final String ERROR = "SHIPPER_SearchOrderController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean checkValidation = true;
        ShipperOrderDAO dao = new ShipperOrderDAO();
        try {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            int orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
            if (checkValidation) {
                ShipperOrderDTO order = new ShipperOrderDTO(0, orderID, "", "", "", "", orderStatus);
                boolean checkUpdateS = dao.updateStatusShipperOrder(order);
                if (checkUpdateS) {
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            log("Error at SHIPPER_UpdateOrderController: " + e.toString());
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
