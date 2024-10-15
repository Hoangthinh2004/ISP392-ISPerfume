/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.user;

import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 *
 * @author ThinhHoang
 */
public class UserDAO {
    
    private static final String LOGIN = "SELECT * FROM dbo.Users WHERE Email LIKE ? AND Password LIKE ?";
    private static final String GET_CUSTOMER_BY_USERID = "SELECT    u.UserID, u.Name, u.Email, u.Password, u.Phone, u.Status, u.RoleID, c.CustomerID, c.Area, c.District, c.Ward, c.DetailAddress, c.DayOfBirth\n"
            + "FROM         Users AS u INNER JOIN\n"
            + "                      Customer AS c ON u.UserID = c.CustomerID\n"
            + "WHERE     u.UserID = ?";
    private static final String UPDATE_PASSWORD = "UPDATE dbo.Users SET Password=? WHERE UserID=?";
    private static final String UPDATE_PROFILE_USER = "UPDATE dbo.Users SET Name=?, Email=?, Phone=? WHERE UserID=?";
    private static final String UPDATE_PROFILE_CUSTOMER = "UPDATE dbo.Customer SET DetailAddress=?, Area=?, District=?, Ward=?, DayOfBirth=? WHERE customerID=?";
    private static final String GET_PASSWORD_BY_ID = "SELECT Password FROM Users WHERE UserID = ?";
            
    
    public UserDTO checkLogin(String email, String password) throws SQLDataException, SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
//               SELECT * FROM dbo.Users WHERE Email LIKE ? AND Password LIKE ?
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String name = rs.getString("Name");
                    String emai11 = rs.getString("Email");
                    String password1 = rs.getString("Password");
                    String phone = rs.getString("Phone");
                    int status = rs.getInt("Status");
                    int roleID = rs.getInt("RoleID");
                    user = new UserDTO(userID, name, emai11, password1, phone, roleID, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return user;
    }
    
    public CustomerViewProfileDTO getCustInfoByUserID(int userID) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        CustomerViewProfileDTO cust = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_CUSTOMER_BY_USERID);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    
                    int custID = rs.getInt("CustomerID");
                    String area = rs.getString("Area");
                    String district = rs.getString("District");
                    String ward = rs.getString("Ward");
                    String detailAddress = rs.getString("DetailAddress");
                    Date dob = rs.getDate("DayOfBirth");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String password = rs.getString("Password");
                    String phone = rs.getString("Phone");
                    int status = rs.getInt("Status");
                    int roleID = rs.getInt("RoleID");
                    cust = new CustomerViewProfileDTO(custID, area, district, ward, detailAddress, dob, name, email, password, phone, roleID, status);
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
        return cust;
    }
    
    public boolean updatePassword(int userID, String newPassword) throws SQLException, ClassNotFoundException {
        boolean isUpdated = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //  "UPDATE dbo.Users SET Password=? WHERE UserID=?";
                ptm = conn.prepareStatement(UPDATE_PASSWORD);
                ptm.setString(1, newPassword);
                ptm.setInt(2, userID);
                isUpdated = ptm.executeUpdate() > 0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return isUpdated;
    }
    
    public boolean updateCustomerProfile(CustomerViewProfileDTO customer) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        PreparedStatement userptm = null;
        PreparedStatement custptm = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                // Update Users
                userptm = conn.prepareStatement(UPDATE_PROFILE_USER);
                String cusName = customer.getName();
                String cusemail = customer.getEmail();
                String cusphone = customer.getPhone();
                int id = customer.getId();
                userptm.setString(1, customer.getName());
                userptm.setString(2, customer.getEmail());
                userptm.setString(3, customer.getPhone());
                userptm.setInt(4, customer.getId());
                boolean checkUserUpdate = userptm.executeUpdate() > 0;
                if (checkUserUpdate) {
//                    UPDATE dbo.Customer SET DetailAddress=?, Area=?, District=?, Ward=?, DayOfBirth=? WHERE customerID=?
                    custptm = conn.prepareStatement(UPDATE_PROFILE_CUSTOMER);
                    custptm.setString(1, customer.getDetailAddress());
                    custptm.setString(2, customer.getArea());
                    custptm.setString(3, customer.getDistrict());
                    custptm.setString(4, customer.getWard());
                    custptm.setDate(5, customer.getDayOfBirth());
                    custptm.setInt(6, customer.getId());
                    check = custptm.executeUpdate() > 0;
                }
            }
        } finally {
            if (userptm != null) {
                userptm.close();
            }
            if (custptm != null) {
                custptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return check;
    }
    
    public String getPasswordByID(int userID) throws SQLException, ClassNotFoundException {
        String password = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(GET_PASSWORD_BY_ID);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                password = rs.getString("Password");
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return password;
    }
    
}
