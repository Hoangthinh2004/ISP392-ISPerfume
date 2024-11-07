/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.order.OrderDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duyhc
 */
@WebServlet(name = "AssignShipperStaffController", urlPatterns = {"/AssignShipperStaffController"})
public class AssignShipperStaffController extends HttpServlet {

    private static final String ERROR = "ShowAllOrderStaffController";
    private static final String SUCCESS = "ShowAllOrderStaffController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        OrderDAO dao = new OrderDAO();
        try {
            int shipperID = Integer.parseInt(request.getParameter("shipperID"));
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            String email = request.getParameter("email");
            boolean checkAssign = dao.assignShipper(orderID,shipperID);
            if(checkAssign){
                request.setAttribute("ASSIGN_SUCCESS", "ASSIGNED ORDER SUCCESSFULLY!");
                url="SendEmailController?email="+email+"&orderID="+orderID+"&action=ConfirmEmail";
                request.getRequestDispatcher(url).include(request, response);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at AssignShipperStaffController: "+e.toString());
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
