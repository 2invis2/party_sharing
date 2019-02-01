package com.cft.shift.partysharing.partysharing.features.profile.domain.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Profile {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String location;
    private ArrayList<String> interests;
    private ArrayList<Long> attend;
    private ArrayList<Long> manage;

    private Bitmap image;

    public Long getId() {
        return id;
    }

    public ArrayList<Long> getAttend() {
        return attend;
    }

    public ArrayList<Long> getManage() {
        return manage;
    }

    public Profile(String firstName, String lastName, int age, String location, ArrayList<String> interests, Bitmap image, ArrayList<Long> attend,ArrayList<Long> manage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.interests = (ArrayList<String>)interests.clone();
        this.image = image;
        this.attend = (ArrayList<Long>)attend.clone();
        this.manage = (ArrayList<Long>)manage.clone();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public Bitmap getImage() {
        return image;
    }
}