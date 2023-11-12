package com.example.scan.voiceData;

public class VoiceQuizModel {
    private int voiceQuizImage;
    private String voiceQuizCorrectAnswer;

    public VoiceQuizModel(int _voiceQuizImage, String _voiceQuizCorrectAnswer) {
        this.voiceQuizImage = _voiceQuizImage;
        this.voiceQuizCorrectAnswer = _voiceQuizCorrectAnswer;
    }

    public int getVoiceQuizImage() {
        return voiceQuizImage;
    }

    public String getVoiceQuizCorrectAnswer() {
        return voiceQuizCorrectAnswer;
    }
}
