
package com.example.sercanyusuf.boomsetdemo.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("group")
    @Expose
    private Group group;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("startsat")
    @Expose
    private String startsat;
    @SerializedName("endsat")
    @Expose
    private String endsat;
    @SerializedName("timezone")
    @Expose
    private Integer timezone;
    @SerializedName("premium")
    @Expose
    private Boolean premium;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("modified")
    @Expose
    private String modified;

    public Result(Integer timezone) {
        this.timezone = timezone;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartsat() {
        return startsat;
    }

    public void setStartsat(String startsat) {
        this.startsat = startsat;
    }

    public String getEndsat() {
        return endsat;
    }

    public void setEndsat(String endsat) {
        this.endsat = endsat;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

}
