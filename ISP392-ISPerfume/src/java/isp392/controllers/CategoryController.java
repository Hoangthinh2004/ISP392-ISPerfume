/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.product.ProductDAO;
import isp392.product.ProductDTO;
import isp392.product.ProductDetailDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ThinhHoang
 */
public class CategoryController extends HttpServlet {

    private static final String ERROR ="home.jsp";
    private static final String SUCCESS ="shopping.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url=ERROR;
        try {
            HttpSession session = request.getSession();
            String category = request.getParameter("Category");
            ProductDAO productDAO = new ProductDAO();           
            List<ProductDTO> listProduct = productDAO.getListProductByCategory(category);
            
            List<ProductDetailDTO> highestPrice = new ArrayList<>();
            List<ProductDetailDTO> lowestPrice = new ArrayList<>();
            
            for (ProductDTO product : listProduct) {
                String productID = String.valueOf(product.getProductID());
            
            List<ProductDetailDTO> highestPriceForProduct = productDAO.getHightestPrice(productID);
            List<ProductDetailDTO> lowestPriceForProduct = productDAO.getLowestPrice(productID);
            
            highestPrice.addAll(highestPriceForProduct);
            lowestPrice.addAll(lowestPriceForProduct);        
            }
            
            session.setAttribute("LIST_PRODUCT_BY_CATEGORY", listProduct);
            request.setAttribute("HIGHEST_PRICE", highestPrice);
            request.setAttribute("LOWEST_PRICE", lowestPrice);
            url = SUCCESS;
            
        } catch (Exception e) {
            log("Error at CategoryController: " + e.toString());
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
