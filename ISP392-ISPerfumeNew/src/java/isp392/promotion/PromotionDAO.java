/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.promotion;

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
public class PromotionDAO {

    private static final String LIST_PROMOTION = "SELECT PromotionID, PromotionName, ManagerID, Description, StartDate, EndDate, DiscountPer, Condition, Status FROM Promotion";
    private static final String PROMOTION_DETAIL = "SELECT PromotionID, PromotionName, ManagerID, Description, StartDate, EndDate, DiscountPer, Condition, Status FROM Promotion WHERE PromotionID = ?";
    private static final String INSERT = "INSERT INTO Promotion(PromotionName,ManagerID,Description,StartDate,EndDate,DiscountPer,Condition,Status) VALUES(?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Promotion SET PromotionName=?, Description=?, StartDate=?, EndDate=?, DiscountPer=?, Condition=?, Status=?  WHERE PromotionID=?";
    private static final String DUPLICATE = "SELECT PromotionName FROM Promotion WHERE PromotionName=?";
    private static final String DELETE = "DELETE Promotion WHERE promotionID=?";

    public List<PromotionDTO> getListPromotion() throws SQLException, ClassNotFoundException, NamingException {
        List<PromotionDTO> listPromotion = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LIST_PROMOTION);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int promotionID = rs.getInt("PromotionID");
                    String promotionName = rs.getString("PromotionName");
                    int managerID = rs.getInt("ManagerID");
                    String Description = rs.getString("Description");
                    Date StartDate = rs.getDate("StartDate");
                    Date EndDate = rs.getDate("EndDate");
                    int DiscountPer = rs.getInt("DiscountPer");
                    int Condition = rs.getInt("Condition");
                    int Status = rs.getInt("Status");
                    listPromotion.add(new PromotionDTO(promotionID, managerID, promotionName, Description, StartDate, EndDate, DiscountPer, Condition, Status));
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
        return listPromotion;

    }

    public boolean insert(String promotionName, int managerID, String description, Date stDate, Date enDate, int discountPer, int condition, int status) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
//            INSERT INTO Promotion(PromotionName,ManagerID,Description,StartDate,EndDate,DiscountPer,Condition,Status) VALUES(?,?,?,?,?,?,?,?)
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, promotionName);
                ptm.setInt(2, managerID);
                ptm.setString(3, description);
                ptm.setDate(4, stDate);
                ptm.setDate(5, enDate);
                ptm.setInt(6, discountPer);
                ptm.setInt(7, condition);
                ptm.setInt(8, status);
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

    public boolean checkDuplicate(String userID) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DUPLICATE);
                ptm.setString(1, userID);
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

    public boolean update(PromotionDTO promotion) throws SQLException, ClassNotFoundException, NamingException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, promotion.getPromotionName());
                ptm.setString(2, promotion.getDescription());
                ptm.setDate(3, promotion.getStartDate());
                ptm.setDate(4, promotion.getEndDate());
                ptm.setInt(5, promotion.getDiscountPer());
                ptm.setInt(6, promotion.getCondition());
                ptm.setInt(7, promotion.getStatus());
                ptm.setInt(8, promotion.getPromotionID());

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
    
    public List<PromotionDTO> getDetail(int promotionID) throws ClassNotFoundException, SQLException {
        List<PromotionDTO> listPromotion = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(PROMOTION_DETAIL);
                ptm.setInt(1, promotionID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String promotionName = rs.getString("PromotionName");
                    int managerID = rs.getInt("ManagerID");
                    String Description = rs.getString("Description");
                    Date StartDate = rs.getDate("StartDate");
                    Date EndDate = rs.getDate("EndDate");
                    int DiscountPer = rs.getInt("DiscountPer");
                    int Condition = rs.getInt("Condition");
                    int Status = rs.getInt("Status");
                    listPromotion.add(new PromotionDTO(promotionID, managerID, promotionName, Description, StartDate, EndDate, DiscountPer, Condition, Status));
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
        return listPromotion;
    }
}
