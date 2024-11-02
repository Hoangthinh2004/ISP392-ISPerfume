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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author anhng
 */
public class ShipperOrderDAO {
    
     private static final String LIST_ORDER = "SELECT O.OrderID, U.Name, U.Phone, concat(O.Address, ', ' , O.Ward, ', ', O.District, ', ', O.City) as Address, O.Note, O.orderStatus from Orders O \n"
            + "            JOIN Customer C ON C.CustomerID = O.CustomerID \n"
            + "            JOIN Users U ON U.UserID = C.CustomerID\n"
            + "			WHERE O.ShipperID = ? AND orderStatus >= 2";
    private static final String SHIPPER_UPDATE_STATUS_ORDER = "UPDATE Orders SET orderStatus=? WHERE OrderID=?";
    private static final String COUNT_ORDER_COMPLETED = "SELECT  COUNT(OrderID) as OrderID FROM Orders WHERE orderStatus = 4";
    
    public List<ShipperOrderDTO> getListOrder(int shipperID) throws SQLException, NamingException, ClassNotFoundException {
        List<ShipperOrderDTO> listOrder = new ArrayList<>();
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
                    listOrder.add(new ShipperOrderDTO(shipperID, orderID, customerName, phone, address, note, orderStatus));
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

    public boolean updateStatusShipperOrder(ShipperOrderDTO order) throws SQLException, NamingException, ClassNotFoundException {
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

    public List<ShipperOrderDTO> countAllOrder() throws NamingException, SQLException, ClassNotFoundException {
        List<ShipperOrderDTO> listSOrder = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(COUNT_ORDER_COMPLETED);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("OrderID");
                    listSOrder.add(new ShipperOrderDTO(0, orderID, "", "", "", "", 0));
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
        return listSOrder;
    }
}
