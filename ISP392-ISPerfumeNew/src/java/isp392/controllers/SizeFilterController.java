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
public class SizeFilterController extends HttpServlet {

    private static final String ERROR = "shopping.jsp";
    private static final String SUCCESS = "shopping.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            ProductDAO productDAO = new ProductDAO();
            Map<String, Integer> listProductID = new HashMap<>();

            session.setAttribute("SIZE_IDS", listProductID); //  storing sizeID for sort by function 
            Map<String, Integer> currentCategoryID = (Map<String, Integer>) session.getAttribute("CURRENT_IDS"); // get categoryID exist or not
            Map<String, Integer> currentBrandID = (Map<String, Integer>) session.getAttribute("CURRENT_BRANDID"); // // check brandID exist or not
            Map<String, Integer> currentSizeID = (Map<String, Integer>) session.getAttribute("SIZE_IDS"); //get sizeID and move to sort function

            String[] sizeIDs = request.getParameterValues("sizeID[]");
            int categoryID = currentCategoryID.get("categoryID");

            currentSizeID.put("sizeID_length", sizeIDs.length); //send length of sizeID to sort by  function

            List<Integer> sizeList = new ArrayList<>();
            int sizeIDLength = sizeIDs.length;
            String Error = "";
            
            if (currentBrandID == null || currentBrandID.size() == 0) {
                if (sizeIDLength == 2) {
                    sizeList.add(Integer.parseInt(sizeIDs[0]));
                    sizeList.add(Integer.parseInt(sizeIDs[1]));

                    currentSizeID.put("sizeID1", Integer.parseInt(sizeIDs[0]));
                    currentSizeID.put("sizeID2", Integer.parseInt(sizeIDs[1]));
                } else if (sizeIDLength == 1) {
                    sizeList.add(Integer.parseInt(sizeIDs[0]));

                    currentSizeID.put("sizeID", Integer.parseInt(sizeIDs[0]));
                }
                List<ViewProductDTO> listProduct = productDAO.filterListProduct(categoryID, sizeList);
                if (listProduct.isEmpty()) {
                    Error = "None of product";
                }
                session.setAttribute("LIST_PRODUCT", listProduct);
            } else {
                int brandID = currentBrandID.get("brandID");
                if (sizeIDLength == 2) {
                    sizeList.add(Integer.parseInt(sizeIDs[0]));
                    sizeList.add(Integer.parseInt(sizeIDs[1]));

                    currentSizeID.put("sizeID1", Integer.parseInt(sizeIDs[0]));
                    currentSizeID.put("sizeID2", Integer.parseInt(sizeIDs[1]));
                } else if (sizeIDLength == 1) {
                    sizeList.add(Integer.parseInt(sizeIDs[0]));
                    
                    currentSizeID.put("sizeID", Integer.parseInt(sizeIDs[0]));
                }
                List<ViewProductDTO> listProduct = productDAO.filterListProductBrandID(categoryID, brandID, sizeList);
                if (listProduct.isEmpty()) {
                    Error = "None of product";
                }
                session.setAttribute("LIST_PRODUCT", listProduct);
            }
            request.setAttribute("MESSAGE", Error);
            url = SUCCESS;
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
