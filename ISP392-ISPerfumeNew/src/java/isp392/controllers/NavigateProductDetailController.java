/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.brand.BrandDAO;
import isp392.brand.BrandDTO;
import isp392.product.ProductDAO;
import isp392.product.ProductDTO;
import isp392.product.ProductDetailDAO;
import isp392.product.ProductDetailDTO;
import isp392.product.ViewProductDetailDTO;
import isp392.size.SizeDAO;
import isp392.size.SizeDTO;
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
public class NavigateProductDetailController extends HttpServlet {

    private static final String ERROR = "shopping.jsp";
    private static final String ERROR_SEARCH = "shoppingSearch.jsp";
    private static final String SUCCESS = "productDetail.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "";
        HttpSession session = request.getSession();
        Object search = session.getAttribute("CURRENT_SEARCH");
        Object category = session.getAttribute("CURRENT_IDS");
        if (search != null) {
            url = ERROR_SEARCH;
        } else if (category != null) {
            url = ERROR;
        }      
        try {
            
            int productID = Integer.parseInt(request.getParameter("productID"));
            int sizeID = Integer.parseInt(request.getParameter("sizeID"));
            
            Map<String, Integer> listProIDs = new HashMap<>();
            listProIDs.put("productID", productID);
            session.setAttribute("CURRENT_PRODUCT_ID", listProIDs); // Storing productID for PriceBySizeController
            
            SizeDAO sizeDAO = new SizeDAO();
            List<SizeDTO> sizeAvailable =  sizeDAO.getAvailableSize(productID);
            if (sizeAvailable.size() > 0) {
                session.setAttribute("AVAILABLE_SIZE", sizeAvailable);
            }
            
            BrandDAO brandDAO = new BrandDAO();
            List<BrandDTO> brand = brandDAO.getBrandByProduct(productID);
            if (brand.size() > 0) {
                int brandID = brand.get(0).getBrandID();
                request.setAttribute("CURRENT_BRAND_ID", brandID);
                
                String brandName = brand.get(0).getName();
                session.setAttribute("BRAND_BY_PRODUCT", brandName);
            }
            
            ProductDetailDAO productDetailDAO = new ProductDetailDAO();
            List<ProductDetailDTO> listPriceBySize = productDetailDAO.getListPriceBySize(productID, sizeID);           
            if (listPriceBySize.size() > 0) {
                request.setAttribute("PRICE_BY_SIZE", listPriceBySize);
            }
                         
            List<ProductDetailDTO> listImage = productDetailDAO.getListImage(productID);
            if (listImage.size() > 0) {
                session.setAttribute("LIST_IMAGE", listImage);
            }
            
            ProductDAO productDAO = new ProductDAO();
            List<ProductDTO> productInformation = productDAO.getProductInformation(productID);
            if (productInformation.size() > 0) {
                session.setAttribute("PRODUCT_INFORMATION", productInformation);
                
                String productName = productInformation.get(0).getName();
                session.setAttribute("PRODUCT_NAME", productName);
                
            }
            url = SUCCESS;            
        } catch (Exception e) {
            log("Error at NavigateProductDetailController" + e.toString());
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
