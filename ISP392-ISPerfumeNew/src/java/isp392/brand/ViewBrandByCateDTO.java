/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.brand;

/**
 *
 * @author ThinhHoang
 */
public class ViewBrandByCateDTO {
    private int categoryID;
    private int brandID;
    private String categoryName;
    private String brandName;
    private String brandImage;
    private String brandDescription;
    private boolean status;

    public ViewBrandByCateDTO() {
    }

    public ViewBrandByCateDTO(int categoryID, int brandID, String categoryName, String brandName, String brandImage, String brandDescription, boolean status) {
        this.categoryID = categoryID;
        this.brandID = brandID;
        this.categoryName = categoryName;
        this.brandName = brandName;
        this.brandImage = brandImage;
        this.brandDescription = brandDescription;
        this.status = status;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public String getBrandDescription() {
        return brandDescription;
    }

    public void setBrandDescription(String brandDescription) {
        this.brandDescription = brandDescription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
