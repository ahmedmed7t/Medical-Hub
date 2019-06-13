package com.example.crazynet.medicalhub.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by Medhat on 12/06/2019.
 */

public class Developers {

    private Drawable Image;
    private String Name;
    private String job;

    public Drawable getImage() {
        return Image;
    }

    public void setImage(Drawable image) {
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

    public Developers(Drawable image, String name, String job) {

        Image = image;
        Name = name;
        this.job = job;
    }
}
