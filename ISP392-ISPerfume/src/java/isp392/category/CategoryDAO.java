/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.category;

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
public class CategoryDAO {
    
    private static final String GET_LIST_CATEGORY = "SELECT * FROM Categories";

    public List<CategoryDTO> getListCategory() throws ClassNotFoundException, SQLException {
        List<CategoryDTO> listCategory = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_LIST_CATEGORY);
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    int categoryID = rs.getInt("CategoryID");
                    String categoryName = rs.getString("CategoryName");
                    listCategory.add(new CategoryDTO(categoryID, categoryName));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listCategory;
    }
    
}
