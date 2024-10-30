/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.cart;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ThinhHoang
 */
public class Cart {
    private Map<Integer, ViewCartDTO> cart;

    public Cart() {
    }

    public Cart(Map<Integer, ViewCartDTO> cart) {
        this.cart = cart;
    }

    public Map<Integer, ViewCartDTO> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, ViewCartDTO> cart) {
        this.cart = cart;
    }

    public boolean add(ViewCartDTO product) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            } 
            this.cart.put(product.getProductDetailID(), product);
            check = true;
        } catch (Exception e) {
        }
        return check;
    }
    
}
