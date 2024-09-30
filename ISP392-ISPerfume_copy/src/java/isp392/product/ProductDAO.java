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

    private static final String LIST_PRODUCT_MANAGER = "SELECT ProductID, BrandID, ProName, Description, Image, Status FROM Products WHERE ProName LIKE ?";
    private static final String UPDATE_PRODUCT_MANAGER = "UPDATE Products SET BrandID = ?, ProName = ?, Description = ?, Image = ? WHERE ProductID = ?";
    private static final String INSERT_PRODUCT_MANAGER = "INSERT INTO Products(BrandID, Description, Image, ProName, Status) VALUES(?,?,?,?,?)";
    private static final String CHECK_DUPLICATE_PRODUCT_BY_NAME = "SELECT ProductID FROM Products WHERE ProName LIKE ?";

    public List<ProductDTO> getListProduct(String search) throws ClassNotFoundException, SQLException {
        List<ProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_PRODUCT_MANAGER);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String proName = rs.getString("ProName");
                    String descrip = rs.getString("Description");
                    String image = rs.getString("Image");
                    boolean status = rs.getBoolean("Status");
                    ProductDTO newPro = new ProductDTO(productID, brandID, proName, descrip, image, status);
                    listProduct.add(newPro);
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
        return listProduct;
    }

    public boolean updateProduct(ProductDTO pro) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
//          UPDATE Products SET BrandID = ?, ProName = ?, Description = ?, Image = ? WHERE ProductID = ?"
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PRODUCT_MANAGER);
                ptm.setInt(1, pro.getBrandID());
                ptm.setString(2, pro.getName());
                ptm.setString(3, pro.getDescription());
                ptm.setString(4, pro.getImage());
                ptm.setInt(5, pro.getProductID());
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

    public boolean addProduct(String name, int brandID, String description, String imagePath, boolean status) throws SQLException, ClassNotFoundException {
//        INSERT INTO Products(BrandID, Description, Image, ProName, Status) VALUES(?,?,?,?,?)
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_PRODUCT_MANAGER);
                ptm.setInt(1, brandID);
                ptm.setString(2, description);
                ptm.setString(3, imagePath);
                ptm.setString(4, name);
                ptm.setBoolean(5, status);
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

    public boolean checkDuplicateByName(String name) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
//              SELECT ProductID FROM Products WHERE ProName LIKE ?
                ptm = conn.prepareStatement(CHECK_DUPLICATE_PRODUCT_BY_NAME);
                ptm.setString(1, name);
                rs = ptm.executeQuery();
                if(rs.next()){
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

}
