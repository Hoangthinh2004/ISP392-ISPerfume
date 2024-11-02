/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ThinhHoang
 */
public class DBUtils {
    private static final String DB_NAME="ISPerfume";
    private static final String PASSWORD="12345";
    private static final String USER_NAME="SA";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName="+ DB_NAME;
        conn= DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
    
    public static void closeConnection3(Connection conn, PreparedStatement ptm, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (ptm != null) {
                ptm.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void closeConnection2(Connection conn, PreparedStatement ptm) {
        try {
            if (ptm != null) {
                ptm.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
