/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.user;

/**
 *
 * @author duyhc
 */
public class UserError {
    private String userIDErr;
    private String nameErr;
    private String emailErr;
    private String passwordErr;
    private String phoneErr;
    private String statusErr;
    private String roleIDErr;
    private String confirmPasswordErr;
    private String error;

    public UserError() {
    }

    public UserError(String userIDErr, String nameErr, String emailErr, String passwordErr, String phoneErr, String statusErr, String roleIDErr, String confirmPasswordErr, String error) {
        this.userIDErr = userIDErr;
        this.nameErr = nameErr;
        this.emailErr = emailErr;
        this.passwordErr = passwordErr;
        this.phoneErr = phoneErr;
        this.statusErr = statusErr;
        this.roleIDErr = roleIDErr;
        this.confirmPasswordErr = confirmPasswordErr;
        this.error = error;
    }

    public String getUserIDErr() {
        return userIDErr;
    }

    public void setUserIDErr(String userIDErr) {
        this.userIDErr = userIDErr;
    }

    public String getNameErr() {
        return nameErr;
    }

    public void setNameErr(String nameErr) {
        this.nameErr = nameErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    public String getStatusErr() {
        return statusErr;
    }

    public void setStatusErr(String statusErr) {
        this.statusErr = statusErr;
    }

    public String getRoleIDErr() {
        return roleIDErr;
    }

    public void setRoleIDErr(String roleIDErr) {
        this.roleIDErr = roleIDErr;
    }

    public String getConfirmPasswordErr() {
        return confirmPasswordErr;
    }

    public void setConfirmPasswordErr(String confirmPasswordErr) {
        this.confirmPasswordErr = confirmPasswordErr;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    
}
