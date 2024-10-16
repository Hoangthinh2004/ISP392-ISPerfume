/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.product.ProductDAO;
import isp392.product.ViewProductDTO;
import java.io.IOException;
import java.util.ArrayList;
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
public class DescendingProductByPriceController extends HttpServlet {

    private static final String CATEGORY = "shopping.jsp";
    private static final String SEARCH = "shoppingSearch.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "";
        HttpSession session = request.getSession();
        Object searchContent = session.getAttribute("CURRENT_SEARCH");
        Object category = session.getAttribute("CURRENT_IDS");
        if (searchContent != null) {
            url = SEARCH;
        } else if (category != null) {
            url = CATEGORY;
        }
        try {
            Map<String, Integer> categoryIDs = (Map<String, Integer>) session.getAttribute("CURRENT_IDS");
            Map<String, Integer> sizeIDS = (Map<String, Integer>) session.getAttribute("SIZE_IDS");
            Map<String, Integer> currentBrandID = (Map<String, Integer>) session.getAttribute("CURRENT_BRANDID");
            ProductDAO productDAO = new ProductDAO();
            List<Integer> sizeIDList = new ArrayList<>();
            List<Integer> brandID = new ArrayList<>();
            
            //Descending in shoppingSearch
            if (searchContent != null) {
                String search = (String) session.getAttribute("CURRENT_SEARCH");               
                if (sizeIDS != null && !sizeIDS.isEmpty()) {
                    int sizeIDLength = sizeIDS.get("sizeID_length");
                    if (sizeIDLength == 2) {
                        sizeIDList.add(sizeIDS.get("sizeID1"));
                        sizeIDList.add(sizeIDS.get("sizeID2"));
                    } else if (sizeIDLength == 1) {
                        sizeIDList.add(sizeIDS.get("sizeID"));
                    }
                }               
                List<ViewProductDTO> listProduct = productDAO.descendingProductByPrice(search, sizeIDList);
                session.setAttribute("LIST_PRODUCT_SEARCH", listProduct);
                url = SEARCH;
                //session.removeAttribute("SIZE_IDS");
            } else { //Descending in Shopping
                int categoryID = categoryIDs.get("categoryID");
                if (currentBrandID != null) {
                    brandID.add(currentBrandID.get("brandID"));
                } if (sizeIDS != null && !sizeIDS.isEmpty()) {
                    int sizeIDLength = sizeIDS.get("sizeID_length");
                    if (sizeIDLength == 2) {
                        sizeIDList.add(sizeIDS.get("sizeID1"));
                        sizeIDList.add(sizeIDS.get("sizeID2"));
                    } else if (sizeIDLength == 1) {
                        sizeIDList.add(sizeIDS.get("sizeID"));
                    }
                }
                
                List<ViewProductDTO> listProduct = productDAO.descendingCategorizeProduct(categoryID, brandID, sizeIDList);
                session.setAttribute("LIST_PRODUCT", listProduct);
                url = CATEGORY;
                //session.removeAttribute("SIZE_IDS");
            }
        } catch (Exception e) {
            log("Error at DescendingProductByPriceController: " + e.toString());
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
