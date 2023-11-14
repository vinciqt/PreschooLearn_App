package com.example.scan.quizData;

public class AlphabetQuestion {
    public int imageViewQuestion;
    public String correctAnswer;
    public int correctAnswerPosition;
    public int otherAnswer1;
    public int otherAnswer2;
    public int otherAnswer3;
    public int corAnswer;
    public int soundQuestion;

    public AlphabetQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer, int _soundQuestion){
        this.imageViewQuestion = _imageViewQuestion;
        this.correctAnswer = _correctAnswer;
        this.correctAnswerPosition = _correctAnswerPosition;
        this.otherAnswer1 = _otherAnswer1;
        this.otherAnswer2 = _otherAnswer2;
        this.otherAnswer3 = _otherAnswer3;
        this.corAnswer = _corAnswer;
        this.soundQuestion = _soundQuestion;
    }

    public int getImageViewQuestion() {
        return imageViewQuestion;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public int getCorrectAnswerPosition() {
        return correctAnswerPosition;
    }
    public int getOtherAnswer1() {
        return otherAnswer1;
    }
    public int getOtherAnswer2() {
        return otherAnswer2;
    }
    public int getOtherAnswer3() {
        return otherAnswer3;
    }
    public int getCorAnswer()  {
        return corAnswer;
    }
    public int getSoundQuestion(){return soundQuestion;}
}
