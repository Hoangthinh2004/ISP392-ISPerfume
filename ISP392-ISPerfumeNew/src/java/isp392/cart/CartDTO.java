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
public class CartDTO {
    private int cartID;
    private int customerID;

    public CartDTO() {
        this.cartID = 0;
        this.customerID = 0;
    }

    public CartDTO(int cartID, int customerID) {
        this.cartID = cartID;
        this.customerID = customerID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    
}
