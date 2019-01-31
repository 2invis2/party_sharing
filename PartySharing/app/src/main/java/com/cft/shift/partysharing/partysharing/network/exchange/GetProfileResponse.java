package com.cft.shift.partysharing.partysharing.network.exchange;

import java.io.Serializable;
import java.util.List;


public class GetProfileResponse implements Serializable {
    /**
     * имя
     */
    private String firstName;
    /**
     * фамилия
     */
    private String lastName;
    /**
     * возраст
     */
    private int age;
    /**
     * город
     */
    private String location;
    /**
     * интересы
     */
    private String interests;
    /**
     * мероприятия, в которых участвует
     */
    private List<Long> attend;
    /**
     * картинка в base64
     */
    private String image;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setAttend(List<Long> attend) {
        this.attend = attend;
    }

    public void setImage(String image) {
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

    public String getInterests() {
        return interests;
    }

    public List<Long> getAttend() {
        return attend;
    }

    public String getImage() {
        return image;
    }
}
