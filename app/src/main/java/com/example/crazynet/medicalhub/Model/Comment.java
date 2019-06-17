package com.example.crazynet.medicalhub.Model;

/**
 * Created by Medhat on 17/06/2019.
 */

public class Comment {

    private String content ;
    private String auther ;
    private String image ;
    private String date;
    private String community_id ;
    private String post_id;

    public Comment() {
    }

    public Comment(String content, String auther, String image, String date, String community_id, String post_id) {
        this.content = content;
        this.auther = auther;
        this.image = image;
        this.date = date;
        this.community_id = community_id;
        this.post_id = post_id;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
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

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
