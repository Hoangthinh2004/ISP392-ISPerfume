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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.naming.NamingException;

/**
 *
 * @author ThinhHoang
 */
public class ProductDAO {

    private static final String LIST_PRODUCT = "SELECT PD.ProductDetailID, P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
            + "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4";
    private static final String LIST_PRODUCT_MANAGER = "SELECT ProductID, BrandID, ManagerID, ProName, Description, Image, Country, ReleaseDate, FragranceFamilies, Status FROM Products WHERE ProName LIKE ?";
    private static final String UPDATE_PRODUCT_MANAGER = "UPDATE Products SET BrandID = ?, ProName = ?, Description = ?, Image = ? , Country = ?,  FragranceFamilies= ?, Status = ? WHERE ProductID = ?";
    private static final String INSERT_PRODUCT_MANAGER = "INSERT INTO Products(BrandID, ManagerID, Description, Image, ProName, Status, Country, ReleaseDate, FragranceFamilies) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE_PRODUCT_BY_NAME = "SELECT ProductID FROM Products WHERE ProName LIKE ?";
    private static final String DELETE_PRODUCT_MANAGER = "DELETE FROM Products WHERE ProductID = ? ";
    private static final String PRODUCT_INFORMATION = "SELECT P.ProductID, P.BrandID, P.ProName, P.Description, P.Country, P.ReleaseDate, P.FragranceFamilies FROM Products P "
            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
            + "WHERE P.ProductID = ?";

    private static final String COUNT ="SELECT  COUNT(ProductID) as ProductID FROM Products WHERE Status = 1";
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
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(0, productDetailID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
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

    public int addProduct(String name, int brandID, int managerID, String description, String country, int releaseYear, String fragranceFamilies, String imagePath, int status) throws SQLException, ClassNotFoundException {
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
                if (check > 0) {
                    rs = ptm.getGeneratedKeys();
                    if (rs.next()) {
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

    public boolean deleteProductManager(int productID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_PRODUCT_MANAGER);
                ptm.setInt(1, productID);
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
        return productInformation;
    }

    private static final String SEARCH_RESULT = "SELECT PD.ProductDetailID, P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name, PD.Image, PD.Price, P.ProName FROM Products P "
            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
            + "WHERE P.ProName LIKE ? AND P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = 4 ";
    private static final String SIZE_FILTER_DESC = " AND PD.SizeID IN (%s) ORDER BY PD.Price DESC";
    private static final String PUR_FILTER_DESC = " AND PD.SizeID IN (%s) ORDER BY PD.NumberOfPurchasing DESC";
    private static final String SIZE_FILTER_ASC = " AND PD.SizeID IN (%s) ORDER BY PD.Price ASC";
    private static final String SIZE_FILTER = " AND PD.SizeID IN (%s)";

    private static final String CATEGORIZE_PRODUCT = "SELECT PD.ProductDetailID, P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name, PD.Image, PD.Price, P.ProName FROM Products P "
            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
            + "WHERE P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = ? ";
    private static final String SUGGEST_PRODUCT = "SELECT PD.ProductDetailID, P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name, PD.Image, PD.Price, P.ProName FROM Products P "
                                                + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
                                                + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
                                                + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
                                                + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
                                                + "WHERE P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = ? AND P.ProductID != ? AND PD.SizeID = ?";
    private static final String FILTER_PRODUCT_BY_BRAND = "SELECT PD.ProductDetailID, P.ProductID, PD.SizeID, PC.CategoryID, B.BrandID, B.BrandName, S.Name , PD.Image, PD.Price, P.ProName FROM Products P "
            + "INNER JOIN Product_Category PC ON P.ProductID = PC.ProductID "
            + "INNER JOIN ProductDetail PD ON PD.ProductID = P.ProductID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "INNER JOIN Brands B ON B.BrandID = P.BrandID "
            + "WHERE P.Status = 1 AND PD.Status = 1 AND PC.CategoryID = ? AND P.BrandID = ?";

    public List<ViewProductDTO> descendingProductByPrice(String search, List<Integer> sizeIDList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = SEARCH_RESULT;
                if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER_DESC, sizeParams);
                } else {
                    query += " ORDER BY PD.Price DESC";
                }

                ptm = conn.prepareStatement(query);
                ptm.setString(1, "%" + search + "%");

                if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 2, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 2 vì vị trí 1 là search key
                    }
                }
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, brandID, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> fiterSearchResult(String search, List<Integer> sizeList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = SEARCH_RESULT;
                if (sizeList != null && !sizeList.isEmpty()) {
                    String sizeParams = sizeList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER, sizeParams);
                }

                ptm = conn.prepareStatement(query);
                ptm.setString(1, "%" + search + "%");

                if (sizeList != null && !sizeList.isEmpty()) {
                    for (int i = 0; i < sizeList.size(); i++) {
                        ptm.setInt(i + 2, sizeList.get(i)); // Bắt đầu từ vị trí thứ 2 vì vị trí 1 là search key
                    }
                }
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, brandID, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> filterListProduct(int categoryID, List<Integer> sizeList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = CATEGORIZE_PRODUCT;
                if (sizeList != null && !sizeList.isEmpty()) {
                    String sizeParams = sizeList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER, sizeParams);
                }

                ptm = conn.prepareStatement(query);
                ptm.setInt(1, categoryID);

                if (sizeList != null && !sizeList.isEmpty()) {
                    for (int i = 0; i < sizeList.size(); i++) {
                        ptm.setInt(i + 2, sizeList.get(i)); // Bắt đầu từ vị trí thứ 2 vì vị trí 1 là search key
                    }
                }

                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, brandID, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> filterListProductBrandID(int categoryID, int brandID, List<Integer> sizeList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = CATEGORIZE_PRODUCT + "AND p.BrandID = ?";
                if (sizeList != null && !sizeList.isEmpty()) {
                    String sizeParams = sizeList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER, sizeParams);
                }

                ptm = conn.prepareStatement(query);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, brandID);

                if (sizeList != null && !sizeList.isEmpty()) {
                    for (int i = 0; i < sizeList.size(); i++) {
                        ptm.setInt(i + 3, sizeList.get(i)); // Bắt đầu từ vị trí thứ 2 vì vị trí 1 là search key
                    }
                }

                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, brandID, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> descendingCategorizeProduct(int categoryID, List<Integer> brandID, List<Integer> sizeIDList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = CATEGORIZE_PRODUCT;
                if ((brandID != null && !brandID.isEmpty()) && (sizeIDList != null && !sizeIDList.isEmpty())) {
                    query += "AND P.BrandID = ?";
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER_DESC, sizeParams);
                } else if (brandID != null && !brandID.isEmpty()) {
                    query += "AND P.BrandID = ? ORDER BY PD.Price DESC";
                } else if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER_DESC, sizeParams);
                } else {
                    query += " ORDER BY PD.Price DESC";
                }

                ptm = conn.prepareStatement(query);
                ptm.setInt(1, categoryID);
                if ((brandID != null && !brandID.isEmpty()) && (sizeIDList != null && !sizeIDList.isEmpty())) {
                    ptm.setInt(2, brandID.get(0));
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 3, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 3
                    }
                } else if (brandID != null && !brandID.isEmpty()) {
                    ptm.setInt(2, brandID.get(0));
                } else if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 2, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 2
                    }
                }
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, 0, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> getListProductByCategory(int categoryID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProductByCategory = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CATEGORIZE_PRODUCT);
                ptm.setInt(1, categoryID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProductByCategory.add(new ViewProductDTO(productDetailID, categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
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
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int sizeID = rs.getInt("SizeID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProductByBrand.add(new ViewProductDTO(productDetailID, categoryID, brandID, productID, sizeID, sizeName, brandName, productName, price, image));
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
        return listProductByBrand;
    }

    public List<ViewProductDTO> ascendingProductByPrice(String search, List<Integer> sizeIDList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = SEARCH_RESULT;
                if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER_ASC, sizeParams);
                } else {
                    query += " ORDER BY PD.Price ASC";
                }

                ptm = conn.prepareStatement(query);
                ptm.setString(1, "%" + search + "%");

                if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 2, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 2 vì vị trí 1 là search key
                    }
                }
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, brandID, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> ascendingCategorizeProduct(int categoryID, List<Integer> brandID, List<Integer> sizeIDList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = CATEGORIZE_PRODUCT;
                if ((brandID != null && !brandID.isEmpty()) && (sizeIDList != null && !sizeIDList.isEmpty())) {
                    query += "AND P.BrandID = ?";
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER_ASC, sizeParams);
                } else if (brandID != null && !brandID.isEmpty()) {
                    query += "AND P.BrandID = ? ORDER BY PD.Price ASC";
                } else if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(SIZE_FILTER_ASC, sizeParams);
                } else {
                    query += " ORDER BY PD.Price ASC";
                }

                ptm = conn.prepareStatement(query);
                ptm.setInt(1, categoryID);
                if ((brandID != null && !brandID.isEmpty()) && (sizeIDList != null && !sizeIDList.isEmpty())) {
                    ptm.setInt(2, brandID.get(0));
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 3, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 3
                    }
                } else if (brandID != null && !brandID.isEmpty()) {
                    ptm.setInt(2, brandID.get(0));
                } else if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 2, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 2
                    }
                }
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, 0, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> suggestListProduct(int categoryID, int productID, int sizeID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProductByCategory = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SUGGEST_PRODUCT);
                ptm.setInt(1, categoryID);
                ptm.setInt(2, productID);
                ptm.setInt(3, sizeID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productIDrela = rs.getInt("ProductID");
                    int sizeIDrela = rs.getInt("SizeID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProductByCategory.add(new ViewProductDTO(categoryID, productDetailID, brandID, productIDrela, sizeIDrela, sizeName, brandName, productName, price, image));
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
        return listProductByCategory;
    }

    public List<ViewProductDTO> sortCategorizeProductByPur(int categoryID, List<Integer> brandID, List<Integer> sizeIDList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = CATEGORIZE_PRODUCT;
                if ((brandID != null && !brandID.isEmpty()) && (sizeIDList != null && !sizeIDList.isEmpty())) {
                    query += "AND P.BrandID = ?";
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(PUR_FILTER_DESC, sizeParams);
                } else if (brandID != null && !brandID.isEmpty()) {
                    query += "AND P.BrandID = ? ORDER BY PD.NumberOfPurchasing DESC";
                } else if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(PUR_FILTER_DESC, sizeParams);
                } else {
                    query += " ORDER BY PD.NumberOfPurchasing DESC";
                }

                ptm = conn.prepareStatement(query);
                ptm.setInt(1, categoryID);
                if ((brandID != null && !brandID.isEmpty()) && (sizeIDList != null && !sizeIDList.isEmpty())) {
                    ptm.setInt(2, brandID.get(0));
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 3, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 3
                    }
                } else if (brandID != null && !brandID.isEmpty()) {
                    ptm.setInt(2, brandID.get(0));
                } else if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 2, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 2
                    }
                }
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, 0, productID, 0, sizeName, brandName, productName, price, image));
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

    public List<ViewProductDTO> sortSearchResultByPur(String search, List<Integer> sizeIDList) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String query = SEARCH_RESULT;
                if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    String sizeParams = sizeIDList.stream().map(s -> "?").collect(Collectors.joining(","));
                    query += String.format(PUR_FILTER_DESC, sizeParams);
                } else {
                    query += " ORDER BY PD.NumberOfPurchasing DESC";
                }

                ptm = conn.prepareStatement(query);
                ptm.setString(1, "%" + search + "%");

                if (sizeIDList != null && !sizeIDList.isEmpty()) {
                    for (int i = 0; i < sizeIDList.size(); i++) {
                        ptm.setInt(i + 2, sizeIDList.get(i)); // Bắt đầu từ vị trí thứ 2 vì vị trí 1 là search key
                    }
                }
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    int productID = rs.getInt("ProductID");
                    int brandID = rs.getInt("BrandID");
                    String sizeName = rs.getString("Name");
                    String brandName = rs.getString("BrandName");
                    String productName = rs.getString("ProName");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewProductDTO(productDetailID, 0, brandID, productID, 0, sizeName, brandName, productName, price, image));
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
