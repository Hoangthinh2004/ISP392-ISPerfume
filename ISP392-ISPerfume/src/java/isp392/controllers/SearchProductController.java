/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.product.ProductDAO;
import isp392.product.ViewProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
public class SearchProductController extends HttpServlet {

    private static final String HOME ="HomeController";
    private static final String CATEGORY ="shopping.jsp";
    private static final String SUCCESS = "shoppingSearch.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        HttpSession session = request.getSession();
        Object category = session.getAttribute("CURRENT_IDS");
        if (category != null) {
            url = CATEGORY;
        } else {
            url = HOME;
        }
        try {
            String search = request.getParameter("search");
            session.setAttribute("CURRENT_SEARCH", search); //Store search key and send to size filter and sort function
            
            ProductDAO productDAO = new ProductDAO();
            List<ViewProductDTO> listProduct = productDAO.getListProduct(search);
            int listSize = listProduct.size();
            
            Map<String, Integer> sizeIDS = (Map<String, Integer>) session.getAttribute("SIZE_IDS");
            if (sizeIDS != null && !sizeIDS.isEmpty()) {
                session.removeAttribute("SIZE_IDS");
            }
            
            session.setAttribute("SEARCH_RESULT_SIZE", listSize); // show number of perfume
            session.setAttribute("LIST_PRODUCT_SEARCH", listProduct);
                       
            url = SUCCESS;     
        } catch (Exception e) {
            log("Error at SearchProductController: " + e.toString());
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
