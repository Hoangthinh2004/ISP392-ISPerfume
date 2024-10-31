/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.order;

import isp392.product.ProductDTO;
import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author anhng
 */
public class OrderDetailDAO {

    private static final String LIST_ORDER_DETAIL = "SELECT O.OrderID, P.ProName, OD.Quantity, PD.Price  FROM Order_Detail OD\n"
            + "            JOIN ProductDetail PD on OD.ProductDetailID = PD.ProductDetailID\n"
            + "            JOIN Products P on P.ProductID = PD.ProductID\n"
            + "            JOIN Orders O on O.OrderID = OD.OrderID\n"
            + "            JOIN Promotion Pr on O.PromotionID = Pr.PromotionID\n"
            + "            WHERE O.OrderID = ? AND O.PromotionID = Pr.PromotionID";

    public List<OrderDetailDTO> getListOrderDetail(int orderID) throws SQLException, NamingException, ClassNotFoundException {
        List<OrderDetailDTO> listOrderDetail = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_ORDER_DETAIL);
                ptm.setInt(1, orderID);
                rs = ptm.executeQuery();
                while (rs.next()){
                    int quantity = rs.getInt("Quantity");
                    int unitPrice = rs.getInt("Price");
                    String productName = rs.getString("ProName");
                    listOrderDetail.add(new OrderDetailDTO(orderID, 0, quantity, unitPrice, productName));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return listOrderDetail;
    }
}
