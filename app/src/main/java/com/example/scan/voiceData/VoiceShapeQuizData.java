package com.example.scan.voiceData;

import com.example.scan.R;
import com.example.scan.quizData.ShapeQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class VoiceShapeQuizData {
    public static HashMap<String, VoiceQuizModel> hashMapQuestion = new HashMap<String, VoiceQuizModel>();
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

    public HashMap<String, VoiceQuizModel> createShapeQuizQuestion(int _imageViewQuestion, String _correctAnswer) {

        hashMapQuestion.put(_correctAnswer, new VoiceQuizModel(_imageViewQuestion, _correctAnswer));

        return hashMapQuestion;
    }
    public void setShapeQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers=  rand.ints(0, SHAPE_QUESTION_NAMES.length).distinct().limit(SHAPE_QUESTION_NAMES.length).toArray();
        createShapeQuizQuestion(R.drawable.quizsquare, "Square");
        createShapeQuizQuestion(R.drawable.quizstar, "Star");
        createShapeQuizQuestion(R.drawable.quizoval, "Oval");
        createShapeQuizQuestion(R.drawable.quizheart, "Heart");
        createShapeQuizQuestion(R.drawable.quiztriangle, "Triangle");
        createShapeQuizQuestion(R.drawable.quizcircle, "Circle");
        createShapeQuizQuestion(R.drawable.quizrectangle, "Rectangle");

        System.out.println(hashMapQuestion.size());
    }
    public VoiceQuizModel getOneShapeQuestion(String keyName){
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
