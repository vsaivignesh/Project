package com.example.libsys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ret {

    @SerializedName("ID")
    @Expose
    private String iD;
    @SerializedName("bName")
    @Expose
    private String bName;
    @SerializedName("aName")
    @Expose
    private String aName;
    @SerializedName("Due")
    @Expose
    private String due;
    @SerializedName("StdID")
    @Expose
    private String stdID;

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

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getStdID() {
        return stdID;
    }

    public void setStdID(String stdID) {
        this.stdID = stdID;
    }
}