package com.cft.shift.partysharing.partysharing.features.event.domain.model;

import android.graphics.Bitmap;


import com.cft.shift.partysharing.partysharing.types.InterestType;

import java.util.List;

public class Event {
    private String name;
    private String location;
    private String adress;
    private String date;
    private InterestType category;
    private Long creator;
    private List<Long> attend;
    private Bitmap image;

    public Event(String name, String location, String adress, String date, InterestType category, Long creator, List<Long> attend, Bitmap image) {
        this.name = name;
        this.location = location;
        this.adress = adress;
        this.date = date;
        this.category = category;
        this.creator = creator;
        this.attend = attend;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAdress() {
        return adress;
    }

    public String getDate() {
        return date;
    }

    public InterestType getCategory() {
        return category;
    }

    public Long getCreator() {
        return creator;
    }

    public List<Long> getAttend() {
        return attend;
    }

    public Bitmap getImage() {
        return image;
    }
}
