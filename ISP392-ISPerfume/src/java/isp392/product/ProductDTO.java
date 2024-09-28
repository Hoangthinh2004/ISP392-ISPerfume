/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.product;

/**
 *
 * @author ThinhHoang
 */
public class ProductDTO {
    private int productID;
    private int brandID;
    private String name;
    private String description;
    private String image;
    private boolean status;

    public ProductDTO() {
        this.productID = 0;
        this.brandID = 0;
        this.name = "";
        this.description = "";
        this.image = "";
        this.status=true;
    }

    public ProductDTO(int productID, int brandID, String name, String description, String image, boolean status) {
        this.productID = productID;
        this.brandID = brandID;
        this.name = name;
        this.description = description;
        this.image = image;
        this.status = status;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
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
