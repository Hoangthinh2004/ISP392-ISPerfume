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
import isp392.size.SizeDAO;
import isp392.size.SizeDTO;
import isp392.user.UserDAO;
import isp392.user.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "GetAllInfoForOrder", urlPatterns = {"/GetAllInfoForOrder"})
public class GetAllInfoForOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "ShowAllOrderStaffController";
    private static final String SUCCESS = "ShowAllOrderStaffController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession ses =request.getSession();
        String url = ERROR;
        UserDAO dao = new UserDAO();
        ProductDetailDAO proDeDAO = new ProductDetailDAO();
        ProductDAO proDAO = new ProductDAO();
        SizeDAO sizeDAO = new SizeDAO();
        try {      
            List<UserDTO> listUser = dao.getListUser();
            List<ProductDetailDTO> listProDe = proDeDAO.getListAllProductDetail();
            List<ProductDTO> listPro = proDAO.getListProductManager("");
            List<SizeDTO> listSize = sizeDAO.getListSize();
            if (listUser != null || listProDe!=null || listPro!=null || listSize!=null) {
                ses.setAttribute("LIST_USER_STAFF", listUser);
                ses.setAttribute("LIST_PRODUCT_DETAIL_STAFF", listProDe);
                ses.setAttribute("LIST_PRODUCT_STAFF", listPro);
                ses.setAttribute("LIST_SIZE_STAFF", listSize);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at GetAllInfoForOrder: " + e.toString());
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
