/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.size;

import isp392.product.ProductDetailDTO;
import isp392.product.ViewProductDTO;
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
public class SizeDAO {
    
    private final String GET_LIST_SIZE = "SELECT S.Name, S.SizeID FROM Size S ";
    private final String GET_AVAILABLE_SIZE = "SELECT S.SizeID, PD.ProductDetailID, S.Name FROM Size S "
                                            + "INNER JOIN ProductDetail PD ON  S.SizeID = PD.SizeID "
                                            + "INNER JOIN Products P ON P.ProductID = PD.ProductID "
                                            + "WHERE P.ProductID = ? ";
    
    public List<SizeDTO> getListSize() throws ClassNotFoundException, SQLException {
        List<SizeDTO> listSize = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_SIZE);
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    int sizeID = rs.getInt("SizeID");
                    String name = rs.getString("Name");
                    listSize.add(new SizeDTO(sizeID, name));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listSize;
    }

    public List<ViewProductDTO> getAvailableSize(int productID) throws ClassNotFoundException, SQLException {
        List<ViewProductDTO> listSize = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_AVAILABLE_SIZE);
                ptm.setInt(1, productID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int sizeID = rs.getInt("SizeID");
                    String name = rs.getString("Name");
                    listSize.add(new ViewProductDTO(0, 0, 0, productID, sizeID, name, "", "", 0, ""));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listSize;
    }
    
}
