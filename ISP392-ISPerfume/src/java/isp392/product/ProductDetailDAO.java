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
    private static final String VIEW_PRODUCT_DETAIL = "SELECT P.ProductID, S.SizeID, P.ProName, P.Description, PD.Price ,S.Name, PD.NumberOfPurchasing, PD.Country, PD.ReleaseDate, PD.FragranceFamilies, PD.Image FROM ProductDetail PD "
                                                    + "INNER JOIN Products P ON PD.ProductID = P.ProductID "
                                                    + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                    + "WHERE PD.ProductID = ? AND P.BrandID = 4";
    private static final String GET_PRICE_BY_SIZE = "SELECT PD.Price FROM ProductDetail PD "
                                                  + "WHERE PD.ProductID = ? AND PD.SizeID = ?";
    private static final String GET_LIST_IMAGE = "SELECT PD.Image FROM ProductDetail PD "
                                               + "WHERE PD.ProductID = ?";

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

    public List<ProductDetailDTO> getListPriceBySize(int productID, int sizeID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<ProductDetailDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_PRICE_BY_SIZE);
                ptm.setInt(1, productID);
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int price = rs.getInt("Price");
                    list.add(new ProductDetailDTO(productID, sizeID, price, 0, 0, null, "", 0, "", "", 0));
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

    public List<ProductDetailDTO> getListImage(int productID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        List<ProductDetailDTO> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_IMAGE);
                ptm.setInt(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String image = rs.getString("Image");
                    list.add(new ProductDetailDTO(productID, 0, 0, 0, 0, null, "", 0, "", image, 0));
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
