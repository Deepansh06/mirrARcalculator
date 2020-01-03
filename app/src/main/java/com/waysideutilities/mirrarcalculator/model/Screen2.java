package com.waysideutilities.mirrarcalculator.model;

public class Screen2
{
    private String ipad="";
    private String ipad_am="";
    private String stand="";
    private String stand_am="";
    private String tv="";
    private String tv_am="";
    private String mac_mini="";
    private String mac_mini_am="";
    private String processed_images="";
    private String processed_images_am="";
    private String amount="";
    private String tax="";
    private String to_be_paid="";

    public Screen2(String ipad,String ipad_am, String stand,String stand_am,
                   String tv,String tv_am, String mac_mini,String mac_mini_am,
                   String processed_images,String processed_images_am,
                   String amount,String tax,String to_be_paid)
    {
        this.ipad = ipad;
        this.ipad_am = ipad_am;
        this.stand = stand;
        this.stand_am = stand_am;
        this.tv = tv;
        this.tv_am = tv_am;
        this.mac_mini = mac_mini;
        this.mac_mini_am = mac_mini_am;
        this.processed_images = processed_images;
        this.processed_images_am = processed_images_am;
        this.amount = amount;
        this.tax = tax;
        this.to_be_paid = to_be_paid;
    }

    public String getIpad() {
        return ipad;
    }

    public String getMac_mini() {
        return mac_mini;
    }

    public String getProcessed_images() {
        return processed_images;
    }

    public String getStand() {
        return stand;
    }

    public String getTv() {
        return tv;
    }

    public String getAmount() {
        return amount;
    }

    public String getIpad_am() {
        return ipad_am;
    }

    public String getMac_mini_am() {
        return mac_mini_am;
    }

    public String getProcessed_images_am() {
        return processed_images_am;
    }

    public String getStand_am() {
        return stand_am;
    }

    public String getTax() {
        return tax;
    }

    public String getTo_be_paid() {
        return to_be_paid;
    }

    public String getTv_am() {
        return tv_am;
    }
}
