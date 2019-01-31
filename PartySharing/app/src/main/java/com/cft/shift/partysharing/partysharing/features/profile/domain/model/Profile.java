package com.cft.shift.partysharing.partysharing.features.profile.domain.model;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Profile {
    private String firstName;
    private String lastName;
    private int age;
    private String location;
    private ArrayList<String> interests;
    private Bitmap image;

    public Profile(String firstName, String lastName, int age, String location, ArrayList<String> interests, Bitmap image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.location = location;
        this.interests = interests;
        this.image = image;
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