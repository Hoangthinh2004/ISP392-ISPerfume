/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.role;

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
 * @author anhng
 */
public class RoleDAO {
    private static final String LIST_ROLE = "SELECT RoleID, Name FROM Role";
    
    public List<RoleDTO> getListRole() throws SQLException, ClassNotFoundException, NamingException{
        List<RoleDTO> listRole = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(LIST_ROLE);
                rs = ptm.executeQuery();
                while(rs.next()){
                    int roleID = rs.getInt("RoleID");
                    String name= rs.getString("Name");
                    listRole.add(new RoleDTO(roleID, name));
                }
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            if(ptm != null){
                ptm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return listRole;
    }
}
