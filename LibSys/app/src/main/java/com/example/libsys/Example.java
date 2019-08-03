package com.example.libsys;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("Author")
    @Expose
    private String author;
    @SerializedName("Availablity")
    @Expose
    private Boolean availablity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getAvailablity() {
        return availablity;
    }

    public void setAvailablity(Boolean availablity) {
        this.availablity = availablity;
    }

}