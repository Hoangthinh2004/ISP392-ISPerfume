/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.user;

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
public class UserDAO {

    private static final String LIST_USER = "SELECT UserID, Name, Email, Phone, Status, RoleID FROM Users";
    private static final String UPDATE = "UPDATE Users SET Name=?, Email=?, Phone=?, RoleID=? WHERE UserID=?";
    private static final String FILTER_EMPLOYEE = "SELECT UserID, Name, Email, Phone, Status, RoleID FROM Users where RoleID not like 1";
    private static final String FILTER_CUSTOMER = "SELECT UserID, Name, Email, Phone, Status, RoleID FROM Users where RoleID = 1";
    private static final String UPDATE_USER_STATUS = "UPDATE Users SET Status=? WHERE UserID=?";

    public List<UserDTO> getListUser() throws SQLException, ClassNotFoundException, NamingException {
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_USER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    int status = rs.getInt("Status");
                    int roleID = rs.getInt("RoleID");
                    listUser.add(new UserDTO(userID, name, email, "", phone, status, roleID));
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
        return listUser;
    }

    public boolean update(UserDTO user) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, user.getName());
                ptm.setString(2, user.getEmail());
                ptm.setString(3, user.getPhone());
                ptm.setInt(4, user.getRoleID());
                ptm.setInt(5, user.getUserID());
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

    public List<UserDTO> filterEmployee() throws SQLException, ClassNotFoundException, NamingException {
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_EMPLOYEE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    int status = rs.getInt("Status");
                    int roleID = rs.getInt("RoleID");
                    listUser.add(new UserDTO(userID, name, email, "", phone, status, roleID));
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
        return listUser;
    }

    public List<UserDTO> filterCustomer() throws SQLException, ClassNotFoundException, NamingException {
        List<UserDTO> listUser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(FILTER_CUSTOMER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String name = rs.getString("Name");
                    String email = rs.getString("Email");
                    String phone = rs.getString("Phone");
                    int status = rs.getInt("Status");
                    int roleID = rs.getInt("RoleID");
                    listUser.add(new UserDTO(userID, name, email, "", phone, status, roleID));
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
        return listUser;
    }

    public boolean updateUserStatus(UserDTO user) throws SQLException, ClassNotFoundException, NamingException {
         boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_USER_STATUS);
                ptm.setInt(1, user.getStatus());
                ptm.setInt(2, user.getUserID());
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
