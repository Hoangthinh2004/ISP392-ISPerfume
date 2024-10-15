/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.size;

/**
 *
 * @author ThinhHoang
 */
public class SizeDTO {
    private int sizeID;
    private String name;

    public SizeDTO() {
    }

    public SizeDTO(int sizeID, String name) {
        this.sizeID = sizeID;
        this.name = name;
    }

    public int getSizeID() {
        return sizeID;
    }

    public void setSizeID(int sizeID) {
        this.sizeID = sizeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
