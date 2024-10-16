/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.user;

import java.sql.Date;

/**
 *
 * @author GIGABYTE
 */
public class CustomerViewProfileDTO {
    private int id; 
    private String area;
    private String district;
    private String ward;
    private String detailAddress;
    private Date dayOfBirth;
    private String name;
    private String email;
    private String password;
    private String phone;
    private int roleID;
    private int status;
    public CustomerViewProfileDTO() {
    }

    public CustomerViewProfileDTO(int id, String area, String district, String ward, String detailAddress, Date dayOfBirth, String name, String email, String password, String phone, int roleID, int status) {
        this.id = id;
        this.area = area;
        this.district = district;
        this.ward = ward;
        this.detailAddress = detailAddress;
        this.dayOfBirth = dayOfBirth;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roleID = roleID;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
