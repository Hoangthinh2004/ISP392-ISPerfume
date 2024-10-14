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
public class BrandDTO {
    private int brandID;
    private int managerID;
    private String name;
    private String description;
    private String image;
    private boolean status;

    public BrandDTO() {
        this.brandID = 0;
        this.managerID = 0;
        this.name = "";
        this.description = "";
        this.image = "";
        this.status = true;
    }

    public BrandDTO(int brandID, int managerID, String name, String description, String image, boolean status) {
        this.brandID = brandID;
        this.managerID = managerID;
        this.name = name;
        this.description = description;
        this.image = image;
        this.status = status;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
