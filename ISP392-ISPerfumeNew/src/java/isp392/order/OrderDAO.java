/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.order;

import isp392.product.ProductDetailDTO;
import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThinhHoang
 */
public class OrderDAO {

    private final String GET_LIST_ORDER_STAFF = "SELECT * FROM Orders";
    private final String GET_LIST_ORDER_DETAIL_STAFF = "SELECT * FROM Order_Detail WHERE OrderID = ?";
    private final String GET_ORDER_BY_ORDERID = "SELECT * FROM Orders WHERE OrderID = ?";
    private final String ASSIGN_SHIPPER_ORDER = "UPDATE Orders SET ShipperID = ? , orderStatus = 2 WHERE OrderID = ?";
            
    public List<OrderDTO> getListOrder() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<OrderDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(GET_LIST_ORDER_STAFF);
            rs = ptm.executeQuery();
            while (rs.next()) {
                int orderID = rs.getInt("OrderID");
                int cartID = rs.getInt("CartID");
                int staffID = rs.getInt("StaffID");
                int shipperID = rs.getInt("ShipperID");
                int promotionID = rs.getInt("PromotionID");
                int customerID = rs.getInt("CustomerID");
                Date orderDate = rs.getDate("OrderDate");
                int orderStatus = rs.getInt("orderStatus");
                String city = rs.getString("City");
                String district = rs.getString("District");
                String ward = rs.getString("Ward");
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                String note = rs.getString("Note");
                OrderDTO order = new OrderDTO(orderID, cartID, staffID, shipperID, promotionID, customerID, orderDate, orderStatus, city, district, ward, address, phone, note);
                list.add(order);

            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return list;
    }

    public List<OrderDetailDTO> getListOrderDetail(int orderID) throws SQLException, ClassNotFoundException {
        List<OrderDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_ORDER_DETAIL_STAFF);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int quantity = rs.getInt("Quantity");
                    int unitPrice = rs.getInt("UnitPrice");
                    OrderDetailDTO orderDetail = new OrderDetailDTO(orderID, productDetailID, quantity, unitPrice);
                    list.add(orderDetail);
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return list;
    }

    public OrderDTO getOrder(int orderID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        OrderDTO order = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ORDER_BY_ORDERID);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int cartID = rs.getInt("CartID");
                    int staffID = rs.getInt("StaffID");
                    int shipperID = rs.getInt("ShipperID");
                    int promotionID = rs.getInt("PromotionID");
                    int customerID = rs.getInt("CustomerID");
                    Date orderDate = rs.getDate("OrderDate");
                    int orderStatus = rs.getInt("orderStatus");
                    String city = rs.getString("City");
                    String district = rs.getString("District");
                    String ward = rs.getString("Ward");
                    String address = rs.getString("Address");
                    String phone = rs.getString("Phone");
                    String note = rs.getString("Note");
                    order = new OrderDTO(orderID, cartID, staffID, shipperID, promotionID, customerID, orderDate, orderStatus, city, district, ward, address, phone, note);
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return order;
    }

    public boolean assignShipper(int orderID, int shipperID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
//              UPDATE Orders SET ShipperID = ? , orderStatus = 2 WHERE OrderID = ?
                ptm = conn.prepareStatement(ASSIGN_SHIPPER_ORDER);
                ptm.setInt(1, shipperID);
                ptm.setInt(2, orderID);
                check = ptm.executeUpdate()>0;
            }
        }finally{
            DBUtils.closeConnection2(conn, ptm);
        }
        return check;
    }

    private static final String LIST_ORDER = "SELECT O.OrderID, U.Name, U.Phone, concat(O.Address, ', ' , O.Ward, ', ', O.District, ', ', O.City) as Address, O.Note, O.orderStatus from Orders O \n"
            + "            JOIN Customer C ON C.CustomerID = O.CustomerID \n"
            + "            JOIN Users U ON U.UserID = C.CustomerID\n"
            + "			WHERE O.ShipperID = ? AND orderStatus >= 2";
    private static final String SHIPPER_UPDATE_STATUS_ORDER = "UPDATE Orders SET orderStatus=? WHERE OrderID=?";
    private static final String COUNT = "SELECT  COUNT(OrderID) as OrderID FROM Orders";

    public List<OrderDTO> getListOrder(int shipperID) throws SQLException, NamingException, ClassNotFoundException {
        List<OrderDTO> listOrder = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_ORDER);
                ptm.setInt(1, shipperID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    String customerName = rs.getString("Name");
                    String phone = rs.getString("Phone");
                    String address = rs.getString("Address");
                    String note = rs.getString("Note");
                    int orderStatus = rs.getInt("orderStatus");
                    listOrder.add(new OrderDTO(shipperID, orderID, customerName, phone, address, note, orderStatus));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listOrder;
    }

    public boolean updateStatusShipperOrder(OrderDTO order) throws SQLException, NamingException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SHIPPER_UPDATE_STATUS_ORDER);
                ptm.setInt(1, order.getOrderStatus());
                ptm.setInt(2, order.getOrderID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

    public List<OrderDTO> countAllOrder() throws NamingException, SQLException, ClassNotFoundException {
        List<OrderDTO> listOrder = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COUNT);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    listOrder.add(new OrderDTO(0, orderID,  "", "", "", "", 0));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listOrder;
    }
}
