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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyhc
 */
public class ProductDetailDAO {

//    private static final String LIST_PRODUCT_DETAIL = "SELECT * FROM ProductDetail WHERE ProductID = ? AND Status = 1";
    private static final String UPDATE_PRODUCT_DETAIL = "UPDATE ProductDetail SET Price = ?, StockQuantity = ?, Status = ?, Image = ? WHERE ProductID = ? AND SizeID = ?";
    private static final String DELETE_PRODUCT_DETAIL = "DELETE FROM ProductDetail WHERE ProductID = ? AND SizeID = ?";
    private static final String LIST_PRODUCT_DETAIL = "SELECT * FROM ProductDetail WHERE ProductID = ?";
    private static final String VIEW_PRODUCT_DETAIL = "SELECT P.ProductID, S.SizeID, P.ProName, P.Description, PD.Price ,S.Name, PD.NumberOfPurchasing, PD.Country, PD.ReleaseDate, PD.FragranceFamilies, PD.Image FROM ProductDetail PD "
            + "INNER JOIN Products P ON PD.ProductID = P.ProductID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "WHERE PD.ProductID = ? AND P.BrandID = 4";
    private static final String GET_PRICE_BY_SIZE = "SELECT PD.Price FROM ProductDetail PD "
            + "WHERE PD.ProductID = ? AND PD.SizeID = ?";
    private static final String GET_LIST_IMAGE = "SELECT PD.Image FROM ProductDetail PD "
            + "WHERE PD.ProductID = ?";
    private static final String CHECK_PRODUCT_DETAIL_EXISTED = "SELECT * FROM ProductDetail WHERE ProductID =? AND SizeID = ?";
    private static final String INSERT_PRODUCT_DETAIL = "INSERT INTO ProductDetail(ProductID,SizeID,Price,StockQuantity,NumberOfPurchasing,ImportDate,Image,Status) VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_LIST_PRODUCT_DETAIL_STAFF = "SELECT * FROM ProductDetail";

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
                    int productDetailID = rs.getInt("ProductDetailID");
                    int sizeID = rs.getInt("SizeID");
                    int price = rs.getInt("Price");
                    int stockQuantity = rs.getInt("StockQuantity");
                    int numOfPur = rs.getInt("NumberOfPurchasing");
                    Date importDate = rs.getDate("ImportDate");
                    String image = rs.getString("Image");
                    int status = rs.getInt("Status");
                    ProductDetailDTO newProDe = new ProductDetailDTO(productDetailID, productID, sizeID, price, stockQuantity, numOfPur, importDate, image, status);
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

    public boolean updateProductDetail(int productID, int sizeID, int price, int stockQuantity, String image, int status) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
//            UPDATE ProductDetail SET Price = ?, StockQuantity = ?, Status = ?, Image = ? WHERE ProductID = ? AND SizeID = ?
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PRODUCT_DETAIL);
                ptm.setInt(1, price);
                ptm.setInt(2, stockQuantity);
                ptm.setInt(3, status);
                ptm.setString(4, image);
                ptm.setInt(5, productID);
                ptm.setInt(6, sizeID);
                check = ptm.executeUpdate() > 0;
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

    public boolean deleteProductDeltail(int productID, int sizeID) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
//              UPDATE ProductDetail SET Status = 0 WHERE ProductID = ? AND SizeID = ?
                ptm = conn.prepareStatement(DELETE_PRODUCT_DETAIL);
                ptm.setInt(1, productID);
                ptm.setInt(2, sizeID);
                check = ptm.executeUpdate() > 0;
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
                    list.add(new ProductDetailDTO(0, productID, sizeID, price, 0, 0, null, "", 0));
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
                    list.add(new ProductDetailDTO(0, productID, 0, 0, 0, 0, null, image, 0));
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

    public boolean checkExisted(int productID, int sizeID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
//        SELECT * FROM ProductDetail WHERE ProductID =? AND SizeID = ?
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_PRODUCT_DETAIL_EXISTED);
                ptm.setInt(1, productID);
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
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
        return check;
    }

    public boolean createProductDetailManager(int productID, int sizeID, int price, int stockQuantity, LocalDateTime importDate, String imagePath, int numberOfPurchase, int status) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
//      INSERT INTO ProductDetail(ProductID,SizeID,Price,StockQuantity,NumberOfPurchasing,ImportDate,Image,Status) VALUES (?,?,?,?,?,?,?,?)
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(INSERT_PRODUCT_DETAIL);
            ptm.setInt(1, productID);
            ptm.setInt(2, sizeID);
            ptm.setInt(3, price);
            ptm.setInt(4, stockQuantity);
            ptm.setInt(5, numberOfPurchase);
            ptm.setTimestamp(6, Timestamp.valueOf(importDate));
            ptm.setString(7, imagePath);
            ptm.setInt(8, status);
            check = ptm.executeUpdate() > 0;
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

    public List<ProductDetailDTO> getListAllProductDetail() throws ClassNotFoundException, SQLException {
        List<ProductDetailDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_PRODUCT_DETAIL_STAFF);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int sizeID = rs.getInt("SizeID");
                    int price = rs.getInt("Price");
                    int stockQuantity = rs.getInt("StockQuantity");
                    int numberOfPur = rs.getInt("NumberOfPurchasing");
                    Date importDate = rs.getDate("ImportDate");
                    String image = rs.getString("Image");
                    int status = rs.getInt("Status");
                    ProductDetailDTO proDe = new ProductDetailDTO(productDetailID, productID, sizeID, price, stockQuantity, numberOfPur, importDate, image, status);
                    list.add(proDe);
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return list;
    }
}
