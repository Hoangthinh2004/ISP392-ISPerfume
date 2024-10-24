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
public class CartDetailDTO {
    private int cartID;
    private int productDetailID;
    private int quantity;

    public CartDetailDTO() {
    }

    public CartDetailDTO(int cartID, int productDetailID, int quantity) {
        this.cartID = cartID;
        this.productDetailID = productDetailID;
        this.quantity = quantity;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getProductDetailID() {
        return productDetailID;
    }

    public void setProductDetailID(int productDetailID) {
        this.productDetailID = productDetailID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
