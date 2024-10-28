/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.order;

/**
 *
 * @author anhng
 */
public class OrderDetailDTO {
    private String productName;
    private int quantity;
    private int price;
    private int orderID;

    public OrderDetailDTO() {
        this.productName = "";
        this.quantity = 0;
        this.price = 0;
        this.orderID = 0;
    }

    public OrderDetailDTO( int orderID,String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.orderID = orderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    
}
