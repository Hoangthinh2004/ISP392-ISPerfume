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
public class ProductError {
    private String productIDErr;
    private String brandIDErr;
    private String productName;
    private String description;
    private String imageErr;
    private String status;
    private String error;

    public ProductError() {
    }

    public ProductError(String productIDErr, String brandIDErr, String productName, String description, String imageErr, String status, String error) {
        this.productIDErr = productIDErr;
        this.brandIDErr = brandIDErr;
        this.productName = productName;
        this.description = description;
        this.imageErr = imageErr;
        this.status = status;
        this.error = error;
    }

    public String getProductIDErr() {
        return productIDErr;
    }

    public void setProductIDErr(String productIDErr) {
        this.productIDErr = productIDErr;
    }

    public String getBrandIDErr() {
        return brandIDErr;
    }

    public void setBrandIDErr(String brandIDErr) {
        this.brandIDErr = brandIDErr;
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

    public String getImageErr() {
        return imageErr;
    }

    public void setImageErr(String imageErr) {
        this.imageErr = imageErr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}
