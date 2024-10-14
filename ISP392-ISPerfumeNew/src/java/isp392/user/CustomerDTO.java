/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.user;

import java.sql.Date;

/**
 *
 * @author duyhc
 */
public class CustomerDTO {
    private int customerID;
    private String area;
    private String district;
    private String ward;
    private String DetailAddress;
    private Date dayOfBirth;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerID, String area, String district, String ward, String DetailAddress, Date dayOfBirth) {
        this.customerID = customerID;
        this.area = area;
        this.district = district;
        this.ward = ward;
        this.DetailAddress = DetailAddress;
        this.dayOfBirth = dayOfBirth;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public String getDetailAddress() {
        return DetailAddress;
    }

    public void setDetailAddress(String DetailAddress) {
        this.DetailAddress = DetailAddress;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }
    
    
    
}
