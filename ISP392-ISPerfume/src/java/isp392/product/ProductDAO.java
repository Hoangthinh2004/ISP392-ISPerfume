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
    private static final String LIST_PRODUCT = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                            +  "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                            +  "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                            +  "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                            +  "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                            +  "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4";
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
    private static final String LIST_PRODUCT_MANAGER = "SELECT ProductID, BrandID, ManagerID, ProName, Description, Image, Status FROM Products WHERE ProName LIKE ? AND Status = 1";
    private static final String UPDATE_PRODUCT_MANAGER = "UPDATE Products SET BrandID = ?, ProName = ?, Description = ?, Image = ? WHERE ProductID = ?";
    private static final String INSERT_PRODUCT_MANAGER = "INSERT INTO Products(BrandID, ManagerID, Description, Image, ProName, Status) VALUES(?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE_PRODUCT_BY_NAME = "SELECT ProductID FROM Products WHERE ProName LIKE ?";
    private static final String DELETE_PRODUCT_MANAGER = "UPDATE Products SET Status = 0 WHERE ProductID = ? ";
    private static final String DESCENDING_PRODUCT_BY_PRICE = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                            + "WHERE P.Status = 1 AND PC.CategoryID = ? "
                                                            + "ORDER BY PD.Price DESC";
    private static final String DESCENDING_PRODUCT_BY_PRICE_2 = "SELECT P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
                                                              + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                              + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                              + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                              + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                              + "WHERE PC.CategoryID = ? AND P.BrandID = ? "
                                                              + "ORDER BY PD.Price DESC";
    
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
                    ProductDTO newPro = new ProductDTO(productID, managerID, brandID, proName, descrip, image, status);
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

    public int addProduct(String name, int brandID, int managerID, String description, String imagePath, int status) throws SQLException, ClassNotFoundException {
//        INSERT INTO Products(BrandID, ManagerID ,Description, Image, ProName, Status) VALUES(?,?,?,?,?,?)
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

    public List<ViewProductDTO> DescendingListChildProductByPrice(int categoryID, int brandID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> DescendingListChildProductByPrice = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DESCENDING_PRODUCT_BY_PRICE_2);
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
}
