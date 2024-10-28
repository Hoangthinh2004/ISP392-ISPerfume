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
    private int managerID;
    private int brandID;
    private String name;
    private String description;
    private String image;
    private String country;
    private int releaseDate;
    private String fragranceFamilies;
    private int status;

    public ProductDTO() {
        this.productID = 0;
        this.managerID = 0;
        this.brandID = 0;
        this.name = "";
        this.description = "";
        this.image = "";
        this.status = 0;
        this.country = "";
        this.releaseDate = 0;
        this.fragranceFamilies = "";
        this.status = 0;
    }

    public ProductDTO(int productID, int managerID, int brandID, String name, String description, String image, String country, int releaseDate, String fragranceFamilies, int status) {
        this.productID = productID;
        this.managerID = managerID;
        this.brandID = brandID;
        this.name = name;
        this.description = description;
        this.image = image;
        this.country = country;
        this.releaseDate = releaseDate;
        this.fragranceFamilies = fragranceFamilies;
        this.status = status;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
