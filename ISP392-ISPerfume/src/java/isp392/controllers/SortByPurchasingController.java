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
public class SortByPurchasingController extends HttpServlet {

    private static final String ERROR = "shopping.jsp";
    private static final String SUCCESS = "shopping.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            ProductDAO productDAO = new ProductDAO();
            HttpSession session = request.getSession();
            Map<String, Integer> categoryIDs = (Map<String, Integer>) session.getAttribute("CURRENT_IDS");

            if (categoryIDs != null) { // Sort in Category
                int categoryID = categoryIDs.get("categoryID");
                
                if (categoryIDs.containsKey("brandID") && categoryIDs.containsKey("sizeID")) {
                    int brandID = categoryIDs.get("brandID");
                    int sizeID = categoryIDs.get("sizeID");
                    List<ViewProductDTO> listProduct = productDAO.sortByPurchasing(categoryID, brandID, sizeID);
                    request.setAttribute("LIST_PRODUCT", listProduct);
                } else if (categoryIDs.containsKey("brandID")) {
                    int brandID = categoryIDs.get("brandID");
                    List<ViewProductDTO> listProduct = productDAO.sortbyPurchasing2(categoryID, brandID);
                    request.setAttribute("LIST_PRODUCT", listProduct);
                } else if (categoryIDs.containsKey("sizeID")) {
                    int sizeID = categoryIDs.get("sizeID");
                    List<ViewProductDTO> listProduct = productDAO.sortbyPurchasing3(categoryID, sizeID);
                    request.setAttribute("LIST_PRODUCT", listProduct);
                } else {
                    List<ViewProductDTO> listProduct = productDAO.sortByPurchasingAll(categoryID);
                    request.setAttribute("LIST_PRODUCT", listProduct);
                }
                url = SUCCESS;
            } else { //sort in Search result

            }

        } catch (Exception e) {
            log("Error at SortByPurchasingController: " + e.toString());
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
