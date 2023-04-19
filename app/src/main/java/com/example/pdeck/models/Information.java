package com.example.pdeck.models;

public class Information {
    private int id;
    private String collegeName;
    private String companyName;
    private String companytype;
    private Double ctc;
    private String roleOffered;
    private int yearOfVisit;
    private String logo;
    private int noOfRounds;
    private String techStack;
    private String location;
    private String driveType;

    public Information(String roleOffered,int id ,String collegeName, String companyName, String companytype, Double ctc, int yearOfVisit, String logo, int noOfRounds, String techStack, String location, String driveType) {
        this.id = id;
        this.roleOffered = roleOffered;
        this.collegeName = collegeName;
        this.companyName = companyName;
        this.companytype = companytype;
        this.ctc = ctc;
        this.yearOfVisit = yearOfVisit;
        this.logo = logo;
        this.noOfRounds = noOfRounds;
        this.techStack = techStack;
        this.location = location;
        this.driveType = driveType;
    }

    public int getId() {
        return id;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanytype() {
        return companytype;
    }

    public Double getCtc() {
        return ctc;
    }

    public String getRoleOffered() {
        return roleOffered;
    }

    public int getYearOfVisit() {
        return yearOfVisit;
    }

    public String getLogo() {
        return logo;
    }

    public int getNoOfRounds() {
        return noOfRounds;
    }

    public String getTechStack() {
        return techStack;
    }

    public String getLocation() {
        return location;
    }

    public String getDriveType() {
        return driveType;
    }
}
