package com.cft.shift.partysharing.partysharing.features.event.domain.model;
import java.util.ArrayList;

public class Event {
    private String name;
    private String location;
    private String adress;
    private String date;
    private String category;
    private Long creator;
    private ArrayList<Long> attend;
    private String image;

    public Event(String name, String location, String adress,String date, String category,Long creator,ArrayList<Long> attend, String image) {
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

    public String getCategory() {
        return category;
    }

    public Long getCreator() {
        return creator;
    }

    public ArrayList<Long> getAttend() {
        return attend;
    }

    public String getImage() {
        return image;
    }
}
