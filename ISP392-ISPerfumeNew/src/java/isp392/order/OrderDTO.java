/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.order;

import java.sql.Date;

/**
 *
 * @author ThinhHoang
 */
public class OrderDTO {
    private int orderID;
    private int cartID;
    private int staffID;
    private int shipperID;
    private int promotionID;
    private int customerID;
    private Date orderDate;
    private int orderStatus;
    private String city;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String note;

    public OrderDTO() {
    }

    public OrderDTO(int orderID, int cartID, int staffID, int shipperID, int promotionID, int customerID, Date orderDate, int orderStatus, String city, String district, String ward, String address, String phone, String note) {
        this.orderID = orderID;
        this.cartID = cartID;
        this.staffID = staffID;
        this.shipperID = shipperID;
        this.promotionID = promotionID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.note = note;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getShipperID() {
        return shipperID;
    }

    public void setShipperID(int shipperID) {
        this.shipperID = shipperID;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
}
