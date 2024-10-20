/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.promotion.PromotionDAO;
import isp392.promotion.PromotionDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author anhng
 */
@WebServlet(name = "UpdatePromotionController", urlPatterns = {"/UpdatePromotionController"})
public class UpdatePromotionController extends HttpServlet {

    private static final String ERROR = "ManagePromotionController";
    private static final String SUCCESS = "ManagePromotionController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        PromotionDAO dao = new PromotionDAO();
        try {
            int promotionID = Integer.parseInt(request.getParameter("promotionID"));
            String promotionName = request.getParameter("promotionName");
            String description = request.getParameter("description");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            int discountPer = Integer.parseInt(request.getParameter("discountPer"));
            int condition = Integer.parseInt(request.getParameter("condition"));
            int status = Integer.parseInt(request.getParameter("status"));
            int managerID = 4;
            
//            LocalDate stdate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//            LocalDate edDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));        
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilStDate = formatter.parse(startDate);
            java.util.Date utilEnDate = formatter.parse(endDate);

            Date sqlStDate = new Date(utilStDate.getTime());
            Date sqlEnDate = new Date(utilEnDate.getTime());
           
           
           PromotionDTO promotion = new PromotionDTO(promotionID, managerID, promotionName, description, sqlStDate, sqlEnDate, discountPer, condition, status);
                    
           boolean checkUpdate = dao.update(promotion);
           HttpSession session = request.getSession();
            if (checkUpdate) {                             
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at UpdatePromotionController: " +e.toString());
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
