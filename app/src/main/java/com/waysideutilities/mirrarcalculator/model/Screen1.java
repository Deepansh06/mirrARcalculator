package com.waysideutilities.mirrarcalculator.model;

public class Screen1
{
    private String ipad="";
    private String stand="";
    private String tv="";
    private String mac_mini="";
    private String processed_images="";

    public Screen1(String ipad, String stand, String tv, String mac_mini, String processed_images)
    {
        this.ipad = ipad;
        this.stand = stand;
        this.tv = tv;
        this.mac_mini = mac_mini;
        this.processed_images = processed_images;
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
}
