/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.user;

/**
 *
 * @author ThinhHoang
 */
public class UserDTO {
    private int userID;
    private String name;
    private String email;
    private String password;
    private String phone;
    private int status;
    private int roleID;

    public UserDTO() {
        this.userID = 0;
        this.name = "";
        this.email = "";
        this.password = "";
        this.phone = "";
        this.roleID = 0;
        this.status = 0;
    }

    public UserDTO(int userID, String name, String email, String password, String phone, int status, int roleID) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roleID = roleID;
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
