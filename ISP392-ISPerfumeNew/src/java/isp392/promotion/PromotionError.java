/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.promotion;

/**
 *
 * @author anhng
 */
public class PromotionError {
    private String promotionIDError;
    private String promotionNameError;
    private String descriptionError;
    private String startDateError;
    private String endDateError;
    private String discountPerError;
    private String conditionError;
    private String statusError;
    private String error;

    public PromotionError() {
    }

    public PromotionError(String promotionIDError, String promotionNameError, String descriptionError, String startDateError, String endDateError, String discountPerError, String conditionError, String statusError, String error) {
        this.promotionIDError = promotionIDError;
        this.promotionNameError = promotionNameError;
        this.descriptionError = descriptionError;
        this.startDateError = startDateError;
        this.endDateError = endDateError;
        this.discountPerError = discountPerError;
        this.conditionError = conditionError;
        this.statusError = statusError;
        this.error = error;
    }

    public String getPromotionIDError() {
        return promotionIDError;
    }

    public void setPromotionIDError(String promotionIDError) {
        this.promotionIDError = promotionIDError;
    }

    public String getPromotionNameError() {
        return promotionNameError;
    }

    public void setPromotionNameError(String promotionNameError) {
        this.promotionNameError = promotionNameError;
    }

    public String getDescriptionError() {
        return descriptionError;
    }

    public void setDescriptionError(String descriptionError) {
        this.descriptionError = descriptionError;
    }

    public String getStartDateError() {
        return startDateError;
    }

    public void setStartDateError(String startDateError) {
        this.startDateError = startDateError;
    }

    public String getEndDateError() {
        return endDateError;
    }

    public void setEndDateError(String endDateError) {
        this.endDateError = endDateError;
    }

    public String getDiscountPerError() {
        return discountPerError;
    }

    public void setDiscountPerError(String discountPerError) {
        this.discountPerError = discountPerError;
    }

    public String getConditionError() {
        return conditionError;
    }

    public void setConditionError(String conditionError) {
        this.conditionError = conditionError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}
