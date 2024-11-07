/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.brand.BrandDAO;
import isp392.brand.BrandDTO;
import isp392.brand.ViewBrandByCateDTO;
import isp392.cart.CartDAO;
import isp392.category.CategoryDAO;
import isp392.category.CategoryDTO;
import isp392.product.ProductDAO;
import isp392.product.ViewProductDTO;
import isp392.size.SizeDAO;
import isp392.size.SizeDTO;
import java.io.IOException;
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
public class HomeController extends HttpServlet {
    
    private static final String ERROR = "home.jsp";
    private static final String HOME = "home.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            CategoryDAO categoryDAO = new CategoryDAO();
            BrandDAO brandDAO = new BrandDAO();
            SizeDAO sizeDAO = new SizeDAO();
            CartDAO cartDAO = new CartDAO();
            ProductDAO productDAO = new ProductDAO();
            
            Map<String, Integer> IDs = new HashMap<>();   
            session.setAttribute("SIZE_IDS", IDs); //  storing sizeID 
            
            Map<String, Integer> ids = new HashMap<>();
            session.setAttribute("CURRENT_IDS", ids); //set attribute to Category Controller
            
            Map<String, Integer> home = new HashMap<>();
            session.setAttribute("HOME", home);
            
            Map<String, Integer> sizeIDS = (Map<String, Integer>) session.getAttribute("SIZE_IDS");
            if (sizeIDS != null && !sizeIDS.isEmpty()) {
                session.removeAttribute("SIZE_IDS");
            }
            
            Map<String, Integer> brandIDS = (Map<String, Integer>) session.getAttribute("CURRENT_BRANDID");
            if (brandIDS != null && !brandIDS.isEmpty()) {
                session.removeAttribute("CURRENT_BRANDID");
            }
            
            Map<String, Integer> CustomerIDS = (Map<String, Integer>) session.getAttribute("CUSTOMER_ID"); 
            if (CustomerIDS != null && !CustomerIDS.isEmpty()) {
                int customerID = CustomerIDS.get("customerID");
                int cartSize = cartDAO.getCartSize(customerID);
                session.setAttribute("CART_SIZE", cartSize);
            }
            
            List<CategoryDTO> listCategory = categoryDAO.getListCategory();
            List<BrandDTO> listBrand = brandDAO.getListBrand();
            List<SizeDTO> listSize = sizeDAO.getListSize();
            List<ViewBrandByCateDTO> listBrandByCate = brandDAO.getBrandByCate();
            List<ViewProductDTO> listProduct = productDAO.getListFeaturedProduct();
            List<ViewProductDTO> listProductRecent = productDAO.getListProductRecent();
            session.setAttribute("LIST_FEATURED_PRODUCT", listProduct);                
            session.setAttribute("LIST_SIZE", listSize);
            session.setAttribute("LIST_CATEGORY", listCategory);
            session.setAttribute("LIST_BRAND", listBrand);
            session.setAttribute("LIST_BRAND_BY_CATE", listBrandByCate);
            session.setAttribute("LIST_PRODUCT_RECENT", listProductRecent);
            url = HOME;
        } catch (Exception e) {
            log("Error at HomeController: " + e.toString());
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
