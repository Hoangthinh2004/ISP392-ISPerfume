/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.brand.BrandDAO;
import isp392.brand.BrandDTO;
import isp392.category.CategoryDAO;
import isp392.category.CategoryDTO;
import isp392.size.SizeDAO;
import isp392.size.SizeDTO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author duyhc
 */
@WebServlet(name = "GetBrandCategoriesManager", urlPatterns = {"/GetBrandCategoriesManager"})
public class GetBrandCategoriesManager extends HttpServlet {

    private static final String ERROR = "MGR_ProductManagement.jsp";
    private static final String SUCCESS = "MGR_ProductManagement.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        BrandDAO brandDAO = new BrandDAO();
        CategoryDAO cateDAO = new CategoryDAO();
        SizeDAO sizeDAO = new SizeDAO();
        try {
            List<BrandDTO> brandList = brandDAO.getListBrand();
            List<CategoryDTO> cateList = cateDAO.getListCategory();
            List<SizeDTO> sizeList = sizeDAO.getListSize();
            if (brandList != null || cateList!=null ||sizeList!=null) {
                HttpSession ses = request.getSession();
                ses.setAttribute("BRAND_LIST_MANAGER", brandList);
                ses.setAttribute("CATEGORY_LIST_MANAGER", cateList);
                ses.setAttribute("SIZE_LIST_MANAGER", sizeList);
                url = SUCCESS;
            }
        } catch (ClassNotFoundException | SQLException e) {
            log("Error at GetBrandControllerManager: " + e.toString());
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
