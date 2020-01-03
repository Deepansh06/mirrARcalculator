package com.waysideutilities.mirrarcalculator.model;

import android.util.Patterns;

public class Screen3
{
    private String person_name="";
    private String client_name="";
    private String brand_name="";
    private String email_id="";
    private String mobile_no="";
    private String address="";
    private String advance_payment_amount="";
    private String advance_payment_method="";

    public Screen3(String person_name, String client_name, String brand_name, String email_id, String mobile_no,
                   String address,String advance_payment_amount,String advance_payment_method)
    {
        this.person_name = person_name;
        this.client_name = client_name;
        this.brand_name = brand_name;
        this.email_id = email_id;
        this.mobile_no = mobile_no;
        this.address = address;
        this.advance_payment_amount = advance_payment_amount;
        this.advance_payment_method = advance_payment_method;
    }

    public String getAddress() {
        return address;
    }

    public String getAdvance_payment_amount() {
        return advance_payment_amount;
    }

    public String getAdvance_payment_method() {
        return advance_payment_method;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public String getPerson_name() {
        return person_name;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail_id()).matches();
    }

    public boolean isMobileValid() {
        return getMobile_no().length() == 10;
    }
}
