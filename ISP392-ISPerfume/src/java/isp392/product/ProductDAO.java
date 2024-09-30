/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.product;

import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThinhHoang
 */
public class ProductDAO {
    private static final String LIST_PRODUCT = "SELECT FROM WHERE";
    private static final String LIST_PRODUCT_BY_CATEGORY = "SELECT p.ProductID,p.Image, p.ProName FROM Products p " 
                                                        + "INNER JOIN Product_Category pc on p.ProductID = pc.ProductID "
                                                        + "WHERE p.Status = 1 AND pc.CategoryID = ?";
    private static final String LOWEST_PRICE = "SELECT TOP 1 pd.Price FROM ProductDetail pd " 
                                              + "WHERE pd.ProductID = ? " 
                                              + "ORDER BY pd.Price ASC";
    private static final String HIGHEST_PRICE = "SELECT TOP 1 pd.Price FROM ProductDetail pd " 
                                              + "WHERE pd.ProductID = ? " 
                                              + "ORDER BY pd.Price DESC";
    private static final String LIST_PRODUCT_BY_BRAND = "SELECT p.ProductID,p.Image, p.ProName, p.BrandID FROM Products p " 
                                                        + "INNER JOIN Product_Category pc on p.ProductID = pc.ProductID " 
                                                        + "WHERE p.Status = 1 AND pc.CategoryID = ? AND p.BrandID = ?";

    public List<ProductDTO> getListProduct(String search) throws ClassNotFoundException, SQLException {
        List<ProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_PRODUCT);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ProductDTO> getListProductByCategory(String category) throws ClassNotFoundException, SQLException {
        List<ProductDTO> listProductByCategory = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_PRODUCT_BY_CATEGORY);
                ptm.setString(1, category);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    listProductByCategory.add(new ProductDTO(productID, 0, productName, "", image, 1));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProductByCategory;
    }

    public List<ProductDetailDTO> getHightestPrice(String productID) throws ClassNotFoundException, SQLException {
        List<ProductDetailDTO> listHightestPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(HIGHEST_PRICE);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {      
                    int price = rs.getInt("Price");
                    listHightestPrice.add(new ProductDetailDTO(0, price, 0, 0, null, "", 0, "", ""));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listHightestPrice;
    }

    public List<ProductDetailDTO> getLowestPrice(String productID) throws ClassNotFoundException, SQLException {
        List<ProductDetailDTO> listLowestPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOWEST_PRICE);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {      
                    int price = rs.getInt("Price");
                    listLowestPrice.add(new ProductDetailDTO(0, price, 0, 0, null, "", 0, "", ""));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listLowestPrice;
    }

    public List<ProductDTO> filterProductByBrand(String brandID, String categoryID) throws ClassNotFoundException, SQLException {
        List<ProductDTO> listProductByBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_PRODUCT_BY_BRAND);
                ptm.setString(1, categoryID);
                ptm.setString(2, brandID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    listProductByBrand.add(new ProductDTO(productID, 0, productName, "", image, 1));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProductByBrand;
    }
    
}
