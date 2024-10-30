/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import isp392.cart.Cart;
import isp392.cart.CartDAO;
import isp392.cart.CartDetailDTO;
import isp392.cart.ViewCartDTO;
import isp392.order.OrderDAO;
import isp392.order.OrderDTO;
import isp392.order.OrderDetailDTO;
import isp392.user.CustomerViewProfileDTO;
import isp392.user.UserDAO;
import java.io.IOException;
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
public class checkOutController extends HttpServlet {

    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "NavigateToCartController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession session = request.getSession();
            CartDAO cartDAO = new CartDAO();
            UserDAO userDAO = new UserDAO();
            OrderDAO orderDAO = new OrderDAO();

            Map<String, Integer> promo = (Map<String, Integer>) session.getAttribute("CUR_PROMOTION");
            Cart listChecked = (Cart) session.getAttribute("CHECK_LIST");
            String ErrorMessage = "";
            int cartID = 0;
            int customerID = 0;

            //Check quantity in store
            boolean checkQuanity = false;
            int totalPrice = 0;
            for (ViewCartDTO product : listChecked.getCart().values()) {
                int price = product.getPrice();
                int productDetailID = product.getProductDetailID();
                int quantity = product.getTotalQuantity();
                cartID = cartDAO.getCarID(product.getCustomerID());
                customerID = product.getCustomerID();
                totalPrice += price * quantity;
                boolean checkQuantity = cartDAO.checkQuantity(productDetailID, quantity);
                if (!checkQuantity) {
                    ErrorMessage += "Error at checking quantity of " + product.getProductName() + " " + product.getSizeName();
                    checkQuanity = true;
                    break;
                }
            }
            if (checkQuanity) {
                ErrorMessage += "\nThe quantity of this perfume in my store is not enough for your order";
                request.setAttribute("CHECKOUT_MESSAGE", ErrorMessage);
            } else {

                //create order
                boolean checkCreateOrder = false;
                int orderID = 0;
                String note = "";
                if (!checkQuanity) {
                    int staffID = userDAO.getstaffID();
                    int promotionID = 0;
                    if (promo == null || promo.isEmpty()) {
                        promotionID = 0;
                    } else {
                        promotionID = promo.get("promotionID");
                    }
                    List<CustomerViewProfileDTO> custProfile = userDAO.getPersonalInfor(customerID);
                    for (CustomerViewProfileDTO customer : custProfile) {
                        String city = customer.getArea();
                        String district = customer.getDistrict();
                        String ward = customer.getWard();
                        String address = customer.getDetailAddress();
                        String phone = customer.getPhone();
                        int orderStatus = customer.getStatus();
                        OrderDTO order = new OrderDTO(0, cartID, staffID, 0, promotionID, customerID, null, orderStatus, city, district, ward, address, phone, note);
                        orderID = orderDAO.createOrder(order);
                        if (orderID > 0) {
                            checkCreateOrder = true;
                        }
                        if (orderID == 0) {
                            request.setAttribute("CHECKOUT_MESSAGE", "fail to create order");
                        }
                    }
                }

                //create orderDetail
                boolean checkCreateOrderDetail = false;
                if (checkCreateOrder) {
                    for (ViewCartDTO product : listChecked.getCart().values()) {
                        int productDeID = product.getProductDetailID();
                        int quan = product.getTotalQuantity();
                        int proPrice = product.getPrice();
                        checkCreateOrderDetail = orderDAO.createOrderDetail(orderID, productDeID, quan, proPrice);
                    }

                    if (!checkCreateOrderDetail) {
                        request.setAttribute("CHECKOUT_MESSAGE", "fail to create order");
                    }
                }

                //update quantity in product Detail
                boolean checkUpdateQuanriry = false;
                if (checkCreateOrderDetail) {
                    for (ViewCartDTO product : listChecked.getCart().values()) {
                        int productDetailID = product.getProductDetailID();
                        int quantity = product.getTotalQuantity();
                        checkUpdateQuanriry = orderDAO.updateQuantity(productDetailID, quantity);
                    }
                    if (!checkUpdateQuanriry) {
                        request.setAttribute("CHECKOUT_MESSAGE", "Fail to update quantity");
                    }
                }

                //remove cart & send message
                boolean checkRemove = false;
                if (checkCreateOrder && checkCreateOrderDetail && checkUpdateQuanriry) {
                    for (ViewCartDTO product : listChecked.getCart().values()) {
                        boolean checkDeteleCartDetail = cartDAO.deleteCartDetail(cartID, product.getProductDetailID());
                        if (checkDeteleCartDetail) {
                            checkRemove = true;
                        }
                    }
                    if (checkRemove) {
                        request.setAttribute("CHECKOUT_MESSAGE", "Order successfully!");
                        session.removeAttribute("CHECK_LIST");
                        url = SUCCESS;
                    }
                }
            }
        } catch (Exception e) {
            log("Error at checkOutController: " + e.toString());
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
