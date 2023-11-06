package com.example.scan.quizData;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.HashMap;


public class NumberQuizData {

    public static HashMap<String, NumberQuestion> hashMapQuestion = new HashMap<String, NumberQuestion>();
    public static int NUMBER_QUESTION_SIZE = 9;
    public static int NUMBER_QUESTION_COUNTER = -1;
    public static String[] NUMBER_QUESTION_NAMES = {
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
    };


    public HashMap<String, NumberQuestion> createNumberQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer) {

        hashMapQuestion.put(_correctAnswer, new NumberQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer));

        return hashMapQuestion;
    }

    public NumberQuestion getOneQuestion(String keyName) {
        createNumberQuizQuestion(R.drawable.imgsquare, "1", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgstar, "2", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgoval, "3", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgheart, "4", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createNumberQuizQuestion(R.drawable.imgtriangle, "5", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgcircle, "6", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgrectangle, "7", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgsquare, "8", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgstar, "9", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createNumberQuizQuestion(R.drawable.imgoval, "10", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        return hashMapQuestion.get(keyName);
    }

    public int questionCounterNumber(){
        if(NUMBER_QUESTION_COUNTER > NUMBER_QUESTION_NAMES.length){
            return NUMBER_QUESTION_SIZE;
        }
        NUMBER_QUESTION_COUNTER++;
        return NUMBER_QUESTION_COUNTER;
    }

    public static void resetCounter () {
        NUMBER_QUESTION_COUNTER = -1;
    }

}
