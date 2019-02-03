package com.cft.shift.partysharing.partysharing.network.exchange;

import com.cft.shift.partysharing.partysharing.types.InterestType;

import java.io.Serializable;


public class AddEventRequest implements Serializable {
    private String name;
    /**
     * геометка
     */
    private String location;
    /**
     * адрес (город, улица ...)
     */
    private String address;
    private String description;
    private String date;
    private InterestType category;
    /**
     * картинка в base64
     */

    private String image;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCategory(InterestType category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public InterestType getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
}
