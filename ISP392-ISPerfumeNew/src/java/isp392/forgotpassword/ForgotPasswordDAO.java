/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.forgotpassword;

import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author duyhc
 */
public class ForgotPasswordDAO {

    private static final String CREATE_TOKEN = "INSERT INTO ForgotPassword(UserID, Token, ResetDate, TokenStatus) VALUES(?,?,GETDATE()+1,1)";
    private static final String GET_INFO_USERID = "SELECT TOP 1* FROM ForgotPassword WHERE UserID = ? AND TokenStatus = 1 ORDER BY ResetID DESC";
    private static final String CHECK_OTP = "SELECT * FROM ForgotPassword WHERE Token = ? AND ResetDate > GETDATE() AND TokenStatus = 1";
    private static final String DELETE_OTP = "UPDATE ForgotPassword SET TokenStatus = 0 WHERE Token = ? OR UserID = ?";
    public String createToken() {
        Random random = new Random();
        int opt = 1000 + random.nextInt(9000);
        return String.valueOf(opt);
    }

    public boolean insertToken(int userID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_TOKEN);
//                INSERT INTO ForgotPassword(UserID, Token, ResetDate, TokenStatus) VALUES(?,?,GETDATE(),1)
                ptm.setInt(1, userID);
                ptm.setString(2, createToken());
                check = ptm.executeUpdate() > 0;
            }
        } finally {
            DBUtils.closeConnection2(conn, ptm);
        }
        return check;
    }

    public ForgotPasswordDTO getInforByUserID(int userID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ForgotPasswordDTO forgotPasswordDTO = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
//                SELECT * FROM ForgotPassword WHERE UserID = ?
                ptm = conn.prepareStatement(GET_INFO_USERID);
                ptm.setInt(1, userID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String token = rs.getString("Token");
                    Date resetDate = rs.getDate("ResetDate");
                    int tokenStatus = rs.getInt("TokenStatus");
                    forgotPasswordDTO = new ForgotPasswordDTO(0, userID, token, resetDate, tokenStatus);
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return forgotPasswordDTO;
    }

    public ForgotPasswordDTO checkExist(String otp) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ForgotPasswordDTO forgotPasswordDTO = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(CHECK_OTP);
//              SELECT * FROM ForgotPassword WHERE Token = ? AND ResetDate > GETDATE() AND TokenStatus = 1
                ptm.setString(1, otp);
                rs = ptm.executeQuery();
                if(rs.next()){
                    int userID = rs.getInt("UserID");
                    String token = rs.getString("Token");
                    Date resetDate = rs.getDate("ResetDate");
                    int tokenStatus = rs.getInt("TokenStatus");
                    forgotPasswordDTO = new ForgotPasswordDTO(0, userID, token, resetDate, tokenStatus);
                }
            }
        } finally {
            DBUtils.closeConnection3(conn, ptm, rs);
        }
        return forgotPasswordDTO;
    }

    public boolean deleteOTP(String otp, int userID) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
//          UPDATE ForgotPassword SET TokenStatus = 0 WHERE Token = ? OR UserID = ?
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(DELETE_OTP);
                ptm.setString(1, otp);
                ptm.setInt(2, userID);
                check = ptm.executeUpdate()>0;
            }
        }finally{
            DBUtils.closeConnection2(conn, ptm);
        }
        return check;
    }

    

}
