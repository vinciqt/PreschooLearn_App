package com.example.scan.quizData;

import android.graphics.Color;

import com.example.scan.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;


public class ColorQuizData {

    public static HashMap<String, ColorQuestion> hashMapQuestion = new HashMap<String, ColorQuestion>();
    public static int COLOR_QUESTION_SIZE = 5;
    public static boolean QUIZ_INITIAL_VISIT = true;
    public static int COLOR_QUESTION_COUNTER = -1;
    public static String[] COLOR_QUESTION_NAMES = {
            "Blue", "Violet", "Red", "Green", "Orange", "Yellow"
    };

    public static Random rand = new Random();
    public static int[] randomNumbers;


    public HashMap<String, ColorQuestion> createColorQuizQuestion(int _imageViewQuestion, String _correctAnswer, int _correctAnswerPosition, int _otherAnswer1, int _otherAnswer2, int _otherAnswer3, int _corAnswer, int _soundQuestion) {

        hashMapQuestion.put(_correctAnswer, new ColorQuestion(_imageViewQuestion, _correctAnswer, _correctAnswerPosition, _otherAnswer1, _otherAnswer2, _otherAnswer3, _corAnswer, _soundQuestion));

        return hashMapQuestion;
    }

    public void setColorQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers = rand.ints(0, COLOR_QUESTION_NAMES.length).distinct().limit(COLOR_QUESTION_NAMES.length).toArray();
        createColorQuizQuestion(R.drawable.quiz_dolphin, "Blue", 3, R.drawable.red, R.drawable.violet, R.drawable.green, R.drawable.blue, R.raw.blue);
        createColorQuizQuestion(R.drawable.quiz_eggplant, "Violet", 0, R.drawable.violet, R.drawable.yellow, R.drawable.orange, R.drawable.green, R.raw.violet);
        createColorQuizQuestion(R.drawable.quiz_apple, "Red", 1, R.drawable.blue, R.drawable.red, R.drawable.orange, R.drawable.yellow, R.raw.red);
        createColorQuizQuestion(R.drawable.quiz_parrot, "Green", 3, R.drawable.red, R.drawable.blue, R.drawable.violet, R.drawable.green, R.raw.green);
        createColorQuizQuestion(R.drawable.quiz_ball, "Orange", 1, R.drawable.blue, R.drawable.orange, R.drawable.green, R.drawable.red, R.raw.orange);
        createColorQuizQuestion(R.drawable.quiz_banana, "Yellow", 0, R.drawable.yellow, R.drawable.blue, R.drawable.orange, R.drawable.red, R.raw.yellow);

        System.out.println(hashMapQuestion.size());
    }

    public ColorQuestion getOneColorQuestion(String keyName){
        return hashMapQuestion.get(keyName);
    }

    public int questionCounterColor(){
        if(COLOR_QUESTION_COUNTER > COLOR_QUESTION_NAMES.length){
            return COLOR_QUESTION_NAMES.length;
        }
        COLOR_QUESTION_COUNTER++;
        return randomNumbers[COLOR_QUESTION_COUNTER];
    }
    public static void resetCounter () {
        COLOR_QUESTION_COUNTER = -1;
        QUIZ_INITIAL_VISIT = true;
    }

}