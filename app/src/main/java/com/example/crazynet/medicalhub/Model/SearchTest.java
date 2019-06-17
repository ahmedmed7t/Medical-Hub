package com.example.crazynet.medicalhub.Model;

/**
 * Created by CrazyNet on 29/04/2019.
 */

public class SearchTest {

    private String image;
    private String name;
    private float rate;
    private String place;
    private String expertise;
    private String phone;

    public SearchTest() {
    }

    public SearchTest( String phone ,String image, String name, float rate, String place, String expertise) {
        this.image = image;
        this.name = name;
        this.rate = rate;
        this.place = place;
        this.expertise = expertise;
        this.phone = phone;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
