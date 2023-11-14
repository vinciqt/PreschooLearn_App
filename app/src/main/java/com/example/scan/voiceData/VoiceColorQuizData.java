package com.example.scan.voiceData;

import com.example.scan.R;
import com.example.scan.quizData.ColorQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class VoiceColorQuizData {
    public static HashMap<String, VoiceQuizModel> hashMapQuestion = new HashMap<String, VoiceQuizModel>();
    public static boolean QUIZ_INITIAL_VISIT = true;
    public static int COLOR_QUESTION_COUNTER = -1;
    public static String[] COLOR_QUESTION_NAMES = {
            "Blue", "Violet", "Red", "Green", "Orange", "Yellow"
    };

    public static Random rand = new Random();
    public static int[] randomNumbers;


    public HashMap<String, VoiceQuizModel> createColorQuizQuestion(int _imageViewQuestion, String _correctAnswer) {

        hashMapQuestion.put(_correctAnswer, new VoiceQuizModel(_imageViewQuestion, _correctAnswer));

        return hashMapQuestion;
    }

    public void setColorQuestion() {
        System.out.println("CHECK RANDOM " + Arrays.toString(randomNumbers));
        randomNumbers = rand.ints(0, COLOR_QUESTION_NAMES.length).distinct().limit(COLOR_QUESTION_NAMES.length).toArray();
        createColorQuizQuestion(R.drawable.quiz_dolphin, "Blue");
        createColorQuizQuestion(R.drawable.quiz_eggplant, "Violet");
        createColorQuizQuestion(R.drawable.quiz_apple, "Red");
        createColorQuizQuestion(R.drawable.quiz_parrot, "Green");
        createColorQuizQuestion(R.drawable.quiz_ball, "Orange");
        createColorQuizQuestion(R.drawable.quiz_banana, "Yellow");

        System.out.println(hashMapQuestion.size());
    }

    public VoiceQuizModel getOneColorQuestion(String keyName){
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
