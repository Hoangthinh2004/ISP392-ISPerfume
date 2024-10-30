/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.order;

import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ThinhHoang
 */
public class OrderDAO {
    
    private static final String CREATE_ORDER = "INSERT INTO Orders(CartID, StaffID, ShipperID, PromotionID, CustomerID, OrderDate, orderStatus, City, District, Ward, Address, Phone, Note) VALUES (?,?,?,?,?,getdate(),1,?,?,?,?,?,?)";
    private static final String CREATE_ORDER_DETAIL ="INSERT INTO Order_Detail(OrderID, ProductDetailID, Quantity, UnitPrice) VALUES (?,?,?,?)";
    private static final String UPDATE_QUANTITY = "UPDATE ProductDetail SET StockQuantity = StockQuantity-? WHERE ProductDetailID = ?";   
    
    public int createOrder(OrderDTO order) throws ClassNotFoundException, SQLException {
        int orderID = 0;
        Connection conn = null;
        PreparedStatement orderPtm = null;
        PreparedStatement orderDetailPtm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                orderPtm = conn.prepareStatement(CREATE_ORDER, PreparedStatement.RETURN_GENERATED_KEYS);
                orderPtm.setInt(1, order.getCartID());
                orderPtm.setInt(2, order.getStaffID());
                orderPtm.setNull(3, java.sql.Types.INTEGER);
                if (order.getPromotionID() == 0) {
                    orderPtm.setNull(4, java.sql.Types.INTEGER);
                } else {
                    orderPtm.setInt(4, order.getPromotionID());
                }             
                orderPtm.setInt(5, order.getCustomerID());
                orderPtm.setString(6, order.getCity());
                orderPtm.setString(7, order.getDistrict());
                orderPtm.setString(8, order.getWard());
                orderPtm.setString(9, order.getAddress());
                orderPtm.setString(10, order.getPhone());
                orderPtm.setString(11, order.getNote());
                int checkCreateOrder = orderPtm.executeUpdate();
                if (checkCreateOrder > 0) {
                    rs = orderPtm.getGeneratedKeys();
                    if (rs.next()) {
                        orderID = rs.getInt(1);
                    }
                }
            }
        } finally {
            if (orderPtm != null) {
                orderPtm.close();
            } if (orderDetailPtm != null) {
                orderDetailPtm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return orderID;
    }

    public boolean updateQuantity(int productDetailID, int quantity) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null) {
                ptm = conn.prepareStatement(UPDATE_QUANTITY);
                ptm.setInt(1, quantity);
                ptm.setInt(2, productDetailID);
                check = ptm.executeUpdate()>0?true:false;
            }
        } finally {
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }

    public boolean createOrderDetail(int orderID, int productDeID, int quan, int proPrice) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_ORDER_DETAIL);
                ptm.setInt(1, orderID);
                ptm.setInt(2, productDeID);
                ptm.setInt(3, quan);
                ptm.setInt(4, proPrice);
                check = ptm.executeUpdate()>0?true:false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
}
