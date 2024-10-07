/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.product.ProductDAO;
import isp392.product.ViewProductDTO;
import java.io.IOException;
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
public class SizeFilterController extends HttpServlet {

    private static final String ERROR = "shopping.jsp";
    private static final String SUCCESS_CATEGORY = "shopping.jsp";
    private static final String SUCCESS_SEARCH = "shoppingSearch.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            int sizeID = Integer.parseInt(request.getParameter("sizeID"));
            ProductDAO productDAO = new ProductDAO();

            HttpSession session = request.getSession();
            Map<String, Integer> categoryIDs = (Map<String, Integer>) session.getAttribute("CURRENT_IDS");
            Map<String, Integer> searchIDs = (Map<String, Integer>) session.getAttribute("SEARCH_IDS"); // Get attribute from searchProductController

            if (categoryIDs != null) { // Filter by size from Category 
                int categoryID = categoryIDs.get("categoryID");
                categoryIDs.put("sizeID", sizeID);
                if (session.getAttribute("CURRENT_SEARCH") != null) { // Categorize -> Search -> Filter by size
                    String search = (String) session.getAttribute("CURRENT_SEARCH");
                    searchIDs.put("sizeID", sizeID);
                    List<ViewProductDTO> listProduct = productDAO.filterSearchResultBySize(search, sizeID);
                    int listSize = listProduct.size();
                    request.setAttribute("SEARCH_RESULT_SIZE", listSize);
                    request.setAttribute("LIST_PRODUCT_SEARCH", listProduct);
                    url = SUCCESS_SEARCH;
                } else {
                    if (categoryIDs.containsKey("brandID")) { // Filter by size after filtering by brand
                        int brandID = categoryIDs.get("brandID");
                        List<ViewProductDTO> listProduct = productDAO.filterProductByChildSize(categoryID, brandID, sizeID);
                        request.setAttribute("LIST_PRODUCT", listProduct);
                        //session.removeAttribute("CURRENT_IDS");
                    } else { //Filter by size after categorizing
                        List<ViewProductDTO> listProduct = productDAO.filterProductBySize(sizeID, categoryID);
                        request.setAttribute("LIST_PRODUCT", listProduct);
                    }
                    url = SUCCESS_CATEGORY;
                }
            } else { // Filter by Size from Search result                
                String search = (String) session.getAttribute("CURRENT_SEARCH");
                searchIDs.put("sizeID", sizeID);
                List<ViewProductDTO> listProduct = productDAO.filterSearchResultBySize(search, sizeID);
                int listSize = listProduct.size();
                request.setAttribute("SEARCH_RESULT_SIZE", listSize);
                request.setAttribute("LIST_PRODUCT_SEARCH", listProduct);
                url = SUCCESS_SEARCH;
            }
            //session.setAttribute("CURRENT_IDS", ids); //Store sizeID & categoryID into attribute for DescendingProductByPrice Controller                     
        } catch (Exception e) {
            log("Error at BrandFilterController: " + e.toString());
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
