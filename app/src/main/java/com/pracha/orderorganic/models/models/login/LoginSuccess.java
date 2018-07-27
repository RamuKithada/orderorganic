package com.pracha.orderorganic.models.models.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginSuccess {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("details")
    @Expose
    private LoginDetails details;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LoginDetails getDetails() {
        return details;
    }

    public void setDetails(LoginDetails details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
