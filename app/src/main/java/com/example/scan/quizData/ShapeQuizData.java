package com.example.scan.quizData;

import com.example.scan.R;

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
            "Rectangle",
    };

    public static Random rand = new Random();
    public static int[] randomNumbers;


    public HashMap<String, ShapeQuestion> createShapeQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer, int _soundQuestion) {

        hashMapQuestion.put(_correctAnswer, new ShapeQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer, _soundQuestion));

        return hashMapQuestion;
    }

    public void setShapeQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers=  rand.ints(0, SHAPE_QUESTION_NAMES.length).distinct().limit(SHAPE_QUESTION_NAMES.length).toArray();
        createShapeQuizQuestion(R.drawable.quiz_chessboard, "Square", 3, R.drawable.choices_rectangle, R.drawable.choices_oval, R.drawable.choices_heart, R.drawable.choices_square, R.raw.square);
        createShapeQuizQuestion(R.drawable.quiz_stars, "Star", 0, R.drawable.choices_star, R.drawable.choices_heart, R.drawable.choices_triangle, R.drawable.choices_rectangle, R.raw.star);
        createShapeQuizQuestion(R.drawable.quiz_eggs, "Oval", 1, R.drawable.choices_square, R.drawable.choices_oval, R.drawable.choices_star, R.drawable.choices_circle, R.raw.oval);
        createShapeQuizQuestion(R.drawable.quiz_chocoheart, "Heart", 3, R.drawable.choices_circle, R.drawable.choices_square, R.drawable.choices_triangle, R.drawable.choices_heart, R.raw.heart);
        createShapeQuizQuestion(R.drawable.quiz_pizza, "Triangle", 1, R.drawable.choices_rectangle, R.drawable.choices_triangle, R.drawable.choices_oval, R.drawable.choices_square, R.raw.triangle);
        createShapeQuizQuestion(R.drawable.quiz_clock, "Circle", 0, R.drawable.choices_circle, R.drawable.choices_star, R.drawable.choices_oval, R.drawable.choices_triangle, R.raw.circle);
        createShapeQuizQuestion(R.drawable.quiz_door, "Rectangle", 2, R.drawable.choices_triangle, R.drawable.choices_heart, R.drawable.choices_rectangle, R.drawable.choices_square, R.raw.rectangle);

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
