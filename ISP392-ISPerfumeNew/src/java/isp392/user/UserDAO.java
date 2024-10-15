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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author ThinhHoang
 */
public class UserDAO {

    private final String INSERT_USER_GOOGLE = "INSERT INTO Users(Name, Email, Password, Phone, RoleID, Status) VALUES (?,?,?,?,?,1)";
    private final String INSERT_CUSTOMER_GOOGLE = "INSERT INTO Customer(CustomerID, Area, District, Ward, DetailAddress, DayOfBirth) VALUES(?,?,?,?,?,?)";
    private final String CHECK_USER_BY_EMAIL = "SELECT * FROM Users WHERE Email LIKE ?";
    private final String CHECK_USER_BY_PHONE = "SELECT * FROM Users WHERE Phone LIKE ?";
    private final String GET_CUSTOMER_BY_USERID = "SELECT * FROM Customer WHERE CustomerID = ?";
    private static final String LIST_USER = "SELECT UserID, Name, Email,Phone, Status, RoleID FROM Users";
    private static final String UPDATE = "UPDATE Users SET Name=?, Email=?, Phone=?, RoleID=? WHERE UserID=?";
    private static final String FILTER_EMPLOYEE = "SELECT UserID, Name, Email, Phone, Status, RoleID FROM Users where RoleID not like 1";
    private static final String FILTER_CUSTOMER = "SELECT UserID, Name, Email, Phone, Status, RoleID FROM Users where RoleID =1";
    private static final String UPDATE_USER_STATUS = "UPDATE Users SET Status=? WHERE UserID=?";

    public boolean checkEmailExisted(String email) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_USER_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return check;
    }

    public boolean addNewUser(UserDTO newUser, CustomerDTO newCust) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement userptm = null;
        PreparedStatement custptm = null;
        ResultSet rs = null;
//      INSERT INTO Users(Name, Email, Password, Phone, RoleID, Status) VALUES (?,?,?,?,?,1)
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                userptm = conn.prepareStatement(INSERT_USER_GOOGLE, PreparedStatement.RETURN_GENERATED_KEYS);
                userptm.setString(1, newUser.getName());
                userptm.setString(2, newUser.getEmail());
                userptm.setString(3, newUser.getPassword());
                userptm.setString(4, newUser.getPhone());
                userptm.setInt(5, newUser.getRoleID());
                int checkAddUser = userptm.executeUpdate();
                if (checkAddUser > 0) {
                    rs = userptm.getGeneratedKeys();
                    if (rs.next()) {
//                      INSERT INTO Customer(CustomerID, Area, District, Ward, DetailAddress, DayOfBirth) VALUES(?,?,?,?,?,null)
                        int custID = rs.getInt(1);
                        custptm = conn.prepareStatement(INSERT_CUSTOMER_GOOGLE);
                        custptm.setInt(1, custID);
                        custptm.setString(2, newCust.getArea());
                        custptm.setString(3, newCust.getDistrict());
                        custptm.setString(4, newCust.getWard());
                        custptm.setString(5, newCust.getDetailAddress());
                        custptm.setDate(6, newCust.getDayOfBirth());
                        check = custptm.executeUpdate() > 0;
                    }
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

    public UserDTO getUserByGoogleEmail(String email) throws ClassNotFoundException, SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_USER_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int userID = rs.getInt("UserID");
                    String name = rs.getString("Name");
                    String userEmail = rs.getString("Email");
                    String password = rs.getString("Password");
                    String phone = rs.getString("Phone");
                    int status = rs.getInt("Status");
                    int roleID = rs.getInt("RoleID");
                    user = new UserDTO(userID, name, userEmail, password, phone, roleID, status);
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return user;
    }

    public CustomerDTO getCustInfoByID(int userID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        CustomerDTO cust = null;
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
                    cust = new CustomerDTO(custID, area, district, ward, detailAddress, dob);
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return cust;
    }

    public boolean checkPhoneNumExisted(String phoneNum) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_USER_BY_PHONE);
                ptm.setString(1, phoneNum);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return check;
    }

    public List<UserDTO> filterCustomer() throws SQLException, NamingException, ClassNotFoundException {
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

    public List<UserDTO> filterEmployee() throws SQLException, NamingException, ClassNotFoundException {
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
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return listUser;
    }

    public List<UserDTO> getListUser() throws ClassNotFoundException, SQLException, NamingException {
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
                    listUser.add(new UserDTO(userID, name, email, phone, phone, status, roleID));
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

    public boolean updateUserStatus(UserDTO user) throws SQLException, NamingException, ClassNotFoundException {
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
