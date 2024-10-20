/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.brand;

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
public class BrandDAO {

    private static final String GET_LIST_BRAND = "SELECT * FROM Brands WHERE Status = 1";
    private static final String INSERT_BRAND = "INSERT INTO Brands(ManagerID ,BrandName, Image, Description, Status) VALUES (?,?,?,?,?)";
    private static final String LIST_BRAND = "SELECT BrandID, Description, ManagerID ,BrandName, Image, Status FROM Brands WHERE BrandName LIKE ?";
    private static final String BRAND_LIST_BY_CATEGORY = "SELECT C.CategoryName, B.BrandName, B.BrandID FROM Categories C "
            + "INNER JOIN Categories_Brands CB on C.CategoryID = CB.CategoryID "
            + "INNER JOIN Brands B on CB.BrandID = B.BrandID";
    private static final String BRAND_BY_PRODUCT = "SELECT B.BrandID, B.BrandName FROM Brands B "
            + "INNER JOIN Products P ON P.BrandID = B.BrandID "
            + "WHERE P.ProductID = ?";
    private static final String UPDATE_BRAND = "UPDATE Brands SET  BrandName = ?, Description = ?, Status = ? WHERE BrandID = ?";
    private static final String BRAND_INFORMATION = "SELECT * FROM Brands WHERE BrandID = ?";

    public List<BrandDTO> getListBrandManager(String search) throws SQLException, ClassNotFoundException {

        List<BrandDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_BRAND);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int brandID = rs.getInt("BrandID");
                    String brandName = rs.getString("BrandName");
                    int managerID = rs.getInt("ManagerID");
                    String description = rs.getString("Description");
                    String image = rs.getString("Image");
                    boolean status = rs.getBoolean("Status");
                    BrandDTO brand = new BrandDTO(brandID, managerID, brandName, description, image, status);
                    list.add(brand);
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
    
    public List<BrandDTO> getListBrand() throws ClassNotFoundException, SQLException {
        List<BrandDTO> listBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_BRAND);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int managerID = rs.getInt("ManagerID");
                    int brandID = rs.getInt("BrandID");
                    String brandName = rs.getString("BrandName");
                    String image = rs.getString("Image");
                    String description = rs.getString("Description");
                    listBrand.add(new BrandDTO(brandID, managerID, brandName, description, image, true));
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
        return listBrand;
    }

    public List<BrandDTO> getListBrandManager() throws SQLException, ClassNotFoundException {
        List<BrandDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_BRAND);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int brandID = rs.getInt("BrandID");
                    int managerID = rs.getInt("ManagerID");
                    String brandName = rs.getString("BrandName");
                    String image = rs.getString("Image");
                    String description = rs.getString("Description");
                    boolean status = rs.getBoolean("Status");
                    BrandDTO newBrand = new BrandDTO(brandID, managerID, brandName, description, image, status);
                    list.add(newBrand);
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

    public List<BrandDTO> getBrandByProduct(int productID) throws ClassNotFoundException, SQLException {
        List<BrandDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(BRAND_BY_PRODUCT);
                ptm.setInt(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int brandID = rs.getInt("BrandID");
                    String brandName = rs.getString("BrandName");
                    BrandDTO newBrand = new BrandDTO(brandID, 0, brandName, "", "", true);
                    list.add(newBrand);
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

    public boolean updateBrand(BrandDTO brand) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_BRAND);
                ptm.setString(1, brand.getName());
                ptm.setString(2, brand.getDescription());
                ptm.setBoolean(3, brand.isStatus());
                ptm.setInt(4, brand.getBrandID());
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

    public boolean addBrand(String name, String description, String imagePath, int managerID, boolean status) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_BRAND);
//              INSERT INTO Brands(ManagerID ,BrandName, Image, Description, Status) VALUES (?,?,?,?,?)
                ptm.setInt(1, managerID);
                ptm.setString(2, name);
                ptm.setString(3, imagePath);
                ptm.setString(4, description);
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

    public List<BrandDTO> showBrandInfor(int brandID) throws ClassNotFoundException, SQLException {
        List<BrandDTO> listBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(BRAND_INFORMATION);
                ptm.setInt(1, brandID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String brandName = rs.getString("BrandName");
                    String image = rs.getString("Image");
                    String description = rs.getString("Description");
                    listBrand.add(new BrandDTO(brandID, 0, brandName, description, image, true));
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
        return listBrand;
    }

}
