
package com.example.sercanyusuf.boomsetdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Entity(tableName = "group")
public class Group {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("website")
    @Expose
    private Object website;
    @SerializedName("fbpage")
    @Expose
    private Object fbpage;
    @SerializedName("twitter")
    @Expose
    private Object twitter;
    @SerializedName("googleplus")
    @Expose
    private Object googleplus;

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

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Object getWebsite() {
        return website;
    }

    public void setWebsite(Object website) {
        this.website = website;
    }

    public Object getFbpage() {
        return fbpage;
    }

    public void setFbpage(Object fbpage) {
        this.fbpage = fbpage;
    }

    public Object getTwitter() {
        return twitter;
    }

    public void setTwitter(Object twitter) {
        this.twitter = twitter;
    }

    public Object getGoogleplus() {
        return googleplus;
    }

    public void setGoogleplus(Object googleplus) {
        this.googleplus = googleplus;
    }

}
