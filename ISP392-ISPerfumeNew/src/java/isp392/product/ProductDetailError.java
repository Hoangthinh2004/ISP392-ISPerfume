/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.product;

import java.util.Date;

/**
 *
 * @author duyhc
 */
public class ProductDetailError {
    private String productIDErr;
    private String sizeIDErr;
    private String priceErr;
    private String stockQuantityErr;
    private String importDateErr;
    private String image;
    private String statusErr;

    public ProductDetailError() {
    }

    public ProductDetailError(String productIDErr, String sizeIDErr, String priceErr, String stockQuantityErr, String importDateErr, String image, String statusErr) {
        this.productIDErr = productIDErr;
        this.sizeIDErr = sizeIDErr;
        this.priceErr = priceErr;
        this.stockQuantityErr = stockQuantityErr;
        this.importDateErr = importDateErr;
        this.image = image;
        this.statusErr = statusErr;
    }

    public String getProductIDErr() {
        return productIDErr;
    }

    public void setProductIDErr(String productIDErr) {
        this.productIDErr = productIDErr;
    }

    public String getSizeIDErr() {
        return sizeIDErr;
    }

    public void setSizeIDErr(String sizeIDErr) {
        this.sizeIDErr = sizeIDErr;
    }

    public String getPriceErr() {
        return priceErr;
    }

    public void setPriceErr(String priceErr) {
        this.priceErr = priceErr;
    }

    public String getStockQuantityErr() {
        return stockQuantityErr;
    }

    public void setStockQuantityErr(String stockQuantityErr) {
        this.stockQuantityErr = stockQuantityErr;
    }

    public String getImportDateErr() {
        return importDateErr;
    }

    public void setImportDateErr(String importDateErr) {
        this.importDateErr = importDateErr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatusErr() {
        return statusErr;
    }

    public void setStatusErr(String statusErr) {
        this.statusErr = statusErr;
    }
    
   
}
