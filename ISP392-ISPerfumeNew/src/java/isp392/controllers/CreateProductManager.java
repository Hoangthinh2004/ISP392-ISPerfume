/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.product.ProductDAO;
import isp392.product.ProductError;
import isp392.product_category.ProductCategoryDAO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author duyhc
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
@WebServlet(name = "CreateProductManager", urlPatterns = {"/CreateProductManager"})
public class CreateProductManager extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = "img";
    private static final String ERROR = "MGR_CreateProduct.jsp";
    private static final String SUCCESS = "MGR_ProductManagement.jsp";
    private static final int IMAGE_WIDTH = 500;
    private static final int IMAGE_HEIGHT = 500;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO dao = new ProductDAO();
        ProductCategoryDAO proCateDao = new ProductCategoryDAO();
        ProductError proErr = new ProductError();
        String url = ERROR;
        boolean validation = true;
        try {
            Part filePart = request.getPart("brandImage");
            String name = request.getParameter("productName");
            int brandID = Integer.parseInt(request.getParameter("brandID"));
            String description = request.getParameter("description");
            String country = request.getParameter("country");
            int releaseYear = Integer.parseInt(request.getParameter("releaaseDate"));
            String fragranceFamilies = request.getParameter("fregranceFamilies");
            int categoryID = Integer.parseInt(request.getParameter("categoryID"));
            int managerID = 4;
            int status = 1;
            if (dao.checkDuplicateByName(name)) {
                proErr.setProductName("THIS PRODUCT'S NAME ALREADY EXISTED");
                validation = false;
            }
            if (validation) {
                String imagePath = "";
                String path = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
                File uploadDir = new File(path);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                imagePath = UPLOAD_DIRECTORY + File.separator + fileName;
                File outputFile = new File(path + File.separator + fileName);

                // Resize the image
                Thumbnails.of(filePart.getInputStream())
                        .size(IMAGE_WIDTH, IMAGE_HEIGHT)
                        .toFile(outputFile);

                filePart.write(path + File.separator + fileName);
                int check = dao.addProduct(name, brandID, managerID, description, country,releaseYear, fragranceFamilies ,imagePath, status);
                if (check != -1) {
                    boolean checkAddProCate = proCateDao.addProCate(check, categoryID);
                    boolean checkAddProCate1 = proCateDao.addProCate(check, 4);
                    if (checkAddProCate) {
                        url = SUCCESS;
                    }
                }
            } else {
                request.setAttribute("ERROR", proErr);
            }
        } catch (IOException | ClassNotFoundException | NumberFormatException | SQLException | ServletException e) {
            log("Error at CreateProductManager: " + e.toString());
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
