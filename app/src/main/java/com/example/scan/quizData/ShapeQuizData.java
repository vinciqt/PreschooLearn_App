package com.example.scan.quizData;

import android.graphics.drawable.shapes.Shape;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class ShapeQuizData {

    public static HashMap<String, ShapeQuestion> hashMapQuestion = new HashMap<String, ShapeQuestion>();
    public static int SHAPE_QUESTION_SIZE = 6;
    public static boolean QUIZ_INITIAL_VISIT = true;
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

    public static Random rand = new Random();
    public static int[] randomNumbers;


    public HashMap<String, ShapeQuestion> createShapeQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer) {

        hashMapQuestion.put(_correctAnswer, new ShapeQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer));

        return hashMapQuestion;
    }

    public void setShapeQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers=  rand.ints(0, SHAPE_QUESTION_NAMES.length).distinct().limit(SHAPE_QUESTION_NAMES.length).toArray();
        createShapeQuizQuestion(R.drawable.quizsquare, "Square", 3, R.drawable.imgrectangle, R.drawable.imgoval, R.drawable.imgheart, R.drawable.imgsquare);
        createShapeQuizQuestion(R.drawable.quizstar, "Star", 0, R.drawable.imgstar, R.drawable.imgheart, R.drawable.imgtriangle, R.drawable.imgrectangle);
        createShapeQuizQuestion(R.drawable.quizoval, "Oval", 1, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgstar, R.drawable.imgcircle);
        createShapeQuizQuestion(R.drawable.quizheart, "Heart", 3, R.drawable.imgcircle, R.drawable.imgsquare, R.drawable.imgoval, R.drawable.imgheart);
        createShapeQuizQuestion(R.drawable.quiztriangle, "Triangle", 1, R.drawable.imgrectangle, R.drawable.imgtriangle, R.drawable.imgoval, R.drawable.imgsquare);
        createShapeQuizQuestion(R.drawable.quizcircle, "Circle", 0, R.drawable.imgcircle, R.drawable.imgstar, R.drawable.imgoval, R.drawable.imgtriangle);
        createShapeQuizQuestion(R.drawable.quizdoor, "Rectangle", 2, R.drawable.imgtriangle, R.drawable.imgheart, R.drawable.imgrectangle, R.drawable.imgsquare);

        System.out.println(hashMapQuestion.size());
    }

    public ShapeQuestion getOneShapeQuestion(String keyName){
        return hashMapQuestion.get(keyName);

    }

    public int questionCounterShape(){
        if(SHAPE_QUESTION_COUNTER >= SHAPE_QUESTION_NAMES.length){
            return SHAPE_QUESTION_NAMES.length;
        }
        SHAPE_QUESTION_COUNTER++;
        return randomNumbers[SHAPE_QUESTION_COUNTER];
    }

    public static void resetCounter () {
        SHAPE_QUESTION_COUNTER = -1;
        QUIZ_INITIAL_VISIT = true;
    }


}
