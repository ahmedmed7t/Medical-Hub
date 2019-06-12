package com.example.crazynet.medicalhub.Model;

/**
 * Created by Medhat on 12/06/2019.
 */

public class Developers {

    private String Image;
    private String Name;
    private String job;

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Developers() {

    }

    public Developers(String image, String name, String job) {

        Image = image;
        Name = name;
        this.job = job;
    }
}
