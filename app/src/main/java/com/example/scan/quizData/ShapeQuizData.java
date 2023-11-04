package com.example.scan.quizData;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.HashMap;


public class ShapeQuizData {

    public static HashMap<String, ShapeQuestion> hashMapQuestion = new HashMap<String, ShapeQuestion>();
    public static int SHAPE_QUESTION_SIZE = 6;
    public static int SHAPE_QUESTION_COUNTER = -1;
    public static String[] SHAPE_QUESTION_NAMES = {
            "Square",
            "Star",
            "Oval",
            "Heart",
            "Triangle",
            "Circle",
            "Rectangle"
    };


    public HashMap<String, ShapeQuestion> createShapeQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer) {

        hashMapQuestion.put(_correctAnswer, new ShapeQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer));

        return hashMapQuestion;
    }

    public ShapeQuestion getOneQuestion(String keyName) {
        createShapeQuizQuestion(R.drawable.imgsquare, "Square", 3, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createShapeQuizQuestion(R.drawable.imgstar, "Star", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createShapeQuizQuestion(R.drawable.imgoval, "Oval", 1, R.drawable.imgcircle, R.drawable.imgoval, R.drawable.imgoval, R.drawable.imgsquare);
        createShapeQuizQuestion(R.drawable.imgheart, "Heart", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createShapeQuizQuestion(R.drawable.imgtriangle, "Triangle", 1, R.drawable.imgcircle, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgsquare);
        createShapeQuizQuestion(R.drawable.imgcircle, "Circle", 0, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgoval, R.drawable.imgsquare);
        createShapeQuizQuestion(R.drawable.imgrectangle, "Rectangle", 2, R.drawable.imgcircle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);
        return hashMapQuestion.get(keyName);
    }

    public int questionCounter(){
        if(SHAPE_QUESTION_COUNTER > SHAPE_QUESTION_NAMES.length){
            return SHAPE_QUESTION_SIZE;
        }
        SHAPE_QUESTION_COUNTER++;
        return SHAPE_QUESTION_COUNTER;
    }

}
