package com.example.pdeck.models;

public class RoundInfo {
    private int sno;
    private int roundId;
    private String question;
    private String answer;
    private String postedBy;
    private String postedOn;
    private String difficulty;

    public RoundInfo(int sno, int roundId, String question, String answer, String difficulty,String postedBy, String postedOn) {
        this.sno = sno;
        this.roundId = roundId;
        this.question = question;
        this.answer = answer;
        this.postedBy = postedBy;
        this.postedOn = postedOn;
        this.difficulty = difficulty;
    }


    public int getSno() {
        return sno;
    }

    public int getRoundId() {
        return roundId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public String getPostedOn() {
        return postedOn;
    }

    public String getDifficulty() {
        return difficulty;
    }
}
