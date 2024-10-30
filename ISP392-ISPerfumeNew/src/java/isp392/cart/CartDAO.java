/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.cart;

import isp392.product.ProductDetailDTO;
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
public class CartDAO {

    private static final String ADD_TO_CART = "INSERT INTO CartsDetail(CartID, ProductDetailID, Quantity) VALUES (?, ?, ?)";
    private static final String VIEW_CART = "SELECT P.ProductID, P.ProName, PD.SizeID, S.Name , PD.Price, PD.Image, C.TotalQuantity FROM ProductDetail PD "
            + "INNER JOIN Products P ON PD.ProductID = P.ProductID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "INNER JOIN Carts C ON C.productID = PD.ProductID "
            + "WHERE C.CustomerID = ? AND P.ProductID = ? AND PD.SizeID = ?";
    private static final String VIEW_CART_DETAIL = "SELECT C.CustomerID, C.CartID, CD.ProductDetailID, S.Name, P.ProName, PD.Price, PD.Image, CD.Quantity FROM Carts C "
            + "INNER JOIN CartsDetail CD ON CD.CartID = C.CartID "
            + "INNER JOIN ProductDetail PD ON PD.ProductDetailID = CD.ProductDetailID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "INNER JOIN Products P ON P.ProductID = PD.ProductID "
            + "WHERE C.CustomerID = ?";
    private static final String GET_DETAIL = "SELECT PD.ProductDetailID FROM ProductDetail PD "
            + "WHERE PD.ProductID = ? AND PD.SizeID = ?";

    private static final String CHECK_EXIST = "SELECT * FROM Carts C "
            + "INNER JOIN CartsDetail CD ON CD.CartID = C.CartID "
            + "WHERE CD.ProductDetailID = ? AND C.CustomerID = ?";
    private static final String GET_CARTID = "SELECT C.CartID FROM Carts C WHERE C.CustomerID = ?";
    private static final String GET_QUANTITY = "SELECT CD.Quantity FROM Carts C "
            + "INNER JOIN CartsDetail CD ON CD.CartID = C.CartID "
            + "WHERE CD.ProductDetailID = ? AND C.CustomerID = ?";
    private static final String UPDATE_QUANTITY = "UPDATE CartsDetail SET Quantity = ? WHERE ProductDetailID = ?";
    private static final String DELETE_CART = "DELETE CD FROM CartsDetail CD "
            + "INNER JOIN Carts C ON C.CartID = CD.CartID "
            + "WHERE CD.ProductDetailID = ? AND C.CustomerID = ?";
    private static final String ADD_NEW_CART = "INSERT INTO Carts(CustomerID) VALUES (?)";
    private static final String GET_CART_SIZE = "SELECT COUNT (*) FROM CartsDetail CD "
            + "INNER JOIN Carts C ON C.CartID = CD.CartID "
            + "WHERE C.CustomerID = ?";
    private static final String VIEW_CHECKOUT_DETAIL = "SELECT C.CustomerID, C.CartID, CD.ProductDetailID, S.Name, P.ProName, PD.Price, PD.Image, CD.Quantity FROM Carts C "
            + "INNER JOIN CartsDetail CD ON CD.CartID = C.CartID "
            + "INNER JOIN ProductDetail PD ON PD.ProductDetailID = CD.ProductDetailID "
            + "INNER JOIN Size S ON S.SizeID = PD.SizeID "
            + "INNER JOIN Products P ON P.ProductID = PD.ProductID "
            + "WHERE CD.ProductDetailID = ?";
    private static final String CHECK_QUANTITY = "SELECT PD.ProductDetailID, PD.StockQuantity FROM ProductDetail PD "
            + "WHERE PD.ProductDetailID = ? AND PD.StockQuantity >= ?";
    private static final String DELETE_CART_DETAIL = "DELETE FROM CartsDetail WHERE CartID = ? AND ProductDetailID = ?";

    public List<ViewCartDTO> getProductDetailID(int customerID) throws ClassNotFoundException, SQLException {
        List<ViewCartDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_CART_DETAIL);
                ptm.setInt(1, customerID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    String productName = rs.getString("ProName");
                    String sizeName = rs.getString("Name");
                    int quantity = rs.getInt("Quantity");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewCartDTO(customerID, productDetailID, productName, sizeName, price, image, quantity));
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

//    public List<ProductDetailDTO> getDetail() throws ClassNotFoundException, SQLException {
//        Connection conn = null;
//        PreparedStatement ptm = null;
//        ResultSet rs = null;
//        List<ProductDetailDTO> list = new ArrayList<>();
//        try {
//            conn = DBUtils.getConnection();
//            if (conn != null) {
//                ptm = conn.prepareStatement(GET_DETAIL);
//                rs = ptm.executeQuery();
//                while (rs.next()) {
//                    int productID = rs.getInt("ProductID");;
//                    int sizeID = rs.getInt("SizeID");
//                    int price = rs.getInt("Price");
//                    String image = rs.getString("Image");
//                    list.add(new ProductDetailDTO(productID, sizeID, price, 0, 0, null, image, 0));
//                }
//            }
//        } finally {
//            if (rs != null) {
//                rs.close();
//            }
//            if (ptm != null) {
//                ptm.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//        return list;
//    }
    public List<CartDTO> checkExistProduct(int productDetailID, int customerID) throws ClassNotFoundException, SQLException {
        List<CartDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_EXIST);
                ptm.setInt(1, productDetailID);
                ptm.setInt(2, customerID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    listProduct.add(new CartDTO(0, 0));
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

    public int getQuantity(int productDetailID, int customerID) throws ClassNotFoundException, SQLException {
        int quantity = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_QUANTITY);
                ptm.setInt(1, productDetailID);
                ptm.setInt(2, customerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("Quantity");
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
        return quantity;
    }

    public boolean addToCart(CartDetailDTO cartDetail) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_TO_CART);
                ptm.setInt(1, cartDetail.getCartID());
                ptm.setInt(2, cartDetail.getProductDetailID());
                ptm.setInt(3, cartDetail.getQuantity());
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

    public boolean deleteCart(int productDetailID, int customerID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_CART);
                ptm.setInt(1, productDetailID);
                ptm.setInt(2, customerID);
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

    public int getCarID(int customerID) throws ClassNotFoundException, SQLException {
        int cartID = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CARTID);
                ptm.setInt(1, customerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    cartID = rs.getInt("CartID");
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
        return cartID;
    }

    public boolean updateQuantity(CartDetailDTO cartDetail, int productDetailID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_QUANTITY);
                ptm.setInt(1, cartDetail.getQuantity());
                ptm.setInt(2, productDetailID);
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

    public boolean createCart(CartDTO cart) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(ADD_NEW_CART);
                ptm.setInt(1, cart.getCustomerID());
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

    public int getCartSize(int customerID) throws ClassNotFoundException, SQLException {
        int size = 0;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CART_SIZE);
                ptm.setInt(1, customerID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    size = rs.getInt(1);
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
        return size;
    }

    public List<ViewCartDTO> getProductInfor(int parseInt, int customerID) throws ClassNotFoundException, SQLException {
        List<ViewCartDTO> listProduct = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(VIEW_CHECKOUT_DETAIL);
                ptm.setInt(1, parseInt);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int productDetailID = rs.getInt("ProductDetailID");
                    String productName = rs.getString("ProName");
                    String sizeName = rs.getString("Name");
                    int quantity = rs.getInt("Quantity");
                    String image = rs.getString("Image");
                    int price = rs.getInt("Price");
                    listProduct.add(new ViewCartDTO(customerID, productDetailID, productName, sizeName, price, image, quantity));
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

    public boolean checkQuantity(int productDetailID, int quantity) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_QUANTITY);
                ptm.setInt(1, productDetailID);
                ptm.setInt(2, quantity);
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

    public boolean deleteCartDetail(int cartID, int productDetailID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE_CART_DETAIL);
                ptm.setInt(1, cartID);
                ptm.setInt(2, productDetailID);
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

}
