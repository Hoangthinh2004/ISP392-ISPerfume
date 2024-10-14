/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.category;

/**
 *
 * @author ThinhHoang
 */
public class CategoryDTO {
    private int categoryID;
    private String name;
    private String image;

    public CategoryDTO() {
        this.categoryID = 0;
        this.name = "";
        this.image = "";
    }

    public CategoryDTO(int categoryID, String name, String image) {
        this.categoryID = categoryID;
        this.name = name;
        this.image = image;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}
