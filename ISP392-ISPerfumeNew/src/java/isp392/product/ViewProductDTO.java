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
public class ViewProductDTO {
    private int categoryID;
    private int productDetailID;
    private int brandID;
    private int productID;
    private int sizeID;
    private String sizeName;
    private String brandName;
    private String productName;
    private int price;
    private String image;

    public ViewProductDTO() {
        this.categoryID = 0;
        this.productDetailID = 0;
        this.brandID = 0;
        this.productID = 0;
        this.sizeID = 0;
        this.sizeName = "";
        this.brandName = "";
        this.productName = "";
        this.price = 0;
        this.image = "";
    }

    public ViewProductDTO(int categoryID, int productDetailID, int brandID, int productID, int sizeID, String sizeName, String brandName, String productName, int price, String image) {
        this.categoryID = categoryID;
        this.productDetailID = productDetailID;
        this.brandID = brandID;
        this.productID = productID;
        this.sizeID = sizeID;
        this.sizeName = sizeName;
        this.brandName = brandName;
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public int getBrandID() {
        return brandID;
    }

    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
