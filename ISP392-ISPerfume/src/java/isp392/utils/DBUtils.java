/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ThinhHoang
 */
public class DBUtils {
    private static final String DB_NAME="";
    private static final String PASSWORD="12345";
    private static final String USER_NAME="SA";
    public static Connection getConnectionV1() throws ClassNotFoundException, SQLException {
        Connection conn= null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName="+ DB_NAME;
        conn= DriverManager.getConnection(url, USER_NAME, PASSWORD);
        return conn;
    }
}
