package com.example.crazynet.medicalhub.Model;

/**
 * Created by CrazyNet on 16/04/2019.
 */

public class CommunitiesTest {

    private String img;
    private String name;

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

    public CommunitiesTest(String img, String name) {

        this.img = img;
        this.name = name;
    }
}
