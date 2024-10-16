/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.cart;

/**
 *
 * @author ThinhHoang
 */
public class ViewCartDTO {
    private int customerID;
    private int productDetailID;
    private String productName;
    private String sizeName;
    private int price;
    private String image;
    private int totalQuantity;

    public ViewCartDTO() {
    }

    public ViewCartDTO(int customerID, int productDetailID, String productName, String sizeName, int price, String image, int totalQuantity) {
        this.customerID = customerID;
        this.productDetailID = productDetailID;
        this.productName = productName;
        this.sizeName = sizeName;
        this.price = price;
        this.image = image;
        this.totalQuantity = totalQuantity;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    
    
}
