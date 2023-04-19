package com.example.pdeck.models;

public class CollegeInfo {
    private int sno;
    private String collegeName;
    private String location;
    private String imgUrl;


    public CollegeInfo(int sno, String collegeName, String location) {
        this.sno = sno;
        this.collegeName = collegeName;
        this.location = location;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getSno() {
        return sno;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getLocation() {
        return location;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
