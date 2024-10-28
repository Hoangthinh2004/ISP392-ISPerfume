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
import javax.naming.NamingException;

/**
 *
 * @author ThinhHoang
 */
public class ProductDAO {
    private static final String LIST_PRODUCT = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                            +  "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                            +  "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                            +  "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                            +  "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                            +  "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4";
    private static final String FILTER_SEARCH_RESULT_BY_SIZE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                            +  "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                            +  "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                            +  "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                            +  "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                            +  "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4 AND PD.SizeID = ?";
    private static final String LIST_PRODUCT_BY_CATEGORY = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                        +  "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                        +  "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                        +  "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                        +  "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                        +  "WHERE P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = ?";
    private static final String FILTER_PRODUCT_BY_BRAND = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                        + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                        + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                        + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                        + "INNER JOIN Brands B ON B.BrandID = P.BrandID " 
                                                        + "WHERE P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = ? AND P.BrandID = ?";
    private static final String FILTER_PRODUCT_BY_CHILD_BRAND = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                            + "INNER JOIN Brands B ON B.BrandID = P.BrandID " 
                                                            + "WHERE P.Status = 1 AND PD.Status = 1 AND pc.CategoryID = ? AND p.BrandID = ? AND PD.SizeID = ?";
    private static final String FILTER_PRODUCT_BY_SIZE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                       + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                       + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                       + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                       + "INNER JOIN Brands B ON B.BrandID = P.BrandID " 
                                                       + "WHERE P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = ? AND PD.SizeID = ?";
    private static final String FILTER_PRODUCT_BY_CHILD_SIZE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                             + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                             + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                             + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                             + "INNER JOIN Brands B ON B.BrandID = P.BrandID " 
                                                             + "WHERE P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = ? AND P.BrandID = ? AND PD.SizeID = ?";
    private static final String LIST_PRODUCT_MANAGER = "SELECT ProductID, BrandID, ManagerID, ProName, Description, Image, Country, ReleaseDate, FragranceFamilies, Status FROM Products WHERE ProName LIKE ?";
    private static final String UPDATE_PRODUCT_MANAGER = "UPDATE Products SET BrandID = ?, ProName = ?, Description = ?, Image = ? , Country = ?,  FragranceFamilies= ?, Status = ? WHERE ProductID = ?";
    private static final String INSERT_PRODUCT_MANAGER = "INSERT INTO Products(BrandID, ManagerID, Description, Image, ProName, Status, Country, ReleaseDate, FragranceFamilies) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE_PRODUCT_BY_NAME = "SELECT ProductID FROM Products WHERE ProName LIKE ?";
    private static final String DELETE_PRODUCT_MANAGER = "DELETE FROM Products WHERE ProductID = ? ";
    private static final String DESCENDING_PRODUCT_BY_PRICE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                            + "WHERE P.Status = 1 AND PC.CategoryID = ? "
                                                            + "ORDER BY PD.Price DESC";
    private static final String ASCENDING_PRODUCT_BY_PRICE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                            + "WHERE P.Status = 1 AND PC.CategoryID = ? "
                                                            + "ORDER BY PD.Price ASC";
    private static final String DESCENDING_PRODUCT_BY_PRICE_BRAND = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                  + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                  + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                  + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                  + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                  + "WHERE PC.CategoryID = ? AND P.BrandID = ? "
                                                                  + "ORDER BY PD.Price DESC";
    private static final String ASCENDING_PRODUCT_BY_PRICE_BRAND = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                 + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                 + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                 + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                 + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                 + "WHERE PC.CategoryID = ? AND P.BrandID = ? "
                                                                 + "ORDER BY PD.Price ASC";
    private static final String DESCENDING_PRODUCT_BY_PRICE_SIZE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                 + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                 + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                 + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                 + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                 + "WHERE PC.CategoryID = ? AND PD.SizeID = ? "
                                                                 + "ORDER BY PD.Price DESC";
    private static final String ASCENDING_PRODUCT_BY_PRICE_SIZE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                 + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                 + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                 + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                 + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                 + "WHERE PC.CategoryID = ? AND PD.SizeID = ? "
                                                                 + "ORDER BY PD.Price ASC";
    private static final String DESCENDING_PRODUCT_BY_PRICE_BRAND_SIZE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                       + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                       + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                       + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                       + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                       + "WHERE PC.CategoryID = ? AND P.BrandID = ? AND PD.SizeID = ? "
                                                                       + "ORDER BY PD.Price DESC";
    private static final String ASCENDING_PRODUCT_BY_PRICE_BRAND_SIZE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                      + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                      + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                      + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                      + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                      + "WHERE PC.CategoryID = ? AND P.BrandID = ? AND PD.SizeID = ? "
                                                                      + "ORDER BY PD.Price ASC";
    private static final String DESCENDING_CHILD_SEARCH_RESULT_BY_RPICE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                        + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                        + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                        + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                        + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                        + "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4 AND PD.SizeID = ? "
                                                                        + "ORDER BY PD.Price DESC";
    private static final String ASCENDING_CHILD_SEARCH_RESULT_BY_RPICE =  "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                        + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                        + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                        + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                        + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                        + "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4 AND PD.SizeID = ? "
                                                                        + "ORDER BY PD.Price ASC";
    private static final String DESCENDING_SEARCH_RESULT_BY_RPICE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                  + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                  + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                  + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                  + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                  + "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4 "
                                                                  + "ORDER BY PD.Price DESC";
    private static final String ASCENDING_SEARCH_RESULT_BY_RPICE =  "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                  + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                  + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                  + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                  + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                  + "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4 "
                                                                  + "ORDER BY PD.Price ASC";
    private static final String PRODUCT_INFORMATION = "SELECT P.ProductID, P.BrandID, P.ProName, P.Description, P.Country, P.ReleaseDate, P.FragranceFamilies FROM Products P "
                                                    + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                    + "WHERE P.ProductID = ?";
    private static final String SORT_BY_PURCHASING = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                   + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                   + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                   + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                   + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                   + "WHERE PC.CategoryID = ? AND P.Status = 1 AND PD.Status = 1 AND P.BrandID = ? AND PD.SizeID = ? "
                                                   + "ORDER BY PD.NumberOfPurchasing DESC";
    private static final String SORT_BY_PURCHASING_2 = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                    + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                    + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                    + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                    + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                    + "WHERE PC.CategoryID = ? AND P.BrandID = ? AND P.Status = 1 AND PD.Status = 1 "
                                                    + "ORDER BY PD.NumberOfPurchasing DESC";
    private static final String SORT_BY_PURCHASING_3 = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                   + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                   + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                   + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                   + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                   + "WHERE PC.CategoryID = ? AND PD.SizeID = ? AND P.Status = 1 AND PD.Status = 1 "
                                                   + "ORDER BY PD.NumberOfPurchasing DESC";
    private static final String SORT_BY_PURCHASING_ALL = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                   + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                   + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                   + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                   + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                   + "WHERE PC.CategoryID = ? AND P.Status = 1 AND PD.Status = 1 "
                                                   + "ORDER BY PD.NumberOfPurchasing DESC";
    private static final String SORT_SEARCH_RESULT_BY_PURCHASING_2 = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                    + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                    + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                    + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                    + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                    + "WHERE P.ProName LIKE ? AND PC.CategoryID = 4 AND P.Status = 1 AND PD.Status = 1 "
                                                                    + "ORDER BY PD.NumberOfPurchasing DESC";
    private static final String SORT_SEARCH_RESULT_BY_PURCHASING_1 = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                                    + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                                    + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                                    + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                                    + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                                    + "WHERE P.ProName LIKE ? AND PD.SizeID = ? AND PC.CategoryID = 4 AND P.Status = 1 AND PD.Status = 1"
                                                                    + "ORDER BY PD.NumberOfPurchasing DESC";
    
    private static final String COUNT ="SELECT  COUNT(ProductID) as ProductID FROM Products";
    public List<ViewProductDTO> getListProduct(String search) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
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
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }
    
    public List<ProductDTO> getListProductManager(String search) throws ClassNotFoundException, SQLException {
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
                    String country = rs.getString("Country");
                    int releaseDate = rs.getInt("ReleaseDate");
                    String fragranceFamilies = rs.getString("FragranceFamilies");
                    ProductDTO newPro = new ProductDTO(productID, managerID, brandID, proName, descrip, image, country, releaseDate, fragranceFamilies, status);
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
//          UPDATE Products SET BrandID = ?, ProName = ?, Description = ?, Image = ? , Country = ?, FragranceFamilies=?, Status = ? WHERE ProductID = ?
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_PRODUCT_MANAGER);
                ptm.setInt(1, pro.getBrandID());
                ptm.setString(2, pro.getName());
                ptm.setString(3, pro.getDescription());
                ptm.setString(4, pro.getImage());
                ptm.setString(5, pro.getCountry());
                ptm.setString(6, pro.getFragranceFamilies());
                ptm.setInt(7, pro.getStatus());
                ptm.setInt(8, pro.getProductID());
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

    public int addProduct(String name, int brandID, int managerID, String description, String country, int releaseYear, String fragranceFamilies  ,String imagePath, int status) throws SQLException, ClassNotFoundException {
//      INSERT INTO Products(BrandID, ManagerID, Description, Image, ProName, Status, Country, ReleaseDate, FragranceFamilies) VALUES(?,?,?,?,?,?,?,?,?)
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        int productID = -1;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT_PRODUCT_MANAGER, PreparedStatement.RETURN_GENERATED_KEYS);
                ptm.setInt(1, brandID);
                ptm.setInt(2, managerID);
                ptm.setString(3, description);
                ptm.setString(4, imagePath);
                ptm.setString(5, name);
                ptm.setInt(6, status);
                ptm.setString(7, country);
                ptm.setInt(8, releaseYear);
                ptm.setString(9, fragranceFamilies);
                int check = ptm.executeUpdate();
                if(check>0){
                    rs = ptm.getGeneratedKeys();
                    if(rs.next()){
                        productID = rs.getInt(1);
                    }
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
        return productID;
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
    
    public List<ViewProductDTO> filterProductByChildBrand(int categoryID, int brandID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProductByChildBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_PRODUCT_BY_CHILD_BRAND);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                ptm.setInt(3, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProductByChildBrand.add(new ViewProductDTO(categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProductByChildBrand;
    }

    public boolean deleteProductManager(int productID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(DELETE_PRODUCT_MANAGER);
                ptm.setInt(1, productID);
                check = ptm.executeUpdate()>0;
            }
        } finally{
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }

    public List<ViewProductDTO> filterProductBySize(int sizeID, int categoryID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProductByBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_PRODUCT_BY_SIZE);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProductByBrand.add(new ViewProductDTO(categoryID, 0, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProductByBrand;
    }
    
    public List<ViewProductDTO> filterProductByChildSize(int categoryID, int brandID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProductByBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_PRODUCT_BY_CHILD_SIZE);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                ptm.setInt(3, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
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

    public List<ViewProductDTO> filterSearchResultBySize(String search, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_SEARCH_RESULT_BY_SIZE);
                ptm.setString(1, "%" + search + "%");
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ProductDTO> getProductInformation(int productID) throws ClassNotFoundException, SQLException {
        List<ProductDTO> productInformation = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(PRODUCT_INFORMATION);
                ptm.setInt(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int brandID = rs.getInt("BrandID");
                    String productName = rs.getString("ProName");
                    String description = rs.getString("Description");
                    String country = rs.getString("Country");
                    int releaseDate = rs.getInt("ReleaseDate");
                    String fragranceFamilies = rs.getString("FragranceFamilies");
                    productInformation.add(new ProductDTO(productID, brandID, 0, productName, description, "", country, releaseDate, fragranceFamilies, 0));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return productInformation;
    }   

    public List<ViewProductDTO> DescendingSearchResultByPrice(String search) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DESCENDING_SEARCH_RESULT_BY_RPICE);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, brandID, productID, 0, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }
    
    public List<ViewProductDTO> AscendingSearchResultByPrice(String search) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ASCENDING_SEARCH_RESULT_BY_RPICE);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, brandID, productID, 0, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }
    
    public List<ViewProductDTO> DescendingChildSearchResultByPrice(String search, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DESCENDING_CHILD_SEARCH_RESULT_BY_RPICE);
                ptm.setString(1, "%" + search + "%");
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }
    
    public List<ViewProductDTO> AscendingChildSearchResultByPrice(String search, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ASCENDING_CHILD_SEARCH_RESULT_BY_RPICE);
                ptm.setString(1, "%" + search + "%");
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }
    
    public List<ViewProductDTO> DescendingListProductByPrice(int categoryID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listDescendingProductPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DESCENDING_PRODUCT_BY_PRICE);
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
    
     public List<ViewProductDTO> AscendingListProductByPrice(int categoryID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listDescendingProductPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ASCENDING_PRODUCT_BY_PRICE);
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

    public List<ViewProductDTO> DescendingListChildProductByPrice2(int categoryID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> DescendingListChildProductByPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DESCENDING_PRODUCT_BY_PRICE_SIZE);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    DescendingListChildProductByPrice.add(new ViewProductDTO(categoryID, 0, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return DescendingListChildProductByPrice;
    }
    
    public List<ViewProductDTO> AscendingListChildProductByPrice2(int categoryID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ASCENDING_PRODUCT_BY_PRICE_SIZE);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(categoryID, 0, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }
    
    public List<ViewProductDTO> DescendingListChildProductByPrice(int categoryID, int brandID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> DescendingListChildProductByPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DESCENDING_PRODUCT_BY_PRICE_BRAND);
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
    
    public List<ViewProductDTO> AscendingListChildProductByPrice(int categoryID, int brandID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ASCENDING_PRODUCT_BY_PRICE_BRAND);
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
                    listProduct.add(new ViewProductDTO(categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ViewProductDTO> DescendingAllListProductByPrice(int categoryID, int brandID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> DescendingListChildProductByPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DESCENDING_PRODUCT_BY_PRICE_BRAND_SIZE);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                ptm.setInt(3, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
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

    public List<ViewProductDTO> AscendingAllListProductByPrice(int categoryID, int brandID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ASCENDING_PRODUCT_BY_PRICE_BRAND_SIZE);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                ptm.setInt(3, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ViewProductDTO> sortByPurchasing(int categoryID, int brandID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SORT_BY_PURCHASING);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                ptm.setInt(3, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ViewProductDTO> sortbyPurchasing2(int categoryID, int brandID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SORT_BY_PURCHASING_2);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(categoryID, brandID, productID, 0, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ViewProductDTO> sortbyPurchasing3(int categoryID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SORT_BY_PURCHASING_3);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(categoryID, 0, productID, sizeID, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ViewProductDTO> sortByPurchasingAll(int categoryID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SORT_BY_PURCHASING_ALL);
                ptm.setInt(1, categoryID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(categoryID, 0, productID, 0, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ViewProductDTO> sortSearchResultByPurChasing1(String search, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SORT_SEARCH_RESULT_BY_PURCHASING_1);
                ptm.setString(1, "%" + search + "%");
                ptm.setInt(2, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, 0, productID, 0, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ViewProductDTO> sortSearchResultByPurChasing2(String search) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SORT_SEARCH_RESULT_BY_PURCHASING_2);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, 0, productID, 0, sizeName, brandName, productName, price, image));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listProduct;
    }

    public List<ProductDTO> countAllProduct() throws SQLException, ClassNotFoundException, NamingException {
        List<ProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if( conn != null){
                ptm = conn.prepareStatement(COUNT);
                rs = ptm.executeQuery();
                while (rs.next()){
                    int productID = rs.getInt("ProductID");
                    listProduct.add(new ProductDTO(productID, 0, 0, "", "", "", "", 0, "", 0));
                }
            }
        } finally {
            if (rs != null){
                rs.close();
            }
            if(ptm != null){
                ptm.close();
            }
            if( conn != null){
                conn.close();
            }
        }
        return listProduct;
    }

}
