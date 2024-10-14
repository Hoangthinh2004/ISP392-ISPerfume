/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.user;

/**
 *
 * @author anhng
 */
public class UserError {
    private String userIDError;
    private String nameError;
    private String emailError;
    private String passwordError;
    private String phoneError;
    private String statusError;
    private String roleIDError;
    private String error;

    public UserError() {
    }

    public UserError(String userIDError, String nameError, String emailError, String passwordError, String phoneError, String statusError, String roleIDError, String error) {
        this.userIDError = userIDError;
        this.nameError = nameError;
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.phoneError = phoneError;
        this.statusError = statusError;
        this.roleIDError = roleIDError;
        this.error = error;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
}
