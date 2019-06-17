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
    private int likes;
    private String comm;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public PostTest(String image, String name, String date, String content, Boolean isDoctor, int likes) {
        Image = image;
        this.name = name;
        this.date = date;
        this.content = content;
        this.isDoctor = isDoctor;
        this.likes = likes;
    }

    public PostTest() {
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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
