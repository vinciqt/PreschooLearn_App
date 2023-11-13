package com.example.scan.QuizScore;

public class QuizScoreModel {

    private int quizId;
    private String quizCategory;
    private String quizType;

    private String quizScore;
    private String quizDate;

    private String quizScoreOverallCount;


    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizCategory() {
        return quizCategory;
    }

    public void setQuizCategory(String quizCategory) {
        this.quizCategory = quizCategory;
    }

    public String getQuizType() {
        return quizType;
    }

    public void setQuizType(String quizType) {
        this.quizType = quizType;
    }

    public String getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(String quizScore) {
        this.quizScore = quizScore;
    }

    public String getQuizDate() {
        return quizDate;
    }

    public void setQuizDate(String quizDate) {
        this.quizDate = quizDate;
    }


    public String getQuizScoreOverallCount() {
        return quizScoreOverallCount;
    }

    public void setQuizScoreOverallCount(String quizScoreOverallCount) {
        this.quizScoreOverallCount = quizScoreOverallCount;
    }

    public QuizScoreModel(int _quizId, String _quizCategory, String _quizType, String _quizScore, String _quizDate, String _quizScoreOverallCount){
        this.quizId = _quizId;
        this.quizCategory = _quizCategory;
        this.quizType = _quizType;
        this.quizScore = _quizScore;
        this.quizDate = _quizDate;
        this.quizScoreOverallCount = _quizScoreOverallCount;
    }



}
