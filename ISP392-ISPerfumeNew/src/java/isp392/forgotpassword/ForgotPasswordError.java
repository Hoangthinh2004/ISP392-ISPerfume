/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.forgotpassword;

/**
 *
 * @author duyhc
 */
public class ForgotPasswordError {
    private String resetIDError;
    private String userIDError;
    private String tokenError;
    private String resetDateError;
    private String tokenStatusError;

    public ForgotPasswordError() {
    }

    public ForgotPasswordError(String resetIDError, String userIDError, String tokenError, String resetDateError, String tokenStatusError) {
        this.resetIDError = resetIDError;
        this.userIDError = userIDError;
        this.tokenError = tokenError;
        this.resetDateError = resetDateError;
        this.tokenStatusError = tokenStatusError;
    }

    public String getResetIDError() {
        return resetIDError;
    }

    public void setResetIDError(String resetIDError) {
        this.resetIDError = resetIDError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getTokenError() {
        return tokenError;
    }

    public void setTokenError(String tokenError) {
        this.tokenError = tokenError;
    }

    public String getResetDateError() {
        return resetDateError;
    }

    public void setResetDateError(String resetDateError) {
        this.resetDateError = resetDateError;
    }

    public String getTokenStatusError() {
        return tokenStatusError;
    }

    public void setTokenStatusError(String tokenStatusError) {
        this.tokenStatusError = tokenStatusError;
    }
}
