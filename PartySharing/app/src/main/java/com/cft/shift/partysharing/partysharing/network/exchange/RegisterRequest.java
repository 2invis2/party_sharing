package com.cft.shift.partysharing.partysharing.network.exchange;


import java.io.Serializable;
public class RegisterRequest implements Serializable {

    /**
     * Имя
     */
    private String firstName;

    /**
     * Фамилия
     */
    private String lastName;

    /**
     * Возрат
     */
    private Integer age;
    /**
     * город
     */
    private String location;

    /**
     * Интересы
     */
    private String interests;

    /**
     * Превью аватарки пользователя
     */
    private String image;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getInterests() {
        return interests;
    }

    public String getImage() {
        return image;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
