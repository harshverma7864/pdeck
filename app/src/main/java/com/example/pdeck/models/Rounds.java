package com.example.pdeck.models;

public class Rounds {
    private int id;
    private int companyId;
    private String roundName;
    private String roundType;
    private int noOfQuestions;
    private int duration;

    public Rounds(int id,int companyId, String roundName, String roundType, int noOfQuestions, int duration) {
        this.id = id;
        this.companyId = companyId;
        this.roundName = roundName;
        this.roundType = roundType;
        this.noOfQuestions = noOfQuestions;
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "Rounds{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", roundName='" + roundName + '\'' +
                ", roundType='" + roundType + '\'' +
                ", noOfQuestions=" + noOfQuestions +
                ", duration=" + duration +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getRoundName() {
        return roundName;
    }

    public String getRoundType() {
        return roundType;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public int getDuration() {
        return duration;
    }
}
