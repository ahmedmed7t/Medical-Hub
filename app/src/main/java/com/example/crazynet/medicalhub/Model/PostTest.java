package com.example.crazynet.medicalhub.Model;

/**
 * Created by Medhat on 29/04/2019.
 */

public class PostTest {

    private String Image ;
    private String name;
    private String date ;
    private String content;
    private Boolean isDoctor;

    public PostTest(String image, String name, String date, String content, Boolean isDoctor) {
        Image = image;
        this.name = name;
        this.date = date;
        this.content = content;
        this.isDoctor = isDoctor;
    }

    public PostTest() {
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDoctor() {
        return isDoctor;
    }

    public void setDoctor(Boolean doctor) {
        isDoctor = doctor;
    }
}
