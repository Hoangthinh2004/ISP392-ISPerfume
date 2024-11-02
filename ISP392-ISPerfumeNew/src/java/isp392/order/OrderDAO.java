/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.order;

import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ThinhHoang
 */
public class OrderDAO {
    
    private final String ASSIGN_SHIPPER_ORDER = "UPDATE Orders SET ShipperID = ? , orderStatus = 2 WHERE OrderID = ?";
    private static final String CREATE_ORDER = "INSERT INTO Orders(CartID, StaffID, ShipperID, PromotionID, CustomerID, OrderDate, orderStatus, City, District, Ward, Address, Phone, Note) VALUES (?,?,?,?,?,getdate(),1,?,?,?,?,?,?)";
    private static final String CREATE_ORDER_DETAIL ="INSERT INTO Order_Detail(OrderID, ProductDetailID, Quantity, UnitPrice) VALUES (?,?,?,?)";
    private static final String UPDATE_QUANTITY = "UPDATE ProductDetail SET StockQuantity = StockQuantity-? WHERE ProductDetailID = ?";   
    private final String GET_LIST_ORDER_STAFF = "SELECT * FROM Orders";
    private final String GET_LIST_ORDER_DETAIL_STAFF = "SELECT * FROM Order_Detail WHERE OrderID = ?";
    private final String GET_ORDER_BY_ORDERID = "SELECT * FROM Orders WHERE OrderID = ?";
    private final String GET_LIST_ORDER_BY_STATUS = "SELECT * FROM Orders WHERE CustomerID = ? AND orderStatus = ?";
    private final String COUNT_ORDER_IS_PROCESSING = "SELECT COUNT(OrderID) as OrderID FROM Orders WHERE orderStatus BETWEEN 1 AND 3";
    
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
    
    public List<OrderDTO> getListOrderByStatus(int custID, int i) throws ClassNotFoundException, SQLException {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
//                SELECT * FROM Orders WHERE CustomerID = ? AND orderStatus = ?
                ptm = conn.prepareStatement(GET_LIST_ORDER_BY_STATUS);
                ptm.setInt(1, custID);
                ptm.setInt(2, i);
                rs = ptm.executeQuery();
                while(rs.next()){
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
            }
        }finally{
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return list;
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

    public List<OrderDetailDTO> getListOrderDetail(int orderID) throws ClassNotFoundException, SQLException {
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
                    OrderDetailDTO orderDetail = new OrderDetailDTO(orderID, productDetailID, quantity, unitPrice,"");
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

    public List<OrderDTO> getListOrderByStatus(int custID, int i) throws ClassNotFoundException, SQLException {
        List<OrderDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
//                SELECT * FROM Orders WHERE CustomerID = ? AND orderStatus = ?
                ptm = conn.prepareStatement(GET_LIST_ORDER_BY_STATUS);
                ptm.setInt(1, custID);
                ptm.setInt(2, i);
                rs = ptm.executeQuery();
                while(rs.next()){
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
            }
        }finally{
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return list;
    }
    
    public List<OrderDTO> countAllOrderIsProcessing() throws SQLException, NamingException, ClassNotFoundException{
         List<OrderDTO> listOrder = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COUNT_ORDER_IS_PROCESSING);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    listOrder.add(new OrderDTO(orderID, 0, 0, 0, 0, 0, null, 0, "", "", "", "", "", ""));
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
