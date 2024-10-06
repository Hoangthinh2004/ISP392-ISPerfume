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
public class ViewProductDetailDTO {
    private int productID;
    private int sizeID;
    private String productName;
    private String description;
    private int price;
    private String sizeName;
    private int numberOfPurchasing;
    private String country;
    private int releaseDate;
    private String fraganceFamilies;
    private String image;

    public ViewProductDetailDTO() {
    }

    public ViewProductDetailDTO(int productID, int sizeID, String productName, String description, int price, String sizeName, int numberOfPurchasing, String country, int releaseDate, String fraganceFamilies, String image) {
        this.productID = productID;
        this.sizeID = sizeID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.sizeName = sizeName;
        this.numberOfPurchasing = numberOfPurchasing;
        this.country = country;
        this.releaseDate = releaseDate;
        this.fraganceFamilies = fraganceFamilies;
        this.image = image;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public int getNumberOfPurchasing() {
        return numberOfPurchasing;
    }

    public void setNumberOfPurchasing(int numberOfPurchasing) {
        this.numberOfPurchasing = numberOfPurchasing;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getFraganceFamilies() {
        return fraganceFamilies;
    }

    public void setFraganceFamilies(String fraganceFamilies) {
        this.fraganceFamilies = fraganceFamilies;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
        
}
