/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.promotion;
import java.sql.Date;

/**
 *
 * @author ThinhHoang
 */
public class PromotionDTO {
    private int promotionID;
    private String promotionName;
    private int managerID;
    private String description;
    private Date startDate;
    private Date endDate;
    private int discountPer;
    private int condition;
    private int status;

    public PromotionDTO() {
        this.promotionID = 0;
        this.managerID = 0;
        this.promotionName = "";
        this.description = "";
        this.startDate = null;
        this.endDate = null;
        this.discountPer = 0;
        this.condition = 0;
        this.status = 0;
    }

    public PromotionDTO(int promotionID, int managerID, String promotionName, String description, Date startDate, Date endDate, int discountPer, int condition, int status) {
        this.promotionID = promotionID;
        this.managerID = managerID;
        this.promotionName = promotionName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountPer = discountPer;
        this.condition = condition;
        this.status = status;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(int promotionID) {
        this.promotionID = promotionID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getDiscountPer() {
        return discountPer;
    }

    public void setDiscountPer(int discountPer) {
        this.discountPer = discountPer;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    
    
}
