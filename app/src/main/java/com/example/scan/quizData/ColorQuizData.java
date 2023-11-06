package com.example.scan.quizData;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.HashMap;


public class ColorQuizData {

    public static HashMap<String, ColorQuestion> hashMapQuestion = new HashMap<String, ColorQuestion>();
    public static int COLOR_QUESTION_SIZE = 5;
    public static int COLOR_QUESTION_COUNTER = -1;
    public static String[] COLOR_QUESTION_NAMES = {
            "Blue",
            "Violet",
            "Red",
            "Green",
            "Orange",
            "Yellow"
    };


    public HashMap<String, ColorQuestion> createColorQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer) {

        hashMapQuestion.put(_correctAnswer, new ColorQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer));

        return hashMapQuestion;
    }

    public ColorQuestion getOneQuestion(String keyName) {
        createColorQuizQuestion(R.drawable.imgsquare, "Blue", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createColorQuizQuestion(R.drawable.imgstar, "Violet", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createColorQuizQuestion(R.drawable.imgoval, "Red", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createColorQuizQuestion(R.drawable.imgheart, "Green", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createColorQuizQuestion(R.drawable.imgtriangle, "Orange", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createColorQuizQuestion(R.drawable.imgcircle, "Yellow", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        return hashMapQuestion.get(keyName);
    }

    public int questionCounterColor(){
        if(COLOR_QUESTION_COUNTER > COLOR_QUESTION_NAMES.length){
            return COLOR_QUESTION_SIZE;
        }
        COLOR_QUESTION_COUNTER++;
        return COLOR_QUESTION_COUNTER;
    }
    public static void resetCounter () {
        COLOR_QUESTION_COUNTER = -1;
    }

}