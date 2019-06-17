package com.example.crazynet.medicalhub.Model;

import java.util.ArrayList;

/**
 * Created by Medhat on 13/06/2019.
 */

public class Patient {

    private String Image;
    private String name;
    private String gender;
    private String address;
    private String age;
    private String n_id;
    private String bio;
    private String hight;
    private String weight;
    private String blood;
    ArrayList<Report> reports;

    public Patient() {
    }

    public Patient(String image ,String name, String gender, String address, String age, String n_id, String bio, String hight, String weight, String blood, ArrayList<Report> reports) {

        this.Image = image;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.n_id = n_id;
        this.bio = bio;
        this.hight = hight;
        this.weight = weight;
        this.blood = blood;
        this.reports = reports;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getN_id() {
        return n_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHight() {
        return hight;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }


}
