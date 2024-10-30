/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.order;

/**
 *
 * @author ThinhHoang
 */
public class OrderDetailDTO {
    private int orderID;
    private int productDetailID;
    private int quantity;
    private int unitPrice;

    public OrderDetailDTO() {
        this.orderID = 0;
        this.productDetailID = 0;
        this.quantity = 0;
        this.unitPrice = 0;
    }

    public OrderDetailDTO(int orderID, int productDetailID, int quantity, int unitPrice) {
        this.orderID = orderID;
        this.productDetailID = productDetailID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    
}
