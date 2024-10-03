/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.product;

import java.sql.Date;

/**
 *
 * @author ThinhHoang
 */
public class ProductDetailDTO {
    private int productID;
    private int sizeID;
    private int price;
    private int stockQuantity;
    private int numberOfPurchasing;
    private Date importDate;
    private String country;
    private int releaseDate;
    private String fragranceFamilies;
    private String image;
    private int status;

    public ProductDetailDTO() {
        this.productID = 0;
        this.sizeID = 0;
        this.price = 0;
        this.stockQuantity = 0;
        this.numberOfPurchasing = 0;
        this.importDate = null;
        this.country = "";
        this.releaseDate = 0;
        this.fragranceFamilies = "";
        this.image = "";
        this.status = 0;
    }

    public ProductDetailDTO(int productID, int sizeID, int price, int stockQuantity, int numberOfPurchasing, Date importDate, String country, int releaseDate, String fragranceFamilies, String image, int status) {
        this.productID = productID;
        this.sizeID = sizeID;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.numberOfPurchasing = numberOfPurchasing;
        this.importDate = importDate;
        this.country = country;
        this.releaseDate = releaseDate;
        this.fragranceFamilies = fragranceFamilies;
        this.image = image;
        this.status = status;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getNumberOfPurchasing() {
        return numberOfPurchasing;
    }

    public void setNumberOfPurchasing(int numberOfPurchasing) {
        this.numberOfPurchasing = numberOfPurchasing;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
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

    public String getFragranceFamilies() {
        return fragranceFamilies;
    }

    public void setFragranceFamilies(String fragranceFamilies) {
        this.fragranceFamilies = fragranceFamilies;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    
    
    
}
