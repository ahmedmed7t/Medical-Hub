package com.example.crazynet.medicalhub.Model;

/**
 * Created by Medhat on 12/06/2019.
 */

public class Reminder {

    private String name;
    private String date;

    public Reminder(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public Reminder() {
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
}
