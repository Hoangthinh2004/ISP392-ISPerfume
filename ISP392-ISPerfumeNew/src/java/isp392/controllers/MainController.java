/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ThinhHoang
 */
public class MainController extends HttpServlet {

    private static final String HOME_PAGE = "HomeController";

    private static final String NAVIGATE_CATEGORY = "Category";
    private static final String NAVIGATE_CATEGORY_CONTROLLER = "CategoryController";

    private static final String FILTER_BY_BRAND = "FilterByBrand";
    private static final String FILTER_BY_BRAND_CONTROLLER = "BrandFilterController";

    private static final String SHOW_ALL_PRODUCT_MANAGER = "Search product";
    private static final String SHOW_ALL_PRODUCT_MANAGER_CONTROLLER = "ShowAllProductManager";

    private static final String UPDATE_PRODUCT_MANAGER = "Update";
    private static final String UPDATE_PRODUCT_MANAGER_CONTROLLER = "UpdateProductManager";

    private static final String CREATE_PRODUCT_MANAGER = "Create";
    private static final String CREATE_PRODUCT_MANAGER_CONTROLLER = "CreateProductManager";

    private static final String DELETE_PRODUCT_MANAGER = "Delete Product";
    private static final String DELETE_PRODUCT_MANAGER_CONTROLLER = "DeleteProductManager";

    private static final String DESCENDING_SORT_BY_PRICE = "DescendingSortByPrice";
    private static final String DESCENDING_SORT_BY_PRICE_CONTROLLER = "DescendingProductByPriceController";

    private static final String PRODUCT_PAGE = "Manage_Product_Page";
    private static final String PRODUCT_PAGE_VIEW = "GetBrandCategoriesManager";

    private static final String ASCENDING_SORT_BY_PRICE = "AscendingSortByPrice";
    private static final String ASCENDING_SORT_BY_PRICE_CONTROLLER = "AscendingProductByPriceController";

    private static final String PRODUCT_DETAIL_PAGE = "ProductDetailPage";
    private static final String PRODUCT_DETAIL_PAGE_VIEW = "SearchProductDetailManager";

    private static final String FILTER_BY_SIZE = "ViewResultInShopping";
    private static final String FILTER_BY_SIZE_CONTROLLER = "SizeFilterController";

    private static final String FILTER_BY_SIZE_2 = "ViewResultInShoppingSearch";
    private static final String FILTER_BY_SIZE_CONTROLLER_2 = "SizeFilterSearchController";

    private static final String SEARCH_PRODUCT = "SeacrhProduct";
    private static final String SEARCH_PRODUCT_CONTROLLER = "SearchProductController";

    private static final String VIEW_PROMOTION = "ViewPromotion";
    private static final String VIEW_PROMOTION_CONTROLLER = "ManagePromotionController";

    private static final String CREATE_PROMOTION = "CreatePromotion";
    private static final String CREATE_PROMOTION_CONTROLLER = "CreatePromotionController";

    private static final String UPDATE_PROMOTION = "UpdatePromotion";
    private static final String UPDATE_PROMOTION_CONTROLLER = "UpdatePromotionController";

    private static final String NAVIGATE_PRODUCT_DETAIL = "NavigateProductDetail";
    private static final String NAVIGATE_PRODUCT_DETAIL_CONTROLLER = "NavigateProductDetailController";

    private static final String SHOW_PRICE_BY_SIZE = "PriceBySize";
    private static final String SHOW_PRICE_BY_SIZE_CONTROLLER = "PriceBySizeController";

    private static final String UPDATE_PRODUCT_DETAIL_MANAGER = "UpdateProductDetail";
    private static final String UPDATE_PRODUCT_DETAIL_MANAGER_CONTROLLER = "UpdateProductDetailManager";

    private static final String DELETE_PRODUCT_DETAIL_MANAGER = "DeleteProductDetail";
    private static final String DELETE_PRODUCT_DETAIL_MANAGER_CONTROLLER = "DeleteProductDetailManager";

    private static final String SORT_BY_PURCHASING = "SortByPurchasing";
    private static final String SORT_BY_PURCHASING_CONTROLLER = "SortByPurchasingController";

    private static final String NAVIGATE_DETAIL_TO_SHOPPING = "NavigateShopping";
    private static final String NAVIGATE_DETAIL_TO_SHOPPING_CONTROLLER = "NavigateShoppingController";

    private static final String SEARCH_BRAND = "Search";
    private static final String SEARCH_BRAND_CONTROLLER = "ShowAllBrandManager";

    private static final String UPDATE_BRAND = "Update Brand";
    private static final String UPDATE_BRAND_CONTROLLER = "UpdateBrandManager";

    private static final String SIGNIN_EMPLOYEE = "Sign In";
    private static final String SIGNIN_EMPLOYEE_CONTROLLER = "SigninEmployee";

    private static final String SIGNOUT_EMPLOYEE = "Sign out";
    private static final String SIGNOUT_EMPLOYEE_CONTROLLER = "SignoutEmployee";

    private static final String CHANGE_PASSWORD = "ChangePassword";
    private static final String CHANGE_PASSWORD_CONTROLLER = "ChangePasswordController";

    private static final String SEARCH_USER = "SearchUser";
    private static final String SEARCH_USER_CONTROLLER = "SearchUserController";

    private static final String UPDATE_USER = "UpdateUser";
    private static final String UPDATE_USER_CONTROLLER = "UpdateUserController";

    private static final String FILTER_BY_EMPLOYEE = "FilterByEmployee";
    private static final String FILTER_BY_EMPLOYEE_CONTROLLER = "FilterByEmployeeController";

    private static final String FILTER_BY_CUSTOMER = "FilterByCustomer";
    private static final String FILTER_BY_CUSTOMER_CONTROLLER = "FilterByCustomerController";

    private static final String UPDATE_USER_STATUS = "UpdateUserStatus";
    private static final String UPDATE_USER_STATUS_CONTROLLER = "UpdateUserStatusController";

    private static final String ADD_TO_CART = "AddToCart";
    private static final String ADD_TO_CART_CONTROLLER = "AddToCartController";

    private static final String NAVIGATE_DETAIL_TO_CART = "NavigateToCart";
    private static final String NAVIGATE_DETAIL_TO_CART_CONTROLLER = "NavigateToCartController";

    private static final String DELETE_CART = "DeleteCart";
    private static final String DELETE_CART_CONTROLLER = "DeleteCartController";

    private static final String UPDATE_PROFILE = "UpdateProfile";
    private static final String UPDATE_PROFILE_CONTROLLER = "UpdateUserProfile";

    private static final String CREATE_NEW_USER_CUSTOMER = "registerNewUser";
    private static final String CREATE_NEW_USER_CUSTOMER_CONTROLLER = "CreateNewUserCustomerController";

    private static final String SHOW_ALL_ORDERS_STAFF = "ShowAllOrder";
    private static final String SHOW_ALL_ORDERS_STAFF_CONTROLLER = "ShowAllOrderStaffController";

    private static final String ORDER_PAGE = "ManageOrderPage";
    private static final String ORDER_PAGE_VIEW = "GetAllInfoForOrder";

    private static final String ORDER_DETAIL_PAGE = "OrderDetailPage";
    private static final String ORDER_DETAIL_PAGE_VIEW = "ShowOrderDetailStaff";

    private static final String ASSIGN_SHIPPER_STAFF = "AssignShipperStaff";
    private static final String ASSIGN_SHIPPER_STAFF_CONTROLLER = "AssignShipperStaffController";

    private static final String FORGOT_PASSWORD = "ForgetPassword";
    private static final String FORGET_PASSWORD_CONTROLLER = "ForgetPasswordController";

    private static final String VERIFY_TOKEN_FORGOT_PASSWORD = "VerifyOTP";
    private static final String VERIFY_TOKEN_FORGOT_PASSWORD_CONTROLLER = "VerifyOTPController";

    private static final String CHANGE_FORGOT_PASSWORD = "ChangePasswordForgot";
    private static final String CHANGE_FORGOT_PASSWORD_CONTROLLER = "ChangePasswordForgotController";

    private static final String NAVIGATE_SIGN_IN = "Sign in";
    private static final String NAVIGATE_SIGN_IN_CONTROLLER = "signin.jsp";

    private static final String NAVIGATE_SIGN_UP = "Sign up";
    private static final String NAVIGATE_SIGN_UP_CONTROLLER = "signup.jsp";

    private static final String NAVIGATE_RELATED_PRODUCT_DETAIL = "NavigateRelatedProductDetail";
    private static final String NAVIGATE_RELATED_PRODUCT_DETAIL_CONTROLLER = "NavigateRelatedProductDetailController";
    
    private static final String NAVIGATE_CHECK_OUT = "NavigateToCheckOut";
    private static final String NAVIGATE_CHECK_OUT_CONTROLLER = "NavigateToCheckOutController";
    
    private static final String CHECK_OUT = "checkOut";
    private static final String CHECK_OUT_CONTROLLER = "checkOutController";
    
    private static final String APPLY_VOUCHER = "ApplyVoucher";
    private static final String APPLY_VOUCHER_CONTROLLER = "ApplyVoucherController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = HOME_PAGE;
        try {
            String action = request.getParameter("action");
            if (SHOW_ALL_PRODUCT_MANAGER.equals(action)) {
                url = SHOW_ALL_PRODUCT_MANAGER_CONTROLLER;
            } else if (UPDATE_PRODUCT_MANAGER.equals(action)) {
                url = UPDATE_PRODUCT_MANAGER_CONTROLLER;
            } else if (CREATE_PRODUCT_MANAGER.equals(action)) {
                url = CREATE_PRODUCT_MANAGER_CONTROLLER;
            } else if (NAVIGATE_CATEGORY.equals(action)) {
                url = NAVIGATE_CATEGORY_CONTROLLER;
            } else if (FILTER_BY_BRAND.equals(action)) {
                url = FILTER_BY_BRAND_CONTROLLER;
            } else if (DELETE_PRODUCT_MANAGER.equals(action)) {
                url = DELETE_PRODUCT_MANAGER_CONTROLLER;
            } else if (PRODUCT_PAGE.equals(action)) {
                url = PRODUCT_PAGE_VIEW;
            } else if (DESCENDING_SORT_BY_PRICE.equals(action)) {
                url = DESCENDING_SORT_BY_PRICE_CONTROLLER;
            } else if (ASCENDING_SORT_BY_PRICE.equals(action)) {
                url = ASCENDING_SORT_BY_PRICE_CONTROLLER;
            } else if (PRODUCT_DETAIL_PAGE.equals(action)) {
                url = PRODUCT_DETAIL_PAGE_VIEW;
            } else if (FILTER_BY_SIZE.equals(action)) {
                url = FILTER_BY_SIZE_CONTROLLER;
            } else if (FILTER_BY_SIZE_2.equals(action)) {
                url = FILTER_BY_SIZE_CONTROLLER_2;
            } else if (SEARCH_PRODUCT.equals(action)) {
                url = SEARCH_PRODUCT_CONTROLLER;
            } else if (VIEW_PROMOTION.equals(action)) {
                url = VIEW_PROMOTION_CONTROLLER;
            } else if (CREATE_PROMOTION.equals(action)) {
                url = CREATE_PROMOTION_CONTROLLER;
            } else if (UPDATE_PROMOTION.equals(action)) {
                url = UPDATE_PROMOTION_CONTROLLER;
            } else if (NAVIGATE_PRODUCT_DETAIL.equals(action)) {
                url = NAVIGATE_PRODUCT_DETAIL_CONTROLLER;
            } else if (SHOW_PRICE_BY_SIZE.equals(action)) {
                url = SHOW_PRICE_BY_SIZE_CONTROLLER;
            } else if (UPDATE_PRODUCT_DETAIL_MANAGER.equals(action)) {
                url = UPDATE_PRODUCT_DETAIL_MANAGER_CONTROLLER;
            } else if (DELETE_PRODUCT_DETAIL_MANAGER.equals(action)) {
                url = DELETE_PRODUCT_DETAIL_MANAGER_CONTROLLER;
            } else if (SORT_BY_PURCHASING.equals(action)) {
                url = SORT_BY_PURCHASING_CONTROLLER;
            } else if (NAVIGATE_DETAIL_TO_SHOPPING.equals(action)) {
                url = NAVIGATE_DETAIL_TO_SHOPPING_CONTROLLER;
            } else if (SEARCH_BRAND.equals(action)) {
                url = SEARCH_BRAND_CONTROLLER;
            } else if (UPDATE_BRAND.equals(action)) {
                url = UPDATE_BRAND_CONTROLLER;
            } else if (ADD_TO_CART.equals(action)) {
                url = ADD_TO_CART_CONTROLLER;
            } else if (NAVIGATE_DETAIL_TO_CART.equals(action)) {
                url = NAVIGATE_DETAIL_TO_CART_CONTROLLER;
            } else if (DELETE_CART.equals(action)) {
                url = DELETE_CART_CONTROLLER;
            } else if (SHOW_ALL_PRODUCT_MANAGER.equals(action)) {
                url = SHOW_ALL_PRODUCT_MANAGER_CONTROLLER;
            } else if (SIGNIN_EMPLOYEE.equals(action)) {
                url = SIGNIN_EMPLOYEE_CONTROLLER;
            } else if (SIGNOUT_EMPLOYEE.equals(action)) {
                url = SIGNOUT_EMPLOYEE_CONTROLLER;
            } else if (CHANGE_PASSWORD.equals(action)) {
                url = CHANGE_PASSWORD_CONTROLLER;
            } else if (UPDATE_PROFILE.equals(action)) {
                url = UPDATE_PROFILE_CONTROLLER;
            } else if (SEARCH_USER.equals(action)) {
                url = SEARCH_USER_CONTROLLER;
            } else if (UPDATE_USER.equals(action)) {
                url = UPDATE_USER_CONTROLLER;
            } else if (FILTER_BY_EMPLOYEE.equals(action)) {
                url = FILTER_BY_EMPLOYEE_CONTROLLER;
            } else if (FILTER_BY_CUSTOMER.equals(action)) {
                url = FILTER_BY_CUSTOMER_CONTROLLER;
            } else if (UPDATE_USER_STATUS.equals(action)) {
                url = UPDATE_USER_STATUS_CONTROLLER;
            } else if (CREATE_NEW_USER_CUSTOMER.equals(action)) {
                url = CREATE_NEW_USER_CUSTOMER_CONTROLLER;
            } else if (SHOW_ALL_ORDERS_STAFF.equals(action)) {
                url = SHOW_ALL_ORDERS_STAFF_CONTROLLER;
            } else if (ORDER_PAGE.equals(action)) {
                url = ORDER_PAGE_VIEW;
            } else if (ORDER_DETAIL_PAGE.equals(action)) {
                url = ORDER_DETAIL_PAGE_VIEW;
            } else if (ASSIGN_SHIPPER_STAFF.equals(action)) {
                url = ASSIGN_SHIPPER_STAFF_CONTROLLER;
            } else if (FORGOT_PASSWORD.equals(action)) {
                url = FORGET_PASSWORD_CONTROLLER;
            } else if (VERIFY_TOKEN_FORGOT_PASSWORD.equals(action)) {
                url = VERIFY_TOKEN_FORGOT_PASSWORD_CONTROLLER;
            } else if (CHANGE_FORGOT_PASSWORD.equals(action)) {
                url = CHANGE_FORGOT_PASSWORD_CONTROLLER;
            } else if (NAVIGATE_SIGN_IN.equals(action)) {
                url = NAVIGATE_SIGN_IN_CONTROLLER;
            } else if (NAVIGATE_SIGN_UP.equals(action)) {
                url = NAVIGATE_SIGN_UP_CONTROLLER;
            } else if (NAVIGATE_RELATED_PRODUCT_DETAIL.equals(action)) {
                url = NAVIGATE_RELATED_PRODUCT_DETAIL_CONTROLLER;
            } else if(NAVIGATE_CHECK_OUT.equals(action)){
                url = NAVIGATE_CHECK_OUT_CONTROLLER;
            } else if(CHECK_OUT.equals(action)){
                url = CHECK_OUT_CONTROLLER;
            } else if(APPLY_VOUCHER.equals(action)){
                url = APPLY_VOUCHER_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
