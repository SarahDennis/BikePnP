package com.bikepnp;

public class SellerInfo {
    private String mName;
    private String mPhoneNumber;
    private String mTitle;
    private String itemDetails;
    private Double mPrice;


    //*******************************************************
    //Getters
    //*******************************************************
    public String getmName() {
        return mName;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public Double getmPrice() {
        return mPrice;
    }



    //*******************************************************
    //Setters
    //*******************************************************
    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }

    public void setmPrice(Double mPrice) {
        this.mPrice = mPrice;
    }
}
