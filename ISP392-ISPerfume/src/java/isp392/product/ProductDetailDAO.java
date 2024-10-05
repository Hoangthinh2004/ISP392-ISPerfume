/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.product;

import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyhc
 */
public class ProductDetailDAO {

    private static final String LIST_PRODUCT_DETAIL = "SELECT * FROM ProductDetail WHERE ProductID = ?";

    public List<ProductDetailDTO> getListProductDetail(int productID) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<ProductDetailDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_PRODUCT_DETAIL);
                ptm.setInt(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int sizeID = rs.getInt("SizeID");
                    int price = rs.getInt("Price");
                    int stockQuantity = rs.getInt("StockQuantity");
                    int numOfPur = rs.getInt("NumberOfPurchasing");
                    Date importDate = rs.getDate("ImportDate");
                    String country = rs.getString("Country");
                    int releaseDate = rs.getInt("ReleaseDate");
                    String fraganceFamilies = rs.getString("FragranceFamilies");
                    String image = rs.getString("Image");
                    int status = rs.getInt("Status");
                    ProductDetailDTO newProDe = new ProductDetailDTO(productID, sizeID, price, stockQuantity, numOfPur,importDate, country, releaseDate, fraganceFamilies, image, status);
                    list.add(newProDe);
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
        return list;
    }

}
