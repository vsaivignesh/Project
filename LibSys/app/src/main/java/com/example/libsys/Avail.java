package com.example.libsys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avail {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("bName")
    @Expose
    private String bName;
    @SerializedName("aName")
    @Expose
    private String aName;
    @SerializedName("avail")
    @Expose
    private String avail;
    @SerializedName("StdID")
    @Expose
    private Object stdID;

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getBName() {
        return bName;
    }

    public void setBName(String bName) {
        this.bName = bName;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public Object getStdID() {
        return stdID;
    }

    public void setStdID(Object stdID) {
        this.stdID = stdID;
    }

}