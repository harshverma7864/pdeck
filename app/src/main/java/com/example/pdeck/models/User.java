package com.example.pdeck.models;

public class User {
    private int id;
    private String name;
    private String rollNo;
    private String collegeName;
    private String email;
    private String course;
    private String password;
    private int year;
    private String imgUrl;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rollNo='" + rollNo + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                ", year=" + year +
                '}';
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public String getPassword() {
        return password;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
