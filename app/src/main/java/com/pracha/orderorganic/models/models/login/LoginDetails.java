package com.pracha.orderorganic.models.models.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginDetails {
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("role_id")
    @Expose
    private String roleId;
    @SerializedName("cust_firstname")
    @Expose
    private String custFirstname;
    @SerializedName("cust_lastname")
    @Expose
    private String custLastname;
    @SerializedName("cust_email")
    @Expose
    private String custEmail;
    @SerializedName("cust_password")
    @Expose
    private String custPassword;
    @SerializedName("cust_mobile")
    @Expose
    private String custMobile;
    @SerializedName("cust_propic")
    @Expose
    private Object custPropic;
    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("create_at")
    @Expose
    private String createAt;
    @SerializedName("forgot_verification")
    @Expose
    private String forgotVerification;
    @SerializedName("subscribe")
    @Expose
    private String subscribe;
    @SerializedName("deliveryboy_current_location")
    @Expose
    private String deliveryboyCurrentLocation;
    @SerializedName("bike")
    @Expose
    private String bike;
    @SerializedName("active_status")
    @Expose
    private String activeStatus;
    @SerializedName("current_login")
    @Expose
    private String currentLogin;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCustFirstname() {
        return custFirstname;
    }

    public void setCustFirstname(String custFirstname) {
        this.custFirstname = custFirstname;
    }

    public String getCustLastname() {
        return custLastname;
    }

    public void setCustLastname(String custLastname) {
        this.custLastname = custLastname;
    }

    public String getCustEmail() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustPassword() {
        return custPassword;
    }

    public void setCustPassword(String custPassword) {
        this.custPassword = custPassword;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public Object getCustPropic() {
        return custPropic;
    }

    public void setCustPropic(Object custPropic) {
        this.custPropic = custPropic;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getForgotVerification() {
        return forgotVerification;
    }

    public void setForgotVerification(String forgotVerification) {
        this.forgotVerification = forgotVerification;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getDeliveryboyCurrentLocation() {
        return deliveryboyCurrentLocation;
    }

    public void setDeliveryboyCurrentLocation(String deliveryboyCurrentLocation) {
        this.deliveryboyCurrentLocation = deliveryboyCurrentLocation;
    }

    public String getBike() {
        return bike;
    }

    public void setBike(String bike) {
        this.bike = bike;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getCurrentLogin() {
        return currentLogin;
    }

    public void setCurrentLogin(String currentLogin) {
        this.currentLogin = currentLogin;
    }
}
