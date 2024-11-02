/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.order.OrderDAO;
import isp392.order.OrderDTO;
import isp392.order.OrderDetailDTO;
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
@WebServlet(name = "viewOrderHistoryController", urlPatterns = {"/viewOrderHistoryController"})
public class viewOrderHistoryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SUCCESS = "orderStatus.jsp";
    private static final String ERROR = "orderStatus.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        OrderDAO dao = new OrderDAO();
        UserDAO userDAO = new UserDAO();
        HttpSession ses = request.getSession();
        ProductDAO proDAO = new ProductDAO();
        ProductDetailDAO proDeDAO = new ProductDetailDAO();
        SizeDAO sizeDAO = new SizeDAO();
        try {
            int custID = Integer.parseInt(request.getParameter("customerID"));
            List<UserDTO> listUser = userDAO.getListUser();
            List<ProductDTO> listProduct = proDAO.getListProductManager("");
            List<ProductDetailDTO> listProductDetail = proDeDAO.getListAllProductDetail();
            List<SizeDTO> listSize = sizeDAO.getListSize();
            List<OrderDTO> status1 = dao.getListOrderByStatus(custID, 1);
            List<OrderDTO> status2 = dao.getListOrderByStatus(custID, 2);
            List<OrderDTO> status3 = dao.getListOrderByStatus(custID, 3);
            List<OrderDTO> status4 = dao.getListOrderByStatus(custID, 4);
            if (status1 != null || status2 != null || status3 != null ||
                status4 != null || listUser != null || listProduct != null ||
                listProductDetail!=null || listSize!=null) {
                ses.setAttribute("LIST_USER", listUser);
                ses.setAttribute("LIST_PRODUCT", listProduct);
                ses.setAttribute("LIST_PRODUCT_DETAIL", listProductDetail);
                ses.setAttribute("LIST_SIZE", listSize);
                ses.setAttribute("ORDER_STATUS_1", status1);
                ses.setAttribute("ORDER_STATUS_2", status2);
                ses.setAttribute("ORDER_STATUS_3", status3);
                ses.setAttribute("ORDER_STATUS_4", status4);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at viewOrderHistoryController: " + e.toString());
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
