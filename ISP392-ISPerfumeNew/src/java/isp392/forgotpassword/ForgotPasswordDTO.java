/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp392.forgotpassword;

import java.sql.Date;

/**
 *
 * @author duyhc
 */
public class ForgotPasswordDTO {
    private int resetID;
    private int userID;
    private String token;
    private Date resetDate;
    private int tokenStatus;

    public ForgotPasswordDTO() {
    }

    public ForgotPasswordDTO(int resetID, int userID, String token, Date resetDate, int tokenStatus) {
        this.resetID = resetID;
        this.userID = userID;
        this.token = token;
        this.resetDate = resetDate;
        this.tokenStatus = tokenStatus;
    }

    public int getResetID() {
        return resetID;
    }

    public void setResetID(int resetID) {
        this.resetID = resetID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getResetDate() {
        return resetDate;
    }

    public void setResetDate(Date resetDate) {
        this.resetDate = resetDate;
    }

    public int getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(int tokenStatus) {
        this.tokenStatus = tokenStatus;
    }
    
}
