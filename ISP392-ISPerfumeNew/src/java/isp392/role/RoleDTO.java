/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.role;

/**
 *
 * @author anhng
 */
public class RoleDTO {
    private int roleID;
    private String name;

    public RoleDTO() {
        this.roleID = 0;
        this.name = "";
    }

    public RoleDTO(int roleID, String name) {
        this.roleID = roleID;
        this.name = name;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
