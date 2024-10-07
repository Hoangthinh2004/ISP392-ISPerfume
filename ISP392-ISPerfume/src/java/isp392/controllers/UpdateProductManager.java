package isp392.controllers;

import isp392.product.ProductDAO;
import isp392.product.ProductDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateProductManager", urlPatterns = {"/UpdateProductManager"})
public class UpdateProductManager extends HttpServlet {

    private static final String ERROR = "ShowAllProductManager";
    private static final String SUCCESS = "ShowAllProductManager";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            ProductDAO dao = new ProductDAO();
            int productID = Integer.parseInt(request.getParameter("productID"));
            int brandID = Integer.parseInt(request.getParameter("brandID"));
            String productName = request.getParameter("productName");
            String description = request.getParameter("description");
            String existingImage = request.getParameter("existingImage");
            String country = request.getParameter("country");
            String fraganceFamilies = request.getParameter("fragranceFamilies");
            int releaseDate = Integer.parseInt(request.getParameter("releaseDate"));
            int managerID = 4;
            int status=Integer.parseInt(request.getParameter("status"));
            ProductDTO pro = new ProductDTO(productID, managerID, brandID, productName, description, existingImage, country, releaseDate, fraganceFamilies, status);
            boolean checkUpdate = dao.updateProduct(pro);
            if (checkUpdate) {
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at UpdateProductManage: " + e.getMessage());
            e.printStackTrace(); // Ghi lại stack trace để biết thêm thông tin
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
