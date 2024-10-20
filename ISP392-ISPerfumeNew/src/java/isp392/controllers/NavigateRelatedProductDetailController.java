/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.product.ProductDAO;
import isp392.product.ProductDTO;
import isp392.product.ProductDetailDAO;
import isp392.product.ProductDetailDTO;
import isp392.product.ViewProductDTO;
import isp392.size.SizeDAO;
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
public class NavigateRelatedProductDetailController extends HttpServlet {

    private static final String PRODUCT_DETAIL_PAGE = "productDetail.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = PRODUCT_DETAIL_PAGE;
        try {
            HttpSession session = request.getSession();
            ProductDAO productDAO = new ProductDAO();
            SizeDAO sizeDAO = new SizeDAO();           
            ProductDetailDAO productDetailDAO = new ProductDetailDAO();

            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            int productID = Integer.parseInt(request.getParameter("productID"));
            int sizeID = Integer.parseInt(request.getParameter("sizeID"));
                       
            List<ViewProductDTO> sizeAvailable = sizeDAO.getAvailableSize(productID);
            if (sizeAvailable.size() > 0) {
                session.setAttribute("AVAILABLE_SIZE", sizeAvailable);
            }
            
            List<ProductDetailDTO> listPriceBySize = productDetailDAO.getListPriceBySize(productID, sizeID);
            if (listPriceBySize.size() > 0) {
                session.setAttribute("PRICE_BY_SIZE", listPriceBySize);
            }
            
            List<ProductDetailDTO> listImage = productDetailDAO.getListImage(productID);
            if (listImage.size() > 0) {
                session.setAttribute("LIST_IMAGE", listImage);
            }
            
            List<ProductDTO> productInformation = productDAO.getProductInformation(productID);
            if (productInformation.size() > 0) {
                session.setAttribute("PRODUCT_INFORMATION", productInformation);

                String productName = productInformation.get(0).getName();
                session.setAttribute("PRODUCT_NAME", productName);
            }

            List<ViewProductDTO> listProduct = productDAO.suggestListProduct(categoryID, productID, sizeID);
            if (listProduct.size() > 0) {
                session.setAttribute("SUGGEST_PRODUCT", listProduct);
            }
            
            url = PRODUCT_DETAIL_PAGE;
        } catch (Exception e) {
            log("Error at NavigateRelatedProductDetailController: " + e.toString());
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
