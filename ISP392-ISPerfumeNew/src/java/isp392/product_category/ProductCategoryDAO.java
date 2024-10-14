/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.product_category;

import isp392.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author duyhc
 */
public class ProductCategoryDAO {

    private static final String INSERT_PRODUCT_CATEGORY_MANAGER = "INSERT INTO Product_Category(ProductID,CategoryID) VALUES (?,?)";

    public boolean addProCate(int check, int categoryID) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean checkAdd = false;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(INSERT_PRODUCT_CATEGORY_MANAGER);
                ptm.setInt(1, check);
                ptm.setInt(2, categoryID);
                checkAdd = ptm.executeUpdate()>0;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return checkAdd;
    }

}
