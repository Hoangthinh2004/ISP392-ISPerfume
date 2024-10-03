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
    private static final String LIST_PRODUCT_BY_CATEGORY = "SELECT P.ProductID, B.BrandName, S.Name , P.Image, PD.Price, P.ProName FROM Products P "
                                                         + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                         + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                         + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                         + "WHERE P.Status = 1 AND PC.CategoryID = ?";
    private static final String LIST_PRODUCT_BY_BRAND = "SELECT p.ProductID,p.Image, p.ProName FROM Products p "
                                                      + "WHERE p.Status = 1 ";
    private static final String FILTER_PRODUCT_BY_BRAND = "SELECT p.ProductID,p.Image, p.ProName, p.BrandID FROM Products p " 
                                                        + "INNER JOIN Product_Category pc on p.ProductID = pc.ProductID " 
                                                        + "WHERE p.Status = 1 AND pc.CategoryID = ? AND p.BrandID = ?";

    private static final String LIST_PRODUCT_MANAGER = "SELECT ProductID, BrandID, ProName, Description, Image, Status FROM Products WHERE ProName LIKE ?";
    private static final String UPDATE_PRODUCT_MANAGER = "UPDATE Products SET BrandID = ?, ProName = ?, Description = ?, Image = ? WHERE ProductID = ?";
    private static final String INSERT_PRODUCT_MANAGER = "INSERT INTO Products(BrandID, Description, Image, ProName, Status) VALUES(?,?,?,?,?)";
    private static final String CHECK_DUPLICATE_PRODUCT_BY_NAME = "SELECT ProductID FROM Products WHERE ProName LIKE ?";
    private static final String DESCENDING_PRODUCT_BY_PRICE = "SELECT P.ProductID, P.Image, P.ProName  FROM Products P "
                                                            + "INNER JOIN Product_Category PC ON PC.ProductID = P.ProductID "
                                                            + "INNER JOIN Categories C ON C.CategoryID = PC.CategoryID "
                                                            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                            + "WHERE C.CategoryID = ? AND PD.SizeID = 3 "
                                                            + "ORDER BY PD.Price DESC";
    private static final String DESCENDING_PRODUCT_BY_PRICE_2 = "SELECT P.ProductID, P.Image, P.ProName  FROM Products P "
                                                              + "INNER JOIN Product_Category PC ON PC.ProductID = P.ProductID "
                                                              + "INNER JOIN Categories C ON C.CategoryID = PC.CategoryID "
                                                              + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                              + "WHERE C.CategoryID = ? AND PD.SizeID = 1 AND P.BrandID = ? "
                                                              + "ORDER BY PD.Price DESC";

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
                    int managerID = rs.getInt("ManagerID");
                    int brandID = rs.getInt("BrandID");
                    String proName = rs.getString("ProName");
                    String descrip = rs.getString("Description");
                    String image = rs.getString("Image");
                    int status = rs.getInt("Status");
                    ProductDTO newPro = new ProductDTO(productID, managerID, brandID, proName, descrip, image, status);
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


    public List<ViewProductDTO> getListProductByCategory(int category) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProductByCategory = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_PRODUCT_BY_CATEGORY);
                ptm.setInt(1, category);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProductByCategory.add(new ViewProductDTO(category, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProductByCategory;
    }

    public List<ViewProductDTO> filterProductByBrand(int brandID, int categoryID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProductByBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_PRODUCT_BY_BRAND);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProductByBrand.add(new ViewProductDTO(categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProductByBrand;
    }

    public List<ViewProductDTO> DescendingListProductByPrice(int categoryID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listDescendingProductPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_PRODUCT_BY_BRAND);
                ptm.setInt(1, categoryID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listDescendingProductPrice.add(new ViewProductDTO(categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listDescendingProductPrice;
    }

    public List<ViewProductDTO> DescendingListChildProductByPrice(int categoryID, int brandID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> DescendingListChildProductByPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_PRODUCT_BY_BRAND);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    DescendingListChildProductByPrice.add(new ViewProductDTO(categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return DescendingListChildProductByPrice;
    }
    
}
