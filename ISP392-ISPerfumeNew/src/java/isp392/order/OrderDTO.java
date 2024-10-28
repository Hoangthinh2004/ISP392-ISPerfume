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
public class OrderDTO {
    private int shipperID;
    private int orderID;
    private String customerName;
    private String phone;
    private String address;
    private String note;
    private int orderStatus;

    public OrderDTO() {   
        this.shipperID = 0;
        this.orderID = 0;
        this.customerName = "";
        this.phone = "";
        this.address = "";
        this.note = "";
        this.orderStatus = 0;
    }

    public OrderDTO(int shipperID, int orderID, String customerName, String phone, String address, String note, int orderStatus) {
        this.shipperID = shipperID;
        this.orderID = orderID;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
        this.note = note;
        this.orderStatus = orderStatus;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    
}
