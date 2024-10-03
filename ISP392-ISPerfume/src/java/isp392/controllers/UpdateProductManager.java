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

    private static final String UPLOAD_DIRECTORY = "img";
    private static final String ERROR = "ShowAllProductManager";
    private static final String SUCCESS = "ShowAllProductManager";
    private static final int IMAGE_WIDTH = 500;
    private static final int IMAGE_HEIGHT = 500;

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
            int managerID = 4;
//            Part filePart = request.getPart("file");
//            String imagePath = "";
//            String path = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
//            File uploadDir = new File(path);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//            String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//            imagePath = UPLOAD_DIRECTORY + File.separator + fileName;
//            File outputFile = new File(path + File.separator + fileName);
//            Thumbnails.of(filePart.getInputStream())
//                    .size(IMAGE_WIDTH, IMAGE_HEIGHT)
//                    .toFile(outputFile);
//
//            filePart.write(path + File.separator + fileName);
            //boolean status = Boolean.parseBoolean(request.getParameter("status"));
            int status = Integer.parseInt(request.getParameter("status"));
            ProductDTO pro = new ProductDTO(productID, managerID, brandID, productName, description, existingImage, status);
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
