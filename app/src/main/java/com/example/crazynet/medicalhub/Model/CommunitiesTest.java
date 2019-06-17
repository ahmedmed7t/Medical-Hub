package com.example.crazynet.medicalhub.Model;

/**
 * Created by Medhat on 16/04/2019.
 */

public class CommunitiesTest {

    private int id;
    private String img;
    private String name;
    private String descreption;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommunitiesTest(String img, String name, String desc) {

        this.img = img;
        this.name = name;
        this.descreption = desc;
    }
}
