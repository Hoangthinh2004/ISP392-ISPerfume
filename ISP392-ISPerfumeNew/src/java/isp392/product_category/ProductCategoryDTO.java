/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.product_category;

/**
 *
 * @author duyhc
 */
public class ProductCategoryDTO {
    private int productID;
    private int categoryID;

    public ProductCategoryDTO() {
    }

    public ProductCategoryDTO(int productID, int categoryID) {
        this.productID = productID;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
}
