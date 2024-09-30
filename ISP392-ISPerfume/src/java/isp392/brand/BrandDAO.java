/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.brand;

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
public class BrandDAO {
    
    private static final String GET_LIST_BRAND = "SELECT * FROM Brands WHERE Status = 1";
    private static final String BRAND_LIST_BY_CATEGORY = "SELECT C.CategoryName, B.BrandName, B.BrandID FROM Categories C "
                                                        +"INNER JOIN Categories_Brands CB on C.CategoryID = CB.CategoryID "
                                                        +"INNER JOIN Brands B on CB.BrandID = B.BrandID";


    public List<BrandDTO> getListBrand() throws ClassNotFoundException, SQLException {
        List<BrandDTO> listBrand = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn!=null) {
                ptm = conn.prepareStatement(GET_LIST_BRAND);
                rs = ptm.executeQuery();
                while (rs.next()) {                    
                    int brandID = rs.getInt("BrandID");
                    String brandName = rs.getString("BrandName");
                    String image = rs.getString("Image");
                    listBrand.add(new BrandDTO(brandID, brandName, image, true));
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return listBrand;
    }
   
    public List<BrandDTO> getListBrandManager() throws SQLException, ClassNotFoundException {
        List<BrandDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(BRAND_LIST_BY_CATEGORY);
                rs = ptm.executeQuery();
                while(rs.next()){
                    int brandID = rs.getInt("BrandID");
                    String brandName = rs.getString("BrandName");
                    String image = rs.getString("Image");
                    boolean status = rs.getBoolean("Status");
                    BrandDTO newBrand = new BrandDTO(brandID, brandName, image, status);
                    list.add(newBrand);
                }
            }
        } finally {
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return list;
    }
}
