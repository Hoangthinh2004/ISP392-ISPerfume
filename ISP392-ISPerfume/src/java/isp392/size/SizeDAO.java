/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.size;

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
    
}
